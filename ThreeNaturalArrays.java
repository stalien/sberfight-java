import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeNaturalArrays {
    /**
     * Дано три массива, состоящие из натуральных чисел.
     * Напишите функцию, которая возвращает сумму элементов, которые встречаются во всех трех массивах.
     * Если таких чисел нет, функция должна возвращать 0. Массив может быть пустым.
     *
     * На входе: три массива натуральных чисел (arr1, arr2, arr3)
     * На выходе : число (integer)
     *
     * Пример:
     *
     * sumOfCommon([1, 2 ,3], [5, 3, 2], [7, 3, 2]) --> 5 # 2 + 3
     *
     * sumOfCommon([1, 2, 2, 3, 5], [5, 3, 2, 2], [7, 3, 2, 2]) --> 7 # 2 + 2 + 3
     *
     * sumOfCommon([2, 1, 7, 6, 4], [3, 3, 1, 6, 3, 1], [6, 3, 7, 1]) --> 7 # 1 + 6
     *
     */
    public static int sumOfCommon(List<Integer> arr1, List<Integer> arr2, List<Integer> arr3) {
        // Write your code here...
        int result = 0;
        List<Integer> tmpArr1 = new ArrayList<>();
        tmpArr1.addAll(arr1);
        List<Integer> tmpArr2 = new ArrayList<>();
        tmpArr2.addAll(arr2);
        List<Integer> tmpArr3 = new ArrayList<>();
        tmpArr3.addAll(arr3);

            for (int i = 0; i < tmpArr1.size(); i++) {
                if (tmpArr2.contains(tmpArr1.get(i)) && tmpArr3.contains(tmpArr1.get(i))) {
                    System.out.println(tmpArr1.get(i));
                    result += tmpArr1.get(i);
                    tmpArr2.remove(tmpArr1.get(i));
                    tmpArr3.remove(tmpArr1.get(i));
                    tmpArr1.remove(i);
                    i--;
                }
            }


        System.out.println("result: " + result);
        return result;
    }

    public static void runCode() {
        // Entrypoint to debug your function
    }

    public static void main(String[] args) throws Exception {
        List<Integer> arr1 = new ArrayList<>(Arrays.asList(1, 2, 2, 3, 5));
        List<Integer> arr2 = new ArrayList<>(Arrays.asList(5, 3, 2));
        List<Integer> arr3 = new ArrayList<>(Arrays.asList(7, 3, 2, 2));


        sumOfCommon(arr1, arr2, arr3);
    }

}
