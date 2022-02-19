import java.util.*;

public class TreasuresTimeCopy {
    /**
     * 2 уровень сложности (100%)
     *
     * Искатель приключений попал в подземелье, полное сокровищ. Однако перед входом он активировал ловушку, которая через t минут затопит всё помещение.
     * Вам подаётся массив сундуков chests, где chests[i] - количество сокровищ в сундуке. Исследователь может либо забрать сокровища i, потратив одну минуту, либо переместиться к следующему сундуку (i+1), что также займет одну минуту. Он начинает с нулевой позиции, доходить до конца массива необязательно.
     *
     * Определите максимальное количество сокровищ, которое может собрать герой.
     *
     * Ввод:
     *
     * chests - количество сокровищ в сундуках, 2<length(chests)<20,  0<chests[i]<100
     * t - количество минут до затопления, 0<t<20
     * Вывод:
     *
     * Integer - максимальное количество собранных сокровищ
     *
     * Пример 1:
     *
     * chests = [1, 4, 2]
     * t = 3
     * getResult(chests, t) = 5 // За первую минуту герой собрал сокровища из первого сундука, за вторую минут переместился к следующему сундуку, за третью минуту забрал сокровища из него
     * Пример 2:
     *
     * chests = [7, 8, 9]
     * t = 2
     * getResult(chests, t) = 8 // За первую минуту герой перешел ко второму сундуку и забрал сокровища из него, это выгоднее, чем взять сокровища в первом сундуке
     */
    public static int getResult(List<Integer> chests, int t) {
        // Write your code here...
        int maxTreasures = 0;


        //стратегия6
        // [0 = {[{0, k-1}, {1, k-2}]}, 1 = {}]
        Map<Integer, List<List<Integer>>> mapSum = new HashMap<>();
        int k = t;
        System.out.println(k);

        for (int i = 0; i < k; i++) {
            System.out.println("i: " + i);

            if (i == 0) {
                List<List<Integer>> mapList = new ArrayList<>();
                List<Integer> sumListLeft = new ArrayList<>();
                sumListLeft.add(0);
                sumListLeft.add(k - 1);
                mapList.add(sumListLeft);

                List<Integer> sumListRight = new ArrayList<>();
                if (i < chests.size()) {
                    sumListRight.add(chests.get(i));
                } else {
                    sumListRight.add(0);
                }
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
                        if (i < chests.size()) {
                            sumListRight.add(mapSum.get(i - 1).get(j).get(0) + chests.get(i));
                        } else {
                            sumListRight.add(mapSum.get(i - 1).get(j).get(0) + 0);
                        }
                        sumListRight.add(mapSum.get(i - 1).get(j).get(1) - 2);
                        mapList.add(sumListRight);


                    }
                }
                mapSum.put(i, mapList);
            }
//             System.out.println("mapSum: " + mapSum);
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




        System.out.println(maxTreasures6);
        return maxTreasures6;
    }

    public static void runCode() {
        // Entrypoint to debug your function
    }

    public static void main(String[] args) throws Exception {
        List<Integer> chests = new ArrayList<>();
        int t = 32;

        chests.add(1);
        chests.add(1);
        chests.add(1);
        chests.add(1);
        chests.add(1);
//        chests.add(4);
//        chests.add(4);
//        chests.add(2);
//        chests.add(2);
//        chests.add(7);
//        chests.add(7);
//        chests.add(7);
//        chests.add(7);
//        chests.add(7);
//        chests.add(7);
//        chests.add(1);
//        chests.add(1);
//        chests.add(1);
//        chests.add(1);
//        chests.add(6);
//        chests.add(6);
//        chests.add(6);
//        chests.add(6);
//        chests.add(6);

        getResult(chests, t);
    }

}
