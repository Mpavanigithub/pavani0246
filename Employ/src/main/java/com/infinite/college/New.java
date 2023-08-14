package com.infinite.college;

    	import java.time.Year;

    	public class New {
    	    public static void main(String[] args) {
    	        Year year = Year.of(1998); // Create a Year object with the year 0

    	        if (year.getValue() == 0) {
    	            System.out.println("Year is 0");
    	            // Perform necessary actions based on the condition
    	        } else {
    	            System.out.println("Year is not 0");
    	        }
    	   
    }
}
