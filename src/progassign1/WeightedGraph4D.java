package progassign1;

import java.util.ArrayList;
import java.util.Random;

/**
 * The WeightedGraph4D class represents a weighted graph in four dimensions.
 * @author Anders Peterson
 */
public class WeightedGraph4D{
    private int numVertices;
    public ArrayList<Vertex4D> vertices;
    private MST4D mst;
    
    /**
     * The constructor takes a parameter representing the number of vertices and
     * initializes the graph.
     * @param numVertices An integer representing the number of vertices.
     */
    public WeightedGraph4D(int numVertices){
        this.numVertices = numVertices;
        generateVertices();
        buildMST();
    }
    
    /**
     * The buildMST method builds a minimum spanning tree utilizing the MST
     * class. The method follows Prim's algorithm for constructing an MST. After
     * constructing the mst (MST object) it is assigned to the mst field.
     */
    public void buildMST(){
        Random random = new Random();
        ArrayList<Vertex4D> remaining = vertices;
        Vertex4D v = remaining.get(random.nextInt(numVertices));
        remaining.remove(v);
        MST4D mst = new MST4D(v);
        while(remaining.size() != 1){
            Vertex4D next = mst.getBestNode().getClosest();
            mst.addNode(next);
            remaining.remove(next);
        }
        mst.addNode(remaining.get(0));
        this.mst = mst;
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
     * The generateVertices method generates the number of vertices represented
     * by the numVertices field. Each vertex is assigned x, y, z and zz values
     * between 0 and 1.
     */
    public void generateVertices(){
        vertices = new ArrayList<Vertex4D>();
        for(int i = 0; i < numVertices; i++){
            Vertex4D v = new Vertex4D(Math.random(), Math.random(),
                    Math.random(), Math.random());
            vertices.add(v);
        }
        // it is a complete graph, so all vertices are connected to each other
        for(Vertex4D v : vertices){
            v.make4DConnections(vertices);
        }
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
