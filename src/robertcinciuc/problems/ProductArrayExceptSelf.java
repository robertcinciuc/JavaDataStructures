package robertcinciuc.problems;

import java.io.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ProductArrayExceptSelf {

    public static int[] getResult(int[] input){

        int[] prefix = new int[input.length];
        prefix[0] = 1;
        for(int i = 1; i < input.length; ++i){
            prefix[i] = input[i-1] * prefix[i-1];
        }

        int[] sufix = new int[input.length];
        sufix[input.length - 1] = 1;
        for(int i = input.length - 2; i >= 0; --i){
            sufix[i] = input[i + 1] * sufix[i + 1];
        }

        int[] res = new int[input.length];
        for(int i = 0; i < input.length; ++i){
            res[i] = prefix[i] * sufix[i];
        }

        return res;
    }

    public static void print(int[] arr){
        for(int i = 0; i < arr.length; ++i) {
            System.out.print(arr[i]);
            if(i < arr.length - 1){
                System.out.print(" ");
            }
        }
        System.out.println();
    }

//    public static void main(String[] args){
//        print(getResult(new int[]{1, 2, 3, 4, 5}));
//    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        List<Integer> expenditure = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int[] arr = new int[expenditure.size()];
        for(int i = 0; i < expenditure.size(); ++i){
            arr[i] = expenditure.get(i);
        }

        print(getResult(arr));

        bufferedReader.close();
    }
}
