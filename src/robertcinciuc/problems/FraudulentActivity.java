package robertcinciuc.problems;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Result3{
    public static int activityNotifications(List<Integer> expenditure, int d) {
        Map<Integer, Integer> sumFreq = createFreqMap();

        for(int i = 0; i < expenditure.size(); ++i){
            sumFreq.put(expenditure.get(i), sumFreq.get(expenditure.get(i)) + 1);

            if(i >= d){
                sumFreq.put(expenditure.get(i - d), sumFreq.get(expenditure.get(i - d)) - 1);
            }

//            Iterate over sum freq and send notification here
        }

        return 0;
    }

    private static Map<Integer, Integer> createFreqMap(){
        Map<Integer, Integer> expenditureFreq = new HashMap<>();
        for(int i = 0; i <= 200; ++i){
            expenditureFreq.put(i, 0);
        }
        return expenditureFreq;
    }
}

public class FraudulentActivity {
    public static void main(String[] args){
        Result3.activityNotifications(null, 0);
    }
}
