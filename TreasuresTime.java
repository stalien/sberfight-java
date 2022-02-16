import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TreasuresTime {
    /**
     * Искатель приключений попал в подземелье полное сокровищ. Однако перед входом он наступил на нажимную плиту и активировал ловушку, которая через t минут
     * затопит всё помещение.
     *
     * Вам подаётся массив сундуков chests, где chests[i] - количество сокровищ в сундуке. За одну минуту исследователь может либо забрать сокровища i,
     * либо переместиться к следующему сундуку (i+1). Он начинает с нулевой позиции, доходить до конца массива необязательно.
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
        List<Integer> sorted = new ArrayList<>(chests);
        Collections.sort(sorted);
        System.out.println(chests);
        System.out.println(sorted);

        double median, mid, mid2;

        mid = (double)chests.get(chests.size()/2);
        mid2 = (double)chests.get(chests.size()/2 - 1);

        if (chests.size() % 2 == 0) {
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

            if (chests.get(i) >= (int)median) {
                maxTreasures2 += chests.get(i);

                k--;
                continue;
            }
        }
        System.out.println("s2 :" + maxTreasures2);

        //стратегия3 (принимаем решение рандомно)
        int maxTreasures3 = 0;
        k = t;
        for (int i = 0; i < k; i++) {

            double r = Math.random() * 9;
            System.out.println("r :" + r);

            if ((int)r % 2 == 0) {
                maxTreasures3 += chests.get(i);
                k--;
                continue;
            }
        }
        System.out.println("s3 :" + maxTreasures3);

        List<Integer> strategies = new ArrayList<>();

        strategies.add(maxTreasures1);
        strategies.add(maxTreasures2);
        strategies.add(maxTreasures3);

        maxTreasures = Collections.max(strategies);

        System.out.println(maxTreasures);
        return maxTreasures;
    }

    public static void runCode() {
        // Entrypoint to debug your function
    }

    public static void main(String[] args) throws Exception {
        List<Integer> chests = new ArrayList<>();
        int t = 3;

        chests.add(1);
        chests.add(4);
        chests.add(2);

        getResult(chests, t);
    }

}
