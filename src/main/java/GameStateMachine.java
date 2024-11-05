import java.util.Random;

import static java.lang.System.exit;

public class GameStateMachine {

    private GameState currentState;
    private GameUtlity gameUtlity = new GameUtlity();
    BattleUtlity battleUtlity = new BattleUtlity();
    private String heroChoice;
    private int heroNumber;
    HeroRegistry heroRegistry = HeroRegistry.getInstance();
    MonsterRegistry monsterRegistry = MonsterRegistry.getInstance();

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
            gameUtlity.InitializeGame();
            System.out.println("Welcome to the game.");
            System.out.println("Enter number of heroes you want to create:");
            heroNumber = gameUtlity.takeValidInput(1, 3);
            gameUtlity.createHeroParty(heroNumber);
        } else {
            System.out.println("Invalid action: Can only start exploring from IDLE state.");
        }
    }

    public void Moving() {
        if (currentState == GameState.IDLE) {
            currentState = GameState.MOVE;
            //TODO: move logic
            Board board = Board.getInstance();
            int x = 0;
            int y = 0;
            Board.getInstance().getBoard().get(new UnitKey(x, y)).setCurrent(true);
            System.out.println("X: Blocked Unit; M: Market Unit");
            board.displayBoard();
            while (true){
                System.out.println("Enter the action you want to take:");
                System.out.println("1. Up(W)");
                System.out.println("2. Down(S)");
                System.out.println("3. Left(A)");
                System.out.println("4. Right(D)");
                System.out.println("5. Quit Game(Q)");
                System.out.println("6. Display Hero Info(I)");
                String action = Main.SCANNER.next().toLowerCase();
                switch (action){
                    case "w":
                        if(isInBoard(x - 1, y)){
                            if (board.getBoard().get(new UnitKey(x - 1, y)).getType() == UnitEvent.EMPTY) {
                                Random random = new Random();
                                int randomNum = random.nextInt(10);
                                if (randomNum <= 4) {
                                    System.out.println("Encounter enemies.");
                                    //encounterEnemy();
                                }
                                System.out.println("Moved up.");
                            }
                            else if (board.getBoard().get(new UnitKey(x - 1, y)).getType() == UnitEvent.MARKET) {
                                    //enterShop();
                                    System.out.println("Enter the shop.");
                            }
                            else if (board.getBoard().get(new UnitKey(x - 1, y)).getType() == UnitEvent.BLOCK) {
                                    System.out.println("Cannot move up. Blocked unit.");
                                    board.displayBoard();
                                    break;
                            }
                            Board.getInstance().getBoard().get(new UnitKey(x, y)).setCurrent(false);
                            x--;
                            Board.getInstance().getBoard().get(new UnitKey(x, y)).setCurrent(true);
                        }
                        else{
                            System.out.println("Invalid move. Please try again.");
                        }
                        board.displayBoard();
                        break;

                    case "s":
                        if(isInBoard(x + 1, y)){
                            if (board.getBoard().get(new UnitKey(x + 1, y)).getType() == UnitEvent.EMPTY) {
                                Random random = new Random();
                                int randomNum = random.nextInt(10);
                                if (randomNum <= 4) {
                                    System.out.println("Encounter enemies.");
                                    //encounterEnemy();
                                }
                                System.out.println("Moved down.");

                            }
                            else if (board.getBoard().get(new UnitKey(x + 1, y)).getType() == UnitEvent.MARKET) {
                                System.out.println("Enter the shop.");
                                //enterShop();
                            }
                            else if (board.getBoard().get(new UnitKey(x + 1, y)).getType() == UnitEvent.BLOCK) {
                                System.out.println("Cannot move down. Blocked unit.");
                                board.displayBoard();
                                break;
                            }
                            Board.getInstance().getBoard().get(new UnitKey(x, y)).setCurrent(false);
                            x++;
                            Board.getInstance().getBoard().get(new UnitKey(x, y)).setCurrent(true);
                        }
                        else{
                            System.out.println("Invalid move. Please try again.");
                        }
                        board.displayBoard();
                        break;

                    case "a":
                        if(isInBoard(x, y - 1)){
                            if (board.getBoard().get(new UnitKey(x, y - 1)).getType() == UnitEvent.EMPTY) {
                                Random random = new Random();
                                int randomNum = random.nextInt(10);
                                if (randomNum <= 4) {
                                    System.out.println("Encounter enemies.");
                                    //encounterEnemy();
                                }
                                System.out.println("Moved left.");
                            }
                            else if (board.getBoard().get(new UnitKey(x, y - 1)).getType() == UnitEvent.MARKET) {
                                System.out.println("Enter the shop.");
                                //enterShop();
                            }
                            else if (board.getBoard().get(new UnitKey(x, y - 1)).getType() == UnitEvent.BLOCK) {
                                System.out.println("Cannot move left. Blocked unit.");
                                board.displayBoard();
                                break;
                            }
                            Board.getInstance().getBoard().get(new UnitKey(x, y)).setCurrent(false);
                            y--;
                            Board.getInstance().getBoard().get(new UnitKey(x, y)).setCurrent(true);
                        }
                        else{
                            System.out.println("Invalid move. Please try again.");
                        }
                        board.displayBoard();
                        break;

                    case "d":
                        if(isInBoard(x, y + 1)){
                            if (board.getBoard().get(new UnitKey(x, y + 1)).getType() == UnitEvent.EMPTY) {
                                Random random = new Random();
                                int randomNum = random.nextInt(10);
                                if (randomNum <= 4) {
                                    System.out.println("Encounter enemies.");
                                    //encounterEnemy();
                                }
                                System.out.println("Moved right.");
                            }
                            else if (board.getBoard().get(new UnitKey(x, y + 1)).getType() == UnitEvent.MARKET) {
                                System.out.println("Enter the shop.");
                                //enterShop();
                            }
                            else if (board.getBoard().get(new UnitKey(x, y + 1)).getType() == UnitEvent.BLOCK) {
                                System.out.println("Cannot move right. Blocked unit.");
                                board.displayBoard();
                                break;
                            }
                            Board.getInstance().getBoard().get(new UnitKey(x, y)).setCurrent(false);
                            y++;
                            Board.getInstance().getBoard().get(new UnitKey(x, y)).setCurrent(true);
                        }
                        else{
                            System.out.println("Invalid move. Please try again.");
                        }
                        board.displayBoard();
                        break;

                    case "q":
                        System.out.println("Quitting game.");
                        exit(0);
                        break;

                    case "i":
                        gameUtlity.displayAllHeroInfo();
                        break;
                }
            }

        } else {
            System.out.println("Invalid action: Can only stop moving from MOVE state.");
        }
    }

    public void encounterEnemy() {
        if (currentState == GameState.MOVE) {
            currentState = GameState.BATTLE;
            System.out.println("Encounter enemies.");
            gameUtlity.createMonsterParty(heroRegistry.getHeroMap().size(), 0);
            boolean isBattleOver = false;
            int turn = 0;
            while (!isBattleOver) {
                if(turn % 2 == 0){
                    System.out.println("Monsters in the party:");
                    gameUtlity.displayAllMonsterInfo();
                    System.out.println("Heroes in the party:");
                    gameUtlity.displayAllHeroInfo();
                    System.out.println("Select a hero to attack:");
                    heroChoice = gameUtlity.selectHero();
                    System.out.println("Select a monster to attack:");
                    String monsterChoice = gameUtlity.selectMonster();
                    System.out.println("Select an action:");
                    System.out.println("1. Attack");
                    System.out.println("2. Use Spell");
                    System.out.println("3. Use Potion");
                    System.out.println("4. Equip Item");
                    System.out.println("5. Unequip Item");
                    System.out.println("6. Display hero info");
                    int action = gameUtlity.takeValidInput(1, 6);
                    switch (action) {
                        case 1:
                            boolean b = battleUtlity.heroAttack(heroRegistry.getHero(heroChoice), monsterRegistry.getMonster(monsterChoice));
                            if (b) System.out.println("Attacked.");
                            else System.out.println("Missed.");
                            break;
                        case 2:
                            System.out.println("Select a spell to use:");
                            gameUtlity.displayInventory(heroChoice);
                            String spellChoice = Main.SCANNER.next();
                            while (!heroRegistry.getHero(heroChoice).getInventory().containsKey(spellChoice)
                                    && !(heroRegistry.getHero(heroChoice).getInventory().get(spellChoice) instanceof Spell)) {
                                System.out.println("Invalid spell name. Please enter a valid spell name:");
                                spellChoice = Main.SCANNER.next();
                            }
                            battleUtlity.useSpell(heroRegistry.getHero(heroChoice), spellChoice, monsterRegistry.getMonster(monsterChoice));
                            break;
                        case 3:
                            System.out.println("Select a potion to use:");
                            gameUtlity.displayInventory(heroChoice);
                            String potionChoice = Main.SCANNER.next();
                            while (!heroRegistry.getHero(heroChoice).getInventory().containsKey(potionChoice)
                                    && !(heroRegistry.getHero(heroChoice).getInventory().get(potionChoice) instanceof Potion)) {
                                System.out.println("Invalid potion name. Please enter a valid potion name:");
                                potionChoice = Main.SCANNER.next();
                            }
                            battleUtlity.usePotion(heroRegistry.getHero(heroChoice), potionChoice);
                            break;
                        case 4:
                            System.out.println("Select an item to equip:");
                            gameUtlity.displayInventory(heroChoice);
                            String itemChoice = Main.SCANNER.next();
                            while (!heroRegistry.getHero(heroChoice).getInventory().containsKey(itemChoice)
                                    && (!(heroRegistry.getHero(heroChoice).getInventory().get(itemChoice) instanceof Armor)
                                    || !(heroRegistry.getHero(heroChoice).getInventory().get(itemChoice) instanceof Weapon))) {
                                System.out.println("Invalid item name. Please enter a valid item name:");
                                itemChoice = Main.SCANNER.next();
                            }
                            if (heroRegistry.getHero(heroChoice).getInventory().get(itemChoice) instanceof Armor) {
                                battleUtlity.equipArmor(heroRegistry.getHero(heroChoice), itemChoice);
                            }
                            else {
                                int hand = gameUtlity.takeValidInput(1, 2);
                                //TODO
                                battleUtlity.equipWeapon(heroRegistry.getHero(heroChoice), itemChoice, hand);
                            }
                            break;
                        case 5:
                            System.out.println("Select an item to unequip:");
                            gameUtlity.displayEquippedItems(heroChoice);
                            String itemChoice2 = Main.SCANNER.next();
                            while (!heroRegistry.getHero(heroChoice).getEquipped().containsKey(itemChoice2)) {
                                System.out.println("Invalid item name. Please enter a valid item name:");
                                itemChoice2 = Main.SCANNER.next();
                            }
                            if (heroRegistry.getHero(heroChoice).getEquipped().get(itemChoice2) instanceof Armor) {
                                battleUtlity.unEquipArmor(heroRegistry.getHero(heroChoice), itemChoice2);
                            }
                            else {
                                int hand2 = gameUtlity.takeValidInput(1, 2);
                                //TODO
                                battleUtlity.unEquipWeapon(heroRegistry.getHero(heroChoice), itemChoice2, hand2);
                            }
                            break;
                        case 6:
                            gameUtlity.displayAllHeroInfo();
                            turn++;
                            break;
                        default:
                            break;
                    }
                } else {
                    //Monster turn
                    Random random = new Random();
                    int heroIndex = random.nextInt(heroRegistry.getHeroMap().size());
                    int monsterIndex = random.nextInt(monsterRegistry.getMonsterMap().size());
                    battleUtlity.monsterAttack(monsterRegistry.getMonster(monsterRegistry.getMonsterMap().keySet().toArray()[monsterIndex].toString()),
                            heroRegistry.getHero(heroRegistry.getHeroMap().keySet().toArray()[heroIndex].toString()));
                }
                turn++;

                //TODO: Check if battle is over
                boolean allHeroesDead = true;
                for (Hero hero : heroRegistry.getHeroMap().values()) {
                    if (hero.getHp() > 0) {
                        allHeroesDead = false;
                        break;
                    }
                }

                //check if all monsters hp <= 0
                boolean allMonstersDead = true;
                for (Monster monster : monsterRegistry.getMonsterMap().values()) {
                    if (monster.getHp() > 0) {
                        allMonstersDead = false;
                        break;
                    }
                }

                if(allHeroesDead){
                    System.out.println("All heroes are dead. Game over.");
                    exit(0);
                }

                if (allHeroesDead || allMonstersDead) {
                    isBattleOver = true;
                }
            }

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
            exitShop();
        } else {
            System.out.println("Invalid action: Can only enter shop from MOVE state.");
        }
    }

    public void winBattle() {
        if (currentState == GameState.BATTLE) {
            currentState = GameState.MOVE;
            battleUtlity.endBattle();
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

    private boolean isInBoard(int x, int y){
        return x >= 0 && x < 7 && y >= 0 && y < 7;
    }
}

