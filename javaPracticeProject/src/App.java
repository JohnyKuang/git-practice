import java.util.Arrays;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        // scannerFunction();
        // primVsRefComparison();
        AudiR8 aAudiR8 = new AudiR8();
        System.out.println(aAudiR8.getManufacturer());

    }

    public static void scannerFunction() {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Please enter full name: ");
        String fullName = keyboard.nextLine();
        System.out.print("Please enter your height: ");
        double height = keyboard.nextDouble();
        System.out.print("Please enter your age: ");
        int age = keyboard.nextInt();
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
}