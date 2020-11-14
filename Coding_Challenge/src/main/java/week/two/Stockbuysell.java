package week.two;

public class Stockbuysell {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int maxProfit=0;
		int []dayPrices= {8,5,10,3,6,4};

		for (int i=0;i<dayPrices.length-1;i++)
		{
			for (int j=i+1;j<dayPrices.length;j++)
			{
				int profit = dayPrices[j]-dayPrices[i];
				if(profit>maxProfit)
				{
					maxProfit=profit;
				}
			}
		}
		System.out.println("Best Profit buy for the stock "+maxProfit);
	}
}
