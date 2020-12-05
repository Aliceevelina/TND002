package default_package;

import java.io.*;
import java.io.BufferedReader;
import java.io.IOException;

public class Lab2 {

	// skapar en bufferedreader som har namnet consoleReader.

	private static BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));

	public static String questionToUser =

			"---------------------------------------------------\n"

					+ "You have the following options:\n"

					+ "End : type 'end'                                   |\n"

					+ "Load from file: type 'load' followed by filename\n"

					+ "Save to file: type 'save' followed by filename     |\n"

					+ "Add another word: type the word\n"

					+ "List reduced content: type '1'                     |\n"

					+ "List full content: type '2'\n"

					+ "Remove multiple occurences: type '3'               |\n"

					+ "Sort: type '4'\n"

					+ "List occurences: type '5'                          |\n"

					+ "Your choice: ";

//vad menas igentligen med IOExeptions?
	public static String consoleInput() throws IOException {

//ett try catch - block, som läser av svaren vi ger
		try {

			System.out.print(questionToUser);

			return consoleReader.readLine();

		} catch (Exception e) {

			return "";

		}

	}

	public static void main(String[] args) {

		Dictionary myDictionary = new Dictionary();

		String input = "";

//Stora While loopen som körs sålänge ordet end skrivs in.
		do {

			try {

				input = consoleInput();

				System.out.print("---------------------------------------------------\n\n");

// Case Switch som tar hand om de olika valen vi givit usern

				switch (input) {

				case "load":

//usern skriver in namnet på filen, i vårt fall skriver vi "hej" och läser det med readline, lägger till txt.
					System.out.print("Enter name of file: ");

					String loadFile = consoleReader.readLine();

					File myFile = new File(loadFile + ".txt");

// Exists statement som kollar om det finns en sådan fil. tror problemet med att den inte läser ligger här
					if (myFile.exists())

					{

						try {

//om den finns läser bufferedreadern av filen som givits.
							BufferedReader myBufferedReader = new BufferedReader(new FileReader(myFile));

							String line;

							String fileInput = "";

							while ((line = myBufferedReader.readLine()) != null) {

								fileInput += line + " ";

							}

							myBufferedReader.close();

							System.out.println(
									"The words from the file " + loadFile + ".txt was added to your dictionary");

							myDictionary.addWords(fileInput);

						} catch (IOException e) {

							System.out.println("IO Exception");

						}

					}

					else

					{

						System.out.println("No such file exists\n");

					}

					break;

				// läser in svaret på vad filen ska heta, läser in det

				case "save":

					System.out.println("Enter name of file: ");

					String saveFile = consoleReader.readLine();

					myDictionary.setFileName(saveFile + ".txt");

					System.out.println("");

					break;

				// de olika valen som är kopplade till funktionerna vi skapat i dictionary som
				// ska utföra de olika komandon

				case "1":

					Word.changeOutputFormat(0);

					System.out.println(myDictionary.toString());

					break;

				case "2":

					Word.changeOutputFormat(1);

					System.out.println(myDictionary.toString());

					break;

				case "3":
					myDictionary.removeDuplicates();
					break;

				case "4":
					myDictionary.sortDictionaryByCounts();
					break;

				case "5":
					System.out.println(myDictionary.countOccurences());
					break;

				default:
					myDictionary.addWords(input);
					break;

				}

			} catch (Exception e) {

				System.out.println("Something went wrong!!");

			}

		} while (!input.equals("end"));

	}

}
