package com.hexaware;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class TestEmployeeSet {

	public static void main(String[] args) {
		Employee e1 = new Employee(100,"Amit",LocalDate.of(1997, 02, 11), 50000);
		Employee e2 = new Employee(100,"Amit",LocalDate.of(1997, 02, 11), 50000);
		Employee e3 = new Employee(200,"Sumit",LocalDate.of(1998, 03, 11), 10000);
		
		
		Set<Employee> set = new HashSet<>();
		set.add(e1);
		set.add(e2);
		set.add(e3);
		System.out.println("total employee: "+set.size());
     
	}

}
