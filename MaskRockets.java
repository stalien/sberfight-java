import java.util.ArrayList;
import java.util.List;

public class MaskRockets {
    /**
     * 3 уровень сложности (100%)
     *
     * Илон Маск презентовал свой новый космический проект - он запустил в небо большое количество ракет.
     * Дан массив rocket_pos, где rocket_pos[i] - высота, на которой находится i-я ракета и rocket_speed,
     * где rocket_speed[i] - скорость i-й ракеты (величина перемещения за одну единицу времени).
     *
     * Если ракеты достигают одинаковой высоты на каком-либо шаге, то они складываются в одну ракету,
     * их скорость тоже складывается.
     *
     * Определите, сколько ракет будет в итоге.
     *
     * Ввод:
     *
     * rocket_pos - начальные позиции каждой из ракет (Integer[]), 0<length(rocket_pos)<=10, 0<=rocket_pos[i]<=1000
     * rocket_speed - скорость каждой из ракет (Integer[]), 0<length(rocket_speed)<=10, 0<=rocket_speed[i]<=15
     * Вывод:
     *
     * Integer - количество ракет по итогу всех "соединений"
     * Пример 1:
     *
     * rocket_pos = [3, 11]
     * rocket_speed = [5, 1]
     * getResult(rocket_pos, rocket_speed) = 1 // Уже через две единицы времени обе ракеты будут на высоте 13 и соединятся
     * Пример 2:
     *
     * rocket_pos = [2, 3]
     * rocket_speed = [1, 2]
     * getResult(rocket_pos, rocket_speed) = 2 // Ракеты никогда не соединятся
     *
     * public static int getResult(List<Integer> rocketPos, List<Integer> rocketSpeed) {
     *         // Write your code here...
     *         int rocketsCount = rocketPos.size();
     *         List<Integer> rocketPosList = new ArrayList<>();
     *         List<Integer> rocketSpeedList = new ArrayList<>();
     *         rocketPosList.addAll(rocketPos);
     *         rocketSpeedList.addAll(rocketSpeed);
     *
     *         for (int time = 1; time < 100; time++) {
     *             for (int i = 0; i < rocketPosList.size(); i++) { //расчитываем положение через i времени для каждой ракеты
     *                 rocketPosList.set(i, rocketPosList.get(i) + rocketSpeedList.get(i));
     *             }
     *             System.out.println(rocketPosList);
     *             System.out.println(rocketSpeedList);
     *             if (rocketPosList.size() == 1) break;
     *
     *             for (int i = 0; i < rocketPosList.size(); i++) { //учесть 1 ракету
     *                 if (rocketPosList.indexOf(rocketPosList.get(i)) != i) { //если есть такая же позиция ракеты
     *                     rocketSpeedList.set(i, rocketSpeedList.get(i) + rocketSpeedList.get(rocketPosList.indexOf(rocketPosList.get(i))));
     *                     int removeIndex = rocketPosList.indexOf(rocketPosList.get(i));
     *
     *                     System.out.println("removeIndex: " + removeIndex);
     *                     rocketSpeedList.remove(removeIndex);
     *                     rocketPosList.remove(removeIndex);
     *                     i--;
     *                     rocketsCount--;
     *                 }
     *             }
     *         }
     *         System.out.println(rocketsCount);
     *
     *         return rocketsCount;
     *     }
     */
    public static int getResult(List<Integer> rocketPos, List<Integer> rocketSpeed) {
        // Write your code here...
        int rocketsCount = rocketPos.size();
        List<Integer> rocketPosList = new ArrayList<>();
        List<Integer> rocketSpeedList = new ArrayList<>();
        rocketPosList.addAll(rocketPos);
        rocketSpeedList.addAll(rocketSpeed);

        for (int time = 1; time < 10_000; time++) {
            for (int i = 0; i < rocketPosList.size(); i++) { //расчитываем положение через i времени для каждой ракеты
                rocketPosList.set(i, rocketPosList.get(i) + rocketSpeedList.get(i));
            }
             System.out.println(rocketPosList);
             System.out.println(rocketSpeedList);
            if (rocketPosList.size() == 1) break;

            for (int i = 0; i < rocketPosList.size(); i++) { //учесть 1 ракету
                if (rocketPosList.indexOf(rocketPosList.get(i)) != i) { //если есть такая же позиция ракеты
                    rocketSpeedList.set(i, rocketSpeedList.get(i) + rocketSpeedList.get(rocketPosList.indexOf(rocketPosList.get(i))));
                    int removeIndex = rocketPosList.indexOf(rocketPosList.get(i));

                    System.out.println("removeIndex: " + removeIndex);
                    rocketSpeedList.remove(removeIndex);
                    rocketPosList.remove(removeIndex);
                    i--;
                    rocketsCount--;
                }
            }
        }
        System.out.println(rocketsCount);

        return rocketsCount;
    }

    public static void runCode() {
        // Entrypoint to debug your function
    }

    public static void main(String[] args) throws Exception {

        List<Integer> rocketPos = new ArrayList<>();
        rocketPos.add(3);
        rocketPos.add(11);
        rocketPos.add(15);
        rocketPos.add(18);

        List<Integer> rocketSpeed = new ArrayList<>();
        rocketSpeed.add(5);
        rocketSpeed.add(1);
        rocketSpeed.add(3);
        rocketSpeed.add(2);

        getResult(rocketPos, rocketSpeed);
    }
}
