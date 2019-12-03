package DesignPatterns.Factory;

public interface SuperPerson {

    String getCatchPhrase();
    
    String getName();
    
    int getPowerLevel();
    
    int getHp();
    
    int attack();
    
    void setHp(int i);
    
    String getAlignment();

    void setCatchPhrase(String string);

    void setPowerLevel(int i);
    
}
