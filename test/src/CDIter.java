public class CDIter { //iterator
    public CDNode cur; //current node
    CDIter(CDNode k){ //
        if(k == null) cur = null;
        else cur = k;
    }
    CDIter(){
        cur = null;
    }
    public boolean isValid(){return !(cur == null);}

    public int getValue(){
        if(isValid()) return cur.data;
        else return -1;
    }

    public boolean setValue(int x){
        if(isValid()){
            cur.data = x;
            return true;
        }
        else return false;
    }

    public int delete(){
        int cash;
        if(isValid()){
            cash = cur.data;
            if(cur.prev == cur && cur.next == cur){
                cur = null;
                return cash;
            }
            cur.next.prev = cur.prev;
            cur.prev.next = cur.next;
            cur = cur.next;
            return cash;
        }
        else return -1;
    }

    public boolean insertBefore(int x){
        CDNode pos;
        pos = new CDNode();
        if(isValid()){
            pos.data = x;
            pos.next = cur;
            pos.prev = cur.prev;
            cur.prev.next = pos;
            cur.prev = pos;
            return true;
        }
        else return false;
    }

    public boolean insertAfter(int x){
        CDNode pos;
        pos = new CDNode();
        if(isValid()){
            pos.data = x;
            pos.prev = cur;
            pos.next= cur.next;
            cur.next.prev = pos;
            cur.next = pos;
            return true;
        }
        else return false;
    }

    public void prev(){
        if(isValid()) cur = cur.prev;
        else return;
    }

    public void next(){
        if(isValid()) cur = cur.next;
        else return;
    }
}
