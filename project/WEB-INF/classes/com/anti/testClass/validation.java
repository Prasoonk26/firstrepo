package com.anti.testClass;
import java.util.regex.Pattern;

public class validation {

	
	public static void main(String args[]) {
	      
        // Regular expression in Java to check if String is number or not
        Pattern pattern = Pattern.compile(".*[^0-9].*");
       //Pattern pattern = Pattern.compile(".*\\D.*");
       String input="1234567896";
       
       System.out.println("does value "+input+ "is"+!pattern.matcher(input).matches());
      
     
      
       // Regular expression in java to check if String is 6 digit number or not
       String  numbers = "12365874";
       Pattern digitPattern = Pattern.compile("\\d{6}");       
       //Pattern digitPattern = Pattern.compile("\\d\\d\\d\\d\\d\\d");
       

      /* for(String number: numbers){
           System.out.println( "does " + number + " is 6 digit number : "
                               + digitPattern.matcher(number).matches());
       }*/
       
       System.out.println("does value 6 digits  "+input+ "is"+!digitPattern.matcher(input).matches());
       
       
       String s1="1234567896";
       
    /*   Pattern pattern1=pattern.compile(".*[^0-9].*")("\\d{6}");*/
       
    }

}




