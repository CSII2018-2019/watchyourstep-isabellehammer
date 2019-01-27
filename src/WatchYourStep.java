import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame; //might be able to delete
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;

public class WatchYourStep extends JFrame {
	
	private static final int GRIDSIZE = 10;
	private static final int NUMBEROFHOLES = 10;
	
	private TerrainButton[][] terrain = new TerrainButton[GRIDSIZE] [GRIDSIZE];
	private int totalRevealed = 0;

	public WatchYourStep (){
		initGUI();
		setTitle("WatchYourStep");
		setSize(300, 150);
		setResizable(false);
		//pack(); //why do we have to pack it if resizing is false???
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	private void initGUI() {
		JLabel titleLabel = new JLabel("Watch Your Step!");
		Font titleFont = new Font (Font.SERIF, Font.BOLD + Font.ITALIC, 32);
		titleLabel.setFont(titleFont);
		titleLabel.setForeground(new Color(107, 158, 239));
		titleLabel.setBackground(new Color(241, 169, 242));
		titleLabel.setOpaque(true);
		add(titleLabel, BorderLayout.PAGE_START);
		titleLabel.setHorizontalAlignment(JLabel.CENTER);
		
		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new GridLayout(GRIDSIZE, GRIDSIZE));
		add(centerPanel, BorderLayout.CENTER);
		for (int r = 0; r < GRIDSIZE; r++) {
			for (int c = 0; c < GRIDSIZE; c++) {
				terrain[r][c] = new TerrainButton(r, c);
				centerPanel.add(terrain[r][c]);
			}
		}
		
	}
	
	
	public class TerrainButton extends JButton {
		
		private static final int size = 50;
		private int row = 0;
		private int col = 0;
		private int nextToHoles = 0;
		private boolean hole = false;
		private boolean revealed = false;
		
	}
	
	public WatchYourStep(int row, int col) {
		
		sizeWide(row);
		sizeHigh(col);
		setPreferredSize(size);
		
	}
	
	public int getRow() {
		return row;
	}
	
	public int getCol() {
		return col;
	}
	
	public int hasHole() {
		return hole;
	}
	
	public int isRevealed(){
		return revealed;
	}
	
	
	public void setHole(hasHole) {
		hole = hasHole;
	}
	
	public void increaseHoleCount() {
		nextToHoles = nextToHoles + 1;
	}
	
	public int isNextToHoles() {
		if (nextToHoles > 0) {
			return true;
		}
	}
	
	public void reveal(reveal) {
		revealed = reveal;
		if (revealed = true) {
			if (hole = true) {
				setBackground(Color.BLACK);
			}
			else {
				setBackground(Color.CYAN);
				if (nextToHoles = 1) {
					setText(Integer.toString(nextToHoles));
				}
			}
		}
		else {
			setBackground(null);
			setText(" ");
		}
	}
	
	public void reset() {
		hole = false;
		revealed = false;
		nextToHoles = 0;
		setText(" ");
		setBackground(null);
	}
	
	
	
	
	
	
	
	public static void main(String[] args) {
		
		try {
            String className = UIManager.getCrossPlatformLookAndFeelClassName();
            UIManager.setLookAndFeel(className);
        } catch ( Exception e) {}
        
        EventQueue.invokeLater(new Runnable (){
            @Override
            public void run() {
                new WatchYourStep();
            }   
        });
		
	}
	
	
	
}
