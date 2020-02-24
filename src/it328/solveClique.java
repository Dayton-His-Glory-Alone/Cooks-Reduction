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
 * @author Dayton Rumbold Created on: 2/18/20 Last Modified on: 2/23/20
 *
 *         Solves kCliques
 */
public class solveClique {

	private int[][] matrix;
	private int edges;
	private static long time;
	private int vertices=0;
	private int row=0;
	private int graphNumber=0;
	
	//default
	public solveClique() {
		matrix = new int[0][0];
		edges = 0;
		setEdges();
	}
	//initialize from 2d array input
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
		setEdges();
	}
	
	public int edgeCount() {//edge count getter
		return edges;
	}
	/*
	 * To begin, counts ones in graph (edges)
	 */
	public void setEdges() {
		edges = 0;
		for(int i= 0; i< matrix.length; i++) {
			for (int j=0; j<matrix.length; j++) {
				if(matrix[i][j]==1)edges++;
			}
		}
		edges= edges/2;
	}
	/*
	 * To do: finish creation of graph
	 */
	public void readGraph(String fname) {
try {
			BufferedReader br= new BufferedReader(new FileReader(fname));
			String line= null;
			while((line=br.readLine())!=null) {
				edges=0;
				vertices= Integer.parseInt(line);
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

	                    ArrayList<Integer> cliqueAL = new ArrayList<Integer>();
	                   // cliqueAL = clique.findMaxClique(cliqueAL, row, vertices);
	                  //  print(cliqueAL);
	                }
	            }
	            br.close();
		}
		catch(FileNotFoundException fnf) {
			System.out.println("File Not Located");
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/*
	 * To do: finish complement method
	 */
	public solveClique createComplement() {
		solveClique complement= new solveClique(matrix);
		
		return complement;	
	}
	/**
	 * @param args
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		String fname= args[0];
		
		solveClique clique= new solveClique();
		
		int edges = 0;
		int totalEdge = 0;
	
		clique.readGraph(fname);
	}

}
