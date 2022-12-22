package robertcinciuc.problems;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Result3{
    private static int maxVal = 200;

    public static int activityNotifications(List<Integer> expenditure, int d) {
        Map<Integer, Integer> valFreq = createFreqMap(expenditure, d);
        int nbNotif = 0;
        for(int i = d; i < expenditure.size(); ++i){

//              Iterate over sum freq and send notification here
            float median;
            List<Integer> arrForMedian = new ArrayList<>();
            for(int j = 0; j <= maxVal; ++j){
                if(valFreq.containsKey(j)){
                    if(valFreq.get(j) > 0){
                        int count = valFreq.get(j);
                        while(count > 0){
                            arrForMedian.add(j);
                            count--;
                        }
                    }
                }
            }
            median = getMedianExpenditure(arrForMedian);


            if(expenditure.get(i) >= 2 * median){
                nbNotif++;
            }

            valFreq.put(expenditure.get(i - d), valFreq.get(expenditure.get(i - d)) - 1);

            if(valFreq.containsKey(expenditure.get(i))){
                valFreq.put(expenditure.get(i), valFreq.get(expenditure.get(i)) + 1);
            }else{
                valFreq.put(expenditure.get(i), 1);
            }

        }

        return nbNotif;
    }

    private static Map<Integer, Integer> createFreqMap(List<Integer> expenditure, int d){
        Map<Integer, Integer> expenditureFreq = new HashMap<>();
        for(int i = 0; i < d; ++i){
            if(expenditureFreq.containsKey(expenditure.get(i))){
                expenditureFreq.put(expenditure.get(i), expenditureFreq.get(expenditure.get(i) + 1));
            }else{
                expenditureFreq.put(expenditure.get(i), 1);
            }
        }
        return expenditureFreq;
    }

    private static float getMedianExpenditure(List<Integer> arr) {
        int size = arr.size();
        if (size % 2 == 0) {
            return (arr.get(size / 2) + arr.get((size / 2) - 1)) / 2f;
        }
        return arr.get(size / 2);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int d = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> expenditure = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int result = Result3.activityNotifications(expenditure, d);
        System.out.println(result);

        bufferedReader.close();
    }
}

public class FraudulentActivity {
    public static void main(String[] args){
        System.out.println(Result3.activityNotifications(List.of(10, 20, 30, 40, 50), 3));
        System.out.println(Result3.activityNotifications(List.of(2, 3, 4, 2, 3, 6, 8, 4, 5), 5));
        System.out.println(Result3.activityNotifications(List.of(2, 3, 4, 2, 3, 6, 8, 4, 5), 4));
        System.out.println(Result3.activityNotifications(List.of(1, 2, 3, 4, 4), 4));
    }
}
