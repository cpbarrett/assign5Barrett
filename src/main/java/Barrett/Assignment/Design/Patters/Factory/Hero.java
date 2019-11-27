package Barrett.Assignment.Design.Patters.Factory;
import java.util.Random;

public class Hero implements SuperPerson {
    public final String name;
    private int hp;
    private int powerLevel;
    private String catchPhrase;
    private String alignment;
    
    public Hero(String name) {
        this.name = name;
        this.hp = 100;
        this.powerLevel = 10;
        this.catchPhrase = "I am a hero";
        this.alignment = "hero";
    }

    @Override
    public String getName(){
        return this.name;
    }

    @Override
    public int getHp() {
        return hp;
    }

    @Override
    public int getPowerLevel(){
        return this.powerLevel;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    @Override
    public String getCatchPhrase() {
        return catchPhrase;
    }

    public void setCatchPhrase(String catchPhrase) {
        this.catchPhrase = catchPhrase;
    }

    public void setPowerLevel(int powerLevel) {
        this.powerLevel = powerLevel;
    }

    @Override
    public int attack() {
        int sides = 6;
        Random d = new Random();
        
        int roll = d.nextInt(sides) + 1 + this.getPowerLevel();
        
        return roll;
    }

    @Override
    public String getAlignment() {
        return this.alignment;
    }

}
