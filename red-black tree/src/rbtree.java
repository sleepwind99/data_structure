public class rbtree {
    static boolean RED = true;
    static boolean BLACK = false;
    public Node root;
    public rbtree(){root = null;}

    public void Rrotate(Node cur){
        Node newnode = cur.left.right;
        if(cur.parent != null){
            if(isRChild(cur)){
                cur.parent.right = cur.left;
                cur.left.parent = cur.parent;
            }else{
                cur.parent.left = cur.left;
                cur.left.parent = cur.parent;
            }
        }
        cur.left.right = cur;
        cur.parent = cur.left;
        cur.left = newnode;
        if(newnode == null) return;
        newnode.parent = cur;
    }

    public void Lrotate(Node cur){
        Node newnode = cur.right.left;
        if(cur.parent != null){
            if(isRChild(cur)){
                cur.parent.right = cur.right;
                cur.right.parent = cur.parent;
            }else{
                cur.parent.left = cur.right;
                cur.right.parent = cur.parent;
            }
        }
        cur.right.left = cur;
        cur.parent = cur.right;
        cur.right = newnode;
        if(newnode == null) return;
        newnode.parent = cur;
    }

    public void swap(Node x, Node y){
        int k = x.key;
        x.key = y.key;
        y.key = k;
    }

    public boolean find(int x){
        if(root == null) return false;
        if(root.key == x) return true;
        if(root.key > x) return find(x,root.left);
        else return find(x,root.right);
    }

    private boolean find(int x,Node cur){
        if(cur == null) return false;
        if(cur.key == x) return true;
        if(cur.key > x) return find(x,cur.left);
        else return find(x, cur.right);
    }

    private boolean bothblack(Node cur){
        if(cur.left == null && cur.right == null) return true;
        if(cur.left != null && cur.left.color) return false;
        if(cur.right != null && cur.right.color) return false;
        return true;
    }

    private boolean Rblack(Node cur){
        if(cur.left == null) return false;
        if(cur.left.color){
            if(cur.right == null) return true;
            if(!cur.right.color) return true;
            return false;
        }
        return false;
    }

    private boolean Lblack(Node cur){
        if(cur.right == null) return false;
        if(cur.right.color){
            if(cur.left == null) return true;
            if(!cur.left.color) return true;
            return false;
        }
        return false;
    }

    private boolean isRChild(Node cur){
        if(cur.parent == null) return false;
        if(cur.parent.right == null) return false;
        if(cur.parent.right == cur) return true;
        return false;
    }

    private boolean isLChild(Node cur){
        if(cur.parent == null) return false;
        if(cur.parent.left == null) return false;
        if(cur.parent.left == cur) return true;
        return false;
    }

    public void insert(int x){
        Node newnode = new Node();
        newnode.key = x;
        if(root == null)root = newnode;
        else {
            newnode.color = RED;
            insert(newnode, root);
            if (isLChild(newnode.parent)) Linsert(newnode);
            else Rinsert(newnode);
        }
        root.color = BLACK;
    }

    private void insert(Node newnode, Node cur){
        if(cur.key == newnode.key) return;
        if(cur.key > newnode.key){
            if(cur.left == null){
                cur.left = newnode;
                newnode.parent = cur;
            }else insert(newnode, cur.left);
        }
        else{
            if(cur.right == null){
                cur.right = newnode;
                newnode.parent = cur;
            }else insert(newnode, cur.right);
        }
    }

    private void Linsert(Node x){
        if(root == x || x.parent.color == BLACK) return;
        Node gp = x.parent.parent;
        if(gp == null) return;
        Node uncle = gp.right;
        if(uncle == null || uncle.color == BLACK){
            if(isRChild(x)){
                Lrotate(x.parent);
                x = x.parent;
            }
            x.parent.color = BLACK;
            gp.color = RED;
            Rrotate(gp);
        }
        else{
            uncle.color = x.parent.color = BLACK;
            gp.color = RED;
            x = gp;
            if(x.parent == null) return;
            if(isRChild(x.parent)) Rinsert(x);
            else Linsert(x);
        }
    }

    private void Rinsert(Node x){
        if(root == x || x.parent.color == BLACK) return;
        Node gp = x.parent.parent;
        if(gp == null) return;
        Node uncle = gp.left;
        if(uncle == null || uncle.color == BLACK){
            if(isLChild(x)){
                Rrotate(x.parent);
                x = x.parent;
            }
            x.parent.color = BLACK;
            gp.color = RED;
            Lrotate(gp);
        }
        else{
            uncle.color = x.parent.color = BLACK;
            gp.color = RED;
            x = gp;
            if(x.parent == null) return;
            if(isRChild(x.parent)) Rinsert(x);
            else Linsert(x);
        }
    }

    public void delete(int x){
        if(!find(x)) return;
        Node newnode = delete(x, root);
        if(newnode == null) return;
        if(isLChild(newnode)) Ldelete(newnode);
        else Rdelete(newnode);
        newnode.color = BLACK;
    }

    private Node delete(int x,Node cur) {
        if (cur.key == x) {
            if (cur.right == null && cur.left == null) {
                if(cur.parent == null){
                    root = null;
                    return null;
                }
                if (isRChild(cur)) cur.parent.right = null;
                else cur.parent.left = null;
                return null;
            }
            if (cur.left == null) {
                if(cur.parent == null){
                    cur.right.parent = null;
                    root = cur.right;
                    return cur.right;
                }
                if (isRChild(cur)) cur.parent.right = cur.right;
                else cur.parent.left = cur.right;
                cur.right.parent = cur.parent;
                if(cur.color) return null;
                return cur.right;
            }
            if (cur.right == null) {
                if(cur.parent == null){
                    cur.left.parent = null;
                    root = cur.left;
                    return cur.left;
                }
                if (isRChild(cur)) cur.parent.right = cur.left;
                else cur.parent.left = cur.left;
                cur.left.parent = cur.parent;
                if(cur.color) return null;
                return cur.left;
            }
            Node dp = cur.left.right;
            if(dp == null){
                if(cur.parent == null){
                    cur.left.parent = null;
                    root = cur.left;
                    return cur.left;
                }
                if (isRChild(cur)) cur.parent.right = cur.left;
                else cur.parent.left = cur.left;
                cur.left.parent = cur.parent;
                cur.left.right = cur.right;
                cur.right.parent = cur.left;
                if(cur.color) return null;
                return cur.left;
            }
            while (dp.right != null) dp = dp.right;
            swap(dp, cur);
            dp.parent.right = dp.left;
            if(dp.left != null) dp.left.parent = dp.parent;
            if(dp.color) return null;
            return dp.left;
        } else if (cur.key > x) return delete(x, cur.left);
        else return delete(x, cur.right);
    }

    private void Ldelete(Node x){
        while(x != root && x.color == BLACK){
            Node bro = x.parent.right;
            if(bro != null && bro.color){
                bro.color = BLACK;
                x.parent.color = RED;
                Lrotate(x.parent);
            }
            else{
                if(bothblack(bro)){
                    bro.color = RED;
                    x = x.parent;
                }
                else{
                    if(Rblack(bro)){
                        bro.left.color = BLACK;
                        bro.color = RED;
                        Rrotate(bro);
                    }
                    boolean tmp = bro.color;
                    bro.color = x.parent.color;
                    x.parent.color = tmp;
                    bro.right.color = BLACK;
                    Lrotate(x.parent);
                    x = root;
                }
            }
        }
    }

    private void Rdelete(Node x){
        while(x != root && x.color == BLACK){
            Node bro = x.parent.left;
            if(bro != null && bro.color){
                bro.color = BLACK;
                x.parent.color = RED;
                Rrotate(x.parent);
            }
            else{
                if(bothblack(bro)){
                    bro.color = RED;
                    x = x.parent;
                }
                else{
                    if(Lblack(bro)){
                        bro.left.color = BLACK;
                        bro.color = RED;
                        Lrotate(bro);
                    }
                    boolean tmp = bro.color;
                    bro.color = x.parent.color;
                    x.parent.color = tmp;
                    bro.left.color = BLACK;
                    Rrotate(x.parent);
                    x = root;
                }
            }
        }
    }
}