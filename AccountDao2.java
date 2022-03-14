package com.revature.dao;

import java.util.List;

import com.revature.beans.Accounts;
import com.revature.beans.Users;

/**
 * The data access object interface for CRUD operations on Accounts.
 * This allows us to define a contract which can be implemented in different ways
 * using different methods of data storage and retrieval.
 */
public interface AccountDao2 {
	/**
	 * Adds a new account into the persistence layer
	 * @param a the account object to add
	 * @return the same account that was added
	 */
	public Accounts addAccount(Accounts a);
	
	/**
	 * Retrieves an account
	 * @param actId the id of the account to retrieve
	 * @return the account object
	 */
	public Accounts getAccount(Integer actId);
	
	/**
	 * Retrieves all accounts
	 * @return a list of all accounts
	 */
	public List<Accounts> getAccounts();
	
	/**
	 * Retrieves accounts by a particular user
	 * @param u the user object to search by
	 * @return a list of accounts that the user owns
	 */
	public List<Accounts> getAccountsByUser(Users u);
	
	/**
	 * Updates a specific account
	 * @param a the account to update
	 * @return the updated account
	 */
	public Accounts updateAccount(Accounts a);
	
	/**
	 * Deletes an account from the persistence layer
	 * @param a the account to delete
	 * @return true if the deletion was successful; false if not
	 */
	public boolean removeAccount(Accounts a);
}


