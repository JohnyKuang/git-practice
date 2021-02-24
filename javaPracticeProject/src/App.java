import java.io.InputStream;
import java.lang.ProcessBuilder.Redirect.Type;
import java.util.Arrays;
import java.util.Scanner;

import package1.*;

public class App {
    public static void main(String[] args) throws Exception {
        scannerFunction();
        // primVsRefComparison();

        // // playing with classes
        // AudiR8 aAudiR8 = new AudiR8();
        // // Audi aAudiR8 = new AudiR8(); //legal since AudiR8 is subclass of Audi
        // aAudiR8.useV8();
        // aAudiR8.addNewCustomer("Jim");
        // System.out.println("New rim size on R8: " + aAudiR8.changeWheelSize(50));
        // Audi someRandomAudi = new Audi("red", "blue");
        // System.out.println("Default rim size: " + someRandomAudi.wheelSize);
        // someRandomAudi.addNewCustomer("Jan");
        // System.out.println("Number of Audi owners: " +
        // someRandomAudi.addNewCustomer("Pam").size());

        // exceptionCatching();
        // switchStatements();

    }

    public static void scannerFunction() {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Please enter full name: ");
        String fullName = keyboard.nextLine();
        System.out.print("Please enter your height: ");
        double height = keyboard.nextDouble();
        System.out.print("Please enter your age: ");
        int age = 0;
        boolean valid = false;
        while (!valid) {
            try {
                age = keyboard.nextInt();
                if (age >= 0) {
                    valid = true;
                }
            } catch (Exception e) {
                System.out.println(e);
                keyboard.nextLine();
                System.out.print("Please input a number: ");
            }
        }

        keyboard.close();
        System.out.println(
                "My name is " + fullName + ", I am " + Math.abs(height) + "cm tall and " + age + " years old.");
    }

    public static void primVsRefComparison() {
        int array1[] = { 1, 2, 3, 4, 5 }; // arrays are reference (object) types
        int array2[] = { 1, 2, 3, 4, 5 };
        System.out.println(array1 == array2); // shallow comparison
        System.out.println(array1.equals(array2)); // still only compares pointers
        System.out.println(Arrays.equals(array1, array2)); // compare contents of array
        array2 = array1; // pointing to same area now
        System.out.println(array1 == array2);

        System.out.println("Strings");
        String a = "coffee";
        String b = "coffee";
        String c = new String("coffee");
        System.out.println(a == b);
        System.out.println(a == c);
        System.out.println(a.equals(c)); // deep comparison when comparing strings
    }

    public static void exceptionCatching() {
        try {
            int division = 10 / 0;
        } catch (ArithmeticException e) {
            System.out.println(e);
        } catch (Exception e) {
            System.out.println("We can run this line instead of program blowing up");
        } catch (Throwable e) { // catches error OR exception
            System.out.println(e);
        }
        // throw new ArrayIndexOutOfBoundsException("don't do that"); //throw an
        // exception instead of catching one
    }

    public static void switchStatements() {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Please input your letter grade: ");
        String letterGrade = keyboard.next();
        keyboard.close();
        switch (letterGrade) {
            case "A":
                System.out.println("Excellent!");
                break;
            case "B":
                System.out.println("Great!");
                break;
            case "C":
                System.out.println("Satisfactory");
                break;
            default:
                System.out.println("Fail");
                break;
        }
    }
}
