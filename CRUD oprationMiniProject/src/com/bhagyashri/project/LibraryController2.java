package com.bhagyashri.project;

import java.sql.SQLException;
import java.util.Scanner;

public class LibraryController2 {

	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		LibraryOpration2 bo=new LibraryOpration2();
		Scanner s1=new Scanner(System.in);
		System.out.println("Please select your choice");
		while(true)
		{
		System.out.println("Insert the data ");
		System.out.println("Read library data");
		System.out.println("update library data");
		System.out.println("delete library data");
		System.out.println();
	    System.out.println("enter your choice");	
			
		int choice=s1.nextInt();
		switch(choice) {
		case 1 : bo.create();
		System.out.println();
		break;
		case 2 : bo.read();
		System.out.println();
		break;
		case 3 : bo.update();
		System.out.println();
		break;
		
		case 4 : bo.delete();
		System.out.println();
		break;
		default : System.out.println("invalid choice");
		
			
			
		}	
		}
		
	
		
		
	}
}
