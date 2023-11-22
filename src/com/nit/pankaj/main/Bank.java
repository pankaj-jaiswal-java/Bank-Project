package com.nit.pankaj.main;

import java.util.Scanner;

import com.nit.pankaj.blogic.HDFCBank;
import com.nit.pankaj.blogic.ICICIBank;
import com.nit.pankaj.blogic.SBIBank;
import com.nit.pankaj.exceptions.InsufficientFundsException;
import com.nit.pankaj.exceptions.NegetiveNumberException;
import com.nit.pankaj.specification.BankAccount;


public class Bank {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		
		System.out.print("bank name btao BSDK \n 1. SBI \n 2. HDFC \n 3. ICICI ");
		System.out.print("\nchosse your key : ");
		int num1 = sc.nextInt();
		
		
		BankAccount acc;
		
		
		switch (num1) {
		case 1: {
			
			System.out.print("Enter your SBI AC no : ");
			long accno = sc.nextLong(); sc.nextLine();
			System.out.print("enter account HName : ");
			String accHName = sc.nextLine();
			System.out.print("your Total Amount : ");
			double balence = sc.nextDouble();
			
			acc = new SBIBank(accno, accHName, balence);
			
			break;
		}	
		case 2:
			
			System.out.print("Enter your HDFC AC no : ");
			long accno = sc.nextLong(); sc.nextLine();
			System.out.print("enter account HName : ");
			String accHName = sc.nextLine();
			System.out.print("your Total Amount : ");
			double balence = sc.nextDouble();
			
			acc = new HDFCBank(accno, accHName, balence);
			
			break;
			
		case 3:
			
			System.out.print("Enter your ICICI AC no : ");
			long accno1 = sc.nextLong(); sc.nextLine();
			System.out.print("enter account HName : ");
			String accHName1 = sc.nextLine();
			System.out.print("your Total Amount : ");
			double balence1 = sc.nextDouble();
			
			acc = new ICICIBank(accno1, accHName1, balence1);
			
			break;
			
		default:
			throw new IllegalArgumentException("Unexpected value: " + num1);
		}
		
		loop:while(true) {
			System.out.println("What you want \n1. withdrow \n2. Deposit \n3. Check Balence \n4. Exit");
			System.out.print("choose one Option :");
			int num2 = sc.nextInt();
		
			switch (num2) {
			case 1: 
				try {
					System.out.print("Enter amount : ");
					double amt = sc.nextDouble();
					acc.withdrow(amt);
				} catch(NegetiveNumberException|InsufficientFundsException e) {
					System.out.println(e.getMessage());
				}
				break;
				
			case 2:
				try {
					System.out.print("Enter Amount : ");
					double amt = sc.nextDouble();
					acc.deposit(amt);
				} catch(NegetiveNumberException e) {
					System.out.println(e.getMessage());
				}
				break;
				
			case 3:
				acc.checkBalance();
				break;
				
			case 4:
				System.out.println("Thank You!");
				break loop;
				
			default:
				throw new IllegalArgumentException("Unexpected value: " + num2);
			}
		}
		
	}
}
