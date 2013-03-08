package org.practice.cracking.graph;

public class GraphExampe1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		double[][] dists1 = new double[5][5];
		int graph2[][];
		graph2 = new int[5][5];
		String[] nodes1 = {"A","B","C","D","E"};
		
		//java.util.Arrays.fill(graph1[0], 10000);	
		
		dists1[0][1] = 10;
		dists1[0][2] = 3;
		//dists1[1][2] = 1;
		dists1[1][3] = 2;
		dists1[2][1] = 4;
		dists1[2][3] = 8;
		dists1[2][4] = 2;
		dists1[3][4] = 7;
		dists1[4][3] = 9;
		
		Graph graph1 = new Graph(nodes1,dists1);
		
		
		
		System.out.println(graph1.getString());
		graph1.showDists();
		
		
//		for (int i=0; i<dists1.length; i++) {
//			for (int j = 0; j<dists1[0].length; j++) {
//				System.out.println((char)(i+65)+"->"+(char)(j+65)+": "+dists1[i][j]);
//			}
//		}
		
		graph1.depthFirstSearch(0);
		graph1.breadthFirstSearch(0);
		
		

	}

}
