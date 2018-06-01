/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelarray;

import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 *
 * @author Isuru
 */
public class FileWrite {

   
       public static void main(String[] args) throws IOException {
//        
//    
//   String roomName;
//        int roomNum = 0;
//        int roomNm = 0;
//        String[] hotel = new String[10];
//        boolean correctNum = true;
////main handeling menu
//        Scanner input = new Scanner(System.in);
//        System.out.println("   Welcome to Hotel managment System     ");
//        System.out.println("_________________________________________");
//        System.out.println();
//        // initialize the array
//         RoomDetails.initialise(hotel);
//// start menu
//        while ( RoomDetails.cont) {
//            System.out.println("Enter V to view all room details                :");
//            System.out.println("Enter E to view available rooms                 :");
//            System.out.println("Enter A to add customer to room                 :");
//            System.out.println("Enter D to delete customer from room            :");
//            System.out.println("Enter F to find room number from customer name  :");
//            System.out.println("Enter S to insert details to the file           :");
//            System.out.println("Enter L to read the data file                   :");
//            System.out.println("Enter O to view the customer names alphabaticaly:");
//            String action = input.next();
//
//            // implement the  roomDetails(hotel); method
//            if (action.equalsIgnoreCase("v")) {
//               RoomDetails.roomDetails(hotel);
//                 RoomDetails.cont();
//
//                // implement the emptyRooms(hotel); method
//            } else if (action.equalsIgnoreCase("e")) {
//                 RoomDetails.emptyRooms(hotel);
//                 RoomDetails.cont();
//
//                // implement the deletcustomer(hotel); method
//            } else if (action.equalsIgnoreCase("d")) {
//                 RoomDetails.deletcustomer(hotel);
//                 RoomDetails.cont();
//
//                // implement the findCustomer(hotel, nm); method
//            } else if (action.equalsIgnoreCase("f")) {
//                System.out.println("Enter customer Name to find Room No");
//                String nm = input.next();
//                 RoomDetails.findCustomer(hotel, nm);
//                 RoomDetails.cont();
//
//                // implement the FileWrite(hotel, date); method
//            } else if (action.equalsIgnoreCase("s")) {
//                System.out.println("please enter date.month to create record");
//                double date = input.nextDouble();
//                 RoomDetails.roomDetails(hotel);
//                System.out.println("above details are written to file on" + date);
//                 RoomDetails.FileWrite(hotel, date);
//                 RoomDetails.cont();
//                // implement the  FileRead(); method
//            } else if (action.equalsIgnoreCase("l")) {
//                 RoomDetails.FileRead();
//                 RoomDetails.cont();
//                // implement the  SortName(hotel);method
//            } else if (action.equalsIgnoreCase("o")) {
//                 RoomDetails.SortName(hotel);
//                 RoomDetails.cont(); 
//            }
//}
     

    
        // create an array list with list interface
//       int room[]= new int[10];
//       Customer sam= new Customer();
//       sam.setRoomNo(10);
//       sam.setCsName("sam");
//       
//        System.out.println(sam.getCsName());
        Queue<Customer> q = new LinkedList<Customer>();
        Customer cs = new Customer();
        q.add(cs);
        cs.setCsId("23253");
        cs.setCsName("toby");
        cs.setRoomNo(2);
        Customer sam= q.remove();
        System.out.println(sam.getCsId());
        System.out.println(sam.getCsName());
        System.out.println(sam.getRoomNo());      
           
       }    }