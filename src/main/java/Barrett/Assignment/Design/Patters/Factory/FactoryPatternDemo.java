package Barrett.Assignment.Design.Patters.Factory;

public class FactoryPatternDemo {

    public static void main(String[] args) {
        CharacterSpawns spawnNew = new CharacterSpawns();

        SuperPerson hero1 = spawnNew.getCharacter("HERO");
        
        SuperPerson villian1 = spawnNew.getCharacter("Villian");
        
        hero1.catchPhrase();
        villian1.catchPhrase();
     }
 }
