package robertcinciuc.problems.leetcode.dp;

public class ClimbingStairs {

    public int climbStairs(int n) {

        int[] steps = new int[n];
        for(int i = 0; i < n; ++i){
            steps[i] = -1;
        }
        steps[0] = 1;

        if(steps.length > 1){
            steps[1] = 2;
        }

        return recursiveSearch(n - 1, steps);
    }

    public int recursiveSearch(int x, int[] steps){
        if(steps[x] == -1){
            int below = recursiveSearch(x - 1, steps);
            int below2 = recursiveSearch(x - 2, steps);
            steps[x] = below + below2;
        }

        return steps[x];
    }

    public static void main(String[] args) {
        var v = new ClimbingStairs();
        System.out.println(v.climbStairs(2));
        System.out.println(v.climbStairs(3));
        System.out.println(v.climbStairs(4));
    }
}
