# Cooks-Reduction
#Format of graph files: graphs2019.txt
The graphs are stored in a text file one by one. For an undirected graph G : (V, E) with |V | = n
(i.e., n vertices), G will be stored in (n+1) lines. The first line contains the number n to indicate
the size of V . The following n lines represent the adjacency matrix m of G (i.e., m is an n × n
two dimensional array). If the entry m[i][j] = 1, that means (i, j) ∈ E; otherwise m[i][j] = 0
indicates (i, j) 6∈ E.
Since all graphs are undirected, all matrices are symmetric, i.e., for all 0 ≤ i, j < n we have
m[i][j] = m[j][i]. If m[i][j] = m[j][i] = 1, and we count as one edge in E. Note that the diagonal
of the matrix is set to 1, i.e. m[i][i] = 1 since we consider every vertex links to itself but we
do not count it as an edges, thus (v, v) does not contribute to the edge count, |E|. The file is
ended by an empty graph, i.e., n = 0.
• Format of 3CNF files: cnfs2019.txt
Each line in the files is a 3CNF, starting with a number to indicate the number of boolean
variables in this 3CNF. The variables are indexed from 1, 2, to n. After the first number in
IT 328 Programming Assignment 1
each line, the rest numbers indicate the occurrences of the variables in the 3CNF. A negative
number indicates the negation of the corresponding variable. These numbers are grouped 3 by
3. Each group is a clause. For example, consider the following line:
5 1 3 -2 3 1 4 -4 5 1
The first number indicates that there are 5 variables, a1, a2, . . . a5, in the formula. The sequence
represents the formula as follows:
(a1 ∨ a3 ∨ ¬a2) ∧ (a3 ∨ a1 ∨ a4) ∧ (¬a4 ∨ a5 ∨ a1)
A line starting with n = 0 indicates the end of the file.
