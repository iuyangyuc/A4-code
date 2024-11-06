public class Play {

    GameUtlity gameUtlity = new GameUtlity();

    public void startGame() {
        System.out.println("Welcome to the game!");
        System.out.println("Input difficulty level(0 for default difficult, 10 for max difficult): ");
        Main.difficulty = gameUtlity.takeValidInput(0, 10);
        GameStateMachine gameStateMachine = new GameStateMachine();
        gameStateMachine.startExploring();
        gameStateMachine.Moving();
    }
}
