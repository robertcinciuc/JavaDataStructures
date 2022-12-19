package robertcinciuc.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Result2{

    public static void almostSorted(List<Integer> arr) {
        List<Integer> sortedArr = new ArrayList(arr);
        Collections.sort(sortedArr);

        boolean diff = false;
        for(int i = 0; i < arr.size(); ++i){
            if (!arr.get(i).equals(sortedArr.get(i))) {
                diff = true;
                break;
            }
        }

        if(!diff){
            System.out.println("yes");
        }

        String swap = isSwap(arr, sortedArr);
        String reverse = isReverse(arr, sortedArr);

        if(!swap.equals("no")){
            System.out.println(swap);
        }else if(!reverse.equals("no")){
            System.out.println(reverse);
        }else{
            System.out.println("no");
        }
    }

    public static String isSwap(List<Integer> arr, List<Integer> sortedArr){
        boolean firstDiffFound = false;
        boolean secondDiffFound = false;
        int diffPos = -1;
        String response = "";
        for(int i = 0; i < arr.size(); ++i) {
            if (!arr.get(i).equals(sortedArr.get(i))) {
                if (!firstDiffFound) {
                    firstDiffFound = true;
                    diffPos = i;
                } else {
                    if (!secondDiffFound) {
                        secondDiffFound = true;
                        if (diffPos == 0) {
                            if (arr.get(i) > arr.get(diffPos + 1)) {
                                return "no";
                            } else {
                                response = "yes\nswap " + (diffPos + 1) + " " + (i + 1);
                            }
                        } else {
                            if (arr.get(i) > arr.get(diffPos + 1) || arr.get(i) < arr.get(diffPos - 1)) {
                                return "no";
                            } else {
                                response = "yes\nswap " + (diffPos + 1) + " " + (i + 1);
                            }
                        }
                    } else {
                        return "no";
                    }
                }
            }
        }
        return response;
    }

    public static String isReverse(List<Integer> arr, List<Integer> sortedArr){
        boolean diffFound = false;
        boolean diffEnded = false;
        boolean inDiff = false;
        int diffStart = 0;
        int diffEnd = 0;
        for(int i = 0; i < arr.size(); ++i){
            if(!arr.get(i).equals(sortedArr.get(i))){
                if(diffEnded){
                    return "no";
                }else if(!diffFound){
                    diffFound = true;
                    diffStart = i;
                }
            }else if(diffFound && !diffEnded){
                diffEnd = i - 1;
                diffEnded = true;
            }
        }

        if(diffStart > 0 && arr.get(diffStart - 1) > arr.get(diffEnd)){
            return "no";
        }
        if(diffEnd < arr.size() - 1 && arr.get(diffStart) > arr.get(diffEnd + 1)){
            return "no";
        }
        return "yes\nreverse " + (diffStart + 1) + " " + (diffEnd + 1);
    }


}

public class AlmostSorted{
    public static void main(String[] args){

        Result2.almostSorted(List.of(4, 2));
        Result2.almostSorted(List.of(1, 2, 3, 4, 5, 6));
        Result2.almostSorted(List.of(1, 2, 6, 5, 4, 3, 7));
        Result2.almostSorted(List.of(1, 3, 2, 4, 5, 2, 7));
        Result2.almostSorted(List.of(1, 2, 5, 4, 1, 6));

        Result2.almostSorted(List.of(1, 6, 3, 4, 5, 2));
        Result2.almostSorted(List.of(1, 3, 2, 4, 5, 6));
        Result2.almostSorted(List.of(1, 7, 2, 4, 5, 6));
        Result2.almostSorted(List.of(1, 2, 6, 4, 5, 1));
    }
}

//public class AlmostSorted {
//    public static void main(String[] args) throws IOException {
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//
//        int n = Integer.parseInt(bufferedReader.readLine().trim());
//
//        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
//                .map(Integer::parseInt)
//                .collect(Collectors.toList());
//
//        Result2.almostSorted(arr);
//
//        bufferedReader.close();
//    }
//}