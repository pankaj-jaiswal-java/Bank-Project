package com.nit.pankaj.blogic;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.nit.pankaj.exceptions.InsufficientFundsException;
import com.nit.pankaj.exceptions.NegetiveNumberException;
import com.nit.pankaj.specification.BankAccount;

public class HDFCBank implements BankAccount {
	
	private static String bankName;
	private static String branchName;
	private static String ifsc;
	
	private long accNo;
	private String accHName;
	private double balence;
	
	static {
		try(BufferedReader br = new BufferedReader(new FileReader("sbidata.txt"))){
			bankName = br.readLine();
			branchName = br.readLine();
			ifsc = br.readLine();
		}catch (FileNotFoundException e) {
			System.out.println("file not found");
		}catch (IOException e) {
			e.getStackTrace();
		}
	}
	
	

	public HDFCBank(long accNo, String accHName, double balence) {
			this.accNo = accNo;
			this.accHName = accHName;
			this.balence = balence;
	}

	@Override
	public void withdrow(double amt) throws NegetiveNumberException, InsufficientFundsException {
		if(amt<=0) 
			new NegetiveNumberException("Please enter positive Amount");
		if(amt > balence) 
			new InsufficientFundsException("insufficient funds ");
		balence = balence - amt;
		
	}

	@Override
	public void deposit(double amt) throws NegetiveNumberException {
		if(amt<=0) new NegetiveNumberException("please enter Positive Amount");
		balence = balence + amt;
		
	}

	@Override
	public void checkBalance() {
		System.out.println(balence+" your corrunt Amount");
		
	}
	
}
