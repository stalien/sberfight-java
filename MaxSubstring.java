import java.util.*;

public class MaxSubstring {
    /**
     * Напишите функцию, которая для заданной строки возвращает длину наибольшей подстроки без повторяющихся символов.
     *
     * На входе: s - заданна строка
     * На выходе: целое число - длина наибольшей подстроки без повторяющихся символов
     *
     * Пример:
     * 1.
     *
     * getLongest( "abcabcbb" ) -> 3
     * Наибольшая подстрока без повторяющихся символов: "abc" состоит из 3 символов
     * 2.
     *
     * getLongest( "bbbbb" ) -> 1
     * Наибольшая подстрока без повторяющихся символов: "b" состоит из 1 символа
     */
    public static int getLongest(String s) {
        // Write your code here...
        List<String> sList = new ArrayList<>(Arrays.asList(s.split("")));
        Integer maxSubstringLength;
        TreeMap<Integer, List<String>> lengthMap = new TreeMap<>();

        int window = sList.size();
        List<String> tmp = new ArrayList<>();

        while(window > 0) {
            for (int firstIndex = 0; firstIndex <= s.length() - window; firstIndex++) {
                int sum = 1;
                tmp.clear();
                tmp.add(sList.get(firstIndex));

                for (int i = firstIndex + 1; i < firstIndex + window; i++) {

                    if (!tmp.contains(sList.get(i))) {
                        tmp.add(sList.get(i));
                        sum++;
                    } else break;
                }

                lengthMap.put(sum, sList.subList(firstIndex, firstIndex + window));
            }

            window--;
        }

//        System.out.println(lengthMap);

        maxSubstringLength = lengthMap.lastKey();

//        System.out.println(maxSubstringLength);

        return maxSubstringLength;
    }

    public static void runCode() {
        // Entrypoint to debug your function
    }

    public static void main(String[] args) throws Exception {
//        List<String> s = new ArrayList<>();
//        int t = 6;

//        s.add(3);
//        s.add(2);
//        s.add(4);
//        s.add(5);

        getLongest("abcdefas");
    }

}
