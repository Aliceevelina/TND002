package default_package;

public class Worker extends Employee {
	
	Worker(String arg1, String arg2, int arg3, double arg4){
		super(arg1,arg2,arg3,arg4);
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
			else if (salary > arg.getSalary()) {
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
	public double computeTaxes() {
		double total = 0.0;
		
		total = getSalary();
		total = total * 0.25;
		return total;
	}
	
}