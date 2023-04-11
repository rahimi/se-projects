import java.util.Scanner;
import debugging.*;

public class Main {
  public static void main(String[] args) {
    System.out.println("Pick excercise to run:");
    System.out.println("1:\tDebugging");
    Scanner sc = new Scanner(System.in);
    String input = sc.nextLine();
    switch (input) {
      case "1":
        DebuggingRuntimeException.main(new String[] {});
        break;
    }
  }
}