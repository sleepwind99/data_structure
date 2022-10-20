public class LList {
    public Node start, end;
    public LList(){start = end = null;}
    public boolean isEmpty(){return start == null;}
    public void insert(Node e){
        if(!isEmpty()){
            end.list = e;
            end = e;
            return;
        }
        start = end = e;
    }
    public Node delete(){
        if(!isEmpty()){
            Node e = start;
            start = start.list;
            if(isEmpty()) end = null;
            return e;
        }
        return null;
    }
}
