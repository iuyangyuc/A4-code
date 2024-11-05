import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Board {

    private final UnitEvent[] CELL_TYPES = {UnitEvent.EMPTY, UnitEvent.MARKET, UnitEvent.BLOCK};
    private final int[] CELLS_TO_PLACE = {32, 19, 13};
    private int size = 8;
    private HashMap<UnitKey, Unit> board = new HashMap<>();
    private UnitKey startingPoint = new UnitKey(0, 0);
    private static Board instance;

    private Board() {}

    public static Board getInstance() {
        if (instance == null) {
            instance = new Board();
        }
        return instance;
    }

    public void setBoard(int size) {
        Random random = new Random();
        Set<String> usedCoordinates = new HashSet<>();

        for (int i = 0; i < CELL_TYPES.length; i++) {
            UnitEvent cellType = CELL_TYPES[i];
            int cellsToPlace = CELLS_TO_PLACE[i];

            for (int count = 0; count < cellsToPlace; count++) {
                int x, y;
                String coord;

                do {
                    x = random.nextInt(size);
                    y = random.nextInt(size);
                    coord = x + "," + y;
                } while (usedCoordinates.contains(coord));

                // Mark the cell as used and place the cell type
                usedCoordinates.add(coord);
                Unit unit = new Unit(cellType, x, y);  // Assuming Unit can store a cell type
                board.put(new UnitKey(x, y), unit);
            }
        }
    }

    public void improvedSetBoard(int size){
        UnitKey key = new UnitKey(0, 1);
        UnitKey key2 = new UnitKey(1, 0);
        boolean recreate = true;
        while(recreate){
            setBoard(size);
            if(board.get(key).getType() == UnitEvent.EMPTY &&
                    board.get(key2).getType() == UnitEvent.EMPTY &&
                    board.get(startingPoint).getType() == UnitEvent.EMPTY){
                recreate = false;
            } else {
                board.clear();
            }
        }
    }

    public void displayBoard() {
        System.out.println("------------------------------------------------");
        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                UnitKey key = new UnitKey(i, j);
                if(board.containsKey(key)) {
                    System.out.print("| " + board.get(key).getSymbol()+ " | ");
                } else {
                    System.out.print(' ');
                }
            }
            System.out.println();
            System.out.print("------------------------------------------------");
            System.out.println();
        }
    }

    public HashMap<UnitKey, Unit> getBoard() {
        return board;
    }

}
