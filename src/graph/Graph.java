package graph;

import java.util.Arrays;

public class Graph {
	private Object[] nodes;
//	private int numNodes;
	private double[][] dists;
	
	public Graph(Object[] newNodes, double[][] newDists) {
		nodes = newNodes;
//		numNodes = newNumNodes;
		dists = newDists;
	}
	
	public void setNodes(Object[] newNodes) {
		nodes = newNodes;
	}
	
//	public void setNumNodes(int newNumNodes) {
//		numNodes = newNumNodes;
//	}
	
	public void setDists(double[][] newDists) {
		dists = newDists;
	}
	
	public Object[] getNodes() {
		return nodes;
	}
	
	public int getNumNodes() {
		return nodes.length;
	}
	
	public double[][] getDists() {
		return dists;
	}
	
	public String getString() {
		return "Number of nodes: " + nodes.length + "\nNodes: " + Arrays.toString(nodes) 
			+ "\nDists: " + Arrays.deepToString(dists);
	}
	
	public void showDists() {
		for (int i=0; i<nodes.length; i++) {
			for (int j = 0; j<nodes.length; j++) {
				if (dists[i][j]>0) System.out.println(nodes[i]+"->"+nodes[j]+": "+dists[i][j]);
			}
		}
	}
	
	public void depthFirstSearch (int nodeIndex) {
		boolean[] visited = new boolean[getNumNodes()];
		//System.out.println(Arrays.toString(visited));
		System.out.println("========== DFS ============");
		dfs(nodeIndex, visited);
	}
	
	private void dfs (int nodeIndex, boolean[] visited) {
		
		if (visited[nodeIndex] == false) {
			visit(nodes[nodeIndex]);
			visited[nodeIndex] = true;			
		}
		for (int i=0; i<getNumNodes(); i++) {
			if (visited[i] == false && dists[nodeIndex][i]>0) {
				visit(nodes[i]);
				visited[i] = true;
				dfs(i,visited);
			}
		}		
	}
	
	private void visit(Object node) {
		System.out.println(node);
	}
	
	
}
