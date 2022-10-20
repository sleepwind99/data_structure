public class priorityq {
    public LList pq;
    public priorityq(){pq = new LList();}
    public boolean isEmpty(){return pq.isEmpty();}
    public void insertedge(Edge e){pq.insertpq(e);}
    public Edge delete(){return pq.delete();}
    public void printedge(){
        Edge e = pq.start;
        while(e != null){
            System.out.println(e.weight);
            e = e.next;
        }
    }
}
