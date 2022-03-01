import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class arraySortOdd {
    /**
     * 4/4
     *
     * На входе массив чисел.
     * Задание: отсортировать в массиве только нечетные числа и вернуть массив.
     * Четные числа оставить на своих позициях.
     *
     * Пример:
     *
     * sort([9, 4, 7, 3, 5, 7, 8, 2]) --> [3, 4, 5, 7, 7, 9, 8, 2]
     * сортируем нечетные числа 9, 7, 3, 5, 7
     * порядок остальных чисел остается без изменений
     *
     */
    public static List<Integer> getResult(List<Integer> arr) {
        // Write your code here...
        List<Integer> result = new ArrayList<>();
        List<Integer> even = new ArrayList<>();
        List<Integer> odd = new ArrayList<>();
        List<Integer> sort = new ArrayList<>();

        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i) % 2 == 0) {
                even.add(i);
            } else {
                odd.add(i);
                sort.add(arr.get(i));
            }
        }

        Collections.sort(sort);

        int j = 0;
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i) % 2 == 0) {
                result.add(arr.get(i));
            } else {
                result.add(sort.get(j));
                j++;
            }
        }

        System.out.println(result);
        return result;
    }

    public static void runCode() {
        // Entrypoint to debug your function
    }

    public static void main(String[] args) throws Exception {
        List<Integer> arr = new ArrayList<>(Arrays.asList(9, 4, 7, 3, 5, 7, 8, 2));

        getResult(arr);
    }

}
