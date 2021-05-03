/**
 * 
 */
package javaProject;

//import java.io.BufferedReader;
import java.util.concurrent.ThreadLocalRandom;

import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.FileReader;
//import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;



/**
 * @author Japan Patel
 *
 */
public class User {

	/**
	 * @param args
	 */
	//variable declarations
	//fname = store first name of user
	//lname = store last name of user
	//address = store address of user
	//dob = store date of birth of user
	//email = store email of user
	//user_id = store user_id of user
	//saving_account = store saving account no of user
	//current_account = store current account of user
	//saving_account_balance = store saving account balance of user
	//current_account_balance = store current_account_balance of user
	//contact_no = store contact no of user
	//sin_no = store sin no of user
	
	private String Fname,Lname,Address,DOB,Email,User_id;
	private int Savings_Account, Current_Account,Saving_Account_Balance,Current_Account_Balance;;
	//private double 
	private long SIN_no,Contact_no;
	
	public User() 
	{
		/**
		 * User constructor without arguments
		 */
		this.Fname="";
		this.Lname="";
		this.Address="";
		this.DOB="";
		this.Email="";
		this.User_id="";
		this.SIN_no=0;
		this.Contact_no=0;
		this.Savings_Account=0;
		this.Current_Account=0;
		this.Saving_Account_Balance=0;
		this.Current_Account_Balance=0;
	}
	
	public User(String Fname,String Lname,String Address, String DOB, String Email,long Contact_no, String acctype_choice,  long SIN_no) 
	{
		/**
		 * User constructor with arguments
		 */
		this.Fname=Fname;
		this.Lname=Lname;
		this.Address=Address;
		this.DOB=DOB;
		this.Email=Email;
		this.User_id= Fname.toLowerCase() + Lname.toLowerCase() + String.valueOf(ThreadLocalRandom.current().nextInt(100,1000));
		this.SIN_no=SIN_no;
		this.Contact_no=Contact_no;
		if(Integer.parseInt(acctype_choice) == 1)
		{
			this.Savings_Account = ThreadLocalRandom.current().nextInt(1000000,10000000);
			this.Current_Account = 0;
		}
		else if(Integer.parseInt(acctype_choice) == 2)
		{
			this.Savings_Account = 0;
			this.Current_Account = ThreadLocalRandom.current().nextInt(1000000,10000000);
		}
		else if(Integer.parseInt(acctype_choice) == 3)
		{
			this.Savings_Account = ThreadLocalRandom.current().nextInt(1000000,10000000);
			this.Current_Account = ThreadLocalRandom.current().nextInt(1000000,10000000);
		}
		this.Saving_Account_Balance=0;
		this.Current_Account_Balance=0;
		//this.Saving_Account_Balance=0;
	}
	//Getter methods for variables
	public String getFname() {
		return Fname;
	}
	public String getLname() {
		return Lname;
	}
	public String getAddress() {
		return Address;
	}
	public String getDOB() {
		return DOB;
	}
	public String getEmail() {
		return Email;
	}
	public String getUser_id() {
		return User_id;
	}
	public long getSIN_no() {
		return SIN_no;
	}
	public long getContact_no() {
		return Contact_no;
	}
	public int getSavings_Account() {
		return Savings_Account;
	}
	public int getCurrent_Account() {
		return Current_Account;
	}
	public double getSaving_Account_Balance() {
		return Saving_Account_Balance;
	}
	public double getCurrent_Account_Balance() {
		return Current_Account_Balance;
	}
	//Setter methods for variable
	public void setFname(String Fname) {
		 this.Fname = Fname;
	}
	public void setLname(String Lname) {
		 this.Lname = Lname;
	}
	public void setAddress(String Address) {
		 this.Address = Address;
	}
	public void setDOB(String DOB) {
		 this.DOB = DOB;
	}
	public void setEmail(String Email) {
		 this.Email = Email;
	}
	public void setUser_id(String User_id) {
		 this.User_id = User_id;
	}
	public void setSIN_no(int SIN_no) {
		 this.SIN_no = SIN_no;
	}
	public void setContact_no(int Contact_no) {
		 this.Contact_no = Contact_no;
	}
	public void setSavings_Account(int Savings_Account) {
		//System.out.println(getSavings_Account());
		this.Savings_Account = Savings_Account;
	}
	public void setCurrent_Account(int Current_Account) {
		 this.Current_Account = Current_Account;
	}
	public void setSaving_Account_Balance(int Saving_Account_Balance) {
		 this.Saving_Account_Balance = Saving_Account_Balance;
	}
	public void setCurrent_Account_Balance(int Current_Account_Balance) {
		 this.Current_Account_Balance = Current_Account_Balance;
	}
	
	public void save() throws IOException
	{
		/**
		 * Method will create a file (user_id) and will save the details of the user.
		 */
		File file = new File(String.valueOf(this.User_id)+".txt");
		PrintWriter pw = new PrintWriter(file);
		pw.println("User ID : "+String.valueOf(this.User_id));
		pw.println("First Name : "+this.Fname);
		pw.println("Last Name : "+this.Lname);
		pw.println("Address : "+this.Address);
		pw.println("DOB : "+this.DOB);
		pw.println("Email : "+this.Email);
		pw.println("Contact no : "+String.valueOf(this.Contact_no));
		pw.println("Savings Account no : "+String.valueOf(this.Savings_Account));
		pw.println("Current Account no : "+String.valueOf(this.Current_Account));
		pw.println("Saving Account Balance : "+String.valueOf(this.Saving_Account_Balance));
		pw.println("Current Account Balance : "+String.valueOf(this.Current_Account_Balance));
		pw.println("SIN no : "+String.valueOf(this.SIN_no));
		pw.close();
	}
	public void Update(String User_id,String OldValue, String NewValue, String startwith,String type) throws IOException 
	{
		/**
		 * Methods is used to update the details of user in file
		 * filecontents = store the user data which is fetched from file
		 * newcontents = store the user data with the update value.
		 * val = store the digits(oldvalue) which are found from string(like saving balance, current balance)
		 * updatedvalue = store the newly changed value.
		 * User_id = represent the unique user_id of user
		 * Oldvalue = represents the old value (which we want to update)
		 * newValue = represents the new value (which we want to update)
		 * startwith = represents the string in which we want to update the data
		 * type = represents which type of update method we need(like debit,credit,etc)
		 *
		 */
		File file = new File(User_id);
	      Scanner sc = new Scanner(file);
	      String fileContents="";
	      while(sc.hasNext())
	      {
	    	  fileContents = fileContents + sc.nextLine() +"\n";
	      }
	      String[] contentarr = fileContents.split("\n");
	      String newcontents="",uvalue="",val="";
	      int updatedValue=0;
	      for(String str : contentarr)
	      {
	    	  if(str.startsWith(startwith))
	    	  {
	    		  if(type.equals("deposit"))
	    		  {
	    			  val = findDigitValue(str);
	    			  updatedValue = Integer.parseInt(val) + Integer.parseInt(NewValue);
	    			  uvalue = String.valueOf(updatedValue);
	    		  }
	    		  else if(type.equals("debit"))
	    		  {
	    			  val = findDigitValue(str);
	    			  updatedValue = Integer.parseInt(val) - Integer.parseInt(NewValue);
	    			  uvalue = String.valueOf(updatedValue);
	    		  }
	    		  else if(type.equals("mobile"))
	    		  {
	    			  val = findDigitValue(str);
	    			  uvalue = NewValue;
	    		  }
	    		  else if(type.equals("sin"))
	    		  {
	    			  val = findDigitValue(str);
	    			  uvalue = NewValue;
	    		  }
	    		  else
	    		  {
	    			  String[] arr = str.split("[:]", 0);
	    			  val = arr[1];
	    			  uvalue = NewValue;
	    		  }
	    		  str = str.replace(val,uvalue);
	    		  newcontents = newcontents + str + "\n";
	    	  }else {
	    		  newcontents = newcontents + str + "\n";
	    	  }
	      }
	      sc.close();
	      file.delete();
	      File newfile = new File(User_id);
	      PrintWriter pw = new PrintWriter(newfile);
	      pw.println(newcontents);
	      pw.close();
	}
	
	private String findDigitValue(String fileData) {
		/**
		 * Method will identify the digit in string and returns digit in a string format
		 */
		StringBuilder sb= new StringBuilder();
		char[] arr = fileData.toCharArray();
		for(char ch : arr)
		{
			if(Character.isDigit(ch))
			{
				sb.append(ch);
			}
		}
		return sb.toString();
	}
}
