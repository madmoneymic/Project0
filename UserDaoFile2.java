package com.revature.dao;

import java.util.List;

import com.revature.beans.User;

	/**
	 * Implementation of UserDAO that reads and writes to a file
	 */
	public class UserDaoFile2 implements UserDao {
		
		public static String fileLocation = "";
		FileWriter doc = new FileWriter;
	    FileReader obs = new FileReader;

		public User addUser(User user) {
			// TODO Auto-generated method stub
			doc.write(filename,append);
			System.out.println("User added successfully!!!!")
			return user;
		}

		public User getUser(Integer userId) {
			// TODO Auto-generated method stub
			do {
				obs.read(filename,filebuffer,0,7);
				if (userId == filebuffer)
				{
					user.userId=filebuffer;
					obs.read(filename,filebuffer,9,22);
					user.firstName=filebuffer;
					obs.read(filename,filebuffer,23,37);
					user.lastName=filebuffer;
					obs.read(filename,filebuffer,39,53);
					user.userName=filebuffer;
					obs.read(filename,filebuffer,54,62);
					user.password=filebuffer;
					obs.read(filename,filebuffer,64,73);
					user.usertype=filebuffer;
				}
				}while(obs.hasnext!='EOF');	
			return User;
		}

		public User getUser(String username, String pass) {
			// TODO Auto-generated method stub
			do {
				obs.read(filename,filebuffer,39,53);
				if (username.equalsto(filebuffer))
				{
					user.username=filebuffer;
					obs.read(filename,filebuffer,54,62);
					user.password=filebuffer;
					obs.read(filename,filebuffer,0,7);
					user.userId=filebuffer;
					obs.read(filename,filebuffer,9,22);
					user.firstName=filebuffer;
					obs.read(filename,filebuffer,23,37);
					user.lastName=filebuffer;
					obs.read(filename,filebuffer,64,73);
					user.usertype=filebuffer;
					boolean TRUE;
				}
				}while(obs.hasnext!='EOF');	
			return User;
		}

		public List<User> getAllUsers() {
			// TODO Auto-generated method stub
			do {
				    obs.read(filename,filebuffer,0,7);
					user.userId=filebuffer;
					obs.read(filename,filebuffer,9,22);
					user.firstName=filebuffer;
					obs.read(filename,filebuffer,24,38);
					user.lastName=filebuffer;
					obs.read(filename,filebuffer,40,54);
					user.userName=filebuffer;
					obs.read(filename,filebuffer,55,63);
					user.password=filebuffer;
					obs.read(filename,filebuffer,65,74);
					user.usertype=filebuffer;
					List.add(User);
				}while(obs.hasnext!='EOF');	
			return List<User>;
		}

		public User updateUser(User u) {
			// TODO Auto-generated method stub
			do {
				obs.read(filename,filebuffer,0,7);
				if (userId == filebuffer)
				{
					user.userId=filebuffer;
					obs.read(filename,filebuffer,9,22);
					user.firstName=filebuffer;
					obs.read(filename,filebuffer,23,37);
					user.lastName=filebuffer;
					obs.read(filename,filebuffer,39,53);
					user.userName=filebuffer;
					obs.read(filename,filebuffer,54,62);
					user.password=filebuffer;
					obs.read(filename,filebuffer,64,73);
					user.usertype=filebuffer;
				}
				}while(obs.hasnext!=EOF);	
			return null;
		}

		public boolean removeUser(User u) {
			// TODO Auto-generated method stub
			private char c;
			Scanner ask = new Scanner(system.in);
			do {
				obs.read(filename,filebuffer,0,7);
				if (userId == filebuffer)
				{
					user.userId=filebuffer;
					obs.read(filename,filebuffer,9,22);
					user.firstName=filebuffer;
					obs.read(filename,filebuffer,23,37);
					user.lastName=filebuffer;
					obs.read(filename,filebuffer,39,53);
					user.userName=filebuffer;
					obs.read(filename,filebuffer,54,62);
					user.password=filebuffer;
					obs.read(filename,filebuffer,64,73);
					user.usertype=filebuffer;
					System.out.println("Are you sure you want this user removed?(Y/N)");
					c=(char) ask.nextbyte();
				}
				}while(obs.hasnext!='EOF');
			    if (c=="Y")||(c=="y")
			      return true;
			return false;
		}
	private void write(User user,0,100) {
	}

}
