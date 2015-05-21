import WattBrown.*;
import java.util.Iterator;

public class DirectedGraphTest {

    public static void main(String[] args) {
        Digraph graph = new ESDigraph();

        Graph.Node nodeA = graph.addNode("A");
        Graph.Node nodeB = graph.addNode("B");
        Graph.Node nodeC = graph.addNode("C");
        Graph.Node nodeD = graph.addNode("D");
        Graph.Node nodeE = graph.addNode("E");
        Graph.Node nodeF = graph.addNode("F");
        Graph.Node nodeG = graph.addNode("G");
        Graph.Node nodeH = graph.addNode("H");
        Graph.Node nodeI = graph.addNode("I");

        graph.addEdge(nodeA, nodeB);
        graph.addEdge(nodeA, nodeE);
        graph.addEdge(nodeB, nodeC);
        graph.addEdge(nodeB, nodeD);
        graph.addEdge(nodeC, nodeG);
        graph.addEdge(nodeC, nodeH);
        graph.addEdge(nodeD, nodeE);
        graph.addEdge(nodeD, nodeF);
        graph.addEdge(nodeE, nodeB);
        graph.addEdge(nodeE, nodeF);
        graph.addEdge(nodeF, nodeH);
        graph.addEdge(nodeG, nodeI);
        graph.addEdge(nodeH, nodeI);

        Iterator iter;

        iter = graph.depthFirstIterator(nodeA);
        System.out.println("Depth-first search starting at A:");
        while (iter.hasNext()) {
            Graph.Node node = (Graph.Node) iter.next();
            System.out.print(node.getElement() + " ");
        }
        System.out.println();

        iter = graph.breadthFirstIterator(nodeA);
        System.out.println("Breadth-first search starting at A:");
        while (iter.hasNext()) {
            Graph.Node node = (Graph.Node) iter.next();
            System.out.print(node.getElement() + " ");
        }
        System.out.println();
    }
} 