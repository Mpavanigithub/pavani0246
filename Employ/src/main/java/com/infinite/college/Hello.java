package com.infinite.college;

import java.util.Calendar;

public class Hello {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, 0);
        int year = calendar.get(Calendar.YEAR);
        System.out.println(year);
        
        if (year == 1) {
            System.out.println("Year is  0");
           
        } else {
            System.out.println("Year is not 0");
        }
    }
}
