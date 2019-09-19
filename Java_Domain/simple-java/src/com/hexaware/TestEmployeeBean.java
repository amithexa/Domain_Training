package com.hexaware;

import java.util.List;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;

public class TestEmployeeBean {

	public static void main(String[] args) {
		List<Employee> employees = new ArrayList<>();
		employees.add(new Employee(100,"amit",LocalDate.now(),50000));
		employees.add(new Employee(200,"sumit",LocalDate.of(1997,02,11),5000));
		System.out.println("Total Employees: "+employees.size());
		
		Iterator<Employee> it = employees.iterator();
		while(it.hasNext()) {
			Employee e = it.next();
			if(e.getSalary() > 40000)
			System.out.println(e);
			}
		
	}

}
