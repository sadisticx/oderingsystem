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
		
		//labels for txtbox
		JLabel total = new JLabel();
		JLabel payment = new JLabel();
		JLabel discountlbl = new JLabel();
		JLabel change = new JLabel();
		
		//header
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
		
		JList<String> itemList = new JList<String>(modelList);
		
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
		double menuPrice[] = {80.00,  // Mashed Potatoes
			    90.00,  // Steamed Vegetables
			    70.00,  // Coleslaw
			    60.00,  // Garlic Bread
			    95.00, // Rice Pilaf
			    75.00,  // Baked Beans
			    55.00,  // French Fries
			    95.00,  // Garden Salad
			    65.00,  // Corn on the Cob
			    80.00, // Macaroni and Cheese
			    85.00, // Fruit Salad
			    70.00,  // Roasted Carrots
			    80.00,  // Sautéed Spinach
			    75.00,  // Buttered Peas
			    90.00   // Pasta Salad
				};
		//drinks
		double[] drinkPrices = {
				150.00, // Tropical Tango Smoothie
			    120.00, // Mint Mojito Madness
			    100.00, // Caramel Cold Brew
			    130.00, // Berry Blast Lemonade
			    110.00, // Ginger Zing Tea
			    160.00, // Pineapple Paradise Slush
			    140.00, // Coconut Chai Latte
			    115.00, // Pomegranate Punch
			    125.00, // Sizzling Citrus Cooler
			    135.00  // Vanilla Bean Frappe
			};

		
		String[] drinks = {
				 "Tropical Tango Smoothie",
				    "Mint Mojito Madness",
				    "Caramel Cold Brew",
				    "Berry Blast Lemonade",
				    "Ginger Zing Tea",
				    "Pineapple Paradise Slush",
				    "Coconut Chai Latte",
				    "Pomegranate Punch",
				    "Sizzling Citrus Cooler",
				    "Vanilla Bean Frappe"
				};
		  JCheckBox[] drinkCheckBoxes = new JCheckBox[drinks.length];
		
		  //main dish
		  String[] mainDish = {
				    "Filet Mignon",
				    "Lobster Tail",
				    "Truffle Risotto",
				    "Grilled Sea Bass",
				    "Duck Confit",
				    "Rack of Lamb",
				    "Beef Wellington",
				    "Seafood Risotto",
				    "Veal Oscar",
				    "Truffle Risotto",
				    "Lamb Shank Osso Buco"
				};
		  double[] mainPrices = {
				    1699.99,    // Filet Mignon
				    2299.99,    // Lobster Tail
				    1199.99,    // Truffle Risotto
				    1699.99,    // Grilled Sea Bass
				    1399.99,    // Duck Confit
				    1899.99,    // Rack of Lamb
				    2199.99,    // Beef Wellington
				    1599.99,    // Seafood Risotto
				    1799.99,    // Veal Oscar
				    1199.99,    // Truffle Risotto
				    1699.99     // Lamb Shank Osso Buco
				};

		  JCheckBox[] mainCheckBoxes = new JCheckBox[mainDish.length];
		  
		JTextField txtAmount = new JTextField();
		JTextField txtPayment = new JTextField();
		JButton btnBuy = new JButton();
		
		JTextField boxDiscount = new JTextField();
		JTextField boxChange = new JTextField();
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
	            sideDishCheckBoxes[i].setFont(new Font("Arial", Font.BOLD, 13)); // Set font size to 16
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
	        	pricelbl[i].setFont(new Font("Arial", Font.BOLD, 13)); // Set font size to 16

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
	        blackBorder = BorderFactory.createLineBorder(Color.BLACK, 4);
	        
	        header.add(headerlbl);
	        headerlbl.setText("Hutao's Fine Dining on Teyvat");
	        headerlbl.setBounds(35, 5, 1000 ,100);
	        headerlbl.setFont(new Font ("Bahnschrift SemiCondensed", Font.ITALIC, 45));
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
	        verticalSpacing = 41; // The vertical space between each checkbox
	        for (int i = 0; i < mainDish.length; i++) {
	        	mainCheckBoxes[i] = new JCheckBox(mainDish[i]);
	        	mainCheckBoxes[i].setOpaque(false);
	        	mainCheckBoxes[i].setBounds(10, (i * verticalSpacing) + 50, 250, 25);
	            mainCheckBoxes[i].setFont(new Font("Arial", Font.BOLD, 16)); // Set font size to 16
	        	mainPanel.add(mainCheckBoxes[i]);
	            mainCheckBoxes[i].addActionListener(this);
	        }
	        
	        JLabel[] mainlbl = new JLabel[mainPrices.length];
	        verticalSpacing = 41; // The vertical space between each checkbox					
	        for (int i = 0; i < mainPrices.length; i++) {
	        	// Initialize JCheckBox with the text from the items array
	        	mainlbl[i] = new JLabel(String.valueOf(mainPrices[i]));
	            // Set bounds for each JCheckBox: x, y, width, height
	        	mainlbl[i].setBounds(330, (i * verticalSpacing) + 50, 250, 25);
	            mainlbl[i].setFont(new Font("Arial", Font.BOLD, 16)); // Set font size to 16
	            // Add the JCheckBox to the coursePanel
	            mainPanel.add(mainlbl[i]);
	        }

	        mainPanel.revalidate();
	        mainPanel.repaint();
	        //drinks panel
	     
	        this.add(drinksPanel);
	        drinksPanel.setBounds(700, 140, 251 ,525);
	        drinksPanel.setLayout(null);
	        drinksPanel.setBackground(Color.decode("#F1E7D1"));
	        blackBorder = BorderFactory.createLineBorder(Color.BLACK, 5);
	        drinksPanel.setBorder(blackBorder);
	       
	        verticalSpacing = 30; // Reset the vertical space between each checkbox
	        for (int i = 0; i < drinks.length; i++) {
	            drinkCheckBoxes[i] = new JCheckBox(drinks[i]);
	            drinkCheckBoxes[i].setOpaque(false);
	            drinkCheckBoxes[i].setBounds(10, (i * verticalSpacing) + 50, 200, 25);
	            drinkCheckBoxes[i].setFont(new Font("Arial", Font.BOLD, 13)); // Set font size to 16
	            drinksPanel.add(drinkCheckBoxes[i]);
	            drinkCheckBoxes[i].addActionListener(this);
	        }


	        JLabel[] drinkPriceLabels = new JLabel[drinkPrices.length];
	        verticalSpacing = 30; // The vertical space between each checkbox
	        for (int i = 0; i < drinkPrices.length; i++) {
	            // JLabel to display the drink price
	            drinkPriceLabels[i] = new JLabel(String.valueOf(drinkPrices[i]));

	            // Set the bounds for each JLabel: x, y, width, height
	            drinkPriceLabels[i].setBounds(200, (i * verticalSpacing) + 50, 100, 25);
	            drinkPriceLabels[i].setFont(new Font("Arial", Font.BOLD, 13)); 
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
	        detailPanel.setBounds(960, 90, 305 ,240);
	        scroll.setBackground(Color.decode("#F1E7D1"));
	        detailPanel.setLayout(null);
	        blackBorder = BorderFactory.createLineBorder(Color.BLACK, 5);
	        detailPanel.setBorder(blackBorder);
	        detailPanel.setLayout(new BorderLayout());
	        detailPanel.add(scroll);

	        //checkout panel 
	       
	        this.add(checkPanel);
	        checkPanel.setBounds(960, 340, 305 ,323);
	        checkPanel.setLayout(null);
	        checkPanel.setBackground(Color.decode("#F1E7D1"));
	        blackBorder = BorderFactory.createLineBorder(Color.BLACK, 5);
	        checkPanel.setBorder(blackBorder);
	       
	        checkPanel.add(btnBuy);
	        checkPanel.add(txtAmount); 
	        checkPanel.add(txtPayment);
	        checkPanel.add(boxDiscount);
	        checkPanel.add(boxChange);
	        checkPanel.add(total);
	        
	        total.setBounds(10, 95, 200, 50);
	        total.setText("Total:");
	        total.setFont(new Font ("Times New Roman", Font.BOLD, 30));
	       
	        checkPanel.add(discountlbl);
	        discountlbl.setBounds(10, 135, 200, 50);
	        discountlbl.setText("Discount:");
	        discountlbl.setFont(new Font ("Times New Roman", Font.BOLD, 30));
	        
	        checkPanel.add(payment);
	        payment.setBounds(10, 175, 200, 50);
	        payment.setText("Payment:");
	        payment.setFont(new Font ("Times New Roman", Font.BOLD, 30));
	        
	        checkPanel.add(change);
	        change.setBounds(10, 215, 200, 50);
	        change.setText("Change:");
	        change.setFont(new Font ("Times New Roman", Font.BOLD, 30));

	        
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
	        rbStudent.setBounds(20, 60, 150, 25);
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
	        
	      //button discounts
	        rbStudent.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                if (rbStudent.isSelected()) {
	                    double discountAmount = price * 0.03; // Calculate the discount amount
	                    boxDiscount.setText(String.format("%.2f", discountAmount)); // Update the boxDiscount field
	                    double discountedPrice = price - discountAmount; // Calculate the discounted price
	                    txtAmount.setText(String.format("%.2f", discountedPrice)); // Update the txtAmount field
	                } else {
	                    boxDiscount.setText(""); // Clear the boxDiscount field if the radio button is deselected
	                    txtAmount.setText(String.format("%.2f", price)); // Display the original price
	                }
	            }
	        });

	        rbSenior.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                if (rbSenior.isSelected()) {
	                    double discountAmount = price * 0.20; // Calculate the discount amount
	                    boxDiscount.setText(String.format("%.2f", discountAmount)); // Update the boxDiscount field
	                    double discountedPrice = price - discountAmount; // Calculate the discounted price
	                    txtAmount.setText(String.format("%.2f", discountedPrice)); // Update the txtAmount field
	                } else {
	                    boxDiscount.setText(""); // Clear the boxDiscount field if the radio button is deselected
	                    txtAmount.setText(String.format("%.2f", price)); // Display the original price
	                }
	            }
	        });


	        
	        btnBuy.setBounds(55, 270, 200, 40);
	        btnBuy.setText("Purchase");
	        btnBuy.setBackground(Color.decode("#E6D5B8"));
	        btnBuy.setFocusable(false);
	        btnBuy.addActionListener(new ActionListener(){

	        	@Override
	        	public void actionPerformed(ActionEvent e) {
	        	    if(modelList.isEmpty()) {
	        	        JOptionPane.showMessageDialog(null, "Please select Order!");
	        	    } else if (txtPayment.getText().equals("")) {
	        	        JOptionPane.showMessageDialog(null, "Please select Payment!");
	        	    } else {
	        	        double amount = Double.parseDouble(txtAmount.getText());
	        	        double payment = Double.parseDouble(txtPayment.getText());

	        	        if (payment < amount) {
	        	            JOptionPane.showMessageDialog(null, "Please enter the right amount");
	        	        } else {
	        	            // Calculate the discount amount
	        	            double discountAmount = 0;
	        	            if (rbStudent.isSelected()) {
	        	                discountAmount = price * 0.03;
	        	            } else if (rbSenior.isSelected()) {
	        	                discountAmount = price * 0.20;
	        	            }

	        	            // Subtract the discount amount from the total amount
	        	            double discountedTotal = price - discountAmount;

	        	            // Calculate the change
	        	            double changeAmount = payment - discountedTotal;

	        	            // Display the change
	        	            boxChange.setText(String.format("%.2f", changeAmount));
	        	            
	        	            // Open the receipt
	        	            JDialog dialog = new JDialog(null, Dialog.DEFAULT_MODALITY_TYPE);
	        	            dialog.setSize(330, (modelList.getSize() * 20) + 340);
	        	            dialog.setLocationRelativeTo(null);
	        	            dialog.setUndecorated(true);
	        	            dialog.setVisible(true);
	        	        }
	        	    }
	        	
	        	}});
	        
	        txtAmount.setBounds(140, 105, 150, 35);
	        txtAmount.setEditable(false);
	        txtAmount.setOpaque(false);
	        
	        boxDiscount.setBounds(140, 145, 150, 35);
	        boxDiscount.setEditable(false);
	        
	        boxChange.setBounds(140, 225, 150, 35);
	        boxChange.setEditable(false);
	        
	        txtPayment.setBounds(140, 185, 150, 35);
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
		                // If the checkbox is deselected, it removes the item from the list
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
