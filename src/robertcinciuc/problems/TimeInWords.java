package robertcinciuc.problems;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

class Result {

    public static Map<Integer, String> createNbInWords(){
        Map<Integer, String> nbInWords = new HashMap<>();
        nbInWords.put(1, "one");
        nbInWords.put(2, "two");
        nbInWords.put(3, "three");
        nbInWords.put(4, "four");
        nbInWords.put(5, "five");
        nbInWords.put(6, "six");
        nbInWords.put(7, "seven");
        nbInWords.put(8, "eight");
        nbInWords.put(9, "nine");
        nbInWords.put(10, "ten");
        nbInWords.put(11, "eleven");
        nbInWords.put(12, "twelve");
        nbInWords.put(13, "thirteen");
        nbInWords.put(14, "fourteen");
        nbInWords.put(15, "fifteen");
        nbInWords.put(16, "sixteen");
        nbInWords.put(17, "seventeen");
        nbInWords.put(18, "eighteen");
        nbInWords.put(19, "nineteen");
        nbInWords.put(20, "twenty");
        nbInWords.put(30, "thirty");
        nbInWords.put(40, "forty");
        nbInWords.put(50, "fifty");

        return  nbInWords;
    }

    public static String allNbToWords(int h, Map<Integer, String> nbInWords){
        if(nbInWords.containsKey(h)){
            return nbInWords.get(h);
        }else{
            int tens = h - h % 10;
            return nbInWords.get(tens) + " " + nbInWords.get(h % 10);
        }
    }

    public static String timeInWords(int h, int m) {
        Map<Integer, String> nbInWords = createNbInWords();

        if(m == 0){
            return nbInWords.get(h) + " o' clock";
        }

        return getMinutePhrase(h, m, nbInWords);
    }

    public static String getMinutePhrase(int h, int m, Map<Integer, String> nbInWords){
//            Add minute word
        String minutes;
        if(m == 15 || m == 45){
            minutes = "quarter";
        }else if(m == 30){
            minutes = "half";
        }else{
            if(m < 30){
                minutes = allNbToWords(m, nbInWords);
            }else{
                minutes = allNbToWords(60 - m, nbInWords);
            }
        }

//            Add minute sufix
        if(m != 15 && m != 30 && m != 45){
            minutes += " minute";
            if (m > 1) {
                minutes += "s";
            }
        }

//            Add preposition
        String preposition = "to";
        if(m <= 30){
            preposition = "past";
        }

//            Add hour word
        String hour;
        if(m <= 30){
            hour = allNbToWords(h, nbInWords);
        }else{
            hour = allNbToWords(h + 1, nbInWords);
        }

        return minutes + " " + preposition + " " + hour;
    }

}

public class TimeInWords {

    public static void main(String[] args) throws IOException {
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//        int h = Integer.parseInt(bufferedReader.readLine().trim());
//        int m = Integer.parseInt(bufferedReader.readLine().trim());

        System.out.println(Result.timeInWords(5,00));
        System.out.println(Result.timeInWords(5,30));
        System.out.println(Result.timeInWords(5,20));
        System.out.println(Result.timeInWords(5,15));
        System.out.println(Result.timeInWords(5,47));
        System.out.println(Result.timeInWords(5,01));
        System.out.println(Result.timeInWords(5,10));
        System.out.println(Result.timeInWords(5,40));
        System.out.println(Result.timeInWords(5,45));
        System.out.println(Result.timeInWords(5,28));

//        bufferedWriter.write(result);
//        bufferedWriter.newLine();
//        bufferedReader.close();
//        bufferedWriter.close();
    }
}
