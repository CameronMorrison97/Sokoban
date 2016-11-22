package tiles;

import java.awt.Color;

import javax.swing.BorderFactory;

public class Player extends Tile {

	public Player(){
		setBackground(Color.BLUE);
		setBorder(BorderFactory.createLineBorder(Color.black));
		setOpaque(true);
	}
}
