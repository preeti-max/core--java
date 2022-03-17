package StreamAPI;

import java.util.*;

public class Reverse {

    String reversed = "";
    Stack<Character>st= new Stack<>();for(
    int i = 0;i<s.length();i++)
    {
        if (s.charAt(i) != ' ') {
            st.push(s.charAt(i));
        } else {
            while (!st.isEmpty()) {
                reversed += st.pop() + " ";
            }

        }

    }while(!st.isEmpty())
    {
        reversed += st.pop();
    }System.out.println(reversed);
    }

    public static void main(String[] args) {
        String s="Hello World";
        reverseString(s);
    }

}
