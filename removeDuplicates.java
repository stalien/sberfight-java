import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class removeDuplicates {
    /**
     * Дана строка s. Необходимо удалить из нее все символы, которые повторяются ровно k раз подряд.
     * Удаление дубликатов состоит из выбора k соседних одинаковых букв в строке s и удаления их.
     * В результате мы получаем новую строку без удаленных букв. Если в полученной строке есть буквы, повторяющиеся k раз,
     * то повторяем описанный процесс заново до тех пор, пока в строке не останется дубликатов, повторяющихся k раз подряд.
     *
     * Напишите функцию, которая возвращает конечную строку после того, как были сделаны все возможные удаления символов.
     *
     * Гарантируется, что ответ будет уникальным.
     *
     * На входе:
     *
     *     строка s - исходная строка
     *     число k - количество повторов, k >= 2
     *
     * На выходе: новая строка
     *
     * Пример:
     *
     * s = "deeedbbcccbdaa"
     * k = 3
     * removeDuplicates( s, k ) --> "aa"
     *
     * 1 шаг: удаляем буквы "eee" и "ccc", получаем строку "ddbbbdaa"
     * 2 шаг: удаляем "bbb", получаем строку "dddaa"
     * 3 шаг: удаляем "ddd", получаем строку "aa"
     *
     *
     *
     *
     */
    public static String removeDuplicates(String s, int k) {
        // Write your code here...
        String result = "";
        List<String> strList = new ArrayList<>();
        strList.addAll(Arrays.asList(s.split("")));

        System.out.println(strList);

        int count = 0;
        while (count < 5) {
            for (int i = 0; i < strList.size(); i++) {
                int tmp = 1;
                for (int j = i + 1; j < strList.size(); j++) {
                    if (strList.get(j).equals(strList.get(i))) {
                        tmp++;
                    } else {
                        break;
                    }
                }
                if (tmp > k - 1) {
                    for (int j = i; j < k + i; j++) {
                        System.out.println("remove " + strList.get(i));
                        System.out.println(i);
                        strList.remove(i);
                    }
                    i = 0;
                }

                System.out.println(strList);
            }
            count++;
        }

        System.out.println(strList);
        return result;
    }

    public static void runCode() {
        // Entrypoint to debug your function
    }

    public static void main(String[] args) throws Exception {


        removeDuplicates("deeedbbcccbdaa", 2);
    }

}
