import java.util.*;

public class Palindrom {
    /**
     * Напишите функцию, которая проверяет, является ли какая-либо из анаграмм заданного слова палиндромом.
     * Анаграмма это слово, образованное путем перестановки букв исходного слова.
     * Палиндром - слово одинаково читающееся в обоих направлениях.
     *
     * На входе: строка word - заданное слово
     * На выходе: true - если какая-либо из анаграмм является палиндромом, иначе - false
     * Пример:
     *
     * palindromeAnagram("abcabc") --> true # вариант палиндрома abccba
     * palindromeAnagram("aabbcd") --> false
     *
     */
    public static boolean palindromeAnagram(String word) {
        // Write your code here...
        List<Character> wordList = new ArrayList<>();

        for (char ch : word.toCharArray()) {
            wordList.add(ch);
        }

        Collections.sort(wordList);

            for (int i = 0; i < wordList.size(); i++) {
                for (int j = i + 1; j < wordList.size(); j++) {
                    if (wordList.get(i).equals(wordList.get(j))) {
                        wordList.remove(j);
                        wordList.remove(i);
                        i = -1;
                        break;
                    }
                }
            }

            System.out.println(wordList);

            if (wordList.size() < 2) {
                return true;
            }

        return false;
    }

    public static void runCode() {
        // Entrypoint to debug your function
    }

    public static void main(String[] args) throws Exception {


        palindromeAnagram("dbcabca");
    }

}

