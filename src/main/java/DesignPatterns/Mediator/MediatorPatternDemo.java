package DesignPatterns.Mediator;

import DesignPatterns.Factory.CharacterSpawns;
import DesignPatterns.Factory.SuperPerson;

public class MediatorPatternDemo {
    public static void main(String[] args) {
        Battle threeVsThree = new Battle();

        CharacterSpawns spawn = new CharacterSpawns();

        //Heros
        SuperPerson fighter1 = spawn.spawnCharacter("HERO", "fighter1");
        SuperPerson fighter2 = spawn.spawnCharacter("HERO", "fighter2");
        SuperPerson healer = spawn.spawnCharacter("HERO", "healer");

        //Villains        
        SuperPerson brute1 = spawn.spawnCharacter("VILLAIN", "brute1");
        SuperPerson brute2 = spawn.spawnCharacter("VILLAIN", "brute2");
        SuperPerson caster = spawn.spawnCharacter("VILLAIN", "caster");

        //add to teams
        threeVsThree.addHero(fighter1);
        threeVsThree.addHero(fighter2);
        threeVsThree.addHero(healer);

        threeVsThree.addVillain(brute1);
        threeVsThree.addVillain(brute2);
        threeVsThree.addVillain(caster);

        while (threeVsThree.currentRound()) {
            //villains turns
            threeVsThree.attack(brute1);
            threeVsThree.attack(brute2);
            threeVsThree.castSpell(caster);

            //heros turns
            threeVsThree.attack(fighter1);
            threeVsThree.attack(fighter2);
            threeVsThree.castSpell(healer);

        }
    }
}
