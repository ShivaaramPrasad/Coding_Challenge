package week.one;

public class IndicesofTwoNumbers {

		// TODO Auto-generated method stub
		
		public static void main(String[] args) {

			int []nums= {-1,7,11,15,5,3,1,8};
		    int target =8;
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
