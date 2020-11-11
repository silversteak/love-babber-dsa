package com.Arrays;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Random;

public class Q3_Kth_Smallest_Element {

	/*Using Max heap O(n log K)*/
	/*Inverse Logic in case of heap*/
	public static int KthSmallest(int arr[], int k) {
		final PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		for(int val : arr) {
			pq.offer(val);
			//Check the size
			if(pq.size() > k) {
				pq.poll();
			}
		}
		return pq.peek();
	}


	/**
	 * Using selection sort partition its in O(n)
	 * @param arr
	 * @param k
	 * @return
	 */
	public static int KthSmallestQuickSelect(int arr[], int k) {
		int n = arr.length;
		int left = 0, right = n-1;

		Random rand = new Random();

		while(left <= right) {

			int pivot = rand.nextInt(right - left + 1) + left;

			//Returns the index of the element
			int finalPivot = partition(arr, left, right, pivot);

			if(finalPivot == n-k)
				return arr[finalPivot];

			/*k'th largest must be in the right partition. We "undershot" and need to go right
          		(and we do this by narrowing the left bound)	
			 */
			if(finalPivot < n-k) {
				left = finalPivot + 1;
			}else 
			/*k'th largest must be in the left partition. We "overshot" and need to go left
		    (and we do this by narrowing the right bound)*/
			{
				right = finalPivot - 1;
			}

		}

		return -1;
	}

	/**
	 * partition the arr into two
	 * 
	 * @param arr
	 * @param left
	 * @param right
	 * @param pivot
	 * @return tailIndex which contains the final element
	 */
	private static int partition(int[] arr, int left, int right, int pivot) {
		int pivotValue = arr[pivot];
		int tailIndex = left;

		//Swap the pivotValue with the right Boundary
		swap(arr, pivot, right);

		//Now loop over the items till less than the right boundary
		for(int index = left; index < right; index++) {
			if(arr[index] > pivotValue) {
				swap(arr, tailIndex, index);
				tailIndex++;
			}
		}
		//Swap the right boundary with the tailIndex
		swap(arr, tailIndex, right);
		return tailIndex;
	}

	private static void swap(int[] arr, int pivot, int right) {
		int temp = arr[pivot];
		arr[pivot] = arr[right];
		arr[right] = temp;
	}
	
	public static void main(String args[]) {
		int arr1[] = {12, 3, 5, 7, 4, 19, 26 };
		int arr2[] = {12, 3, 5, 7, 4, 19, 26 };

		System.out.println(KthSmallest(arr1, 2));
		System.out.println(KthSmallestQuickSelect(arr2, 2));
		
	}

}
