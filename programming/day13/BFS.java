public class BFS<N,W> {
    DoubleLinkList<INode> list = new DoubleLinkList<>();
    RingQueue<IEdge> queue = new RingQueue<>();
    DoubleLinkList<IEdge> checked = new DoubleLinkList<>();
    IGraph<N, W> g;
    INode<N> start;
    INode<N> end;

    public BFS(IGraph g, INode s, INode e) {
        start = s;
        end = e;
        this.g = g;
        list.append(s);
        IEdge[] sedges = g.getEdgesFrom(s);
        for(int i = 0; i < sedges.length; i++){
            queue.enqueue(sedges[i]);
            list.append(sedges[i].getDestination());
        }
    }
    public IList<INode> getPath(INode s, DoubleLinkList l) {
        INode<N> cur = s;
        LinkStack<INode> full = new LinkStack();
        if(cur.equals(end)){
            IList<INode> special = new DoubleLinkList<>();
            special.append(cur);
            return special;
        }
        else {

            while (!cur.equals(end)) {
                int t = list.size;
                IEdge r = queue.dequeue();
                cur = r.getDestination();
                checked.append(r);
                IEdge[] sedges = g.getEdgesFrom(cur);
                for (int o = 0; o < t; o++) {
                    for (int i = 0; i < sedges.length; i++) {
                        if (sedges[i].getDestination().equals(list.fetch(o))) {

                        } else {
                            queue.enqueue(sedges[i]);
                            list.append(sedges[i].getDestination());
                        }
                    }
                }
            }
            full.push(cur);
            while (!cur.equals(s)) {
                int n = 0;
                while (!checked.fetch(n).getDestination().equals(cur)) {
                    n++;
                }
                cur = checked.fetch(n).getSource();
                full.push(cur);
            }
        }

        return full.getStackr();
    }
}
