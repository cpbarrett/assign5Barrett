package Barrett.Assignment.Design.Patters.Mediator;

import Barrett.Assignment.Design.Patters.Factory.SuperPerson;

import java.util.ArrayList;
import java.util.HashMap;

public class Battle {

    public HashMap<String, Integer> heros = new HashMap<>();
    public HashMap<String, Integer> villains = new HashMap<>();
    ArrayList<SuperPerson> heroList; 
    ArrayList<SuperPerson> villainList; 

    public final String name;
    public int round;

    public Battle() {
        this.name = "Battle";
        this.round = 1;
        this.heroList = new ArrayList<SuperPerson>();
        this.villainList = new ArrayList<SuperPerson>();
    }

    public Battle(String name) {
        this.name = name;
        this.round = 1;
    }

    public ArrayList<SuperPerson> getHeroList() {
        return this.heroList;
    }

    public ArrayList<SuperPerson> getvillainList() {
        return this.villainList;
    }

    public HashMap<String, Integer> getHeros() {
        return heros;
    }

    public void setHeros(HashMap<String, Integer> heros) {
        this.heros = heros;
    }

    public HashMap<String, Integer> getVillains() {
        return villains;
    }

    public void setVillains(HashMap<String, Integer> villains) {
        this.villains = villains;
    }

    public boolean addHero(SuperPerson hero) {
        if (hero != null) {
            heros.put(hero.getName(), hero.getHp());
            heroList.add(hero);
            return true;
        }
        return false;
    }

    public boolean addVillain(SuperPerson villain) {
        if (villain != null) {
            villains.put(villain.getName(), villain.getHp());
            villainList.add(villain);
            return true;
        }
        return false;
    }

    public int currentHp(SuperPerson unit) {
        if (unit.getAlignment().equals("hero")) {
            return heros.get(unit.getName());
        } else if (unit.getAlignment().equals("villain")) {
            return villains.get(unit.getName());
        } else {
            return 0;
        }
    }

    private boolean removeDeadUnits(SuperPerson unit) {
        if (unit == null) {
            return false;
        } else if (unit.getAlignment().equals("hero")) {
            heros.remove(unit.getName());
            heroList.remove(unit);
            return true;
        } else if (unit.getAlignment().equals("villain")) {
            villains.remove(unit.getName());
            villainList.remove(unit);
            return true;
        } else {
            return false;
        }
    }

    public boolean currentRound() {
        if (this.round == 1) {
            System.out.println("The " + this.name + " has begun!");
            System.out.println();
        }
        //check for victors
        if (declareVictory()) {
            return false;
        }

        //current Round
        System.out.println("Round " + this.round);

        //end of round
        this.round++;
        return true;
    }

    public void attack(SuperPerson attacker) {
        if (attacker.getName() == null || attacker.getHp() == 0) {
            return;
        }
        if (heroList.isEmpty() || villainList.isEmpty()) {
            return;
        }
        //calc damage
        int damage = attacker.attack();

        //PICK target
        DiceRoll target = new DiceRoll();
        SuperPerson defender = heroList.get(target.rollD(heroList.size()) - 1);

        if (attacker.getAlignment().equals("hero")) {
            defender = villainList.get(target.rollD(villainList.size()) - 1);
        }        

        if (attacker.getAlignment().equals("hero") && defender.getAlignment().equals("villain")) {
            villains.put(defender.getName(), (this.currentHp(defender) - damage));
            System.out.println(attacker.getName() + " attacks " 
                    + defender.getName() + " for " + damage + " damage.");
            if (this.currentHp(defender) <= 0) {
                System.out.println(defender.getName() + " has fallen.");
                removeDeadUnits(defender);
            }
        } else if (attacker.getAlignment().equals("villain") 
                && defender.getAlignment().equals("hero")) {
            heros.put(defender.getName(), (this.currentHp(defender) - damage));
            System.out.println(attacker.getName() + " attacks " 
                    + defender.getName() + " for " + damage + " damage.");
            if (this.currentHp(defender) <= 0) {
                System.out.println(defender.getName() + " has fallen.");
                removeDeadUnits(defender);
            }
        } else {
            System.out.println("Attack Fails.");
            return;
        }
    }

    public void castSpell(SuperPerson attacker) {
        if (attacker.getName() == null || attacker.getHp() == 0) {
            return;
        }
        if (heroList.isEmpty() || villainList.isEmpty()) {
            return;
        }
        //calc damage
        int damage = attacker.attack();

        //PICK target
        DiceRoll target = new DiceRoll();
        SuperPerson defender = heroList.get(target.rollD(heroList.size()) - 1);

        if (attacker.getAlignment().equals("hero") && defender.getAlignment().equals("hero")) {
            heros.put(defender.getName(), (this.currentHp(defender) + damage));
            System.out.println(attacker.getName() + " heals " 
                    + defender.getName() + " for " + damage + " health.");
        } else if (attacker.getAlignment().equals("villain") 
                && defender.getAlignment().equals("hero")) {
            heros.put(defender.getName(), (this.currentHp(defender) - damage));
            System.out.println(attacker.getName() + " casts a spell on " 
                    + defender.getName() + " for " + damage + " damage.");
            if (this.currentHp(defender) <= 0) {
                System.out.println(defender.getName() + " has fallen.");
                removeDeadUnits(defender);
            }
        } else {
            System.out.println("Spell Fails.");
            return;
        }
    }

    public boolean declareVictory() {        
        if (heros.isEmpty()) {
            System.out.println("Villains have defeated the heros.");
            return true;
        }
        if (villains.isEmpty()) {
            System.out.println("Heros have vanquished the vilains.");
            return true;
        }
        return false;
    }
}
