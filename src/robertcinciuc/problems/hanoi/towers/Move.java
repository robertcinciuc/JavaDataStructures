package robertcinciuc.problems.hanoi.towers;

import lombok.Data;

@Data
public class Move {
    private final int depthElem;
    private final int deltaCurrPos;
    private final int deltaDestPos;

    public Move(int depthElem, int deltaCurrPos, int deltaDestPos){
        this.depthElem = depthElem;
        this.deltaCurrPos = deltaCurrPos;
        this.deltaDestPos = deltaDestPos;
    }
}
