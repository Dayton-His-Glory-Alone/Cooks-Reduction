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
	public void results(ArrayList<Integer> clique) {
		System.out.println("G# (|E|,|V|) Independent Set (size, ms solved)");
		System.out.println("G" + graphNumber + "(" + vertices + ", " + edges + ")" + "{" + clique.toString() + "}"
				+ "size= " + clique.size() + time + "ms");
	}

	/*
	 * To do: finish complement method
	 */
	public solveClique createComplement() {
		solveClique complement = new solveClique(matrix);

		return complement;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		

	}

}
