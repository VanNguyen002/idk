# FirstName LastName
# CSC 380, section 001

import time
import random
import csv
from select_medians import select_medians
from select_randomized import select_randomized

def benchmark_selection_algorithms():
    """
    Benchmark randomized select vs median of medians select for finding the median.
    Tests on various input sizes and saves results to CSV.
    """
    # Input sizes to test
    sizes = [100, 300, 500, 700, 1000, 3000, 5000, 7000, 10000, 
             30000, 50000, 70000, 100000, 300000, 500000]
    
    # Number of trials for each size
    num_trials = 3
    
    # Open CSV file for writing results
    with open('benchmark_results.csv', 'w', newline='') as csvfile:
        fieldnames = ['size', 'method', 'trial', 'runtime']
        writer = csv.DictWriter(csvfile, fieldnames=fieldnames)
        writer.writeheader()
        
        # Test each input size
        for size in sizes:
            print(f"\nTesting size: {size}")
            
            # Run multiple trials
            for trial in range(1, num_trials + 1):
                print(f"  Trial {trial}...")
                
                # Generate random array with integers from 1 to size * 10
                original_array = [random.randint(1, size * 10) for _ in range(size)]
                
                # Calculate which element is the median (middle element)
                median_position = (size + 1) // 2
                
                # Test randomized select
                array_copy = original_array.copy()
                start = time.time()
                result_randomized = select_randomized(array_copy, 0, size - 1, median_position)
                runtime_randomized = time.time() - start
                
                writer.writerow({
                    'size': size,
                    'method': 'randomized',
                    'trial': trial,
                    'runtime': runtime_randomized
                })
                
                # Test median of medians select
                array_copy = original_array.copy()
                start = time.time()
                result_medians = select_medians(array_copy, 0, size - 1, median_position)
                runtime_medians = time.time() - start
                
                writer.writerow({
                    'size': size,
                    'method': 'median_of_medians',
                    'trial': trial,
                    'runtime': runtime_medians
                })
                
                print(f"    Randomized: {runtime_randomized:.6f}s")
                print(f"    Median of Medians: {runtime_medians:.6f}s")
    
    print("\nBenchmarking complete! Results saved to 'benchmark_results.csv'")

if __name__ == "__main__":
    print("Starting benchmark of selection algorithms...")
    print("This may take a few minutes for larger input sizes.\n")
    benchmark_selection_algorithms()