package HeartRate_Calculator;
import javax.swing.JOptionPane;
import java.util.Scanner;

public class HRCalculator {

	public static void main(String[] args) {

	       //Getting all the inputs
	       Scanner cin = new Scanner(System.in);
	       
	       //use a while loop to validate the string name
	       //the condition of the while loop only take letters
	       String firstname = JOptionPane.showInputDialog("Please enter your first name:");
	       while (!firstname.matches("[a-zA-Z]+"))
	       {
	    	   firstname = JOptionPane.showInputDialog("Invalid input!!! Please retype your first name again.");
	       }
	       
	       String lastname = JOptionPane.showInputDialog("Please enter your last name:");;
	       while (!lastname.matches("[a-zA-Z]+"))
	       {
	    	   //System.out.println("Invalid input!!! Please retype again.");
	    	   lastname = JOptionPane.showInputDialog("Invalid input!!! Please retype your last name again.");
	       }
	       
	       String date = JOptionPane.showInputDialog("Please enter the Date of Birth in dd Format:");
	       while (!date.matches("[1-9]|1[0-9]|2[0-9]|3[0-1]") && !date.matches("0[1-9]|1[0-9]|2[0-9]|3[0-1]"))
	    	   //1.either the value is 1 to 9 or 01 to 09
	    	   //2.or the value start with 1 and followed with 0 to 9 (10-19)
	    	   //3.0r the value start with 2 and followed with 0 to 9 (20-29)
	    	   //4.or the value start with 3 and followed with 0 to 1 (30-31)
	       {
	    	   date = JOptionPane.showInputDialog("Invalid input!!! Please re-enter the Date part of your Date of Birth in dd Format:");
	       }
	       
	       String mon = JOptionPane.showInputDialog("Please enter the Month of Birth in MM Format:");
	       while (!mon.matches("[1-9]|1[0-2]") && !mon.matches("0[1-9]|1[0-2]"))
	       {
	    	   mon = JOptionPane.showInputDialog("Invalid input!!! Please re-enter the Month of Birth in MM Format:");
	       }
	       
	       String year = JOptionPane.showInputDialog("Please enter the Year of your Date of Birth in yyyy Format");
	       //while (!year.matches("[0-9]{4}"))
	    	   while (!year.matches("(19|20)[0-9]{2}"))
	       {
	    	   year = JOptionPane.showInputDialog("Invalid input!!! Please re-enter Year of your Date of Birth in yyyy Format");
	       }

	       cin.close();
	      
	       //Creating HeartRates class object and passing values in constructor
	       HeartRates h = new HeartRates(firstname, lastname, date, mon, year);
	      
	       //Calling the function for calculating heart rates
	       double hRates[] = h.calcHeartRate();
	       //Printing all details
	       /*
	       System.out.println("First Name: "+h.getFirstName());
	       System.out.println("Last Name: "+h.getLastName());
	       System.out.println("Date of Birth: "+h.getDob());
	       System.out.println("Age: "+h.calcAge());
	       System.out.println("Maximum heart rate: "+hRates[0]);
	       System.out.println("Target heart rate range");
	       System.out.println("\tMinimum: "+hRates[1]);
	       System.out.println("\tMaximum: "+hRates[2]);
	       */
	       JOptionPane.showMessageDialog(null, "First Name: "+h.getFirstName() +
	       "\nLast Name: "+h.getLastName()+
	       "\nDate of Birth: "+h.getDob()+
	       "\nAge: "+h.calcAge()+
	       "\nMaximum heart rate: "+hRates[0]+
	       "\nTarget heart rate range"+
	       "\nMinimum: "+hRates[1]+
	       "\nMaximum: "+hRates[2]);
		
	}

}
