//  Testing the push() and pop() methods

import java.util.Stack;

public class WS0901 {

    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push("Brazil");
        stack.push("Canada");
        stack.push("France");
        stack.push("Mexico");
        stack.push("Russia");
        stack.push("Sweden");
        stack.push("Brazil");
        stack.push("Turkey");
        print(stack);
        System.out.println("stack.search(\"Brazil\") = "
                          + stack.search("Brazil"));
        System.out.println("stack.pop() = " + stack.pop());
        System.out.println("stack.pop() = " + stack.pop());
        print(stack);
        System.out.println("stack.search(\"Brazil\") = "
                          + stack.search("Brazil"));
    }

    private static void print(Stack stack) {
        System.out.println(stack);
        System.out.println("stack.size() = " + stack.size());

        try {
            System.out.println("stack.peek() = " + stack.peek());
        } catch(java.util.EmptyStackException e) {
            System.out.println(e + ": The stack is empty.");
        }
    }
}
