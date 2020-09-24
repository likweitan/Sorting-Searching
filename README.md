# Sorting-Searching

## Part A

In this assignment, you will create a program that allows the user to choose between the following menu choices for a Book Store.
1. Linear Search
2. Binary Search
a. Bubble Sort
b. Selection Sort
5. Quit

You have the following information available in your stock (information is stored in the form of parallel arrays): 

-	String[] bookTitle = {“Starting out with Java”, “Java Programming”, “Software Structures”, “Design and Analysis of Algorithms”, “Computer Graphics”, “Artificial Intelligence: A Modern Approach”, “Probability and Statistics”, “Cognitive Science”, “Modern Information Retrieval”, “Speech and Language Processing”};

-	int[] bookID = {1101, 1211, 1333, 1456, 1567, 1642, 1699, 1755, 1800, 1999};

-	double[] bookPrice = {112.32, 73.25, 54.00, 67.32, 135.00, 173.22, 120.00, 42.25, 32.11, 123.75}; 

First display() the above information to the user in a tabular format. Your program should then ask for the book ID and the number of books the user wishes to purchase. Based on the book ID provided by the user, display the following information (if the ID is found):
-	Book ID
-	Book Title
-	Number of books bought
-	Total cost of the purchase

If the book ID is not found, display a message saying so. The book ID needs to be searched based on linearSearch() or binarySearch() based on user choice from the menu. For binarySearch() user can choose either bubbleSort() or selectionSort() to sort bookID array.

You can use additional methods (optional) for other operations. Make sure your program runs until the user decides to quit the program. Your program should validate (input validation) the menu choice entered by the user, and force them to reenter a menu choice if their original input was invalid.


## Part B

Test the efficiency of your developed searching and sorting algorithms. To test the efficiency, calculate and display the execution (elapsed) time (in seconds) required for each of the Searching and Sorting techniques. Execution time is calculated from the start of a function call to the end of the function. Look up online resources on how to calculate elapsed time and using the system time library. Can you tell which searching technique is better/faster (linear search vs. binary search) and which sorting technique is better/faster (bubble sort vs. selection sort)?
