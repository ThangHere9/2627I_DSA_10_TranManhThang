import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.NoSuchElementException;
import java.util.Stack;
import java.util.stream.IntStream;

class Stack2Queue<T>
{
    private final Stack<T> inputStack = new Stack<>();
    private final Stack<T> outputStack = new Stack<>();

    public void enqueue(T element)
    {
        inputStack.push(element);
    }

    public T dequeue()
    {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue underflow: The queue is empty.");
        }
        shiftStack();
        return outputStack.pop();
    }

    public T peek()
    {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue underflow: The queue is empty.");
        }
        shiftStack();
        return outputStack.peek();
    }

    public int size() {
        return inputStack.size() + outputStack.size();
    }

    public boolean isEmpty()
    {
        return inputStack.isEmpty() && outputStack.isEmpty();
    }

    private void shiftStack()
    {
        if (outputStack.isEmpty())
            while (!inputStack.isEmpty())
                outputStack.push(inputStack.pop());
    }

}

public class Task3
{
    public static void main(String[] args) throws IOException 
    {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        Stack2Queue<Integer> que = new Stack2Queue<>();

        IntStream.range(0, t).forEach(tItr -> {
            try {   
                String[] query = bufferedReader.readLine().trim().split("\\s+");
                int type = Integer.parseInt(query[0]);
                switch (type)
                {
                    case 1:
                    {
                        int x = Integer.parseInt(query[1]);
                        que.enqueue(x);
                        break;
                    }
                    case 2:
                    {
                        que.dequeue();
                        break;
                    }
                    case 3:
                    {
                        System.out.println(que.peek());
                    }
                }
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