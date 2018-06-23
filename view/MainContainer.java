package view;

import java.awt.Button;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import controller.ButtonController;
import model.BookingList;
import model.Field;
import model.FieldMan;

public class MainContainer extends JFrame{
	private FieldMan fm;
	private BookingList bm;
	private JButton[][] buttonGrid;
	private int nbTerrain;
	
	public MainContainer(){
		fm = new FieldMan();
		bm = new BookingList();
		
		this.nbTerrain = fm.getFields().size();
	    this.setTitle("Foot planning");
	    this.setSize(800, 600);
	    this.setLocationRelativeTo(null);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
	    this.setLayout(new GridLayout(14, nbTerrain));
	    
	    JLabel date = new JLabel("14/07/2018"); 
	    date.setHorizontalAlignment(JLabel.CENTER);
	    this.add(date);
	    this.add(new JLabel(""));
	    this.add(new JLabel(""));

	    for(Field temp : fm.getFields()){
	    	JLabel tp = new JLabel(temp.getfName());
	    	tp.setHorizontalAlignment(JLabel.CENTER);
		    this.add(tp);
	    }
	    
	    initButton();
	    updateButton();
	    
    	this.setVisible(true);
	 }
	
	private void initButton(){
		buttonGrid = new JButton[12][nbTerrain];
		for(int j = 9; j <= 20; j++){
		    for(int i = 0; i < nbTerrain; i++){
			    	JButton tp = new JButton(j + "h");
			    	tp.addActionListener(new ButtonController(this));
			    	buttonGrid[j-9][i] = tp;
			    	tp.setOpaque(true);
				    this.add(tp);
		    }
    	}
	}
	
	public void updateButton(){
    	for(int j = 9; j <= 20; j++){
		    for(int i = 0; i < nbTerrain; i++){
			    	if(bm.isBooked(fm.getFields().get(i).getfID(), j))
			    		buttonGrid[j-9][i].setBackground(Color.red);
			    	else
			    		buttonGrid[j-9][i].setBackground(Color.green);
			   }
    	}
    }
	
	public FieldMan getFm() {
		return fm;
	}

	public BookingList getBm() {
		return bm;
	}

	public JButton[][] getButtonGrid() {
		return buttonGrid;
	}
}
