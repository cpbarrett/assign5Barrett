package Barrett.Assignment.Design.Patters.Factory;

public class CharacterSpawns {

    public SuperPerson getCharacter(String characterType) {
        if(characterType == null) {
            return null;
        }
        if(characterType.equalsIgnoreCase("HERO")) {
            return new Hero("hero");
        } else if(characterType.equalsIgnoreCase("VILLIAN")) {
            return new Villian("hero");
        }
        return null;
    }
}
