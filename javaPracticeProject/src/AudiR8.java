public class AudiR8 {
    private static int wheelSize = 33; // class variable; changing this changes all
    private static String manufacturer = "Audi Japan";
    public String color; // instance variable; only changes the particular instance of the class

    public AudiR8() {
    }

    public void paintCar(String newColor) {
        color = newColor;
    }

    public static int changeWheelSize(int size) { // static methods can be accessed both by instances and non-instances
        wheelSize = size;
        return wheelSize;
    }

    public String getManufacturer() {
        return manufacturer;
    }

}
