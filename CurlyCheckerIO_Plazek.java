package cit244_LabAssignment5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

/**
 * @author annap
 */
public class CurlyCheckerIO_Plazek {

    public static void main(String[] args) {

        Stack<Character> stack = new Stack();

        System.out.println("***** First File *****");
        char[] charArray = getArray("SportsTeam1.java");
        printArray(charArray);
        curlyChecker(charArray, stack);

        System.out.println("***** Second File *****");
        charArray = getArray("SportsTeam2.java");
        printArray(charArray);
        curlyChecker(charArray, stack);

    }


    public static char[] getArray(String filename) {
        char[] charArray = new char[100];
        int counter = 0;

        try {
            File file = new File(filename);
            Scanner scan = new Scanner(file);

            while(scan.hasNext()) {
                String currentToken = scan.next();
                if (currentToken.charAt(0) == '{' || currentToken.charAt(0) == '}') {

                    for (int i = 0; i < currentToken.length(); i++) {
                        char c = currentToken.charAt(i);
                        if(c == '{' || c == '}') {
                            charArray[counter] = c;
                        }
                    }
                    counter++;
                }
            }
            System.out.println("Array Loaded.");
            scan.close();

    } catch (FileNotFoundException ex) {
        System.out.println("Error-- file not found.");
        }
    return charArray;
    }

    public static void curlyChecker(char[] charArray, Stack stack) {
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == '{') {
                stack.push('{');
            }
            try{
                if ((charArray[i] == '}')) {
                    stack.pop();
                }
            } catch (Exception EmptyStackException) {
                System.out.println("\nTried to pop from an empty stack! UNEQUAL CURLIES :((( ");
                System.exit(0);
            }

        }
        if (stack.empty()) {
            System.out.println("\nEQUAL CURLIES YAYYYY :)))\n");
        } else {
            System.out.println("\nNOOOO CURLIES NOT EQUAL :(((\n");
        }
    }

    public static void printArray(char[] charArray) {
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] != '0') {
                System.out.print(charArray[i] + " ");
            }
        }
    }


}
