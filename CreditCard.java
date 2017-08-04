import java.io.Serializable;
import java.util.*;

public class CreditCard implements Serializable 
{	
	//private ArrayList<Charge> monthlyStatement;
	//private ArrayList<Charge>[] monthlyStatement;
	private ArrayList<ArrayList<Charge>> monthlyStatement;
	private double totalMonthlyBill;
	private int monthlyBillDate;
	
	public CreditCard()
	{
		//monthlyStatement = new ArrayList<Charge>();
		//monthlyStatement = new ArrayList<Charge>[12];
		monthlyStatement = new ArrayList<ArrayList<Charge>>(12);
		
		for(int i = 0; i < 12; i++)
		{
			monthlyStatement.add(new ArrayList<Charge>());
		}
		
		monthlyBillDate = 1;
		totalMonthlyBill = 0;
	}
	
	public CreditCard(int m)
	{
		//monthlyStatement = new ArrayList<Charge>();
		monthlyStatement = new ArrayList<ArrayList<Charge>>(12);
		
		for(int i = 0; i < 12; i++)
		{
			monthlyStatement.add(new ArrayList<Charge>());
		}
		
		monthlyBillDate = m;
		totalMonthlyBill = 0;
	}
	
	public ArrayList<ArrayList<Charge>> getStatement()
	{
		return monthlyStatement;
	}
	
	public void addCharge(Date date, String descr, double amount)
	{
		Charge c = new Charge(date, descr, amount);
		
		int month = date.getMonth();
		
		//get arraylist at correct index
		ArrayList<Charge> temp = monthlyStatement.get(month - 1);
		
		//add charge to arraylist
		temp.add(c);
		
		//add updated arraylist to correct index
		monthlyStatement.set(month - 1, temp);
	}
	
	public double getTotalMonthlyBill(int month)
	{
		double sum = 0;
		
		for(Charge c : monthlyStatement.get(month - 1))
		{
			sum += c.getAmount();
		}
		
		return sum;
	}
	
	public String toString()
	{
		String s;
		String suffix;
		
		if(monthlyBillDate == 1)
		{
			suffix = "st";
		}
		else if(monthlyBillDate == 2)
		{
			suffix = "nd";
		}
		else if(monthlyBillDate == 3)
		{
			suffix = "rd";
		}
		else
		{
			suffix = "th";
		}
		
		s = "Pay Credit Card Bill on day: " + monthlyBillDate + suffix + "\n\n"
		  + "Monthly Statement: \n" 
		  +  monthlyStatement.toString() + "\n\n" 
		  + "Total monthly bill: " + totalMonthlyBill;
		
		return s;
	}
}
