import java.util.*;

public class sequenceMaxNumber {
    /**
     * Последовательность X для заданного  натурального числа n образуется следующим образом:
     *
     * если число чётное, то делим его на 2
     * если нечётное, то умножаем на 3 и прибавляем 1 (получаем 3n + 1)
     * над полученным числом выполняем те же самые действия, и так далее
     * Например, для числа 3 получаем:
     *
     * 3 — нечётное, 3×3 + 1 = 10
     * 10 — чётное, 10:2 = 5
     * 5 — нечётное, 5×3 + 1 = 16
     * 16 — чётное, 16:2 = 8
     * 8 — чётное, 8:2 = 4
     * 4 — чётное, 4:2 = 2
     * 2 — чётное, 2:2 = 1
     * 1 — нечётное, 1×3 + 1 = 4
     * Очевидно, что, начиная с 1, начинают циклически повторяться числа 1, 4, 2.
     *
     * Найдите наибольшее число последовательности Х для заданного числа n.
     *
     * На входе: n - целое неотрицательно число, начало последовательности
     * На выходе: число (int) - максимальный член последовательности, начинающийся с n
     *
     * Аргумент
     * // 1: n: Integer
     * 15
     * Ожидаемое значение
     * 160
     *
     *
     */
    public static int sequenceMaxNumber(int n) {
        // Write your code here...
        int max = n;
        List<Integer> sequenceList = new ArrayList<>();

        int i = 0;
        while (i < 20) {
            if (max % 2 == 0) {
                max = max / 2;
                sequenceList.add(max);
            }
            if (max % 2 != 0) {
                max = (max * 3) + 1;
                sequenceList.add(max);
            }
            i++;
        }

        System.out.println(sequenceList);
        max = Collections.max(sequenceList);
        System.out.println(max);
        return max;
    }

    public static void runCode() {
        // Entrypoint to debug your function
    }

    public static void main(String[] args) throws Exception {


        sequenceMaxNumber(15);
    }

}
