package ske;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JSplitPane;
import java.awt.BorderLayout;
import javax.swing.JToolBar;
import javax.swing.JDesktopPane;
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.border.LineBorder;

import tiles.Tile;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.Component;

import javax.imageio.ImageIO;
import javax.swing.Box;
import java.awt.GridBagLayout;
import javax.swing.JFormattedTextField;
import javax.swing.JToggleButton;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.FlowLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.Icon;

import java.awt.event.ActionListener;
import java.io.InputStream;
import java.net.URL;
import java.awt.event.ActionEvent;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.border.EtchedBorder;
import javax.swing.border.BevelBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Sokoban {

	private JFrame frmSokoban;
	private SokobanEngine engine;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sokoban window = new Sokoban();
					window.frmSokoban.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Sokoban() {
		engine = new SokobanEngine();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSokoban = new JFrame();
		frmSokoban.setTitle("Sokoban");
		frmSokoban.setBounds(100, 100, 793, 588);
		frmSokoban.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSokoban.getContentPane().setLayout(new BorderLayout(0, 0));
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		frmSokoban.getContentPane().add(horizontalStrut_1, BorderLayout.EAST);
		
		Tile tiles[][] = engine.getTiles();
		JPanel panel = new JPanel();
		
		for(int i = 0; i < 20; i++){
			for(int j = 0;  j < 20; j++){
				panel.add(tiles[j][i]);
			}
		}
		
		frmSokoban.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(20, 0, 0, 0));
		
		JPanel panel_1 = new JPanel();
		frmSokoban.getContentPane().add(panel_1, BorderLayout.WEST);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_2 = new JPanel();
		panel_2.setToolTipText("Directions");
		panel_2.setBorder(null);
		panel_1.add(panel_2, BorderLayout.NORTH);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[]{32, 32, 32, 0};
		gbl_panel_2.rowHeights = new int[]{32, 32, 32, 0};
		gbl_panel_2.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_2.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_2.setLayout(gbl_panel_2);
		
		JLabel lblUp = new JLabel("");
		lblUp.setIcon(new ImageIcon(Sokoban.class.getResource("/img/Up.png")));
		GridBagConstraints gbc_lblUp = new GridBagConstraints();
		gbc_lblUp.fill = GridBagConstraints.BOTH;
		gbc_lblUp.insets = new Insets(0, 0, 5, 5);
		gbc_lblUp.gridx = 1;
		gbc_lblUp.gridy = 0;
		panel_2.add(lblUp, gbc_lblUp);
		
		JLabel label_1 = new JLabel("");
		label_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
			}
		});
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Sokoban.class.getResource("/img/Left.png")));
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.fill = GridBagConstraints.BOTH;
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 0;
		gbc_label.gridy = 1;
		panel_2.add(label, gbc_label);
		label_1.setIcon(new ImageIcon(Sokoban.class.getResource("/img/Right.png")));
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.insets = new Insets(0, 0, 5, 0);
		gbc_label_1.fill = GridBagConstraints.BOTH;
		gbc_label_1.gridx = 2;
		gbc_label_1.gridy = 1;
		panel_2.add(label_1, gbc_label_1);
		
		JLabel lblDown = new JLabel("");
		lblDown.setIcon(new ImageIcon(Sokoban.class.getResource("/img/Down.png")));
		GridBagConstraints gbc_lblDown = new GridBagConstraints();
		gbc_lblDown.fill = GridBagConstraints.BOTH;
		gbc_lblDown.insets = new Insets(0, 0, 0, 5);
		gbc_lblDown.gridx = 1;
		gbc_lblDown.gridy = 2;
		panel_2.add(lblDown, gbc_lblDown);
		
		JMenuBar menuBar = new JMenuBar();
		frmSokoban.setJMenuBar(menuBar);
		
		JMenu mnOptions = new JMenu("Options");
		menuBar.add(mnOptions);
		
		JMenuItem mntmNewGame = new JMenuItem("New Game");
		mnOptions.add(mntmNewGame);
		
		JMenuItem mntmResetGame = new JMenuItem("Reset Game");
		mnOptions.add(mntmResetGame);
	}
}
