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
import java.util.Scanner;

/**
 *
 * @author Isuru
 */
public class RoomDetails {

    public static boolean cont = true;

   public RoomDetails() throws IOException {
//declare hotel array
        String roomName;
        int roomNum = 0;
        int roomNm = 0;
        String[] hotel = new String[10];
        boolean correctNum = true;
//main handeling menu
        Scanner input = new Scanner(System.in);
        System.out.println("   Welcome to Hotel managment System     ");
        System.out.println("_________________________________________");
        System.out.println();
        // initialize the array
        initialise(hotel);
// start menu
        while (cont) {
            System.out.println("Enter V to view all room details                :");
            System.out.println("Enter E to view available rooms                 :");
            System.out.println("Enter A to add customer to room                 :");
            System.out.println("Enter D to delete customer from room            :");
            System.out.println("Enter F to find room number from customer name  :");
            System.out.println("Enter S to insert details to the file           :");
            System.out.println("Enter L to read the data file                   :");
            System.out.println("Enter O to view the customer names alphabaticaly:");
            String action = input.next();

            // implement the  roomDetails(hotel); method
            if (action.equalsIgnoreCase("v")) {
                roomDetails(hotel);
                cont();

                // implement the emptyRooms(hotel); method
            } else if (action.equalsIgnoreCase("e")) {
                emptyRooms(hotel);
                cont();

                // implement the deletcustomer(hotel); method
            } else if (action.equalsIgnoreCase("d")) {
                deletcustomer(hotel);
                cont();

                // implement the findCustomer(hotel, nm); method
            } else if (action.equalsIgnoreCase("f")) {
                System.out.println("Enter customer Name to find Room No");
                String nm = input.next();
                findCustomer(hotel, nm);
                cont();

                // implement the FileWrite(hotel, date); method
            } else if (action.equalsIgnoreCase("s")) {
                System.out.println("please enter date.month to create record");
                double date = input.nextDouble();
                roomDetails(hotel);
                System.out.println("above details are written to file on" + date);
                FileWrite(hotel, date);
                cont();
                // implement the  FileRead(); method
            } else if (action.equalsIgnoreCase("l")) {
                FileRead();
                cont();
                // implement the  SortName(hotel);method
            } else if (action.equalsIgnoreCase("o")) {
                SortName(hotel);
                cont();
                // add customer to room process
            } else if (action.equalsIgnoreCase("a")) {
                boolean rm = true;

                while (roomNm < 10 && rm) {
                    // display empty rooms before add customers
                    for (int x = 0; x < 10; x++) {
                        if (hotel[x].equals("e")) {
                            System.out.println("room " + x + " is empty");
                        }
                    }
                    //prompt for room no and customer name
                    while (rm) {
                        System.out.println("Enter room number(0-9):  or 99 to end room booking: ");
                        roomNum = input.nextInt();
                        if (roomNum == 99) {
                            System.out.println("Room booking process terminated");

                            rm = false;

                        } else if (roomNum > 0 && roomNum < 10) {
                            System.out.println("Enter customer Name for room " + roomNum + ":");
                            roomName = input.next();
                            hotel[roomNum] = roomName;
                            System.out.println("room Number " + roomNum + " occupied by " + roomName);
                            roomNm++;
                        } else {
                            System.out.println("invalid input");
                            cont();
                        }

                    }
                }
                cont();
            } else {
                System.out.println("Invaid Input");
                cont();

            }
        }
    }
//Method for display all room details

    public static void roomDetails(String rm[]) {
        for (int x = 0; x < 10; x++) {
            if (rm[x].equalsIgnoreCase("e")) {
                rm[x] = "none";
            }
            System.out.println("room" + x + " occupied by " + rm[x]);
        }
    }
//method for initialize the array
    //run only at start.  make rooms empty

    public static void initialise(String hotelRef[]) {

        for (int x = 0; x < 10; x++) {
            hotelRef[x] = "none";
        }
        System.out.println("initialized Hotell Rooms");
    }
//method for display empty rooms

    public static void emptyRooms(String emp[]) {
        System.out.println("available rooms:  ");

        for (int x = 0; x < 10; x++) {
            if (emp[x].equalsIgnoreCase("none")) {
                System.out.println("room " + x + " is empty");
            }
        }
    }
//method for delete customers from room

    public static void deletcustomer(String dlt[]) {
        System.out.println("Enter room No for delete occupied customer");
        Scanner input = new Scanner(System.in);
        int a = input.nextInt();

        for (int i = 0; i < dlt.length; i++) {
            if (i == a) {
                dlt[i] = "e";
                System.out.println("remove customer successfully");
                break;
            }

        }

    }
//method for find room number by using customer name

    public static void findCustomer(String fc[], String name) {
        boolean found = false;

        for (int i = 0; i < fc.length; i++) {
            if (fc[i].equalsIgnoreCase(name)) {
                System.out.println("customer named " + name + " is in room number " + i);
                found = true;
            }

        }
        if (!found) {
            System.out.println("No customer with name " + name);
        }
    }
// method for insert data to text file with date

    public static void FileWrite(String[] arr, double date) {

        try (FileWriter f = new FileWriter("D:\\txts\\customer.txt", true)) {
            //data write to file
            for (int i = 0; i < arr.length; i++) {

                f.write("\t\r\n" + "Room No " + i + " Occupied by " + arr[i] + " on " + date);

            }

            System.out.println("Record created");

        } catch (Exception e) {
            System.out.println("Error with file writing" + e.getMessage().toString());

        }
    }
// method for read data from customer details file and display

    public static void FileRead() throws FileNotFoundException, IOException {
        FileReader file = new FileReader("D:\\txts\\customer.txt");
        BufferedReader reader = new BufferedReader(file);

        String line = reader.readLine();
        while (line != null) {

            line = reader.readLine();
            System.out.println(line);

        }

    }
//methos for sort customers by customer name

    public static void SortName(String[] arr) {

        boolean flag = true;
        String temp;
        while (flag) {
            flag = false;
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr.length - 1; j++) {
                    String a = arr[j];
                    String b = arr[j + 1];

                    int result = a.compareTo(b);

                    if (result < 0) {

                        temp = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = temp;
                        flag = true;
                    }

                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);

        }

    }
//method for controle the programe startin and ending

    public static void cont() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Process again Enter 'C' : ");
        System.out.println("End Process Enter 'E' : ");
        String dcsn = sc.next();
        if (dcsn.equalsIgnoreCase("C")) {
            cont = true;
        } else if (dcsn.equalsIgnoreCase("E")) {

            System.out.println("Process terminated");
            cont = false;

        } else {
            System.out.println("Enter valid Input(E- end process / C- Continue)");
            cont();
        }
    }

}
