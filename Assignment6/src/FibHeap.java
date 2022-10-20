public class FibHeap {
    static boolean MARK = true;
    static boolean UNMARK = false;
    public int n;
    public Node minroot;
    public FibHeap(){
        minroot = null;
        n = 0;
    }

    public FibHeap(FibHeap h1, FibHeap h2){
        h1.minroot.next.prev = h2.minroot.prev;
        h2.minroot.prev.next = h1.minroot.next;
        h1.minroot.next = h2.minroot;
        h2.minroot.prev = h1.minroot;
        if(h1.minroot.key > h2.minroot.key) minroot = h2.minroot;
        else minroot = h1.minroot;
        n = h1.n + h2.n;
    }

    public Node insert(int key, String data){
        Node newnode = new Node();
        newnode.key = key;
        newnode.data = data;
        newnode.marked = UNMARK;
        newnode.deg = 0;
        if(minroot == null){
            newnode.next = newnode;
            newnode.prev = newnode;
            minroot = newnode;
            n++;
            return newnode;
        }
        minroot.next.prev = newnode;
        newnode.next = minroot.next;
        minroot.next = newnode;
        newnode.prev = minroot;
        if(minroot.key > newnode.key) minroot = newnode;
        n++;
        return newnode;
    }

    public Node queryMin(){return minroot;}
    public boolean deleteMin(){
        if(minroot == null) return false;
        if(n == 1){
            minroot = null;
            n--;
            return true;
        }
        if(minroot.child != null){
            downdgree(minroot.child);
            minroot.next.prev = minroot.child.prev;
            minroot.child.prev.next = minroot.next;
            minroot.next = minroot.child;
            minroot.child.prev = minroot;
            minroot.child.parent = null;
            for(Node e = minroot.child.next; e != minroot.child; e = e.next) e.parent = null;
        }
        minroot.prev.next = minroot.next;
        minroot.next.prev = minroot.prev;
        minroot = minroot.next;
        min(minroot.next);
        n--;
        Node[] D = new Node[n];
        union(D, minroot);
        return true;
    }

    public void decreaseKey(Node target, int newkey){
        target.key = newkey;
        if(target.parent == null){
            if(target.key < minroot.key) minroot = target;
        } else if(target.key < target.parent.key) decreaseKey(target);
    }

    private void decreaseKey(Node target){
        if(target == target.next) target.parent.child = null;
        else target.parent.child = target.next;
        target.marked = UNMARK;
        target.deg = 0;
        target.next.prev = target.prev;
        target.prev.next = target.next;
        resetdgree(target);
        minroot.next.prev = target;
        target.next = minroot.next;
        target.prev = minroot;
        minroot.next = target;
        Node parent = target.parent;
        target.parent = null;
        if(minroot.key > target.key) minroot = target;
        if(parent.marked) decreaseKey(parent);
        else parent.marked = MARK;
    }

    public void delete(Node target){
        decreaseKey(target, Integer.MIN_VALUE);
        deleteMin();
    }

    private void resetdgree(Node cur){
        if(cur.deg == 0) cur = cur.child;
        if(cur == null) return;
        cur.deg = cur.parent.deg + 1;
        for(Node e = cur.next; e != cur; e = e.next){
            e.deg = e.parent.deg + 1;
            resetdgree(e.child);
        }
    }

    private void min(Node cur){
        if(cur == minroot) return;
        if(cur.key < minroot.key) minroot = cur;
        min(cur.next);
    }

    private int dgree(Node cur){
        if(cur.child == null) return cur.deg;
        int dgree = 0;
        queue q = new queue();
        q.enqueue(cur.child);
        while(!q.isEmpty()){
            Node ep = q.dequeue();
            if(ep.deg > dgree) dgree = ep.deg;
            if(ep.child != null) q.enqueue(ep.child);
            for(Node e = ep.next; e != ep ; e = e.next){
                if(e.child != null) q.enqueue(e.child);
            }
        }
        return dgree;
    }

    private void downdgree(Node cur){
        if(cur == null) return;
        if(cur.deg == 0) return;
        cur.deg--;
        for(Node e = cur.next; e != cur; e = e.next){
            e.deg--;
            downdgree(e.child);
        }
    }

    private void updgree(Node cur){
        if(cur.deg == 0){
            cur.deg++;
            cur = cur.child;
        }
        if(cur == null) return;
        cur.deg++;
        for(Node e = cur.next; e != cur; e = e.next){
            e.deg++;
            updgree(e.child);
        }
    }

    private void union(Node[] D, Node cur) {
        int index = dgree(cur);
        if (D[index] != null && D[index] != cur) {
            if (D[index].key > cur.key) {
                updgree(D[index]);
                D[index].prev.next = D[index].next;
                D[index].next.prev = D[index].prev;
                if (cur.child == null) {
                    cur.child = D[index];
                    D[index].parent = cur;
                    D[index].next = D[index];
                    D[index].prev = D[index];
                } else {
                    D[index].parent = cur;
                    cur.child.next.prev = D[index];
                    D[index].next = cur.child.next;
                    cur.child.next = D[index];
                    D[index].prev = cur.child;
                }
                D[index] = null;
                union(D, minroot);
            } else if(D[index].key < cur.key){
                updgree(cur);
                cur.prev.next = cur.next;
                cur.next.prev = cur.prev;
                if (D[index].child == null) {
                    D[index].child = cur;
                    cur.parent = D[index];
                    cur.next = cur;
                    cur.prev = cur;
                } else {
                    cur.parent = D[index];
                    D[index].child.next.prev = cur;
                    cur.next = D[index].child.next;
                    D[index].child.next = cur;
                    cur.prev = D[index].child;
                }
                D[index] = null;
                union(D, minroot);
            }
        } else {
            D[index] = cur;
            if(cur == cur.next) return;
            if(cur == minroot.prev) return;
            else union(D, cur.next);
        }
    }
}
