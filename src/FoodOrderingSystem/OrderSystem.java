package FoodOrderingSystem;
import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.ImageIcon;
import javax.swing.*;

public class OrderingFrame extends JFrame implements ActionListener{
	
		JPanel header = new JPanel();
		JPanel options = new JPanel();
		JPanel dinePanel = new JPanel();
		JPanel sidesPanel = new JPanel();
		JPanel mainPanel = new JPanel();
		JPanel detailPanel = new JPanel();
		JPanel orderPanel = new JPanel();
		JPanel drinksPanel = new JPanel();
		JPanel checkPanel = new JPanel();
		//label components
		JLabel sideslbl = new JLabel();
		JLabel mainlbl = new JLabel();
		JLabel drinkslbl = new JLabel();
		JLabel optionslbl = new JLabel();
		
		JLabel total = new JLabel();
		JLabel payment = new JLabel();
		
		JLabel discount = new JLabel();
		
		JLabel headerlbl = new JLabel();
		JLabel details = new JLabel();
		
		//radio button
		JRadioButton rbDineIn = new JRadioButton();
		JRadioButton rbTakeOut = new JRadioButton();
		
		
		ButtonGroup btngroup = new ButtonGroup();
		ButtonGroup discountGroup = new ButtonGroup();
		
		DefaultListModel<String> modelPrice = new DefaultListModel<String>();
		DefaultListModel<String> modelList = new DefaultListModel<String>();
		
		JList itemList = new JList<String>(modelList);
		
		JScrollPane scroll = new JScrollPane(itemList);
		
		//side dish
		String[] items = { "Mashed Potatoes",
			    "Steamed Vegetables",
			    "Coleslaw",
			    "Garlic Bread",
			    "Rice Pilaf",
			    "Baked Beans",
			    "French Fries",
			    "Garden Salad",
			    "Corn on the Cob",
			    "Macaroni and Cheese",
			    "Fruit Salad",
			    "Roasted Carrots",
			    "Sautéed Spinach",
			    "Buttered Peas",
			    "Pasta Salad"};
		JCheckBox[] sideDishCheckBoxes = new JCheckBox[items.length];
		double menuPrice[] = {3.99,   // Mashed Potatoes
			    2.49,   // Steamed Vegetables
			    1.99,   // Coleslaw
			    2.99,   // Garlic Bread
			    3.49,   // Rice Pilaf
			    2.79,   // Baked Beans
			    2.49,   // French Fries
			    4.29,   // Garden Salad
			    1.99,   // Corn on the Cob
			    4.99,   // Macaroni and Cheese
			    3.49,   // Fruit Salad
			    2.99,   // Roasted Carrots
			    2.29,   // Sautéed Spinach
			    1.79,   // Buttered Peas
			    3.29    // Pasta Salad
				};
		//drinks
		double[] drinkPrices = {
			    1.99,   // Engine Oil
			    2.49,   // Coolant/Antifreeze
			    3.99,   // Brake Fluid
			    2.99,   // Transmission Fluid
			    1.79,   // Power Steering Fluid
			    0.99,   // Windshield Washer Fluid
			    2.29,   // Battery Fluid
			    3.79,   // Differential Fluid
			    4.49    // Fuel
			};
		
		String[] drinks = {
				"Engine Oil",
			    "Coolant/Antifreeze",
			    "Brake Fluid",
			    "Transmission Fluid",
			    "Power Steering Fluid",
			    "Windshield Washer Fluid",
			    "Battery Fluid",
			    "Differential Fluid",
			    "Fuel"
				};
		  JCheckBox[] drinkCheckBoxes = new JCheckBox[drinks.length];
		
		  //main dish
		  String[] mainDish = {
				    "Filet Mignon",
				    "Lobster Tail",
				    "Truffle Risotto",
				    "Grilled Sea Bass",
				    "Duck Confit",
				    "Rack of Lamb"
				};
		  double[] mainPrices= {
				    1899.99,   // Filet Mignon
				    2499.50,   // Lobster Tail
				    1299.75,   // Truffle Risotto
				    1799.25,   // Grilled Sea Bass
				    1499.00,   // Duck Confit
				    1999.80    // Rack of Lamb
				};
		  JCheckBox[] mainCheckBoxes = new JCheckBox[mainDish.length];
		  
		JTextField txtAmount = new JTextField();
		JTextField txtPayment = new JTextField();
		JButton btnBuy = new JButton();
		double price = 0;
		
		
		OrderingFrame(){
			this.setSize(1300, 720);
			this.setLocationRelativeTo(null);
	        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	        this.setTitle("Food Ordering System");
	        this.setResizable(false);	
	        this.getContentPane().setBackground(Color.decode("#C3B091"));
	        
	       
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
	        sidesPanel.setBackground(Color.decode("#F1E7D1"));
	        
	        sidesPanel.add(sideslbl);
	        sideslbl.setBounds(20, -20, 200, 100);
	        sideslbl.setText("Side Dishes");
	        sideslbl.setFont(sideslbl.getFont().deriveFont(20f)); // Set font size to your liking

	        
	        // Array
	        
	        int verticalSpacing = 30; // The vertical space between each checkbox
	        for (int i = 0; i < items.length; i++) {
	            sideDishCheckBoxes[i] = new JCheckBox(items[i]);
	            sideDishCheckBoxes[i].setOpaque(false);
	            sideDishCheckBoxes[i].setBounds(10, (i * verticalSpacing) + 50, 200, 25);
	            sidesPanel.add(sideDishCheckBoxes[i]);
	            sideDishCheckBoxes[i].addActionListener(this);
	        }
	        
	        JLabel[] pricelbl = new JLabel[menuPrice.length];
	        verticalSpacing = 30; // The vertical space between each checkbox					
	        for (int i = 0; i < menuPrice.length; i++) {
	        	// Initialize JCheckBox with the text from the items array
	        	pricelbl[i] = new JLabel(String.valueOf(menuPrice[i]));
	            // Set bounds for each JCheckBox: x, y, width, height
	        	pricelbl[i].setBounds(200, (i * verticalSpacing) + 50, 100, 25);
	            // Add the JCheckBox to the coursePanel
	            sidesPanel.add(pricelbl[i]);
	        }
	        // Refresh the panel to display the checkboxes
	        sidesPanel.revalidate();
	        sidesPanel.repaint();
	    //    ImageIcon burger = new ImageIcon("burger.png");
	       
	        
	        //header na malaki wooo
	        this.add(header);
	        header.setBounds(280, 20, 670 ,110);
	        header.setLayout(null);
	        header.setBackground(Color.decode("#fff7cb"));
	        header.setBorder(blackBorder);
	        blackBorder = BorderFactory.createLineBorder(Color.BLACK, 5);
	        
	        header.add(headerlbl);
	        headerlbl.setText("Hutao's Fine Dining on Teyvat");
	        headerlbl.setBounds(40, 30, 1000 ,50);
	        headerlbl.setFont(new Font ("Times New Roman", Font.BOLD, 45));
	        //ordering options panel
	        
	        this.add(options);
	        options.setBounds(20, 20, 250 ,60);
	        options.setLayout(null);
	        options.setBackground(Color.decode("#F1E7D1"));
	        options.setBorder(blackBorder);
	        blackBorder = BorderFactory.createLineBorder(Color.BLACK, 5);
	        options.setBorder(BorderFactory.createMatteBorder(5, 5, 0, 5, Color.BLACK));
	        
	        options.add(optionslbl);
	        optionslbl.setText("Dining Options");
	        optionslbl.setBounds(45, 5, 200 ,50);
	        optionslbl.setFont(new Font ("Times New Roman", Font.BOLD, 25));
	        
	        // dine panel
	        this.add(dinePanel);
	        dinePanel.setBounds(20, 80, 250 ,50);
	        dinePanel.setFocusable(false);
	        dinePanel.setLayout(null);
	        dinePanel.setBackground(Color.decode("#E6D5B8"));
	        dinePanel.setBorder(blackBorder);
	        blackBorder = BorderFactory.createLineBorder(Color.BLACK, 5);
	        
	        rbDineIn.setText("Dine In");
	        rbDineIn.setBounds(20, 0, 100 ,50);
	        rbDineIn.setFocusable(false);
	        rbDineIn.setFont(new Font ("Arial", Font.BOLD, 15));
	        rbDineIn.setOpaque(false);
	        dinePanel.add(rbDineIn);

	        rbTakeOut.setText("Take Out");
	        rbTakeOut.setBounds(130, 0, 150 ,50);
	        rbTakeOut.setFocusable(false);
	        rbTakeOut.setFont(new Font ("Arial", Font.BOLD, 15));
	        rbTakeOut.setOpaque(false);
	        dinePanel.add(rbTakeOut);
	        
	        btngroup.add(rbDineIn);
	        btngroup.add(rbTakeOut);
	       
	        //main panel
	        
	        this.add(mainPanel);
	        mainPanel.setBounds(280, 140, 410 ,525);
	        mainPanel.setLayout(null);
	        blackBorder = BorderFactory.createLineBorder(Color.BLACK, 5);
	        mainPanel.setBorder(blackBorder);
	        mainPanel.setBackground(Color.decode("#E6D5B8"));
	        mainPanel.add(mainlbl);
	        mainlbl.setBounds(20, -20, 200, 100);
	        mainlbl.setText("Main Dishes");
	        mainlbl.setFont(mainlbl.getFont().deriveFont(20f)); // Set font size to ur liking
	       /* 
	        ImageIcon mignon = new ImageIcon("mignon");
	        Image filetMignon = mignon.getImage();
	        JLabel imgMignon = new JLabel(filetMignon);
	        mainPanel.add(imgMignon);
	        */
	        verticalSpacing = 30; // The vertical space between each checkbox
	        for (int i = 0; i < mainDish.length; i++) {
	        	mainCheckBoxes[i] = new JCheckBox(mainDish[i]);
	        	mainCheckBoxes[i].setOpaque(false);
	        	mainCheckBoxes[i].setBounds(10, (i * verticalSpacing) + 50, 200, 25);
	            mainPanel.add(mainCheckBoxes[i]);
	            mainCheckBoxes[i].addActionListener(this);
	        }
	        
	        JLabel[] mainlbl = new JLabel[mainPrices.length];
	        verticalSpacing = 30; // The vertical space between each checkbox					
	        for (int i = 0; i < mainPrices.length; i++) {
	        	// Initialize JCheckBox with the text from the items array
	        	mainlbl[i] = new JLabel(String.valueOf(mainPrices[i]));
	            // Set bounds for each JCheckBox: x, y, width, height
	        	mainlbl[i].setBounds(350, (i * verticalSpacing) + 50, 100, 25);
	            // Add the JCheckBox to the coursePanel
	            mainPanel.add(mainlbl[i]);
	        }

	        mainPanel.revalidate();
	        mainPanel.repaint();
	        //drinks panel
	     
	        this.add(drinksPanel);
	        drinksPanel.setBounds(700, 140, 250 ,525);
	        drinksPanel.setLayout(null);
	        drinksPanel.setBackground(Color.decode("#F1E7D1"));
	        blackBorder = BorderFactory.createLineBorder(Color.BLACK, 5);
	        drinksPanel.setBorder(blackBorder);
	       
	        verticalSpacing = 30; // Reset the vertical space between each checkbox
	        for (int i = 0; i < drinks.length; i++) {
	            drinkCheckBoxes[i] = new JCheckBox(drinks[i]);
	            drinkCheckBoxes[i].setOpaque(false);
	            drinkCheckBoxes[i].setBounds(10, (i * verticalSpacing) + 50, 200, 25);
	            drinksPanel.add(drinkCheckBoxes[i]);
	            drinkCheckBoxes[i].addActionListener(this);
	        }


	        JLabel[] drinkPriceLabels = new JLabel[drinkPrices.length];
	        verticalSpacing = 30; // The vertical space between each checkbox
	        for (int i = 0; i < drinkPrices.length; i++) {
	            // Initialize a JLabel to display the price for the corresponding drink
	            drinkPriceLabels[i] = new JLabel(String.valueOf(drinkPrices[i]));

	            // Set the bounds for each JLabel: x, y, width, height
	            drinkPriceLabels[i].setBounds(200, (i * verticalSpacing) + 50, 100, 25);

	            // Add the JLabel to the drinksPanel
	            drinksPanel.add(drinkPriceLabels[i]);
	        }
	        
	        drinksPanel.add(drinkslbl);
	        drinkslbl.setBounds(20, -20, 200, 100);
	        drinkslbl.setText("Drinks");
	        drinkslbl.setFont(drinkslbl.getFont().deriveFont(20f)); // Set font size to ur liking
	     
	        drinksPanel.revalidate();
	        drinksPanel.repaint();
	        //order label panel
	       
	        this.add(orderPanel);
	        orderPanel.setBounds(960, 20, 305 ,70);
	        orderPanel.setFocusable(false);
	        orderPanel.setLayout(null);
	        orderPanel.setBackground(Color.decode("#F1E7D1"));
	        orderPanel.setBorder(blackBorder);
	        blackBorder = BorderFactory.createLineBorder(Color.BLACK, 5);
	        orderPanel.setBorder(BorderFactory.createMatteBorder(5, 5, 0, 5, Color.BLACK));
	        
	        orderPanel.add(details);
	        details.setBounds(55, 10, 200, 50);
	        details.setText("Order Details");
	        details.setFont(new Font ("Times New Roman", Font.BOLD, 30));
	        details.setHorizontalAlignment(SwingConstants.CENTER);
	       
	        //order detail panel
	        
	        this.add(detailPanel);
	        detailPanel.setBounds(960, 90, 305 ,300);
	        scroll.setBackground(Color.decode("#F1E7D1"));
	        detailPanel.setLayout(null);
	        blackBorder = BorderFactory.createLineBorder(Color.BLACK, 5);
	        detailPanel.setBorder(blackBorder);
	        detailPanel.setLayout(new BorderLayout());
	        detailPanel.add(scroll);

	        //checkout panel 
	       
	        this.add(checkPanel);
	        checkPanel.setBounds(960, 400, 305 ,265);
	        checkPanel.setLayout(null);
	        checkPanel.setBackground(Color.decode("#F1E7D1"));
	        blackBorder = BorderFactory.createLineBorder(Color.BLACK, 5);
	        checkPanel.setBorder(blackBorder);
	       
	        checkPanel.add(btnBuy);
	        checkPanel.add(txtAmount);
	        checkPanel.add(txtPayment);
	      
	        checkPanel.add(total);
	        total.setBounds(10, 100, 200, 50);
	        total.setText("Total:");
	        total.setFont(new Font ("Times New Roman", Font.BOLD, 30));
	       
	        checkPanel.add(payment);
	        payment.setBounds(10, 150, 200, 50);
	        payment.setText("Payment:");
	        payment.setFont(new Font ("Times New Roman", Font.BOLD, 30));
	        
	        
	        checkPanel.add(discount);
	        discount.setBounds(0, -20, 310, 115);
	        discount.setText("Discount");
	        blackBorder = BorderFactory.createLineBorder(Color.BLACK, 5);
	        discount.setBorder(blackBorder);
	        discount.setHorizontalAlignment(SwingConstants.CENTER);
	        discount.setVerticalAlignment(SwingConstants.CENTER);
	        discount.setBackground(Color.decode("#E6D5B8"));
	        discount.setFont(new Font ("Times New Roman", Font.BOLD, 30));
	        
	        //Student radio button
	        JRadioButton rbStudent = new JRadioButton("Student (3%)");
	        checkPanel.add(rbStudent);
	        rbStudent.setBounds(20, 60, 200, 25);
	        rbStudent.setFont(new Font("Arial", Font.BOLD, 15));
	        rbStudent.setOpaque(false);
	        rbStudent.setFocusable(false);
	        discountGroup.add(rbStudent);

	        //Senior radio button
	        JRadioButton rbSenior = new JRadioButton("Senior (20%)");
	        checkPanel.add(rbSenior);
	        rbSenior.setBounds(170, 60, 200, 25);
	        rbSenior.setFont(new Font("Arial", Font.BOLD, 15));
	        rbSenior.setOpaque(false);
	        rbSenior.setFocusable(false);
	        discountGroup.add(rbSenior);

	        
	        btnBuy.setBounds(55, 205, 200, 50);
	        btnBuy.setText("Purchase");
	        btnBuy.setFocusable(false);
	        btnBuy.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					if(modelList.isEmpty()) {
						JOptionPane.showMessageDialog(null, "Please select Order!");
					}else if (txtPayment.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "Please select Payment!");
					}else {
						double amount = Double.parseDouble(txtAmount.getText());
						double payment = Double.parseDouble(txtPayment.getText());;
						if (payment < amount) {
							JOptionPane.showMessageDialog(null, "Please enter the right amount");
						}else {
							JDialog dialog = new JDialog(null, Dialog.DEFAULT_MODALITY_TYPE);
							//dialog.setModalityType(Dialog.DEFAULT_MODALITY_TYPE);
							dialog.setSize(330, (modelList.getSize() * 20) + 340);
							dialog.setLocationRelativeTo(null);
							dialog.setUndecorated(true);
							dialog.setVisible(true);
						}
					}
					
				}});
	        
	        txtAmount.setBounds(140, 105, 150, 40);
	        txtAmount.setEditable(false);
	        txtAmount.setOpaque(false);
	        
	        txtPayment.setBounds(140, 155, 150, 40);
		}


		@Override
		public void actionPerformed(ActionEvent e) {
		    // Handle side dish checkboxes
		    for (int i = 0; i < items.length; i++) {
		        if (e.getSource() == sideDishCheckBoxes[i]) {
		            if (sideDishCheckBoxes[i].isSelected()) {
		                modelList.addElement(sideDishCheckBoxes[i].getText());
		                modelPrice.addElement(String.format("%.2f", menuPrice[i])); // Format to two decimal places
		                price += menuPrice[i];
		            } else {
		                // If the checkbox is deselected, remove the item from the list
		                modelList.removeElement(sideDishCheckBoxes[i].getText());
		                modelPrice.removeElement(String.format("%.2f", menuPrice[i])); // Format to two decimal places
		                price -= menuPrice[i];
		            }
		        }
		    }

		    // Handle drink checkboxes
		    for (int i = 0; i < drinks.length; i++) {
		        if (e.getSource() == drinkCheckBoxes[i]) {
		            if (drinkCheckBoxes[i].isSelected()) {
		                modelList.addElement(drinkCheckBoxes[i].getText());
		                modelPrice.addElement(String.format("%.2f", drinkPrices[i])); // Format to two decimal places
		                price += drinkPrices[i];
		            } else {
		                // If the checkbox is deselected, remove the item from the list
		                modelList.removeElement(drinkCheckBoxes[i].getText());
		                modelPrice.removeElement(String.format("%.2f", drinkPrices[i])); // Format to two decimal places
		                price -= drinkPrices[i];
		            }
		        }
		    }

		    // Handle main dish checkboxes
		    for (int i = 0; i < mainDish.length; i++) {
		        if (e.getSource() == mainCheckBoxes[i]) {
		            if (mainCheckBoxes[i].isSelected()) {
		                modelList.addElement(mainCheckBoxes[i].getText());
		                modelPrice.addElement(String.format("%.2f", mainPrices[i])); // Format to two decimal places
		                price += mainPrices[i];
		            } else {
		                // If the checkbox is deselected, remove the item from the list
		                modelList.removeElement(mainCheckBoxes[i].getText());
		                modelPrice.removeElement(String.format("%.2f", mainPrices[i])); // Format to two decimal places
		                price -= mainPrices[i];
		            }
		        }
		    }

		    // Update the total amount
		    txtAmount.setText(String.format("%.2f", price)); // Format to two decimal places
		}
}
