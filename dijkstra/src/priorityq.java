public class priorityq {
    public LList pq;
    public priorityq(int[] dt, int num){ pq = new LList(dt, num);}
    public void insert(int v){pq.insert(v);}
    public int delete(){return pq.delete();}
}
