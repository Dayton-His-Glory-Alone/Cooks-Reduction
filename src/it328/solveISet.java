package it328;
/**
 * 
 */

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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
	/**
	 * setEdges()
	 * Note: Every vertex links to itself but doesn't count as an edge
	 */
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
	public void createGraph(String fname, solveISet iset) {
		//solveClique clique = new solveClique();
				BufferedReader br= null;
				try {
				//	fname = "C:/Users/Dayton/Desktop/mywork/IT328_Asg1/src/graphs2019.txt";
					// read in file
					br = new BufferedReader(new FileReader(fname));
					String line = null;
					while ((line = br.readLine()) != null) {
						edges= 0;
						vertices = Integer.parseInt(line);
						if (vertices != 0) {
							graphNumber++;
							
							for (int i = 0; i < vertices; i++) {
							
								for (int j = 0; j < vertices; j++) {
									char c = (char) br.read();
									int v = Character.getNumericValue(c);
									matrix[i][j] = v;
									setEdges();
									br.read();

								}
								br.read();
								br.read();
							}
							ArrayList<Integer> arryL = new ArrayList<Integer>();
						//	arryL = iset.findMaxim(arryL, row, vertices);
							results(arryL);
							// print out
						}
					}
				} catch (FileNotFoundException fnf) {
					System.out.println("file not found");
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				

		
	}
	public ArrayList<Integer> findMaxim(ArrayList<Integer> arryL, int row2, int vertices2) {
		return arryL;
		
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		solveISet solveIS= new solveISet();
		String fname = "C:/Users/Dayton/Desktop/mywork/IT328_Asg1/src/graphs2019.txt";
		//solveIS= solveIS.createComplement();
		solveIS.createGraph(fname, solveIS);
		solveIS= solveIS.createComplement();
	}

}
