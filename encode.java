import java.util.ArrayList;
import java.util.*;

public class encode {
    /**
     * 4/5
     *
     * Напишите функцию, которая переводит сообщения на зашифрованный язык, в котором слова образуются путем переноса первой
     * буквы слова в конец и добавлением в конец слова букв "my".
     *
     * На входе: строка, состоящая минимум из одного слова; все слова состоят из букв английского алфавита в нижнем регистре.
     * Знаки пунктуации отделены пробелом.
     * На выходе: зашифрованная фраза с сохранением пунктуации.
     *
     * Пример:
     *
     * encode("there is the house where my family lives.") --> "heretmy simy hetmy ousehmy herewmy ymmy amilyfmy iveslmy."
     *
     * Аргумент
     * // 1: text: String
     * "george hasn’t finished his work yet."
     * Ожидаемое значение
     * "eorgegmy asn’thmy inishedfmy ishmy orkwmy etymy."
     * Консольный вывод
     * eorgegmy asn’thmy inishedfmy ishmy orkwmy etymy.
     *
     */
    public static String encode(String text) {
        // Write your code here...
        String result = "";
        // Делаем List строк из входной строки
        List<String> list = new ArrayList<>(Arrays.asList(text.split(" ")));
        System.out.println(list);

        // Проходим циклом по List от превого элемента до последнего
        for (String word : list) {
            // если в конце слова - запятая
            if (word.endsWith(",")) {
                //обрезать последний символ
                word = word.substring(0, word.length()-1);
                //трансформируем слово согласно заданному правилу
                word = word.substring(1) + word.substring(0, 1) + "my";
                //добавить запятую и пробел в конце
                result = result + word.concat(", ");
                continue;
            }

            // если в конце слова - точка
            if (word.endsWith(".")) {
                //обрезать последний символ
                word = word.substring(0, word.length()-1);
                //трансформируем слово согласно заданному правилу
                word = word.substring(1) + word.substring(0, 1) + "my";
                //добавить точку в конце
                result = result + word.concat(".");
                continue;
            }

            result = result + word.substring(1) + word.substring(0, 1) + "my ";
        }

        System.out.println(result);
        System.out.print("heretmy simy hetmy ousehmy herewmy ymmy amilyfmy iveslmy.");

        return result;
    }

    public static void runCode() {
        // Entrypoint to debug your function
    }

    public static void main(String[] args) throws Exception {


        encode("there is the house, where my family lives.");
    }

}
