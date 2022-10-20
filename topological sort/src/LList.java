public class LList {
    public vertex start;
    public LList(){start = null;}
    public void insertver(int k){
        vertex newver = new vertex(k);
        if(start == null){
            start = newver;
            return;
        }
        newver.next = start;
        start = newver;
    }
}
