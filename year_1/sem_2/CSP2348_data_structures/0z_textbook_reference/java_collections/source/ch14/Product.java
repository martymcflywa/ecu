public class Product extends Expression {

    // Each Product object describes an expression consisting of the product
    // of two operands (which are themselves expressions).

    private Expression leftOperand, rightOperand;

    public float evaluate () {
        return leftOperand.evaluate() * rightOperand.evaluate();
    }
}