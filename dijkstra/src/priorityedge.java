public class priorityedge {
    public eLList pe;
    public priorityedge(){pe = new eLList();}
    public boolean isEmpty(){return pe.isEmpty();}
    public void insertedge(Edge e){pe.insertpq(e);}
    public Edge delete(){return pe.delete();}
    public void printedge(){
        Edge e = pe.start;
        while(e != null){
            System.out.println(e.weight);
            e = e.next;
        }
    }
}

