package progassign1;

import java.util.ArrayList;

/**
 * The Vertex class represents a vertex within a four-dimensional unit square.
 * 
 * @author Anders Peterson
 */
public class Vertex4D{
    public double x;
    public double y;
    public double z;
    public double zz;
    private ArrayList<Vertex4D> connectedVertices;
    
    /**
     * The constructor sets the coordinates of the vertex and initializes the
     * ArrayList of vertices connected to this vertex.
     * @param x A double representing the vertex's location along the x-axis.
     * @param y A double representing the vertex's location along the y-axis.
     * @param z A double representing the vertex's location along the z-axis.
     * @param zz A double representing the vertex's location along the 4th axis.
     */
    public Vertex4D(double x, double y, double z, double zz){
        this.x = x;
        this.y = y;
        this.z = z;
        this.zz = zz;
        connectedVertices = new ArrayList<Vertex4D>();
    }
    
    /**
     * The removeConnection method removes a specified vertex from the list of
     * vertices to which this vertex is connected.
     * @param v The vertex to be removed.
     */
    public void removeConnection(Vertex4D v){
        connectedVertices.remove(v);
    }
    
    /**
     * The getClosest method determines and returns the vertex to which this
     * vertex is closest based on edge weight.
     * @return The vertex closest to this one.
     */
    public Vertex4D getClosest(){
        Vertex4D closestVertex = connectedVertices.get(0);
        double lowestWeight = this.getEdgeWeight(closestVertex);
        for(Vertex4D v : connectedVertices){
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
    public double getEdgeWeight(Vertex4D otherVertex){
        return Math.sqrt(Math.pow((otherVertex.x - this.x), 2)
                + Math.pow((otherVertex.y - this.y), 2)
                + Math.pow((otherVertex.z - this.z) , 2)
                + Math.pow((otherVertex.zz - this.zz), 2));
    }
    
    /**
     * The equals method checks to see if this vertex is the same as another
     * one buy seeing if they have the same coordinates.
     * @param v A specified Vertex object.
     * @return A boolean stating whether or not the two vertices are equal.
     */
    public boolean equals(Vertex4D v){
        return this.x == v.x && this.y == v.y && this.z == v.z && this.zz == zz;
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
     * The getConnectedVertices is a simple accessor for the connectedVertices
     * field.
     * @return  An ArrayList representing the connectedVertices field. 
     */
    public ArrayList<Vertex4D> getConnectedVertices(){
        return connectedVertices;
    }
    
    /**
     * The makeConnections method connects this vertex with all other vertexes
     * in the given ArrayList of vertices. This is done since all graphs in the
     * assignment are complete.
     * @param graph An ArrayList of vertices representing the graph in which
     * this vertex is located.
     */
    public void make4DConnections(ArrayList<Vertex4D> someVerts){
        connectedVertices.clear();
        for(Vertex4D v : someVerts){
            if(!this.equals(v)){
                connectedVertices.add(v);
            }
        }
    }
}
