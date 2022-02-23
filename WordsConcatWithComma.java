import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class WordsConcatWithComma {
    /**
     * 6/8
     *
     * Напишите функцию, которая принимает на вход массив строк и возвращает строку, отформатированную согласно следующим правилам:
     *
     * 1. все слова, кроме последнего, отделяются от предыдущего запятой
     * 2. последнее слово отделяется союзом "и"
     * 3. пустые строки игнорируются
     *
     * Примечание:  элементы массива могут быть либо пустой строкой, либо строкой, состоящей из букв английского алфавита.
     *
     * На входе:
     *
     *     words - массив строк, содержащий не менее 1 элемента
     *
     * На выходе: отформатированная строка
     *
     * Например:
     *
     * humanReadable( ["Python", "JavaScript", "Java"] ) --> "Python, JavaScript и Java"
     *
     * Аргумент
     *
     * // 1: words: String[]
     * ["Java", "", "JavaScript", "Python"]
     *
     * Ожидаемое значение
     *
     * "Java, JavaScript и Python"
     *
     * Консольный вывод
     *
     * Java, JavaScript и Python
     *
     * Тест-кейс #3Провален
     * 0.092 сек.
     * Аргумент
     *
     * // 1: words: String[]
     * ["Python"]
     *
     * Ожидаемое значение
     *
     * "Python"
     *
     * Консольный вывод
     *
     * Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: Index -1 out of bounds for length 1
     * 	at java.base/java.util.Arrays$ArrayList.get(Arrays.java:4165)
     * 	at Solution.humanReadable(Geecko.java:23)
     * 	at Geecko.main(Geecko.java:39)
     *
     * Тест-кейс #4Пройден
     * 0.099 сек.
     * Аргумент
     *
     * // 1: words: String[]
     * ["", "", "", ""]
     *
     * Ожидаемое значение
     *
     * ""
     */
    public static String humanReadable(List<String> words) {
        // Write your code here...
        String result = "";

        words.removeAll(Collections.singleton(""));
        if (words.size() == 1) {
            System.out.println(words.get(0));
            return words.get(0);
        }

        for (int i = 0; i < words.size(); i++) {
            if (i < words.size() - 2) {
                result = result.concat(words.get(i) + ", ");
            }
            if (i == words.size() - 1){
                result = result.concat(words.get(i - 1) + " и " + words.get(i));
            }
        }

        System.out.println(result);
        return result;
    }

    public static void runCode() {
        // Entrypoint to debug your function
    }

    public static void main(String[] args) throws Exception {
        List<String> words = new ArrayList<>(Arrays.asList("Python", "JavaScript", "Java"));


        humanReadable(words);
    }

}
