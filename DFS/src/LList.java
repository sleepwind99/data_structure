class LList {
    public Node start;
    public Node end;

    public LList(){
        start = null;
        end = null;
    }

    public void insert(int x){
        Node newnode = new Node();
        newnode.v = x;
        if(start == null){
            start = newnode;
            end = newnode;
            return;
        }
        end.next = newnode;
        end = newnode;
    }
    public int delete(){
        int k = start.v;
        start = start.next;
        if(start == null) end = null;
        return k;
    }
    public boolean empty(){ return (start == null); }
}
