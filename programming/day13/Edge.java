public class Edge<N, W> implements IEdge<N,W> {
    INode<N> start;
    INode<N> end;
    W weight;

    public Edge(INode<N> s, INode<N> e, W w){
        start = s;
        end = e;
        weight = w;
    }
    public INode<N> getSource() {
        return start;
    }

    public INode<N> getDestination() {
        return end;
    }

    public W getWeight() {
        return weight;
    }

    public boolean equals(Object o){
        Edge compared = (Edge) o;
        if (this.start == compared.start && this.end == compared.end){
            return true;
        }
        else{
            return  false;
        }
    }
}
