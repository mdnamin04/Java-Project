//This is my main java file

package Library_Database;

//@Override annotation is used when we override a method in sub class.
//The @SuppressWarnings annotation type allows Java programmers to disable compilation warnings for a certain part of a program 
//(type, field, method, parameter, constructor, and local variable).

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Scanner;

import org.apache.commons.collections4.comparators.ComparatorChain;

public class Library {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		ComparatorChain chain = new ComparatorChain();
        Database library = new Database();
        Calendar cal = Calendar.getInstance();
        Date dateInput;

        //sort items by ID (default)
        class Comparison implements Comparator<Item> {
            public int compare(Item i1, Item i2) {
                return i1.getID().compareTo(i2.getID());
            }
        }

        //sort items by their title
        class sortByTitle implements Comparator<Item> {
            public int compare(Item i1, Item i2) {
                return i1.getTitle().compareTo(i2.getTitle());
            }
        }
        //sort items by the date added
        class sortByAddedOn implements Comparator<Item>{
            public int compare(Item i1, Item i2) {
                return i1.getDate().compareTo(i2.getDate());
            }
        }

        //sort by director if it's a video, by artist is it's a CD, and by author if it's a Textbook
        class sortByDirector implements Comparator <Item>{
            @Override
            public int compare(Item i1, Item i2) {
                if(i1.getClass().equals(Textbook.class))
                    return i1.getAuthor().compareTo(i2.getAuthor());
                else if (i1.getClass().equals(CD.class))
                    return i1.getArtist().compareTo(i2.getArtist());
                else
                    return i1.getDirector().compareTo(i2.getDirector());
            }
        }

        /**
         * Test Code provided
         */

        // adding database entries
        cal.set(1890, Calendar.AUGUST, 10);
        Date date = (Date) cal.getTime();
        library.addItem(new Textbook("TB15", "TextX", date, "John Doe"));

        cal.set(1954, Calendar.JANUARY, 18);
        date = (Date) cal.getTime();
        library.addItem(new Video("V09", "VideoB", date, 70000, "J. Smith"));

        cal.set(2000, Calendar.FEBRUARY, 29);
        date = (Date) cal.getTime();
        library.addItem(new Textbook("TB01", "TextY", date, "John Doe"));

        cal.set(2000, Calendar.FEBRUARY, 29);
        date = (Date) cal.getTime();
        library.addItem(new CD("CD07", "CD1", date, 1000, "B.D."));

        cal.set(1990, Calendar.APRIL, 30);
        date = (Date) cal.getTime();
        library.addItem(new CD("CD10", "CD1", date, 800, "X.Y."));

        cal.set(2000, Calendar.FEBRUARY, 29);
        date = (Date) cal.getTime();
        library.addItem(new CD("CD05", "CD1", date, 1000, "B.C."));

        cal.set(1890, Calendar.JULY, 2);
        date = (Date) cal.getTime();
        library.addItem(new Video("V12", "VideoA", date, 7000, "Joe Smith"));


        System.out.println("***** Welcome to your library Database! *****");
        // print unsorted database
        System.out.println("\n----- DATABASE BEFORE SORTING: -----\n");
        library.list();
        
        //sort and print sorted database (by id)
        Comparison Default = new Comparison();
        Collections.sort(library.items, Default);
        System.out.println("\n----- DATABASE AFTER SORTING BY ID (default): -----\n");
        library.list();
        
        // sort by other fields
        System.out.println("\n----- DATABASE AFTER SORTING BY OTHER FIELDS: -----");
        System.out.println("------------ (title, addedOn, director/artist/author) -----------\n");
        chain.addComparator(new sortByTitle());
        chain.addComparator(new sortByAddedOn());
        chain.addComparator(new sortByDirector());
        Collections.sort(library.items, chain);
        library.list();

        /**
         * Code to get user input
         */        
        Scanner scan = new Scanner (System.in);
        Scanner scanAdd = new Scanner (System.in);
        boolean flag = false;

        while(!flag){

            System.out.print("\n1. Add item\n"
                    + "2. List current items\n"
                    + "3. Remove an item\n"
                    + "4. Remove all items\n"
                    + "Enter a selection(0 to quit): ");

            int answer = scan.nextInt();

            if(answer < 0 || answer > 5){
                System.out.println("Wrong input");
                continue;
            }
            else if (answer == 0){
                System.out.print("Goodbye");
                flag = true;
            }
            else if (answer == 1){
                scanAdd = new Scanner(System.in);
                System.out.print("\nWould you like to add\n"
                        + "1. Textbook\n"
                        + "2. CD\n"
                        + "3. Video\n"
                        + "Enter a selection(0 to return): ");
                int addAnswer = scan.nextInt();
                switch (addAnswer){
                    case 0:
                        continue;
                    case 1:
                        System.out.print("Enter id: ");
                        String id = scanAdd.nextLine();
                        System.out.print("Enter title: ");
                        String title = scanAdd.nextLine();
                        System.out.print("Enter author: ");
                        String author = scanAdd.nextLine();
                        System.out.print("Enter date of entry (dd-MM-yyyy): ");
                        String addedOn = scanAdd.nextLine();
                        try{
                            DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
                            formatter.setLenient(false);
                            dateInput = formatter.parse(addedOn);
                            cal.setTime(date);
                        }
                        catch (ParseException e){
                            System.out.println("Wrong date");
                            continue;
                        }
                        library.addItem(new Textbook(id,title,dateInput,author));
                        System.out.println("Item added");
                        continue;
                    case 2:
                        System.out.println("Enter id: ");
                        id = scanAdd.nextLine();
                        System.out.println("Enter title: ");
                        title = scanAdd.nextLine();
                        System.out.println("Enter artist: ");
                        String artist = scanAdd.nextLine();
                        System.out.println("Enter date of entry (dd-MM-yyyy): ");
                        addedOn = scanAdd.nextLine();
                        System.out.println("Enter playing time: ");
                        int playingTime = scanAdd.nextInt();
                        try{
                            DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
                            formatter.setLenient(false);
                            dateInput = formatter.parse(addedOn);
                            cal.setTime(date);
                        }
                        catch (ParseException e){
                            System.out.println("Wrong date");
                            continue;
                        }
                        library.addItem(new CD(id,title,dateInput,playingTime,artist));
                        System.out.println("Item added");
                        continue;
                    case 3:
                        System.out.println("Enter id: ");
                        id = scanAdd.nextLine();
                        System.out.println("Enter title: ");
                        title = scanAdd.nextLine();
                        System.out.println("Enter director: ");
                        String director = scanAdd.nextLine();
                        System.out.println("Enter date of entry (dd-MM-yyyy): ");
                        addedOn = scanAdd.nextLine();
                        System.out.println("Enter playing time: ");
                        playingTime = scanAdd.nextInt();
                        try{
                            DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
                            formatter.setLenient(false);
                            dateInput = formatter.parse(addedOn);
                            cal.setTime(date);
                        }
                        catch (ParseException e){
                            System.out.println("Wrong date");
                            continue;
                        }
                        library.addItem(new CD(id,title,dateInput,playingTime,director));
                        System.out.println("Item added");
                        continue;
                    default:
                        System.out.println("Wrong input");
                        continue;
                }
            }
            else if(answer == 2){
                System.out.println("\nHow would you like to list your library items?\n"
                        + "1. Unsorted\n"
                        + "2. Sorted by ID(default)\n"
                        + "3. Sorted by title, addedOn, then by director/artist/author");
                System.out.print("Enter a selection(0 to return): ");
                int listAnswer = scan.nextInt();
                switch(listAnswer){
                    case 0:
                        continue;
                    case 1:
                        System.out.println("----- DATABASE BEFORE SORTING: -----\n");
                        library.list();
                        continue;
                    case 2:
                        Comparison DefaultInput = new Comparison();
                        Collections.sort(library.items, DefaultInput);
                        if(library.items.isEmpty()){
                            System.out.println("YOU HAVE NO ITEMS IN LIBRARY");
                            continue;
                        }
                        else{
                            System.out.println("\n----- DATABASE AFTER SORTING BY ID (default): -----\n");
                            library.list();
                            continue;
                        }
                    case 3:
                        //chain.addComparator(new sortByTitle());
                        //chain.addComparator(new sortByAddedOn());
                        //chain.addComparator(new sortByDirector());
                        Collections.sort(library.items, chain);
                        if(library.items.isEmpty()){
                            System.out.println("YOU HAVE NO ITEMS IN LIBRARY");
                            continue;
                        }
                        else{
                            System.out.println("\n----- DATABASE AFTER SORTING BY OTHER FIELDS: -----");
                            System.out.println("------------ (title, addedOn, director/artist/author) -----------\n");
                            library.list();
                            continue;
                        }
                    default:
                        System.out.println("Wrong input");
                        continue;
                }
            }
            else if(answer == 3){
                System.out.println("Which item do you want to remove?");
                System.out.print("Enter index: ");
                int index = scan.nextInt();
                if(index > library.items.size() || index < 0){
                    System.out.println("Wrong input");
                    continue;
                }
                else {
                    library.items.remove(index);
                    System.out.println("Item removed");
                    continue;
                }
            }
            else if(answer == 4){
                library.clearDatabase();
                System.out.println("Database was cleared of all items");
                continue;
            }
            scanAdd.close();
        }
        scan.close();
    }
	
}