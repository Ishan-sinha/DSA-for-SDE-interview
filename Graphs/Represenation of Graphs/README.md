## Ways of Representing Graph

The two most common ways of representing graphs are:

1. Adjacency Matrix:

Adjacency Matrix is a 2D array of size V x V where V is the number of vertices in a graph.
Let the 2D array be adj[][], a slot adj[i][j] = 1 indicates that there is an edge from vertex 
i to vertex j. Adjacency matrix for undirected graph is always symmetric. Adjacency Matrix is 
also used to represent weighted graphs. If adj[i][j] = w, then there is an edge from vertex i 
to vertex j with weight w.

2. Adjacency List

An array of lists is used. Size of the array is equal to the number of vertices. Let the array be 
array[]. An entry array[i] represents the list of vertices adjacent to the ith vertex. This representation
can also be used to represent a weighted graph. The weights of edges can be represented as lists of pairs.


Here, I have added the code for both, Representation by Adjacency lists and Adjacency matrix as well.
