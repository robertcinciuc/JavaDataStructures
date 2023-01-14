package robertcinciuc.problems.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        Map<Long, Integer> sumMinCoins = new HashMap<>();

        List<Integer> collect = Arrays.stream(coins).boxed().map(e -> e * -1).sorted().collect(Collectors.toList());
        int[] coinsDesc = new int[collect.size()];
        for(int i = 0; i < collect.size(); ++i){
            coinsDesc[i] = collect.get(i) * -1;
        }

        makeChange(coinsDesc, amount, sumMinCoins, 0, 0);

        return sumMinCoins.getOrDefault((long)amount, -1);
    }

    public void makeChange(int[] coins, int amount, Map<Long, Integer> sumMinCoins, int nbCoinsSoFar, long sumSoFar){
        if(sumSoFar <= amount){
            if(sumMinCoins.containsKey(sumSoFar)) {
                if(sumMinCoins.get(sumSoFar) > nbCoinsSoFar){
                    sumMinCoins.put(sumSoFar, nbCoinsSoFar);
                }else{
                    return;
                }
            }else{
                sumMinCoins.put(sumSoFar, nbCoinsSoFar);
            }

            for(int coin : coins){
                if( sumSoFar + coin <= amount){
                    makeChange(coins, amount, sumMinCoins, nbCoinsSoFar + 1, sumSoFar + coin);
                }
            }
        }
    }

    public static void main(String[] args){
        CoinChange coinChange = new CoinChange();
        System.out.println(coinChange.coinChange(new int[]{1,2,5}, 11));
        System.out.println(coinChange.coinChange(new int[]{1}, 0));
        System.out.println(coinChange.coinChange(new int[]{1,2147483647}, 2));
    }
}
