package com.yatish.sorting;

/*
 * Complexity
 * ----------
 * Time Complexity : O(n)
 */
public class MergeSort {

	public static void main(String[] args) {
		int[] arr = {10,9,8,6,7,3,4,1,2};
		MergeSort obj = new MergeSort();
		obj.sort(arr, 0, arr.length-1);
		
		for(int m = 0; m < arr.length; m++) {
			System.out.println(arr[m]);
		}
	}
	
	public void sort(int[] arr,int startIndex,int endIndex) {
		
		if(startIndex < endIndex) {
			int mid = (endIndex+startIndex)/2;
			sort(arr,startIndex,mid);
			sort(arr,mid+1,endIndex);
			merge(arr,startIndex,mid,endIndex);
		}
	}
	
	public void merge(int[] arr,int startIndex,int midIndex, int endIndex) {
		
		//finding size of first half of array and 2nd half of array
		int array1size = midIndex - startIndex+1;
		int array2size = endIndex - midIndex;
		
		//copying the first half of array and 2nd half of array into the temp 
		int[] tempArray1 = new int[array1size];
		int[] tempArray2 = new int[array2size];
		for(int i=0; i< array1size; i++) {
			tempArray1[i] = arr[startIndex + i];
		}
		for(int j = 0; j< array2size; j++) {
			tempArray2[j] = arr[midIndex +1 + j];
		}
		
		int i = 0, j = 0;
		int k = startIndex;
		
		while(i < array1size && j < array2size) {
			if(tempArray1[i] < tempArray2[j]) {
				arr[k] = tempArray1[i];
				i++;
			} else {
				arr[k] = tempArray2[j];
				j++;
			}
			k++;
		}
		
		while(i < array1size) {
			arr[k] = tempArray1[i];
			i++;k++;
		}
		
		while(j < array2size) {
			arr[k] = tempArray2[j];
			j++;k++;
		}
		
		
	}
	
}
