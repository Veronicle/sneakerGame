/*
* We are creating a sneaker business simulation. 
User chooses how long they want to play the game for.
There are periodic sneaker releases, which provide the user opportunities to buy shoes to resell.
We will use concurrent programming to set a timer for suggested game time.
At the end of the game, the user statistics are shown for the inventory/sales of the user
*/

class BadInputException extends Exception {
  int s;
  BadInputException(int s) {
    this.s = s;
  }
  
  public String toString() {
    if (s < 1 || s > 7)
      return "\nPlease input a value in between 1-7, inclusive. You chose " + s + " days";
    return "\nThank you for inputting a value in between 1-7, inclusive. You chose " + s + " days";
  }
}

public class Console {
  
  public static void main(String[] args) {

    System.out.println("\n---");
    System.out.println(">--");
    System.out.println("->-");
    System.out.println("-->");
    System.out.println("--<");
    System.out.println("-<-");
    System.out.println("<--");
    System.out.println("---");

    
    int duration = 1;
    System.out.println("\nWelcome to the Sneaker Business Game! How many days do you want to play the game for? (1-7) ");
      duration = scannerH.araash.nextInt();
    do {
      try {
        if (duration < 1 || duration > 7) {
          System.out.println("\nPick a day period from 1-7");
          duration = scannerH.araash.nextInt();
          throw new BadInputException(duration);
        }
        } 
      catch(BadInputException x) {
        System.out.println(x.toString());
        }  
    } while (duration < 1 || duration > 7);
    
    scannerH.araash.nextLine(); 

    System.out.println("\nChoose a difficulty: easy or hard. ");
    String difficulty = scannerH.araash.nextLine();

    Game SuperSillyFunLand = new Game(duration, difficulty);// remember this name ;)

    SuperSillyFunLand.play();


    System.out.println("\nThank you for playing the sneaker business game!");

    // ASCII art for fun
    System.out.println("\n----|----");
    System.out.println("---|-|---");
    System.out.println("--|===|--");
    System.out.println("-|-----|-");
    System.out.println("--|===|--");
    System.out.println("---|-|---");
    System.out.println("----|----");
    
    
    
    }

    
  }

