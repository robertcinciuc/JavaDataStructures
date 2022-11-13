package robertcinciuc.problems;

import lombok.Data;

import java.util.LinkedList;
import java.util.Queue;

public class PaintFill {

    public void fillWithPaintIterative(Color[][] screen, Color color){
        Queue<Point> pointsToVisit = new LinkedList<>();
        pointsToVisit.add(new Point(0, 0));

        while(pointsToVisit.size() > 0){
            Point currPoint = pointsToVisit.poll();
            screen[currPoint.i][currPoint.j] = color;
            addNeighbors(currPoint.i, currPoint.j, screen, color, pointsToVisit);
        }
    }

    public void addNeighbors(int i, int j, Color[][] screen, Color color, Queue<Point> pointsToVisit){
        if(j - 1 >= 0 && screen[i][j-1] != color){
            pointsToVisit.add(new Point(i, j-1));
        }
        if(j + 1 < screen[0].length && screen[i][j+1] != color){
            pointsToVisit.add(new Point(i, j+1));
        }

        if(i - 1 >= 0 && screen[i-1][j] != color){
            pointsToVisit.add(new Point(i-1, j));
        }
        if(i + 1 < screen.length && screen[i+1][j] != color){
            pointsToVisit.add(new Point(i+1, j));
        }

        if(i - 1 >= 0){
            if(j - 1 >= 0 && screen[i-1][j-1] != color){
                    pointsToVisit.add(new Point(i-1, j-1));
            }
            if(j + 1 < screen[0].length && screen[i-1][j+1] != color){
                pointsToVisit.add(new Point(i-1, j+1));
            }
        }

        if(i + 1 < screen.length){
            if(j - 1 >= 0 && screen[i+1][j-1] != color){
                pointsToVisit.add(new Point(i+1, j-1));
            }
            if(j + 1 < screen[0].length && screen[i+1][j+1] != color){
                pointsToVisit.add(new Point(i+1, j+1));
            }
        }
    }

    public enum Color{
        Black, White
    }

    @Data
    public static class Point{
        private int i;
        private int j;

        public Point(int i, int j){
            this.i = i;
            this.j = j;
        }
    }

    public static void printScreen(Color[][] screen){
        for(int i = 0; i < screen.length; ++i){
            for(int j = 0; j < screen[0].length; ++j){
                System.out.print(screen[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args){
        Color[][] screen = new Color[10][10];
        for(int i = 0; i < screen.length; ++i){
            for(int j = 0; j < screen[0].length; ++j){
                screen[i][j] = Color.Black;
            }
        }

        PaintFill paintFill = new PaintFill();
        printScreen(screen);
        paintFill.fillWithPaintIterative(screen, Color.White);
        System.out.println();
        printScreen(screen);
    }
}
