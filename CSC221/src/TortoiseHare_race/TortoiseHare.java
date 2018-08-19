package TortoiseHare_race;

public class TortoiseHare {

	public static void main(String[] args) {
		//variable declaration
		//clock time set to 0
		int finish=70,tort=1,hare=1,rtime=0;
		System.out.println("The Finishing mark 70 count: ");//each | count 1
	    for(int n=0; n<=70; n++)
	     {
	      System.out.print("|");
	     }
		System.out.println("\nON YOUR MARK, GET SET\nBANG !!!!!\nAND THEY'RE OFF !!!!!\n");
		do
		{
			//call the race of Hare method
			hare=movehare(hare);
			//call the race of tortoise method
			tort=movetort(tort);
			//call the display method
		    position(tort,hare);
		    rtime++;
		}
		while(tort<finish && hare<finish);
		if(tort>hare )
		    System.out.println("TORTOISE WINS!!! YAY!!!\n");
		else if(tort<hare )
		    System.out.println("Hare wins. Yuch. \n");
		else
		    System.out.println("Would you believe IT\'S A TIE!!\n");
			System.out.println("time of race: "+rtime+" simulated seconds\n");
		}
		public static void position(int t,int h)
		{
			int i;
				if(h==t)
				{
					for(i=0;i<h;i++)
					System.out.print(" ");
					System.out.println("OUCH!!!");
					}  
				else if(h<t)
				{
					for(i=0;i<h;i++)
					System.out.print(" ");
					System.out.print("H");
					for(i=0;i<(t-h);i++)
					System.out.print(" ");
					System.out.print("T"); 
					}
				else
				{
					for(i=0;i<t;i++)
					System.out.print(" ");
					System.out.print("T");
					for(i=0;i<(h-t);i++)
					System.out.print(" ");
					System.out.print("H");
					}
					System.out.println();
					}
		public static int movehare(int r ) //method for Hare
		{
			int num;
		num=(int)(1 + Math.random()*10);
		if(num>=1 && num<=2) //Sleep no move
		     r=1;
		else if(num>=3 && num<=4) //Big hop 9 squares right
		      r+=9; 
		else if(num==5) //Big slip 12 squares left
		      r-=12;
		else if(num>=6 && num<=8) //Small hop 1 squares right
		      r++;
		else if(num>=9 && num<=10) //Small slip 2 squares left
		      r-=2;
		if(r< 1 )
		      r=1;
		return r;
		}
		public static int movetort(int t) //method for tortoise
		{
			int num;
		num=(int)(1 + Math.random()*10);
		if(num>=1 && num<=5) //Fast plod 3 squares right
		   t+=3;
		else if(num>=6 && num<=7) //Slip 6 squares left
		   t-= 6;
		else //8,9,10 Slow plod 1 squares right
		    t++;
		if(t<1)
		   t=1;
		return t;
		}
	}