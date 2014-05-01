package progassign1;

import java.util.ArrayList;
import java.util.Random;

/**
 * The WeightedGraph class represents a weighted graph in two dimensions.
 * @author Anders Peterson
 */
public class WeightedGraph {
    private int numVertices;
    private ArrayList<Vertex> vertices;
    private MST mst;
    
    /**
     * The constructor takes a parameter representing the number of vertices and
     * initializes the graph.
     * @param numVertices An integer representing the number of vertices.
     */
    public WeightedGraph(int numVertices){
        this.numVertices = numVertices;
        generateVertices();
        buildMST();
    }
    
    /**
     * The generateVertices method generates the number of vertices represented
     * by the numVertices field. Each vertex is assigned x and y values between
     * 0 and 1.
     */
    public void generateVertices(){
        vertices = new ArrayList<Vertex>();
        for(int i = 0; i < numVertices; i++){
            Vertex v = new Vertex(Math.random(), Math.random());
            vertices.add(v);
        }
        // it is a complete graph, so all vertices are connected to each other
        for(Vertex v : vertices){
            v.makeConnections(vertices);
        }
    }
    
    /**
     * The getNumEdges method returns the theoretical number of edges there
     * should be given a complete graph containing the number of vertices
     * specified in the numVertices field.
     * @return An integer representing the theoretical number of edges.
     */
    public int getNumEdges(){
        return (numVertices*(numVertices -1))/2;
    }
    
    /**
     * The buildMST method builds a minimum spanning tree utilizing the MST
     * class. The method follows Prim's algorithm for constructing an MST. After
     * constructing the mst (MST object) it is assigned to the mst field.
     */
    public void buildMST(){
        Random random = new Random();
        ArrayList<Vertex> remaining = vertices;
        Vertex v = remaining.get(random.nextInt(numVertices));
        remaining.remove(v);
        MST mst = new MST(v);
        while(remaining.size() != 1){
            Vertex next = mst.getBestNode().getClosest();
            mst.addNode(next);
            remaining.remove(next);
        }
        mst.addNode(remaining.get(0));
        this.mst = mst;
    }
    
    /**
     * The getMST weight method returns the total weight of the minimum spanning
     * tree represented by the mst field.
     * @return 
     */
    public double getMSTWeight(){
        return mst.getWeight();
    }
}
