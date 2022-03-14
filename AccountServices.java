package com.revature.services;


	import com.revature.beans.*;
	import com.revature.dao.AccountDao2;
	import com.revature.exceptions.OverdraftException;

	/**
	 * This class should contain the business logic for performing operations on Accounts
	 */
	public class AccountServices {
		
		public AccountDao2 actDao;
		public static final double STARTING_BALANCE = 25d;
		
		public AccountServices(AccountDao2 dao) {
			this.actDao = dao;
		}
		
		/**
		 * Withdraws funds from the specified account
		 * @throws OverdraftException if amount is greater than the account balance
		 * @throws UnsupportedOperationException if amount is negative
		 */
		public void withdraw(Accounts a, Double amount) {
            double bal=0.0;
			
            bal=a.getBalance();
			if (!a.isApproved()||(bal<amount)) {
				throw new UnsupportedOperationException();
			}else {
				bal = bal - amount;
				a.setBalance(amount);
			}
		}
		
		/**
		 * Deposit funds to an account
		 * @throws UnsupportedOperationException if amount is negative
		 */
		public void deposit(Accounts a, Double amount) {
			double bal=0.0;
			
			
			if (!a.isApproved()||(amount<0)) {
				throw new UnsupportedOperationException();
			}else {
				bal=a.getBalance();
				bal = bal + amount;
				a.setBalance(amount);
		}
		}	
		/**
		 * Transfers funds between accounts
		 * @throws UnsupportedOperationException if amount is negative or 
		 * the transaction would result in a negative balance for either account
		 * or if either account is not approved
		 * @param fromAct the account to withdraw from
		 * @param toAct the account to deposit to
		 * @param amount the monetary value to transfer
		 */
		public void transfer(Accounts fromAct, Accounts toAct, double amount) {
			double fbal=0.0;
			double tbal=0.0;
			
			fbal=fromAct.getBalance();
			tbal=toAct.getBalance();
			if (!fromAct.isApproved()||(!toAct.isApproved()||(amount<0))||(fbal<amount)) {
				throw new UnsupportedOperationException();
		    }else {
		    	fbal=fbal-amount;
		    	tbal=tbal+amount;
		    	fromAct.setBalance(fbal);
		    	toAct.setBalance(tbal);
		    }
		}
		/**
		 * Creates a new account for a given User
		 * @return the Account object that was created
		 */
		public Accounts createNewAccount(Users u) {
			int anum = 001;
			Integer Oid = u.getId();
			
			Accounts newacct = new Accounts();
			newacct.getSerialversionuid();
			newacct.setOwnerId(Oid);
			newacct.setId(anum);
			return newacct;
		}
		
		/**
		 * Approve or reject an account.
		 * @param a
		 * @param approval
		 * @throws UnauthorizedException if logged in user is not an Employee
		 * @return true if account is approved, or false if unapproved
		 */
		public boolean approveOrRejectAccount(Accounts a, boolean approval) {
			Users emp = new Users();
			
			try {
				
			}
			return false;
		}
	}

