import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class dispalcement {
    /**
     *
     * Напишите функцию, которая сдвигает массив влево или вправо на заданное число shift. Число может быть положительным или отрицательным. Положительное число сдвигает массив вправо, отрицательное сдвигает его влево.
     * На входе:
     *
     *     arr - исходный массив целых чисел
     *     shift - число (integer) - сдвиг массива
     *
     * На выходе: массив после сдвига
     *
     * Пример:
     * 1.
     *
     * dispalcement([1, 2, 3, 4, 5], 2) --> [4, 5, 1, 2, 3]
     *
     * первый шаг: [1, 2, 3, 4, 5] --> [5, 1, 2, 3, 4,]
     * второй шаг: [5, 1, 2, 3, 4,] --> [4, 5, 1, 2, 3]
     *
     * 2.
     *
     * dispalcement([1, 2, 3, 4, 5], -2) --> [3, 4, 5, 1, 2]
     *
     * первый шаг: [1, 2, 3, 4, 5] --> [2, 3, 4, 5, 1]
     * второй шаг: [2, 3, 4, 5, 1]   --> [3, 4, 5, 1, 2]
     *
     */
    public static List<Integer> dispalcement(List<Integer> arr, int shift) {
        // Write your code here...
        List<Integer> result = new ArrayList<>();

        if (shift > 0) {
            for (int i = shift; i > 0; i--) {
                System.out.println(i);
                result.add(arr.get(arr.size() - i));
                System.out.println(result);
            }
            result.addAll(arr.subList(0, arr.size() - shift));
        } else {
            for (int i = arr.size() + shift; i > 0; i--) {
                System.out.println(i);
                result.add(arr.get(arr.size() - i));
                System.out.println(result);
            }
            result.addAll(arr.subList(0, Math.abs(shift)));
        }

        System.out.println(result);
        return result;
    }

    public static void runCode() {
        // Entrypoint to debug your function
    }

    public static void main(String[] args) throws Exception {
        List<Integer> arr = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        int shift = -1;

        dispalcement(arr, shift);
    }

}
