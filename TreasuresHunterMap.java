import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TreasuresHunterMap {
    /**
     * Вы сбежали от тянущейся рутины и отправились в приключение! Каждый день вы можете спуститься в подземелье и найти сокровища.
     * Ваша задача забрать с собой как можно больше сокровищ. Однако, если вы пойдёте за сокровищами во второй день подряд,
     * то у вас украдут половину сокровищ текущего, второго дня другие искатели приключений, действуйте осторожно!
     *
     * Чтобы этого избежать, вы можете взять паузу в один день.
     *
     *  Ввод:
     * treasures - массив сокровищ, treasures[i] - количество сокровищ, i - номер дня
     *
     *  Вывод:
     * integer - максимальное количество сокровищ за приключение, округленное в большую сторону
     *
     * Example:
     *
     * treasures = [4, 2, 5, 1, 5]
     * getResult(treasures) = 14
     * В данном случае, вы забрали сокровища 0, 2 и 4 дня (4 + 5 + 5 = 14)
     */
    public static int getResult(List<Integer> treasures) {
        // Write your code here...

        double maxTreasures = 0;

        Map<Integer, List<List<Integer>>> mapSum = new HashMap<>();

        for (int i = 0; i < treasures.size(); i++) {
            System.out.println("i: " + i);

            if (i == 0) {
                List<List<Integer>> mapList = new ArrayList<>();
                List<Integer> sumListLeft = new ArrayList<>();
                sumListLeft.add(0);
                sumListLeft.add(0);
                mapList.add(sumListLeft);

                List<Integer> sumListRight = new ArrayList<>();
                    sumListRight.add(treasures.get(i));
                sumListRight.add(1);
                mapList.add(sumListRight);

                mapSum.put(i, mapList);
            }
            else {
                List<List<Integer>> mapList = new ArrayList<>();
                for (int j = 0; j < mapSum.get(i - 1).size(); j++) {

                    List<Integer> sumListLeft = new ArrayList<>();
                        sumListLeft.add(mapSum.get(i - 1).get(j).get(0) + 0);
                        sumListLeft.add(0);
                        mapList.add(sumListLeft);

                        List<Integer> sumListRight = new ArrayList<>();
                        if (mapSum.get(i - 1).get(j).get(1) == 0) { //если не брали на прошлом ходе, то прибавляем полностью
                            sumListRight.add(mapSum.get(i - 1).get(j).get(0) + treasures.get(i));
                            sumListRight.add(1);
                            mapList.add(sumListRight);
                        } else { //если брали, то прибавляем только половину
                            sumListRight.add(mapSum.get(i - 1).get(j).get(0) + treasures.get(i) / 2);
                            sumListRight.add(1);
                            mapList.add(sumListRight);
                        }
                }
                mapSum.put(i, mapList);

            }
            System.out.println(mapSum);
        }

        for (int i = 0; i < mapSum.size(); i++) {
            for (int j = 0; j < mapSum.get(i).size(); j++) {
                if (maxTreasures < mapSum.get(i).get(j).get(0)) {
                    maxTreasures = mapSum.get(i).get(j).get(0);
                }
            }
        }

        System.out.println((int)maxTreasures);
        return (int)maxTreasures;
    }

    public static void runCode() {
        // Entrypoint to debug your function
    }

    public static void main(String[] args) throws Exception {

        List<Integer> treasures = new ArrayList<>();
        treasures.add(0);
        treasures.add(10);
        treasures.add(20);
        treasures.add(30);
        treasures.add(40);
        treasures.add(100);

        getResult(treasures);
    }
}
