package Barrett.Assignment.Design.Patters.Factory;

import java.util.Random;

public class Villian implements SuperPerson {
    public final String name;
    private int hp;
    private int powerLevel;
    private String catchPhrase;
    private String alignment;
    
    public Villian(String name) {
        this.name = name;
        this.hp = 50;
        this.powerLevel = 20;
        this.catchPhrase = "I am a villian.";
        this.alignment = "villain";
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getHp() {
        return hp;
    }

    @Override
    public int getPowerLevel() {
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
        int sides = 12;
        Random d = new Random();
        
        int roll = d.nextInt(sides) + 1 + this.getPowerLevel();
        
        return roll;
    }
    
    public String getAlignment() {
        return this.alignment;
    }

}
