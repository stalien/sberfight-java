import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class pickPeaks {
    /**
     * Напишите функцию, которая определяет количество "пиков" (локальных максимумов) в заданном массиве.
     * Первый и последний элементы массива не могут являться пиками. Если пиковое значение повторяется в массиве несколько раз подряд, то засчитывается как один пик.
     *
     * На входе: numbers - целочисленный массив
     * На выходе: число (int) - количество пиков
     *
     * Пример:
     *
     * pickPeaks( [3, 2, 8, 8, 6, 1, 0, 4, 1]) --> 2
     * исходный массив имеет 2 пика: значение 8 и значение 4.
     *
     * Аргумент
     * // 1: numbers: Integer[]
     * [0, 1, -2, 3, 0, -1, 1, 2, -2]
     * Ожидаемое значение
     * 3
     *
     * Аргумент
     * // 1: numbers: Integer[]
     * [0, 4, 4, 4, 2, 2, 1, 2, -3, -2]
     * Ожидаемое значение
     * 2
     *
     */
    public static int pickPeaks(List<Integer> numbers) {
        // Write your code here...
        int result = 0;
        List<Integer> nums = new ArrayList<>();
        nums.addAll(numbers);

        System.out.println(nums);
        for (int i = 1; i < nums.size() - 1; i++) {
            if (nums.get(i+1) == nums.get(i)) {
                nums.remove(i+1);
                i = 0;
            }
        }
        System.out.println(nums);

        int min = Collections.min(nums);
        int max = Collections.max(nums);

        for (int i = 1; i < nums.size() - 1; i++) {
            if (nums.get(i - 1) < nums.get(i) && nums.get(i + 1) < nums.get(i)) {
                result++;
            }
        }

        System.out.println(result);
        return result;
    }

    public static void runCode() {
        // Entrypoint to debug your function
    }

    public static void main(String[] args) throws Exception {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(0, 4, 4, 4, 2, 2, 1, 2, -3, -2));

        pickPeaks(numbers);
    }

}
