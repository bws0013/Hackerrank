import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// https://www.hackerrank.com/challenges/mark-and-toys


public class Solution {
   
   public static void main(String[] args) {
      Scanner in = new Scanner(System.in);
         int num_toys;
         num_toys = in.nextInt();
         int money;
         money = in.nextInt();
         
         int[] arr = new int[num_toys];
         
         for(int i = 0; i < num_toys; i++) {
            arr[i] = in.nextInt();
         }
         
         int ret = buy(money, arr);
         
         System.out.print(ret);
   
   }

   public static int buy(int money, int[] arr) {
      Arrays.sort(arr);
      int toys = 0;
      if(arr[0] > money) {
         return 0;
      }
      
      for(int i = 0; i < arr.length - 1; i++) {
         int current = arr[i];
         money -= current;
         toys++;
         int next = arr[i + 1];
         if(next > money) {
            return toys;
         }
      }
      toys++;
      return toys;
   }

}

/*

public List<String> getMinSequence(String start, String finish) {
      
      
      
		List<String> ret = new ArrayList<String>();
		List<String> searched = new ArrayList<String>();
      
      Queue<String> current = new LinkedList<String>();
		Queue<List<String>> w2l = new LinkedList<List<String>>();
      
	   if(start == null || finish == null) {
         return searched;
      }
   
		List<String> originPath = new ArrayList<String>();
		originPath.add(start);
		
		current.add(start);	
		w2l.add(originPath);
      
      while(!current.isEmpty()) {
         String currentWord = current.poll();
			List<String> currentPath = w2l.poll();
         
         List<String> wordsOneOff = hdWords(currentWord);
         
         if (!wordsOneOff.isEmpty()) {
				for (String word : wordsOneOff) {
					if (word.equals(finish)) {
						currentPath.add(word);
                  
                  
						ret = currentPath; 
                  return currentPath;
               }
               
               else if (!searched.contains(word)){
						
						List<String> tempPath = new ArrayList<String>();
						for (String wordInPath : currentPath) {
							tempPath.add(wordInPath);
						}
						tempPath.add(word);  
                  
                  
                  current.add(word);
						w2l.add(tempPath);
						searched.add(word);  
            
               }
            }
         }
      }
      return ret;
   }
*/