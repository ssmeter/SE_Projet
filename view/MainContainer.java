package view;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MainContainer extends JFrame{
	public MainContainer(){
	    this.setTitle("Foot planning");
	    this.setSize(800, 600);
	    this.setLocationRelativeTo(null);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
	    this.setLayout(new GridLayout(14, 3));
	    
	    this.add(new JLabel("14/07/2018"));
	    this.add(new JLabel(""));
	    this.add(new JLabel(""));

	    this.add(new JLabel("Terrain 1"));
	    this.add(new JLabel("Terrain 2"));
	    this.add(new JLabel("Terrain 3"));

	    this.add(new JButton("9h"));
	    this.add(new JButton("9h"));
	    this.add(new JButton("9h"));
	    this.add(new JButton("Button 1"));
	    this.add(new JButton("Button 1"));
	    this.add(new JButton("Button 1"));
	    this.add(new JButton("Button 1"));
	    this.add(new JButton("Button 1"));
	    this.add(new JButton("Button 1"));
	    this.add(new JButton("Button 1"));
	    this.add(new JButton("Button 1"));
	    this.add(new JButton("Button 1"));
	    this.add(new JButton("Button 1"));
	    this.add(new JButton("Button 1"));
	    this.add(new JButton("Button 1"));
	    this.add(new JButton("Button 1"));
	    this.add(new JButton("Button 1"));
	    this.add(new JButton("Button 1"));
	    this.add(new JButton("Button 1"));
	    this.add(new JButton("Button 1"));
	    this.add(new JButton("Button 1"));
	    this.add(new JButton("Button 1"));
	    this.add(new JButton("Button 1"));
	    this.add(new JButton("Button 1"));
	    this.add(new JButton("Button 1"));
	    this.add(new JButton("Button 1"));
	    this.add(new JButton("Button 1"));
	    this.add(new JButton("Button 1"));
	    this.add(new JButton("Button 1"));
	    this.add(new JButton("Button 1"));
	    this.add(new JButton("Button 1"));
	    this.add(new JButton("Button 1"));
	    this.add(new JButton("Button 1"));
	    this.add(new JButton("Button 1"));
	    this.add(new JButton("Button 1"));
	    this.add(new JButton("Button 1"));

	    this.setVisible(true);
	  }
}
