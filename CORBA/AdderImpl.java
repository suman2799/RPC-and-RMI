import math_.Math.*;
import org.omg.PortableServer.*;
import org.omg.CORBA.*;

public class AdderImpl extends AdderPOA {
    private ORB orb;

    public void setORB(ORB orb_val) {
        orb = orb_val;
    }

    // Implement the add method
    public int add(int a, int b) {
        System.out.println("add(" + a + ", " + b + ") is called");
        return a + b;
    }
}
