package robertcinciuc.problems;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MaxSubarray {

    public static List<Integer> maxSubarray(List<Integer> arr) {
        int maxSubsequence = arr.get(0);
        for(int i = 1; i < arr.size(); ++i) {
            maxSubsequence = Math.max(Math.max(maxSubsequence, arr.get(i)), maxSubsequence + arr.get(i));
        }

//        Subarray part
        int maxSum = arr.get(0);
        int sum = arr.get(0);
        for (int i = 1; i < arr.size(); ++i) {
            sum = Math.max(sum + arr.get(i), arr.get(i));
            maxSum = Math.max(maxSum, sum);
        }

        return Arrays.asList(maxSum, maxSubsequence);
    }
}

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());

                List<Integer> result = MaxSubarray.maxSubarray(arr);
                System.out.println(result);

            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
    }
}

