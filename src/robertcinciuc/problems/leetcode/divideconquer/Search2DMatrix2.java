package robertcinciuc.problems.leetcode.divideconquer;

public class Search2DMatrix2 {

    public boolean searchMatrix(int[][] matrix, int target) {
        return recursiveSearch(matrix, 0, matrix[0].length - 1, matrix.length - 1, 0, target);
    }

    public boolean recursiveSearch(int[][] matrix, int top, int right, int bottom, int left, int target){
        if(top >= bottom && right <= left){
            return matrix[top][left] == target;
        }else if(matrix[top][left] == target || matrix[top][right] == target || matrix[bottom][left] == target || matrix[bottom][right] == target) {
            return true;
        }else{
            top = topDown(matrix, top, right, bottom, left, target);
            if(top >= matrix.length){
                return false;
            }
            bottom = bottomUp(matrix, top, right, bottom, left, target);
            if(bottom < 0 ){
                return false;
            }
            left = leftRight(matrix, top, right, bottom, left, target);
            if(left >= matrix[0].length){
                return false;
            }
            right = rightLeft(matrix, top, right, bottom, left, target);
            if(right < 0){
                return false;
            }

            return recursiveSearch(matrix, top, right, bottom, left, target);
        }
    }

    public int topDown(int[][] matrix, int top, int right, int bottom, int left, int target){
        while(top < matrix.length && matrix[top][right] < target){
            top++;
        }

        return top;
    }

    public int bottomUp(int[][] matrix, int top, int right, int bottom, int left, int target){
        while(bottom >= 0 && matrix[bottom][left] > target){
            bottom--;
        }

        return bottom;
    }

    public int leftRight(int[][] matrix, int top, int right, int bottom, int left, int target){
        while(left < matrix[bottom].length &&  matrix[bottom][left] < target){
            left++;
        }

        return left;
    }

    public int rightLeft(int[][] matrix, int top, int right, int bottom, int left, int target){
        while(right >= 0 && matrix[top][right] > target){
            right--;
        }

        return right;
    }

    public static void main(String[] args) {
        var v = new Search2DMatrix2();
        System.out.println(v.searchMatrix(new int[][]{{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}}, 5));
        System.out.println(v.searchMatrix(new int[][]{{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}}, 20));
        System.out.println(v.searchMatrix(new int[][]{{1,1}}, 0));
        System.out.println(v.searchMatrix(new int[][]{{1,1}}, 1));
    }
}
