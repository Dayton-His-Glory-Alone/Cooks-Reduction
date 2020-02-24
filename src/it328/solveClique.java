package it328;
/**
 * 
 */

/**
 * @author Dayton Rumbold Created on: 2/18/20 Last Modified on: 2/23/20
 *
 *         Solves kCliques
 */
public class solveClique {

	private int[][] matrix;
	private int edges;

	public solveClique() {
		matrix = new int[0][0];
		edges = 0;
	}

	public solveClique(int[][]array) {
		this.matrix= new int [array.length][array.length];
		for (int i=0; i<array.length;i++) {
			for(int j=0; j<array.length;j++)
			{
				if(i==j)matrix[i][j]=0;//eliminate selfloops
				else {
					matrix[i][j]= array[i][j];
				}
				
			}
			}
	}
	
	public int edgeCount() {//edge count getter
		return edges;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int edges = 0;
		int totalEdge = 0;

	}

}
