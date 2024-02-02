import org.omg.CORBA.*;
import org.omg.CosNaming.*;
import org.omg.PortableServer.*;
import math_.Math.*;

public class AdderServer {
    public static void main(String[] args) {
        try {
            ORB orb = ORB.init(args, null);
            
            POA rootpoa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
            rootpoa.the_POAManager().activate();

            AdderImpl adderImpl = new AdderImpl();
            adderImpl.setORB(orb);

            org.omg.CORBA.Object ref = rootpoa.servant_to_reference(adderImpl);
            Adder href = AdderHelper.narrow(ref);

            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

            String name = "Adder";
            NameComponent[] path = ncRef.to_name(name);
            ncRef.rebind(path, href);

            System.out.println("AdderServer Ready and Waiting ...");

            orb.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
