package FoodOrderingSystem;
import java.awt.Checkbox;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.ImageIcon;
import javax.swing.*;

public class OrderSystem extends JFrame {
	
		
		JPanel sidesPanel = new JPanel();
		JPanel mainPanel = new JPanel();
		JPanel detailPanel = new JPanel();
		JPanel drinksPanel = new JPanel();
		
		
		//label components
		JLabel sideslbl = new JLabel();
		JLabel mainlbl = new JLabel();
		JLabel drinkslbl = new JLabel();
		//
		OrderSystem(){
			this.setSize(1300, 720);
			this.setLocationRelativeTo(null);
	        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	        this.setTitle("Food Ordering System");
	        this.setResizable(false);	
	        this.getContentPane().setBackground(Color.decode("#2d3e50"));
	        
	        this.setLayout(null);
	        this.setVisible(true);
	      
		/*	 bg panel this.add(mainPanel); mainPanel.setBounds(0, 0, 1300, 720);
			 mainPanel.setBackground(Color.decode("#2d3e50")); */
			 
	        
	        //side course panel
	        //  coursePanel.setBackground(Color.decode("#100000"));
	        this.add(sidesPanel);
	        sidesPanel.setBounds(20, 140, 250 ,525);
	        sidesPanel.setLayout(null);
	        Border blackBorder = BorderFactory.createLineBorder(Color.BLACK, 5);
	        sidesPanel.setBorder(blackBorder);
	    
	        sidesPanel.add(sideslbl);
	        sideslbl.setBounds(20, -20, 200, 100);
	        sideslbl.setText("Side Dishes");
	        sideslbl.setFont(sideslbl.getFont().deriveFont(20f)); // Set font size to your liking

	        
	        // Define an array with the specific items
	        String[] items = {"Hamburger", "Fries", "Bacon", "Ramen"};
	        JCheckBox[] checkBoxes = new JCheckBox[items.length];
	        int verticalSpacing = 30; // The vertical space between each checkbox
	        							
	        for (int i = 0; i < items.length; i++) {
	            // Initialize each JCheckBox with the text from the items array
	            checkBoxes[i] = new JCheckBox(items[i]);
	            
	            // Set bounds for each JCheckBox: x, y, width, height
	            checkBoxes[i].setBounds(10, (i * verticalSpacing) + 50, 100, 25);
	            
	            // Add the JCheckBox to the coursePanel
	            sidesPanel.add(checkBoxes[i]);
	        }

	        // Refresh the panel to display the checkboxes
	        sidesPanel.revalidate();
	        sidesPanel.repaint();
	        
	        
	        ImageIcon burger = new ImageIcon("burger.png");
	      
	       
	        
	        //main panel
	        
	        this.add(mainPanel);
	        mainPanel.setBounds(280, 140, 410 ,525);
	        mainPanel.setLayout(null);
	        blackBorder = BorderFactory.createLineBorder(Color.BLACK, 5);
	        mainPanel.setBorder(blackBorder);
	     
	        mainPanel.add(mainlbl);
	        mainlbl.setBounds(20, -20, 200, 100);
	        mainlbl.setText("Main Dishes");
	        mainlbl.setFont(mainlbl.getFont().deriveFont(20f)); // Set font size to ur liking

	        
	        //drinks panel
	        
	        this.add(drinksPanel);
	        drinksPanel.setBounds(700, 140, 250 ,525);
	        drinksPanel.setLayout(null);
	        blackBorder = BorderFactory.createLineBorder(Color.BLACK, 5);
	        drinksPanel.setBorder(blackBorder);
	       
	        drinksPanel.add(drinkslbl);
	        drinkslbl.setBounds(20, -20, 200, 100);
	        drinkslbl.setText("Drinks");
	        drinkslbl.setFont(drinkslbl.getFont().deriveFont(20f)); // Set font size to ur liking
	        
	        //order detail panel
	        
	        this.add(detailPanel);
	        detailPanel.setBounds(970, 20, 300 ,645);
	        detailPanel.setLayout(null);
	        blackBorder = BorderFactory.createLineBorder(Color.BLACK, 5);
	        detailPanel.setBorder(blackBorder);
	   
		
	        
		
	
	
	
		}

}
