public class GameStateMachine {

    private GameState currentState;

    public GameStateMachine() {
        this.currentState = GameState.IDLE;
    }

    public GameState getCurrentState() {
        return currentState;
    }


    public void startExploring() {
        if (currentState == GameState.IDLE) {
            currentState = GameState.MOVE;
            System.out.println("Transitioned to MOVE: Player starts exploring.");
        } else {
            System.out.println("Invalid action: Can only start exploring from IDLE state.");
        }
    }

    public void stopMoving() {
        if (currentState == GameState.MOVE) {
            currentState = GameState.IDLE;
            System.out.println("Transitioned to IDLE: Player stops moving.");
        } else {
            System.out.println("Invalid action: Can only stop moving from MOVE state.");
        }
    }

    public void encounterEnemy() {
        if (currentState == GameState.MOVE) {
            currentState = GameState.BATTLE;
            System.out.println("Transitioned to BATTLE: Player encounters an enemy.");
        } else {
            System.out.println("Invalid action: Can only encounter enemy from MOVE state.");
        }
    }

    public void enterShop() {
        if (currentState == GameState.MOVE) {
            currentState = GameState.SHOP;
            System.out.println("Transitioned to SHOP: Player enters a shop.");
        } else {
            System.out.println("Invalid action: Can only enter shop from MOVE state.");
        }
    }

    public void winOrFleeBattle() {
        if (currentState == GameState.BATTLE) {
            currentState = GameState.IDLE;
            System.out.println("Transitioned to IDLE: Player wins the battle or flees.");
        } else {
            System.out.println("Invalid action: Can only win or flee battle from BATTLE state.");
        }
    }

    public void exitShop() {
        if (currentState == GameState.SHOP) {
            currentState = GameState.IDLE;
            System.out.println("Transitioned to IDLE: Player exits the shop.");
        } else {
            System.out.println("Invalid action: Can only exit shop from SHOP state.");
        }
    }
}

