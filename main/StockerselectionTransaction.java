package com.greatlearning.main;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StockerselectionTransaction {
	public void sharePriceOrder(double[] compNums, Boolean[] isValue) throws NumberFormatException, IOException {

		int choice = 0;

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (choice < 6) {

			System.out.println("1. Display the companies stock prices in ascending order");
			System.out.println("2. Display the companies stock prices in descending order");
			System.out.println("3. Display the total no of companies for which stock prices rose today");
			System.out.println("4. Display the total no of companies for which stock prices declined today");
			System.out.println("5. Search a specific stock price");
			System.out.println("6. press 0 to exit");

			choice = Integer.parseInt(br.readLine());
			StockersTransaction transactionselection = new StockersTransaction();
			switch (choice) {
			case 1:
				System.out.println("Stock prices in ascending order are :\n");
				transactionselection.displayOrder(compNums, "ASC");
				break;

			case 2:
				System.out.println("Stock prices in descending order are :\n");
				transactionselection.displayOrder(compNums, "DSC");
				break;

			case 3:
				System.out.println("Total no of companies whose stock price rose today");
				transactionselection.numberOfCompaniesRose(isValue);
				break;
			case 4:
				System.out.println("Total no of companies whose stock price declined today");
				transactionselection.numberOfCompaniesDeclain(isValue);
				break;
			case 5:
				System.out.println("Search a specific stock price");
				transactionselection.searchKeyPrice(compNums);
				break;
			default:
				return;

			}
		}
		
	}
}
