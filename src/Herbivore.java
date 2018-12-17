public class Herbivore extends Dinosaur{
    public Herbivore(int hp, int speed, int age, int life, int starve, int size, String name, String gender){
        super(hp, speed, age, life, starve, size, name, gender);
    }
    public int getDamageHerb(int size, int age, int speed, int starve){
        double minDamage;
        double maxDamage;
        if(size > speed){
            maxDamage = size * (1-starve/100.0);
            minDamage = speed * (1-starve/100.0);
        }
        else{
            maxDamage = speed * (1-starve/100.0);
            minDamage = size * (1-starve/100.0);
        }
        int damage = (int)((Math.random()*maxDamage-minDamage)+minDamage);
        return damage;
    }

    public boolean runAway(int attackSpeed, int defendSpeed){
        boolean run;
        int defense = (int)(Math.random()*defendSpeed)+1;
        int attack = (int)(Math.random()*attackSpeed)+1;
        if(defense < attack){
            run = true;
        }
        else{
            run = false;
        }
        return run;
    }
}