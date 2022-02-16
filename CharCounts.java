import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CharCounts {
    /**
     * Напишите функцию, которая на основе полученной строки генерирует число следующим образом:
     *
     * для каждого символа в строке, если это первое вхождение символа, замените его на '1'
     * если это не первое вхождение, то замените символ на количество раз, которое он был встречен на данный момент.
     * Буквы в верхнем и нижнем регистре считаются разными символами.
     *
     * На входе: string - исходная строка
     * На выходе: строка - сгенерированное число
     *
     * Пример:
     *
     *     stringToNum( "hello world") --> "11121112131"
     */
    public static String stringToNum(String s) {
        // Write your code here...
        List<Character> charList = new ArrayList<>();
        List<Integer> resultString = new ArrayList<>();
        List<Character> tmpList = new ArrayList<>();
        int count = 1;

        for (int i = 0; i < s.length(); i++) {
            charList.add(s.charAt(i));
        }

        tmpList.add(charList.get(0));
        resultString.add(1);
        for (int i = 1; i < charList.size(); i++) {
            if (tmpList.contains(charList.get(i))) {
                for (int j = 0; j < tmpList.size(); j++) {
                    if (tmpList.get(j).equals(charList.get(i))) count++;
                }
                resultString.add(count);
                count = 1;
            } else {
                resultString.add(1);
            }
        tmpList.add(charList.get(i));
        }

        System.out.println(resultString.toString().replaceAll("[, \\[\\]]", ""));
        return resultString.toString().replaceAll("[, \\[\\]]", "");
    }

    public static void runCode() {
        // Entrypoint to debug your function
    }

    public static void main(String[] args) throws Exception {
        List<Integer> chests = new ArrayList<>();
        int t = 2;

        chests.add(7);
        chests.add(8);
        chests.add(9);

        stringToNum("I love yOu");
    }

}
