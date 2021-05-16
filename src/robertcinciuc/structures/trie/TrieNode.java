package robertcinciuc.structures.trie;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class TrieNode {

//    Array with size of number of letters in the alphabet
    private TrieNode[] children;
    private boolean isEndOfWord;

    public TrieNode(){
        this.children = new TrieNode[5];
        this.isEndOfWord = false;
    }

}
