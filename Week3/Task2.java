import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.stream.IntStream;

class Result 
{

    /*
     * Complete the 'isBalanced' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String isBalanced(String s) 
    {
    // Write your code here
        Stack<Character> sta = new Stack<>();
        for (int i = 0; i < s.length(); i++)
        {
            if (s.charAt(i) == '{' || s.charAt(i) == '[' || s.charAt(i) == '(')
            {
                sta.push(s.charAt(i));
            }
            else
            {
                if (sta.isEmpty()) return "NO";
                switch (s.charAt(i))
                {
                    case '}':
                    {
                        if (sta.pop() != '{') return "NO";
                        break;
                    }
                    case ']':
                    {
                        if (sta.pop() != '[') return "NO";
                        break;
                    }
                    case ')':
                    {
                        if (sta.pop() != '(') return "NO";
                        break;
                    }
                }
            }
        }
        if (sta.isEmpty()) return "YES";
        return "NO";
    }

}

public class Task2 
{
    public static void main(String[] args) throws IOException 
    {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                String s = bufferedReader.readLine();

                String result = Result.isBalanced(s);

                System.out.println(result);
                //bufferedWriter.write(result);
                //bufferedWriter.newLine();
            } 
            catch (IOException ex) 
            {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        //bufferedWriter.close();
    }
}