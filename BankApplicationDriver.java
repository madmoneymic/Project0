package com.revature;

import java.io.InvalidClassException;
import java.util.*;

import com.revature.beans.*;
import com.revature.dao.*;
import com.revature.services.*;
import com.revature.utils.SessionCache;

/**
 * This is the entry point to the application
 */
public class BankApplicationDriver {

	
	public static void main(String[] args) {
		

				// TODO Auto-generated method stub
				int opt1,opt2,idnum=100000,depo,withd;
				double cash;
				char ans;
				boolean flag=true;
				Users newc = new Users();
				Users userin = new Users();
				SessionCache linewc = new SessionCache();
				Accounts newa = new Accounts();
				UserDaoDB userdb = new UserDaoDB();
				AccountDaoDB hdao = new AccountDaoDB();
				AccountServices hacct = new AccountServices(hdao);
				UserServices servu = new UserServices(userdb,hdao);
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
					     newc.setId(idnum);
					     System.out.println("Please type the user's First Name and press ENTER:");
					     fname=sel.next();
					     newc.setFirstName(fname);
					     System.out.println("Please type the user's Last Name and press ENTER:");
					     lname=sel.next();
					     newc.setLastName(lname);
					     System.out.println("Please create a username for this user and press ENTER:");
					     uname=sel.next();
					     newc.setUsername(uname);
				      	 System.out.print("Please create a password for this user and press ENTER:");
					     pword=sel.next();
				      	 newc.setPassword(pword);
					     System.out.println("1. Register Customer");
					     System.out.println("2. Register Employee");
					     System.out.println();
					     System.out.println();
					     System.out.println("Please choose option 1 or 2:");
					     opt1=sel.nextInt();
					     servu.register(newc);
					     System.out.println("This user's account has been registered successfully!!!!");
				}
				//Compare Username and Password to those in the file or database.  If a match occurs, log user into the system and show appropriate menu.
			    //Customer Menu
				System.out.println("Please type your username and press ENTER:");
				uname=sel.next();
				newc.setUsername(uname);
				System.out.println("Please type your password and press ENTER:");
				pword=sel.next();
				newc.setPassword(pword);
			    userin=servu.login(uname,pword);
			    linewc.setCurrentUser(userin);
				  System.out.println("1. Apply for a New Account");
			      System.out.println("2. Deposit");
			      System.out.println("3. Withdraw");
			      System.out.println("4. Transfer");
			      System.out.println("5. View Account Balances");
			      System.out.println("6. Exit");
			      System.out.println();
			      System.out.println();
			      System.out.println("Please choose option");
			      opt1=sel.nextInt();
			    switch (opt1) {
			    case 1:{
			    	hacct.createNewAccount(userin);
			    	Accounts rcust = new Accounts();
			    	flag=hacct.approveOrRejectAccount(rcust, flag);
			    	if (flag!=true) {
			    		System.out.println("We are unable to approve this account at this time.");
			    		rcust.setApproved(false);
			    		rcust.setId(null);
			    		rcust.setOwnerId(null);
			    	}
			    	else {
			    		rcust.setApproved(true);
			    		System.out.println("1. Checking Account");
			    		System.out.println("2. Savings Account");
			    		System.out.println();
			    		System.out.println();
			    		System.out.println("Please choose option");
			    		opt1=sel.nextInt();
			    		if(opt1==1)
			    			rcust.setType(null);
			    		else if (opt1==2)
			    			rcust.setType(null);
			    		else {
			    			System.out.println("Invalid selection. Please choose again.");
			    			opt1=sel.nextInt();
			    		}
			    		rcust.setBalance(null);
			    		System.out.println("Your %1s account has been approved");
			    		System.out.println("Your balance on this account is:");
			    		System.out.println("Thanks for banking at First Revature Bank");
			    		System.out.println("Have a Great Day");
			    	}
			    }
			    case 2:{
			    	Accounts rcust = new Accounts();
			    	rcust.getOwnerId();
			    	userin.getAccounts();
			    	System.out.println("Please enter the account ID for which you would like to make a deposit today:");
			    	depo=sel.nextInt();
			    	System.out.println("Please enter the amount of this deposit:");
			    	cash=sel.nextDouble();
			    	hacct.deposit(rcust,cash);
			    	hdao.updateAccount(rcust);
			    	break;
			    }
			    case 3:{
			    	Accounts rcust = new Accounts();
			    	rcust.getOwnerId();
			    	System.out.println("Please enter the account ID for which you would like to withdraw today:");
			    	withd=sel.nextInt();
			    	rcust.getId();
			    	System.out.println("Please enter the amount of this withdrawal:");
			    	cash=sel.nextDouble();
			    	hacct.withdraw(rcust,cash);
			    	hdao.updateAccount(rcust);
			    	break;
			    }
			    case 4:{
			    	Accounts fracct = new Accounts();
			    	Accounts tracct = new Accounts();
			    	fracct.getOwnerId();
			    	tracct.getOwnerId();
			    	System.out.println("Please enter the account ID from which you would like to transfer money:");
			    	withd=sel.nextInt();
			    	fracct.getId();
			    	System.out.println("Please enter the account ID to which you would like to transfer money:");
			    	depo=sel.nextInt();
			    	tracct.getId();
			    	System.out.println("Please enter the amount to transfer:");
			    	cash=sel.nextDouble();
			    	hacct.transfer(fracct,tracct,cash);
			    	hdao.updateAccount(fracct);
			    	hdao.updateAccount(tracct);
			    	break;
			    }
			    case 5:{
			    	Accounts rcust = new Accounts();
			    	break;
			    }
			}

	}
}

