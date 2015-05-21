package WattBrown;

import java.util.Iterator;

public interface Digraph extends Graph {

    // Each Digraph object is a directed graph whose elements and edge
    // attributes are arbitrary objects.

    //////////// Accessor ////////////

    public int outDegree (Graph.Node node);
    // Return the number of out-edges of node in this directed graph.

    //////////// Iterators ////////////

    public Iterator successors (Graph.Node node);
    // Return an iterator that will visit all the successors of node in this
    // directed graph, in no particular order.

    public Iterator outEdges (Graph.Node node);
    // Return an iterator that will visit all the out-edges of node in this
    // directed graph, in no particular order.
}
