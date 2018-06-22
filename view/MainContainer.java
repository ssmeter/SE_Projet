package view;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import model.Field;
import model.FieldMan;

public class MainContainer extends JFrame{
	private FieldMan fm;
	
	public MainContainer(){
		fm = new FieldMan();
		int nbTerrain = fm.getFields().size();
	    this.setTitle("Foot planning");
	    this.setSize(800, 600);
	    this.setLocationRelativeTo(null);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
	    this.setLayout(new GridLayout(14, nbTerrain));
	    
	    this.add(new JLabel("14/07/2018"));
	    this.add(new JLabel(""));
	    this.add(new JLabel(""));

	    for(Field temp : fm.getFields()){
		    this.add(new JLabel(temp.getfName()));
	    }
	    
	    for(int i = 0; i < nbTerrain; i++)
		    this.add(new JButton("9h"));
	    for(int i = 0; i < nbTerrain; i++)
		    this.add(new JButton("10h"));
	    for(int i = 0; i < nbTerrain; i++)
		    this.add(new JButton("11h"));
	    for(int i = 0; i < nbTerrain; i++)
		    this.add(new JButton("12h"));
	    for(int i = 0; i < nbTerrain; i++)
		    this.add(new JButton("13h"));
	    for(int i = 0; i < nbTerrain; i++)
		    this.add(new JButton("14h"));
	    for(int i = 0; i < nbTerrain; i++)
		    this.add(new JButton("15h"));
	    for(int i = 0; i < nbTerrain; i++)
		    this.add(new JButton("16h"));
	    for(int i = 0; i < nbTerrain; i++)
		    this.add(new JButton("17h"));
	    for(int i = 0; i < nbTerrain; i++)
		    this.add(new JButton("18h"));
	    for(int i = 0; i < nbTerrain; i++)
		    this.add(new JButton("19h"));
	    for(int i = 0; i < nbTerrain; i++)
		    this.add(new JButton("20h"));
	    
	    this.setVisible(true);
	  }
}
