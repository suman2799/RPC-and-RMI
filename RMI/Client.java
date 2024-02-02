// create client application

import java.rmi.*;

public class Client {
	public static void main (String args[]) {
		if (args.length < 4) {
			System.out.println("usage: java Client <server_host> <number_1> <number_2> <packets>");
			System.exit(1);
		}

		try {
			AddServerInterface st = (AddServerInterface)Naming.lookup("AddService");
			
			// Number of iterations
			int iterations = Integer.parseInt(args[3]);

			// Initialize total time
			long totalTime = 0;
			
			for (int i = 0; i < iterations; i++) {
				
				// Record the start time
				long startTime = System.currentTimeMillis();

				// Call procedure sum()
				int val = st.sum(Integer.parseInt(args[1]), Integer.parseInt(args[2]));
				System.out.println("Result:"+val);

				// Record the end time
				long endTime = System.currentTimeMillis();

				// Calculate and print the elapsed time
				long elapsedTime = endTime - startTime;
				
				// Add to total time
                totalTime += elapsedTime;
            }

            // Calculate and print the average elapsed time
			long averageTime = totalTime / iterations;
			System.out.println("Average Elapsed Time for " + iterations + " iterations: " + averageTime + " milliseconds");
			System.out.println("Total Elapsed Time for " + iterations + " iterations: " + totalTime + " milliseconds");

		} catch (Exception e) {
			System.out.println(e);
		}
	}
}

