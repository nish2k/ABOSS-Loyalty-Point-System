/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aboss.loyalty.point.system;

import java.util.Scanner;

/**
 *
 * @author Nish1
 */
public class Customer {
    
    private String initialId;
    private String uniqueId;
    private String address;
    private String name;
    private int points;
    private Customer[] custList; 
    
    public Customer(){
       
    custList = new Customer[10];
    
      custList[0] = new Customer ("12322","1234DES","Towers Hall, Uwi Mona","Bob Myers",0);

      custList[1] = new Customer("12232","154!EES","Chancellor, Uwi Mona","Crippy Myers",0);
      
      custList[2] = new Customer("18322","1114SES","Towers Hall, Uwi Mona","Eastern Myers",0);   
    }
    
    public Customer (String initialId, String uniqueId, String name, String address, int points){
        this.initialId = initialId;
        this.uniqueId = uniqueId;
        this.address = address;
        this.name = name;
        points = 0;
        
    }
    
    public void addCustomer(Customer n){
        int i = 0;
        while (i<custList.length){
            if (custList[i]==null){
                custList[i] = n;
                i = custList.length;
            }
        }
    }
           
    public String getuniqueID(){
        return uniqueId;
    }
    
    public void setPoints(int y){
    this.points = y;
    }
    
    public int getPoints(){
        return points;
    }
    
    public String getName(){
    return name;
    }
    
    public String getinitialID(){
    return initialId;
    }
    
    public String getAddress(){
    return address;
    }
    
    public String viewCustomer(){
    
        String mess = "Customer name: " + getName();
        mess+= "\n Customer initial ID: " + getinitialID();
        mess+= "\nCustomer unique ID: " + getuniqueID();
        mess+= "\n Customer address: " + getAddress();
        mess+= "\nCurrent customer points: " + getPoints();
        mess+= "\n_________________________________________________________";
        
        return mess;   
    }
    
   public Customer returnCus(String y){
   int x = 0;
   int u = 0;
   Customer t = new Customer("","","","");
   System.out.println(custList.length);
   while (x<custList.length){
        System.out.println(custList[x].getuniqueID());
        if (custList[x].getuniqueID().equals(y)){
        t = custList[x];
        u = 1;
        x = custList.length;
        }
        x++;
   }
   
    if (u!=1){
        System.out.println("No match found, returning empty customer");
        }
   return t;
   }
   
  public void addPoints(String y, Collection col){
    int x = 0;
    System.out.println(custList[0]);
        while (x<custList.length){
            
            if (custList[x].getuniqueID().equals(y)){
                System.out.println(custList[x]);
               int newpoints = custList[x].getPoints();
               newpoints += col.getPoints();
               custList[x].setPoints(newpoints);
               x=custList.length;
            }
        x++;
        }
    }  
      
    public String redeemPoints(String id){
         Scanner decision = new Scanner(System.in);
        System.out.print("Please enter the item you would like to redeem");
        String item = decision.nextLine();       
        System.out.print("Please enter the required amount of points to redeem item");
        int req;
        req = decision.nextInt();
        String message = "";
        int x = 0;
        
        while (x<custList.length){
            if (id.equals(custList[x].getuniqueID())){
                if(custList[x].getPoints() >= req)
                { 
                    System.out.print("Would you like to redeem your reward?");
                    String set = decision.nextLine();
            
                    if (set.equals("yes"))
                    {               
                        int newpoints = custList[x].getPoints();
                        newpoints -= req;
                        custList[x].setPoints(newpoints);
                        message = "You have redeemed: " + item;
                    }
                    else if (set.equals("no"))
                    {
                        message = "You have chosen not to redeem item, Thank you!";
                    }
                }
                else if(points <= req)
                {
                    message = "You do not have the required amount of points to redeem: " +item + ". The new customer balance is: " + custList[x].getPoints();
                }
            }
        }
        
        return message;
    }
}
