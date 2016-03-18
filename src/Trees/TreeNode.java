package Trees;

/**
 * Created by ogheneruona on 3/17/16.
 */


/**
 * Used in modeling a Tree data structure
 */
public class TreeNode {
    private int item;
    private TreeNode left;
    private TreeNode right;

    public TreeNode(int item) {
        this.item = item;
        left = null;
        right = null;
    }

    public TreeNode(int item, TreeNode left, TreeNode right) {
        this.item = item;
        this.right = right;
        this.left = left;
    }

    public int getItem() {
        return item;
    }

    public void setItem(int item) {
        this.item = item;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    /**
     *
     * @return   true of tree Node is a leaf Node
     */
    public boolean isaleaf(){
        return (this.right == null && this.left==null) ;
    }


    // adds an element into the binary tree

    public void add(TreeNode subroot, int data){
//        if (subroot == null){
//            subroot = new TreeNode(data);
//            ;
//        }
//
//        else{
//            if (data < subroot.getItem())
//                add(subroot.getLeft(),data);
//            else{
//                add(subroot.getRight(),data);
//            }
//
//        }
        TreeNode cur = subroot;
        while (!cur.isaleaf()){
            if (data < cur.getItem()){
                cur = cur.getLeft();
            }
            else{
                cur = cur.getRight();
            }
        }


    }

    /**
     * Print the root in an in order display Pattern
     * @param root
     */
    public static void inorderdisplay(TreeNode root){
        if (root == null)
            return;
        else{
            inorderdisplay(root.getLeft());
            System.out.println(root.getItem());
            inorderdisplay(root.getRight());
        }
    }

    public static void main(String[] args){
        TreeNode btree = new TreeNode(5);
        btree.add(btree,4);
        // btree.add(btree,7);
        // btree.add(1);
        // btree.add(10);
        // btree.add(5);
        // btree.add(9);

        TreeNode.inorderdisplay(btree);
    }
}