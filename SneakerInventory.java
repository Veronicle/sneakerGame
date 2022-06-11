import java.util.ArrayList;

/*
* This will model the sneakers the user has 
*/

public class SneakerInventory {
  private double retailValue, marketValue, Profit, oldRetailValue, oldMarketValue;
  private ArrayList<SneakerPair> arr, arr2;

  public void retailValueReset() {
    retailValue = 0;
  }

  public void marketValueReset() {
    marketValue = 0;
  }
  
  public SneakerInventory() {
    arr = new ArrayList<SneakerPair>(); 
    arr2 = new ArrayList<SneakerPair>();
  }

  public void buySneaker(SneakerPair A) {
    arr.add(A);
  }

  public void sellSneaker(SneakerPair B) {
    arr2.add(B);
    
    arr.remove(B);
  }

  public void calculateOldValues() {
    oldMarketValue = 0;
    oldRetailValue = 0;
    for (int i = 0; i < arr2.size(); i++) {
      oldMarketValue += arr2.get(i).getMarketPrice();
      oldRetailValue += arr2.get(i).getRetailPrice();
   }
  }

  public ArrayList<SneakerPair> getInventory() {
    return arr;
  }

  public ArrayList<SneakerPair> getSoldInventory() {
    return arr2;
  }

  public double calculateRetailValue() { //call this every time 
    retailValueReset();
    for (int i = 0; i < arr.size(); i++) {
      retailValue += (arr.get(i)).getRetailPrice();
    }
    return retailValue;
    }
  
  public double calculateMarketValue() {
    marketValueReset();
    for (int i = 0; i < arr.size(); i++) {
      marketValue += (arr.get(i)).getMarketPrice();
    }
    return marketValue;
  } 

  public void displayCurrentROI() {
    if (arr.size() > 0) {
    marketValue = calculateMarketValue();
    retailValue = calculateRetailValue();
    double roi = 100 * (marketValue - retailValue)/retailValue; // percent form
    System.out.printf("\nThe average return on investment for the current inventory is: %.2f%%.", roi);  
    }

    else {
      System.out.println("\nYou have no shoes in your current inventory to provide statistics for.");
    }
    
    }

  public void displaySoldROI() {
    if (arr2.size() > 0) {
      calculateOldValues();
      try {
        double roi = 100 * (oldMarketValue - oldRetailValue)/oldRetailValue;
        System.out.printf("\nThe average return on investment for the sold inventory is %.2f%%.\n", roi);
      }
      catch(ArithmeticException ex) {
          System.out.println("You cannot divide by zero and the Old Retail Value is 0");
      }
    }

    else {
      System.out.println("\nYou have no sold shoes to calculate statistics for.");
    }
    
  }

  public void sneakersToSell() { // check the use-case for this program
    for (int i = arr.size() - 1; i >= 0; i--) {
      if (arr.get(i).sellTime()) {
        arr2.add(arr.get(i));
        sellSneaker(arr.get(i));
      }
    }
    
    retailValue = calculateRetailValue();
    marketValue = calculateMarketValue();

    for (int a = 0; a < arr2.size(); a++) {
      Profit += arr2.get(a).getMarketPrice() - arr2.get(a).getRetailPrice(); 
  
    }
  }

  public void calculateProfit() {
    Profit = 0; // reset profit, then update it
    calculateOldValues();
    Profit += oldMarketValue - oldRetailValue;
    }

  public double getProfit() {
    calculateProfit();
    return Profit;
  }

  public String giveStatistics() {
    return ("\nYou have " + arr.size() + " pairs of shoes in your inventory. You have sold " + arr2.size() +  " pairs of shoes already. ");
  }
  
  }
