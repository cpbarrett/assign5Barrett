package Barrett.Assignment.Design.Patters.Factory;

public class Villian implements SuperPerson {
    public String name;
    private int hp;
    private int powerLevel;
    private String catchPhrase;
    
    public Villian(String name) {
        this.name = name;
        this.hp = 50;
        this.powerLevel = 10;
    }

    @Override
    public void catchPhrase() {
        System.out.println("I am a villian");        
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public String getCatchPhrase() {
        return catchPhrase;
    }

    public void setCatchPhrase(String catchPhrase) {
        this.catchPhrase = catchPhrase;
    }

    public void setPowerLevel(int powerLevel) {
        this.powerLevel = powerLevel;
    }

}
