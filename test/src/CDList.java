public class CDList { //list class
    public CDNode first; //start node
    public CDList(){
        first = null;
    }
    public void append(int x){ //append and change of the node
        CDNode pos;
        pos = new CDNode();
        pos.data = x;
        if(first == null){
            pos.next = pos;
            pos.prev = pos;
            first = pos;
            return;
        }
        else{
            pos.next = first;
            pos.prev = first.prev;
            first.prev.next = pos;
            first.prev = pos;
            //first = pos;
            return;
        }
    }

    public CDIter getIter(){
        return new CDIter(first);
    } //get literator
}
