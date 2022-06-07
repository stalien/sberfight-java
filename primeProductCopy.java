import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class primeProductCopy {
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


        int maxResult = 0, tmp;
        for (int i = 0; i < 100; i++) {

            BigInteger bigInteger = BigInteger.valueOf(i);
            boolean probablePrime = bigInteger.isProbablePrime((int) Math.log(i));
            System.out.println(probablePrime);

            if (probablePrime) {
                tmp = n - i;
                System.out.println(tmp);
                if (tmp < 0) break;

                bigInteger = BigInteger.valueOf(tmp);
                probablePrime = bigInteger.isProbablePrime((int) Math.log(tmp));
                System.out.println(probablePrime);
                if (probablePrime) {
                    System.out.println("!!!!");
                    if (maxResult < tmp * i) {
                        maxResult = i * tmp;
                        System.out.println("maxResult: " + maxResult);
                    }
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


        primeProduct(10);
    }

}
