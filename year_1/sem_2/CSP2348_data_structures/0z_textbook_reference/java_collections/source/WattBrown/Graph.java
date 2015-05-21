package WattBrown;

import java.util.Iterator;

public interface Graph {

    // Each Graph object is a (directed or undirected) graph whose elements
    // and edge attributes are arbitrary objects.

    //////////// Accessors ////////////

    public int size ();
    // Return the number of nodes in this graph.

    public int degree (Graph.Node node);
    // Return the number of edges connecting node in this graph.

    public boolean containsEdge (Graph.Node node0, Graph.Node node1);
    // Return true if and only if there is an edge connecting node0 and
    // node1 in this graph. (If the graph is directed, node0 is the edge's
    // source and node1 is the destination.)

    //////////// Transformers ////////////

    public void clear ();
    // Make this graph empty.

    public Graph.Node addNode (Object elem);
    // Add to this graph a new node containing element elem, but with no
    // connecting edges, and return the new node.

    public Graph.Edge addEdge (Graph.Node node0, Graph.Node node1);
    // Add to this graph a new edge connecting node0 and node1, but
    // containing no attribute, and return the new edge. (If the graph is
    // directed, node0 is the edge's source and node1 is the destination.)

    public Graph.Edge addEdge (Graph.Node node0, Graph.Node node1, Object attr);
    // Add to this graph a new edge connecting node0 and node1, and
    // containing attribute attr, and return the new edge. (If the graph is
    // directed, node0 is the edge's source and node1 is the destination.)

    public void removeNode (Graph.Node node);
    // Remove node from this graph, together with all connecting edges.

    public void removeEdge (Graph.Edge edge);
    // Remove edge from this graph.

    //////////// Iterators ////////////

    public Iterator nodes ();
    // Return an iterator that will visit all nodes of this graph, in no
    // particular order.

    public Iterator edges ();
    // Return an iterator that will visit all edges of this graph, in no
    // particular order.

    public Iterator neighbors (Graph.Node node);
    // Return an iterator that will visit all the neighbors of node in this
    // graph, in no particular order.

    public Iterator connectingEdges (Graph.Node node);
    // Return an iterator that will visit all connecting edges of node in this
    // graph, in no particular order.

    //////////// Inner interfaces ////////////

    public interface Node {

    // Each Graph.Node object is a directed graph node, and contains a
    // single element.

        public Object getElement ();
        // Return the element contained in this node.

        public void setElement (Object elem);
        // Change the element contained in this node to elem.
    }

    //////////////////////////////////////////////////////////////////////////

    public interface Edge {

    // Each Graph.Edge object is a directed graph edge, and optionally
    // contains an attribute.

	// Constants for the array inidices used for the source and destination
	// nodes returned by getNodes.
	// Use getNodes()[Graph.Edge.SOURCE] and getNodes()[Graph.Edge.DEST]
        public static final int SOURCE = 0, DEST = 1;

        public Graph.Node[] getNodes ();
        // Return an array containing the two nodes connected by this edge.
        // (If the graph is directed, the array will contain the edge's source
        // and destination, in that order.)

        public Object getAttribute ();
        // Return the attribute contained in this edge, or null if there is
        // none.

        public void setAttribute (Object attr);
        // Change the attribute contained in this edge to attr.
    }
}
