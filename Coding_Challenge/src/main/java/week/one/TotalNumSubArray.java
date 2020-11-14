package week.one;

public class TotalNumSubArray {

		// TODO Auto-generated method stub
		
		public static void main(String[] args) {

			{
			            int[] nums = { 1, 2, 3 };
			            int k= 3;

			            int output = subarraySum(nums, k);
			            System.out.println(output);
			}
		}

			public static int subarraySum(int[] nums, int k)
			{
			            int count = 0;
			            for (int start = 0; start < nums.length; start++)
			            {
			                int sum = 0;
			                for (int end = start; end < nums.length; end++)
			                {
			                    sum += nums[end];
			                    if (sum == k)
			                        count++;
			                }
			            }
			            return count;
			}
		}