import java.util.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import java.rmi.*;

public class AddServer {
   public static void main(String args[]) throws Exception {
          AddImpl obj = new AddImpl();
          Properties prop = new Properties();
          prop.put("java.naming.factory.initial", "com.sun.jndi.cosnaming.CNCtxFactory");
          prop.put("java.naming.provider.url", "corbaloc:iiop:localhost:20900/NameService");
          Context ctx = new InitialContext(prop);
          ctx.rebind("add",obj);
          System.out.println("Server Ready…….");
   }
}
