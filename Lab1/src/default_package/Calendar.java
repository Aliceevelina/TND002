package default_package;

public class Calendar {
	
	public String[][] data;
	
	public int counter;
	
	public Calendar(int size) {
		data = new String [size][5];
		counter = 0;
		}
	
	
	public String addPerson (String[] inString) {
		
		String outstring = "";
		
			if (counter > data.length){
		
			outstring = "Not added";
			return outstring;
		
			}
			else {
			for (int i = 0; i < inString.length; i++) {
		
			data[counter][i] = inString[i];
			
			outstring = "Person added at position" + counter;
			}
			counter++;
			
			return outstring;
			
		}	
		
	}
	 
}	
	
	


