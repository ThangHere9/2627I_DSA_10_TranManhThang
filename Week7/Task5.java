import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;
import java.util.stream.IntStream;

class Result {

    /*
     * Complete the 'runningMedian' function below.
     *
     * The function is expected to return a DOUBLE_ARRAY.
     * The function accepts INTEGER_ARRAY a as parameter.
     */

    public static List<Double> runningMedian(List<Integer> a) 
    {
    // Write your code here
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        List<Double> medians = new ArrayList<>();

        for (int num : a)
        {
            if (maxHeap.isEmpty() || num < maxHeap.peek())
            {
                maxHeap.add(num);
            } 
            else minHeap.add(num);

            if (maxHeap.size() > minHeap.size() + 1)
                minHeap.add(maxHeap.poll());
            else if (minHeap.size() > maxHeap.size() + 1)
                maxHeap.add(minHeap.poll());

            if (maxHeap.size() == minHeap.size())
                medians.add((maxHeap.peek() + minHeap.peek()) / 2.0);
            else if (maxHeap.size() > minHeap.size())
                medians.add((double) maxHeap.peek());
            else if (minHeap.size() > maxHeap.size())
                medians.add((double) minHeap.peek());
        }

        return medians;
    }

}

public class Task5 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int aCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> a = IntStream.range(0, aCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(toList());

        List<Double> result = Result.runningMedian(a);

        /* 
        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining("\n"))
            + "\n"
        );
        */

        System.out.println(result.stream()
                .map(Object::toString)
                .collect(joining("\n"))
            + "\n");

        bufferedReader.close();
        //bufferedWriter.close();
    }
}