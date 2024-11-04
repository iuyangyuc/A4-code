import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Board {


    private final UnitEvent[] CELL_TYPES = {UnitEvent.EMPTY, UnitEvent.MARKET, UnitEvent.BLOCK};
    private final int[] CELLS_TO_PLACE = {32, 19, 13};
    private int size = 8;
    private HashMap<UnitKey, Unit> board = new HashMap<>();

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

}
