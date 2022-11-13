package robertcinciuc.problems;

import java.util.*;

public class CoinsMakeSum {

    public int makeSumWithCoins(int target, int currSum, ResultNb resultNb, List<Coin> currCase, Map<String, Integer> seenCasesResults){
        String keyCurrCase = generateKeyForCase(currCase);
        if(currSum == target && !seenCasesResults.containsKey(keyCurrCase)){
            resultNb.nb += 1;
            seenCasesResults.put(keyCurrCase, currSum);
        }else{
            if(seenCasesResults.containsKey(keyCurrCase)){
                return seenCasesResults.get(keyCurrCase);
            }
            doIterationSteps(target, currSum, resultNb, currCase, seenCasesResults, Coin.Quarter);
            doIterationSteps(target, currSum, resultNb, currCase, seenCasesResults, Coin.Dime);
            doIterationSteps(target, currSum, resultNb, currCase, seenCasesResults, Coin.Nickel);
            doIterationSteps(target, currSum, resultNb, currCase, seenCasesResults, Coin.Penny);
        }

        return resultNb.nb;
    }

    public void doIterationSteps(int target, int currSum, ResultNb resultNb, List<Coin> currCase, Map<String, Integer> seenCasesResults, Coin coin){
        if(currSum <= target - coin.value){
            currCase.add(coin);
            makeSumWithCoins(target, currSum + coin.value, resultNb, currCase, seenCasesResults);
            currCase.remove(currCase.size() - 1);
        }
    }

    public String generateKeyForCase(List<Coin> currCase){
        StringBuilder sb = new StringBuilder();
        Map<Coin, Integer> coinFreq = new HashMap<>();
        coinFreq.put(Coin.Quarter, 0);
        coinFreq.put(Coin.Dime, 0);
        coinFreq.put(Coin.Nickel, 0);
        coinFreq.put(Coin.Penny, 0);
        for(Coin coin: currCase){
            coinFreq.put(coin, coinFreq.get(coin) + 1);
        }

        sb.append("Q").append(coinFreq.get(Coin.Quarter));
        sb.append("D").append(coinFreq.get(Coin.Dime));
        sb.append("N").append(coinFreq.get(Coin.Nickel));
        sb.append("P").append(coinFreq.get(Coin.Penny));

        return sb.toString();
    }

    public enum Coin{
        Quarter(25), Dime(10), Nickel(5), Penny(1);

        int value;

        Coin(int value){
            this.value = value;
        }
    }

    private static class ResultNb {
        Integer nb;

        private ResultNb(Integer nb){
            this.nb = nb;
        }
    }

    public static void main(String[] args){
        CoinsMakeSum coinsMakeSum = new CoinsMakeSum();
        ResultNb resultNb = new ResultNb(0);
        Map<String, Integer> seenCases = new HashMap<>();
        List<Coin> currCase = new ArrayList<>();
        coinsMakeSum.makeSumWithCoins(10, 0, resultNb, currCase, seenCases);
        System.out.println(resultNb.nb);
    }
}
