// TAN LIK WEI I17012619
// EE JIAN PEI I17012981
// YAM ZHENG LIM I17012946
package prg3205_assignment_1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class PRG3205_Assignment_1
{ 
    public static void displayTable(String arr1[], int arr2[],double arr3[])
    {
        int n = arr1.length;
        
        System.out.println("--------------------------------------------------------------------------------------------------");
        System.out.printf("%50s %20s %20s", "BOOK TITLE", "BOOK ID", "BOOK PRICE");
        System.out.println();
        System.out.println("--------------------------------------------------------------------------------------------------");
        for(int i = 0; i < n; i++)
        {
            System.out.format("%50s %20s %20s", arr1[i],arr2[i], "$" + arr3[i]);
            System.out.println();
        }
        System.out.println("--------------------------------------------------------------------------------------------------");
    }
    
    public static void displayMenu()
    {
        System.out.println("\n--------------------Searching--------------------");
        System.out.println("1.Linear Search");
        System.out.println("2.Binary Search");
        System.out.println("3.Quit");
        System.out.print("Selection: ");
    }
    
    public static void displaySubMenu()
    {
        System.out.println("\n--------------------Sorting--------------------");
        System.out.println("1.Bubble Sort");
        System.out.println("2.Selection Sort");
        System.out.println("3.Merge Sort");
        System.out.print("Selection: ");
    }
    
    public static void displayInformation(String bookTitle[], int bookID[], double bookPrice[], int searchIndex, int numberBook, long t1, long t2, int c)
    {
        System.out.println("--------------------------------------------------------------------");
        System.out.println("Book ID\t\t\t: " + bookID[searchIndex]);
        System.out.println("Book Title\t\t: " + bookTitle[searchIndex]);
        System.out.println("Number of books bought\t: " + numberBook);
        System.out.println("Total cost of purchase\t: $" + String.format("%.2f", bookPrice[searchIndex] * numberBook));
        System.out.println("--------------------------------------------------------------------");
        switch(c)
        {
            case 0:
                System.out.println("Execution time (Linear Search)\t: " + t1 + " nanosecond");
                break;
            case 1:
                System.out.println("Execution time (Bubble Sort)\t: " + t2 + " nanosecond");
                System.out.println("Execution time (Binary Search)\t: " + t1 + " nanosecond");
                break;
            case 2:
                System.out.println("Execution time (Selection Sort)\t: " + t2 + " nanosecond");
                System.out.println("Execution time (Binary Search)\t: " + t1 + " nanosecond");
                break;
            case 3:
                System.out.println("Execution time (Merge Sort)\t: " + t2 + " nanosecond");
                System.out.println("Execution time (Binary Search)\t: " + t1 + " nanosecond");
        }
        
        System.out.println("--------------------------------------------------------------------");
    }
    
    public static void enterInformation(int searchID, int numberBook)
    {
        Scanner keyboard = new Scanner(System.in);
        
        System.out.print("Enter book ID: ");
        searchID = keyboard.nextInt();
        System.out.print("Enter number of book: ");
        numberBook = keyboard.nextInt();
    }
    
    public static int linearSearch(int arr[], int x)
    {
        int n = arr.length;
        int flag = 0;
        
        for(int i = 0; i < n; i++)
        {
            if(arr[i] == x)
            {
                flag = i;
                break;
            }
            else
                flag = -1;
        }

        return flag;
    }
    
    public static int binarySearch(int arr[], int x)
    {
        int l = 0, m = 0, r = arr.length-1;
        
        while(l <= r)
        {
            m = l + (r - l) / 2;    // Find the middle value
            
            if(arr[m] == x)
                return m;
            
            if(arr[m] < x)
                l = m + 1;
            else
                r = m - 1;
        }
        
        return -1;
    }
    
    public static void bubbleSort(int arr1[], String arr2[], double arr3[])
    {
        int n = arr1.length;
        
        for(int i=0; i < n-1; i++)
        {
            for(int j=0; j < n-i-1; j++)
            {
                if(arr1[j] > arr1[j+1])
                {
                    int temp1 = arr1[j];
                    arr1[j] = arr1[j+1];
                    arr1[j+1] = temp1;
                    
                    String temp2 = arr2[j];
                    arr2[j] = arr2[j+1];
                    arr2[j+1] = temp2;
                    
                    double temp3 = arr3[j];
                    arr3[j] = arr3[j+1];
                    arr3[j+1] = temp3;
                }
            }
        }
    }
    
    public static void selectionSort(int arr1[], String arr2[], double arr3[])
    {
        int n = arr1.length;
        
        for (int i = 0; i < n-1; i++)
        {
            int min = i;
            
            for (int a = i+1; a < n; a ++)
            {
                if(arr1[a] < arr1[min])
                {
                    min = a;
                }
            }
            
            int temp1 = arr1[i];
            arr1[i]= arr1[min];
            arr1[min]=temp1;
          
            String temp2 = arr2[i];
            arr2[i]= arr2[min];
            arr2[min]=temp2;
          
            double temp3 = arr3[i];
            arr3[i]= arr3[min];
            arr3[min]=temp3;
        }
    }
    
    public static void merge(int arr1[], String arr2[], double arr3[], int l, int m, int r) 
    { 
        // Find sizes of two subarrays to be merged 
        int n1 = m - l + 1; 
        int n2 = r - m; 
  
        /* Create temp arrays */
        int L1[] = new int [n1]; 
        int R1[] = new int [n2];
        String L2[] = new String [n1]; 
        String R2[] = new String [n2]; 
        double L3[] = new double [n1]; 
        double R3[] = new double [n2]; 
  
        /*Copy data to temp arrays*/
        for (int i=0; i<n1; ++i)
        {
            L1[i] = arr1[l + i]; 
            L2[i] = arr2[l + i];
            L3[i] = arr3[l + i];
        }
        for (int j=0; j<n2; ++j) 
        {
            R1[j] = arr1[m + 1+ j]; 
            R2[j] = arr2[m + 1+ j]; 
            R3[j] = arr3[m + 1+ j]; 
        }

        /* Merge the temp arrays */
  
        // Initial indexes of first and second subarrays 
        int i = 0, j = 0; 
  
        // Initial index of merged subarry array 
        int k = l; 
        while (i < n1 && j < n2) 
        { 
            if (L1[i] <= R1[j]) 
            { 
                arr1[k] = L1[i];
                arr2[k] = L2[i];
                arr3[k] = L3[i]; 
                i++; 
            } 
            else
            { 
                arr1[k] = R1[j]; 
                arr2[k] = R2[j]; 
                arr3[k] = R3[j]; 
                j++; 
            } 
            k++; 
        } 
  
        /* Copy remaining elements of L[] if any */
        while (i < n1) 
        { 
            arr1[k] = L1[i]; 
            arr2[k] = L2[i]; 
            arr3[k] = L3[i]; 
            i++; 
            k++; 
        } 
  
        /* Copy remaining elements of R[] if any */
        while (j < n2) 
        { 
            arr1[k] = R1[j]; 
            arr2[k] = R2[j]; 
            arr3[k] = R3[j]; 
            j++; 
            k++; 
        } 
    } 
  
    // Main function that sorts arr[l..r] using 
    // merge() 
    public static void mergeSort(int arr1[], String arr2[], double arr3[], int l, int r) 
    { 
        if (l < r) 
        { 
            // Find the middle point 
            int m = (l+r)/2; 
  
            // Sort first and second halves 
            mergeSort(arr1, arr2, arr3 ,l ,m); 
            mergeSort(arr1, arr2, arr3 , m+1, r); 
  
            // Merge the sorted halves 
            merge(arr1, arr2, arr3, l, m, r); 
        } 
    } 
    
    public static boolean isValid(int enteredNumber,int min, int max)
    {
        if(enteredNumber >= min && enteredNumber <= max)
            return true;
        else
            return false;
    }
    
    /**
     * The errorMessage prints the error messages.
     */
    public static void displayError()
    {
        System.out.println("----------------------------------------\n"
                            + "\tYour selection is invalid.\n"
                            + "\tPlease try again.\n"
                            + "----------------------------------------");
    }
    
    public static String getString()
    {
        Scanner keyboard = new Scanner(System.in);
        String str;
        
        str = keyboard.nextLine();
        
        return str;
    }
    
    public static int getInteger(int c)
    {
        // Create a Scanner object to read from the keyboard
        //Scanner keyboard = new Scanner(System.in);
        int value = 0; // User entered value
        boolean error;
        
        do
        {
            try
            {
                Scanner keyboard = new Scanner(System.in);
                value = keyboard.nextInt();
                error = false;
            }
            catch(InputMismatchException e)
            {
                // accept integer only.
                System.out.println("----------------------------------------\n"
                            + "\tYour input is invalid.\n"
                            + "\tPlease input integer only.\n"
                            + "----------------------------------------");
                
                switch(c)
                {
                    case 0:
                        System.out.print("Selection: ");
                        break;
                    case 1:
                        System.out.print("Enter book ID: ");
                        break;
                    case 2:
                        System.out.print("Enter number of book: ");
                        break;
                }
                error = true;
            }

        }while(error);
        
        return value;
    }
    
    public static void main(String[] args)
    {
        String[] bookTitle = {"Starting out with Java", "Java Programming", "Software Structures", "Design and Analysis of Algorithms", "Computer Graphics", "Artificial Intelligence: A Modern Approach", "Probability and Statistics", "w", "Modern Information Retrieval", "Speech and Language Processing"};
        int[] bookID = {1101, 1211, 1333, 1456, 1567, 1642, 1699, 1755, 1800, 1999};
        double[] bookPrice = {112.32, 73.25, 54.00, 67.32, 135.00, 173.22, 120.00, 42.25, 32.11, 123.75};
        int selection;
        int searchID;
        int searchIndex;
        long searchTime;
        long sortTime;
        int numberBook;
        long startTime;
        long endTime;
        String choice;
        int loop = 0;
        Scanner keyboard = new Scanner(System.in);
        
        do
        {
            displayTable(bookTitle, bookID, bookPrice);
            displayMenu();
            selection = getInteger(0);
            
            while(!isValid(selection, 1, 3))
            {
                displayError(); // Display the error message
                displayMenu();  // Display menu
                selection = getInteger(0); // Get the user value
            }
            
            switch(selection)
            {
                case 1:
                    System.out.print("Enter book ID: ");
                    searchID = getInteger(1);
                    startTime = System.nanoTime();
                    searchIndex = linearSearch(bookID,searchID);
                    endTime = System.nanoTime();
                    
                    while(searchIndex == -1)
                    {
                        displayError();
                        System.out.print("Enter book ID: ");
                        searchID = getInteger(1);
                        startTime = System.nanoTime();
                        searchIndex = linearSearch(bookID,searchID);
                        endTime = System.nanoTime();
                    }
                    
                    searchTime = endTime - startTime;
                    
                    System.out.print("Enter number of book: ");
                    numberBook = getInteger(2);
                    
                    while(numberBook < 0)
                    {
                        displayError();
                        System.out.print("Enter number of book: ");
                        numberBook = getInteger(2);
                    }
                    
                    displayInformation(bookTitle,bookID,bookPrice,searchIndex,numberBook,searchTime,0,0);
                    break;
                case 2:
                    displaySubMenu();
                    selection = getInteger(0);
                    
                    while(!isValid(selection, 1, 3))
                    {
                        displayError(); // Display the error message
                        displaySubMenu();  // Display menu
                        selection = getInteger(0); // Get the user value
                    }
                    
                    switch(selection)
                    {
                        case 1:
                            System.out.print("Enter book ID: ");
                            searchID = getInteger(1);
                            startTime = System.nanoTime();
                            bubbleSort(bookID, bookTitle, bookPrice);
                            endTime = System.nanoTime();
                            sortTime = endTime - startTime;
                            startTime = System.nanoTime();
                            searchIndex = binarySearch(bookID,searchID);
                            endTime = System.nanoTime();
                            searchTime = endTime - startTime;
                            
                            while(searchIndex == -1)
                            {
                                displayError();
                                System.out.print("Enter book ID: ");
                                searchID = getInteger(1);
                                startTime = System.nanoTime();
                                bubbleSort(bookID, bookTitle, bookPrice);
                                endTime = System.nanoTime();
                                sortTime = endTime - startTime;
                                startTime = System.nanoTime();
                                searchIndex = binarySearch(bookID,searchID);
                                endTime = System.nanoTime();
                                searchTime = endTime - startTime;
                            }
                            
                            System.out.print("Enter number of book: ");
                            numberBook = getInteger(2);
                            
                            while(numberBook < 0)
                            {
                                displayError();
                                System.out.print("Enter number of book: ");
                                numberBook = getInteger(2);
                            }
                            
                            displayInformation(bookTitle, bookID, bookPrice, searchIndex, numberBook, searchTime, sortTime, 1);
                            
                            break;
                        case 2:
                            System.out.print("Enter book ID: ");
                            searchID = getInteger(1);
                            startTime = System.nanoTime();
                            selectionSort(bookID, bookTitle, bookPrice);
                            endTime = System.nanoTime();
                            sortTime = endTime - startTime;
                            startTime = System.nanoTime();
                            searchIndex = binarySearch(bookID, searchID);
                            endTime = System.nanoTime();
                            searchTime = endTime - startTime;
                            
                            while(searchIndex == -1)
                            {
                                displayError();
                                System.out.print("Enter book ID: ");
                                searchID = getInteger(2);
                                startTime = System.nanoTime();
                                selectionSort(bookID, bookTitle, bookPrice);
                                endTime = System.nanoTime();
                                sortTime = endTime - startTime;
                                startTime = System.nanoTime();
                                searchIndex = binarySearch(bookID,searchID);
                                endTime = System.nanoTime();
                                searchTime = endTime - startTime;
                            }
                            
                            System.out.print("Enter number of book: ");
                            numberBook = getInteger(2);
                            
                            while(numberBook < 0)
                            {
                                displayError();
                                System.out.print("Enter number of book: ");
                                numberBook = getInteger(2);
                            }
                            
                            displayInformation(bookTitle, bookID, bookPrice, searchIndex, numberBook, searchTime, sortTime, 2);
                            break;
                        case 3:
                            System.out.print("Enter book ID: ");
                            searchID = getInteger(1);
                            startTime = System.nanoTime();
                            mergeSort(bookID, bookTitle, bookPrice, 0, bookID.length-1);
                            endTime = System.nanoTime();
                            sortTime = endTime - startTime;
                            startTime = System.nanoTime();
                            searchIndex = binarySearch(bookID, searchID);
                            endTime = System.nanoTime();
                            searchTime = endTime - startTime;
                            
                            while(searchIndex == -1)
                            {
                                displayError();
                                System.out.print("Enter book ID: ");
                                searchID = getInteger(2);
                                startTime = System.nanoTime();
                                selectionSort(bookID, bookTitle, bookPrice);
                                endTime = System.nanoTime();
                                sortTime = endTime - startTime;
                                startTime = System.nanoTime();
                                searchIndex = binarySearch(bookID,searchID);
                                endTime = System.nanoTime();
                                searchTime = endTime - startTime;
                            }
                            
                            System.out.print("Enter number of book: ");
                            numberBook = getInteger(2);
                            
                            while(numberBook < 0)
                            {
                                displayError();
                                System.out.print("Enter number of book: ");
                                numberBook = getInteger(2);
                            }
                            
                            displayInformation(bookTitle, bookID, bookPrice, searchIndex, numberBook, searchTime, sortTime, 3);
                            break;
                        default:
                            System.out.print("The entered value is unrecognized!");
                            break;
                    }
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    System.out.print("The entered value is unrecognized!");
                    break;
            }
            
            System.out.print("Do you wish to continue? (Y/N)\t: ");
            choice = getString();
            
            switch(choice)
            {
                case "Y":
                case "y":
                    loop = -1;
                    break;
                case "N":
                case "n":
                    loop = 1;
                    break;
            }
            
            while(!choice.equals("Y") && !choice.equals("N") && !choice.equals("y") && !choice.equals("n"))
            {
                displayError();
                System.out.print("Do you wish to continue? (Y/N)\t: ");
                choice = keyboard.nextLine();
            
                switch(choice)
                {
                    case "Y":
                    case "y":
                        loop = -1;
                        break;
                    case "N":
                    case "n":
                        loop = 1;
                        break;
                }
            }
                
        }while(loop != 1);
    }
}