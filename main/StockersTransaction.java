package com.greatlearning.main;
import java.util.Arrays;
import java.util.Scanner;

public class StockersTransaction {
	public void displayOrder(double[] compNums, String Order) {
		int size = compNums.length;
		mergeSort(compNums, 0, size - 1, Order);
		printcompNums(compNums, size, Order);
	}

	private void printcompNums(double[] compNums, int length, String Order) {
		if (Order.equals("ASC")) {
			System.out.print("Stock prices ascending order... ");
		} else {
			System.out.print("Stock prices descending order... ");
		}
		for (int i = 0; i < length; i++)
			System.out.print(compNums[i] + ", "+ " ");
		System.out.print("\n");
	}

	private void mergeSort(double compNums[], int lower, int upper, String Order) {
		if (lower >= upper)
			return;// signifies that array contains only one element
		mergeSort(compNums, lower, (lower + upper) / 2, Order);// sorting the left portion of the array
		mergeSort(compNums, ((lower + upper) / 2) + 1, upper, Order);// sorting the right portion of the array
		mergeSortOrder(compNums, lower, (lower + upper) / 2, upper, Order);// merging the two portions once sorting is done
	}

	private void mergeSortOrder(double[] compNums, int lower, int middle, int upper, String Order) {
		int i, j, k;
		double left[] = new double[(int) (middle - lower + 1)];// creating sub-array to store elements in the left portion of 'array[]'
		double right[] = new double[(int) (upper - middle)];// creating sub-array to store elements in the right portion of 'array[]'
		for (i = 0; i < middle - lower + 1; i++)// copying appropriate elements from array[] to left[]
			left[i] = compNums[(int) (lower + i)];
		for (j = 0; j < upper - middle; j++)// copying appropriate elements from
			// array[] to right[]
			right[j] = compNums[(int) (middle + 1 + j)];
		i = 0; // initial index of sub-array left[]
		j = 0; // initial index of sub-array right[]
		k = (int) lower; // initial index of merged array
		for (k = (int) lower; i < middle - lower + 1 && j < upper - middle; k++) {// THIS CONDITION SORTS IN ASCENDING ORDER
			if (Order.equals("ASC")) {
				if (left[i] <= right[j])
					compNums[k] = left[i++];// storing value of left[i] in array[k] if the former is smaller
				else
					compNums[k] = right[j++];// storing value of right[j] in array[j] if the former is smaller
			} else {// descending order
				if (left[i] > right[j])
					compNums[k] = left[i++];
				else
					compNums[k] = right[j++];
			}
		}
		while (i < middle - lower + 1)
			compNums[k++] = left[i++];// copying back the remaining elements of left[] to array[]
		while (j < upper - middle)
			compNums[k++] = right[j++];// copying back the remaining elements of right[] to array[]
	}

	// Total no of companies whose stock price rose today
	public void numberOfCompaniesRose(Boolean[] isValue) {
		int count = 0;
		for (int i = 0; i < isValue.length; i++) {
			if (isValue[i] == true) {
				count = count + 1;
			}
		}
		System.out.println(count);
	}

	// Total no of companies whose stock price declain today
	public void numberOfCompaniesDeclain(Boolean[] isValue) {
		int count = 0;
		for (int i = 0; i < isValue.length; i++) {
			if (isValue[i] == false) {
				count = count + 1;
			}
		}
		System.out.println(count);
	}
	
	// search the value of key
	public void searchKeyPrice(double[] compNums) {
		Arrays.sort(compNums);

		Scanner sc = new Scanner(System.in);

		System.out.println("enter the Key Value");
		double key = sc.nextDouble();

		boolean isflag = false;

		int l = 0;
		int h = compNums.length - 1;

		while (l <= h) {
			int m = (l + h) / 2;
			if (compNums[m] == key) {
				System.out.println("stock of value " + key + " present");
				isflag = true;
				break;
			}

			if (compNums[m] < key) {
				l = m + 1;
			}

			if (compNums[m] > key) {
				h = m - 1;
			}
		}
		if (isflag == false) {
			System.out.println("value not found");
		}
	}
}
