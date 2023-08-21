package robertcinciuc.problems.leetcode.dp;

public class EditDistance {

    public int minDistance(String word1, String word2) {

        if(word1.isEmpty() && word2.isEmpty()){
            return 0;
        }

        int[][] minDist = new int[word1.length() + 1][word2.length() + 1];
        for(int i = 0; i <= word1.length(); ++i){
            minDist[i][0] = i;
        }

        for(int j = 0; j <= word2.length(); ++j){
            minDist[0][j] = j;
        }

        if(word1.isEmpty()){
            return minDist[0][word2.length()];
        }

        if(word2.isEmpty()){
            return minDist[word1.length()][0];
        }

        for(int i = 1; i <= word1.length(); ++i){
            for(int j = 1; j <= word2.length(); ++j){
                minDist[i][j] = -1;
            }
        }

        recursiveSearch(1, 1,minDist, word1, word2);

        return minDist[word1.length()][word2.length()];
    }

    public void recursiveSearch(int x, int y, int[][] minDist, String w1, String w2){
        if(x <= w1.length() && y <= w2.length() && minDist[x - 1][y] != -1 && minDist[x][y - 1] != -1 && minDist[x][y] == -1){
            if(w1.charAt(x - 1) == w2.charAt(y - 1)){
                minDist[x][y] = minDist[x - 1][y - 1];
            }else{
                minDist[x][y] = Math.min(Math.min(minDist[x - 1][y], minDist[x][y - 1]), minDist[x - 1][y - 1]) + 1;
            }

            recursiveSearch(x + 1, y, minDist, w1, w2);
            recursiveSearch(x, y + 1, minDist, w1, w2);
            recursiveSearch(x + 1, y + 1, minDist, w1, w2);
        }
    }



    public static void main(String[] args) {
        var v = new EditDistance();
        System.out.println(v.minDistance("a", "b"));
        System.out.println(v.minDistance("aa", "b"));
        System.out.println(v.minDistance("horse", "ros"));
        System.out.println(v.minDistance("intention", "execution"));
        System.out.println(v.minDistance("sea", "eat"));
        System.out.println(v.minDistance("", ""));
    }
}
