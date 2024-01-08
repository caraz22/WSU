import java.util.Scanner;

class Conditionals {

  public static void main(String[] args) {

	Scanner in = new Scanner(System.in);
/*
    System.out.print("What grade did you get? ");
    char grade = in.next().charAt(0);
    if (grade == 'A') {
      System.out.println("Excellent!");
    } else if (grade == 'B' || grade == 'C') {
      System.out.println("Good job!");
    } else if (grade == 'D') {
      System.out.println("Whew!");
    } else if (grade == 'F') {
      System.out.println("Uh oh...");
    } else {
      System.out.println("You're not big on following directions are you?");
    }
*/
/*

    //.toUpperCase() used to make any letter put in to be upper case
    System.out.print("What grade did you get? ");
    char grade = in.next().charAt(0);
    String msg = "";

    switch (grade) {
      case 'A':
          msg = "Excellent";
          break;
      case 'B':
      case 'C':
          msg = "Good job!";
          break;
      case 'D':
          msg = "Whew!";
          break;
      case 'F':
          msg = "Uh oh...";
          break;
      default:
          msg = "You're not big on following directions, are you?";
    }
//^switch statement for if/else below
//if the if/else statement has two variables then you can't rewrite it as one switch statement
//switch statements only count for equality, not < or >

*/
/*
    int age = 19;

    String temp;
    if (age < 21) {
      temp = "not legal to drink";
    } else {
      temp = "ok to drink";
    }
//^same as: String temp = age < 21 ? "not legal to drink" : "ok to drink";


String s = "hello";

if (Math.random() < 1) {
  s = null;
}
//if (s.length() > 0 && 5 < 4){
if (5 < 4 && s.length() > 0) {
  System.out.println("yay!");
}
//null is the absence of anything
//short-circuit
*/
	/*
	double rand = Math.random();
	  
	int score = 0;

	if (rand < 0.5) {
		score = 1;
	} else {
		score = -1;
	}
	

	int score = rand < 0.5 ? 1 : -1; // ternary operator

	System.out.println("The number was " + rand);
	System.out.println("Your score is " + score);


	//Boolean is only ever true or false
	
	boolean b = 5 < 10 && "hello".length() > 3;
	System.out.println("b = " + b);

	// if (b == true) { // this works but is weird
	if (b) {
		System.out.println("b was true");
	} else {
		System.out.println("b was false");
	}
	*/
	
	/*
 	// if you want to convert a string that contains a number
 	// into an int, you can do this:
	String s = "7";
	int intValueOfS = Integer.parseInt(s);
	System.out.println("It is " + intValueOfS);
	*/

	  /*
	String s = new String("cherry");
	String t = new String("Grapefruit");

	if (s.compareToIgnoreCase(t) < 0) {
		System.out.println(s + " comes before " + t);
	} else if (s.compareTo(t) == 0) {
		System.out.println(s + " is the same as " + t);
	} else {
		System.out.println(s + " comes after " + t);
	}
	*/

	//uppercase comes before alphabet order

	//can't compare Strings with ==, use .equals()

	  /*
	String s = new String("HELLO");
	String t = new String("Hello");

	if (s.equalsIgnoreCase(t)) {
		System.out.println(s + " equals " + t);
	} else {
		System.out.println(s + " does not equal " + t);
	}
	*/
	
	// bad and wrong -- can't compare Strings with ==
	/*
	if (s == t) {
		System.out.println(s + " equals " + t);
	} else {
		System.out.println(s + " does not equal " + t);
	}
	*/
	
	//logical operators
	// and &&
	// or ||
	// not !

	/*
	Scanner in = new Scanner(System.in);

    // prompt the user to enter a number between 5 and 17
	System.out.print("Enter a number between 5 and 17: ");
	int answer = in.nextInt();

    // if they do that, say thank you
    // otherwise say "really??"
	if (answer >= 5 && answer <= 17) {
		System.out.println("Thank you!");
	} else {
		System.out.println("Really??");
	}

    // second part: ask the user for the temperature
	System.out.print("What is the temperature? ");
	int temp = in.nextInt();

    // if it is less than 50, say it is cold
    // if it is between 50 and 80, inclusive, say it is nice
    // if it is more than 80, say it is hot
	if (temp < 50) {
		System.out.println("It is cold.");
	} else if (temp <= 80) {
		System.out.println("It is nice.");
	} else {
		System.out.println("It is hot.");
	}
	*/

	/*
    // roll a die (i.e. generate a random int between 1 and 6, inclusive)
		int randNum = (int) (Math.random() * 6) + 1;

		System.out.println("You rolled a " + randNum);

    // student-suggested rules
    // if you roll a 1 or 5 you win
    // if you roll a 2, 3, 4 or 6 you lose
    //if (randNum == 1 || randNum == 3 || randNum == 5) {
    if (randNum % 2 == 1 && randNum != 3) {
		  System.out.println("You win!");
    } else {
      System.out.println("You lose :(");
    }
	*/
/*
    // new new rules
    // if you roll a 1, 3 or 5 you win
    // if you roll a 2, 4 or 6 you lose
    //if (randNum == 1 || randNum == 3 || randNum == 5) {
    if (randNum % 2 == 1) {
		  System.out.println("You win!");
    } else {
      System.out.println("You lose :(");
    }
    */

/*
    // new rules:
    // 5 or 6: get one point
    // 3 or 4: get nothing
    // 1 or 2: lose one point
		if (randNum > 4) {
		  System.out.println("You get one point!");
    } else if (randNum > 2) {
      System.out.println("You broke even.");
		} else {
		  System.out.println("You lose one point :(");
		}
    */
		in.close();
  }
}