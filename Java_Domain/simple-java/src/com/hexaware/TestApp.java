package com.hexaware;

import java.util.Scanner;

public class TestApp {
    public static void main(String[] args) {
	System.out.println("Welcome to domain training");
	Scanner sc = new Scanner(System.in);
	System.out.println("enetr any text");
	String word = sc.next();
	System.out.println("enter a number");
	int num = sc.nextInt();
	System.out.println("Word: "+word+",Number: "+num);
	sc.close();
}
}
