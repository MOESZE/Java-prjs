import java.util.*;

public class game {
  static int S;
  static int head, tail;

  public static void main(String agrs[]) {
    try {
      Scanner sc = new Scanner(System.in);
      int movechoice;
      System.out.println("This Game is Called Pypy Vs. Hydra\n");
      System.out.println("The only way to win is to cut off all the heads and tails of the Hydra");
      System.out.println("Your moves and rules are described below:");
      System.out.println("Move 1, cut off one hydra head, but a new head grows immediately\n" + "Move 2, cut off one of hydra's tails, two new tails grow immediately\n" + "Move 3, cut off exactly two of hydra's heads, nothing else happens\n" + "Move 4, cut off exactly two of hydra's tails, a new head grows immediately\n"+ "Remeber, the moves above can only be used if there are sufficient heads and tails");
      System.out.println("Choose how many heads to start the hydra: ");
      head = sc.nextInt();
      System.out.println("Choose how many tails to start the hydra: ");
      tail = sc.nextInt();

      while(head > 0 || tail > 0)
      {
        System.out.println("Enter 1, cut off one of hydra's heads\n" + "Enter 2, cut off on of hydra's tails\n" + "Enter 3, cut off two of hydra's heads\n" + "Enter 4, cut off two of hydra's tails\n" + "Enter 5, for Quit");
        System.out.println("\nChoose Move: ");
        movechoice = sc.nextInt();

        if(movechoice > 0 && movechoice < 6)
        {
          if(movechoice == 5) {
            S = -1;
            break;
          }
          else if(movechoice == 1) {
            if(head > 0)
            {
              S++;
            }
            else {
              System.out.println("Cannot perform this move, no Hydra head left");
            }
          }
          else if(movechoice == 2) {
            if(tail > 0)
            {
              S++;
              tail++;
            }
            else {
              System.out.println("Cannot perform this move, no hydra tail left");
            }
          }
          else if(movechoice == 3) {
            if(head >= 2)
            {
              S++;
              head = head-2;
            }
            else {
              System.out.println("Cannot perform this move");
            }
          }
          else {
            if(tail > 1)
            {
              S++;
              tail = tail-2;
              head++;
            }
            else {
              System.out.println("Cannot perform this move, no hydra head left");
            }
          }
        }
        else {
          System.out.println("Invalid Moves");
        }
        System.out.println("\n Hydra Head= " + head + " Tail= " + tail + " Remain\n");
      }
      if(S==-1) 
      System.out.println("It is impossible to kill hydra");
      else {
        System.out.println("You killed hydra in " + S + " moves");
      }
    }
    catch(Exception e)
    {
      System.out.println("Error is "+e);
    }
  }
}