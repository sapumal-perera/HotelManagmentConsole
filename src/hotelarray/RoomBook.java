/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelarray;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Isuru
 */
public class RoomBook {

    //public static
    public static int count = 0;
    //   public static ArrayList<Customer> cust = new ArrayList<Customer>();
    // public static Customer[] cust= new Customer[10]
    public static Scanner sc = new Scanner(System.in);
    public static Queue<Customer> q = new LinkedList<Customer>();

    public static void roomDetails(Customer[] cust) {

        for (Customer mn : cust) {
            if (mn.getCsId().equals("")) {

                System.out.println("Room number: " + mn.getRoomNo() + " is Empty");

            } else {
                System.out.println(" Room number: " + mn.getRoomNo() + " occupied by Customer name: " + mn.getCsName() + " in Id: " + mn.getCsId());

            }
        }
    }

    public static void initialise(Customer[] cust) {

        int cnt = 1;
        for (int i = 0; i < cust.length; i++) {
            Customer mn = new Customer();
            cust[i] = mn;
            {
                mn.setCsId("");
                mn.setCsName("");
                mn.setRoomNo(cnt);
            }
            cnt++;
        }

    }

    public static void emptyRooms(Customer[] cust) {

        for (Customer mn : cust) {
            if (mn.getCsId().equals("")) {
                System.out.println();
                System.out.println("Room number: " + mn.getRoomNo() + " is Empty");

            }

        }

    }

    public static void addcustomer(Customer[] cust) {
        boolean again = true;
        while (again) {
            Customer newcust = new Customer();

            try {
                System.out.println("Please enter Customer id: ");
                String id = sc.next();
                newcust.setCsId(id);

                System.out.println("Please enter Customer name: ");
                String name = sc.next();
                newcust.setCsName(name);

                System.out.println("Please enter a Room number: ");
                int room = sc.nextInt();
                if (room < 1 || room > 10) {
                    System.out.println("Invalid input. reoom numbers are in 1 - 10 : ");
                } else {
                    newcust.setRoomNo(room);

                    cust[room - 1] = (newcust);
                    //count++;
                    if (count < 8) {
                        insertQueue(newcust);
                    }

                    if (count >= 8) {
                        System.out.println("queue is already full");
                        again = false;
                        removeQueue();

                    }
                }
                System.out.println("do you want process again: ");
                System.out.println("Enter any key to continue/ N to stop booking : ");
                String ag = sc.next();
                if (ag.equalsIgnoreCase("y")) {
                    again = true;
                } else if (ag.equalsIgnoreCase("n")) {
                    again = false;
                } else {
                    System.out.println("Invalid input. please enter valid input ");
                    again = true;
                }
            } catch (Exception ex) {
                System.out.println("Please enter valid data");
            }
        }
    }

    public static void deletcustomer(Customer[] cust) {
        boolean again = true;
        while (again) {
            System.out.println("Please enter a Room number to delet: ");
            int room = sc.nextInt();
            if (room < 1 && room > 10) {
                System.out.println("Invalid input. reoom numbers are in 1 - 10 : ");
            } else {
                for (Customer remove : cust) {

                    if (remove.getRoomNo() == room) {
                        if (remove.getCsId().equals("")) {
                            System.out.println("Room is already empty");
                        } else {
                            System.out.println("Delete Successfully");
                            System.out.println("Room no " + remove.getRoomNo() + " is now empty");
                            remove.setCsName("");
                            remove.setCsId("");
                        }
                    }
                }
            }
            System.out.println("do you want process again: ");
            System.out.println("Enter any to continue/ N to end delete : ");
            String ag = sc.next();
            if (ag.equalsIgnoreCase("y")) {
                again = true;
            } else if (ag.equalsIgnoreCase("n")) {
                again = false;
            } else {
                System.out.println("Invalid input. please enter valid input ");
                again = true;
            }
        }
    }

    public static void FileWrite(Customer[] cust) {

        try (FileWriter f = new FileWriter("D:\\txts\\customer.txt", true)) {
            //data write to file

            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd ");
            Date date = new Date();
            f.write("\t\r\n This record is for " + date);
            f.write("\r\n");
            for (Customer file : cust) {
                if (file.getCsId().isEmpty()) {

                    f.write("\t\r\n Room no " + file.getRoomNo() + " is empty");
                } else {
                    f.write("\t\r\n Room No " + file.getRoomNo() + " Occupied by " + file.getCsName() + " in id " + file.getCsId());
                    f.write("\t\r\n record created on " + date);
                    f.write("\r\n");
                }
            }

            System.out.println("Record created successfully for " + date);

        } catch (Exception e) {
            System.out.println("Error with file writing" + e.getMessage().toString());

        } finally {
            System.out.println("file write process terminated");
        }
    }

    public static void FileRead() throws IOException {
        FileReader file;
        file = new FileReader("D:\\txts\\customer.txt");
        try {
            BufferedReader reader = new BufferedReader(file);

            String line = reader.readLine();
            while (line != null) {

                line = reader.readLine();
                System.out.println(line);

            }
        } catch (FileNotFoundException ex) {
            System.out.println("File not found. please check");
        } finally {
            System.out.println("file read process end");
            file.close();
        }

    }

    public static void findCustomer(Customer[] cust) {
        System.out.println("Enter Customer id to find customer");
        String id = sc.next();
        boolean found = false;
        for (Customer find : cust) {
            if (find.getCsId().equals(id)) {
                System.out.println(" Customer named " + find.getCsName() + " in id " + find.getCsId() + " is in room Number " + find.getRoomNo());
                found = true;
            }

        }
        if (!found) {
            System.out.println("No customer in id " + id);
        }
    }

    public static void insertQueue(Customer queu) {

        q.add(queu);

    }

    public static void displayQueue() {
        try {
            for (int i = 0; i < 4; i++) {
                Customer cs = q.remove();
                System.out.println("Room number : " + cs.getRoomNo() + " occupied by Customer: ");
                System.out.println(" in customer Id: " + cs.getCsId());
                System.out.println("    customer Name: " + cs.getCsName());
            }

        } catch (Exception ex) {
            System.out.println(" check your queue again.");
        } finally {
            System.out.println("displayed items are removed from the queue");
        }
    }

    public static void removeQueue() {

        Customer cs = q.remove();

    }

}
