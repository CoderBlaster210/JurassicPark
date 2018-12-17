public class Dinosaur{
    private int hp;
    private int speed;
    private int age;
    private int life;
    private int starveVal;
    private int size;
    private String name;
    private String gender;
    public Dinosaur(int hp, int speed, int age, int life, int starveVal, int size, String name, String gender){
        this.hp = hp;
        this.speed = speed;
        this.age = age;
        this.life = life;
        this.starveVal = starveVal;
        this.size = size;
        this.name = name;
        this.gender = gender;
    }
    public int getHp(){

        return hp;
    }
    public int getSpeed(){
        return speed;
    }
    public int getAge(){
        return age;
    }
    public int getLife(){
        return life;
    }
    public int getStarve(){
        return starveVal;
    }
    public int getSize(){
        return size;
    }
    public String getName(){
        return name;
    }
    public String getGender(){
        return gender;
    }
    public void getOlder(){
        if (age==life)
            hp = 0;
        age++;
    }
    public void reducePoints(int damage){
        hp-=damage;
    }
    public boolean isStarving(int starveVal){
        int sNum = (int)(Math.random()*100)+1;
        boolean starving;
        if(sNum < starveVal){
            starving = true;
        }
        else{
            starving = false;
        }
        return starving;
    }
    public void starve(){
        if(isStarving(starveVal))
            hp*=.9;
    }

    public int setStarvation(int starve){

        return starveVal += starve;
    }
}