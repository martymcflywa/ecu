public class Difference extends Expression {

    // Each Difference object describes an expression consisting of the
    // difference of two operands (which are themselves expressions).

    private Expression leftOperand, rightOperand;

    public float evaluate () {
        return leftOperand.evaluate() + rightOperand.evaluate();
    }
}