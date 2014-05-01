/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package progassign1;

/**
 *
 * @author andy
 */
public class Main {
    public static void main(String[] args){
        if(args[0].equals("full2dTest")){
            System.out.println("---------------------");
            System.out.println("Testing the size of a minimum spanning tree of a graph"
                    + " containing n vertices. \nEach vertex is chosen at random and falls"
                    + " within the unit square.");
            for(int i = 16; i <= 32678; i = i*2){
                System.out.println("--------------------");
                System.out.println("Testing for value n = " + i);
                WeightedGraph graph1 = new WeightedGraph(i);
                double mstWeight1 = graph1.getMSTWeight();
                System.out.println("Test 1: " + mstWeight1);
                WeightedGraph graph2 = new WeightedGraph(i);
                double mstWeight2 = graph2.getMSTWeight();
                System.out.println("Test 2: " + mstWeight2);
                WeightedGraph graph3 = new WeightedGraph(i);
                double mstWeight3 = graph3.getMSTWeight();
                System.out.println("Test 3: " + mstWeight3);
                WeightedGraph graph4 = new WeightedGraph(i);
                double mstWeight4 = graph4.getMSTWeight();
                System.out.println("Test 4: " + mstWeight4);
                WeightedGraph graph5 = new WeightedGraph(i);
                double mstWeight5 = graph5.getMSTWeight();
                System.out.println("Test 5: " + mstWeight5);
                double average = (mstWeight1 + mstWeight2 + mstWeight3 + mstWeight4 + mstWeight5)/5.0;
                System.out.println("Average weight for n = " + i + ": " + average);
            }
        }
        if(args[0].equals("full3dTest")){
            System.out.println("---------------------");
            System.out.println("Testing the size of a minimum spanning tree of a graph"
                    + " containing n vertices. \nEach vertex is chosen at random and falls"
                    + " within the 3 dimensional unit square.");
            for(int i = 16; i <= 32678; i = i*2){
                System.out.println("--------------------");
                System.out.println("Testing for value n = " + i);
                WeightedGraph3D graph1 = new WeightedGraph3D(i);
                double mstWeight1 = graph1.getMSTWeight();
                System.out.println("Test 1: " + mstWeight1);
                WeightedGraph3D graph2 = new WeightedGraph3D(i);
                double mstWeight2 = graph2.getMSTWeight();
                System.out.println("Test 2: " + mstWeight2);
                WeightedGraph3D graph3 = new WeightedGraph3D(i);
                double mstWeight3 = graph3.getMSTWeight();
                System.out.println("Test 3: " + mstWeight3);
                WeightedGraph3D graph4 = new WeightedGraph3D(i);
                double mstWeight4 = graph4.getMSTWeight();
                System.out.println("Test 4: " + mstWeight4);
                WeightedGraph3D graph5 = new WeightedGraph3D(i);
                double mstWeight5 = graph5.getMSTWeight();
                System.out.println("Test 5: " + mstWeight5);
                double average = (mstWeight1 + mstWeight2 + mstWeight3 + mstWeight4 + mstWeight5)/5.0;
                System.out.println("Average weight for n = " + i + ": " + average);
            }
        }
        
        if(args[0].equals("full4dTest")){
            System.out.println("---------------------");
            System.out.println("Testing the size of a minimum spanning tree of a graph"
                    + " containing n vertices. \nEach vertex is chosen at random and falls"
                    + " within the 3 dimensional unit square.");
            for(int i = 16; i <= 32678; i = i*2){
                System.out.println("--------------------");
                System.out.println("Testing for value n = " + i);
                WeightedGraph4D graph1 = new WeightedGraph4D(i);
                double mstWeight1 = graph1.getMSTWeight();
                System.out.println("Test 1: " + mstWeight1);
                WeightedGraph4D graph2 = new WeightedGraph4D(i);
                double mstWeight2 = graph2.getMSTWeight();
                System.out.println("Test 2: " + mstWeight2);
                WeightedGraph4D graph3 = new WeightedGraph4D(i);
                double mstWeight3 = graph3.getMSTWeight();
                System.out.println("Test 3: " + mstWeight3);
                WeightedGraph4D graph4 = new WeightedGraph4D(i);
                double mstWeight4 = graph4.getMSTWeight();
                System.out.println("Test 4: " + mstWeight4);
                WeightedGraph4D graph5 = new WeightedGraph4D(i);
                double mstWeight5 = graph5.getMSTWeight();
                System.out.println("Test 5: " + mstWeight5);
                double average = (mstWeight1 + mstWeight2 + mstWeight3 + mstWeight4 + mstWeight5)/5.0;
                System.out.println("Average weight for n = " + i + ": " + average);
            }
        }
        int numpoints = Integer.parseInt(args[1]);
        int numtrials = Integer.parseInt(args[2]);
        int dimension = Integer.parseInt(args[3]);
        if(dimension > 4 || dimension < 0 || dimension == 1){
            System.out.println("Please enter valid dimension.");
            System.out.println("Format for randmst is \"0 numpoints numtrials dimension\"");
        }
        if(dimension == 2 || dimension == 0){
            double mstAvg = 0;
            for(int i = 0; i < numtrials; i++){
                WeightedGraph graph = new WeightedGraph(numpoints);
                mstAvg += graph.getMSTWeight();
            }
            System.out.println(mstAvg/numtrials + " " + numpoints + " " + numtrials + " " + dimension);
        }
        
        if(dimension == 3){
            double mstAvg = 0;
            for(int i = 0; i < numtrials; i++){
                WeightedGraph3D graph = new WeightedGraph3D(numpoints);
                mstAvg += graph.getMSTWeight();
            }
            System.out.println(mstAvg/numtrials + " " + numpoints + " " + numtrials + " " + dimension);
        }
        
        if(dimension == 4){
            double mstAvg = 0;
            for(int i = 0; i < numtrials; i++){
                WeightedGraph4D graph = new WeightedGraph4D(numpoints);
                mstAvg += graph.getMSTWeight();
            }
            System.out.println(mstAvg/numtrials + " " + numpoints + " " + numtrials + " " + dimension);
        }
    }
}
