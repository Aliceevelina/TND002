package default_package;

import java.util.*;

public class Company extends Object {
	
	ArrayList<Employee> employees;
	
	Company(){
		employees = new ArrayList<Employee>();
	}
	
//	method for adding an employee that is a director
	public void addEmployee(Director arg) {
		employees.add(arg);
	}
//	method for adding a employee that is a worker
//	method checks if the worker already exists in the arraylist, if not the worker gets added and connected to a director
	public void addEmployee(Worker arg1, Director arg2) {
		if (employees.contains(arg1)) {
			System.out.println("The worker already exists!");
		}
		
		else {
			employees.add(arg1);
			arg2.addEmployee(arg1);
		}
	}
	
//	output sorted
	public String toString() {
		String result;
		result = "LIST OF EMPLOYEES\n";
		result = result + "-------------------------\n";
		result = result + String.format("%-12s%-12s%-8s", "First name","Surname","Number");
		if(Employee.sortCriterion == 0) {
			Collections.sort(employees);
			result = result + "\n";
		}
		else if(Employee.sortCriterion == 1) {
			Collections.sort(employees);
			result = result + "Salary\n";
		}
		else if(Employee.sortCriterion == 2) {
			Collections.sort(employees);
			result = result + "Taxes\n";
		}
		for (int i = 0; i < employees.size(); i++) {
			result = result + "\n" + employees.get(i).toString();
		}
		
		return result;
	}
}