package ProjectInterface;

import project.Users;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 *
 * @author Donte'
 */
public class Home {     
    
    JFrame fHome = new JFrame("G19 Shopping: Home");    
    JPanel pHome = new JPanel();    
    JLabel headerHome = new JLabel("G19 Shopping");    
    JButton homeBtn = new JButton("SIGN IN");
        
    /**
     * Constructor
     */
    public Home() {    
             
        homeBtn.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e)
            {
                
                
                new SignIn();
                            
                               
                fHome.setVisible(false);
            }
        });
        
        pHome.setLayout(new GridBagLayout()); 
        GridBagConstraints cHome = new GridBagConstraints();
        cHome.insets = new Insets(30, 30, 30, 30);        
        
        headerHome.setFont(new Font("Arial", Font.BOLD, 150));
        pHome.add(headerHome, cHome);
        
        cHome.gridx = 0;
        cHome.gridy = 1;
        cHome.ipadx = 100;
        cHome.ipady = 20;
        homeBtn.setHorizontalAlignment(JLabel.CENTER);
        homeBtn.setFont(new Font("Arial", Font.PLAIN, 50));
        pHome.add(homeBtn, cHome);        
        
        fHome.add(pHome);        
        fHome.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fHome.setSize(2000, 1000);  
        fHome.setBackground(Color.white);
        fHome.setVisible(true);        
        
        pHome.setBackground(Color.yellow);        
    }    
}
