package DesignPatterns.Factory;

public class CharacterSpawns {

    public SuperPerson spawnCharacter(String characterType, String name) {
        if (characterType == null) {
            return null;
        }
        if (characterType.equalsIgnoreCase("HERO")) {
            return new Hero(name);
        } else if (characterType.equalsIgnoreCase("VILLAIN")) {
            return new Villian(name);
        }
        return null;
    }
}
