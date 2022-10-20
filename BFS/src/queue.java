class queue {
    public LList q;
    public queue(){q = new LList(); }
    public void enqueue(int x){ q.insert(x);}
    public int dequeue(){ return q.delete();}
    public boolean empty(){return q.empty();}
}
