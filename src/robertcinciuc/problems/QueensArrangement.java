package robertcinciuc.problems;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

public class QueensArrangement {

    public static void printQueensArrangements(List<Position> previousPos, int i){
        if(previousPos.size() == 8){
            System.out.println(previousPos);
        }else{
            for(int j = 0; j < 8; ++j){
                boolean validCol = true;
                for(Position pos : previousPos){
                    if(pos.j == j){
                        validCol = false;
                    }
                    if(pos.j + pos.i == i + j){
                        validCol = false;
                    }
                    if(pos.i - pos.j == i - j){
                        validCol = false;
                    }
                }

                if(validCol){
                    previousPos.add(new Position(i, j));
                    printQueensArrangements(previousPos, i + 1);
                    previousPos.remove(previousPos.size() - 1);
                }
            }
        }
    }

    @Data
    private static class Position{
        private int i;
        private int j;

        public Position(int i, int j){
            this.i = i;
            this.j = j;
        }
    }

    public static void main(String[] args){
        printQueensArrangements(new ArrayList<>(), 0);
    }
}
