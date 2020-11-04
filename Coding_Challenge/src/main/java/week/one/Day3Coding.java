package week.one;

public class Day3Coding {

		// TODO Auto-generated method stub
		
		public static void main(String[] args) {

			int []nums= {-1,7,11,15};
		    int target =6;
				for (int i=0;i<nums.length;i++) 
				{
					for (int j=1+i;j<nums.length;j++) 
					{
					if(target==(nums[j]+nums[i]))
					{
						System.out.println("The indices of two numbers "+i+", "+j);
						break;
					}
					}

			}

	}

}
