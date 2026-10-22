package Week4;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;


public class w4_tailop_25022016 {
    // 10 8 7 5 3 3

    public static Integer hIndex(Integer[] array)
    {
        int ans = 0;
        Arrays.sort(array, Collections.reverseOrder());
        for (int i = 0; i < array.length; i++)
        {
            if (i + 1 <= array[i]) ans++;
            else break;
        }

        return ans;
    }

    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);

        Integer n = scanner.nextInt();
        scanner.nextLine();

        Integer[] array = new Integer[n];

        String line = scanner.nextLine();

        String[] tokens = line.trim().split("\\s+");

        for (int i = 0; i < n; i++)
        {
            array[i] = Integer.parseInt(tokens[i]);
        }

        System.out.println(hIndex(array));
    }
    
}
