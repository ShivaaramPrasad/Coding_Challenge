package week.one;


public class RemoveVowels {

	   public static void main(String[] args)
	   {
	      String Name = "aeiou";
	      System.out.println("Given string: " + Name);
	      Name = Name.replaceAll("[AaEeIiOoUu]", "");
    	  System.out.println("After deleting vowels in given a string: " + Name);

	   }
	}

