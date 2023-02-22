package SumOfCoins;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String[] elements = in.nextLine().substring(7).split(", ");
        int[] coins = new int[elements.length];
        for (int i = 0; i < coins.length; i++) {
            coins[i] = Integer.parseInt(elements[i]);
        }

        int targetSum = Integer.parseInt(in.nextLine().substring(5));


        Map<Integer, Integer> usedCoins = chooseCoins(coins, targetSum);
        int countCoins = usedCoins.values().stream().mapToInt(e -> e).sum();
        System.out.println("Number of coins to take: " + countCoins);
        List<Map.Entry<Integer, Integer>> sortedCoinsList = usedCoins.entrySet()
                .stream()
                .sorted((l, r) -> r.getKey() - l.getKey())
                .collect(Collectors.toList());

        for (Map.Entry<Integer, Integer> usedCoin : sortedCoinsList) {
            System.out.printf("%d coin(s) with value %d%n", usedCoin.getValue(), usedCoin.getKey());
        }
    }

    public static Map<Integer, Integer> chooseCoins(int[] coins, int targetSum) {
        int[] sortedCoins = Arrays.stream(coins)
                .boxed()
                .sorted(Collections.reverseOrder())
                .mapToInt(Integer::intValue)
                .toArray();

        Map<Integer, Integer> result = new HashMap<>();

        while (targetSum > 0) {
            int largestCoin = 0;

            for (int coin : sortedCoins) {
                if (coin <= targetSum) {
                    largestCoin = coin;
                    break;
                }
            }

            if (largestCoin == 0) {
                throw new RuntimeException("Error");
            }

            result.putIfAbsent(largestCoin, 0);
            int currentUsage = result.get(largestCoin);
            result.put(largestCoin, currentUsage + 1);

            targetSum -= largestCoin;
        }
        return result;
    }
}