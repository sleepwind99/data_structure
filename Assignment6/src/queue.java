public class queue {
    public LList q;
    public queue(){q = new LList();}
    public boolean isEmpty(){return q.isEmpty();}
    public void enqueue(Node e){q.insert(e);}
    public Node dequeue(){return q.delete();}
}
