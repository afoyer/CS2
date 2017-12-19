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
        IEdge[] sedges = g.getEdgesFrom(s);
        for(int i = 0; i < sedges.length; i++){
            queue.enqueue(sedges[i]);
        }
    }
    public IList<INode> getPath(INode s, DoubleLinkList l) {
        INode<N> cur = s;
        LinkStack<INode> full = new LinkStack();
        if(cur.equals(end)){
            IList<INode> special = new DoubleLinkList<>();
            return special;
        }
        while (!cur.equals(end)) {
            boolean exists = false;
            IEdge r = queue.dequeue();
            cur = r.getDestination();
//            System.out.println(cur.getValue());
            checked.append(r);
            for (int i = 0; i < list.size; i++) {
                if (cur.equals(list.fetch(i))) {
                    exists = true;
                }
            }
            if (!exists) {
                list.append(cur);
                IEdge[] sedges = g.getEdgesFrom(cur);
                    for (int i = 0; i < sedges.length; i++) {
                        queue.enqueue(sedges[i]);
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
        return full.getStackr();
    }
}
