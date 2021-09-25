package com.greatlearning.main;
import java.io.IOException;
import java.util.Scanner;

public class StockpriceApplication {
public static void main(String[] args) throws NumberFormatException, IOException {
		
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the no of companies");
		int companies=sc.nextInt();
		Boolean[] isvalue = new Boolean[companies];
		double[] compNums = new double[companies];
		for(int i=0;i<companies;i++){
			System.out.println("Enter current stock price of the company "+(i+1));
			 compNums[i]=sc.nextDouble();
			System.out.println("Whether company's stock price rose today compare to yesterday");
			isvalue[i] = sc.nextBoolean();
		}
		StockerselectionTransaction stocktransaction=new StockerselectionTransaction();
		stocktransaction.sharePriceOrder(compNums,isvalue);
	}
}
