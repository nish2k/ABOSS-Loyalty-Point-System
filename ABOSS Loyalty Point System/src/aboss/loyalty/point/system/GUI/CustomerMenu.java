package aboss.loyalty.point.system.GUI;

import aboss.loyalty.point.system.Main;
import static aboss.loyalty.point.system.Main.f;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dubze
 */
public class CustomerMenu extends JPanel{
    
     
     
    public CustomerMenu(){
        setLayout(new GridLayout(5,1));
        
        JLabel cusL = new JLabel("What would the customer like to do?");
        cusL.setFont(new Font("Helvetica", Font.ITALIC,50));
        
        
        
        JPanel lab = new JPanel();
        lab.add(cusL);
        
        JPanel vP = new JPanel();
        JButton v = new JButton("View Customer Profile");
        v.setPreferredSize(new Dimension(200,100));
        vP.add(v);
        
        JPanel rP = new JPanel();
        JButton r = new JButton("Redeem Reward");
        r.addActionListener(new rewOption());
        r.setPreferredSize(new Dimension(200,100));
        rP.add(r);
        
        JPanel point = new JPanel();
        JButton p = new JButton("Add Points");
        p.setPreferredSize(new Dimension(200,100));
        point.add(p);
        
        JPanel home = new JPanel();
        JButton back = new JButton("Home Screen");
        back.setPreferredSize(new Dimension(200,100));
        back.addActionListener(new mainOption());
        home.add(back);
        
        add(lab);
        add(vP);
        add(rP);
        add(point);
        add(home);
        
    }
    
    class rewOption implements ActionListener{
        public void actionPerformed(ActionEvent ae) {
            f.getContentPane().removeAll();
            f.getContentPane().add(new Rewards());
            f.validate();
            f.setVisible(true);
        }
    }
    
    class mainOption implements ActionListener{
        public void actionPerformed(ActionEvent ae) {
            Main.reset();
        }
    }
    
    void reload(){
        Main.refresh(this);
    }
    
    
    
}
