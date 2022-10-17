package com.bhagyashri.project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class LibraryOpration2 {
	
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
			String sql = "insert into liabrarydata2 values(?,?,?,?)";
			

			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1,b.getBookid());
			ps.setString(2, b.getBookname());
			ps.setString(3, b.getStudentname());
			ps.setString(4, b.getIssuedate());

			ps.executeUpdate();

			System.out.println("Data Inserted");

		}

	}

	public void read() throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.jdbc.Driver");

		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/liabrary", "root", "root");
		String sql = "Select * from liabrarydata2 where bookid=?";
		PreparedStatement ps = con.prepareStatement(sql);
		System.out.println("enetr book id");
		int a=s.nextInt();
ps.setInt(1, a);
		ResultSet rs = ps.executeQuery();
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
	
		
		
		
		String sql = "Update liabrarydata2 set studentname=? where bookid=?";
		System.out.println("enter book id");
		int a=s.nextInt();
		System.out.println("enter student name");
		String s=s2.nextLine();
		
		
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(2, a);
		ps.setString(1, s);

		ps.executeUpdate();

	}
	public void delete() throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.jdbc.Driver");

		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/liabrary", "root", "root");
		String sql ="delete from liabrarydata2 where bookid=?";
		PreparedStatement ps= con.prepareStatement(sql);
		
		System.out.println("enter book id");
		int a=s.nextInt();
		ps.setInt(1,a);
		ps.executeUpdate();

	
	}
	
	
	
	

}
