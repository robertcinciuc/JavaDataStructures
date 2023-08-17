package robertcinciuc.problems.leetcode.dp;

import java.util.HashSet;
import java.util.Set;

public class UniquePaths {

    public int uniquePaths(int m, int n) {

        Set<Integer> paths = new HashSet<>();
        Set<Integer> partialPaths = new HashSet<>();

        String initCoord = String.valueOf(0) + 0;
        partialPaths.add(initCoord.hashCode());
        StringBuilder sb = new StringBuilder();
        sb.append(initCoord);
        recursiveSearch(0, 0, m, n, paths, partialPaths, sb);

        return paths.size();
    }

    public void recursiveSearch(int x, int y, int m, int n, Set<Integer> paths, Set<Integer> partialPaths, StringBuilder currPath){
        if(x == (m - 1) && y == (n - 1)){
            paths.add(currPath.toString().hashCode());
            currPath.delete(currPath.length() - 2, currPath.length());
        }else{

            if(x < (m - 1)){
                String sX = String.valueOf(x + 1);
                String sY = String.valueOf(y);
                currPath.append(sX);
                currPath.append(sY);

                if(!partialPaths.contains(currPath.toString().hashCode())){
                    partialPaths.add(currPath.toString().hashCode());
                    recursiveSearch(x + 1, y, m, n, paths, partialPaths, currPath);
                }
            }

            if(y < (n - 1)){
                String sX = String.valueOf(x);
                String sY = String.valueOf(y + 1);
                currPath.append(sX);
                currPath.append(sY);

                if(!partialPaths.contains(currPath.toString().hashCode())){
                    partialPaths.add(currPath.toString().hashCode());
                    recursiveSearch(x, y + 1, m, n, paths, partialPaths, currPath);
                }
            }
        }
    }

    public static void main(String[] args) {
        var v = new UniquePaths();
        System.out.println(v.uniquePaths(3, 2));
        System.out.println(v.uniquePaths(3, 7));
        System.out.println(v.uniquePaths(1, 1));
    }
}
