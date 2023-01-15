package robertcinciuc.problems.leetcode;

public class LongestCommonSubsequence {

    public int longestCommonSubsequence(String text1, String text2) {
        int[] foundPos = new int[text1.length()];
        int[] lens = new int[text1.length()];

        for(int i = 0; i < text1.length(); ++i) {
            if(text1.charAt(0) == text2.charAt(i)){
                foundPos[0] = i;
                lens[0] = 1;
                break;
            }
        }

            for(int i = 0; i < text1.length(); ++i){
            for(int j = 0; j < i; ++j){

                int foundPrevLen = -1;
                int foundSameAtPos = -1;
                for(int k = foundPos[j]; k < text2.length(); ++k){
                    if(text1.charAt(i) == text2.charAt(k)){
                        foundPrevLen = lens[j];
                        foundSameAtPos = k;
                        break;
                    }
                }

                if(foundSameAtPos != -1){
                    if(lens[i] < foundPrevLen + 1){
                        foundPos[i] = foundSameAtPos;
                        lens[i] = foundPrevLen + 1;
                    }
                }else{
                    int foundPosBefore = -1;
                    for(int k = 0; k < foundPos[j]; ++k){
                        if(text1.charAt(i) == text2.charAt(k)){
                            foundPosBefore = k;
                        }
                    }

                    if(foundPosBefore != -1 && lens[i] == 0){
                        lens[i] = 1;
                        foundPos[i] = foundPosBefore;
                    }
                }
            }
        }

        int resp = 0;
        for(int i = 0; i < lens.length; ++i){
            if(lens[i] > resp){
                resp = lens[i];
            }
        }

        return resp;
    }

    public static void main(String[] args){
        LongestCommonSubsequence obj = new LongestCommonSubsequence();
        System.out.println(obj.longestCommonSubsequence("abcde", "ace"));
        System.out.println(obj.longestCommonSubsequence("abc", "abc"));
        System.out.println(obj.longestCommonSubsequence("abc", "def"));
        System.out.println(obj.longestCommonSubsequence("bsbininm", "jmjkbkjkv"));
        System.out.println(obj.longestCommonSubsequence("oxcpqrsvwf", "shmtulqrypy"));
        System.out.println(obj.longestCommonSubsequence("bl", "yby"));
    }
}
