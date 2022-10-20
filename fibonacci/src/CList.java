public class CList {
    public Node root;
    public Node min;
    public int dgree;
    public CList(){min = root = null;}
    public boolean isEmpty(){return root == null;}
    public void insert(int k){
        Node newnode = new Node();
        newnode.key = k;
        if(isEmpty()){
            root = newnode;
            root.next = newnode;
            root.prev = newnode;
            min = newnode;
        }
        newnode.next = root.next;
        root.next.prev = newnode;
        root.next = newnode;
        newnode.prev = root;
        if(min.key > newnode.key) min = newnode;
    }
    public void combine(CList s){
        if(s.isEmpty()) return;
        if(isEmpty()){
            root = s.root;
            min = s.min;
            return;
        }
        s.root.prev.next = this.root.next;
        this.root.next.prev = s.root.prev;
        this.root.next = s.root;
        s.root.prev = this.root;
        if(this.min.key > s.min.key) this.min = s.min;
        if(s.dgree > 0){
            int k = s.dgree;
            Node[] nk = s.root.child;
            while(nk != null){

            }
            combine(k, );
        }
    }

    private void combine(int dgree,Node n){

    }

}
