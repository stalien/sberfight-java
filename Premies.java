import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Premies {
    /**
     * 1 уровень сложности (100%)
     *
     * При распределении премий директор подготовил конверты с определенными суммами, суммы в $ хранятся в массиве cash.
     *
     * Затем директор решил, что разделение не справедливо, выделил еще сумму s и действовал так: он выбирал конверт с наименьшей суммой и добавлял в него 3$ из этой суммы s до тех пор, пока не исчерпал выделенную сумму s.
     *
     * Оставшиеся 1$ или 2$ директор положил в кошелек с наименьшей суммой. Найдите сколько сотрудников получат сумму меньше максимальной получившейся суммы.
     *
     * На входе:
     *
     *     cash - сумма в каждом из конвертов, длина массива больше нуля (integer[]), 0<length(cash)<=20
     *     s - сумма, выделенная дополнительно (integer),  0<s<=1000
     *
     * **На выходе:
     *
     * ** Integer - количество сотрудников, получивших сумму меньше максимальной
     *
     * Пример 1:
     *
     * cash=[51, 48, 62]
     * s=11
     * getResult(cash, s) → 2
     * (51,51,62 - 54,51,62 - 54,54,62 - 56,54,62, меньше 62-х 2 числа)
     *
     * Пример 2:
     *
     * cash=[51, 48, 54, 48]
     * s=14
     * getResult(cash, s) → 1 (54, 54, 54, 53)
     */
    public static int getResult(List<Integer> cash, int s) {
        // Write your code here...
        int minors =  0;

        while (s > 0) {
            Collections.sort(cash);
            if (s > 2) {
                cash.set(0, (cash.get(0) + 3));
                s -= 3;
            } else {
                cash.set(0, (cash.get(0) + s));
                s = 0;
            }
            System.out.println(cash);
        }


        Collections.sort(cash);
        for (int i = 0; i < cash.indexOf(Collections.max(cash)); i++) {
            if (cash.get(i) < Collections.max(cash)) {
                minors++;
            }
        }

        System.out.println(minors);
        return minors;
    }

    public static void runCode() {
        // Entrypoint to debug your function
    }

    public static void main(String[] args) throws Exception {
        int s = 14;
        List<Integer> cash = new ArrayList<>();
        cash.add(51);
        cash.add(48);
        cash.add(54);
        cash.add(48);

        getResult(cash, s);
    }
}
