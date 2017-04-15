/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aboss.loyalty.point.system.GUI;

import static aboss.loyalty.point.system.Main.f;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import org.json.JSONObject;

/**
 *
 * @author dubze
 */
public class Menu extends JPanel {

    JSONObject j;
    
    JButton ok, c;

    File file;

    JTextField iID = new JTextField(10);

    JTextField uID = new JTextField(10);

    JTextField name = new JTextField(30);

    JTextField add = new JTextField(30);

    public Menu(JSONObject jobj, File jsonFile) {
        j = jobj;

        file = jsonFile;

        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        JButton add = new JButton("Add Customer");
        add.addActionListener(new addListener());

        JButton view = new JButton("View All Cusutomers");
        view.addActionListener(new viewListener());

        add(add);
        add(view);

    }

    class addListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            try {
                newCustomer();
            } catch (IOException e) {

            }
        }
    }

    class viewListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            try {
                viewCustomers();
            } catch (IOException e) {

            }
        }
    }

    void newCustomer() throws IOException {
        removeAll();
        setLayout(new GridLayout(0,1));
        add(new JLabel("Enter Initial ID "));

        add(iID);
        add(new JLabel("Enter unique ID"));

        add(uID);
        add(new JLabel("Enter name"));

        add(name);
        add(new JLabel("Enter address"));

        add(add);
        ok = new JButton("OK");
        c = new JButton("Cancel");
        JPanel option = new JPanel();
        option.add(ok);
        option.add(c);
        ok.addActionListener(new decision());
        c.addActionListener(new decision());
        add(option);
        refresh();


        /* JPanel addP = new JPanel(new GridLayout(0, 1));
        addP.add(new JLabel("Enter Initial ID "));
        JTextField iID = new JTextField(10);
        addP.add(iID);
        addP.add(new JLabel("Enter unique ID"));
        JTextField uID = new JTextField(10);
        addP.add(uID);
        addP.add(new JLabel("Enter name"));
        JTextField name = new JTextField(30);
        addP.add(name);
        addP.add(new JLabel("Enter address"));
        JTextField add = new JTextField(30);
        addP.add(add);
        JOptionPane.showMessageDialog(new JFrame(), "WH");
        int d = JOptionPane.showConfirmDialog(null, addP, "Add Customer", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (d == JOptionPane.OK_OPTION) {
            String iID1 = iID.getText();
            String uID1 = uID.getText();
            String name1 = name.getText();
            String add1 = add.getText();
            String cust = "{iID:" + iID1 + ",uID:" + uID1 + ",name:" + name1 + ",address:" + add1 + "}";
            j.put(uID1, cust);
            update();
        }*/
    }

    class decision implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            if (ae.getSource() == ok) {
                String iID1 = iID.getText();
                String uID1 = uID.getText();
                String name1 = name.getText();
                String add1 = add.getText();
                String cust = "{iID:" + iID1 + ",uID:" + uID1 + ",name:" + name1 + ",address:" + add1 + "}";
                j.put(uID1, cust);
                try{
                update();
                }
                catch (IOException e){
                    
                }
                reset();
            }
        }
    }

    void update() throws IOException {
        FileWriter jFW = new FileWriter(file, false);
        String t = j.toString();
        System.out.println(t);
        jFW.write(j.toString());
        jFW.close();
    }

    void viewCustomers() throws IOException {

        JButton m = new JButton("Return to Main Menu");
        m.addActionListener(new mainMenu());
        String keys = "";
        for (Object key : j.keySet()) {

            String keyStr = (String) key;
            keys += keyStr + "\n";
            System.out.println("key: " + keyStr);

        }
        JTextArea jtx = new JTextArea();
        jtx.append(keys);

        JScrollPane p = new JScrollPane(jtx);
        removeAll();
        setLayout(new BorderLayout());
        add(p, BorderLayout.NORTH);
        add(m, BorderLayout.SOUTH);
        refresh();

    }
    
     class mainMenu implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            reset();
        }
    }

    private void refresh() {
        //repaint();
        //revalidate();
        f.getContentPane().removeAll();
        f.getContentPane().add(this);
        f.validate();
        f.setVisible(true);
    }
    
    private void reset(){
        f.getContentPane().removeAll();
        f.getContentPane().add(new Menu(j, file));
        f.validate();
        f.setVisible(true);
    }

}
