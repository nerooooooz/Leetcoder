package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class P280_RandomizedSet {
    public static void main(String[] args) {
        RandomizedSet randomizedSet = new RandomizedSet();
        System.out.printf("[%b] [%b] [%b] [%d] [%b] [%b] [%d]%n",
                randomizedSet.insert(1),
                randomizedSet.remove(2),
                randomizedSet.insert(2),
                randomizedSet.getRandom(),
                randomizedSet.remove(1),
                randomizedSet.insert(2),
                randomizedSet.getRandom());

    }

    static class RandomizedSet {
        List<Integer> random;
        Map<Integer, Integer> randomMap;

        public RandomizedSet() {
            random = new ArrayList<>();
            randomMap = new HashMap<>();
        }

        public boolean insert(int val) {
            if (randomMap.containsKey(val)) {
                return false;
            } else {
                random.add(val);
                randomMap.put(val, random.size() - 1);
                return true;
            }
        }

        public boolean remove(int val) {
            if (randomMap.containsKey(val)) {
                int last = random.get(random.size() - 1);
                random.set(randomMap.get(val), last);
                randomMap.put(last, randomMap.get(val));

                randomMap.remove(val);
                random.remove(random.size() - 1);
                return true;
            } else {
                return false;
            }
        }

        public int getRandom() {
            return random.get(ThreadLocalRandom.current().nextInt(0, random.size()));
        }
    }
}
