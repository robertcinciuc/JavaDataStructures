package robertcinciuc.problems.leetcode.dp;

public class JumpGame {

    public boolean canJump(int[] nums) {

        int[] steps = new int[nums.length];
        for(int i = 0; i < nums.length; ++i){
            steps[i] = Integer.MAX_VALUE;
        }

        steps[0] = 0;
        for(int i = 0; i < steps.length; ++i){
            if(steps[i] != Integer.MAX_VALUE){
                for(int j = 1; j <= nums[i]; ++j){

                    if(  i + j < nums.length){
                        if(steps[i + j] > steps[i] + 1){
                            steps[i + j] = steps[i] + 1;
                        }
                    }
                }
            }
        }

        return steps[nums.length - 1] != Integer.MAX_VALUE;
    }

    public static void main(String[] args) {
        var v = new JumpGame();
        System.out.println(v.canJump(new int[]{2,3,1,1,4}));
        System.out.println(v.canJump(new int[]{3,2,1,0,4}));
        System.out.println(v.canJump(new int[]{0,2,3}));
    }

}
