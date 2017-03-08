/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aboss.loyalty.point.system;

/**
 *
 * @author Nish1
 */

public class Collection {
    
    public float price;
    private int conPrice;
    public Collection(float price){
    
    this.price = price;
    
    }
    
    public void convertPoints(){
        conPrice = Math.round(price);
    }
    
    public int getPoints(){
        return conPrice;
    }    
}
