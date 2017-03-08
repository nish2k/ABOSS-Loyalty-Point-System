/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aboss.loyalty.point.system;

import java.util.Scanner;
import java.util.UUID;

public class User {
   
    public static void main(String[] args) {
              
        int choice = 0;
          
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter Customer enter scanned customer ID:");
        String ph1 = scan.nextLine();
        Scan scan1 = new Scan(ph1);
        Customer cus1 = new Customer();
        while(choice!=5)
        {       
            System.out.println("******A-BOSS Loyalty Program******");
            System.out.println("1. Create Customer Profile");
            System.out.println("2. Add Points");
            System.out.println("3. Redeem Points");
            System.out.println("4. View Customer Profile");
            System.out.print("Select an option:");
            choice = scan.nextInt();

            if (choice==1){
            System.out.println("Please enter name of new customer: ");
            String name = scan.nextLine();
            System.out.println("Please enter a valid ID# (UWI#, TRN, etc) for new customer: ");
            String id = scan.nextLine();
            String unId = UUID.randomUUID().toString();
            System.out.println("Please enter an address for new customer: ");
            String address = scan.nextLine();
            int points = 0;
            Customer n = new Customer(id,unId,name,address,points);
            cus1.addCustomer(n);
            }

            if (choice ==2){
              Customer y = cus1.returnCus(scan1.getID());

              if (!y.getuniqueID().equals("")){
                 System.out.println("Please enter total price of purchase: ");
                 float price = scan.nextFloat();
                 Collection f = new Collection(price);
                 y.addPoints(scan1.getID(), f);
              }
            }

            if (choice == 3){
            Customer n = cus1.returnCus(scan1.getID());
             if (!n.getuniqueID().equals("")){
                 n.redeemPoints(scan1.getID());
              }
            }

            if (choice == 4){
               Customer n = cus1.returnCus(scan1.getID());
                System.out.println(n.viewCustomer(n));     
            }                
        }
    }
}

