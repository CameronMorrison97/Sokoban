package ske;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Level {
	
	/**
	 * Define static variables.
	 */
	private static final short Lines = 20;
	private static String mapSet = null;
	private static int readNumber = 0;
	
	/**
	 * Variable Declaration.
	 */
	private char indivLevel[][] = new char[Lines][Lines];
	private File file;
	private String hold = null;
	private String levelName = null;
	
	Level(String path){
		file = new File(path);
		
		// get the extension of the file.
		String extension = file.getName().substring(file.getName().indexOf('.'), file.getName().length());
		
		// Check if the file exists.
		if(!file.exists()){
			throw new IllegalArgumentException("The file doesn't exist");
		}
		
		// Check to see if the file is of the correct type.
		if(!extension.equals(".skb")){
			throw new IllegalArgumentException("Incorrect file type.");
		}
		
		// Check that you can read the file.
		if(!file.canRead()){
			throw new IllegalArgumentException("File cannot be read");
		}
		
			readFile();	
	}
	
	/**
	 * get the file.
	 * @return file
	 */
	public File getFile(){
		return file;
	}
	
	/**
	 * Gets the Map Set name
	 * @return mapSet
	 */
	public static String getMapSet() {
		return mapSet;
	}

	/**
	 * Get the number of line of the file
	 * @return readNumber
	 */
	public static int getReadNumber() {
		return readNumber;
	}

	/**
	 * Gets the individiual level
	 * @return indivLevel
	 */
	public char[][] getIndivLevel() {
		return indivLevel;
	}

	/**
	 * Get the level name.
	 * @return levelName
	 */
	public String getLevelName() {
		return levelName;
	}

	/**
	 * Read the file provided to me by the lecturer.
	 * @throws FileNotFoundException 
	 */
	private void readFile(){
		// open the scanner.
		Scanner scan = null;
		
		/**
		 * Tell the scanner which file to read.
		 */
		try{
			scan = new Scanner(new FileReader(file));
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}
		
		/**
		 * Used to traverse to the current line.
		 */
		if(readNumber > 0){
			for(int i = 0; i <= readNumber; i++){
				scan.nextLine();
			}
		}
		
		// While there's another line in the text file.
				short i = 0;
				char c = '\0';
				
				while(i < 20){
					hold = scan.nextLine();
					readNumber++;
					checkLine(scan);
					
						for(short j =0 ; j < 20; j++){
							// change all characters to upper case
							// makes things easier later on.
							hold = hold.toUpperCase();
							c =hold.charAt(j);
							// rows, cols
							indivLevel[i][j] = c;
						}// end for
					i++;
				}// end while
		
		// close the scanner.
		scan.close();
	}
	
	/**
	 * Checks to see if a line contains Level set or empty space
	 * @param scan
	 */
	private void checkLine(Scanner scan){
		if(hold.isEmpty()){
			readNumber++;
			setHold(scan.nextLine());
			checkLine(scan);
		} else 
			
			if(hold.contains("Level")){
			readNumber++;
			levelName = hold;
			setHold(scan.nextLine());
			checkLine(scan);
		} else 
			
			if(hold.contains("Map")){
			readNumber++;
			mapSet = hold;
			setHold(scan.nextLine());
			checkLine(scan);
		}
	}

	/**
	 * Private setter for hold.
	 * @param hold
	 */
	private void setHold(String hold){
		this.hold = hold;
	}
	
	/**
	 *  Gets how many levels are in the file that has been passed.
	 * @param pathName
	 * @return i
	 */
	protected static short countLevels(String pathName){
			File file = new File(pathName);
			
			// open the scanner.
			Scanner scan = null;
					
			/**
			 * Tell the scanner which file to read.
			 */
			try{
				scan = new Scanner(new FileReader(file));
			}catch(FileNotFoundException e){
				e.printStackTrace();
			} // end try-catch
			
			short i = 0;
			
			/**
			 * While there's another line in the file.
			 */
			while(scan.hasNext()){
				if(scan.nextLine().contains("Level"))
					i++;
				// end if
			} // end wihle
			
			// close the scanner
			scan.close();
			return i;
		}
	}
