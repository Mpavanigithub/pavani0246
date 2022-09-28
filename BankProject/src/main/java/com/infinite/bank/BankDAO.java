package com.infinite.bank;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BankDAO {
	 Connection connection;
     PreparedStatement pst;
     
     public String depositAccount(int accountNo,double depositAmount)
    		 throws ClassNotFoundException, SQLException {
     Bank bank = searchAccount(accountNo);
     if(bank!=null){
    	 String cmd = "update bank set status= Amount=Amount+? where AccountNo=?";
     	connection = ConnectionHelper.getConnection();
     	pst = connection.prepareStatement(cmd);
   		pst.setDouble(1, depositAmount);
   		pst.setInt(2, accountNo);
   		pst.executeUpdate();
   		cmd = "Insert into Trans(AccountNo,TransAmount,TransType )value(?,?,?)";
   		pst = connection.prepareStatement(cmd);
   		pst.setInt(1, accountNo);
   		pst.setDouble(2, depositAmount);
   		pst.setString(3, "C");
   		pst.executeUpdate();
   		return "Amount Credited  ";
   		
     }
     return "Account Not Found";
     }
     public String closeAccount(int accountNo) 
    		 throws ClassNotFoundException, SQLException {
     Bank bank = searchAccount(accountNo);
     if(bank!=null){
    	String cmd = "update bank set status= 'inactive' where AccountNo=?";
    	connection = ConnectionHelper.getConnection();
    	pst = connection.prepareStatement(cmd);
  		pst.setInt(1, accountNo);
  		pst.executeUpdate();
  		return  "Account closed  ";
     }
     return " Account not closed  ";
     }
   
     
     
     
     public Bank searchAccount(int accountNo) 
 			throws ClassNotFoundException, SQLException {
 		connection = ConnectionHelper.getConnection();
 		String cmd = "select * from Bank where AccountNo=?";
 		pst = connection.prepareStatement(cmd);
 		pst.setInt(1, accountNo);
 		ResultSet rs = pst.executeQuery();
 		Bank bank = null;
 		if(rs.next()) {
 			bank = new Bank();
 			bank.setAccountNO(rs.getInt("accountNo"));
 			bank.setFirstName(rs.getString("firstName"));
 			bank.setLastName(rs.getString("lastName"));
 			bank.setCity(rs.getString("city"));
 			bank.setState(rs.getString("state"));
 			bank.setAmount(rs.getInt("amount"));
 			bank.setCheqFacil(rs.getString("cheqFacil"));
 			bank.setAccountType(rs.getString("accountType"));
 		}
 		return bank;
 	}
     
     
     public String createAccount(Bank bank)
    	 throws ClassNotFoundException, SQLException{
    	 int accountNo = generateAccountNo();
    	 bank.setAccountNO(accountNo);
    	 String cmd = "insert into Bank(AccountNo, FirstName," +
    	 "LastName, city,State,Amount, CheqFacil,"
 				+ "AccountType) values(?,?,?,?,?,?,?,?)";
 		connection = ConnectionHelper.getConnection();
 		pst = connection.prepareStatement(cmd);
 		pst.setInt(1, accountNo);
 		pst.setString(2, bank.getFirstName());
 		pst.setString(3, bank.getLastName());
 		pst.setString(4, bank.getCity());
 		pst.setString(5, bank.getState());
 		pst.setInt(6, bank.getAmount());
 		pst.setString(7, bank.getCheqFacil());
 		pst.setString(8, bank.getAccountType());
 		pst.executeUpdate();
 		return "Account Created...";
 	}
     
     
     public int generateAccountNo() throws ClassNotFoundException, SQLException{
     connection = ConnectionHelper.getConnection();
     String cmd = "select case when max(accountNo) is Null "
     		+ " then 1 else max(accountNo)+1 end accno " + " from Bank ";
     pst = connection.prepareStatement(cmd);
     ResultSet rs = pst.executeQuery();
     rs.next();
     int accno = rs.getInt("accno");
     return accno;
     

}
}