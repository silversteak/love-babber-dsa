package com.Arrays;

public class Q6_Union_Intersection {

	/* Function prints union of arr1[] and arr2[] 
    m is the number of elements in arr1[] 
    n is the number of elements in arr2[] 
    without duplicates*/
	static int printUnion(int arr1[], int arr2[], int m, int n) 
	{ 
		int i = 0, j = 0; 
		while (i < m && j < n) { 
			if (arr1[i] < arr2[j]) 
				System.out.print(arr1[i++] + " "); 
			else if (arr2[j] < arr1[i]) 
				System.out.print(arr2[j++] + " "); 
			else { 
				System.out.print(arr2[j++] + " "); 
				i++; 
			} 
		} 

		/* Print remaining elements of  
         the larger array */
		while (i < m) 
			System.out.print(arr1[i++] + " "); 
		while (j < n) 
			System.out.print(arr2[j++] + " "); 

		return 0; 
	}

	/* Function prints Intersection of arr1[] and arr2[] 
    m is the number of elements in arr1[] 
    n is the number of elements in arr2[] 
    without duplicates*/
	static void printIntersection(int arr1[], int arr2[], int m, int n) 
	{ 
		int i = 0, j = 0; 
		while (i < m && j < n) { 
			if (arr1[i] < arr2[j]) 
				i++; 
			else if (arr2[j] < arr1[i]) 
				j++; 
			else { 
				System.out.print(arr2[j++] + " "); 
				i++; 
			} 
		} 
	}

}
