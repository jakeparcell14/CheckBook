import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class CheckBook 
{

	public static void main(String[] args) 
	{
		String fileName = "UserData.dat";
		File f = new File(fileName);
		User userName;

		if(f.exists())
		{
			userName = readFromFile(f);
		}
		else
		{
			userName = new User();
		}

		Scanner in = new Scanner(System.in);

		int userChoice = 0;

		do
		{
			createMenu();

			if(in.hasNextInt())
			{
				userChoice = in.nextInt();

				processMenuChoice(userChoice, userName);
			}
		}
		while(userChoice != 7);
		
		//saves data to file
		writeToFile(f, userName);


	}

	public static void createMenu()
	{
		System.out.println("1. Add Credit Card Charge");
		System.out.println("2. View Monthly Credit Card Statement");
		System.out.println("3. View Bank Account Balance");
		System.out.println("4. View Total Monthly Credit Card Bill");
		System.out.println("5. Update Bank Account Balance");
		System.out.println("6. Update Credit Card Information");
		System.out.println("7. Exit");
	}

	public static void processMenuChoice(int choice, User userName)
	{
		switch(choice)
		{
		case 1:
			addUserCharge(userName);
			break;

		case 2:
			Scanner in = new Scanner(System.in);
			System.out.print("Enter month you wish to access: ");
			//TODO make idiotproof in gui with dropdown menu
			int month = in.nextInt();
			ArrayList<Charge> statement = userName.getCreditCard().getStatement().get(month - 1);
			Collections.sort(statement);
			System.out.println("Credit Card Statement: \n" + statement.toString() + "\n");
			break;

		case 3:
			double balance =  userName.getBankAccount().getBalance();
			System.out.println("Bank Account Balance: $" + balance + "\n");
			break;

		case 4:
			double totalBill = userName.getCreditCard().getTotalMonthlyBill(8); //TODO get month either automatically or from user
			System.out.println("Total Credit Card Bill: $" + totalBill + "\n");
			break;

		case 5:
			updateUserBalance(userName);
			break;

		case 6:
			break;

		case 7:
			//ends program
			break;

		default:
			System.out.println("Invalid Entry");
			break;
		}
	}

	public static void addUserCharge(User u)
	{
		Scanner in = new Scanner(System.in);

		System.out.print("Charge Date: ");
		String d = in.nextLine();
		Date date = new Date(d);
		
		System.out.print("Charge Description: ");
		String description = in.nextLine();

		System.out.print("Charge Amount: $");

		while(!in.hasNextDouble())
		{
			System.out.println("Invalid Entry");
			System.out.print("Charge amount: $");
		}

		Double amount = in.nextDouble();

		u.getCreditCard().addCharge(date, description, amount);
	}

	public static void updateUserBalance(User userName)
	{
		Scanner in = new Scanner(System.in);
		
		System.out.print("Enter updated balance: $");
		
		while(!in.hasNextDouble())
		{
			System.out.println("Invalid Entry");
			System.out.print("Balance: $");
		}
		
		Double balance = in.nextDouble();
		
		userName.getBankAccount().setBalance(balance);
	}
	
	/**
	 * Extracts User object from a given file name
	 * @param fileName name of a given file
	 * @return User data from given file
	 */
	public static User readFromFile(File fileName)
	{
		User u = new User();

		if(!fileName.exists())
		{
			//file with given name does not exist
			return u;
		}
		else
		{
			//file with given name exists
			try 
			{
				ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName));

				try
				{
					u = (User) in.readObject();
				}
				catch(ClassCastException e)
				{

				}

				in.close();
			} 
			catch (FileNotFoundException e) 
			{
				System.out.println("File Not Found");
			} 
			catch (IOException e) 
			{
				System.out.print(e);
				System.out.println("Error Retrieving Data from File");
			} 
			catch (ClassNotFoundException e) 
			{
				System.out.println("Error Retrieving Data from File");
			}

			return u;
		}
	}

	/**
	 * saves User object to a file with a given file name
	 * @param fileName file to which User object is saved
	 * @param u User object that is saved
	 */
	public static void writeToFile(File fileName, User u)
	{
		try 
		{
			if(!fileName.exists())
			{
				fileName.createNewFile();
			}
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName));

			out.writeObject(u);

			out.close();
		} 
		catch (FileNotFoundException e) 
		{
			System.out.println("File Not Found");
		} 
		catch (IOException e) 
		{
			System.out.println(e);
			System.out.println("Error Writing to File");
		}
	}
}
