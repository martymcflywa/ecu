import WattBrown.*;

import java.io.*;
import java.util.Iterator;

public class MaterialRequirementsPlanning {

    static void readParts (Digraph partsGraph, Map partsMap,
                            BufferedReader input) throws IOException {
    // Read the list of parts from input and add each part as a node in
    // the graph. Also record each part and its corresponding node in partsMap.
	Part p = Part.readPart(input);
	while (p != null) {
	    Graph.Node node = partsGraph.addNode(p);
	    partsMap.put(p.getPartId(), node);
	    p = Part.readPart(input);
	}
    }

    static void readBillOfMaterials (Digraph partsGraph, Map partsMap,
                            BufferedReader input) throws IOException {
    // Read the bill of materials from input and add each entry as an edge
    // in the graph.

        String line = input.readLine();

        while (line != null) {
            String partId  = line.substring(0, 2).trim();
	    int numSubparts = Integer.parseInt(line.substring(3));
            Graph.Node partNode = (Graph.Node) partsMap.get(partId);
            if (partNode == null) {
	        System.err.println(
		        "Bill of materials contains an unknown part " +
		        partId + ".");
                return;
	    }

	    for (int i = 0; i < numSubparts; i++) {
	        line = input.readLine();
	        if (line == null)  break;
	        String subpartId = line.substring(0, 2).trim();
	        Integer qty = Integer.valueOf(line.substring(3));
	        Graph.Node subpartNode = (Graph.Node) partsMap.get(subpartId);
	        if (subpartNode == null)
		    System.err.println(
		            "Bill of materials contains an unknown subpart " +
		            subpartId + " in part " + partId + ".");
	        else
	            partsGraph.addEdge(partNode, subpartNode, qty);
	    }
	    input.readLine();	// Skip blank line
            line = input.readLine();
        }
    }

    static void readProductionSchedule (Digraph partsGraph, Map partsMap,
                                BufferedReader input) throws IOException {
    // Read the production schedule from input and initialize the required
    // quantities of each product in the graph. All parts in the production
    // schedule are marked as products.
	String line = input.readLine();
	while (line != null) {
	    String partId = line.trim();
	    Graph.Node node = (Graph.Node) partsMap.get(partId);
	    Part part = (Part) node.getElement();
            part.markAsProduct();
	    line = input.readLine();
	    while (! line.equals("")) {
                int i = line.indexOf(' ');
	        int weekNum = Integer.parseInt(line.substring(0, i));
	        int qty = Integer.parseInt(line.substring(i+1));
                part.setRequirements(weekNum, qty);
	        line = input.readLine();
	        if (line == null)  break;
	    }
	    line = input.readLine();
	}
    }

    static void readGraph (Digraph partsGraph, String partsName, String bomName,
                            String scheduleName) {
    // Read partsGraph from the three files with the given filenames.
    // The parts list is in the file named partsName, the bill of materials
    // is in the file named bomName, and the production schedule is in
    // the file named scheduleName.
        Map partsMap = new BSTMap();
	try {
	    BufferedReader parts = new BufferedReader(
		    new InputStreamReader(new FileInputStream(partsName)));
	    readParts(partsGraph, partsMap, parts);
	    parts.close();

	    BufferedReader bill = new BufferedReader(
		    new InputStreamReader(new FileInputStream(bomName)));
	    readBillOfMaterials(partsGraph, partsMap, bill);
	    bill.close();

	    BufferedReader schedule = new BufferedReader(
		    new InputStreamReader(new FileInputStream(scheduleName)));
	    readProductionSchedule(partsGraph, partsMap, schedule);
	    schedule.close();
	} catch (IOException e) {
	    System.out.println(e.getMessage());
	}
    }

    static void calculatePlan (Digraph partsGraph) {
	Stack partsStack = new LinkedStack();

        Iterator iter = partsGraph.nodes();
        while (iter.hasNext()) {
            Graph.Node node = (Graph.Node) iter.next();
            Part part = (Part) node.getElement();
            if (part.isProduct())  partsStack.addLast(node);
        }

	while (! partsStack.isEmpty()) {
	    Graph.Node currentNode = (Graph.Node) partsStack.removeLast();
	    Part currentPart = (Part) currentNode.getElement();
            currentPart.calculateQuantities();
            Iterator outEdges = partsGraph.outEdges(currentNode);
            while (outEdges.hasNext()) {
            	Graph.Edge edge = (Graph.Edge) outEdges.next();
            	Graph.Node destNode = (edge.getNodes())[Graph.Edge.DEST];
            	int qty = ((Integer) edge.getAttribute()).intValue();
            	Part part = (Part) destNode.getElement();
            	part.updateRequirements(currentPart, qty);
            	partsStack.addLast(destNode);
            }
	}
    }

    static void printReport (Digraph partsGraph) {
	Iterator nodes = partsGraph.nodes();
	while (nodes.hasNext()) {
	    Graph.Node node = (Graph.Node) nodes.next();
	    Part part = (Part) node.getElement();
	    System.out.println(part.generateReport());
	}
    }

    public static void main (String[] args) {
    	Digraph partsGraph = new ASDigraph();
    	readGraph(partsGraph, args[0], args[1], args[2]);
	calculatePlan(partsGraph);
	printReport(partsGraph);
    }
}
