/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelarray;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 *
 * @author Isuru
 */
public class Main {

    //public static ArrayList<Customer> custmer = new ArrayList<Customer>();

    public static Customer[] custmer = new Customer[10];
    public static boolean cont = true;

    public static void main(String[] args) throws IOException {
        System.out.println("   Welcome to Hotel managment System     ");
        System.out.println("_________________________________________");
        RoomBook.initialise(custmer);
        Scanner sc = new Scanner(System.in);

        while (cont) {
            System.out.println("Enter V to view all room details                :");
            System.out.println("Enter E to view available rooms                 :");
            System.out.println("Enter A to add customer to room                 :");
            System.out.println("Enter D to delete customer from room            :");
            System.out.println("Enter F to find room number from customer name  :");
            System.out.println("Enter S to insert details to the file           :");
            System.out.println("Enter L to read the data file                   :");
            System.out.println("Enter 3 to view queue                           :");
            String action = sc.next();

            // implement the  roomDetails(hotel); method
            if (action.equalsIgnoreCase("v")) {
                RoomBook.roomDetails(custmer);
                cont();

                // implement the emptyRooms(hotel); method
            } else if (action.equalsIgnoreCase("a")) {
                RoomBook.addcustomer(custmer);
                cont();

                // implement the deletcustomer(hotel); method
            } else if (action.equalsIgnoreCase("e")) {
                RoomBook.emptyRooms(custmer);
                cont();

                // implement the findCustomer(hotel, nm); method
            } else if (action.equalsIgnoreCase("d")) {
                RoomBook.deletcustomer(custmer);
                cont();

                // implement the findCustomer(hotel, nm); method
            } else if (action.equalsIgnoreCase("s")) {
                RoomBook.FileWrite(custmer);
                cont();

                // implement the FileWrite(hotel, date); method
            } else if (action.equalsIgnoreCase("l")) {

                RoomBook.FileRead();
                cont();
                // implement the  FileRead(); method
            } else if (action.equalsIgnoreCase("f")) {
                RoomBook.findCustomer(custmer);
                cont();
                // implement the  FileRead(); method
            } else if (action.equalsIgnoreCase("3")) {
                RoomBook.displayQueue();
                cont();
            } else {
                System.out.println("invalid input. please enter vaild input ");
                cont();

            }
        }
    }

    public static void cont() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Process again Enter 'C' : ");
        System.out.println("End Process Enter 'E' : ");
        String dcsn = sc.next();
        if (dcsn.equalsIgnoreCase("C")) {
            cont = true;
        } else if (dcsn.equalsIgnoreCase("E")) {

            System.out.println("Process terminated");
            System.out.println("Thank you for using hotel management system");
            cont = false;

        } else {
            System.out.println("Enter valid Input(E- end process / C- Continue)");
            cont();
        }
    }
}
