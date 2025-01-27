package datastructure;

import java.util.Scanner;

class BinarySearchTree{
    private TreeNode root;
    private int size;

    public BinarySearchTree(){
        root=null;
        size=0;
    }
    public TreeNode createNewNode(int e){
        return new TreeNode(e);
    }
    public int getSize(){
        return size;
    }
    public TreeNode getRoot(){
        return this.root;
    }
    public boolean insert(int e){
        if (root == null){
            root = createNewNode(e);
        }else{
            TreeNode parent = null;
            TreeNode current = root;
            while (current != null) {
                parent = current;
                if (current.getElement() > e){
                    current = current.getLeft();

                }else if (current.getElement() < e){
                    current = current.getRight();

                }else{
                    return  false;
                }
            }
            if (parent.getElement() > e){
                parent.setLeft(createNewNode(e));
            }else if (parent.getElement() < e){
                parent.setRight(createNewNode(e));
            }
        }
        size++;
        return true;

    }
    public void inorder(TreeNode root){
        if (root == null) return;
        inorder(root.getLeft());

        System.out.print(root.getElement()+ " ");

        inorder(root.getRight());
    }

    public void preorder(TreeNode root){
        if (root==null) return;
        System.out.print(root.getElement()+ " ");
        preorder(root.getLeft());
        preorder(root.getRight());
    }
    public void postorder(TreeNode root){
        if (root ==null)return;

        postorder(root.getLeft());
        postorder(root.getRight());
        System.out.print(root.getElement()+ " ");
    }

    public boolean delete(int e){
        TreeNode parent = null;
        TreeNode current  = root;

        while (current!=null){
            if (current.getElement() > e){
                parent=current;
                current = current.getLeft();
            }
            else if(current.getElement() < e){
                parent=current;
                current = current.getRight();
            }
            else break;
        }
        if (current == null)return false;


        //CASE 1 LEFT IS NULL
        if (current.getLeft() == null){
            if (parent == null){
                root = current.getRight();
            }
            else{
                if (parent.getElement() > e)
                    parent.setLeft(current.getRight());
                else
                    parent.setRight(current.getRight());

            }
        }
        else{//CASE 2
            TreeNode parentOfRightMost = current;
            TreeNode rightMost = current.getLeft();
            while (rightMost.getRight() != null){
                parentOfRightMost = rightMost;
                rightMost = rightMost.getRight();
            }
            current.setElement(rightMost.getElement());
            if (parentOfRightMost.getRight() == rightMost)
                parentOfRightMost .setRight(rightMost.getLeft());
            else
                parentOfRightMost.setLeft(rightMost.getLeft());
        }
        size--;
        return true;
    }
    public boolean search(int e){
        TreeNode current = root;
        while (current!=null){
            if (current.getElement() > e){
                current = current.getLeft();
            }else if(current.getElement() < e){
                current = current.getRight();
            }else{
                return true;
            }
        }
        return false;
    }

    public int max(TreeNode root){
        TreeNode current = root;
        TreeNode parent = root;
        while (current!=null){
            parent=current;
            current = current.getRight();
        }
        return parent.getElement();
    }
    public int min(TreeNode root){
        TreeNode current = root;
        TreeNode parent = root;
        while (current!=null){
            parent=current;
            current = current.getLeft();
        }
        return parent.getElement();
    }


}

class TreeNode{
    private int element;
    private TreeNode left;
    private TreeNode right;

    public TreeNode(int newElement){
        this.element = newElement;
        this.left = null;
        this.right=null;
    }

    public int getElement(){
        return this.element;
    }
    public void setElement (int element){
        this.element = element;
    }
    public TreeNode getLeft(){
        return this.left;
    }
    public void setLeft(TreeNode newLeft){
        this.left = newLeft;
    }
    public TreeNode getRight(){
         return this.right;
     }
    public void setRight(TreeNode newRight){
         this.right = newRight;
     }

}



 class AVLNode {
    private int element;
    private AVLNode left;
    private AVLNode right;
    private int height;

    public AVLNode(int e) {
        element = e;
        left = null;
        right = null;
        height = 0;
    }
    public int getElement()
    {
        return element;
    }
    public void setElement(int e)
    {
        element = e;
    }
    public AVLNode getLeft()
    {
        return left;
    }
    public void setLeft(AVLNode newLeft)
    {
        left = newLeft;
    }
    public AVLNode getRight()
    {
        return right;
    }
    public void setRight(AVLNode newRight)
    {
        left = newRight;
    }
    public int getHeight()
    {
        return height;
    }
    public void setHeight(int h)
    {
        height = h;
    }


}

 class AVLTree {
    private AVLNode root;
    private static final int ALLOWED_IMBALANCE = 1;

    // Construct the tree.
    public AVLTree() {
        root = null;
    }

    // Return the height of node a or -1 if null
    private int height(AVLNode a) {
        if (a == null)
            return -1;
        else
            return a.getHeight();
    }
     public void insert(int x)
     {
         root = insert(x, root);
     }
     private AVLNode insert(int x, AVLNode t)
     {
         if(t == null)
             return new AVLNode(x);
         if(x < t.getElement())
             t.setLeft(insert(x, t.getLeft()));
         else if(x > t.getElement())
             t.setRight(insert(x, t.getRight()));
         else
             ; //Duplicate, do nothing
         return balance(t);
     }
     private AVLNode rotateWithLeftChild(AVLNode k2)
     {
         AVLNode k1 = k2.getLeft();
         k2.setLeft(k1.getRight());
         k1.setRight(k2);
         k2.setHeight(Math.max(height(k2.getLeft()), height(k2.getRight()))
                 + 1);
         k1.setHeight(Math.max(height(k1.getLeft()), k2.getHeight()) + 1);
         return k1;
     }
     private AVLNode rotateWithRightChild(AVLNode k1)
     {
         AVLNode k2 = k1.getRight();
         k1.setRight(k2.getLeft());
         k2.setLeft(k1);
         k1.setHeight(Math.max(height(k1.getLeft()), height(k1.getRight()))
                 + 1);
         k2.setHeight(Math.max(height(k2.getRight()), k1.getHeight()) + 1) ;
         return k2;
     }
     private AVLNode doubleWithLeftChild(AVLNode k3)
     {
         k3.setLeft(rotateWithRightChild(k3.getLeft()));
         return rotateWithLeftChild(k3);
     }
     private AVLNode doubleWithRightChild(AVLNode k1)
     {
         k1.setRight(rotateWithLeftChild(k1.getRight()));
         return rotateWithRightChild(k1);
     }
     private AVLNode balance(AVLNode t)
     {
         if( t == null )
             return t;
         if(height(t.getLeft()) - height(t.getRight()) > ALLOWED_IMBALANCE)
             if(height(t.getLeft().getLeft()) >= height(t.getLeft().getRight()))
                 t = rotateWithLeftChild(t);
             else
                 t = doubleWithLeftChild(t);
         else
         if(height(t.getRight()) - height(t.getLeft()) > ALLOWED_IMBALANCE)
             if(height(t.getRight().getRight()) >= height(t.getRight().getLeft()))
                 t = rotateWithRightChild(t);
             else
                 t = doubleWithRightChild(t);
         t.setHeight(Math.max(height(t.getLeft()), height(t.getRight())) + 1);
         return t;
     }
     public void printTree()
     {
         if(root == null)
             System.out.println("Empty tree");
         else
             printTree(root);
     }
     private void printTree(AVLNode t)
     {
         if(t != null)
         {
             printTree(t.getLeft());
             System.out.println(t.getElement());
             printTree(t.getRight());
         }
     }

 }

 class MaxHeap < T extends Comparable < ? super T >> {
    private T[] heap; // array of heap entries
    private int lastIndex; // index of last entry
    private static final int DEFAULT_INITIAL_CAPACITY = 25;

    public MaxHeap() //default constructor
    {
        this(DEFAULT_INITIAL_CAPACITY); // call next constructor
    }
    public MaxHeap (int initialCapacity)
    {
        T [] tempHeap = (T []) new Comparable [initialCapacity + 1];
        heap = tempHeap;
        lastIndex = 0;
    }
    public void add (T newEntry)
    {
        lastIndex++;
        int newIndex = lastIndex;
        int parentIndex = newIndex / 2;
        while((parentIndex > 0)
                && newEntry.compareTo(heap[parentIndex]) > 0)
        {
            heap [newIndex] = heap [parentIndex];
            newIndex = parentIndex;
            parentIndex = newIndex / 2;
        }
        heap [newIndex] = newEntry;
    }
    public boolean isEmpty()
    { return heap.length==0; }

    public T removeMax ()
    {
        T root = null;
        if (!isEmpty ())
        {

            root = heap [1]; // return value
            heap [1] = heap [lastIndex]; // form a semiheap
            lastIndex--; // decrease size
            reheap (1); // transform to a heap
        }
        return root;
    }
    private void reheap (int rootIndex)
    {
        boolean done = false;
        T orphan = heap [rootIndex];
        int leftChildIndex = 2 * rootIndex;
        while(!done && (leftChildIndex <= lastIndex))
        {
            int largerChildIndex = leftChildIndex; // assume larger
            int rightChildIndex = leftChildIndex + 1;
            if((rightChildIndex <= lastIndex) &&
                    heap[rightChildIndex].compareTo(heap[largerChildIndex])
                            > 0)
            {
                largerChildIndex = rightChildIndex;
            }
            if(orphan.compareTo (heap [largerChildIndex]) < 0)
            {
                heap [rootIndex] = heap [largerChildIndex];
                rootIndex = largerChildIndex;
                leftChildIndex = 2 * rootIndex;
            }
            else
                done = true;
        }
        heap [rootIndex] = orphan;
    }


}







public class Main {

    public static void main(String[] args) {

        //BinarySearchTree insert,delete,traversal(inorder,preorder,postorder and print),max,min
        //AVL tree height,insert,rotateWithLeftChild,rotateWithRightChild,doubleWithLeftChild,doubleWithRightChild,balance,print
        //More Balanced tree NO CODE
        /*
        * Heap
        * Parent(i) [i/2]
        * Left(i) = 2i
        * Right(i) = 2i+1
        * Her root childlarından küçüktür
        * */
        Scanner s = new Scanner(System.in);
        int x;
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.insert(15);
        binarySearchTree.insert(7);
        binarySearchTree.insert(8);
        binarySearchTree.insert(17);
        binarySearchTree.insert(6);



        System.out.println("inorder treversal:");
        binarySearchTree.inorder(binarySearchTree.getRoot());
        System.out.println("\npostorder treversal:");
        binarySearchTree.postorder(binarySearchTree.getRoot());
        System.out.println("\npreorder treversal:");
        binarySearchTree.preorder(binarySearchTree.getRoot());
        System.out.println();
        System.out.println("number of nodes in tree: "+binarySearchTree.getSize());
        System.out.println("Enter a number to delete from the tree:");
        x = s.nextInt();

        if (binarySearchTree.delete(x))
            System.out.println(x+" is deleted from the tree");
        else
            System.out.println(x+" is not deleted from tree");

        System.out.println("Enter a number to delete from the tree:");
        x = s.nextInt();

        if (binarySearchTree.delete(x))
            System.out.println(x+" is deleted from the tree");
        else
            System.out.println(x+" is not deleted from tree");


        System.out.println("inorder traversal after delete:");
        binarySearchTree.inorder(binarySearchTree.getRoot());
        System.out.println("\nEnter a number to search in the tree: ");
        x = s.nextInt();
        if (binarySearchTree.search(x))
            System.out.println(x+" is in the tree");
        else
            System.out.println(x+" is not in the tree");


        System.out.println("Max is :"+binarySearchTree.max(binarySearchTree.getRoot()));
        System.out.println("Min is :"+binarySearchTree.min(binarySearchTree.getRoot()));
    }
}
