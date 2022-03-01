import java.util.*;

public class findWords {
    /**
     * Дан массив слов words и паттерн строки pattern. Необходимо определить, какие слова из массива words соответствуют паттерну.
     *
     * Слово соответствуют паттерну, если существует перестановка букв p такая, что после замены каждой буквы x в паттерне на p(x) мы получаем нужное слово.
     *
     * Каждая буква должна соответствовать другой букве, и никакие две буквы не должны соответствовать одной и той же букве.
     *
     * Напишите функцию, которая возвращает массив слов из массива words, которые соответствуют заданному паттерну. Если таких слов нет, то функция должна вернуть пустой массив.
     *
     * На входе:
     *
     * words - массив строк
     * pattern - строка-паттерн
     * На выходе: массив строк в порядке появления в массиве words, соответствующих заданному паттерну
     *
     * Пример:
     *
     * words = ["abc","deq","mee","aqq","dkd","ccc"]
     * pattern = "abb"
     * findWords( words, pattern ) --> ["mee","aqq"]
     * "mee" соответствует паттерну "abb", перестановка {a -> m, b -> e, ...}
     * "ccc" не соответствует паттерну, так как при перестановке {a -> c, b -> c, ...} буквы "a" и "b" в паттерне соответствуют одной и той же букве "c"
     */
    public static List<String> findWords(List<String> words, String pattern) {
        // Write your code here...
        List<String> wordsPattern = new ArrayList<>();
        Map<String,String> charMap = new TreeMap<>();

        for (int i = 0; i < words.size(); i++) {
            int inc = 0;
            charMap.clear();

            if (words.get(i).length() == pattern.length()) {

                for (int j = 0; j < words.get(i).length(); j++) {

                    if (charMap.isEmpty()) {
                        charMap.put(words.get(i).substring(j, j + 1), pattern.substring(j, j + 1));
                        System.out.println(charMap.get(words.get(i).substring(j, j + 1)).length());
                        inc++;
                    } else {
                        if (!charMap.containsKey(words.get(i).substring(j, j + 1))) {
                           if (!charMap.containsValue(pattern.substring(j, j + 1))) {
                               charMap.put(words.get(i).substring(j, j + 1), pattern.substring(j, j + 1));
                               System.out.println(charMap.get(words.get(i).substring(j, j + 1)).length());
                               inc++;
                           }
                        } else {
                            if (charMap.get(words.get(i).substring(j, j + 1)).equals(pattern.substring(j, j + 1))) {
                               System.out.println(charMap.get(words.get(i).substring(j, j + 1)).length());
                               inc++;
                            }
                        }
                    }

                }

                System.out.println(charMap);
                System.out.println(inc);
            }

            if (inc == words.get(i).length()) {
                wordsPattern.add(words.get(i));
            }

        }

        System.out.println(wordsPattern);
        return  wordsPattern;
    }

    public static void runCode() {
        // Entrypoint to debug your function
    }

    public static void main(String[] args) throws Exception {
        List<String> words = new ArrayList<>();
        String pattern = "a";
//        int t = 6;

        words.add("a");
        words.add("b");
        words.add("c");
//        words.add("aqq");
//        words.add("dkd");
//        words.add("ccc");

        findWords(words,pattern);
    }

}
