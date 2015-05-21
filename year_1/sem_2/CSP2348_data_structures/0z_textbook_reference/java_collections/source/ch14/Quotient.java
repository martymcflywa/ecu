public class Quotient extends Expression {

    // Each Quotient object describes an expression consisting of the
    // quotient of two operands (which are themselves expressions).

    private Expression leftOperand, rightOperand;

    public float evaluate () {
        return leftOperand.evaluate() / rightOperand.evaluate();
    }
}