package robertcinciuc.tree;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BinaryTree {

    protected BinaryTreeNode head;

    public BinaryTree(int data){
        this.head = new BinaryTreeNode();
        this.head.setData(data);
    }

    public void insert(int data, BinaryTreeNode node){
//        Case where the head is null
        if(node == null){
            BinaryTreeNode newNode = new BinaryTreeNode();
            newNode.setData(data);
            this.head = newNode;
        }else{

            if(data < node.getData()){
                if(node.getLeft() == null){
                    BinaryTreeNode newLeft = new BinaryTreeNode();
                    newLeft.setData(data);
                    node.setLeft(newLeft);
                }else{
                    this.insert(data, node.getLeft());
                }
            }else{
                if(node.getRight() == null){
                    BinaryTreeNode newRight = new BinaryTreeNode();
                    newRight.setData(data);
                    node.setRight(newRight);
                }else{
                    this.insert(data, node.getRight());
                }
            }
        }
    }

    public void printPreorder(BinaryTreeNode node){
        if(node != null){
            printPreorder(node.getLeft());
            System.out.println(node.getData());
            printPreorder(node.getRight());
        }
    }
}
