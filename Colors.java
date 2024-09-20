package BitBlitz;

public class Colors 
{
		//RESET TEXT COLOR TO BLACK
		 public static final String RESET = "\u001B[0m"; 
		 //TEXT COLORS
		 public static final String YELLOW = "\u001B[33m"; 
		 public static final String RED = "\u001B[31m"; 
		 public static final String GREEN = "\u001B[32m"; 
		 public static final String BLUE = "\u001B[34m"; 
		 public static final String PURPLE = "\u001B[35m"; 
		 public static final String CYAN = "\u001B[36m"; 
		 public static final String WHITE = "\u001B[37m";
		 
		 public static void main(String[] args) 
		 { 
		     System.out.println(YELLOW  + "This text is yellow"); 
		     System.out.println(RED  + "This text is red"); 
		     System.out.println(GREEN  + "This text is green"); 
		     System.out.println(BLUE  + "This text is blue"); 
		     System.out.println(PURPLE  + "This text is purple"); 
		     System.out.println(CYAN  + "This text is cyan"); 
		     //System.out.println(ANSI_WHITE  + "This text is white" + ANSI_RESET); 
		 } 
}
