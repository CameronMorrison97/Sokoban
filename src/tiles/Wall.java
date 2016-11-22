package tiles;

import java.awt.Color;

import javax.swing.BorderFactory;

public class Wall extends Tile {

	public Wall(){
		setBackground(Color.red);
		setBorder(BorderFactory.createLineBorder(Color.black));
		setOpaque(true);
	}
}
