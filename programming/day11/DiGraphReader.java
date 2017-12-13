import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileNotFoundException;

/**
 * Class that is capable of reading in a graph file from disk.
 * Graph files are line based. Node names have type String and edge weights have 
 * type Double. Fields on the line are separated by ':' and there is no extra white space.
 */
public class DiGraphReader implements IGraphReader {
    // Fields needed for the Graph Reader should be added here

    /**
     * Creates a new graph reader instance
     */
    public DiGraphReader() {
        // Configure the graph reader here
    }
    
    /**
     * Reads in a file and instantiates the graph
     * @param filename the file to read
     * @return the instantiated graph
     */
    public IGraph<String,Double> read(String filename) throws FileNotFoundException, IOException {
        // Open the file
        IGraph<String,Double> graph = new Graph<>();
        BufferedReader br=new BufferedReader(new FileReader(filename));
        String line = br.readLine();
        boolean firsttime = true;
        while(line !=null){
            INode<String> curr[] = new INode[3];
            String data[] = line.split(":");
            if (firsttime){
                curr[0] = graph.addNode(data[0]);
                curr[1] = graph.addNode(data[1]);
                firsttime = false;
            }
            else if (data.length ==3){
                INode[] set = graph.getNodeSet();
                for(int i = 0 ; i < 3; i++){

                    for(int j = 0; j < set.length; j++){
                        if (data[i].equals(set[j])){
                            curr[i] = set[j];
                        }
                        else{
                           curr[i]= graph.addNode(data[i]);
                        }
                    }
                }

            }
            graph.addEdge(curr[0], curr[1], Double.parseDouble(data[2]));
        line = br.readLine();
        }
        // Parse the lines. If a line does not have exactly 3 fields, ignore the line
        // For each line, add the nodes and edge

        // Return the graph instance
        return graph;
    }
    
    /**
     * Simple main method to open and process a file
     */
    public static void main(String[] argv) throws Exception {
        // This code should work without modification once your reader code is working
        IGraphReader r = new DiGraphReader();
        IGraph<String,Double> g = r.read("graphfile.cs2");
        IEdge<String,Double>[] edges = g.getEdgeSet();
        for(int i=0; i<edges.length; i++) {
            System.out.println(edges[i].getSource().getValue()+" -> "+edges[i].getDestination().getValue()+"  w: "+edges[i].getWeight());
        }
    }
}