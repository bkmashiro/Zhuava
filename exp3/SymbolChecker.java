import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SymbolChecker {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        StackLinkedList<Character> stk = new StackLinkedList<>();
        System.out.println("Please input a expression:");
        String s = scn.next();
        int pos=-1;
        boolean isStringLegal = true;
        for (char c : s.toCharArray()) {
            int ct = charType(c);
            ++pos;
            if(ct==1){
                stk.push(c);
            }else if(ct==-1){
                if (stk.peek() == getPairChar(c)) stk.pop();
                else {
                    isStringLegal = false;
                    break;
                }
            }
        }
        if (isStringLegal&&stk.isEmpty()) {
            System.out.println("The input sequence is balanced.");
        } else {
            System.out.println("The input sequence is not balanced.");
            System.out.printf("Error occurred at pos %d\n",pos+1);
        }
    }

    static char getPairChar(char c) {
        char ans = ' ';
        switch (c) {
            case '(':
                ans = ')';break;
            case '[':
                ans = ']';break;
            case '{':
                ans = '}';break;
            case ')':
                ans = '(';break;
            case ']':
                ans = '[';break;
            case '}':
                ans = '{';break;
        }
        return ans;
    }

    static int charType(char c) {
        if (c == '(' ||
                c == '{' ||
                c == '[') return 1;
        else if (c == ')' ||
                c == '}' ||
                c == ']') return -1;
        else return 0;
    }

}
