import java.io.Serializable;

public class BankAccount implements Serializable 
{
	private double balance;
	
	public BankAccount()
	{
		balance = 0;
	}
	
	public BankAccount(double b)
	{
		balance = b;
	}
	
	public double deposit(double d)
	{
		balance += d;
		return balance;
	}
	
	public double withdraw(double w)
	{
		if(!overdraft(w))
		{
			balance -= w;
			return balance;
		}
		else
		{
			System.out.println("Transaction Failed. Insufficient Funds.");
			return -1;
		}
	}
	
	public double getBalance()
	{
		return balance;
	}
	
	public void setBalance(Double b)
	{
		balance = b;
	}
	
	public boolean overdraft(double amount)
	{
		if(amount > balance)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}
