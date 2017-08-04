import java.io.Serializable;

public class User implements Serializable 
{
	private BankAccount account;
	private CreditCard  card;
	
	public User()
	{
		account = new BankAccount();
		card = new CreditCard();
	}
	
	public User(BankAccount b, CreditCard c)
	{
		account = b;
		card = c;
	}
	
	public BankAccount getBankAccount()
	{
		return account;
	}
	
	public void setBankAccount(BankAccount b)
	{
		account = b;
	}
	
	public CreditCard getCreditCard()
	{
		return card;
	}
	
	public void setCreditCard(CreditCard c)
	{
		card = c;
	}
	
}
