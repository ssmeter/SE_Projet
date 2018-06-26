package view;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.time.LocalDate;
import java.util.Properties;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import controller.ButtonController;
import controller.DatePickerController;
import model.BookingList;
import model.Field;
import model.FieldMan;

public class MainContainer extends JFrame{
	private FieldMan fm;
	private BookingList bm;
	private JButton[][] buttonGrid;
	private int nbTerrain;
	private JDatePickerImpl datePicker;
	
	public MainContainer(){
		this.fm = new FieldMan();
		this.bm = new BookingList();
		this.nbTerrain = fm.getFields().size();
		
	    this.setTitle("Football Field Booking");
	    this.setSize(800, 900);
	    this.setLocationRelativeTo(null);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
	    this.setLayout(new GridLayout(14, nbTerrain));
	    
	    JLabel date = new JLabel("Selected date:");
	    date.setFont(new Font("Arial", Font.PLAIN, 16));
	    date.setHorizontalAlignment(JLabel.CENTER);
	    this.add(date);
	    
	    //Initiliaze DatePicker
	    UtilDateModel model = new UtilDateModel();
	    LocalDate currentDate = bm.getDate();
	    model.setDate(currentDate.getYear(), currentDate.getMonthValue() - 1, currentDate.getDayOfMonth());
	    model.setSelected(true);
	    Properties p = new Properties();
	    p.put("text.today", "Today");
	    p.put("text.month", "Month");
	    p.put("text.year", "Year");
	    JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
	    this.datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
	    
	    datePicker.addActionListener(new DatePickerController(this));
	    this.add(datePicker);
	    
	    //To respect the form of the grid
	    this.add(new JLabel(""));
	    
	    //Styling the name of the field
	    Font fieldFont = new Font("Arial", Font.BOLD, 18);
	    Color background = Color.decode("#53738D");
	    Border padding = BorderFactory.createEmptyBorder(50,0,50,0);
	    
	    //Add the name of the field
	    for(Field temp : fm.getFields()){
	    	JLabel tp = new JLabel(temp.getfName());
	    	tp.setBackground(background);
	    	tp.setFont(fieldFont);
	    	tp.setForeground(Color.white);
	    	tp.setOpaque(true);
	    	tp.setBorder(padding);
	    	tp.setHorizontalAlignment(JLabel.CENTER);
		    this.add(tp);
	    }
	    
	    //init every button
	    initButton();
	    //Put a color on every button
	    updateButton();
	    
//	    this.pack();
    	this.setVisible(true);
	 }
	
	private void initButton(){
		buttonGrid = new JButton[12][nbTerrain];
		for(int j = 9; j <= 20; j++){
		    for(int i = 0; i < nbTerrain; i++){
			    	JButton tp = new JButton(j + "h");
			    	tp.addActionListener(new ButtonController(this));
			    	buttonGrid[j-9][i] = tp;
			    	tp.setBorder(new LineBorder(this.getBackground()));
			    	tp.setOpaque(true);
				    this.add(tp);
		    }
    	}
	}
	
	public void updateButton(){
		Color free = Color.decode("#13FF76");
		Color booked = Color.decode("#FF6456");
    	for(int j = 9; j <= 20; j++){
		    for(int i = 0; i < nbTerrain; i++){
			    	if(bm.isBooked(fm.getFields().get(i).getfID(), j)) {
			    		buttonGrid[j-9][i].setBackground(booked);
			    		buttonGrid[j-9][i].setActionCommand("booked");
			    	}
			    	else {
			    		buttonGrid[j-9][i].setBackground(free);
			    		buttonGrid[j-9][i].setActionCommand("free");
			    	}
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

	public JDatePickerImpl getDatePicker() {
		return datePicker;
	}
}
