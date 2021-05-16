package robertcinciuc.structures.trie;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.*;

@Getter
@Setter
@ToString
public class Trie {

    private TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }

    public void insert(String key, TrieNode trieNode) {

        int pos = key.charAt(0) - 'a';
        if (trieNode.getChildren()[pos] == null) {
            trieNode.getChildren()[pos] = new TrieNode();

            if (key.length() == 1) {
                trieNode.getChildren()[pos].setEndOfWord(true);
            }
        }

        if(key.length() > 1){
            this.insert(key.substring(1), trieNode.getChildren()[pos]);
        }
    }

//   TODO: figure out how to show each branch of the graph in correct order and level
//    public void printOnLevels(){
//
//        LinkedList<TrieNodeWithPos> queue = new LinkedList<TrieNodeWithPos>();
//        queue.add(new TrieNodeWithPos(this.root, 'a', this.getNbChildren(this.root)));
//
//        while(queue.size() > 0){
//
////            Get and remove head from queue
//            TrieNodeWithPos node = queue.poll();
//
////            Add all its non null children to queue
//            int i = 0;
//            for(TrieNode child: node.trieNode.getChildren()){
//                if(child != null){
//                    queue.add(new TrieNodeWithPos(child, (char)(i + 'a')));
//                }
//                i += 1;
//            }
//
//            if( node.trieNode == this.root){
//                System.out.print("ROOT");
//            }else{
//                System.out.print(node.letter + " ");
//            }
//
//            System.out.println();
//        }
//    }

//    Print all words in the dictionary
    public void printWords(String keySoFar, TrieNode trieNode, int pos){

        if(trieNode.isEndOfWord() && pos != -1){
            System.out.println(keySoFar);
        }

        int count = 0;
        for(TrieNode node: trieNode.getChildren()){
            if(node != null){
                printWords(keySoFar + (char)(count + 'a'), node, count);
            }
            count += 1;
        }
    }

    public int getNbChildren(TrieNode trieNode){
        int count = 0;
        for(TrieNode node: trieNode.getChildren()){
            if(node != null){
                count += 1;
            }
        }

        return count;
    }

}

class TrieNodeWithPos{

    public TrieNode trieNode;
    public char letter;
    public int len;

    public TrieNodeWithPos(TrieNode node, char pos, int len){
        this.trieNode = node;
        this.letter = pos;
        this.len = len;
    }
}
