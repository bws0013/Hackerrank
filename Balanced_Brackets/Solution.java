import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// https://www.hackerrank.com/challenges/ctci-balanced-brackets/problem

public class Solution {

    public static boolean isBalanced(String expression) {

      // System.out.println(expression);

      Stack<Character> stack = new Stack<Character>();

      if(expression.length() % 2 == 1) {
        return false;
      } else if (expression.charAt(0) == '}') {
        return false;
      } else if (expression.charAt(0) == ']') {
        return false;
      } else if (expression.charAt(0) == ')') {
        return false;
      }

      char current;
      for(int i = 0; i < expression.length(); i++) {
        current = expression.charAt(i);
        if(current == '{') {
          stack.push('}');
        } else if(current == '(') {
          stack.push(')');
        } else if(current == '[') {
          stack.push(']');
        } else {
          if(stack.size() == 0) {
            return false;
          } else if(current != stack.pop()) {
            return false;
          }
        }
      }

      if(stack.size() != 0) {
        return false;
      }

      return true;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            String expression = in.next();
            System.out.println( (isBalanced(expression)) ? "YES" : "NO" );
        }
    }
}
