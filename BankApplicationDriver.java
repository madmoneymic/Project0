package com.revature;

import java.io.InvalidClassException;
import java.util.*;

import com.revature.beans.Accounts;
import com.revature.dao.AccountDao2;
import com.revature.Exceptions.InvalidCredentialsException;

import com.revature.beans.User2;
import com.revature.dao.UserDaoFile2;
import com.revature.services.AccountServices;
import com.revature.services.UserService2.UsernameAlreadyExistsException;

/**
 * This is the entry point to the application
 */
public class BankApplicationDriver {

	public static void main(String[] args) {

			final String DEPOSIT = null;
				// TODO Auto-generated method stub
				int opt1,opt2,idnum=1000000,depo,withd;
				double cash;
				char ans;
				boolean flag;
				User2 person = new User2();
				Scanner sel = new Scanner(System.in);
				String uname, pword, fname,lname;
				
				
				System.out.println("---------------------------------------------------------------------");
				System.out.println("---------------------------------------------------------------------");
				System.out.println("---------------------------------------------------------------------");
				System.out.println("|||                                                               |||");
				System.out.println("|||                                                               |||");
				System.out.println("|||             WELCOME TO FIRST REVATURE BANK                    |||");
				System.out.println("|||                                                               |||");
				System.out.println("|||                                                               |||");
				System.out.println("---------------------------------------------------------------------");
				System.out.println("---------------------------------------------------------------------");
				System.out.println("---------------------------------------------------------------------");
				System.out.println();
				System.out.println();
				System.out.println();
				System.out.println("Are you a Registered User?(Y//N)");
				ans = (char) sel.nextByte();
				if((ans=='N') || (ans=='n')){
					//Get user's First Name, Last Name, assign employee number, Username, Password, and UserType(Customer or Employee) and add to file or database.
					     person.setId(idnum);
					     System.out.println("Please type the user's First Name and press ENTER:");
					     fname=sel.next();
					     person.setFirstName(fname);
					     System.out.println("Please type the user's Last Name and press ENTER:");
					     lname=sel.next();
					     person.setLastName(lname);
					     System.out.println("Please create a username for this user and press ENTER:");
					     uname=sel.next();
					     person.setUsername(uname);
				      	 System.out.print("Please create a password for this user and press ENTER:");
					     pword=sel.next();
				      	 person.setPassword(pword);
					     System.out.println("1. Register Customer");
					     System.out.println("2. Register Employee");
					     System.out.println();
					     System.out.println();
					     System.out.println("Please choose option 1 or 2:");
					     opt1=sel.nextInt();
					     if (opt1==1)
						   person.setUserType("CUSTOMER");
					     else if (opt1==2)
					       person.setUserType("EMPLOYEE");
					     else
						   System.out.println("Invalid selection");		
					       System.out.println("This user's account has been registered successfully!!!!");
					    
				}
				//Compare Username and Password to those in the file or database.  If a match occurs, log user into the system and show appropriate menu.
			    //Customer Menu
				System.out.println("Please type your username and press ENTER:");
				uname=sel.next();
				System.out.println("Please type your password and press ENTER:");
				pword=sel.next();
				try {
				person.UserService.login(uname,pword);
				}catch(InvalidClassException e) {
					System.out.println("Login credentials are invalid. Please Reenter username and password");
					System.out.println("Please type your username and press ENTER:");
					uname=sel.next();
					System.out.println("Please type your password and press ENTER:");
					pword=sel.next();
					person.UserService.login(uname,pword);
				}
				if (person.setUserType.CUSTOMER) {
				  System.out.println("1. Apply for a New Account");
			      System.out.println("2. Deposit");
			      System.out.println("3. Withdraw");
			      System.out.println("4. Transfer");
			      System.out.println("5. View Account Balances");
			      System.out.println();
			      System.out.println();
			      System.out.println("Please choose option");
			      opt1=sel.nextInt();
				}else {
				  System.out.println("1. View Customer Transactions");
				  System.out.println("2. Approve or Reject request for a new account");
				  opt2=sel.nextInt();
				}
			    switch (opt1) {
			    case 1:{
			    	Accounts paccnt = new Accounts();
					flag=paccnt.AccountServices.approveOrRejectAccount(person,flag);
					if (flag!=TRUE)
			    		System.out.println("Sorry, we are unable to fulfill your request at this time");
			    	else {
			    		System.out.println("This request has been approved. We are happy to have you as a customer");
			    		UserDaoFile2 pcurr = new UserDaoFile2();
			    		paccnt.createNewAccount(pcurr);
			    	    paccnt.setOwnerId(pcurr.getid());
			            paccnt.setApproved(flag);
			    	    System.out.println("Please select the account type:");
			    	    System.out.println("1. Checking");
			    	    System.out.println("2. Savings");
			    	    System.out.println();
			    	    System.out.println();
			    	    opt2=sel.nextInt();
			    	    }
			    	    if (opt2==1)
			    		  paccnt.setType("CHECKING");
			    	    else if (opt2==2)
			    		  paccnt.setType("SAVINGS");
			    	    else {
			    		  System.out.println("Invalid entry. Please select option 1 or 2!!!");
			    		  opt2=sel.nextInt();
			    	    }
			    	   System.out.println("How much do you want to deposit today?(Minimum 25.00");
			    	   cash=sel.nextDouble();
			    	   paccnt.setBalance(cash);
			    	   paccnt.AccountServices.deposit(paccnt,cash);
			    	   addAccount(paccnt);
			    	   pcurr.setAccounts(paccnt.setType);
			    	   UserService(pcurr,pacct);
			    	break;
			    }
			    case 2:{
			    	Accounts paccnt = new Accounts();
			    	paccnt.getAccountsByUser(pcurr);
			    	System.out.println("Please enter the account ID for which you would like to make a deposit today:");
			    	depo=sel.nextInt();
			    	paccnt.getAccount(depo);
			    	System.out.println("Please enter the amount of this deposit:");
			    	cash=sel.nextDouble();
			    	paccnt.AccountService(paccnt).deposit(paccnt,cash);
			    	paccnt.updateAccount(paccnt);
			    	//Retrieve and display list of available accounts for user from file or database
			    	//Enter Account ID to Deposit
			    	//Have user enter amount to deposit
			    	//Upon acceptance of deposit, add to account balance
			    	//Save updated amount to file or database
			    	//Display new balance to user
			    	//Update Transaction record for user
			    	break;
			    }
			    case 3:{
			    	Accounts paccnt = new Accounts();
			    	paccnt=getAccountsByUser(pcurr);
			    	System.out.println("Please enter the account ID for which you would like to make a withdrawal today:");
			    	withd=sel.nextInt();
			    	paccnt.getAccount(withd);
			    	System.out.println("Please enter the amount of this withdrawal:");
			    	cash=sel.nextDouble();
			    	paccnt.AccountService(paccnt).withdraw(paccnt,cash);
			    	paccnt.updateAccount(paccnt);
			    	break;
			    }
			    case 4:{
			    	
			    	break;
			    }
			    case 5:{
			    	Accounts paccnt = new Accounts();
		    	    paccnt.getAccountsByUser(pcurr);
		    	    System.out.println("Please enter the account ID for which you would like to make a withdrawal today:");
		    	    withd=sel.nextInt();
		    	    paccnt.getAccount(withd);
			    	break;
			    }   
			    switch (opt2) {
			    case 1:{
			    	
			    }
			    case 2:{
			    	
			    }
			    }
			    sel.close();
			}

	}
}

