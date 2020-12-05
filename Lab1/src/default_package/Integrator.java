package default_package;

public class Integrator {
	
	
	
public static void main(String[] args) {
	
	
	
	
	
	int limit=4;
	int intError = 0;
	int N = 1;
		
	do {
		
		 
		double integral = 0.0;
		double x = 2.0/N;
		double error = 0.0;
		double F2= 8.0/3.0;
		

	
		
		for (int i=1; i <= N; i++)
		{
			double height = Math.pow(i*x,2);
			//Importerar från ett mattebibliotek, math.pow är "i*x i kvadrat", där av 2:an.
			
			
			//Plussar på arean från en stav till en total area som ska representera integralens totala värde.
			double area = height * x;
			integral += area;
			
			
			//Räknar ut skillnad i integral från den uträknade integralen minus "rätta" integralen. Delar på rätta integralen 
			//för att få decimaltal.
			error = (integral - F2)/F2;
			
			//Gör om decimaltal till procent
			error = Math.round(100.0*error);
			intError = (int)error;
			// gör om error till int, lagrar i ny variabel av nån anledning som ja inte fattar
					
		}
			
		
		//printar ut allt, fixar comma me 2.3 o 2d grejen
		String myString = String.format("the resolt is %2.3f and the error is %2d percent", integral, intError);
		
		
		//kallar på stringen
		System.out.println(myString);

		
		//sist incrementar ja N med en till nästa värde så allt kan gå runt.
		N++;

	}
		
		//end av loopen.
		while(intError > limit);
}

}

