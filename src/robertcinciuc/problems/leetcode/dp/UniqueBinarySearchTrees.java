package robertcinciuc.problems.leetcode.dp;

public class UniqueBinarySearchTrees {

    public int numTrees(int n) {

        int[] combi = new int[n + 1];
        combi[0] = 0;
        combi[1] = 1;

        if(n == 1){
            return 1;
        }

        int tmpRes = 0;
        for(int i = 0; i < n; ++i){
            tmpRes += recursiveSearch(n, i, n - i - 1, combi);
        }

        return tmpRes;
    }

    public int recursiveSearch(int size, int toTheLeft, int toTheRight, int[] combi){
        int resLeft = 1;
        if(toTheLeft > 0) {
            if (combi[toTheLeft] == 0) {
                int tmpLeft = 0;
                for (int i = 0; i < toTheLeft; ++i){
                    tmpLeft += recursiveSearch(toTheLeft, i, toTheLeft - i - 1, combi);
                }
                combi[toTheLeft] = tmpLeft;
                resLeft = tmpLeft;
            }else{
                resLeft = combi[toTheLeft];
            }
        }

        int resRight = 1;
        if(toTheRight > 0) {
            if (combi[toTheRight] == 0) {
                int tmpRight = 0;
                for (int i = 0; i < toTheRight; ++i) {
                    tmpRight += recursiveSearch(toTheRight, i, toTheRight - i - 1, combi);
                }
                combi[toTheRight] = tmpRight;
                resRight = tmpRight;
            }else{
                resRight = combi[toTheRight];
            }
        }

        return resLeft * resRight;
    }

    public static void main(String[] args) {
        var v = new UniqueBinarySearchTrees();
        System.out.println(v.numTrees(1));
        System.out.println(v.numTrees(2));
        System.out.println(v.numTrees(3));
        System.out.println(v.numTrees(4));
    }

}
