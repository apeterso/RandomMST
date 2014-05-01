package progassign1;

import java.util.ArrayList;

/**
 * The MST class represents a minimum spanning tree in two dimensions.
 * @author Anders Peterson
 */
public class MST {
    private ArrayList<Vertex> mst;
    private Vertex bestNode;
    
    /**
     * The constructor takes a single Vertex to be the beginning of the MST.
     * @param first A single Vertex object.
     */
    public MST(Vertex first){
        mst = new ArrayList<Vertex>();
        mst.add(first);
        bestNode = first;
    }
    
    /**
     * The addNode method adds a vertex to the minimum spanning tree and ensures
     * that a node already contained in the MST cannot be redundantly added to
     * it. The method also determines the node with the shortest edge attached
     * to it after the new node is added and sets it to the bestNode field.
     * @param v The vertex to be added to the MST.
     */
    public void addNode(Vertex v){
        for(Vertex node : mst){
            v.removeConnection(node);
            node.removeConnection(v);
        }
        mst.add(v);
        if(v.getConnectedVertices().size() > 0){
            if(v.getSmallestEdge() < bestNode.getSmallestEdge()){
                bestNode = v;
            }
        }
    }
    
    /**
     * The getBestNode method returns the node within the MST that has the
     * shortest edge attached to it.
     * @return A node within the MST that has the shortest edge attached to it.
     */
    public Vertex getBestNode(){
        return bestNode;
    }
    
    /**
     * The numVertices method returns the size of the MST (# of nodes).
     * @return An integer representing the size of the MST.
     */
    public int numVertices(){
        return mst.size();
    }
    
    /**
     * The getWeight method returns the total weight of the MST (sum of all the
     * weights of the edges).
     * @return The total weight of the MST.
     */
    public double getWeight(){
        double totalWeight = 0;
        for(int i = 0; i < mst.size() - 1; i++){
            totalWeight += mst.get(i).getEdgeWeight(mst.get(i+1));
        }
        return totalWeight;
    }
}
