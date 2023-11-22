package com.nit.pankaj.specification;

import com.nit.pankaj.exceptions.InsufficientFundsException;
import com.nit.pankaj.exceptions.NegetiveNumberException;

public interface BankAccount {
	
	public void withdrow(double amt) throws NegetiveNumberException,InsufficientFundsException;
	public void deposit(double amt) throws NegetiveNumberException;
	public void checkBalance();
	
}
