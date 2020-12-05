package default_package;

public class Labb1skrivut {
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
Database theDataBase = new Database();
		
		String [] newdata = theDataBase.rawData.split(",");
		
		Calendar newcalendar = new Calendar(newdata.length);
		
		for(int i = 0; i < newdata.length; i++)
		{
	    String [] nospace = newdata[i].split(" +");
	    newcalendar.addPerson(nospace);
	    
	    
		System.out.println(newcalendar.data[i][4]);
	
		}

	}

}
