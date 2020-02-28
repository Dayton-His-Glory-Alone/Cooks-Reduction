package it328;
/**
 * 
 */

import java.util.ArrayList;

/**
 * @author Dayton
 *
 */
public class solveISet {

	private static int[][] matrix;
	private static int edges;
	private static long time;
	private static int vertices = 0;
	private static int row = 0;
	private static int graphNumber = 0;
	
	public solveISet() {
		matrix =new int [50][50];
		
	}
	public solveISet(int[][] array) {
		this.matrix = new int[array.length][array.length];
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length; j++) {
				if (i == j)
					matrix[i][j] = 0;// eliminate selfloops
				else {
					matrix[i][j] = array[i][j];
				}

			}
		}
		setEdges();
	}
	public static void setEdges() {
		edges = 0;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				if (matrix[i][j] == 1)
					edges++;
			}
		}
		edges = edges / 2;
	}
	public void results(ArrayList<Integer> clique) {
		System.out.println("G# (|E|,|V|) Independent Set (size, ms solved)	");
		System.out.println("G" + graphNumber + "(" + vertices + ", " + edges + ")" + "{" + clique.toString() + "}"
				+ "size= " + clique.size() + time + "ms");
	}
	/*
	 * helper methods for complement
	 */
	public int getEdge(int i, int j) {
		return matrix[i][j];
	}
	public void setEdge(int i, int j, int set) {
		if (i>= matrix.length||j>=matrix.length) {
			System.out.println("Out of bounds");
			System.exit(1);
		}
		else{
			matrix[i][j]= set;
		}
		
	}
	/*
	 * CreateComplement of the graph
	 * To do: finish complement method
	 */
	public solveISet createComplement() {
		solveISet complement = new solveISet(matrix);
		for (int i= 0; i<matrix.length; i++)
		{
			for (int j= 0; j<matrix.length;j++) {
				
				if (i==j)complement.setEdge(i,j,0);
				else if(complement.getEdge(i,j)==0) {
					//no edge found, set complement edge
					complement.setEdge(i,j,1);
				}
				else complement.setEdge(i,j,0);
			}
		}
		return complement;
	}
	/**
	 * FINISH...
	 */
	public void createGraph() {
		
		
	}
	public void findMaxim() {
		
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		

	}

}
