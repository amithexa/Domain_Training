package com.hexaware;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TestDateApi {
	public static void main(String[] args) {
		LocalDate date = LocalDate.now();
		System.out.println("Date :"+date);
		DateTimeFormatter db = DateTimeFormatter.ofPattern("dd/mm/yyyy");
		System.out.println("date:"+date.format(db));
	}

}
