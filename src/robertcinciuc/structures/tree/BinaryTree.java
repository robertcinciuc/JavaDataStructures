package robertcinciuc.structures.tree;

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

    public BinaryTreeNode findNode(BinaryTreeNode startNode, int data) throws Exception {

        if(startNode == null){
            throw new Exception("The passed node is null");
        }else{
            if(startNode.getData() == data){
                return startNode;
            }else if(data < startNode.getData()){
                return this.findNode(startNode.getLeft(), data);
            }else{
                return this.findNode(startNode.getRight(), data);
            }
        }
    }
}
