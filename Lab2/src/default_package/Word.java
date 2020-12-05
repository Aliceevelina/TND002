package default_package;

public class Word {

	private String theWord;

	private int counts = 1;

	private static int outputFormat = 0;

//kallar på de olika funktionerna i dictionary
	public Word(String inString) {
		theWord = inString;
	}

	public String getWord() {
		return theWord;
	}

	public int getCounts() {
		return counts;
	}

	public void increaseCounts() {
		counts += 1;
	}

	public static void changeOutputFormat(int inInt) {

		if (inInt == 1)

		{

			outputFormat = 1;

		}

		else

		{

			outputFormat = 0;

		}

	}

	public String toString() {

//kollar om outputformat är 0, 
		if (outputFormat == 0)

		{
//skulle det vara så, returnerar if-satsen detta om ordet har förekommit en gång
			return "The word is: " + theWord + "\r\n";

		}

		else

		{
//annars returnerar if-satsen detta om ordet förekommer fler gånger, antal gånger ligger i "counts"
			return "The word '" + theWord + "' has occured " + counts + " times.\r\n";

		}

	}

}
