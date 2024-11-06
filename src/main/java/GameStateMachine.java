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
    private int monsterNumber;
    private double monsterAvgLevel;

    public GameStateMachine() {
        this.currentState = GameState.IDLE;
    }

    public GameState getCurrentState() {
        return currentState;
    }

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
                                    //System.out.println("Encounter enemies.");
                                    encounterEnemy();
                                }
                                System.out.println("Moved up.");
                            }
                            else if (board.getBoard().get(new UnitKey(x - 1, y)).getType() == UnitEvent.MARKET) {
                                    enterShop();
                                    //System.out.println("Enter the shop.");
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
                                    //System.out.println("Encounter enemies.");
                                    encounterEnemy();
                                }
                                System.out.println("Moved down.");

                            }
                            else if (board.getBoard().get(new UnitKey(x + 1, y)).getType() == UnitEvent.MARKET) {
                                //System.out.println("Enter the shop.");
                                enterShop();
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
                                    //System.out.println("Encounter enemies.");
                                    encounterEnemy();
                                }
                                System.out.println("Moved left.");
                            }
                            else if (board.getBoard().get(new UnitKey(x, y - 1)).getType() == UnitEvent.MARKET) {
                                //System.out.println("Enter the shop.");
                                enterShop();
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
                                    //System.out.println("Encounter enemies.");
                                    encounterEnemy();
                                }
                                System.out.println("Moved right.");
                            }
                            else if (board.getBoard().get(new UnitKey(x, y + 1)).getType() == UnitEvent.MARKET) {
                                //System.out.println("Enter the shop.");
                                enterShop();
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
            int avgLevelDiff = gameUtlity.differenceToNearestInt(gameUtlity.HeroAvgLevel(), gameUtlity.HeroInitAvgLevel());
            gameUtlity.createMonsterParty(heroRegistry.getHeroMap().size() + Main.difficulty, avgLevelDiff + Main.difficulty);
            monsterNumber = heroRegistry.getHeroMap().size() + Main.difficulty;
            monsterAvgLevel = battleUtlity.getMonsterAvgLevel();
            boolean isBattleOver = false;
            int turn = 0;
            while (!isBattleOver) {
                if(turn % 2 == 0){
                    turn++;
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
                            break;
                        case 2:
                            System.out.println("Select a spell to use:");
                            gameUtlity.displayInventory(heroChoice);
                            String spellChoice = Main.SCANNER.next();
                            while (true) {
                                if( spellChoice.equals("exit")) {
                                    turn++;
                                    break;
                                }
                                if (heroRegistry.getHero(heroChoice).getInventory().containsKey(spellChoice)) {
                                    if(heroRegistry.getHero(heroChoice).getInventory().get(spellChoice) instanceof Spell) {
                                        if(((Spell) heroRegistry.getHero(heroChoice).getInventory().get(spellChoice)).getUsage() > 0) {
                                            if(heroRegistry.getHero(heroChoice).getMana() > ((Spell) heroRegistry.getHero(heroChoice).getInventory().get(spellChoice)).getManaCost()) {
                                                break;
                                            } else {
                                                System.out.println("Not enough mana to use the spell.");
                                                spellChoice = Main.SCANNER.next();
                                            }
                                        } else {
                                            System.out.println("Potion is out of usage. Please enter a valid potion name:");
                                            spellChoice = Main.SCANNER.next();
                                        }
                                    } else {
                                        System.out.println("Invalid potion name. Please enter a valid potion name:");
                                        spellChoice = Main.SCANNER.next();
                                    }
                                } else {
                                    System.out.println("Invalid potion name. Please enter a valid potion name:");
                                    spellChoice = Main.SCANNER.next();
                                }
                            }
                            battleUtlity.useSpell(heroRegistry.getHero(heroChoice), spellChoice, monsterRegistry.getMonster(monsterChoice));
                            break;
                        case 3:
                            System.out.println("Select a potion to use:");
                            gameUtlity.displayInventory(heroChoice);
                            String potionChoice = Main.SCANNER.next();
                            while (true) {
                                if( potionChoice.equals("exit")) {
                                    turn++;
                                    break;
                                }
                                if (heroRegistry.getHero(heroChoice).getInventory().containsKey(potionChoice)) {
                                    if(heroRegistry.getHero(heroChoice).getInventory().get(potionChoice) instanceof Potion) {
                                        if(((Potion) heroRegistry.getHero(heroChoice).getInventory().get(potionChoice)).getUsage() > 0) {
                                            break;
                                        } else {
                                            System.out.println("Potion is out of usage. Please enter a valid potion name:");
                                            potionChoice = Main.SCANNER.next();
                                        }
                                    } else {
                                        System.out.println("Invalid potion name. Please enter a valid potion name:");
                                        potionChoice = Main.SCANNER.next();
                                    }
                                } else {
                                    System.out.println("Invalid potion name. Please enter a valid potion name:");
                                    potionChoice = Main.SCANNER.next();
                                }
                            }
                            battleUtlity.usePotion(heroRegistry.getHero(heroChoice), potionChoice);
                            break;
                        case 4:
                            System.out.println("Select an item to equip:");
                            gameUtlity.displayInventory(heroChoice);
                            String itemChoice = Main.SCANNER.next();
                            while (!(heroRegistry.getHero(heroChoice).getInventory().get(itemChoice) instanceof Armor)
                                    && !(heroRegistry.getHero(heroChoice).getInventory().get(itemChoice) instanceof Weapon)) {
                                System.out.println("Invalid item name. Please enter a valid item name:");
                                itemChoice = Main.SCANNER.next();
                                if (itemChoice.equals("exit")) {
                                    turn++;
                                    break;
                                }
                            }
                            if (heroRegistry.getHero(heroChoice).getInventory().get(itemChoice) instanceof Armor) {
                                System.out.println("armor");
                                battleUtlity.equipArmor(heroRegistry.getHero(heroChoice), itemChoice);
                                break;
                            }
                            if (heroRegistry.getHero(heroChoice).getInventory().get(itemChoice) instanceof Weapon) {
                                System.out.println("Select hand to equip the weapon:");
                                int hand = gameUtlity.takeValidInput(1, 2);
                                battleUtlity.equipWeapon(heroRegistry.getHero(heroChoice), itemChoice, hand);
                                break;
                            } else {
                                System.out.println("Invalid item type. Please enter a valid item type.");
                            }
                            break;
                        case 5:
                            System.out.println("Select an item to unequip:");
                            gameUtlity.displayEquippedItems(heroChoice);
                            String itemChoice2 = Main.SCANNER.next();
                            while (!heroRegistry.getHero(heroChoice).getEquipped().containsKey(itemChoice2)
                                    && !(heroRegistry.getHero(heroChoice).getEquipped().get(itemChoice2) instanceof Armor)
                                    && !(heroRegistry.getHero(heroChoice).getEquipped().get(itemChoice2) instanceof Weapon)) {
                                System.out.println("Invalid item name. Please enter a valid item name:");
                                itemChoice2 = Main.SCANNER.next();
                                if (itemChoice2.equals("exit")) {
                                    turn++;
                                    break;
                                }
                            }
                            if (heroRegistry.getHero(heroChoice).getEquipped().get(itemChoice2) instanceof Armor) {
                                battleUtlity.unEquipArmor(heroRegistry.getHero(heroChoice), itemChoice2);
                            }
                            if (heroRegistry.getHero(heroChoice).getEquipped().get(itemChoice2) instanceof Weapon) {
                                battleUtlity.unEquipWeapon(heroRegistry.getHero(heroChoice), itemChoice2);
                            }
                            break;
                        case 6:
                            gameUtlity.displayAllHeroInfo();
                            turn++;
                            break;
                        default:
                            break;
                    }
                }
                if (turn % 2 == 1) {
                    turn++;
                    Random random = new Random();
                    for (Monster monster : monsterRegistry.getMonsterMap().values()) {
                        if (monster.getHp() <= 0) {
                            monsterRegistry.getMonsterMap().remove(monster.getName());
                        }
                    }
                    if (monsterRegistry.getMonsterMap().isEmpty()) {
                        break;
                    }
                    int heroIndex = random.nextInt(heroRegistry.getHeroMap().size());
                    int monsterIndex = random.nextInt(monsterRegistry.getMonsterMap().size());
                    battleUtlity.monsterAttack(monsterRegistry.getMonster(monsterRegistry.getMonsterMap().keySet().toArray()[monsterIndex].toString()),
                            heroRegistry.getHero(heroRegistry.getHeroMap().keySet().toArray()[heroIndex].toString()));
                }

                for (Hero hero : heroRegistry.getHeroMap().values()) {
                    if (hero.getHp() > 0 ) hero.setHp(hero.getHp() + 20);
                    if (hero.getHp() > 0 ) hero.setMana(hero.getMana() + 20);
                }

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
            winBattle();
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
                System.out.println("3. Repair Item");
                System.out.println("4. Switch Hero");
                System.out.println("5. Exit Shop");
                int choice = gameUtlity.takeValidInput(1, 5);
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
                    if(heroRegistry.getHero(heroChoice).getLevel() < market.getItemLevel(item_name)){
                        System.out.println("Hero level is not enough to buy the item.");
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
                } else if (choice == 3) {
                    System.out.println("Enter the item name you want to repair:");
                    gameUtlity.displayInventory(heroChoice);
                    String item_name = Main.SCANNER.next();
                    while (!heroRegistry.getHero(heroChoice).getInventory().containsKey(item_name)) {
                        System.out.println("Invalid item name. Please enter a valid item name:");
                        item_name = Main.SCANNER.next();
                    }
                    if(heroRegistry.getHero(heroChoice).getGold() < (double) market.getItemCost(item_name) / 2){
                        System.out.println("Not enough gold to repair the item.");
                        continue;
                    }
                    market.repairItem(item_name, heroChoice);
                }
                else if (choice == 4) {
                    heroChoice = gameUtlity.selectHero();
                }
                else {
                    exitShop();
                    break;
                }
            }
        } else {
            System.out.println("Invalid action: Can only enter shop from MOVE state.");
        }
    }

    public void winBattle() {
        if (currentState == GameState.BATTLE) {
            currentState = GameState.MOVE;
            System.out.println("Player wins the battle.");
            battleUtlity.endBattle(monsterNumber, monsterAvgLevel);
        } else {
            System.out.println("Invalid action: Can only win or flee battle from BATTLE state.");
        }
    }

    public void exitShop() {
        if (currentState == GameState.SHOP) {
            currentState = GameState.MOVE;
            System.out.println("Player exits the shop.");
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

