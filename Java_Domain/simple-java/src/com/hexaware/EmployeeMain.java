package com.hexaware;
import java.util.List;
import java.util.Scanner;

public class EmployeeMain {

	public static void main(String[] args) {
		int id = 0;
		String name = null;
		double salary = 0;
		int a;
		EmployeeDAO dao = new EmployeeDAO();
		do {
		System.out.println("Enter your choice");
		System.out.println("1.Store");
		System.out.println("2.Delete");
		System.out.println("3.Find By Id");
		System.out.println("4.Find All");
		System.out.println("5.Update Salary");
		System.out.println("6.Exit");
		Scanner sc = new Scanner(System.in);
		 a = sc.nextInt();
		switch(a) {
		       case 1:System.out.println("Enter the id");
		       id = sc.nextInt();
		       System.out.println("Enter the name");
               name = sc.next();
               System.out.println("Enter the salary");
               salary = sc.nextDouble();
               Employee emp = new Employee(id,name,null,salary);
               int status = dao.store(emp);
               break;
		       case 2:System.out.println("Enter the id");
			   id = sc.nextInt();
			   dao.delete(id);
			   break;
		       case 3:System.out.println("Enter the id");
			   id =sc.nextInt();
			   Employee c = dao.findById(id);
			   System.out.println(c);
			   break;
		       case 4:List<Employee> list =dao.findAll();
		       for(Employee e:list) {
		       System.out.println("Id = "+e.getId()+", Name = "+e.getName()+",Salary = "+e.getSalary());
		       }
		       break;
		       case 5:System.out.println("Enter the id");
		       id = sc.nextInt();
		       System.out.println("Enter the salary");
               salary = sc.nextDouble();
               dao.UpdateSalary(id,salary);
               Employee e = dao.findById(id);
               System.out.println(e);
		       case 6:System.out.println("Thank You");
		       Runtime.getRuntime().halt(0);
		       sc.close();

		}
	}while(a != 6);
	}       
}
