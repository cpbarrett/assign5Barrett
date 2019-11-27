package Barrett.Assignment.Design.Patters.Mediator;

import java.util.HashMap;

import Barrett.Assignment.Design.Patters.Factory.SuperPerson;

public class Battle {

    public HashMap<String, Integer> heros = new HashMap<>();
    public HashMap<String, Integer> villains = new HashMap<>();
    public final String name;
    public int round;
    
    public Battle() {
        this.name = "Battle";
        this.round = 1;
    }
    
    public Battle(String name) {
        this.name = name;
        this.round = 1;
    }
    
    public boolean addHero(String name, int hp) {
        if(name != null) {
            heros.put(name, hp);
            return true;
        }
        return false;
    }
    
    public boolean addVillain(String name, int hp) {
        if(name != null) {
            villains.put(name, hp);
            return true;
        }
        return false;
    }
    
    public int currentHp(SuperPerson unit) {
        if(unit.getAlignment().equals("hero")) {
            return heros.get(unit.getName());
        } else if (unit.getAlignment().equals("villain")) {
            return villains.get(unit.getName());
        } else {
            return 0;
        }
    }
    
    public void currentRound() {
        if(this.round == 1) {
            System.out.println("The " + this.name + " has begun!");
            System.out.println();
        }
        
        //current Round
        System.out.println("Round " + this.round);
        this.round++;
    }
    
    public void attack(SuperPerson attacker, SuperPerson defender) {
        if(attacker.getName() == null) {
            return;
        }
        int damage = attacker.attack();
        
        if(attacker.getAlignment().equals("hero") && defender.getAlignment().equals("villain")) {
            villains.put(defender.getName(), (this.currentHp(defender) - damage));
            System.out.println(attacker.getName() + " attacks " + defender.getName() + " for " + damage + " damage.");
        } else if(attacker.getAlignment().equals("villain") && defender.getAlignment().equals("hero")) {
            heros.put(defender.getName(), (this.currentHp(defender) - damage));
            System.out.println(attacker.getName() + " attacks " + defender.getName() + " for " + damage + " damage.");
        } else {
            System.out.println("Attack Fails.");
        }
    }
}
