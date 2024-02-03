import javax.naming.Context;
import javax.naming.InitialContext;
import java.util.Properties;
import java.rmi.*;

public class AddClient {
    public static void main(String args[]) throws Exception {
    	if (args.length != 3) {
			System.out.println("usage: java AddClient <number_1> <number_2> <packets>");
			System.exit(1);
		}

		Properties prop = new Properties();
		prop.put("java.naming.factory.initial", "com.sun.jndi.cosnaming.CNCtxFactory");
		prop.put("java.naming.provider.url", "corbaloc:iiop:localhost:20900/NameService");
		Context ctx = new InitialContext(prop);
		AddIntf obj = (AddIntf)ctx.lookup("add");

		// Number of iterations
		int iterations = Integer.parseInt(args[2]);

		// Initialize total time
		long totalTime = 0;

		for (int i = 0; i < iterations; i++) {

			// Record the start time
			long startTime = System.currentTimeMillis();

			// The procedure call
			int ret = obj.add(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
			System.out.println("Result:" + ret);

			// Record the end time
			long endTime = System.currentTimeMillis();

			// Calculate and print the elapsed time
			long elapsedTime = endTime - startTime;
			
			// Add to total time
			totalTime += elapsedTime;
		}

		// Calculate and print the average and total elapsed time
		long averageTime = totalTime / iterations;
		System.out.println("Average Elapsed Time for " + iterations + " iterations: " + averageTime + " milliseconds");
		System.out.println("Total Elapsed Time for " + iterations + " iterations: " + totalTime + " milliseconds");

    }
}
