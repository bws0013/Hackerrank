import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the candies function below.
    static long candies(int n, int[] arr) {

      long total = n;

      // long local_total_front = 0;
      // for(int i = 0; i < n - 1; i++) {
      //   if(arr[i] > arr[i + 1]) {
      //     local_total_front++;
      //     total += local_total_front;
      //   } else if(arr[i] == arr[i + 1]) {
      //     total += local_total_front;
      //   } else {
      //     local_total_front = 0;
      //   }
      // }
      //
      // long local_total_back = 0;
      // for(int i = n - 1; i >= 1; i--) {
      //   if(arr[i] > arr[i - 1]) {
      //     local_total_back++;
      //     total += local_total_back;
      //   } else {
      //     local_total_front = 0;
      //   }
      // }

      return total;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {



      int n = scanner.nextInt();
      int[] arr = new int[n];

      for (int i = 0; i < n; i++) {
          int arrItem = scanner.nextInt();
          arr[i] = arrItem;
      }

      long result = candies(n, arr);

      System.out.println(result);

      scanner.close();

        // BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        //
        // int n = scanner.nextInt();
        // scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        //
        // int[] arr = new int[n];
        //
        // for (int i = 0; i < n; i++) {
        //     int arrItem = scanner.nextInt();
        //     scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        //     arr[i] = arrItem;
        // }
        //
        // long result = candies(n, arr);
        //
        // bufferedWriter.write(String.valueOf(result));
        // bufferedWriter.newLine();
        //
        // bufferedWriter.close();
        //
        // scanner.close();
    }
}
