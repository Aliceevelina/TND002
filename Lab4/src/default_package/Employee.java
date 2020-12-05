package default_package;


public abstract class Employee extends Object implements Comparable<Employee> {
	
	public String firstName;
	public String secondName;
	public int employeeNumber;
	public double salary;
	public static int sortCriterion;
	
	public static final int BYNAME = 0;
	public static final int BYSALARY = 1;
	public static final int BYTAXES = 2;
	
	Employee(String arg1, String arg2, int arg3, double arg4){
		firstName = arg1;
		secondName = arg2;
		employeeNumber = arg3;
		salary = arg4;
		sortCriterion = 0;
	}
	
//	Changes action depending on what the user wants to do
	public static void changeCriterion(int arg) {
		if(arg == BYNAME) {
			sortCriterion = arg;
		}
		else if(arg == BYSALARY) {
			sortCriterion = arg;
		}
		else if (arg == BYTAXES){
			sortCriterion = arg;
		}
	}
	
	public abstract double computeTaxes();
	
	public String getName() {
		return secondName;
	}
	
	public int getNumber() {
		return employeeNumber;
	}
	
	public double getSalary() {
		return salary;
	}
	
//	Output sorted
	public String toString() {
		String result = "Error!";
		
		
		if(sortCriterion == BYNAME) {
			result = String.format("%-12s%-12s%-8d\n", firstName, secondName, employeeNumber);
		}
		else if (sortCriterion == BYSALARY) {
			result = String.format("%-12s%-12s%-8d%-20.6f\n", firstName, secondName, employeeNumber, salary);
		}
		else if (sortCriterion == BYTAXES) {
			double taxes = computeTaxes();
			result = String.format("%-12s%-12s%-8d%-20.6f\n", firstName, secondName, employeeNumber, taxes);
		}
		
		
		return result;
	}
	

}