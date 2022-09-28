package com.infinite.bank;

import java.sql.SQLException;
import java.util.Scanner;

public class DepositAccount {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int accountNo;
		double depositAmount;
		System.out.println("Enter AccountNo ");
		accountNo = sc.nextInt();
		System.out.println("Enter DepositAmount ");
		depositAmount = sc.nextDouble();
		BankDAO dao = new BankDAO();
		try {
			System.out.println(dao.depositAccount(accountNo, depositAmount));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
	}

}
