package aboss.loyalty.point.system.GUI;

import Managers.dbManager;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author dubze
 */
public class AddCustomer extends JPanel {

    JTextField iID = new JTextField(10);

    JTextField uID = new JTextField(10);

    JTextField name = new JTextField(30);

    JTextField add = new JTextField(30);

    JButton ok, c;
    
    dbManager dbM;

    public AddCustomer(dbManager dbM) {
        
        this.dbM = dbM;
        
        setLayout(new GridLayout(5, 0));

        JPanel pID = new JPanel();
        // pID.setPreferredSize(new Dimension(800,100));
        JLabel id = (new JLabel("Enter Initial ID "));
        id.setPreferredSize(new Dimension(200, 100));
        pID.add(id);
        iID.setPreferredSize(new Dimension(200, 100));
        pID.add(iID);
        add(pID);

        JPanel puID = new JPanel();
        // puID.setPreferredSize(new Dimension(800,100));        
        JLabel ud = new JLabel("Enter unique ID");
        ud.setPreferredSize(new Dimension(200, 100));
        puID.add(ud);
        uID.setPreferredSize(new Dimension(200, 100));
        puID.add(uID);
        add(puID);

        JPanel pN = new JPanel();
        JLabel n = new JLabel("Enter name");
        n.setPreferredSize(new Dimension(200, 100));
        pN.add(n);
        name.setPreferredSize(new Dimension(200, 100));
        pN.add(name);
        add(pN);

        JPanel pA = new JPanel();
        JLabel a = new JLabel("Enter address");
        a.setPreferredSize(new Dimension(200, 100));
        pA.add(a);
        add.setPreferredSize(new Dimension(200, 100));
        pA.add(add);
        add(pA);

        ok = new JButton("OK");
        c = new JButton("Cancel");
        JPanel option = new JPanel();
        option.add(ok);
        option.add(c);
        add(option);
    }

    void addC() throws IOException {
        String i = iID.getText();
        String u = uID.getText();
        String n = name.getText();
        String a = add.getText();

        String cust = "{iID:" + i + ",uID:" + u + ",name:" + n + ",address:" + a + ",points:" + 0 +  "}";
        dbM.write(u, cust);
        
        System.out.println(cust);
    }
    
    

}
