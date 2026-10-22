package Week3;
import java.util.Stack;

public class w3_tailop_25022016 {

    private static int getPrecedence(char ch)
    {
        switch (ch)
        {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
        }
        return -1;
    } 

    public static String convertToPostFix(String expression)
    {
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < expression.length(); i++)
        {
            char c = expression.charAt(i);

            if (Character.isWhitespace(c)) continue;

            if (Character.isLetterOrDigit(c)) result.append(c);
            else if (c == '(') stack.push(c);
            else if (c == ')')
            {
                while (!stack.isEmpty() && stack.peek() != '(') result.append(stack.pop());
                if (!stack.isEmpty() && stack.peek() != '(') return "Lỗi: Biểu thức không hợp lệ (sai dấu ngoặc)";
                else stack.pop(); // Loại bỏ dấu '(' khỏi Stack
            }
            else
            {
                while (!stack.isEmpty() && getPrecedence(c) <= getPrecedence(stack.peek())) 
                {
                    result.append(stack.pop());
                }
                stack.push(c); // Đẩy toán tử hiện tại vào Stack
            }
        }

        while (!stack.isEmpty()) {
            if (stack.peek() == '(') {
                return "Lỗi: Biểu thức không hợp lệ (thừa dấu ngoặc mở)";
            }
            result.append(stack.pop());
        }

        return result.toString();
    }
    
    public static void main(String[] args) 
    {
        String infix1 = "A + B * C";
        String infix2 = "(A + B) * (C - D) / E";
        String infix3 = "a+b*(c-d)/e";
        String infix4 = "(A + B) * C";

        System.out.println("Trung tố: " + infix1);
        System.out.println("Hậu tố:   " + convertToPostFix(infix1));
        System.out.println("-------------------------");
        
        System.out.println("Trung tố: " + infix2);
        System.out.println("Hậu tố:   " + convertToPostFix(infix2));
        System.out.println("-------------------------");
        
        System.out.println("Trung tố: " + infix3);
        System.out.println("Hậu tố:   " + convertToPostFix(infix3));
        System.out.println("-------------------------");

        System.out.println("Trung tố: " + infix4);
        System.out.println("Hậu tố:   " + convertToPostFix(infix4));

    }
}
