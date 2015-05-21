public class Sum extends Expression {

    // Each Sum object describes an expression consisting of the sum of two
    // operands (which are themselves expressions).

    private Expression leftOperand, rightOperand;

    public float evaluate () {
        return leftOperand.evaluate() + rightOperand.evaluate();
    }
}