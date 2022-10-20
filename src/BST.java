public class BST{
    public BSTNode root, cur;
    public BST(){
        root = null;
        cur = null;
    }

    public void insert(int key){
        if(root == null) {
            BSTNode newbst = new BSTNode();
            newbst.key = key;
            root = newbst;
            cur = newbst;
            return;
        }
        if (cur.key == key){
            cur = root;
            return;
        }
        if (cur.key < key) {
            if (cur.right == null) {
                BSTNode newbst = new BSTNode();
                newbst.key = key;
                cur.right = newbst;
                cur = root;
                return;
            }
            cur = cur.right;
            insert(key);
        } else if (cur.key > key) {
            if (cur.left == null) {
                BSTNode newbst = new BSTNode();
                newbst.key = key;
                cur.left = newbst;
                cur = root;
                return;
            }
            cur = cur.left;
            insert(key);
        } else return;
    }

    public boolean search(int key){
        if(root == null) return false;
        if(cur == null) {
            cur = root;
            return false;
        }
        if(cur.key < key){
            cur = cur.right;
            return search(key);
        } else if(cur.key > key){
            cur = cur.left;
            return search(key);
        } else if(cur.key == key){
            cur = root;
            return true;
        } else {
            cur = root;
            return false;
        }
    }

    public boolean delete(int key){
        if(root == null) return false;
        BSTNode fdel = new BSTNode();
        BSTNode prev = new BSTNode();
        BSTNode del = new BSTNode();
        if (cur.key < key) {
            if (cur.right == null) return false;
            if (cur.right.key == key) {
                fdel = cur;
                del = cur.right;
                cur = cur.right;
                if (cur.right == null) {
                    fdel.right = cur.left;
                    cur = root;
                    return true;
                } else {
                    cur = cur.right;
                    while (cur.left != null) {
                        prev = cur;
                        cur = cur.left;
                    }
                    fdel.right = cur;
                    prev.left = cur.right;
                    cur.left = del.left;
                    cur.right = del.right;
                    cur = root;
                    return true;
                }
            } else {
                cur = cur.right;
                return delete(key);
            }
        } else if (cur.key > key) {
            if(cur.left == null) return false;
            if (cur.left.key == key) {
                fdel = cur;
                del = cur.left;
                cur = cur.left;
                if (cur.right == null) {
                    fdel.left = cur.left;
                    cur = root;
                    return true;
                } else {
                    cur = cur.right;
                    while (cur.left != null) {
                        prev = cur;
                        cur = cur.left;
                    }
                    fdel.left = cur;
                    prev.left = cur.right;
                    cur.left = del.left;
                    cur.right = del.right;
                    cur = root;
                    return true;
                }
            } else {
                cur = cur.left;
                return delete(key);
            }
        } else if(cur.key == key) {
            del = cur;
            if (cur.right == null) {
                root = root.left;
                cur = root;
                return true;
            } else {
                cur = cur.right;
                while (cur.left != null) {
                    prev = cur;
                    cur = cur.left;
                }
                prev.left = cur.right;
                cur.right = del.right;
                cur.left = del.left;
                root = cur;
                return true;
            }
        } else {
            cur = root;
            return false;
        }
    }
}
