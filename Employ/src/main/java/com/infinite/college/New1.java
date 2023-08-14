
	package com.infinite.college;

	import java.util.Calendar;

	public class New1 {
	    public static void main(String[] args) {
	        Calendar calendar = Calendar.getInstance();
	        int year = calendar.get(Calendar.YEAR);
	        System.out.println(year);
	        
	        if (year == 0) {
	            System.out.println("Year is 0");
	            // Perform necessary actions based on the condition
	        } else {
	            System.out.println("Year is not 0");
	        }
	    }
	

}
