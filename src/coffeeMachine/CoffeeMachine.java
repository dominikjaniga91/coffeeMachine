package coffeeMachine;

import java.util.Scanner;

public class CoffeeMachine {

    public static void main(String[] args) {

        Coffee coffee =new Coffee();

        coffee.coffeeMachine();

    }
}

class Coffee {

    Scanner scan = new Scanner(System.in);

    private int waterAvailable = 400;
    private int milkAvailable = 540;
    private int coffeeBeansAvailable = 120;
    private int disposableCups = 9;
    private int moneyAvailable = 550;

    // the coffee machine needs 200 ml of water, 50 ml of milk, and 15 g

    private void getCoffeeMachineIngredients(){

        System.out.println("The coffee machine has: ");
        System.out.println(waterAvailable + " of water");
        System.out.println(milkAvailable + " of milk");
        System.out.println(coffeeBeansAvailable + " of coffee beans");
        System.out.println(disposableCups + " of disposable cups");
        System.out.println(moneyAvailable + " of money");

    }

    void coffeeMachine() {


        while(true) {

            System.out.println("Write action (buy, fill, take, remaining, exit): ");
            String action = scan.nextLine();

            if ("buy".equals(action)) {
                buy();
            } else if ("fill".equals(action)) {
                fill();
            } else if ("take".equals(action)) {
                take();
            }else if("remaining".equals(action)){
                remaining();
            }else if("exit".equals(action)){
                break;
            }else{
                System.out.println("niepoprawne polecenie");
            }
        }
    }

    private void buy() {

        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino,  back - to main menu:");
        String buyAction = scan.nextLine();

        while(true) {
            if ("1".equals(buyAction)) {
                makeEspresso();
                break;
            } else if ("2".equals(buyAction)) {
                makeLatte();
                break;
            } else if ("3".equals(buyAction)) {
                makeCappuccino();
                break;
            } else {
                break;
            }
        }

    }

    private void fill() {

        System.out.println("Write how many ml of water do you want to add:");
        int addWater = scan.nextInt();
        System.out.println("Write how many ml of milk do you want to add:");
        int addMilk = scan.nextInt();
        System.out.println("Write how many grams of coffee beans do you want to add:");
        int addCoffeeBeans = scan.nextInt();
        System.out.println("Write how many disposable cups of coffee do you want to add:");
        int addDisposableCups = scan.nextInt();

        waterAvailable += addWater;
        milkAvailable += addMilk;
        coffeeBeansAvailable += addCoffeeBeans;
        disposableCups += addDisposableCups;
    }

    private void take() {

        System.out.println("I gave you " + moneyAvailable);
        moneyAvailable = 0;
        getCoffeeMachineIngredients();


    }

    private void remaining(){

        getCoffeeMachineIngredients();
    }

    private void makeEspresso(){
        if(waterAvailable >= 250 && coffeeBeansAvailable >= 16 && disposableCups >= 1) {
            waterAvailable -= 250;
            coffeeBeansAvailable -= 16;
            moneyAvailable += 4;
            disposableCups--;
            System.out.println("I have enough resources, making you a coffee!");
        }else if( waterAvailable < 250 ){
            System.out.println("Sorry, not enough water!");
        }else if( coffeeBeansAvailable < 16 ){
            System.out.println("Sorry, not enough coffee beans!");
        }else if( disposableCups == 0 ){
            System.out.println("Sorry, not enough disposable cups!");
        }
    }
    private void makeLatte(){
        if(waterAvailable >= 350 && milkAvailable >= 75 && coffeeBeansAvailable >= 20 && disposableCups >= 1) {
            waterAvailable -= 350;
            milkAvailable -= 75;
            coffeeBeansAvailable -= 20;
            moneyAvailable += 7;
            disposableCups--;
            System.out.println("I have enough resources, making you a coffee!");
        }else if( waterAvailable < 250 ){
            System.out.println("Sorry, not enough water!");
        }else if( milkAvailable < 75 ){
            System.out.println("Sorry, not enough milk!");
        }else if( coffeeBeansAvailable < 16 ){
            System.out.println("Sorry, not enough coffee beans!");
        }else if( disposableCups == 0 ){
            System.out.println("Sorry, not enough disposable cups!");
        }
    }
    private void makeCappuccino(){
        if(waterAvailable >= 200 && milkAvailable >= 100 && coffeeBeansAvailable >= 12 && disposableCups >= 1) {
            waterAvailable -= 200;
            milkAvailable -= 100;
            coffeeBeansAvailable -= 12;
            moneyAvailable += 6;
            disposableCups--;
            System.out.println("I have enough resources, making you a coffee!");
        }else if( waterAvailable < 200 ){
            System.out.println("Sorry, not enough water!");
        }else if( milkAvailable < 100 ){
            System.out.println("Sorry, not enough milk!");
        }else if( coffeeBeansAvailable < 12 ){
            System.out.println("Sorry, not enough coffee beans!");
        }else if( disposableCups == 0 ){
            System.out.println("Sorry, not enough disposable cups!");
        }
    }

}
