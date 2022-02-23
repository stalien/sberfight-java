import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CanMakeString {
    /**
     * Напишите функцию, которая проверяет, можно ли из комбинации букв первой строки получить вторую строку. Каждый символ первой строки может быть использован только один раз. Строки состоят только из букв английского алфавита в нижнем регистре без пробелов и знаков пунктуации
     *
     * На входе: две непустые строки
     * На выходе: true - если возможно получить вторую строку из комбинации букв первой, иначе false
     *
     * Пример:
     *
     * canMakeString( "refrigerator" , "tear" ) --> true
     *
     * canMakeString( "drive" , "reed" ) --> false
     */
    public static boolean canMakeString(String s1, String s2) {
        // Write your code here...
        boolean result = false;

        List<String> str1 = new ArrayList<>();
        str1.addAll(Arrays.asList(s1.split("")));
        List<String> str2 = new ArrayList<>();
        str2.addAll(Arrays.asList(s2.split("")));

        for (int i = 0; i < str2.size(); i++) {
            if (str1.contains(str2.get(i))) {
                str1.remove(str2.get(i));
                str2.remove(i);
                System.out.println(str1);
                System.out.println(str2);
                i = -1;
            }
        }

        if (str2.size() == 0) {
            result = true;
        }

        System.out.println(result);
        return result;
    }

    public static void runCode() {
        // Entrypoint to debug your function
    }

    public static void main(String[] args) throws Exception {


        canMakeString("drive" , "reed");
    }

}
