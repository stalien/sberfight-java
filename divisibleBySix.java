import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class divisibleBySix {
    /**
     *
     * !!!!5/6
     *
     * На входе замаскированное число - натуральное число, одна из цифр в записи которого заменена на звездочку "*".
     * Найдите все возможные варианты этого числа при условии, что оно должно делиться на 6 без остатка.
     *
     * На входе: maskedNumber - замаскированное число (string). Например, "1234*6"
     * На выходе: массив чисел, удовлетворяющих условию
     *
     * Пример:
     *
     * divisibleBySix( "1*0" ) --> [120, 150, 180]
     *
     */
    public static List<Integer> divisibleBySix(String maskedNumber) {
        // Write your code here...
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            String tmp;
            int index = maskedNumber.indexOf("*");
            tmp = maskedNumber.substring(0, index) + i + maskedNumber.substring(index).replaceAll("[*]", "");
            if (Integer.parseInt(tmp) % 6 == 0) {
                System.out.println(tmp);
                result.add(Integer.parseInt(tmp));
            }
        }

        if (result.contains(0)) {
            result.remove(new Integer(0));
        }
        System.out.println(result);

        return result;
    }

    public static void runCode() {
        // Entrypoint to debug your function
    }

    public static void main(String[] args) throws Exception {

        divisibleBySix("1234*6");
    }

}
