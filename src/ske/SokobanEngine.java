package ske;

import java.awt.Point;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Stack;
import tiles.Tile.*;
import tiles.Wall;
import ske.Level;
import tiles.Crate;
import tiles.Diamond;
import tiles.Player;
import tiles.Tile;

public class SokobanEngine  {
	
	// variable declarations.
	private ArrayList<Level> levels;
	private Tile tiles[][] = new Tile[20][20];
	private Stack<Point> steps;
	private int numberOfMoves;
	private int numberOfDiamonds;
	private int travel;
	
	public SokobanEngine() {
		// TODO Auto-generated constructor stub
		levels = getLevels();
		newGame();
	}
	
	public String helpPage(){
		String message = "This is the beginnings of a helppage.";
		return message;
	}
	
	/**
	 * Get the tiles.
	 * @return
	 */
	public Tile[][] getTiles(){
		return tiles;
	}
	
	/**
	 * Resets the current level
	 */
	public void resetLevel(){
		// get the level
		char level[][] = levels.get(travel-1).getIndivLevel();
		loadLevel(level);
	}
	
	/**
	 * Load the level of the users choice.
	 * @param level
	 * @return tiles
	 */
	public Tile[][] loadLevel(char level[][]){
		int number = level.length;
		
		for(int i = 0; i < level.length; i++){
			for(int j = 0; j < level.length; j++){
				switch(level[j][i]){
				case 'W':
					tiles[j][i] = new Wall();
					break;
				case 'C':
					tiles[j][i] = new Crate();
					break;
				case 'S':
					tiles[j][i] = new Player();
					break;
				case 'D':
					tiles[j][i] = new Diamond();
					break;
				case ' ':
					tiles[j][i] = new Tile();
					break;
				}
			}
		}

		return tiles;
	}
	
	/**
	 * Allows the user to start a new game of their choosing.
	 * @param scan
	 */
	public void newGame(){
		// Just Temporary for testing.
		Scanner scan = new Scanner(System.in);
		
		// load first level by default.
		travel = 1;
		
		if(levels.size() > 1){
			System.out.println("Which Level you like to go to" + "1" + " to " + String.valueOf(levels.size()));
			
			try{
				travel = scan.nextInt();
			}catch(InputMismatchException e){	
				System.out.println("Please enter a level between 1" + " to " + String.valueOf(levels.size()) + "\n");
				newGame();
			} // end try-catch
			
		}// end if
		
		// close the scanner.
		scan.close();
		
		// get the level
		char level[][] = levels.get(travel-1).getIndivLevel();
		
		loadLevel(level);
	}
	
	/**
	 * Gets all of the levels from the file that the user has chosen.
	 * @return levels
	 */
	public ArrayList<Level> getLevels() {
		ArrayList<Level> levels = new ArrayList<Level>();
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Please enter the file.");
		String pathName = scan.nextLine();
	
		short number = Level.countLevels(pathName);
		short noOfLevels = 0;
		
		while(noOfLevels < number){
			levels.add(new Level(pathName));
			noOfLevels++;
		}
		
		// get rid of the null elements.
		levels.trimToSize();
		
		return levels;
	}
	
	public static void main(String args[]){
		SokobanEngine soko = new SokobanEngine();
		
		System.out.println("test");
	}
}