import java.util.InputMismatchException;
public class Game {
 
  private int duration, capital;
  private String difficulty;
  public static String[] models = {"Jordan 4", "Yeezy 350", "Crocs Clog", "Reebok Omni", "Nike Dunk", "Jordan 1", "Jordan 11"};
  public static int[] prices = {150, 175, 200, 225, 250}; 
  // models and prices are two arrays with sample information that the game can use when describing a shoe that is releasing
  public static double[] sizes = {6, 6.5, 7, 7.5, 8, 8.5, 9, 9.5, 10, 10.5, 11, 11.5, 12, 12.5, 13};
  private SneakerInventory database; 

  public Game (int d, String difficulty) { 
    duration = d; 
    capital = 300 + (duration)*100;
    database = new SneakerInventory();
    this.difficulty = difficulty; 
  }

  public void play() {

    new Timer1(duration);
    int total = duration * 30;
    System.out.println("\nTimer Started. You have a total of " + total + " seconds.");

    int status = 0;
    
    while (status < duration) { 
      
      status++; 
      
      String model = models[(int)(Math.random() * 6)];
      int modelPrice = prices[(int)(Math.random() * 5)];
      double size =  sizes[(int)(Math.random() * 15)];
    
      boolean willBuy = true;
      boolean sell = true;
      
      System.out.println("\nHello, user! Today is Day " + status + ". Your current capital is $" + capital + ". The release of the day is the " + model + ", which is retailing at $" + modelPrice + ". Do you want to buy this pair? Answer yes/no.");
      String ans = scannerH.araash.nextLine();

      while (!(ans.equalsIgnoreCase("yes") || ans.equalsIgnoreCase("no"))) {
        System.out.println("\nPlease answer yes or no: ");
        ans = scannerH.araash.nextLine();
      }
      
      if (ans.equalsIgnoreCase("no"))
        willBuy = false; // willBuy defaulted to true in instantiation

      else
        willBuy = true;
      

    if (willBuy) {
            
      if (capital >= modelPrice) {
        double roi = 0;
          do {
            System.out.println("\nWhat is your goal ROI for this sneaker? (in %) ");
            try {
              roi = scannerH.araash.nextDouble();
              if(roi < 0) { // return on investment can be above 100
                System.out.println("Not a valid ROI Value.");
              }
            }
      catch(InputMismatchException value2) {
        System.out.println("Must enter a double value.");
      }
    } while(roi < 0);
        
    System.out.println("You entered " + roi + "%");
        SneakerPair temp = new SneakerPair(modelPrice, size, roi, status, model);
        database.buySneaker(temp);
        capital -= temp.getRetailPrice();
        scannerH.araash.nextLine();
      }
      
      else 
        System.out.println("\nYou do not have enough money.");     
    }

    System.out.println("\nWould you like to sell any shoes? Answer yes/no. "); 
      
      String ans2 = scannerH.araash.nextLine();

      while (!(ans2.equalsIgnoreCase("yes") || ans2.equalsIgnoreCase("no"))) {
        System.out.println("\nPlease answer yes or no: ");
        ans2 = scannerH.araash.nextLine();
      }
      if (ans2.equalsIgnoreCase("no"))
        sell = false; // willBuy defaulted to true in instantiation
    

    if (sell && database.getInventory().size() >= 1) {
      System.out.println("\nHere are your options:\n");
      for (int i = 0; i < (database.getInventory().size()); i++) {
        System.out.println("Shoe " + (i + 1) + ":" + database.getInventory().get(i));
      }
      System.out.print("\nWhich shoe do you want to sell? \nRespond with number of the shoe: ");
      int option = scannerH.araash.nextInt();
      int index = option - 1; // shoe #1 has an index 0
      System.out.println("\nBy the way, it is " + database.getInventory().get(index).sellTime() + " that shoe #" + (option) + " should be sold, based on an ideal ROI.");
      capital += database.getInventory().get(index).getMarketPrice(); 
      database.sellSneaker(database.getInventory().get(index));
    }

      else if (sell && database.getInventory().size() < 1) {
        System.out.println("\nYou have no shoes to sell right now...");
      }

    if (difficulty.equalsIgnoreCase("hard")) { // a hard difficulty involves events in real life that can affect 
      int chance = (int)(Math.random() * 20) + 1; // rand # from 1 - 20
      int chanceComparison = (int)(Math.random() * 20) + 1; // rand # from 1 - 20

      if (chance == 20 && chanceComparison == 20) {
        System.out.println("There is a zombie apocalypse. Zombies have robbed sneaker corporations. All aftermarket sneaker values have gone down by 30% "); 
          for (int i = 0; i < database.getInventory().size(); i++) {
            database.getInventory().get(i).updateMarketValue(0.7);
          }
      }

      else if (chance < chanceComparison) {
        capital*=0.85; 
        System.out.println("\nOh no! Tax season. Your capital has decreased by 15%. Current capital: $" + capital);
      }

      else if (chance > chanceComparison) {
        capital*=0.5;
        System.out.println("\nI have terrible news for you! Your family needs money immediately - they are being threatened by the Chinese government. Sending 35% of your capital to them. Current capital: $" + capital);        
        }

      else {
        capital += 1500;
        System.out.println("\nWho knew hard mode could reward you? Consider yourself lucky. The government just sent a stimulus check to you. Adding $1,500 to your capital. Current capital: $" + capital); 
      }
    }
      
    System.out.println("\nAt the end of day " + status + ", here is the information. " + database.giveStatistics() + "Your current capital is $" + capital + ". Your profit is $" + database.getProfit() + ". "); 
    database.displayCurrentROI(); 
    database.displaySoldROI();
    System.out.println("\n<-----NEXT DAY----->");

        } 
        System.out.println("\nAt the end of this game, here are the shoes that you still have:\n" + database.getInventory() + "\nHere are the shoes that you have sold \n" + database.getSoldInventory());
  }
}
