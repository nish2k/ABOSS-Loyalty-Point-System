/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aboss.loyalty.point.system;

import Managers.dbManager;
import Managers.idGenerator;
import aboss.loyalty.point.system.GUI.Menu;
import aboss.loyalty.point.system.GUI.MainMenu;
import java.awt.BorderLayout;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JPanel;
import org.json.JSONObject;

/**
 *
 * @author dubze
 */
public class Main {

    static final File CUSTOMERLIST = new File("Customer.json");
    //static ArrayList<Customer> customers = new ArrayList<Customer>();
    static final Scanner scan = new Scanner(System.in);
    static JSONObject jobj;
    public static JFrame f;

    public static void main(String[] args) throws Exception {
        idGenerator idg = new idGenerator();
        for(int x=0; x<10; x++){
            System.out.println(idg.nextSessionId());
        }

        start();
        Menu m = new Menu(jobj, CUSTOMERLIST);
        f = new JFrame("ABOSS");
        f.add(new MainMenu(new dbManager(jobj,CUSTOMERLIST)));

        f.setDefaultCloseOperation(EXIT_ON_CLOSE);
        f.pack();
        f.validate();
        f.setVisible(true);

    }

    static void start() throws Exception {

        String result = "";
        if (CUSTOMERLIST.exists()) {

            try {
                BufferedReader br = new BufferedReader(new FileReader(CUSTOMERLIST));
                StringBuilder sb = new StringBuilder();
                String line = br.readLine();
                while (line != null) {
                    sb.append(line);
                    line = br.readLine();
                }
                result = sb.toString();
                System.out.println(result);
                createJObj(result);
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else {
            createJObj("{}");
        }
    }

    static void createJObj(String jsonList) throws IOException {
        jobj = new JSONObject(jsonList);
        if (!(jsonList.equals("{}"))) {
          //  fill(jobj);
        }

    }

    /*static void fill(JSONObject jobj) {
        Iterator<?> keys = jobj.keys();

        for (Object key : jobj.keySet()) {

            String keyStr = (String) key;

            System.out.println("key: " + keyStr);
            
            

        }
    }*/

    static void createJson() throws Exception {

        try {

            File json = new File("Customer.json");

            json.createNewFile();
            FileWriter fw = new FileWriter(json, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter wr = new PrintWriter(bw);
            String line = "{\"state\":\"empty\"}";
            wr.println(line);
            wr.close();
            start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void refresh(JPanel pan) {
        //repaint();
        //revalidate();
        f.getContentPane().removeAll();
        f.getContentPane().add(pan);
        f.validate();
        f.setVisible(true);
    }
    
    
    
    public static void updateJSON(JSONObject job){
        jobj = job;
    }
    
    public static void reset(){
        f.getContentPane().removeAll();
        f.getContentPane().add(new MainMenu(new dbManager(jobj,CUSTOMERLIST)));
        f.validate();
        f.setVisible(true);
    }

}
