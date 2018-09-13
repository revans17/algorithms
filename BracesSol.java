import java.util.*;
public class BracesSol{
     static String[] braces(String[] values) {
         //Create an array of strings to produce the output
         String[] output = new String[values.length];
         //Stack to verify that all items match and get removed
         Stack<Character> stack = new Stack<Character>();
         //Loops through the input (values array)
         for (int i=0; i < values.length; i++) {
            //Current line we are working with
            String lineI = values[i];
            //Loops through the line we are working with
            for (int j=0; j < lineI.length(); j++) {
                 //Put the value we get in the stack
                 if (stack.isEmpty()) {
                     stack.push(lineI.charAt(j));
                 }
                 //If the stack is not empty we check to see if the value has a match and remove it
                 else {
                     if (((stack.peek() == '(') && (lineI.charAt(j) == ')')) || ((stack.peek() == '{') && (lineI.charAt(j) == '}')) ||
                         ((stack.peek() == '[') && (lineI.charAt(j) == ']')))
                     { stack.pop();}
                     //If no match is found the we put the char we are at in the stack
                     else { stack.push(lineI.charAt(j));}
                 }
            }
            //If we get an empty stack we have all matches found
            if (stack.isEmpty()) { output[i] = "YES"; }
            //If not then we do not and something doesnt match
            else {
                 output[i] = "NO";
                 //Clear the stack to start the next spot in the array
                 while (!stack.isEmpty()) { stack.pop(); }
            }
         }
         return output;
     }

}
