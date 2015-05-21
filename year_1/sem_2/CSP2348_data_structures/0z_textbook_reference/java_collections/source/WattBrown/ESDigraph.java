package WattBrown;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ESDigraph implements Digraph {

    // Each ESDigraph object is a directed graph whose elements and
    // edge attributes are arbitrary objects.

    // This directed graph is represented by a node set and edge set as follows.
    // firstNode is a link to the first node in a DLL of ESDigraphNode
    // objects, each of which contains an element. firstEdge is a link to the
    // first node in a DLL of ESDigraphEdge objects, each of which
    // contains an attribute and is linked to the edge's source and destination
    // nodes. size contains the graph's size.

    private ESDigraph.Node firstNode;
    private ESDigraph.Edge firstEdge;
    private int size;

    //////////// Constructor ////////////

    public ESDigraph () {
    // Construct a directed graph, initially empty.
        firstNode = null;
        firstEdge = null;
        size = 0;
    }

    //////////// Accessors ////////////

    public int size () {
    // Return the number of nodes in this graph.
        return this.size;
    }

    public int degree (Graph.Node node) {
    // Return the number of edges connecting node in this graph.
        int numEdges = 0;
        for (ESDigraph.Edge e = firstEdge; e != null; e = e.nextEdge) {
            if (e.source == node || e.dest == node)
                numEdges++;
        }
        return numEdges;
    }

    public boolean containsEdge (Graph.Node node0, Graph.Node node1) {
    // Return true if and only if there is an edge connecting node0 and
    // node1 in this graph. (If the graph is directed, node0 is the edge's
    // source and node1 is the destination.)
        for (ESDigraph.Edge e = firstEdge; e != null; e = e.nextEdge) {
            if (e.source == node0 && e.dest == node1)
                return true;
        }
        return false;
    }

    public int outDegree (Graph.Node node) {
    // Return the number of out-edges of node in this directed graph.
        return ((ESDigraph.Node) node).outDegree;
    }

    //////////// Transformers ////////////

    public void clear () {
    // Make this graph empty.
        this.firstNode = null;
        this.firstEdge = null;
        this.size = 0;
    }

    public Graph.Node addNode (Object elem) {
    // Add to this graph a new node containing element elem, but with no
    // connecting edges, and return the new node.
        ESDigraph.Node node = new ESDigraph.Node(elem);
        node.prevNode = null;
        node.nextNode = firstNode;
        firstNode = node;
        size++;
        return node;
    }

    public Graph.Edge addEdge (Graph.Node node0, Graph.Node node1) {
    // Add to this graph a new edge connecting node0 and node1, but
    // containing no attribute, and return the new edge. (If the graph is
    // directed, node0 is the edge's source and node1 is the destination.)
        return addEdge(node0, node1, null);
    }

    public Graph.Edge addEdge (Graph.Node node0, Graph.Node node1,
            Object attr) {
    // Add to this graph a new edge connecting node0 and node1, and
    // containing attribute attr, and return the new edge. (If the graph is
    // directed, node0 is the edge's source and node1 is the destination.)
        ESDigraph.Node source = (ESDigraph.Node) node0;
        ESDigraph.Node dest = (ESDigraph.Node) node1;
        ESDigraph.Edge edge = new ESDigraph.Edge(source, dest, attr);
        edge.prevEdge = null;
        edge.nextEdge = firstEdge;
        firstEdge = edge;
        source.outDegree++;
        return edge;
    }

    public void removeNode (Graph.Node node) {
    // Remove node from this graph, together with all connecting edges.
    	ESDigraph.Node currNode = (ESDigraph.Node) node;
        for (ESDigraph.Edge e = firstEdge; e != null; e = e.nextEdge) {
            if (e.source == currNode || e.dest == currNode) {
                ESDigraph.Edge prevEdge = e.prevEdge;
                ESDigraph.Edge nextEdge = e.nextEdge;
                prevEdge.nextEdge = nextEdge;
                if (nextEdge != null)  nextEdge.prevEdge = prevEdge;
            }
        }
        ESDigraph.Node prevNode = currNode.prevNode;
        ESDigraph.Node nextNode = currNode.nextNode;
        prevNode.nextNode = nextNode;
        if (nextNode != null)  nextNode.prevNode = prevNode;
        size--;
    }

    public void removeEdge (Graph.Edge edge) {
    // Remove edge from this graph.
        ESDigraph.Edge prevEdge = ((ESDigraph.Edge) edge).prevEdge;
        ESDigraph.Edge nextEdge = ((ESDigraph.Edge) edge).nextEdge;
        if (prevEdge == null)
            firstEdge = nextEdge;
        else
            prevEdge.nextEdge = nextEdge;
        if (nextEdge != null)  nextEdge.prevEdge = prevEdge;
        ((ESDigraph.Edge) edge).source.outDegree--;
    }

    //////////// Iterators ////////////

    public Iterator nodes () {
    // Return an iterator that will visit all nodes of this graph, in no
    // particular order.
        return new ESDigraph.AllNodeIterator();
    }

    public Iterator edges () {
    // Return an iterator that will visit all edges of this graph, in no
    // particular order.
        return new ESDigraph.AllEdgeIterator();
    }

    public Iterator neighbors (Graph.Node node) {
    // Return an iterator that will visit all the neighbors of node in this
    // graph, in no particular order.
        return new ESDigraph.NodeIterator((ESDigraph.Node) node, false);
    }

    public Iterator connectingEdges (Graph.Node node) {
    // Return an iterator that will visit all connecting edges of node in this
    // graph, in no particular order.
        return new ESDigraph.EdgeIterator((ESDigraph.Node) node, false);
    }

    public Iterator successors (Graph.Node node) {
    // Return an iterator that will visit all the successors of node in this
    // directed graph, in no particular order.
        return new ESDigraph.NodeIterator((ESDigraph.Node) node, true);
    }

    public Iterator outEdges (Graph.Node node) {
    // Return an iterator that will visit all the out-edges of node in this
    // directed graph, in no particular order.
        return new ESDigraph.EdgeIterator((ESDigraph.Node) node, true);
    }

    //////////// Inner classes ////////////

    private static class Node implements Graph.Node {

        // Each ESDigraph.Node object is a directed graph node, and contains a
        // single element.

        private Object element;
        private int outDegree;
        private ESDigraph.Node prevNode, nextNode;

        //////////// Constructor ////////////

        private Node (Object element) {
            this.element = element;
            this.outDegree = 0;
            this.prevNode = null;
            this.nextNode = null;
        }

        //////////// Accessor ////////////

        public Object getElement () {
            return this.element;
        }

        //////////// Transformer ////////////

        public void setElement (Object element) {
            this.element = element;
        }
    }

    //////////////////////////////////////////////////////////////////////////

    private static class Edge implements Graph.Edge {

        // Each ESDigraph.Edge object is a directed graph edge, and optionally
        // contains an attribute.

        private Object attribute;
        private ESDigraph.Node source, dest;
        private ESDigraph.Edge prevEdge, nextEdge;

        //////////// Constructor ////////////

        private Edge (ESDigraph.Node source, ESDigraph.Node dest, Object attr) {
            this.source = source;
            this.dest = dest;
            this.attribute = attr;
            this.prevEdge = null;
            this.nextEdge = null;
        }

        public Graph.Node[] getNodes () {
        // Return an array containing the two nodes connected by this edge.
        // (If the graph is directed, the array will contain the edge's source
        // and destination, in that order.)
            return new Graph.Node[] {this.source, this.dest};
        }

        public Object getAttribute () {
        // Return the attribute contained in this edge, or null if there is
        // none.
            return this.attribute;
        }

        public void setAttribute (Object attr) {
        // Change the attribute contained in this edge to attr.
            this.attribute = attr;
        }
    }

    //////////////////////////////////////////////////////////////////////////

    private class AllNodeIterator implements Iterator {

    	private ESDigraph.Node currNode;

    	private AllNodeIterator () {
    	    currNode = firstNode;
    	}

    	public boolean hasNext () {
            return (currNode != null);
        }

        public Object next () {
            Object result = currNode;
            if (result == null)  throw new NoSuchElementException();
            currNode = currNode.nextNode;
            return result;
        }

        public void remove () {
            if (currNode == null)  throw new IllegalStateException();
            removeNode(currNode);
        }
    }

    //////////////////////////////////////////////////////////////////////////

    private class NodeIterator implements Iterator {

    	private Iterator allEdges;
    	private ESDigraph.Node currNode, targetNode;
    	private boolean directed;

   	private NodeIterator (ESDigraph.Node node, boolean directed) {
    	    this.targetNode = node;
    	    this.directed = directed;
    	    this.allEdges = new ESDigraph.AllEdgeIterator();
    	    this.currNode = scanNextNode();
        }

        private ESDigraph.Node scanNextNode () {
    	    while (allEdges.hasNext()) {
    	        ESDigraph.Edge currEdge = (ESDigraph.Edge) allEdges.next();
    	        if (currEdge.source == targetNode) {
    	            return currEdge.dest;
    	    	} else if (! directed && currEdge.dest == targetNode) {
    	    	    return currEdge.source;
    	    	}
    	    }
    	    return null;
        }

        public boolean hasNext () {
            return (currNode != null);
        }

        public Object next () {
    	    Object result = currNode;
    	    if (result == null)  throw new NoSuchElementException();
            currNode = scanNextNode();
    	    return result;
    	}

    	public void remove () {
    	    if (currNode == null)  throw new IllegalStateException();
    	    removeNode(currNode);
    	}
    }

    //////////////////////////////////////////////////////////////////////////

    private class AllEdgeIterator implements Iterator {

    	private ESDigraph.Edge currEdge;

    	private AllEdgeIterator () {
    	    currEdge = firstEdge;
    	}

    	public boolean hasNext () {
    	    return (currEdge != null);
    	}

    	public Object next () {
    	    Object result = currEdge;
    	    if (result == null)  throw new NoSuchElementException();
    	    currEdge = currEdge.nextEdge;
    	    return result;
    	}

    	public void remove () {
    	    if (currEdge == null)  throw new IllegalStateException();
    	    removeEdge(currEdge);
    	}
    }

    //////////////////////////////////////////////////////////////////////////

    private class EdgeIterator implements Iterator {

    	private Iterator allEdges;
    	private ESDigraph.Edge currEdge;
    	private ESDigraph.Node targetNode;
    	private boolean directed;

    	private EdgeIterator (ESDigraph.Node node, boolean directed) {
    	    this.allEdges = new ESDigraph.AllEdgeIterator();
    	    this.targetNode = node;
    	    this.directed = directed;
    	    this.currEdge = scanNextEdge();
    	}

        private ESDigraph.Edge scanNextEdge () {
    	    while (allEdges.hasNext()) {
    	    	ESDigraph.Edge edge = (ESDigraph.Edge) allEdges.next();
    	    	if ((edge.source == targetNode) ||
    	    	        (! directed && edge.dest == targetNode))
    	    	    return edge;
    	    }
    	    return null;
    	}

    	public boolean hasNext () {
    	    return (currEdge != null);
    	}

    	public Object next () {
    	    Object result = currEdge;
    	    if (result == null)  throw new NoSuchElementException();
            currEdge = scanNextEdge();
    	    return result;
    	}

    	public void remove () {
    	    if (currEdge == null)  throw new IllegalStateException();
    	    removeEdge(currEdge);
    	}
    }
}
