import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Miners {
    /**
     * Бригада строителей выравнивают участок зесли для постройки дома, разделенный на квадраты. Вам дается массив ground,
     * где ground[i] - высота квадрата i в метрах.
     * За одну операцию бригадиры опускают или поднимают квадрат i на один метр. Определите максимальное количество
     * операций для полного выравнивания всего участка земли.
     *
     * Ввод:
     * integer - количество операций, чтобы полностью выровнять участок, то есть сделать весь массив состоящим из
     * одинаковых значений.
     *
     * Пример:
     *
     * ground = [1, 3, 2, 2]
     * getResult(ground) = 2
     *
     * За две операции можно сделать массив, состоящий из одинаковых значений.
     * [1, 3, 2, 2]
     * [*2*, 3, 2, 2]
     * [2, *2*, 2, 2]
     */
    public static int getResult(List<Integer> ground) {
        // Write your code here...
        int operations = 0;
        double median, mid, mid2;

        Collections.sort(ground);

        mid = (double)ground.get(ground.size()/2);
        mid2 = (double)ground.get(ground.size()/2 - 1);

        if (ground.size() % 2 == 0) {
            median = (mid + mid2)/2;
        } else {
            median = mid;
        }
        System.out.println(median);

        for (int i = 0; i < ground.size(); i++) {
            operations += Math.abs(ground.get(i) - (int)median);
        }

        return operations;
    }

    public static void runCode() {
        // Entrypoint to debug your function
    }

    public static void main(String[] args) throws Exception {

        List<Integer> ground = new ArrayList<>();
        ground.add(1);
        ground.add(3);
        ground.add(2);
        ground.add(2);

        getResult(ground);
    }
}
