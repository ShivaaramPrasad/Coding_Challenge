package week.one;

import java.util.Scanner;

public class Bottle_Exchnage {

	public static void main(String[] args) {
		

		int noOfCoffeeBottles=15;
		
		int noOfExchange=4;
		
	     Scanner in = new Scanner(System.in);

	     System.out.println("No of Coffee Bottles : ");
	     noOfCoffeeBottles = in.nextInt();
	     System.out.println("No of Exchange : ");
	     noOfExchange = in.nextInt();

		System.out.println("No of Coffee Bottles : " + noOfCoffeeBottles);
		System.out.println("No of Exchange : " + noOfExchange);

        int emptyBottles = 0;
        int newBottles = 0;
        int totalBottlesYouCanDrink = noOfCoffeeBottles;


        while (noOfCoffeeBottles >= noOfExchange)
        {
            //Split full bottles
            emptyBottles = noOfCoffeeBottles;
            newBottles = 0;

            while (emptyBottles >= noOfExchange)
            {
                emptyBottles = emptyBottles - noOfExchange;
                newBottles++;
            }
            totalBottlesYouCanDrink = totalBottlesYouCanDrink + newBottles;
            noOfCoffeeBottles = emptyBottles + newBottles;

        }
        
		System.out.println("Total No of Coffee Bottles: " + totalBottlesYouCanDrink);
	}

}
