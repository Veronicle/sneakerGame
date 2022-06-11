import java.util.InputMismatchException;

public class SneakerPair {

  private int releaseDay;
  private double retailPrice, size, marketValue, goalROI;
  private String model; 

  public SneakerPair(double rP, double s, double g, int rD, String mo) {
    retailPrice = rP;
    size = s;
    marketValue = rP; // market value starts out as retail value
    goalROI = g;
    releaseDay = rD;
    model = mo;

    // need to ask this 
    
    do {
      System.out.println("\nWhat is the current value ($) of " + model + "? (100-1000)");
    try {
        marketValue = scannerH.araash.nextDouble();
        if(marketValue < 100 || marketValue > 1000) {
          System.out.println("\nNot a valid Market Value.");
      }
        }
      catch(InputMismatchException e) {
        System.out.println("\nMust enter a double value.");
      }
    } while(marketValue < 100 || marketValue > 1000);
    System.out.println("\nYou entered $" + marketValue);
  }
  

  public void updateMarketValue() {
    do {
      System.out.println("What is the current market price of the pair? " + toString());
      try {
        marketValue = scannerH.araash.nextDouble();
        if(marketValue < 100 || marketValue > 1000) {
          System.out.println("Not a valid Market Value.");
      }
        }
      catch(InputMismatchException e) {
        System.out.println("Must enter a double value.");
      }
    } while(marketValue < 0 || marketValue > 1000);
    System.out.println("You entered " + marketValue);
  }

  public double getRetailPrice() {
    return retailPrice;
  }

  public double getMarketPrice() {
    return marketValue;
  }

  public void updateMarketValue(double percentLeft) {
    marketValue *= percentLeft; 
  }
  
  public double getSize() {
    return size;
  }

  public String toString() {
    return ("\nModel: " + model + "\nSize: " + size + "\nFrom Day " + releaseDay + "\n"); 
  }

  public boolean sellTime () {
    if (((Math.abs(retailPrice - marketValue))/retailPrice) * 100 >= goalROI)
      return true;
    return false;
  }
}
