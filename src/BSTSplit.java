public class BSTSplit{
    public BST bstSmaller, bstGreater;

    public BSTSplit(){
        bstSmaller = null;
        bstGreater = null;
    }

    public void split(BST bstln, int val){
        BST newSbst = new BST();
        BST newBbst = new BST();
        if(bstln.root == null){
            bstGreater = newBbst;
            bstSmaller = newSbst;
            return;
        }
        if(bstln.root.key == val){
            newBbst.root = bstln.root.right;
            newBbst.cur = bstln.root.right;
            newSbst.root = bstln.root.left;
            newSbst.cur = bstln.root.left;
            bstGreater = newBbst;
            bstSmaller = newSbst;
            return;
        }

        while(true) {
            if (bstln.cur.key > val) {
                if(bstln.cur.left == null){
                    newSbst.root = null;
                    newSbst.cur = null;
                    bstSmaller = newSbst;
                    newBbst.root = bstln.root;
                    newBbst.cur = bstln.root;
                    bstGreater = newBbst;
                    return;
                }
                if (bstln.cur.left.key > val) bstln.cur = bstln.cur.left;
                else if (bstln.cur.left.key < val) {
                    newSbst.root = bstln.cur.left;
                    newSbst.cur = bstln.cur.left;
                    bstSmaller = newSbst;
                    bstln.cur.left = null;
                    newBbst.root = bstln.root;
                    newBbst.cur = bstln.root;
                    bstGreater = newBbst;
                    break;
                }
                else if (bstln.cur.left.key == val) {
                    newSbst.root = bstln.cur.left.left;
                    newSbst.cur = bstln.cur.left.left;
                    bstSmaller = newSbst;
                    bstln.cur.left = bstln.cur.left.right;
                    newBbst.root = bstln.root;
                    newBbst.cur = bstln.root;
                    bstGreater = newBbst;
                    return;
                }
            }
            else if (bstln.cur.key < val) {
                if(bstln.cur.right == null){
                    newBbst.root = null;
                    newBbst.cur = null;
                    bstGreater = newBbst;
                    newSbst.root = bstln.root;
                    newSbst.cur = bstln.root;
                    bstSmaller = newSbst;
                    return;
                }
                if (bstln.cur.right.key > val) {
                    newBbst.root = bstln.cur.right;
                    newBbst.cur = bstln.cur.right;
                    bstGreater = newBbst;
                    bstln.cur.right = null;
                    newSbst.root = bstln.root;
                    newSbst.cur = bstln.root;
                    bstSmaller = newSbst;
                    break;
                }
                else if (bstln.cur.right.key < val) bstln.cur = bstln.cur.right;
                else if (bstln.cur.right.key == val) {
                    newBbst.root = bstln.cur.right.right;
                    newBbst.cur = bstln.cur.right.right;
                    bstGreater = newBbst;
                    bstln.cur.right = bstln.cur.right.left;
                    newSbst.root = bstln.root;
                    newSbst.cur = bstln.root;
                    bstSmaller = newSbst;
                    return;
                }
            }
        }

        while(true){
            if(bstGreater.cur.left == null && bstSmaller.cur.right == null){
                bstGreater.cur = bstGreater.root;
                bstSmaller.cur = bstSmaller.root;
                return;
            }
            if(bstGreater.cur.left != null) {
                if (bstGreater.cur.left.key < val) {
                    bstSmaller.cur.right = bstGreater.cur.left;
                    bstGreater.cur.left = null;
                    bstSmaller.cur = bstSmaller.cur.right;
                }
                else if (bstGreater.cur.left.key > val)bstGreater.cur = bstGreater.cur.left;
                else if (bstGreater.cur.left.key == val) {
                    bstSmaller.cur.right = bstGreater.cur.left.left;
                    bstGreater.cur.left = bstGreater.cur.left.right;
                    bstGreater.cur = bstGreater.root;
                    bstSmaller.cur = bstSmaller.root;
                    return;
                }
            }
            if(bstSmaller.cur.right != null) {
                if (bstSmaller.cur.right.key < val) bstSmaller.cur = bstSmaller.cur.right;
                else if (bstSmaller.cur.right.key > val) {
                    bstGreater.cur.left = bstSmaller.cur.right;
                    bstSmaller.cur.right = null;
                    bstGreater.cur = bstGreater.cur.left;
                } else if (bstSmaller.cur.right.key == val) {
                    bstGreater.cur.left = bstSmaller.cur.right.right;
                    bstSmaller.cur.right = bstSmaller.cur.right.left;
                    bstGreater.cur = bstGreater.root;
                    bstSmaller.cur = bstSmaller.root;
                    return;
                }
            }
        }
    }
}
