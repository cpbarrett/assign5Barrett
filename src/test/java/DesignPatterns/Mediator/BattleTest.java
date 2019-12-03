package DesignPatterns.Mediator;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import DesignPatterns.Factory.CharacterSpawns;
import DesignPatterns.Factory.SuperPerson;

public class BattleTest {
    @Test
    public final void test() {
        Battle none = new Battle();
        assertTrue(none.name.equals("Battle"));
        
        Battle test = new Battle("test");

        CharacterSpawns spawn = new CharacterSpawns();

        //Heros
        SuperPerson fighter = spawn.spawnCharacter("HERO", "fighter1");
        SuperPerson healer = spawn.spawnCharacter("HERO", "fighter1");

        //Villains        
        SuperPerson brute = spawn.spawnCharacter("VILLAIN", "brute1");
        
        brute.setHp(10);

        //add to teams
        assertFalse(test.addHero(null));
        assertFalse(test.addVillain(null));
        test.addHero(fighter);
        test.addVillain(brute);

        assertTrue(test.getHeroList().size() == 1);
        assertTrue(test.getVillainList().size() == 1);
        
        assertTrue(test.currentHp(brute) == 10);
        assertTrue(test.currentHp(fighter) == 100);
        
        //check hero victory
        assertTrue(test.currentRound());
        test.attack(brute);
        test.addHero(healer);
        test.castSpell(healer);
        test.attack(fighter);
        test.attack(fighter);
        
        assertFalse(test.currentRound());
        
        //hero is eaten by dragon
        SuperPerson dragon = spawn.spawnCharacter("VILLAIN", "dragon");
        dragon.setPowerLevel(1000);
        test.addVillain(dragon);
        test.castSpell(dragon);
        assertFalse(test.currentRound());
    }

}
