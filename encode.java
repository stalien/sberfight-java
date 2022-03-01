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
        List<String> list = new ArrayList<>(Arrays.asList(text.split(" ")));

        for (int i = 0; i < list.size() - 1; i++) {
            result = result + list.get(i).substring(1) + list.get(i).substring(0, 1) + "my ";
        }
            result = result + list.get(list.size() - 1).substring(1, list.get(list.size() - 1).length() - 1)
                    + list.get(list.size() - 1).substring(0, 1) + "my"
                    + list.get(list.size() - 1).substring(list.get(list.size() - 1).length() - 1);

        System.out.println(result);

        return result;
    }

    public static void runCode() {
        // Entrypoint to debug your function
    }

    public static void main(String[] args) throws Exception {


        encode("there is the house where my family lives.");
    }

}
