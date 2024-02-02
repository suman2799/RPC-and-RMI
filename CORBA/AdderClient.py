import sys
import timeit
import time
from omniORB import CORBA, PortableServer
import CosNaming
import Math

def main():
    if len(sys.argv) < 4:
        print("Usage: python3 AdderClient.py <number_1> <number_2> <packets>")
        sys.exit(1)

    number1 = int(sys.argv[1])
    number2 = int(sys.argv[2])

    orb = CORBA.ORB_init(sys.argv, CORBA.ORB_ID)

    # Resolve the initial NamingContext using the default "NameService" name
    objRef = orb.resolve_initial_references("NameService")
    ncRef = objRef._narrow(CosNaming.NamingContext)

    try:
        # Resolve the object using the specified name
        name = [CosNaming.NameComponent("Adder", "")]
        obj = ncRef.resolve(name)     
    except CORBA.ORB.InvalidName:
        print("Object named", name, "not found")
        sys.exit(1)

    adder = obj._narrow(Math.Adder)

    if adder is None:
        print("Object reference is not an Adder")
        sys.exit(1)

    # Number of iterations
    iterations = int(sys.argv[3])
    
    # Toatl time initially
    total_time = 0
    
    for _ in range(iterations):
        # Measure execution time for each iteration
        start_time = time.time()

        # Call the procedure
        result = adder.add(number1, number2)
        print("Result:", result)
	
        end_time = time.time()
        execution_time = (end_time - start_time) * 1000  # Convert to milliseconds

        total_time += execution_time

    # Calculate and print the avg and total execution time 
    avg_time = total_time / iterations 

    print(f"Average Elapsed Time for {iterations} iterations: {avg_time} milliseconds")
    print(f"Total Elapsed Time for {iterations} iterations: {total_time} milliseconds")

if __name__ == "__main__":
    main()

