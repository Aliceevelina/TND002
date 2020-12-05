package default_package;

import java.io.*;

import java.util.ArrayList;

public class Dictionary {

//skapar en dynamisk arraylist som heter theDictionary.
	private ArrayList<Word> theDictionary;

	public Dictionary() {
		theDictionary = new ArrayList<Word>();
	}

	public Dictionary(String inString) {

		theDictionary = new ArrayList<Word>();

		addWords(inString);

	}

//funktionen som addar ett ord
	public void addWords(String inString) {

		inString = inString.replaceAll("^\\d", "").toLowerCase();

		String words[] = inString.split(" +");

		for (int i = 0; i < words.length; i++)

		{

			Word word = new Word(words[i]);

			try {

				Integer.parseInt(word.getWord());

			} catch (NumberFormatException e) {

//addar sen ordet till theDictionary sålänge det är tomt med hjälp av .add. 
				if (word.getWord() != " ")

				{

					theDictionary.add(word);

				}

			}

		}

		System.out.println("Total words in dictionary: " + theDictionary.size() + "\n");

	}

//numberofwords metoden som returnerar hur många ord
	public int numberOfWords() {

		return theDictionary.size();

	}

	// void funktionen som tar bort dupliceterna.

	public void removeDuplicates() {

		for (int i = 0; i < theDictionary.size() - 1; i++)

		{
//hämtar första ordet som ska sedan kollas så det finns fler av det
			String first = theDictionary.get(i).getWord();

			for (int q = i + 1; q < theDictionary.size(); q++)

			{
//hämtar nästa ord och så vidare, om första är lika nästkommande tar .remove bort ordet som ligger i q.
				String second = theDictionary.get(q).getWord();

				if (first.equals(second))

				{

					theDictionary.remove(q);

					theDictionary.get(i).increaseCounts();

				}

			}

		}

		for (int i = 0; i < theDictionary.size() - 1; i++)

		{

			System.out.println(theDictionary.get(i).getWord() + " " + theDictionary.get(i).getCounts());

		}

		System.out.println("You have grouped all duplicate words in your dictionary\n");

	}

//kollar med denna hur många gånger ett ord förekommer 
	public String countOccurences() {

		String result = new String();

		int[] occurences;

		int max = 1;

		for (int j = 0; j < theDictionary.size(); j++)

		{

			if (theDictionary.get(j).getCounts() > max)
				max = theDictionary.get(j).getCounts();

		}

		occurences = new int[max + 1];

		for (int j = 0; j < max + 1; j++) {

			occurences[j] = 0;

		}
//lägger in hur storlekens siffra här
		for (int j = 0; j < theDictionary.size(); j++) {

			occurences[theDictionary.get(j).getCounts()] += 1;

		}
//for loop som skriver ut antal ord
		for (int j = 0; j < max + 1; j++) {

			if (occurences[j] > 0) {
				result += "There are " + occurences[j] + "that occured " + j + " times. \n ";
			}

		}

		return result;

	}

///valet sort, som sorterar med hänsyn på hur många counts ordet har.
	public void sortDictionaryByCounts() {

		for (int i = 0; i < theDictionary.size() - 1; i++)

		{

//går igenom theDictionary och sätter första och nästkommande ord i first och second
			for (int q = i + 1; q < theDictionary.size(); q++)

			{

				int first = theDictionary.get(i).getCounts();

				int second = theDictionary.get(q).getCounts();

				// kollar om första har mindre counts än nästkommande. Om så, sorterar vi q+1
				// med remove

				if (first < second)

				{

					theDictionary.add(i, theDictionary.get(q));

					theDictionary.remove(q + 1);

				}

			}

		}

		System.out.println("Dictionary is sorted based on quantity of each word\n");

	}

//tar in filens namn i input, skapar en ny fil med "File" och döper den till givet "filename"
	public void setFileName(String filename) throws IOException {

		File myFile = new File(filename);

		myFile.createNewFile();

		BufferedWriter outputWriter = new BufferedWriter(new FileWriter(myFile, false));

		outputWriter.write(toString());
//hämtar funktionen savefile som kollar med try, om det går att spara nya filen
		saveFile();

		outputWriter.close();

	}

	public void saveFile() {

		try {

		} catch (Exception e) {

			System.out.println("Couldn't save file sorry");

		}

	}

//räknar hur många ord totalt och hur många ord som påträffas 2 gånger
	public String toString() {

//Tom string ans
		String ans = "";
//sätter occurences till noll
		int occurences = 0;
//forloop som lägger till antal ord som påträffas två gånger
		for (int i = 0; i < theDictionary.size(); i++)

		{

			occurences += theDictionary.get(i).getCounts();

		}

//ans kommer vara retur-stringen som innehåller info om antal ord tot och occurences
		ans += "Total words: " + theDictionary.size() + " and total occurences " + occurences + ".\r\n";

		for (int i = 0; i < theDictionary.size(); i++)

		{

			ans += theDictionary.get(i).toString();

		}

		return ans;

	}

}
