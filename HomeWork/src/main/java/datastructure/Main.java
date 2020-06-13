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


public class Main {

    public static void main(String[] args) {

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
    }
}
