public class estack {
    public eLList sl;
    public estack(){sl = new eLList();}
    public boolean isempty(){return sl.isempty();}
    public void push(int x, int y){sl.insert(x,y);}
    public edge pop(){return sl.delete();}
}
