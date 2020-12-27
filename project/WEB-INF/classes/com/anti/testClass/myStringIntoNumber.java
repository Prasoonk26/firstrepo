package com.anti.testClass;

public class myStringIntoNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String num="4";
		
		myStringIntoNumber obj=new myStringIntoNumber();
		
		int number=obj.convertIntoNumber(num);
		
		System.out.println("number is interger "+number);
		
	}
	
	public int convertIntoNumber(String num1){
		
		System.out.println("In Methods are ");
		
		System.out.println("String number is "+num1);
		
		char ch[] = num1.toCharArray();
        int sum = 0;
        //get ascii value for zero
        int zeroAscii = (int)'0';
        for(char c:ch){
            int tmpAscii = (int)c;
            System.out.println("int values in methods is"+tmpAscii);
            sum = (sum*10)+(tmpAscii-zeroAscii);
            
            System.out.println("sum values is "+sum);
        }
        return sum;
		
		
		
	}

}
