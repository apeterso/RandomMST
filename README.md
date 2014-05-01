RandomMST
=========
The randmst application generates a fully connected graph in two, three, or four dimensions. The coordinates of each vertex fall within the unit square (or cube, or hypercube), where each coordinate is in the range [0,1]. The number of vertices in the graph is specified by the user. The program will then determine the minimum spanning tree for that graph using Prim's algorithm and give the MST's weight. On the command line, the number of points, dimension, and number of trials are specified and the average weight of all the MSTs generated is given.

The command line arguments are as follows: $ java -jar randmst.jar 0 numpoints numtrials dimension

The output is as follows: average numpoints numtrials dimension
