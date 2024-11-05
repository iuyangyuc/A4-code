import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        GameStateMachine gameStateMachine = new GameStateMachine();
        GameUtlity gameUtlity = new GameUtlity();
        HeroFactory heroFactory = new WarriorFactory();
        HeroFactory heroFactory1 = new SorcererFactory();
        HeroFactory heroFactory2 = new PaladinFactory();
        HeroRegistry heroRegistry = HeroRegistry.getInstance();
        Board board = Board.getInstance();

        gameUtlity.InitializeGame();
        board.displayBoard();

        gameStateMachine.startExploring();


        System.out.println("Hero Registry:");
        for(HashMap.Entry<String, Hero> entry : heroRegistry.getHeroMap().entrySet()){
            System.out.println(entry.getValue());
        }

        gameStateMachine.enterShop();

    }
}