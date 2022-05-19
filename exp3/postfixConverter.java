import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class postfixConverter {
    private static final Map<String, Integer> priority = new HashMap<String, Integer>();
    static {
        priority.put("-", 1);
        priority.put("+", 1);
        priority.put("*", 2);
        priority.put("/", 2);
        priority.put("(", 0);
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("Please input a infix expr(split by space):");
        String ss = scn.nextLine();
        String[] tokens = ss.split(" ");
        StackLinkedList<String> svalue = new StackLinkedList<>();
        StackLinkedList<String> ssymbol = new StackLinkedList<>();
        String expression = "";
        String [] str = expression.split(" ");
        for (String s:tokens) {
            if (isValue(s)) {
                svalue.push(s);
            } else {
                if (s.equals(")")) {
                    getResult(svalue, ssymbol);
                    ssymbol.pop();
                } else if (s.equals("(")) {
                    ssymbol.push(s);
                } else {
                    if (!ssymbol.isEmpty()) {
                        if (priority.get(s) <= priority.get(ssymbol.peek())) {
                            getResult(svalue, ssymbol);
                        }
                    }
                    ssymbol.push(s);
                }
            }
        }
        while (!ssymbol.isEmpty()) {
            getResult(svalue, ssymbol);
        }
        System.out.println(svalue.peek());
    }

    public static void getResult(StackLinkedList<String> svalue, StackLinkedList<String> ssymbol) {
        String res = "";
        res += svalue.pop() + " " + svalue.pop();
        res += " " + ssymbol.pop();
        svalue.push(res);
    }

    public static Boolean isValue (String s) {
        return !s.equals("+") && !s.equals("-") && !s.equals("*") && !s.equals("/") && !s.equals("(") && !s.equals(")");
    }
}
