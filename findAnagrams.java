import apple.laf.JRSUIConstants;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class findAnagrams {
    /**
     * !!!!возможно недорешанное!
     *
     * Дан массив строк. Часть строк данного массива могут являться анаграммами. Функция должна возвращать наибольший подмассив,
     * элементы которого являются анаграммами, либо пустой массив, если в исходном массиве нет анаграмм.
     * Строки итогового подмассива должны располагаться в том же порядке, что и в исходном массиве.
     *
     * Анаграмма - слово, полученное перестановкой букв другого слова.
     *
     * На входе: массив строк, состоящих из буквенных символов
     * На выходе: массив строк, являющихся анаграммами
     *
     * Пример:
     *
     *  max_anagram(['nbr', 'nfr', 'lev', 'rbn', 'rfn', 'nrb']) --> ['nbr', 'rbn', 'nrb']
     *
     */
    public static List<String> findAnagrams(List<String> words) {
        // Write your code here...
        List<String> result = new ArrayList<>();
        List<String> sorted = new ArrayList<>();

        for (int i = 0; i < words.size(); i++) {
            char[] ar = words.get(i).toCharArray();
            Arrays.sort(ar);
            String sort = String.valueOf(ar);
            sorted.add(sort);
        }

        System.out.println(words);
        System.out.println(sorted);

        List<Integer> tmp = new ArrayList<>();
        for (int i = 0; i < words.size() - 1; i++) {
            for (int j = i + 1; j < words.size(); j++) {
            if (sorted.get(j).equalsIgnoreCase(sorted.get(i))) {
                tmp.add(j);
            }
            }
            if (tmp.size() > 0) {
                tmp.add(i);
                System.out.println(tmp);
            }
            if (tmp.size() > result.size()) {
                result.clear();
                Collections.sort(tmp);
                for (int k = 0; k < tmp.size(); k++) {
                    result.add(words.get(tmp.get(k)));
                }
            }
            tmp.clear();
        }

        System.out.println(result);
        return result;
    }

    public static void runCode() {
        // Entrypoint to debug your function
    }

    public static void main(String[] args) throws Exception {
        List<String> words = new ArrayList<>(Arrays.asList("nbr", "nfr", "lev", "rbn", "rfn", "rnf"));

        findAnagrams(words);
    }

}
