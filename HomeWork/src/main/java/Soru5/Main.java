package Soru5;
 enum COLOR{
    RED,BLACK
};

 class RedBlackNode{
    int element;
    COLOR color;
    RedBlackNode left,right,parent;

    public RedBlackNode(int element)
    {
        this.element = element;
        this.left = this.right = this.parent = null;
        this.color = COLOR.RED;
    }
}

 class RedBlackTree{
    RedBlackNode root;
    public RedBlackTree(){
        root = null;
    }
    public RedBlackNode addToBinarySearchTree(RedBlackNode root, RedBlackNode node){
        if(root == null)return  node;

        if(node.element < root.element){
            root.left = addToBinarySearchTree(root.left, node);
            root.left.parent = root;
        }
        else if(node.element > root.element){
            root.right = addToBinarySearchTree(root.right, node);
            root.right.parent = root;
        }

        return root;
    }
    public void rotateLeft(RedBlackNode root, RedBlackNode node)
    {
        RedBlackNode right = node.right;

        node.right = right.left;

        if (node.right != null)
            node.right.parent = node;

        right.parent = node.parent;

        if(node.parent == null)
            this.root = right;

        else if(node == node.parent.left)
            node.parent.left = right;

        else
            node.parent.right = right;

        right.left = node;
        node.parent = right;
    }

    void rotateRight(RedBlackNode root, RedBlackNode node)
    {
        RedBlackNode left = node.left;

        node.left = left.right;

        if (node.left != null)
            node.left.parent = node;

        left.parent = node.parent;

        if (node.parent == null)
            this.root = left;

        else if (node == node.parent.left)
            node.parent.left = left;

        else
            node.parent.right = left;

        left.right = node;
        node.parent = left;
    }



     void inorder(RedBlackNode root)
    {
        if (root == null)
            return;

        inorder(root.left);
        System.out.print(root.element+ " ");
        inorder(root.right);
    }
    public void printTree(){
        inorder(this.root);
    }
    public void insert(int element){
        RedBlackNode node = new RedBlackNode(element);
        this.root = addToBinarySearchTree(this.root, node);
        RedBlackNode parent,grandParent = null;

        while((node != root) && (node.color != COLOR.BLACK) &&
                    (node.parent.color == COLOR.RED)){

            parent = node.parent; grandParent = node.parent.parent;
            if (parent == grandParent.left){
                RedBlackNode uncle = grandParent.right;
                if (uncle != null && uncle.color == COLOR.RED){
                    uncle.color = parent.color = COLOR.BLACK;
                    grandParent.color = COLOR.RED;
                    node = grandParent;
                }
                else{
                    if (node == parent.right){
                        rotateLeft(this.root,parent);
                        node = parent;
                        parent = node.parent;
                    }
                    rotateRight(this.root, grandParent);
                    COLOR tempColor =parent.color;
                    parent.color = grandParent.color;
                    grandParent.color = tempColor;
                    node = parent;
                }
            }
            else{
                RedBlackNode uncle = grandParent.left;
                if (uncle != null && uncle.color == COLOR.RED){
                    grandParent.color = COLOR.RED;
                    parent.color= uncle.color = COLOR.BLACK;
                    node = grandParent;
                }
                else{
                    if(node == parent.left){
                        rotateRight(this.root, parent);
                        node = parent;
                        parent = node.parent;
                    }
                    rotateLeft(this.root, grandParent);
                    COLOR tempColor =parent.color;
                    parent.color = grandParent.color;
                    grandParent.color = tempColor;
                    node = parent;
                }
            }
        }
        this.root.color = COLOR.BLACK;
    }

}

class MinHeap{
    RedBlackNode root  = null;

    public MinHeap(){
        GenarateMinHeap();
    }

    public RedBlackNode GenarateMinHeap(){
        root = new RedBlackNode(1);
        root.left = new RedBlackNode(2);
        root.right = new RedBlackNode(3);
        root.left.left = new RedBlackNode(4);
        root.left.right = new RedBlackNode(5);
        root.right.left = new RedBlackNode(6);
        root.right.right = new RedBlackNode(7);

        return root;
    }
}

public class Main {


    public static void main(String args[]){

        int heap[] = { 1, 5, 3, 4, 6, 11, 10, 9, 8, 22, 15 };

        RedBlackTree rbt = heapToRBT(heap);
        rbt.printTree();
    }
    public static RedBlackTree heapToRBT(int heap[]){
        RedBlackTree tree = new RedBlackTree();

        for (int i=0;i<heap.length;i++){
            tree.insert(heap[i]);
        }
        return tree;
    }

}
