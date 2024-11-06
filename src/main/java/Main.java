import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static final Scanner SCANNER = new Scanner(System.in);
    public static int difficulty = 0;


    public static void main(String[] args) {
        Play play = new Play();
        play.startGame();
    }

//    private static void winbattleTest(){
//        GameStateMachine gameStateMachine = new GameStateMachine();
//        GameUtlity gameUtlity = new GameUtlity();
//        HeroFactory heroFactory = new WarriorFactory();
//        HeroFactory heroFactory1 = new SorcererFactory();
//        HeroFactory heroFactory2 = new PaladinFactory();
//        HeroRegistry heroRegistry = HeroRegistry.getInstance();
//        MonsterRegistry monsterRegistry = MonsterRegistry.getInstance();
//        Board board = Board.getInstance();
//
//        gameStateMachine.startExploring();
//
//        Monster monster = new Dragon("test", 1, 1, 1, 1, 1);
//        monster.setHp(1);
//        monsterRegistry.getMonsterMap().clear();
//        monsterRegistry.getMonsterMap().put("test", monster);
//        System.out.println(monsterRegistry.getMonsterMap().size());
//
//        gameStateMachine.Moving();
//    }
//
//
//    private static void losebattleTest(){
//        GameStateMachine gameStateMachine = new GameStateMachine();
//        GameUtlity gameUtlity = new GameUtlity();
//        HeroFactory heroFactory = new WarriorFactory();
//        HeroFactory heroFactory1 = new SorcererFactory();
//        HeroFactory heroFactory2 = new PaladinFactory();
//        HeroRegistry heroRegistry = HeroRegistry.getInstance();
//        Board board = Board.getInstance();
//
//        gameStateMachine.startExploring();
//
//        Hero hero = new Warrior("test", 1, 1, 1, 1, 1, 1, "Warrior");
//        hero.setHp(1);
//        heroRegistry.getHeroMap().clear();
//        heroRegistry.getHeroMap().put("test", hero);
//
//        gameStateMachine.Moving();
//    }

//    private static void potionTest(){
//        GameStateMachine gameStateMachine = new GameStateMachine();
//        GameUtlity gameUtlity = new GameUtlity();
//        BattleUtlity battleUtlity = new BattleUtlity();
//        HeroFactory heroFactory = new WarriorFactory();
//        HeroFactory heroFactory1 = new SorcererFactory();
//        HeroFactory heroFactory2 = new PaladinFactory();
//        HeroRegistry heroRegistry = HeroRegistry.getInstance();
//        MonsterRegistry monsterRegistry = MonsterRegistry.getInstance();
//        Board board = Board.getInstance();
//
//        gameStateMachine.startExploring();
//        int turn = 0;
//
//        Fire fire = new Fire("Fire", 1, 1, 1, 1, 1);
//        Potion potion = new Potion("Potion", 1, 1, 1, new ArrayList<>(), 0);
//        heroRegistry.getHero("Eunoia_Cyn").getInventory().put("Fire", fire);
//        heroRegistry.getHero("Eunoia_Cyn").getInventory().put("Potion", potion);
//
//        String heroChoice = "Eunoia_Cyn";
//
//        System.out.println("Select a potion to use:");
//        gameUtlity.displayInventory(heroChoice);
//        String potionChoice = Main.SCANNER.next();
//        while (true) {
//            if (heroRegistry.getHero(heroChoice).getInventory().containsKey(potionChoice)) {
//                if(heroRegistry.getHero(heroChoice).getInventory().get(potionChoice) instanceof Potion) {
//                    if(((Potion) heroRegistry.getHero(heroChoice).getInventory().get(potionChoice)).getUsage() > 0) {
//                        break;
//                    } else {
//                        System.out.println("Potion is out of usage. Please enter a valid potion name:");
//                        potionChoice = Main.SCANNER.next();
//                    }
//                } else {
//                    System.out.println("Invalid potion name. Please enter a valid potion name:");
//                    potionChoice = Main.SCANNER.next();
//                }
//            } else {
//                System.out.println("Invalid potion name. Please enter a valid potion name:");
//                potionChoice = Main.SCANNER.next();
//            }
//        }
//        battleUtlity.usePotion(heroRegistry.getHero(heroChoice), potionChoice);
//    }

//    private void spellTesst(){
//        GameStateMachine gameStateMachine = new GameStateMachine();
//        GameUtlity gameUtlity = new GameUtlity();
//        BattleUtlity battleUtlity = new BattleUtlity();
//        HeroFactory heroFactory = new WarriorFactory();
//        HeroFactory heroFactory1 = new SorcererFactory();
//        HeroFactory heroFactory2 = new PaladinFactory();
//        HeroRegistry heroRegistry = HeroRegistry.getInstance();
//        MonsterRegistry monsterRegistry = MonsterRegistry.getInstance();
//        Board board = Board.getInstance();
//
//        gameStateMachine.startExploring();
//        int turn = 0;
//
//        Spell fire = new Fire("Fire", 1, 1, 1, 100, 1);
//
//        heroRegistry.getHero("Eunoia_Cyn").getInventory().put("Fire", fire);
//        heroRegistry.getHero("Eunoia_Cyn").setMana(1);
//
//        String heroChoice = "Eunoia_Cyn";
//
//        System.out.println("Select a spell to use:");
//        gameUtlity.displayInventory(heroChoice);
//        String spellChoice = Main.SCANNER.next();
//        while (true) {
//            if( spellChoice.equals("exit")) {
//                turn++;
//                break;
//            }
//            if (heroRegistry.getHero(heroChoice).getInventory().containsKey(spellChoice)) {
//                if(heroRegistry.getHero(heroChoice).getInventory().get(spellChoice) instanceof Spell) {
//                    if(((Spell) heroRegistry.getHero(heroChoice).getInventory().get(spellChoice)).getUsage() > 0) {
//                        if(heroRegistry.getHero(heroChoice).getMana() > ((Spell) heroRegistry.getHero(heroChoice).getInventory().get(spellChoice)).getManaCost()) {
//                            break;
//                        } else {
//                            System.out.println("Not enough mana to use the spell.");
//                            spellChoice = Main.SCANNER.next();
//                        }
//                    } else {
//                        System.out.println("Potion is out of usage. Please enter a valid potion name:");
//                        spellChoice = Main.SCANNER.next();
//                    }
//                } else {
//                    System.out.println("Invalid potion name. Please enter a valid potion name:");
//                    spellChoice = Main.SCANNER.next();
//                }
//            } else {
//                System.out.println("Invalid potion name. Please enter a valid potion name:");
//                spellChoice = Main.SCANNER.next();
//            }
//        }
//        System.out.println("Select a monster to attack:");
//    }



}