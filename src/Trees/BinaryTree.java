package Trees;

/**
 * Created by ogheneruona on 3/17/16.
 */
// Designs a binarytree structure that
public class BinaryTree {
    Node root;

    public BinaryTree(){
        root = null;
    }
    public BinaryTree(int key, String data){
        root = new Node(key,data);
    }


    public boolean isEmpty(){
        return root == null;
    }

    public void add(int key, String value){
        Node newNode = new Node(key,value);
        if (this.root == null){
            this.root = newNode;
            return;
        }

        else{
            Node focusNode = root;
            Node Parent;
            while(true){
                Parent = focusNode;
                if (key < focusNode.key){
                    focusNode = focusNode.leftChild;
                    if (focusNode == null){
                        Parent.leftChild = newNode;
                        return;
                    }
                }

                else{

                    focusNode = focusNode.rightChild;
                    if (focusNode == null){
                        Parent.rightChild = newNode;
                        return;
                    }
                }
            }
        }
    }


    public boolean isaLeaf(){
        return (root.rightChild == null && root.leftChild == null);
    }

    public void display(){
        Inorderdisplay(this.root);
    }
    public void Inorderdisplay(Node focusNode){
        if (focusNode != null){
            Inorderdisplay(focusNode.leftChild);
            System.out.println(focusNode);
            Inorderdisplay(focusNode.rightChild);
        }


    }


    public static void main(String[] args){
        //Create number binary tree and add a whole bunch of numbers
        BinaryTree btree = new BinaryTree();
        btree.add(5,"Ruona");
        btree.add(7,"Tega");
        btree.add(10,"Ovo");
        btree.add(1,"Rose");
        btree.add(5,"Ighome");
        btree.add(9,"Kevwe");

        btree.display();
    }




}

// Class is used to define a Node
//  A node consist of an element a
//  reference to the left node
//	reference to the right node
class Node{
    // field
    int key;
    String data;
    Node leftChild;
    Node rightChild;

    public Node(int key, String value){
        this.key = key;
        this.data = value;
    }
    
    public String toString(){
        return  new String("" + data + " has a key " + key);
    }
//    public String value(){
//        return this.data;
//    }
}
