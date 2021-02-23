import java.util.ArrayList;

public class AudiR8 extends Audi {

    private ArrayList<String> r8ownerList = new ArrayList<String>();;

    public AudiR8() {
        super("black", "white");
    }

    public static void useV8() {
        System.out.println("GO VROOOM VROOM");
    }

    public int changeWheelSize(int size) {
        System.out.println("Rim size before: " + super.wheelSize);
        System.out.println("These new rims rule!!!");
        super.wheelSize = size;
        return wheelSize;
    }

    public ArrayList<String> addNewCustomer(String customerName) { // overrides the super
        super.addNewCustomer(customerName);
        this.r8ownerList.add(customerName);
        System.out.println("R8 Owner List:");
        for (String customer : r8ownerList) {
            System.out.println(customer);
        }
        return this.r8ownerList;
    }
}
