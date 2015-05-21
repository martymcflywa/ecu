import CharStack;

public class Bracketing {

public static boolean wellBracketed (String phrase) {
    // Test whether phrase is well-bracketed.
    CharStack bracketStack = new CharStack();
    for (int i = 0; i < phrase.length(); i++) {
        char cur = phrase.charAt(i);
        if (cur == '(' || cur == '[' || cur == '{')
            bracketStack.addLast(cur);
        else if (cur == ')' || cur == ']' || cur == '}') {
            if (bracketStack.isEmpty()) return false;
            char left = bracketStack.removeLast();
            if (! matched(left, cur)) return false;
        }
    }
    return (bracketStack.isEmpty());
}

public static boolean matched (char left, char right) {
    // Test whether left and right are matching brackets
    // (assuming that left is a left bracket and right is a right bracket).
    switch (left) {
        case '(':
            return (right == ')');
        case '[':
            return (right == ']');
        case '{':
            return (right == '}');
    }
    return false;
}

public static void main (String[] args) {
    for (int i = 0; i < args.length; i++) {
        String phrase = args[i];
        System.out.println(phrase + " is "
                + (wellBracketed(phrase) ? "well" : "ill")
                + "-bracketed.");
    }
}

}
