public class HTable {
    public HEntry[] table;

    public HTable(){table = new HEntry[262139];}

    public boolean insert(int i,String s){
        int k = i % 262139;
        return insert(i,k,s);
    }

    private boolean insert(int i, int k, String s){
        if(table[k] == null){
            table[k] = new HEntry();
            table[k].i = i;
            table[k].s = s;
            table[k].deleted =false;
            return true;
        }
        if(k+1 == i) return false;
        if(table[k].i == i) return false;
        return insert(i,(k+1) % 262139,s);
    }

    public boolean delete(int i){
        int k = i % 262139;
        return delete(k,i);
    }

    private boolean delete(int k,int i){
        if(table[k] == null) return false;
        if(table[k].i == i){
            table[k].deleted = true;
            return true;
        }
        if(k+1 == i) return false;
        return delete((k+1) % 262139,i);
    }

    public String query(int i){
        int k = i % 262139;
        return query(k,i);
    }

    private String query(int k, int i){
        if(table[k] == null) return null;
        if(table[k].i == i && table[k].deleted) return null;
        if(table[k].i == i) return table[k].s;
        if(k+1 == i) return null;
        return query((k+1) % 262139,i);
    }
}
