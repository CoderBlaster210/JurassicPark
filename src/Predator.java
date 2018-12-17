public class Predator extends Dinosaur{
    public Predator(int hp, int speed, int age, int life, int starve, int size, String name, String gender){
        super(hp, speed, age, life, starve, size, name, gender);
    }
    public int getDamagePred(int size, int age, int speed, int starve){
        double maxDamage = (size+age+speed) * (1-starve/100.0);
        double minDamage = (size) * (1-starve/100.0);
        int damage = (int)((Math.random()*maxDamage-minDamage)+minDamage);
        return damage;
    }
}