package BinarySearch;

import java.util.concurrent.ThreadLocalRandom;

public class P374_GuessNumHighLow {
    public static void main(String[] args) {
        System.out.println("guess number: " + guessNumber(10));
    }

    public static int randomNum(int n) {
        return ThreadLocalRandom.current().nextInt(0, n + 1);
    }

    public static int guessNumber(int n) {
        int pick = randomNum(n);
        System.out.println("Pick Number: " + pick + " From 1 to " + n);
        return binarySearch(1, n, pick);
    }

    public static int binarySearch(int begin, int end, int pick) {
        // use begin + (end - begin) instead of (begin + end) / 2
        // to avoid stack overflow
        int half = begin + (end - begin) / 2;
        if (guess(pick, half) == 0) {
            return half;
        } else if (guess(pick, half) == -1) {
            return binarySearch(begin, half - 1, pick);
        } else {
            return binarySearch(half + 1, end, pick);
        }
    }

    public static int guess(int pick, int num) {
        return Integer.compare(pick, num);
    }
}
