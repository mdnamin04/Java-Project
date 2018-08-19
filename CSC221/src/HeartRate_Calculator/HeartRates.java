package HeartRate_Calculator;

import java.util.Calendar;

public class HeartRates {

	   private String firstName;
	   private String lastName;
	   private String dob;
	  
	   public HeartRates(String firstName, String lastName, String d, String m, String y) {

	       this.firstName = firstName;
	       this.lastName = lastName;
	       this.dob = ""+d+"/"+m+"/"+y;
	   }

	   public String getFirstName() {
	       return firstName;
	   }

	   public void setFirstName(String firstName) {
	       this.firstName = firstName;
	   }

	   public String getLastName() {
	       return lastName;
	   }

	   public void setLastName(String lastName) {
	       this.lastName = lastName;
	   }

	   public String getDob() {
	       return dob;
	   }

	   public void setDob(String dob) {
	       this.dob = dob;
	   }
	  
	   public int calcAge(){
	      
	       String str[] = dob.split("/");
	       
	       //declaring date of birth an array to get the correct index position 0=day, 1=month, 2=year
		   /*String str[] = dob.split("/");
		   int day = Integer.parseInt(str[0]);
		   int month = Integer.parseInt(str[1]);
		   int year = Integer.parseInt(str[2]);
		   */
	       
	       int birthyear = Integer.parseInt(str[2]); 
	       //the parseInt method to convert string to integer
	       Calendar now = Calendar.getInstance();
	       int curryear = now.get(Calendar.YEAR);      
	       int age = curryear - birthyear;
	       return age;
	   }
	  
	   public double[] calcHeartRate(){
	      
	       int age = calcAge();
	       int max = 220 - age;
	       //int tarMin = (int)(.5 * max);
	       double tarMin = 0.5 * max;
	       //int tarMax = (int) (.85 * max);
	       double tarMax = 0.85 * max;
	      
	       return new double[] {max, tarMin, tarMax};
	   }
	  
	}
