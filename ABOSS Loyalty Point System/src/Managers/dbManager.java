/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Managers;

import aboss.loyalty.point.system.Main;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import org.json.JSONObject;

/**
 *
 * @author dubze
 */
public class dbManager {

    JSONObject j;
    File fl;

    public dbManager(JSONObject ob, File fil) {
        j = ob;
        fl = fil;
    }

    public void addToJSON(String key, String update) {
        j.put(key, update);
        Main.updateJSON(j);
    }

    public void write(String key, String update) throws IOException {
        addToJSON(key, update);
        FileWriter jFW = new FileWriter(fl, false);
        String t = j.toString();
        System.out.println(t);
        jFW.write(j.toString());
        jFW.close();
        
    }
    
    public JSONObject getJSON()
    {
        return j;
    }
}
