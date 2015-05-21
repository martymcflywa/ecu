public class Numeral extends Expression {

    // Each Numeral object describes an expression consisting simply of a
    // numeric literal.

    private float value;

    public float evaluate () {
    // Return the result of evaluating this expression.
        return value;
    }
}