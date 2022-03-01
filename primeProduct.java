import java.util.*;

public class primeProduct {
    /**
     * Некоторые числа можно представить как сумму простых чисел.
     * Например:
     *
     *     7 = 2 + 5
     *     20 = 7 + 13
     *
     * Некоторые невозможно представить в таком виде. Например, 17, 27.
     * Напишите функцию, определяющую, возможно ли разделить заданное число n на сумму простых чисел.
     *  Если возможно, верните максимальное произведение этих чисел. Если число нельзя представить в виде простых чисел - верните 0.
     *
     * На входе: n - натуральное число
     * На выходе: число (integer)
     *
     * Пример:
     *  20 можно разделить на простые числа двумя способами 3 и 17, 7 и 13.
     * Максимальное произведение 91.
     */
    public static int primeProduct(int n) {
        // Write your code here...
        int result = 0;
        List<Integer> simple = new ArrayList<>(
                Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97));

        int maxResult = 0, tmp;
        for (int i = 0; i < simple.size(); i++) {
            tmp = n - simple.get(i);
            System.out.println(tmp);
            if (tmp < 0) break;
            if (simple.contains(tmp)) {
                System.out.println("!!!!");
                if (maxResult < tmp * simple.get(i)) {
                    maxResult = simple.get(i) * tmp;
                    System.out.println("maxResult: " + maxResult);
                }
            }
        }

        if (maxResult > 0) result = maxResult;
        System.out.println(result);
        return result;
    }

    public static void runCode() {
        // Entrypoint to debug your function
    }

    public static void main(String[] args) throws Exception {


        primeProduct(20);
    }

}
