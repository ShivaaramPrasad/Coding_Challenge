package week.one;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Day3Coding_sri {

		// TODO Auto-generated method stub
		
		public static void main(String[] args) {

			int[] Score = {-1,9,1,9,8,7,6,5,4,3,2,1,0};
			int Target = 8;
			System.out.println("Orginal Array is: "+Arrays.toString(Score));
			Set<Integer> scoreSet = new HashSet<Integer>();
			for(Integer each : Score) {
				scoreSet.add(each);
			}
			
			Integer[] finalScore = new Integer[scoreSet.size()]; 
			int k=0; 
			for(Integer each : scoreSet) {
				finalScore[k++]=each; 
			} 
			System.out.println("Sorted Array is: "+Arrays.toString(finalScore));
			System.out.println("Targeted Number Order is: ");
			
			for(int i=0;i<finalScore.length;i++) 
			{ for(int j=1;j<finalScore.length;j++) {
				if((Target == finalScore[i]+finalScore[j]) && (finalScore[i]<finalScore[j])) {
					System.out.println("["+i+","+j+"]"); 
				} 
			} 
			}


		}

	}
