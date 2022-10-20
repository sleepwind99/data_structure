public class Edge {
    public int weight, start, end;
    public Edge next;
    public Edge(int x, int y, int s){
        start = x;
        end = y;
        weight = s;
    }
}
