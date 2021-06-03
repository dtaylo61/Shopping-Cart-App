package ProjectInterface;

import project.Controller;
import project.User;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



/**
 *
 * @author Donte'
 */
public class CheckOut {
    
    Controller controller = new Controller();
    JLabel username;
    JFrame fCheckout = new JFrame("G19 Shopping: Check Out");
    JPanel pCheckout = new JPanel();
    JLabel headerCO = new JLabel("G19 Shopping");
    JLabel lCheckout = new JLabel("Enter Payment Information");
    JRadioButton ccType1 = new JRadioButton("VISA");
    JRadioButton ccType2 = new JRadioButton("MC");
    JRadioButton ccType3 = new JRadioButton("AMEX");
    JRadioButton ccType4 = new JRadioButton("DISCOVERY");
    JLabel ccNum = new JLabel("Credit Card #:");
    JLabel expDate = new JLabel("Exp Date:");
    JLabel cvvNum = new JLabel("CVV #:");
    JTextField cc = new JTextField(16);
    JTextField exp = new JTextField(5);
    JTextField cvv = new JTextField(3);
    JButton placeOrderBtn = new JButton("PLACE ORDER");
    


    /**
     *
     * @param u
     */
        public CheckOut(User u) {
        
        username = new JLabel(u.getUsername());
        pCheckout.setLayout(new GridBagLayout());
        GridBagConstraints cCheckout = new GridBagConstraints();
        cCheckout.fill = GridBagConstraints.HORIZONTAL;
        cCheckout.insets = new Insets(20, 20, 20, 20);
        
        cCheckout.gridwidth = 5;
        cCheckout.gridx = 1;
        cCheckout.gridy = 0;
        headerCO.setHorizontalAlignment(JLabel.CENTER);
        headerCO.setFont(new Font("Arial", Font.BOLD, 70));
        pCheckout.add(headerCO, cCheckout);
    
        cCheckout.gridwidth = 5;
        cCheckout.gridx = 1;
        cCheckout.gridy = 1;
        lCheckout.setHorizontalAlignment(JLabel.CENTER);
        lCheckout.setFont(new Font("Arial", Font.PLAIN, 50));
        pCheckout.add(lCheckout, cCheckout);   
        
        cCheckout.gridwidth = 1;
        cCheckout.gridx = 1;
        cCheckout.gridy = 2;
        ccType1.setFont(new Font("Arial", Font.PLAIN, 30));
        pCheckout.add(ccType1, cCheckout);
        
        cCheckout.gridwidth = 1;
        cCheckout.gridx = 2;
        cCheckout.gridy = 2;
        ccType2.setFont(new Font("Arial", Font.PLAIN, 30));
        pCheckout.add(ccType2, cCheckout);
        
        cCheckout.gridwidth = 1;
        cCheckout.gridx = 3;
        cCheckout.gridy = 2;
        ccType3.setFont(new Font("Arial", Font.PLAIN, 30));
        pCheckout.add(ccType3, cCheckout);
        
        cCheckout.gridwidth = 1;
        cCheckout.gridx = 4;
        cCheckout.gridy = 2;
        ccType4.setFont(new Font("Arial", Font.PLAIN, 30));
        pCheckout.add(ccType4, cCheckout);
    
        cCheckout.gridwidth = 1;
        cCheckout.gridx = 0;
        cCheckout.gridy = 3;
        ccNum.setHorizontalAlignment(JLabel.RIGHT);
        ccNum.setFont(new Font("Arial", Font.PLAIN, 30));
        pCheckout.add(ccNum, cCheckout);
    
        cCheckout.gridwidth = 4;
        cCheckout.gridx = 1;
        cCheckout.gridy = 3;
        cCheckout.ipadx = 100;
        cCheckout.ipady = 20;
        cc.setFont(new Font("Arial", Font.PLAIN, 30));
        pCheckout.add(cc, cCheckout);
        
        cCheckout.gridwidth = 1;
        cCheckout.gridx = 0;
        cCheckout.gridy = 4;
        expDate.setHorizontalAlignment(JLabel.RIGHT);
        expDate.setFont(new Font("Arial", Font.PLAIN, 30));
        pCheckout.add(expDate, cCheckout);
    
        cCheckout.gridwidth = 3;
        cCheckout.gridx = 1;
        cCheckout.gridy = 4;
        cCheckout.ipadx = 100;
        cCheckout.ipady = 20;
        exp.setFont(new Font("Arial", Font.PLAIN, 30));
        pCheckout.add(exp, cCheckout);
        
        cCheckout.gridwidth = 1;
        cCheckout.gridx = 0;
        cCheckout.gridy = 5;
        cvvNum.setHorizontalAlignment(JLabel.RIGHT);
        cvvNum.setFont(new Font("Arial", Font.PLAIN, 30));
        pCheckout.add(cvvNum, cCheckout);
    
        cCheckout.gridwidth = 1;
        cCheckout.gridx = 1;
        cCheckout.gridy = 5;
        cCheckout.ipadx = 100;
        cCheckout.ipady = 20;
        cvv.setFont(new Font("Arial", Font.PLAIN, 30));
        pCheckout.add(cvv, cCheckout);
    
        cCheckout.gridx = 6;
        cCheckout.gridy = 6;
        cCheckout.ipadx = 50;
        cCheckout.ipady = 20;
        placeOrderBtn.setHorizontalAlignment(JLabel.CENTER);
        placeOrderBtn.setFont(new Font("Arial", Font.PLAIN, 40));
        placeOrderBtn.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e)
            {
                controller.completeTransaction(username.getText());
                fCheckout.setVisible(false);
            }
            });
        
        pCheckout.add(placeOrderBtn, cCheckout);
        
        pCheckout.setBackground(Color.yellow);
        
        /* For JFrame */
        fCheckout.add(pCheckout);
        fCheckout.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fCheckout.setSize(2000, 1000);
        fCheckout.setBackground(Color.white);
        fCheckout.setVisible(true);  
    }
}
