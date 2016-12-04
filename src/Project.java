/* CSCI1100 - The Great Math Test By Team:  Cult of Cats
 * Members: Isaac Meuse B00738288, Justin Sedge B00737890.
   December 6th, 2016
 
   Our project is a math program designed for 1st-4th graders.
   given the options to do additions questions and subtraction questions.
   each grade has a different range of numbers that can be radnomly chosen for their questions.
   4th graders have the options to do multiplication and division from numbers ranging 0-10
   an array keeps track of the top 5 high scores, and the names of those users  */
import java.util.Scanner;
import java.util.Random;

public class Project {

	public static void main(String[] args) {
		//new scanner object
		Scanner kb = new Scanner(System.in);
		//boolean for exiting program
		boolean programEnd = false;
		//high score and name arrays
		int[] highScore = new int[6];
		String[] nameArray = new String[6];
		//while loop to keep application going until user exits
		while (programEnd == false){
      
      
			//get input for name
			System.out.print("Hello, please type your name: ");
			String name = kb.nextLine();
			//places newest name in last array position
			nameArray[5] = name;
   		
			//initialize variables
			int range=0,level=0;
   		
			while(range<1){
				System.out.print("Hi " + name + " please type in your grade level(1-4): ");
				level = kb.nextInt();
   		
				if(level==1){//first grade
					range = 15;
				}else if(level==2){//second grade
					range =25;
				}else if(level==3){//third grade
					range = 50;
				}else if(level==4){//fourth grade
					range =100;
				}else{//catch for if user input a bad input
					System.out.println("Error, please input a number between 1 and 4");
				}
			}
   		
			//run scanner again so it works again
			kb.nextLine();
			//init more variables
			boolean x = false;
			int score = 0;
   		
			//keeps trying to get valid input
			while(!x){
				System.out.print("Would you like to try addition or subtraction? Please type + or -: ");
				if(level==4){//fourth graders can try multiplication, does not use same range as above
					System.out.println("\nor as a fourth grader, you can try multiplication by typing x: ");
					System.out.print("Or division by typing /: ");
				}
   			
				x=true;
				String input = kb.nextLine();
   			
				if(input.contains("+")){
					//do addition thing
					score = addition(range);
				}else if(input.contains("-")){
					//do subtraction thing
					score = subtraction(range);
				}else if(input.contains("x")&&level==4){
					//do multiplication thing
					score = multiplication();
				}else if(input.contains("/")){
					score = division();	
   				
				}else{
					//informs user of bad input
					System.out.println("Error, please give the proper input");
					x=false;
				}
			}
			//tells the user what their score was
			System.out.println("Congrats " + name + ", your score was " + score);
			//places newest score in last array position
			highScore[5] = score;
			//calls arraySort to sort highscore and move name array acordingly 
			arraySort(highScore, nameArray);
			//prints out top 5 scores and names
			System.out.println("Top 5 scores (Must be a score higher than 0)\n");
			System.out.println("Name:\t\tScore:");
			for(int i = 0; i < 5; i++){
				// does not print name if no entery has been put into array yet
				if (nameArray[i] != null){
					System.out.println(nameArray[i] + "\t\t" + highScore[i]);
				}
			} 
            
			//asks user if they wish to keep playing
			System.out.print("\nType 'yes' if you wish to continue, or 'no' if you would like to exit: ");
			String yesOrNo = kb.nextLine();
			yesOrNo = yesOrNo.toLowerCase();
			if (yesOrNo.equals("no")){
				programEnd = true;
			}
         
         
		}
		
	}
	public static int addition(int max){
	      //random variable r, Scanner variable input
	      Random r = new Random();
	      Scanner input = new Scanner(System.in);
	      
	      /* i = lives counter, questionCounter = question number of current question
	      rightCounter = number of question gotten correct by user                 */
	      int i = 3, questionCounter = 1, rightCounter = 0;
	      
	      //loops until 3 questions were gotten incorrect
	      while (i >0){
	         
	         System.out.println("Question #" + questionCounter);
	         
	         //puts random ints into 2 different variables
	         int num1 = r.nextInt(max+1);
	         int num2 = r.nextInt(max+1);
	         
	         //prints questions using random variables
	         System.out.println(num1 + "+" + num2 + " = ?");
	         System.out.print("? = ");
	         
	         
	         //gets answer from user 
	         int answer = input.nextInt();
	         
	         //checks if answer is wrong, if wrong reduces lives (i) and continues to next question
	         if (answer != (num1 + num2)){
	            i--;
	            questionCounter++;
	            System.out.println("Incorrect! You have " + i + " more lives!\n");
	            
	          //if right prints out correct line, adds to rightCounter and moves to next question
	         }else{
	            questionCounter++;
	            System.out.println("Correct!\n");
	            rightCounter++;
	         }
	         
	      }
	      return rightCounter;
	}
	//method for subtraction math problems
	public static int subtraction(int max){
		//random variale r, Scanner variable input
	    Random r = new Random();
	    Scanner input = new Scanner(System.in);
	      
	    /* i = lives counter, questionCounter = question number of current question
	    rightCounter = number of question gotten correct by user                 */
	    int i = 3, questionCounter = 1, rightCounter = 0;
	      
	    //loops untill 3 questions were gotten incorrect
	    while (i >0){
	         
	       System.out.println("Question #" + questionCounter);
	         
	       //puts random ints into 2 different variables
	       int[] order = checkOrder(r.nextInt(max+1),r.nextInt(max+1));
	       int num1 = order[0];
	       int num2 = order[1];
	               	         
	       //prints questions using random variables
	       System.out.println(num1 + "-" + num2 + " = ?");
	       System.out.print("? = ");
	         
	         
	       //gets answer from user 
	       int answer = input.nextInt();
	         
	       //checks if answer is wrong, if wrong reuces lives (i) and continues to next question
	       if (answer != (num1 - num2)){
	          i--;
	          questionCounter++;
	          System.out.println("Incorrect! You have " + i + " more lives!\n");
	          
	         //if right prints out correct line, adds to rightCounter and moves to next question
	       }else{
	    	   questionCounter++;
	           System.out.println("Correct!\n");
	           rightCounter++;
	       }
	    }
	       
	    return rightCounter;   
	            
	}

	public static int multiplication(){
		   //make new random and scanner object
		   Random rng = new Random();
		   Scanner kb = new Scanner(System.in);
		   
		   //initialize variables
		   int i = 3, score = 0, c = 0;
		   
		   while(i>0){
			   //get random values within a range
			   int x = rng.nextInt(11), y = rng.nextInt(11);
			   
			   //find their product
			   int product = x*y;
			   
			   //outputs questions
			   System.out.println(x + " x " + y + " = ?");
			   System.out.print("? = ");
			   
			   //gets user input for answer
			   int response = kb.nextInt();
			   
			   //checks if answer was right, increases score if yes, decrease life if no
			   if(response==product){
				   System.out.println("Correct!\n");
				   score++;
			   }else{
				   i--;
				   System.out.println("Incorrect! You have " + i + " tries remaining\n");
			   }
			   c++;
		   }
		   
		   return score;
	   }
	public static int[] checkOrder(int x, int y){
		//make array to hold proper order
		int[] order = new int[2];
		   
		//checks which int is higher and places it first
		if(x>y){
		   order[0]=x;
		   order[1]=y;
	   }else{
		   order[0]=y;
		   order[1]=x;
	   }		   
		   
	   return order;		   
	}
	public static int division(){
		//make new random and scanner object
	    Random rng = new Random();
	    Scanner kb = new Scanner(System.in);
		   
	   //initialize variables
	   int i = 3, score = 0, c = 0;
		   
	   //gives user example of input the program wants (it may or may not crash if bad input is given)
	   System.out.println("For these questions please give your answer as (number)R(remainder)\nExample:\n");
	   int[] example = checkOrder(rng.nextInt(10)+1,rng.nextInt(10)+1);
	   int a = example[0], b = example[1];
		   
	   //get answer and remainder for example
	   int e = a/b;
	   int d = a%b;
		   
	   //output example question and answer
	   System.out.println(a + " ÷ " + b + " = ?");
	   System.out.println("? = " + e + "R" + d+"\n");
		   
	   while(i>0){
		   //get random values within a range
		   int[] ordered = checkOrder(rng.nextInt(10)+1,rng.nextInt(10)+1);
		   int x=ordered[0],y=ordered[1];			 			   
		   		       
		   //find answer and remainder
	       int quotient = x/y;
		   int remainder = x%y;
		   
		   //outputs questions
		   System.out.println(x + " ÷ " + y + " = ?");
		   System.out.print("? = ");
		   
		   //converts input to upper case
		   String input = kb.nextLine().toUpperCase();
		   
		   //checks to see if user gave an answer with a remainder
		   if(input.contains("R")){
			   //splits string into remainder and whole number
			   int userQ = Integer.parseInt(input.substring(0, input.indexOf('R')));
			   int userR = Integer.parseInt(input.substring(input.indexOf('R')+1));
			   
			   //checks if right answer
			   if(userQ==quotient&&userR==remainder){
				   System.out.println("Correct!\n");
				   score++;
			   }else{
				   i--;
				   System.out.println("Incorrect! You have " + i + " tries remaining\n");
			   }
			   
		   }else if(remainder==0){//if the user gave no remainder and there isnt one
			   //converts string to integer
			   int answer = Integer.parseInt(input);
			   
			   //compares against proper answer
			   if(answer==quotient){
				   System.out.println("Correct!\n");
				   score++;
			   }else{
				   i--;
				   System.out.println("Incorrect! You have " + i + " tries remaining\n");
			   }
		   }else{//if the user gave no remainder and should have
			   i--;
			   System.out.println("Incorrect! Please use (number)R(remainder) when responding");
			   System.out.println("You have " + i+ " tries remaining\n");
		   }
		   c++;
	   }
   
	   //return score
	   return score;
	   }
	
      //method to sort high score array and name Array
	public static void arraySort(int[] highScore, String[] nameArray){
                  
		//for loop to sort array from highest score to lowest
        for(int x = 1; x < 6; x++){
         
        //holds a numberr and string from arrays
        int pivotNumber = highScore[x];
        String pivotString = nameArray[x];
        //creats index variable that starts at one less than index for first loop
        int i = (x-1);
        
        //moves array using for loop, if a score needs to be moved to a higher location
        for(   ; i >= 0 && highScore[i] < pivotNumber; i--){
        	highScore[i+1] = highScore[i];
            nameArray[i+1] = nameArray[i];
        }
        //re adds pivot number to array
        highScore[i+1] = pivotNumber;
        nameArray[i+1] = pivotString;
        }
	}
      
}
