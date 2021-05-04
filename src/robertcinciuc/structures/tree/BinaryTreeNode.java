package robertcinciuc.structures.tree;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BinaryTreeNode {

    private int data;
    private BinaryTreeNode left;
    private BinaryTreeNode right;

    public BinaryTreeNode(){
        this.left = null;
        this.right = null;
    }

}
