package FoodOrderingSystem;
import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.ImageIcon;
import javax.swing.*;

public class OrderingFrame extends JFrame implements ActionListener{
	
		
		JPanel dinePanel = new JPanel();
		JPanel sidesPanel = new JPanel();
		JPanel mainPanel = new JPanel();
		JPanel detailPanel = new JPanel();
		JPanel drinksPanel = new JPanel();
		JPanel checkPanel = new JPanel();
		//label components
		JLabel sideslbl = new JLabel();
		JLabel mainlbl = new JLabel();
		JLabel drinkslbl = new JLabel();
		
		JLabel total = new JLabel();
		JLabel payment = new JLabel();
		//radio button
		JRadioButton rbDineIn = new JRadioButton();
		JRadioButton rbTakeOut = new JRadioButton();
		
		
		ButtonGroup btngroup = new ButtonGroup();
		
		DefaultListModel<String> modelPrice = new DefaultListModel<String>();
		DefaultListModel<String> modelList = new DefaultListModel<String>();
		
		JList itemList = new JList<String>(modelList);
		JScrollPane scroll = new JScrollPane(itemList);
		
		
		String[] items = {"Hamburger", "Fries", "Bacon", "Ramen", "Hotdog",};
		JCheckBox[] checkBoxes = new JCheckBox[items.length];
		double menuPrice[] = {69.0, 727.0, 23.0, 23.0, 343.0};
		
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

	        
	        // Array
	        
	        int verticalSpacing = 30; // The vertical space between each checkbox			
	        for (int i = 0; i < items.length; i++) {
	        	// Initialize JCheckBox with the text from the items array
	            checkBoxes[i] = new JCheckBox(items[i]);
	            // Set bounds for each JCheckBox: x, y, width, height
	            checkBoxes[i].setBounds(10, (i * verticalSpacing) + 50, 100, 25);
	            // Add the JCheckBox to the coursePanel
	            sidesPanel.add(checkBoxes[i]);
	            checkBoxes[i].addActionListener(this);
	        }
	        
	        JLabel[] pricelbl = new JLabel[menuPrice.length];
	        verticalSpacing = 30; // The vertical space between each checkbox					
	        for (int i = 0; i < menuPrice.length; i++) {
	        	// Initialize JCheckBox with the text from the items array
	        	pricelbl[i] = new JLabel(String.valueOf(menuPrice[i]));
	            // Set bounds for each JCheckBox: x, y, width, height
	        	pricelbl[i].setBounds(150, (i * verticalSpacing) + 50, 100, 25);
	            // Add the JCheckBox to the coursePanel
	            sidesPanel.add(pricelbl[i]);
	        }
	        // Refresh the panel to display the checkboxes
	        sidesPanel.revalidate();
	        sidesPanel.repaint();
	    //    ImageIcon burger = new ImageIcon("burger.png");
	     // dine panel
	        this.add(dinePanel);
	        dinePanel.setBounds(20, 80, 245 ,50);
	        dinePanel.setFocusable(false);
	        dinePanel.setLayout(null);

	        rbDineIn.setText("Dine In");
	        rbDineIn.setBounds(20, 0, 100 ,50);
	        rbDineIn.setFocusable(false);
	        dinePanel.add(rbDineIn);

	        rbTakeOut.setText("Take Out");
	        rbTakeOut.setBounds(120, 0, 100 ,50);
	        rbTakeOut.setFocusable(false);
	        dinePanel.add(rbTakeOut);

	        btngroup.add(rbDineIn);
	        btngroup.add(rbTakeOut);
	       
	        //main panel
	        
	        this.add(mainPanel);
	        mainPanel.setBounds(280, 140, 410 ,525);
	        mainPanel.setLayout(null);
	        blackBorder = BorderFactory.createLineBorder(Color.BLACK, 5);
	        mainPanel.setBorder(blackBorder);
	        mainPanel.setBackground(Color.pink);
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
	        detailPanel.setBounds(960, 20, 305 ,450);
	        //detailPanel.setLayout(null);
	        //blackBorder = BorderFactory.createLineBorder(Color.BLACK, 5);
	        //detailPanel.setBorder(blackBorder);
	        detailPanel.setLayout(new BorderLayout());
	        detailPanel.add(scroll);
	       
	        this.add(checkPanel);
	        checkPanel.setBounds(960, 485, 305 ,180);
	        checkPanel.setLayout(null);
	        blackBorder = BorderFactory.createLineBorder(Color.BLACK, 5);
	        checkPanel.setBorder(blackBorder);
	       
	        
	        checkPanel.add(btnBuy);
	        checkPanel.add(txtAmount);
	        checkPanel.add(txtPayment);
	        checkPanel.add(total);
	        total.setBounds(10, 10, 200, 50);
	        total.setText("Total:");
	        total.setFont(new Font ("Times New Roman", Font.BOLD, 30));
	        checkPanel.add(payment);
	        payment.setBounds(10, 50, 200, 50);
	        payment.setText("Payment:");
	        payment.setFont(new Font ("Times New Roman", Font.BOLD, 30));
	        
	        btnBuy.setBounds(55, 115, 200, 50);
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
	        
	        txtAmount.setBounds(140, 10, 150, 40);
	        txtAmount.setEditable(false);
	        txtAmount.setOpaque(false);
	        
	        txtPayment.setBounds(140, 60, 150, 40);
		}


		@Override
		public void actionPerformed(ActionEvent e) {
		    for (int i = 0; i < items.length; i++) {
		        if (e.getSource() == checkBoxes[i]) {
		            if (checkBoxes[i].isSelected()) {
		                modelList.addElement(checkBoxes[i].getText());
		                modelPrice.addElement(String.valueOf(menuPrice[i]));
		                price += menuPrice[i];
		            } else {
		                // If the checkbox is deselected, remove the item from the list
		                modelList.removeElement(checkBoxes[i].getText());
		                modelPrice.removeElement(String.valueOf(menuPrice[i]));
		                price -= menuPrice[i];
		            }
		        }		txtAmount.setText(String.valueOf(price));
		    }

		}

}
