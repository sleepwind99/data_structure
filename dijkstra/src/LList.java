public class LList {
    public vertex start;
    public int[] dest;
    public LList(){start = null;}
    public LList(int[] dt, int num){
        dest = new int[num];
        for(int i = 0; i < num; i++) dest[i] = dt[i];
    }
    public void insertver(int k){
        vertex newver = new vertex(k);
        if(start == null){
            start = newver;
            return;
        }
        newver.next = start;
        start = newver;
    }

    public void insert(int v){
        vertex newver = new vertex(v);
        if(start == null){
            start = newver;
            return;
        }
        if(dest[start.v] > dest[v]){
            newver.next = start;
            start = newver;
            return;
        }
        if(start.next == null){
            start.next = newver;
            return;
        }
        insert(start, newver);
    }
    private void insert(vertex cur, vertex ver){
        if(cur.next == null){
            cur.next = ver;
            return;
        }
        if(dest[cur.next.v] > dest[ver.v]){
            ver.next = cur.next;
            cur.next = ver;
            return;
        }
        insert(cur.next,ver);
    }

    public int delete(){
        if(start == null) return Integer.MAX_VALUE;
        vertex ver = start;
        start = start.next;
        return ver.v;
    }
}
