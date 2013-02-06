package org.practice.cracking.graph;

import java.util.Arrays;

import org.practice.cracking.queue.QueueList;


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
	
	public void breadthFirstSearch (int nodeIndex) {
		boolean[] visited = new boolean[getNumNodes()];
		QueueList q = new QueueList();
		System.out.println("=========== BFS ============");

		q.enqueue(nodes[nodeIndex]);
		System.out.println("*** enqueue: "+nodes[nodeIndex].toString());
		visited[nodeIndex] = true;
		visit(nodes[nodeIndex]);

		while (q.getSize()!=0) {
			Object node = q.dequeue();
			System.out.println("*** dequeue: "+node.toString());
			int index = 0;
			for (int i = 0; i<getNumNodes(); i++) {
				if (node.equals(nodes[i])) {
					index = i;
				}
			}
			
			for (int i = 0; i<getNumNodes(); i++) {
				if (!visited[i] && dists[index][i]>0) {
					visit(nodes[i]);
					visited[i] = true;
					q.enqueue(nodes[i]);
					System.out.println("*** enqueue: "+nodes[i].toString());
				}
			}
		}		
	}
	
	private void visit(Object node) {
		System.out.println(node);
	}
	
	
}
