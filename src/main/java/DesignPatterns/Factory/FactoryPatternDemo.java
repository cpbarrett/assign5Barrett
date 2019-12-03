package DesignPatterns.Factory;

public class FactoryPatternDemo {

    public static void main(String[] args) {
        CharacterSpawns spawnNew = new CharacterSpawns();

        SuperPerson hero1 = spawnNew.spawnCharacter("HERO", "hero");

        SuperPerson villain1 = spawnNew.spawnCharacter("Villain", "villain");

        //Battle 1
        System.out.println("Battle one: " + hero1.getName() + " vs. " + villain1.getName());

        //hero catchphrase
        System.out.println(hero1.getCatchPhrase());

        //villian catchphrase
        System.out.println(villain1.getCatchPhrase());

        int round = 1;
        int damage = 0;

        while (hero1.getHp() > 0 && villain1.getHp() > 0) {
            System.out.println();
            System.out.println("Round " + round);

            damage = villain1.attack();
            hero1.setHp(hero1.getHp() - damage);
            System.out.println(villain1.getName() 
                    + " attacks and deals " 
                    + damage + " points of damage.");

            damage = hero1.attack();
            villain1.setHp(villain1.getHp() - damage);
            System.out.println(hero1.getName() 
                    + " attacks and deals " 
                    + damage + " points of damage.");

            if (hero1.getHp() <= 0) {
                System.out.println();
                System.out.println(villain1.getName() + " is the victor this time.");
                break;
            } else if (villain1.getHp() <= 0) {
                System.out.println();
                System.out.println(hero1.getName() + " saves the day.");
                break;
            }

            round++;
        }
    }
}
