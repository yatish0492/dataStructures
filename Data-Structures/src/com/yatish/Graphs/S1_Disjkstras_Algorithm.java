package com.yatish.Graphs;

public class S1_Disjkstras_Algorithm {

	public static void main(String[] args) {
		
		int graph[][] = new int[][]{{0, 4, 999, 999, 999, 999, 999, 8, 999},
						            {4, 0, 8, 999, 999, 999, 999, 11, 999},
						            {999, 8, 0, 7, 999, 4, 999, 999, 2},
						            {999, 999, 7, 0, 9, 14, 999, 999, 999},
						            {999, 999, 999, 9, 0, 10, 999, 999, 999},
						            {999, 999, 4, 14, 10, 0, 2, 999, 999},
						            {999, 999, 999, 999, 999, 2, 0, 1, 6},
						            {8, 11, 999, 999, 999, 999, 1, 0, 7},
						            {999, 999, 2, 999, 999, 999, 6, 7, 0}
						           };
		int source = 0;	
		S1_Disjkstras_Algorithm obj = new S1_Disjkstras_Algorithm();
		int numOfNodes = graph.length;
		obj.printShortestPathsWithDistance(graph,source,numOfNodes);
						           
	}
	
	public void printShortestPathsWithDistance(int[][] graph,int source,int numOfNodes) {
		
		int dist[] = graph[source];
		boolean visited[] = new boolean[numOfNodes];
		visited[source] = true;
		
		
		
		for(int i = 0; i < numOfNodes; i++) {
			int min = 999;
			int nextMinNode = -1;
			
			for(int j = 0; j < numOfNodes; j++) {
				if(visited[j] == false) {
					if(dist[j] < min) {
						min = dist[j];
						nextMinNode = j;
					}
				}
			}
			
			if(nextMinNode == -1) {
			  break;	
			}
			
			visited[nextMinNode] = true;
			
			for(int k = 0; k < numOfNodes; k++) {
				if(visited[k] == false) {
					if((dist[nextMinNode] + graph[nextMinNode][k]) < dist[k]) {
						dist[k] = dist[nextMinNode] + graph[nextMinNode][k];
						System.out.println("Next Node Visited : " + nextMinNode);
					}
				}
			}
			
		}
		//pring result
		for(int m=0; m < dist.length; m++) {
			System.out.println(dist[m]);
		}
	}

	
}
