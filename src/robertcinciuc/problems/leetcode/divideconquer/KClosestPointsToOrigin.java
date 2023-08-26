package robertcinciuc.problems.leetcode.divideconquer;

import java.util.*;

public class KClosestPointsToOrigin {

    static class Pair{
        Integer x;
        Integer y;

        public Pair(Integer x, Integer y){
            this.x = x;
            this.y = y;
        }
    }

    public int[][] kClosest(int[][] points, int k) {


        Map<Double, List<Pair>> closest = new TreeMap<>();
        for (int[] point : points) {
            double dist = Math.sqrt(Math.pow(point[0], 2) + Math.pow(point[1], 2));
            if(!closest.containsKey(dist)){
                closest.put(dist, new ArrayList<>());
            }
            closest.get(dist).add(new Pair(point[0], point[1]));
        }

        List<Pair> respTmp = new ArrayList<>();
        int i = 0;
        for(Double dist: closest.keySet()){
            if(i < k){
                while(closest.get(dist).size() > 0){
                    if(i < k){
                        respTmp.add(closest.get(dist).remove(0));
                        ++i;
                    }else{
                        break;
                    }
                }
            }
        }

        int[][] resp = new int[respTmp.size()][2];
        for(i = 0; i < respTmp.size(); ++i){
            resp[i][0] = respTmp.get(i).x;
            resp[i][1] = respTmp.get(i).y;
        }

        return resp;
    }

    public static void main(String[] args) {
        var v = new KClosestPointsToOrigin();
        System.out.println(Arrays.deepToString(v.kClosest(new int[][]{{3, 3}, {5, -1}, {-2, 4}}, 2)));
        System.out.println(Arrays.deepToString(v.kClosest(new int[][]{{0, 1}, {1, 0}}, 2)));
    }
}
