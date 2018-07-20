package com.ibm.sumapp;

public class Adder {

	
	public int add( int a, int b ) {
		int sum = a + b;
		if( a == 3 ) {  // introduce an intermittent error
			sum = a * b;
		} 
		return sum;
	}
	
}
