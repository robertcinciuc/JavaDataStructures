package robertcinciuc.problems.leetcode;

public class ContainerMostWater {
    public int maxArea(int[] height) {
        int start = 0;
        int end = height.length - 1;
        int res = 0;
        for(int i = 0; i < height.length; ++i){
            if(height[start] <= height[end]){
                res = Math.max(res, height[start] * (end - start));
                start++;
            }else{
                res = Math.max(res, height[end] * (end - start));
                end--;
            }
        }

        return res;
    }

    public static void main(String[] args){
        ContainerMostWater containerMostWater = new ContainerMostWater();
        System.out.println(containerMostWater.maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }
}
