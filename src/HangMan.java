import java.util.Random;
import java.util.Scanner;

public class HangMan{

    // Method to create a random word
    public static String createWord() {
        Random rnd = new Random();
        
        //you can write your words inside of the "words" array before start the game. I created random 10 words with ChatGPT
        String[] words = {"elephant", "kangaroo", "computer", "chocolate", "symphony", "mountain", "umbrella", "rainbow", "backpack", "pineapple"};        
        int selection = rnd.nextInt(words.length);
        
        return words[selection];
    }

    // Method to display hangman
    public static void man(int missGuess) {       
                
        // We could also use a switch-case structure.
        
        //for no wrong login
         if (missGuess==0) {            
        System.out.println("   + - - - + ");        
        System.out.println("   |       | ");
        System.out.println("           | ");
        System.out.println("           | ");
        System.out.println("           | ");
        System.out.println("           | ");
        System.out.println("___________|_");
        System.out.println("-------------");            
        }
        
        //for first wrong login 
        if (missGuess==1) {            
        System.out.println("   + - - - + ");        
        System.out.println("   |       | ");
        System.out.println("   O       | ");
        System.out.println("           | ");
        System.out.println("           | ");
        System.out.println("           | ");
        System.out.println("___________|_");
        System.out.println("-------------");                
        }
        
        //for second wrong login
        if (missGuess==2) {            
        System.out.println("   + - - - + ");        
        System.out.println("   |       | ");
        System.out.println("   O       | ");
        System.out.println("   |       | ");
        System.out.println("           | ");
        System.out.println("           | ");
        System.out.println("___________|_");
        System.out.println("-------------");                
        }
        
        //for third wrong login        
        if (missGuess==3) {            
        System.out.println("   + - - - + ");        
        System.out.println("   |       | ");
        System.out.println("   O       | ");
        System.out.println("  /|       | ");
        System.out.println("           | ");
        System.out.println("           | ");
        System.out.println("___________|_");
        System.out.println("-------------");                
        }
        
        //for fourth wrong login
        if (missGuess==4) {            
        System.out.println("   + - - - + ");        
        System.out.println("   |       | ");
        System.out.println("   O       | ");
        System.out.println("  /|\\      | ");
        System.out.println("           | ");
        System.out.println("           | ");
        System.out.println("___________|_");
        System.out.println("-------------");                
        }
        
        //for fiveth wrong login
        if (missGuess==5) {            
        System.out.println("   + - - - + ");        
        System.out.println("   |       | ");
        System.out.println("   O       |");
        System.out.println("  /|\\      | ");
        System.out.println("  /        | ");
        System.out.println("           | ");
        System.out.println("___________|_");
        System.out.println("-------------");                
        }
        
        //for sixth wrong login
        if (missGuess==6) {            
        System.out.println("   + - - - + ");        
        System.out.println("   |      | ");
        System.out.println("   O      |");
        System.out.println("  /|\\     | ");
        System.out.println("  / \\     | ");
        System.out.println("          | ");
        System.out.println("__________|_");
        System.out.println("-------------");                
        }              
         
                
    }

    // Main method
    public static void main(String[] args) {
        
        Scanner scn = new Scanner(System.in);
        
        int maxAttempts = 6;            // Maximum attempts allowed
        
        int attemptsCounter = 0;        // Counter for incorrect guesses

        String theWord = createWord();              // Generate a random word
        
        int lengthOfWord = theWord.length();        // Get the length of the selected word
        
        char[] correct = new char[lengthOfWord];    // Create a char array named correct with the same length as the selected word
        char[] misses = new char[6];                // Create a char array named misses to store incorrect guesses
        int missCounter = 0;                        // Counter for incorrect guesses
        
        boolean[] guessed = new boolean[lengthOfWord];      // Create a boolean array named guessed
        
        for (int i = 0; i < lengthOfWord; i++) {            // Initialize correct array with underscores and guessed array with false
            correct[i] = '_';                               // Set all elements of guessed array to false
            guessed[i] = false;
        }

        while (attemptsCounter < maxAttempts) {     // Continue until number of attempts is less than the maximum allowed
            
            man(attemptsCounter);           // Display hangman
            
            System.out.print("\nWord: ");
            
            // Display correct guesses and underscores
            for (int i = 0; i < lengthOfWord; i++) {
                if (guessed[i]) {
                    System.out.print(theWord.charAt(i) + " ");
                } else {
                    System.out.print("_ ");
                }
            }

            System.out.println("");
            
            // Display incorrect guesses
            for (int i = 0; i < missCounter; i++) {
                System.out.println("Misses: " + misses[i] + " ");                
            }
            
            System.out.print("\nGuess: ");
            String guess = scn.nextLine();

            // Error message for multiple character input
            if (guess.length() != 1) {
                System.out.println("Please enter only one character!");
                continue;
            }

            char letter = guess.charAt(0);
            
            // Check if the letter is in the word
            boolean found = false;

            // If the letter is found in the word, set found to true
            for (int i = 0; i < lengthOfWord; i++) {
                if (theWord.charAt(i) == letter && !guessed[i]) {
                    correct[i] = letter;
                    guessed[i] = true;
                    found = true;
                }
            }
            
            // If the letter is not found, increment missCounter and display a message
            if (!found) {
                System.out.println("Incorrect guess!");
                attemptsCounter++;
                misses[missCounter]=letter;
                missCounter++;
            }
                
            // Check if all letters have been guessed
            boolean allGuessed = true;
            for (boolean elements: guessed) {
                if (!elements) {
                    allGuessed = false;
                    break;
                }
            }
            
            // If all letters have been guessed, display a congratulatory message
            if (allGuessed) {
                System.out.println("Congratulations! You guessed the word correctly: " + theWord);
                break;
            }
            
            System.out.println("");
        }
        
        // If the maximum number of attempts is reached, display a message indicating that the player has run out of attempts
        if (attemptsCounter >= maxAttempts) {
            man(attemptsCounter);
            System.out.println("Sorry, you've run out of attempts. The word was: " + theWord);
        }
    }
}
