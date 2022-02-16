import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TreasuresHunter {
    /**
     * Вы сбежали от тянущейся рутины и отправились в приключение! Каждый день вы можете спуститься в подземелье и
     * найти сокровища. Ваша задача забрать с собой как можно больше сокровищ.
     * Однако, если вы пойдёте за сокровищами во второй день подряд, то у вас украдут половину сокровищ текущего,
     * второго дня другие искатели приключений, действуйте осторожно!
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
        int maxTreasures = 0;
//        boolean secondDay = false;
        Map<Integer, Integer> tresMap = new HashMap<>();

        for (int i = 0; i < treasures.size() - 1; i++) {
            int summOst = 0;
            for (int j = i+1; j < treasures.size(); j++) {
                summOst += Math.round(treasures.get(j)/2);
            }
            if ((treasures.get(i) + summOst) < (summOst - Math.round(treasures.get(i+1)/2)) + treasures.get(i+1)) {
                tresMap.put(i, 0);
            } else {
                continue;
            }
        }

        for (int i = 0; i < treasures.size(); i++) {
            if (!tresMap.containsKey(i)) {
                int value = treasures.get(i);
                if (i == 0) {
                    tresMap.put(i, value);
                } else if (tresMap.get(i - 1) == 0) {
                    tresMap.put(i, value);
                } else {
                    tresMap.put(i, Math.round(value/2));
                }

            }
        }

        maxTreasures = tresMap.values().stream().reduce(0, Integer::sum);

//        for (int i = 0; i < treasures.size(); i++) {
//            if (i != (treasures.size() - 1)) {
//                if (!secondDay) {
//                    tresMap.put(i, treasures.get(i));
//                    maxTreasures += treasures.get(i);
//                    secondDay = true;
//                    continue;
//                } else {
//                    if ((Math.ceil(treasures.get(i) / 2) >= treasures.get(i + 1))) {
//                        tresMap.put(i, (int) Math.ceil(treasures.get(i) / 2));
//                        maxTreasures += Math.ceil(treasures.get(i) / 2);
//                    } else {
//                        secondDay = false;
//                        tresMap.put(i, 0);
//                        continue;
//                    }
//                }
//            } else {
//                if (!secondDay) {
//                    tresMap.put(i, treasures.get(i));
//                    maxTreasures += treasures.get(i);
//                } else {
//                    tresMap.put(i, (int) Math.ceil(treasures.get(i) / 2));
//                    maxTreasures += Math.ceil(treasures.get(i) / 2);
//                }
//            }
//        }

        System.out.println(treasures);
        System.out.println(tresMap);
        System.out.println(maxTreasures);
        return maxTreasures;
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
