public class Graph<N,W> implements IGraph<N, W> {
    DoubleLinkList<INode> nodes = new DoubleLinkList<>();
    DoubleLinkList<IEdge> edges = new DoubleLinkList<>();
    public INode<N>[] getNodeSet() {
        INode[] arr = new INode[nodes.size];
        for (int i =0; i<arr.length; i++){
            arr[i] = nodes.fetch(i);
        }
        return arr;
    }

    public INode<N>[] getNeighbors(INode<N> n) {
        int s = 0;
        int count = 0;
        for(int i = 0; i< edges.size; i++){
            if (edges.fetch(i).getSource() == n){
                s++;
            }
        }
        INode<N>[] arr = new INode[s];
        for(int i = 0; i < edges.size; i++){
            if (edges.fetch(i).getSource() == n){
                arr[count] = edges.fetch(i).getDestination();
                count++;
            }

        }
        return arr;
    }

    public INode<N> addNode(N v) {
        INode x = new GNode<>(v);
        nodes.append(x);
        return x;
    }

    public IEdge<N, W>[] getEdgeSet() {
        IEdge<N,W>[] arr = new IEdge[edges.size];
        for (int i =0; i<arr.length; i++){
            arr[i] = edges.fetch(i);
        }
        return arr;
    }


    public IEdge<N, W>[] getEdgesFrom(INode<N> n) {
        int s = 0;
        int count = 0;
        for(int i = 0; i< edges.size; i++){
            if (edges.fetch(i).getSource() == n){
                s++;
            }
        }
        IEdge<N,W>[] arr = new IEdge[s];
        for(int i = 0; i < edges.size; i++){
            if (edges.fetch(i).getSource() == n){
                arr[count] = edges.fetch(i);
                count++;
            }

        }
        return arr;
    }

    public IEdge<N, W>[] getEdgesTo(INode<N> n) {
            int s = 0;
            int count = 0;
            for (int i = 0; i < edges.size; i++) {
                if (edges.fetch(i).getDestination() == n) {
                    s++;
                }
            }
            IEdge<N, W>[] arr = new IEdge[s];
            for (int i = 0; i < edges.size; i++) {
                if (edges.fetch(i).getDestination() == n) {
                    arr[count] = edges.fetch(i);
                    count++;
                }

            }
            return arr;
        }


    public void addEdge(INode<N> s, INode<N> d, W w) {
        IEdge<N,W> x = new Edge(s, d, w);
        edges.append(x);
    }
}
