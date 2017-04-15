/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aboss.loyalty.point.system.GUI;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author dubze
 */
public class Rewards extends JPanel{
    
    public Rewards(){
        setLayout(new GridLayout(3,1));
        
        JLabel rewL = new JLabel("Choose the type of reward the customer would like to redeem");
        rewL.setFont(new Font("Helvetica", Font.ITALIC,50));
        
        JPanel rewP = new JPanel();
        rewP.add(rewL);
        
        JPanel dis = new JPanel();
        JButton d = new JButton("Discounts");
        d.setPreferredSize(new Dimension(200,100));
        dis.add(d);
        
        JPanel free = new JPanel();
        JButton f = new JButton("Free Purchase");
        f.setPreferredSize(new Dimension(200,100));
        free.add(f);
        
        add(rewP);
        add(dis);
        add(free);
    }
    
}
