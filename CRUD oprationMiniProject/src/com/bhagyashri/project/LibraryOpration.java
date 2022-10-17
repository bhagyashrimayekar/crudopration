package com.bhagyashri.project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class LibraryOpration {

	Scanner s = new Scanner(System.in);
	Scanner s2 = new Scanner(System.in);
	Library b = new Library();

	public void create() throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.jdbc.Driver");

		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/liabrary", "root", "root");

		System.out.println("how many student issues books");
		int count = s.nextInt();
		for (int i = 1; i <= count; i++) {
			Library b = new Library();
			System.out.println("enter book id");
			b.setBookid(s.nextInt());
			System.out.println("enter book name");
			b.setBookname(s2.nextLine());
			System.out.println("enter student name");
			b.setStudentname(s2.nextLine());
			System.out.println("enter issue date");
			b.setIssuedate(s.next());
			String sql = "insert into liabrarydata values( '" + b.getBookid() + "','" + b.getBookname() + "','"
					+ b.getStudentname() + "','" + b.getIssuedate() + "')";

			Statement stmt = con.createStatement();

			stmt.executeUpdate(sql);

			System.out.println("Data Inserted");

		}

	}

	public void read() throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.jdbc.Driver");

		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/liabrary", "root", "root");
		System.out.println("enter book id");
		int a=s.nextInt();
		
		String sql = "Select * from liabrarydata where bookid='"+a+"' ";
		Statement stmt = con.createStatement();

		ResultSet rs = stmt.executeQuery(sql);
		while (rs.next()) {
			System.out.println(rs.getInt(1));
			System.out.println(rs.getString(2));
			System.out.println(rs.getString(3));
			System.out.println(rs.getString(4));
			System.out.println();

		}

	}

	public void update() throws ClassNotFoundException, SQLException {
		

		Class.forName("com.mysql.jdbc.Driver");

		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/liabrary", "root", "root");
	while(true)
	{
	System.out.println("update book name");	
	System.out.println("update student name");	
	System.out.println("update issue date");
	System.out.println("exit");
	System.out.println("enter your choice");	
		int choice=s.nextInt();
	switch(choice) {
	case 1 :
		System.out.println("enter book id");
		int a=s.nextInt();
		System.out.println("enter book name");
		String s1=s2.nextLine();
		String sql1 = "Update liabrarydata set bookname='"+s1+"' where bookid='"+a+"' ";
         Statement stmt1 = con.createStatement();
		
		stmt1.executeUpdate(sql1);
		break;
	case 2 :
		System.out.println("enter book id");
		int b=s.nextInt();
		System.out.println("enter student name");
		String s3=s2.nextLine();
		String sql2 = "Update liabrarydata set studentname='"+s3+"' where bookid='"+b+"' ";
		
		Statement stmt2 = con.createStatement();
		
		stmt2.executeUpdate(sql2);
		break;
		
	case 3 :
		System.out.println("enter book id");
		int c=s.nextInt();
		System.out.println("enter issue date");
		String s4=s2.nextLine();
		String sql3 = "Update liabrarydata set issuedate='"+s4+"' where bookid='"+c+"' ";
		
		Statement stmt3 = con.createStatement();
		
		stmt3.executeUpdate(sql3);	
		break;
	case 4 :System.exit(0);
	}
	}
	}

	public void delete() throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.jdbc.Driver");

		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/liabrary", "root", "root");

		System.out.println("enter book id");
		int d =s.nextInt();

		String sql = "delete from liabrarydata where bookid='"+d+"'";
		Statement stmt = con.createStatement();

		stmt.executeUpdate(sql);

	}

}
