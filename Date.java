import java.io.Serializable;

public class Date implements Serializable, Comparable<Date>
{

	private int year;
	private int month;
	private int day;

	public Date()
	{
		day = 1;
		month = 1;
		year = 1995;
	}

	public Date(int d, int m, int y)
	{
		day = d;
		month = m;
		year = y;		
	}

	public Date(String d)
	{
		month = Integer.parseInt(d.substring(0,2));
		day = Integer.parseInt(d.substring(3, 5));
		year = Integer.parseInt(d.substring(6));
	}

	public String toString()
	{
		String m = Integer.toString(month);

		String d = Integer.toString(day);

		if(month < 10)
		{
			m = "0" + month;
		}

		if(day < 10)
		{
			d = "0" + day;
		}


		String date = m + "/" + d + "/" + this.year;

		return date;
	}

	public int getDay()
	{
		return day;
	}

	public int getMonth()
	{
		return month;
	}

	public int getYear()
	{
		return year;
	}

	@Override
	public int compareTo(Date arg0) 
	{
		int year1 = this.getYear();
		int year2 = arg0.getYear();

		if(year1 == year2)
		{
			int month1 = this.getMonth();
			int month2 = arg0.getMonth();

			if(month1 == month2)
			{
				int day1 = this.getDay();
				int day2 = arg0.getDay();

				//if years and months are equal, compare days
				return compareInt(day1, day2);
			}
			else
			{
				//if months are not equal, compare months
				return compareInt(month1, month2);
			}
		}
		else
		{
			//if years are not equal, compare years
			return compareInt(year1, year2);
		}
	}

	public static int compareInt(int i1, int i2)
	{
		if(i1 == i2)
		{
			return 0;
		}
		else if(i1 < i2)
		{
			return -1;
		}
		else
		{
			return 1;
		}
	}
}
