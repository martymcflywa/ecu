package WattBrown;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ASDigraph implements Digraph {

    // Each ASDigraph object is a directed graph whose elements and
    // edge attributes are arbitrary objects.

    // This directed graph is represented by adjacency sets as follows.
    // firstNode is a link to the first node in a DLL of ASDigraphNode
    // objects, each of which contains an element and is linked to an SLL of
    // ASDigraphEdge objects representing the node's out-edges. Each
    // ASDigraphEdge object contains an attribute and is linked to the
    // edge's source and destination nodes. size contains the graph's size.

    private ASDigraph.Node firstNode;
    private int size;

    //////////// Constructor ////////////

    public ASDigraph () {
    // Construct a directed graph, initially empty.
        firstNode = null;
        size = 0;
    }

    //////////// Accessors ////////////

    public int size () {
    // Return the number of nodes in this graph.
        return this.size;
    }

    public int degree (Graph.Node node) {
    // Return the number of edges connecting node in this graph.
        int inDegree = 0;
        for (ASDigraph.Node n = firstNode; n != null; n = n.nextNode) {
            for (ASDigraph.Edge e = n.firstOutEdge; e != null;
                    e = e.nextOutEdge)
                if (e.dest == node)  inDegree++;
        }
        return inDegree + ((ASDigraph.Node) node).outDegree;
    }

    public boolean containsEdge (Graph.Node node0, Graph.Node node1) {
    // Return true if and only if there is an edge connecting node0 and
    // node1 in this graph. (If the graph is directed, node0 is the edge's
    // source and node1 is the destination.)
        ASDigraph.Node source = (ASDigraph.Node) node0,
                dest = (ASDigraph.Node) node1;
        for (ASDigraph.Edge edge = source.firstOutEdge;
                edge != null; edge = edge.nextOutEdge) {
            if (edge.dest == dest)
                return true;
        }
        return false;
    }

    public int outDegree (Graph.Node node) {
    // Return the number of out-edges of node in this directed graph.
        return ((ASDigraph.Node) node).outDegree;
    }

    //////////// Transformers ////////////

    public void clear () {
    // Make this graph empty.
        this.firstNode = null;
        this.size = 0;
    }

    public Graph.Node addNode (Object elem) {
    // Add to this graph a new node containing element elem, but with no
    // connecting edges, and return the new node.
        ASDigraph.Node node = new ASDigraph.Node(elem);
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
        ASDigraph.Node source = (ASDigraph.Node) node0;
        ASDigraph.Node dest = (ASDigraph.Node) node1;
        ASDigraph.Edge edge = new ASDigraph.Edge(source, dest, attr);
        edge.nextOutEdge = source.firstOutEdge;
        source.firstOutEdge = edge;
        source.outDegree++;
        return edge;
    }

    public void removeNode (Graph.Node node) {
    // Remove node from this graph, together with all connecting edges.
        for (ASDigraph.Node n = firstNode; n != null; n = n.nextNode) {
            ASDigraph.Edge prev = null;
            for (ASDigraph.Edge e = n.firstOutEdge; e != null;
                    e = e.nextOutEdge) {
                if (e.dest == node) {
                    ASDigraph.Edge next = e.nextOutEdge;
                    if (prev == null)
                        n.firstOutEdge = next;
                    else
                        prev.nextOutEdge = next;
                    prev = e;
                }
            }
        }

        ASDigraph.Node prevNode = ((ASDigraph.Node) node).prevNode;
        ASDigraph.Node nextNode = ((ASDigraph.Node) node).nextNode;
        prevNode.nextNode = nextNode;
        if (nextNode != null)  nextNode.prevNode = prevNode;
        size--;
    }

    public void removeEdge (Graph.Edge edge) {
    // Remove edge from this graph.
        ASDigraph.Edge curr = (ASDigraph.Edge) edge;
        ASDigraph.Edge prev = null;
        ASDigraph.Node source = curr.source;
        for (ASDigraph.Edge e = source.firstOutEdge; e != null;
                e = e.nextOutEdge) {
            if (e == curr)
                break;
            prev = curr;
        }
        ASDigraph.Edge next = curr.nextOutEdge;
        if (prev == null)
            source.firstOutEdge = next;
        else
            prev.nextOutEdge = next;
        source.outDegree--;
    }

    //////////// Iterators ////////////

    public Iterator nodes () {
    // Return an iterator that will visit all nodes of this graph, in no
    // particular order.
        return new ASDigraph.AllNodeIterator();
    }

    public Iterator edges () {
    // Return an iterator that will visit all edges of this graph, in no
    // particular order.
        return new ASDigraph.AllEdgeIterator();
    }

    public Iterator neighbors (Graph.Node node) {
    // Return an iterator that will visit all the neighbors of node in this
    // graph, in no particular order.
        return new ASDigraph.NodeIterator((ASDigraph.Node) node);
    }

    public Iterator connectingEdges (Graph.Node node) {
    // Return an iterator that will visit all connecting edges of node in this
    // graph, in no particular order.
        return new ASDigraph.EdgeIterator((ASDigraph.Node) node);
    }

    public Iterator successors (Graph.Node node) {
    // Return an iterator that will visit all the successors of node in this
    // directed graph, in no particular order.
        return new ASDigraph.SuccessorIterator((ASDigraph.Node) node);
    }

    public Iterator outEdges (Graph.Node node) {
    // Return an iterator that will visit all the out-edges of node in this
    // directed graph, in no particular order.
        return new ASDigraph.OutEdgeIterator((ASDigraph.Node) node);
    }


    //////////// Inner classes ////////////

    private static class Node implements Graph.Node {

        // Each ASDigraph.Node object is a directed graph node, and contains a
        // single element.

        private Object element;
        private int outDegree;
        private ASDigraph.Edge firstOutEdge;
        private ASDigraph.Node prevNode, nextNode;

        private Node (Object element) {
            this.element = element;
            this.outDegree = 0;
            this.firstOutEdge = null;
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

    //////////////////////////////////////////////////////

    private static class Edge implements Graph.Edge {

        // Each ASDigraph.Edge object is a directed graph edge, and optionally
        // contains an attribute.

        private Object attribute;
        private ASDigraph.Node source, dest;
        private ASDigraph.Edge nextOutEdge;

        //////////// Constructor ////////////

        private Edge (ASDigraph.Node source, ASDigraph.Node dest, Object attr) {
            this.source = source;
            this.dest = dest;
            this.attribute = attr;
            this.nextOutEdge = null;
        }

        //////////// Accessors ////////////

        public Object getAttribute () {
            return this.attribute;
        }

        public Graph.Node[] getNodes () {
            return new Graph.Node[] {this.source, this.dest};
        }

        //////////// Transformer ////////////

        public void setAttribute (Object attr) {
            this.attribute = attr;
        }
    }
    //////////////////////////////////////////////////////////////////////////

    private class AllNodeIterator implements Iterator {

    	private ASDigraph.Node currNode;

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

    private class SuccessorIterator implements Iterator {

    	private Iterator outEdges;
    	private ASDigraph.Node currNode;

    	private SuccessorIterator (ASDigraph.Node node) {
    	    outEdges = new ASDigraph.OutEdgeIterator(node);
    	    if (outEdges.hasNext()) {
    	        ASDigraph.Edge edge = (ASDigraph.Edge) outEdges.next();
    	        currNode = edge.dest;
    	    } else
    	        currNode = null;
    	}

    	public boolean hasNext () {
    	    return (currNode != null);
    	}

    	public Object next () {
    	    Object result = currNode;
    	    if (result == null)  throw new NoSuchElementException();
    	    if (outEdges.hasNext()) {
    	        ASDigraph.Edge edge = (ASDigraph.Edge) outEdges.next();
    	        currNode = edge.dest;
    	    } else
    	        currNode = null;
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
    	private ASDigraph.Node currNode, targetNode;

   	private NodeIterator (ASDigraph.Node node) {
    	    this.targetNode = node;
    	    this.allEdges = new ASDigraph.AllEdgeIterator();
    	    this.currNode = scanNextNode();
        }

        private ASDigraph.Node scanNextNode () {
    	    while (allEdges.hasNext()) {
    	        ASDigraph.Edge edge = (ASDigraph.Edge) allEdges.next();
    	        if (edge.source == targetNode) {
    	            return edge.dest;
    	    	} else if (edge.dest == targetNode) {
    	    	    return edge.source;
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

    	private ASDigraph.Node currNode;
    	private ASDigraph.Edge currEdge;

    	private AllEdgeIterator () {
    	    currNode = firstNode;
    	    currEdge = scanNextEdge();
    	}

        private ASDigraph.Edge scanNextEdge () {
            ASDigraph.Edge e = currEdge.nextOutEdge;
            if (e != null)  return e;
    	    while (currNode != null && currNode.firstOutEdge != null)
    	        currNode = currNode.nextNode;
    	    if (currNode != null)
    	        return currNode.firstOutEdge;
            else
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

    //////////////////////////////////////////////////////////////////////////

    private class EdgeIterator implements Iterator {

    	private Iterator allEdges;
    	private ASDigraph.Edge currEdge;
    	private ASDigraph.Node targetNode;

    	private EdgeIterator (ASDigraph.Node node) {
    	    this.allEdges = new ASDigraph.AllEdgeIterator();
    	    this.targetNode = node;
    	    this.currEdge = scanNextEdge();
    	}

        private ASDigraph.Edge scanNextEdge () {
    	    while (allEdges.hasNext()) {
    	    	ASDigraph.Edge edge = (ASDigraph.Edge) allEdges.next();
    	    	if (edge.source == targetNode || edge.dest == targetNode)
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

    private class OutEdgeIterator implements Iterator {

        private ASDigraph.Edge currEdge;

    	private OutEdgeIterator (ASDigraph.Node node) {
    	    currEdge = node.firstOutEdge;
    	}

    	public boolean hasNext () {
    	    return (currEdge != null);
    	}

    	public Object next () {
    	    Object result = currEdge;
    	    if (result == null)  throw new NoSuchElementException();
    	    currEdge = currEdge.nextOutEdge;
    	    return result;
    	}

    	public void remove () {
    	    if (currEdge == null)  throw new IllegalStateException();
    	    removeEdge(currEdge);
    	}
    }
}
