import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Changes {
    /**
     * Дан массив чисел array_start. Вы можете менять местами элементы массива. Ваша задача: получить array_goal.
     *
     * Необходимо определить минимально возможное количество перемещений элементов массива, которое требуется, чтобы получить нужный порядок в массиве.
     *
     * Ввод:
     *
     * array_start - начальный массив
     * array_goal - конечный массив
     * Вывод:
     *
     * Integer
     * Пример:
     *
     * array_start = [3, 2, 1, 4]
     * array_goal = [1, 2, 3, 4]
     */
    public static int getResult(List<Integer> arrayStart, List<Integer> arrayGoal) {
        // Write your code here...
        int swap = 0;
        int temp, j;

        for (int i = 0; i < arrayStart.size(); i++) {
            System.out.println("i :" + i);
            j = arrayGoal.indexOf(arrayStart.get(i));
            System.out.println("j :" + j);
            if (j != i) {
                temp = arrayStart.get(i);
                System.out.println("temp:" + temp);
                arrayStart.set(i, arrayGoal.get(i));
                arrayStart.set(j, temp);
                swap++;
            }
            System.out.println(arrayStart);
        }

        System.out.println(swap);
        return swap;
    }

    public static void runCode() {
        // Entrypoint to debug your function
    }

    public static void main(String[] args) throws Exception {

        List<Integer> arrayStart = new ArrayList<>();
        arrayStart.add(3);
        arrayStart.add(2);
        arrayStart.add(1);
        arrayStart.add(4);

        List<Integer> arrayGoal = new ArrayList<>();
        arrayGoal.add(1);
        arrayGoal.add(2);
        arrayGoal.add(3);
        arrayGoal.add(4);

        getResult(arrayStart, arrayGoal);
    }
}
