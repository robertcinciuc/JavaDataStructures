package robertcinciuc.problems.hanoi.towers;

import lombok.Data;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Data
public class HanoiSubResult {
    private int stackCurrPos;
    private int stackDestPos;
    private List<Move> moves;
    private boolean done;

    public HanoiSubResult(int stackCurrPos, int stackDestPos){
        this.stackCurrPos = stackCurrPos;
        this.stackDestPos = stackDestPos;
        this.moves = new ArrayList<>();
        this.done = false;
    }
}
