package WattBrown;

import java.util.Iterator;

public class AMDigraph implements Digraph {

    // Each AMDigraph object is a directed graph whose elements and
    // edge attributes are arbitrary objects.

    // This directed graph is represented by an adjacency matrix as follows.
    // nodes is an array of ASDigraphNode objects, each of which contains
    // an element and is linked to an array of ASDigraphEdge objects
    // representing the node's potential out-edges (with null indicating the
    // absence of a particular out-edge). Each ASDigraphEdge object
    // contains an attribute and is linked to the edge's source and destination
    // nodes. size contains the graph's size.

    private AMDigraph.Node[] nodes;
    private int size;

    public AMDigraph (int maxsize) {
    // Construct a directed graph, initially empty, whose size will be bounded
    // by maxsize.
        nodes = new AMDigraph.Node[maxsize];
        size = 0;
    }

    public boolean containsEdge (Graph.Node node0, Graph.Node node1) {
    // Return true if and only if there is an edge connecting node0 and
    // node1 in this graph. (If the graph is directed, node0 is the source and
    // node1 is the destination.)
        int i = node0.index, j = node1.index;
        return (nodes[i].outEdges[j] != null);
    }

    //////////// Inner classes ////////////

    private static class Node implements Graph.Node {

        // Each AMDigraph.Node object is a directed graph node, and contains a
        // single element.

        private Object element;
        private int outDegree;
        private AMDigraph.Edge[] outEdges;
        private int index;

    }

    //////////////////////////////////////////////////////////////////////////

    private static class Edge implements Graph.Edge {

        // Each AMDigraph.Edge object is a directed graph edge, and optionally
        // contains an attribute.

        private Object attribute;
        private AMDigraph.Node source, dest;

    }
}