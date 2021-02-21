import java.util.ArrayList;

public class Audi {
    public int wheelSize;
    private static String manufacturer = "Audi Japan";// class variable; changing this changes all
    public String color1; // instance variable; only changes the particular instance of the class
    public String color2;
    private static ArrayList<String> ownerList = new ArrayList<String>();

    public Audi() {
        this.wheelSize = 33;
        this.color1 = "blank";
        this.color2 = "blank";
    }

    public Audi(String color1, String color2) {
        this(); // this will call the default contructor first
        this.color1 = color1;
        this.color2 = color2;
    }

    public void paintCar(String newColor) {
        color1 = newColor;
    }

    public void paintCar(String newColor1, String newColor2) { // overloads other paintCar(x) if 2 arguments are passed
        color1 = newColor1;
        color2 = newColor2;
    }

    public int changeWheelSize(int size) {
        System.out.println("These rims are ok");
        wheelSize = size;
        return wheelSize;
    }

    public static String getManufacturer() {// static methods can be accessed both by instances and non-instances; can't
                                            // be overidden
        return manufacturer;
    }

    public ArrayList<String> addNewCustomer(String customerName) {
        this.ownerList.add(customerName);
        System.out.println("Audi Owner List:");
        for (String customer : ownerList) {
            System.out.println(customer);
        }
        return this.ownerList;
    }
}
