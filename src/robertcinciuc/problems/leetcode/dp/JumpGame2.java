package robertcinciuc.problems.leetcode.dp;

public class JumpGame2 {
    public int jump(int[] nums) {

        int[] steps = new int[nums.length];

        for(int i = 0 ; i < steps.length; ++i){
            steps[i] = -1;
        }
        steps[0] = 0;

        for(int i = 0; i < nums.length; ++i){
//            general case
            for(int j = 1; j <= nums[i]; ++j){
                if((i + j) < nums.length && (steps[i + j] > (steps[i] + 1) || steps[i + j] == -1 )){
                    steps[i + j] = steps[i] + 1;
                }
            }
        }

        return steps[steps.length - 1];
    }

    public static void main(String[] args) {
        var v = new JumpGame2();
        System.out.println(v.jump(new int[]{2,3,1,1,4}));
    }
}
