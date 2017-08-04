import java.io.Serializable;

public class Charge implements Serializable, Comparable<Charge>
{
	private Date date;
	private String description;
	private double amount;
	
	public Charge()
	{
		date = new Date(3, 22, 2017);
		description = "charge";
		amount = 0.0;
	}
	
	public Charge(Date d, String descr, double a)
	{
		date = d;
		description = descr;
		amount = a;
	}
	
	public void setDate(Date d)
	{
		date = d;
	}
	
	public Date getDate()
	{
		return date;
	}
	
	public void setDescription(String descr)
	{
		description = descr;
	}
	
	public String getDescription()
	{
		return description;
	}
	
	public void setAmount(Double a)
	{
		amount = a;
	}
	
	public Double getAmount()
	{
		return amount;
	}
	
	public String toString()
	{
		String s;
		
		s = "\n" + date + " | " + description + " | $" + amount + "\n";
		
		return s;
	}

	@Override
	public int compareTo(Charge arg0) 
	{		
		return this.getDate().compareTo(arg0.getDate());
	}
}
