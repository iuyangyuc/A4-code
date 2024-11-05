public class GameStateMachine {

    private GameState currentState;
    private GameUtlity gameUtlity = new GameUtlity();
    private String heroChoice;
    private int heroNumber;
    HeroRegistry heroRegistry = HeroRegistry.getInstance();

    public GameStateMachine() {
        this.currentState = GameState.IDLE;
    }

    public GameState getCurrentState() {
        return currentState;
    }


    /*
    1. initialize game
    2. create hero list
     */
    public void startExploring() {
        if (currentState == GameState.IDLE) {
            currentState = GameState.MOVE;
            gameUtlity.InitializeGame();
            System.out.println("Welcome to the game.");
            System.out.println("Enter number of heroes you want to create:");
            heroNumber = gameUtlity.takeValidInput(1, 3);
            gameUtlity.createHeroParty(heroNumber);
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
            System.out.println("Welcome to Shop.");
            Market market = new Market();
            market.createRandomMarket();
            heroChoice = gameUtlity.selectHero();
            while (true) {
                System.out.println("1. Buy Item");
                System.out.println("2. Sell Item");
                System.out.println("3. Exit Shop");
                int choice = gameUtlity.takeValidInput(1, 3);
                if (choice == 1) {
                    if (market.getMarket().isEmpty()) {
                        System.out.println("No items to buy.");
                        continue;
                    }
                    System.out.println("Enter the item name you want to buy:");
                    market.displayMarket();
                    String item_name = Main.SCANNER.next();
                    while (!market.getMarket().containsKey(item_name)) {
                        System.out.println("Invalid item name. Please enter a valid item name:");
                        item_name = Main.SCANNER.next();
                    }
                    if(heroRegistry.getHero(heroChoice).getGold() < market.getItemCost(item_name)){
                        System.out.println("Not enough gold to buy the item.");
                        continue;
                    }
                    market.sellItem(item_name, heroChoice);
                    market.displayMarket();
                } else if (choice == 2) {
                    if(heroRegistry.getHero(heroChoice).getInventory().isEmpty()){
                        System.out.println("No items to sell.");
                        continue;
                    }
                    System.out.println("Enter the item name you want to sell:");
                    gameUtlity.displayInventory(heroChoice);
                    String item_name = Main.SCANNER.next();
                    while (!heroRegistry.getHero(heroChoice).getInventory().containsKey(item_name)) {
                        System.out.println("Invalid item name. Please enter a valid item name:");
                        item_name = Main.SCANNER.next();
                    }
                    market.buyItem(item_name, heroChoice);
                    market.displayMarket();
                } else {
                    break;
                }
            }
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
            currentState = GameState.MOVE;
            System.out.println("Transitioned to IDLE: Player exits the shop.");
        } else {
            System.out.println("Invalid action: Can only exit shop from SHOP state.");
        }
    }

    public void setCurrentState(GameState currentState) {
        this.currentState = currentState;
    }
}

