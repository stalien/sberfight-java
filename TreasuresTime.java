import java.util.*;

public class TreasuresTime {
    /**
     * 2 уровень сложности (%)
     *
     * Искатель приключений попал в подземелье полное сокровищ. Однако перед входом он наступил на нажимную плиту и активировал ловушку,
     * которая через t минут затопит всё помещение.
     *
     * Вам подаётся массив сундуков chests, где chests[i] - количество сокровищ в сундуке. За одну минуту исследователь может либо
     * забрать сокровища i, либо переместиться к следующему сундуку (i+1). Он начинает с нулевой позиции, доходить до конца
     * массива необязательно.
     *
     * Определите максимальное количество сокровищ, которое может собрать герой.
     *
     * Ввод:
     *
     * chests - количество сокровищ в сундуках
     * t - количество минут до затопления
     * Вывод:
     *
     * Integer - максимальное количество собранных сокровищ
     *
     * Пример:
     *
     * chests = [1, 4, 2]
     * t = 3
     * getResult(chests, t) = 5
     */
    public static int getResult(List<Integer> chests, int t) {
        // Write your code here...
        int maxTreasures = 0;
        List<Integer> sorted = new ArrayList<>(chests.subList(0, t));
        Collections.sort(sorted);
        System.out.println(chests);
        System.out.println(sorted);

        double median, mid, mid2;

        mid = (double)sorted.get(sorted.size()/2);
        mid2 = (double)sorted.get(sorted.size()/2 - 1);

        if (sorted.size() % 2 == 0) {
            median = (mid + mid2) / 2;
        }
        else {
            median = mid;
        }
        System.out.println("m :" + median);

        //стратегия1 (берем все подряд)
        int maxTreasures1 = 0, k = t;

        for (int i = 0; i < k; i++) {
            if (true) {
                maxTreasures1 += chests.get(i);
                k--;
                continue;
            }
        }
        System.out.println("s1 :" + maxTreasures1);

        //стратегия2 (берем только если больше медианного значения)
        int maxTreasures2 = 0;
        k = t;
        for (int i = 0; i < k; i++) {

            if (chests.get(i) > (int)median) {
                maxTreasures2 += chests.get(i);
                k--;
                continue;
            }
        }
        System.out.println("s2 :" + maxTreasures2);

        //стратегия 3 рандом
        int maxTreasures3 = 0;
        int count = 0;

        while (count < 20) {
            k = t;
            int tmpMax = 0;

//            System.out.println("count: " + count);

            for (int i = 0; i < k; i++) {
                double r = Math.random() * 2;
//                System.out.println(r);

                    if (r > 1d) {
                        tmpMax += chests.get(i);
                        k--;
                    }
            }
//            System.out.println("tmpMax: " + tmpMax);

            if (maxTreasures3 < tmpMax) {
                maxTreasures3 = tmpMax;
            }
            count++;
        }
        System.out.println("s3 :" + maxTreasures3);

        //стратегия 4, если сумма оставшихся больше то не брать
        // [1, 0, 4, 5, 10]
        // [1, 0, 4, 5] беру
        // [0, 4, 5, 10] не беру
        int maxTreasures4 = 0, maxSum = 0;
        k = t;
        for (int j = 0; j < k; j++) {

        List<Integer> maxInterval = new ArrayList<>(chests.subList(j, k));
        System.out.println(maxInterval);
        int sum1 = maxInterval.subList(0, maxInterval.size() - 1).stream().reduce(0, Integer::sum);
        int sum2 = maxInterval.subList(1, maxInterval.size()).stream().reduce(0, Integer::sum);
        System.out.println("sum1: " + sum1);
        System.out.println("sum2: " + sum2);
        if (j == k ) {
            maxTreasures4 += maxInterval.get(0);
            k--;
            continue;
        }
        if (sum1 >= sum2) {
            maxTreasures4 += maxInterval.get(0);
            k--;
            continue;
        }

        }
        System.out.println("maxTreasures4: " + maxTreasures4);

        //стратегия5 граф (дракула)
        //
        Map<String, List<Integer>> chestsMap = new HashMap<>();

        for (int i = 0; i < k; i++) {
            List<Integer> indexList = new ArrayList<>();
            List<Integer> indexList2 = new ArrayList<>();

            if (i == 0) {
                indexList.add(0);
                indexList.add(k - 1);
                chestsMap.put(i + "0", indexList);

                indexList2.add(chests.get(i));
                indexList2.add(k - 2);
                chestsMap.put(i + "1", indexList2);
            } else {
                if (chestsMap.get(Integer.toString(i - 1) + 0).get(1) > 0) {
                    indexList.add(0);
                    indexList.add(k - 1);
                    chestsMap.put(i + "0", indexList);

                    indexList2.add(chests.get(i));
                    indexList2.add(k - 2);
                    chestsMap.put(i + "1", indexList2);
                }
            }

        }
        System.out.println(chestsMap);

        //стратегия6
        // [0 = {[{0, k-1}, {1, k-2}]}, 1 = {}]
        Map<Integer, List<List<Integer>>> mapSum = new HashMap<>();
        k = t;

        for (int i = 0; i < k; i++) {


            if (i == 0) {
                List<List<Integer>> mapList = new ArrayList<>();
                List<Integer> sumListLeft = new ArrayList<>();
                sumListLeft.add(0);
                sumListLeft.add(k - 1);
                mapList.add(sumListLeft);

                List<Integer> sumListRight = new ArrayList<>();
                sumListRight.add(chests.get(i));
                sumListRight.add(k - 2);
                mapList.add(sumListRight);

                mapSum.put(i, mapList);
            }
            else {
                System.out.println(mapSum.get(i - 1).size());
                List<List<Integer>> mapList = new ArrayList<>();
                for (int j = 0; j < mapSum.get(i - 1).size(); j++) {

                    List<Integer> sumListLeft = new ArrayList<>();
                    if (mapSum.get(i - 1).get(j).get(1) > 0) { //проверяем количество оставшихся попыток
                        sumListLeft.add(mapSum.get(i - 1).get(j).get(0) + 0);
                        sumListLeft.add(mapSum.get(i - 1).get(j).get(1) - 1);
                    mapList.add(sumListLeft);

                    List<Integer> sumListRight = new ArrayList<>();
                        sumListRight.add(mapSum.get(i - 1).get(j).get(0) + chests.get(i));
                        sumListRight.add(mapSum.get(i - 1).get(j).get(1) - 2);
                    mapList.add(sumListRight);


                    }
                }
                mapSum.put(i, mapList);
            }
            System.out.println("mapSum: " + mapSum);
        }

        int maxTreasures6 = 0;
        for (int i = 0; i < mapSum.size(); i++) {
            for (int j = 0; j < mapSum.get(i).size(); j++) {
                if (maxTreasures6 < mapSum.get(i).get(j).get(0)) {
                    maxTreasures6 = mapSum.get(i).get(j).get(0);
                }
            }
        }
        System.out.println("maxTreasures6: " + maxTreasures6);


        List<Integer> strategies = new ArrayList<>();

        strategies.add(maxTreasures1);
        strategies.add(maxTreasures2);
        strategies.add(maxTreasures3);
        strategies.add(maxTreasures4);
//        strategies.add(maxTreasures5);
        strategies.add(maxTreasures6);

        maxTreasures = Collections.max(strategies);

        System.out.println(maxTreasures);
        return maxTreasures;
    }

    public static void runCode() {
        // Entrypoint to debug your function
    }

    public static void main(String[] args) throws Exception {
        List<Integer> chests = new ArrayList<>();
        int t = 7;

        chests.add(1);
        chests.add(4);
        chests.add(2);
        chests.add(7);
        chests.add(1);
        chests.add(1);
        chests.add(6);

        getResult(chests, t);
    }

}
