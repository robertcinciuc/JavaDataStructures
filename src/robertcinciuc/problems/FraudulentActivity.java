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
        Map<Integer, Integer> valFreq = createFreqMap();
        int nbNotif = 0;
        for(int i = 0; i < expenditure.size(); ++i){

            if(i >= d){
//              Iterate over sum freq and send notification here
                float median = 0;
                int halfMedian = -1;
                int count = 0;
                int prevJ = -1;
                for(int j = 0; j < maxVal; ++j){
                    if(valFreq.get(j) > 0){
                        count += valFreq.get(j);

                        if(d % 2 != 0){
                            if(count == d / 2 + 1 || (count > d / 2 + 1 && count - valFreq.get(j) < d / 2 + 1)){
                                median = j;
                                break;
                            }
                        }else{
                            if(count >= d/2 + 1){
                                if(count - valFreq.get(j) < d/2){
                                    median = j;
                                }else{
                                    median = (float)(prevJ + j) / 2f;
                                }
                                break;
                            }
                        }
                        prevJ = j;
                    }
                }

                if(expenditure.get(i) >= 2 * median){
                    nbNotif++;
                }

                valFreq.put(expenditure.get(i - d), valFreq.get(expenditure.get(i - d)) - 1);
            }
            valFreq.put(expenditure.get(i), valFreq.get(expenditure.get(i)) + 1);
        }

        return nbNotif;
    }

    private static Map<Integer, Integer> createFreqMap(){
        Map<Integer, Integer> expenditureFreq = new HashMap<>();
        for(int i = 0; i <= maxVal; ++i){
            expenditureFreq.put(i, 0);
        }
        return expenditureFreq;
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
