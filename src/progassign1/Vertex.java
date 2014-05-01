package progassign1;

import java.util.ArrayList;

/**
 * The Vertex class represents a vertex within a two-dimensional unit square.
 * 
 * @author Anders Peterson
 */
public class Vertex{
    public double x;
    public double y;
    private ArrayList<Vertex> connectedVertices;
    
    /**
     * The constructor sets the coordinates of the vertex and initializes the
     * ArrayList of vertices connected to this vertex.
     * @param x A double representing the vertex's location along the x-axis.
     * @param y A double representing the vertex's location along the y-axis.
     */
    public Vertex(double x, double y){
        this.x = x;
        this.y = y;
        connectedVertices = new ArrayList<Vertex>();
    }
    
    /**
     * The getConnectedVertices is a simple accessor for the connectedVertices
     * field.
     * @return  An ArrayList representing the connectedVertices field. 
     */
    public ArrayList<Vertex> getConnectedVertices(){
        return connectedVertices;
    }
    
    /**
     * The removeConnection method removes a specified vertex from the list of
     * vertices to which this vertex is connected.
     * @param v The vertex to be removed.
     */
    public void removeConnection(Vertex v){
        connectedVertices.remove(v);
    }
    
    /**
     * The getClosest method determines and returns the vertex to which this
     * vertex is closest based on edge weight.
     * @return The vertex closest to this one.
     */
    public Vertex getClosest(){
        Vertex closestVertex = connectedVertices.get(0);
        double lowestWeight = this.getEdgeWeight(closestVertex);
        for(Vertex v : connectedVertices){
            double edgeWeight = this.getEdgeWeight(v);
            if(edgeWeight < lowestWeight){
                closestVertex = v;
                lowestWeight = edgeWeight;
            }
        }
        return closestVertex;
    }
    
    /**
     * The getEdgeWeight method determines the Euclidean distance between this
     * vertex and a specified other vertex.
     * @param otherVertex  The Vertex object whose distance away from the Vertex
     * is to be determined.
     * @return A double representing the edge weight between this vertex and the
     * specified other vertex.
     */
    public double getEdgeWeight(Vertex otherVertex){
        return Math.sqrt(Math.pow((otherVertex.x - this.x), 2)
                + Math.pow((otherVertex.y - this.y), 2));
    }
    
    /**
     * The getSmallestEdge method determines the lowest weight edge to which
     * this vertex is connected.
     * @return A double representing the weight of the smallest edge.
     */
    public double getSmallestEdge(){
        return this.getEdgeWeight(getClosest());
    }
    
    /**
     * The equals method checks to see if this vertex is the same as another
     * one buy seeing if they have the same coordinates.
     * @param v A specified Vertex object.
     * @return A boolean stating whether or not the two vertices are equal.
     */
    public boolean equals(Vertex v){
        return this.x == v.x && this.y == v.y;
    }
    
    /**
     * The makeConnections method connects this vertex with all other vertexes
     * in the given ArrayList of vertices. This is done since all graphs in the
     * assignment are complete.
     * @param graph An ArrayList of vertices representing the graph in which
     * this vertex is located.
     */
    public void makeConnections(ArrayList<Vertex> graph){
        connectedVertices.clear();
        for(Vertex v : graph){
            if(!this.equals(v)){
                this.connectedVertices.add(v);
            }
        }
    }
}
