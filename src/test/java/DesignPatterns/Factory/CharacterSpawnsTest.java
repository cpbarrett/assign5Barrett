package DesignPatterns.Factory;

import static org.junit.Assert.*;

import org.junit.Test;

public class CharacterSpawnsTest {

    /**
     * Test method for {@link DesignPatterns.Factory.CharacterSpawns#spawnCharacter(java.lang.String, java.lang.String)}.
     */
    @Test
    public void testSpawnCharacter() {
        CharacterSpawns spawnNew = new CharacterSpawns();

        SuperPerson hero = spawnNew.spawnCharacter("HERO", "hero");

        SuperPerson villain = spawnNew.spawnCharacter("Villain", "villain");

        assertTrue(hero.getAlignment().equals("hero"));
        assertTrue(villain.getAlignment().equals("villain"));
        assertTrue(hero.getName().equals("hero"));
        assertTrue(villain.getName().equals("villain"));
        
        hero.setCatchPhrase("What's up?");
        assertTrue(hero.getCatchPhrase().equals("What's up?"));
        
        villain.setCatchPhrase("Surprise!");
        assertTrue(villain.getCatchPhrase().equals("Surprise!"));
        
        hero.setHp(200);
        assertTrue(hero.getHp() == 200);
        
        villain.setHp(200);
        assertTrue(villain.getHp() == 200);
        
        hero.setPowerLevel(200);
        assertTrue(hero.getPowerLevel() == 200);
        
        villain.setPowerLevel(200);
        assertTrue(villain.getPowerLevel() == 200);
        
        hero.attack();
        villain.attack();
        
        assertTrue(spawnNew.spawnCharacter(null, "test") == null);
        assertTrue(spawnNew.spawnCharacter("test", "test") == null);

    }

}
