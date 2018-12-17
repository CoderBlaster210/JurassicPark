
import java.util.ArrayList;
public class Jurassic{
    ArrayList<Dinosaur> dino;
    int herbHP;
    int predHP;
    int herbSpeed;
    int predSpeed;
    int age;
    int herbSval;
    int predSval;
    int herbSize;
    int predSize;
    int herbLife;
    int predLife;
    int food;
    String gender;
    int gChoice;
    double temp;
    int attacker;
    boolean attackDecide;
    int herbNum = 1;
    int predNum = 1;
    public Jurassic(){
        dino = new ArrayList<Dinosaur>();
        //Creating
        for(int i = 0; i < 50; i++){
            int herbHP = (int)(Math.random()*201)+50;
            int predHP = (int)(Math.random()*141)+45;
            int herbSpeed = (int)(Math.random()*41)+10;
            int predSpeed = (int)(Math.random()*46)+35;
            age = 1;
            int herbSval = (int)(Math.random()*16)+15;
            int predSval = (int)(Math.random()*26)+20;
            temp = predSval;
            int herbSize = (int)(Math.random()*371)+30;
            int predSize = (int)(Math.random()*201)+10;
            int herbLife = (int)(Math.random()*41)+20;
            int predLife = (int)(Math.random()*41)+15;
            int food = (int)(Math.random()*2)+1;
            gender = "";
            gChoice = (int)(Math.random()*2)+1;
            if(gChoice == 1)
                gender = "Male";
            else
                gender = "Female";
            if(food == 1){
                String herbName = "Veggienator" + herbNum;
                herbNum++;
                Dinosaur herb =  (new Herbivore( herbHP, herbSpeed, age, herbLife, herbSval, herbSize, herbName, gender));
                dino.add(herb);
            }
            else{
                String predName = "Beefosaurus" + predNum;
                predNum++;
                Dinosaur pred = (new Predator(predHP, predSpeed, age, predLife, predSval, herbSize, predName, gender));
                dino.add(pred);
            }
        }
        for(int i = 0; i < dino.size(); i++){
            System.out.println(dino.get(i).getName() + "\tHealth:" + dino.get(i).getHp() + "\tSpeed: " + dino.get(i).getSpeed() + "\tAge: " + dino.get(i).getAge() + "\tLife Span: " + dino.get(i).getLife() + "\tStarvation: " + dino.get(i).getStarve() + "\tSize: " + dino.get(i).getSize() + "\tGender: " + dino.get(i).getGender());
        }
        System.out.println("************************************************************************************************************************************");
        //Call first method
        LiveFreeOrDie();
    }

    //LiveFreeOrDie
    public void LiveFreeOrDie(){
        while(herbNum > 0 && predNum > 0){
            for(int i = dino.size() - 1; i >= 0; i--){
                dino.get(i).getOlder();
                int newStarve = dino.get(i).getStarve();
                if(dino.get(i) instanceof Herbivore){
                    dino.get(i).setStarvation((int)(dino.get(i).getStarve()*.03));
                }
                else{
                    dino.get(i).setStarvation((-(int)(dino.get(i).getStarve()*.03)));
                }
                dino.get(i).starve();
                if(dino.get(i).getHp() == 0){
                    if(dino.get(i) instanceof Herbivore){
                        herbNum--;
                    }
                    else{
                        predNum--;
                    }
                    dino.remove(i);
                }
            }
            //Mini Game Call
            int selectOne = (int)(Math.random()*dino.size());
            int selectTwo = (int)(Math.random()*dino.size());
            MiniGame(dino.get(selectOne), dino.get(selectTwo));
            System.out.println("Dinos Left:");
            for(int i = 0; i < dino.size(); i++){
                System.out.println(dino.get(i).getName() + "\tHealth:" + dino.get(i).getHp() + "\tSpeed: " + dino.get(i).getSpeed() + "\tAge: " + dino.get(i).getAge() + "\tLife Span: " + dino.get(i).getLife() + "\tStarvation: " + dino.get(i).getStarve() + "\tSize" + dino.get(i).getSize() + "\tGender: " + dino.get(i).getGender());
            }
            System.out.println();
            System.out.println("************************************************************************************************************************************");
        }
    }
    //MiniGame
    public void MiniGame(Dinosaur playerOne, Dinosaur playerTwo){
        //Intro
        System.out.println("Mini Game: ");
        System.out.println(playerOne.getName() + "\tHealth:" + playerOne.getHp() + "\tSpeed: " + playerOne.getSpeed() + "\tAge: " + playerOne.getAge() + "\tLife Span: " + playerOne.getLife() + "\tStarvation: " + playerOne.getStarve() + "\tSize" + playerOne.getSize() + "\tGender: " + playerOne.getGender());
        System.out.println(playerTwo.getName() + "\tHealth:" + playerTwo.getHp() + "\tSpeed: " + playerTwo.getSpeed() + "\tAge: " + playerTwo.getAge() + "\tLife Span: " + playerTwo.getLife() + "\tStarvation: " + playerTwo.getStarve() + "\tSize" + playerTwo.getSize() + "\tGender: " + playerTwo.getGender());
        //Herbivore-Herbivore
        if(playerOne instanceof Herbivore && playerTwo instanceof Herbivore){
            if(playerOne.getGender() != playerTwo.getGender()){
                System.out.println("Mating!");
                int gChoice = (int)(Math.random()*2)+1;
                if(gChoice == 1){
                    gender = "Male";
                }
                else{
                    gender = "Female";

                }
                String nHerbName = "";
                nHerbName = "nVeggienator" + herbNum;
                dino.add(new Herbivore(herbHP, herbSpeed, age, herbLife, herbSval, herbSize, nHerbName, gender));
            }
            playerOne.setStarvation(-(int)(playerOne.getStarve()*.6));
            playerTwo.setStarvation(-(int)(playerOne.getStarve()*.6));
        }
        //Predator-Predator
        if(playerOne instanceof Predator && playerTwo instanceof Predator) {
            if (((double)(( playerOne.getStarve() / 1.03)/playerOne.getStarve()) >= .8) || ((double) (playerTwo.getStarve() / 1.03)/playerOne.getStarve() >= .8)) {
                attackDecide = true;
            }
            if (playerOne.getGender() != playerTwo.getGender() && !attackDecide) {
                System.out.println("Mating!");
                if (gChoice == 1) {
                    gender = "Male";
                } else {
                    gender = "Female";
                }
                String nPredName = "";
                nPredName = "nBeefosaurus" + predNum;
                dino.add(new Predator(predHP, predSpeed, age, predLife, predSval, herbSize, nPredName, gender));
            }
            else if (attackDecide || playerOne.isStarving(predSval) || playerTwo.isStarving(predSval)) {
                if (playerOne.getStarve() > playerTwo.getStarve()) {
                    System.out.println("Player One Attacks Player Two!");
                    playerTwo.reducePoints(((Predator) playerOne).getDamagePred(predSize, age, predSpeed, predSval));
                    playerOne.reducePoints(((Predator) playerTwo).getDamagePred(predSize, age, predSpeed, predSval));
                } else {
                    System.out.println("Player Two Attacks Player One");
                    playerOne.reducePoints(((Predator) playerTwo).getDamagePred(predSize, age, predSpeed, predSval));
                    playerTwo.reducePoints(((Predator) playerOne).getDamagePred(predSize, age, predSpeed, predSval));
                }
                if (playerOne.getHp() != 0) {
                    System.out.println("Player One Survives with " + playerOne.getHp() + " health left");
                    playerOne.setStarvation((int) (playerOne.getStarve() * .1));
                }
                if (playerTwo.getHp() != 0) {
                    System.out.println("Player Two Survives with " + playerTwo.getHp() + " health left");
                    playerTwo.setStarvation((int) (playerTwo.getStarve() * .1));
                }
            }
        }
        else{
            if(playerOne instanceof Herbivore && playerTwo instanceof Predator){
                System.out.println("Player Two attacks Player One!");
                    playerOne.reducePoints(((Predator)playerTwo).getDamagePred(predSize, age, predSpeed, predSval));
                if(!((Herbivore)playerOne).runAway(herbSpeed, playerTwo.getSpeed())){
                    System.out.println("Player One attacks back!");
                    playerTwo.reducePoints(((Herbivore)playerOne).getDamageHerb(herbSize, age, herbSpeed, herbSval));
                }
                else System.out.println("Player One runs away!");
                if(playerOne.getHp() > 0){
                    System.out.println("Player One survives with " + playerOne.getHp() + " health!");
                    playerOne.setStarvation(-(int)(playerOne.getStarve()*.6));
                }
                if(playerOne.getHp() > 0){
                    System.out.println("Player Two survives with " + playerTwo.getHp() + " health!");
                    playerTwo.setStarvation((int)(playerTwo.getStarve()*.1));
                }
            }
            else if(playerOne instanceof Predator && playerTwo instanceof Herbivore){
                System.out.println("Player One attacks Player Two!");
                    playerTwo.reducePoints(((Predator)playerOne).getDamagePred(predSize, age, predSpeed, predSval));
                if(!((Herbivore)playerTwo).runAway(herbSpeed, playerOne.getSpeed())){
                    System.out.println("Player Two attacks back!");
                    playerOne.reducePoints(((Herbivore)playerTwo).getDamageHerb(herbSize, age, herbSpeed, herbSval));
                }
                else System.out.println("Player One runs away!");
                if(playerOne.getHp() > 0){
                    System.out.println("Player Two survives with " + playerTwo.getHp() + " health!");
                    playerTwo.setStarvation(-(int)(playerTwo.getStarve()*.6));
                }
                if(playerOne.getHp() > 0){
                    System.out.println("Player One survives with " + playerOne.getHp() + " health!");
                    playerOne.setStarvation((int)(playerOne.getStarve()*.1));
                }
            }
        }
    }
    public static void main(String[] args){
        Jurassic app = new Jurassic();
    }
}

/*
 herbHP, herbSpeed, age, herbSval, herbSize, herbLife, gender, herbName
 */
