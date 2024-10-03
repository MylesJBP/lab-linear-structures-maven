package edu.grinnell.csc207.util;

import edu.grinnell.csc207.linear.Stack;
import edu.grinnell.csc207.linear.LinkedStack;

import java.io.PrintWriter;

/**
 * Assorted utilities for working with strings.
 * 
 * @author Samuel A. Rebelsky
 * @author Your Name Here
 */ 
public class StringUtils {
  // +------------------+--------------------------------------------
  // | Provided methods |
  // +------------------+
    
  /**
   * Determine whether the parens match in string.
   */
  public static boolean checkMatching(String str) throws Exception{
    Stack<Character> parens = new LinkedStack<Character>();
    for(int i = 0; i < str.length(); i++) {
      if(str.charAt(i) == '(' || str.charAt(i) == '[') {
        Character newChar = str.charAt(i) ;
        parens.push(newChar);
      } else if (str.charAt(i) == ')') {
        if (parens.isEmpty()) {
          return false;
        }
         if(parens.peek() == '(') {
          parens.pop() ;
         } else {
          return false;
         }
      } else if (!parens.isEmpty() && str.charAt(i) == ']'){
        if (parens.isEmpty()) {
          return false;
        }
        if(parens.peek() == '[') {
          parens.pop() ;
        } else {
          return false;
        }
      } 
    }
    if (parens.isEmpty()) {
      return true;
    }
    return false;       
  } // checkMatching
} // class StringUtils    

