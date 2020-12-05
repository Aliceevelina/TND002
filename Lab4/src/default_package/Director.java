package default_package;

import java.util.ArrayList;

public class Director extends Employee {
	
	ArrayList<Worker> workers;
	
	Director(String arg1, String arg2, int arg3, double arg4){
		super(arg1, arg2, arg3, arg4);
		workers = new ArrayList<Worker>();
	}
	
	public void addEmployee(Worker arg) {
		workers.add(arg);
	}
	
	public double computeBonus() {
		double bonus;
		double comulative = 0.0;
		
		for (int i = 0; i < workers.size(); i++) {
			comulative = comulative + workers.get(i).getSalary();
		}
		
		bonus = comulative * 0.1;
		
		return bonus;
	}
	
	public double computeTaxes() {
		double total = 0.0;
		
		total = computeBonus() + getSalary();
		total = total * 0.25;
		return total;
	}
	
//	Compare different things depending how the user wants to sort everything
	public int compareTo(Employee arg) {
		
		if(sortCriterion == 0) {
			return secondName.compareTo(arg.secondName);
		}
		
		else if(sortCriterion == 1) {
			if (salary > arg.getSalary()) {
				return -1;
			}
			else if (salary < arg.getSalary()) {
				return 1;
			}
			else return 0;
		}
		
		else if(sortCriterion == 2) {
			if(computeTaxes() > arg.computeTaxes()) {
				return -1;
			}
			else if(computeTaxes() < arg.computeTaxes()) {
				return 1;
			}
			else return 0;		
		}
		return 0;
		}
}