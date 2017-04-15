/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aboss.loyalty.point.system.GUI;

import aboss.loyalty.point.system.Main;
import Managers.dbManager;
import static aboss.loyalty.point.system.Main.f;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author dubze
 */
public class MainMenu extends JPanel {

    JButton newC = new JButton("Add new customer");
    JButton bar = new JButton("Scan Barcode");
    JButton view = new JButton("View All Customers");

    dbManager db;

    public MainMenu(dbManager db) {
        this.db = db;
        setLayout(new GridLayout(5, 1));
        newC.setPreferredSize(new Dimension(200, 50));
        bar.setPreferredSize(new Dimension(200, 50));
        view.setPreferredSize(new Dimension(200, 50));
        newC.addActionListener(new newButton());
        bar.addActionListener(new cusOption());
        view.addActionListener(new allCus());

        JPanel f = new JPanel();
        JPanel s = new JPanel();
        JPanel b = new JPanel();
        JPanel m = new JPanel();
        JPanel v = new JPanel();
        
        b.setBackground(new Color(255, 51, 51));
        s.setBackground(new Color(255, 51, 51));
        f.setBackground(new Color(255, 51, 51));
        m.setBackground(new Color(255, 51, 51));
        v.setBackground(new Color(255, 51, 51));
        JLabel l = new JLabel("A-BOSS Loyalty Program");
        JLabel i = new JLabel("Choose an option below");
        l.setFont(new Font("Helvetica", Font.ITALIC, 100));
        i.setFont(new Font("Sans Serif", Font.BOLD, 50));
        f.setPreferredSize(new Dimension(720, 404));
        s.setPreferredSize(new Dimension(720, 404));
        f.add(newC);
        s.add(bar);
        b.add(l);
        m.add(i);
        v.add(view);
        add(b);
        add(m);
        add(f);
        add(s);
        add(v);
    }

    class newButton implements ActionListener {

        public void actionPerformed(ActionEvent ae) {
            //f.getContentPane().removeAll();
            //f.getContentPane().add(new AddCustomer());
            AddCustomer ac = new AddCustomer(db);
            int h = JOptionPane.showConfirmDialog(null, ac, "Add Item", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
            if (h == JOptionPane.OK_OPTION) {
                try {
                    ac.addC();
                } catch (IOException ex) {
                    Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                //Main.refresh(new MainMenu());
            }

            // f.validate();
            // f.setVisible(true);
        }
    }

    class cusOption implements ActionListener {

        public void actionPerformed(ActionEvent ae) {
             f.getContentPane().removeAll();

            f.getContentPane().add(new CustomerMenu());
            f.validate();
            f.setVisible(true);
        }
    }

    class allCus implements ActionListener {

        public void actionPerformed(ActionEvent ae) {
            Main.refresh(new CustomerView(db));
        }
    }
    

    

}
