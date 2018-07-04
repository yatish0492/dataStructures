package com.yatish.Graphs;

import java.util.ArrayList;
import java.util.List;

public class S1_Travelling_Sales_Problem {

	public static void main(String[] args) {
		
		int graph[][] = { 	{ 0, 10, 15, 20 },
                				{ 10, 0, 35, 25 },
                				{ 15, 35, 0, 30 },
                				{ 20, 25, 30, 0 } };
		
		int startingPoint = 0;
		
		S1_Travelling_Sales_Problem obj = new S1_Travelling_Sales_Problem();
		obj.findMinimumPath(graph, startingPoint);

	}
	
	
	public int findMinimumPath(int[][] graph,int startingPoint) {
		
		List<Integer> citiesExceptStartingPoint = new ArrayList<Integer>();
		int rows = graph.length;
		int columns = graph[0].length;
		
		//Adding the cities which to the list 'citiesExceptStartingPoint' except starting point
		for(int i = 0; i < rows; i++) {
			if(i != startingPoint) {
				citiesExceptStartingPoint.add(i);
			}
		}
		
		//We will initialize the 'minimumDistance' to highest value
		int minimumDistance = Integer.MAX_VALUE;
		
		
	}

}
