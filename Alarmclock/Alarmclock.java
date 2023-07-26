import java.util.Scanner;

public class Alarmclock {
  public static void main(String[] args) {

    String usertime;
    int H = 0;
    int M = 0;
    int time;

    Scanner scan = new Scanner(System.in);

    try {
      System.out.println("Enter time in 24 hour notation sparated by a space: ");
      usertime = scan.nextLine();
      H = Integer.parseInt(usertime.split(" ")[0]);
      M = Integer.parseInt(usertime.split(" ")[1]);

      if (H >= 0 && H <= 23) {
        if (M >= 0 && M <= 59) {
          time = H * 60 + M;
          time -= 45;
          H = time / 60;
          M = time % 60;
          System.out.println("Time set back 45 minutes is: " + H + ":" + M);
        } else {
          System.out.println("Invalid Input, Try Again");
        }
      } else {
        System.out.println("Invalid Input, Try Again");
      }
    } catch (NumberFormatException exception) {
      System.out.println("Invalid Input, Try Again");
    } catch (ArrayIndexOutOfBoundsException exception) {
      System.out.println("Invalid Input, Try Again");
    } finally {
      scan.close();
    }
  }
}