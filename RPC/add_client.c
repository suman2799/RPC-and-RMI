/*
 * This is sample code generated by rpcgen.
 * These are only templates and you can use them
 * as a guideline for developing your own functions.
 */

#include "add.h"
#include "time.h"

void
add_prog_1(char *host, int x, int y)
{
	CLIENT *clnt;
	int  *result_1;
	numbers  add_1_arg;

#ifndef	DEBUG
	clnt = clnt_create (host, ADD_PROG, ADD_VERS, "udp");
	if (clnt == NULL) {
		clnt_pcreateerror (host);
		exit (1);
	}
#endif	/* DEBUG */

	// Add the numbers and print 

	add_1_arg.a=x;
	add_1_arg.b=y;
	result_1 = add_1(&add_1_arg, clnt);
	if (result_1 == (int *) NULL) {
		clnt_perror (clnt, "call failed");
	} else {
		printf("Result:%d\n", *result_1);
	}
#ifndef	DEBUG
	clnt_destroy (clnt);
#endif	 /* DEBUG */
}


int
main (int argc, char *argv[])
{
	char *host;

	if (argc < 5) {
		printf ("usage: %s server_host <number_1> <number_2> <packets>\n", argv[0]);
		exit (1);
	}
	host = argv[1];
	
	// Number of iterations
	int iterations = atoi(argv[4]);
	
	// Initialize total time
	double total_time = 0;
	
 	for (int i = 0; i < iterations; i++) {
		// Record the start time	
		clock_t start_time = clock();

		// RPC call
		add_prog_1 (host, atoi(argv[2]), atoi(argv[3]));

		// Record the end time
		clock_t end_time = clock();

		// Calculate and print the elapsed time in milliseconds
		double elapsed_time = ((double)(end_time - start_time) * 1000.0) / CLOCKS_PER_SEC;
		
		// Add to total time
        total_time += elapsed_time;
	}
	
	// Calculate the average time
	double average_time = total_time / iterations;

	printf("Average Elapsed Time for %d iterations: %.3f milliseconds\n", iterations, average_time);
	printf("Total Elapsed Time for %d iterations: %.3f milliseconds\n", iterations, total_time);
	
	exit (0);
}