import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Divide {
    /**
     * 2 уровень сложности (100%)
     *
     * На вход подается числовой массив. За одну операцию вы можете разделить любое число в массиве на два (целочисленное деление).
     * Определите, может ли сумма всех элементов в массиве быть не больше w. Общее количество операций не должно превышать значение самого большого числа в массиве.
     *
     * Возможное общее количество операций меняется динамически, то есть если Вы будете делить самое крупное число, то общее количество возможных операций уменьшится.
     *
     * Ввод:
     *
     * arr - массив чисел (integer[])
     * w - число, максимальный предел для суммы массива (integer)
     * Вывод:
     *
     * Boolean - возможно ли удовлетворить условие sum(arr) <= w
     * Пример:
     *
     * arr = [3, 2, 4, 5]
     * W = 9
     * getResult(arr, W) = true
     *
     * Сначала количество возможных операций равно 5 (самое большое число в исходном массиве)
     * 5 // 2 = 2 [3, 2, 4, 2], теперь количество проведенных операций равно 1, а число возможных операций - 4
     * 4 // 2 = 2 [3, 2, 2, 2], теперь количество проведенных операций равно 2, а число возможных операций - 3
     * Уже сейчас выполняется условие: 3 + 2 + 2 + 2 <= 9
     */
    public static boolean getResult(List<Integer> arr, int w) {
        // Write your code here...
        boolean maybe;
        Collections.sort(arr);
        Collections.reverse(arr);
//        System.out.println(arr);

        int i = 0;
        int max = Collections.max(arr);
        while (i < max) {

//            System.out.println("i :" + i);
//            System.out.println("max :" + max);

            if (i < max) {
                arr.set(0, arr.get(0) / 2);
            } else {
                arr.set(1, arr.get(1) / 2);
            }
//                System.out.println(arr);
                Collections.sort(arr);
                Collections.reverse(arr);

            i++;
            max = Collections.max(arr);
        }

        double sum = arr.stream()
                .mapToDouble(a -> a)
                .sum();

//        System.out.println("sum: " + (int)sum);

        maybe = (int)sum <= w;

//        System.out.println(maybe);
        return maybe;
    }

    public static void runCode() {
        // Entrypoint to debug your function
    }

    public static void main(String[] args) throws Exception {
        List<Integer> chests = new ArrayList<>();
        int t = 9;

        chests.add(3);
        chests.add(2);
        chests.add(4);
        chests.add(5);

        getResult(chests, t);
    }

}
