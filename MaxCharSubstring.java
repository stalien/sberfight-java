import javax.swing.plaf.SliderUI;
import java.util.*;

public class MaxCharSubstring {
    /**
     * 2 уровень сложности (100%)
     *
     * Дана строка s, она содержит подстроки c одинаковыми символами, подстроки разделены пробелом.
     *
     * Вы можете поэтапно заменять пробелы в строке на любые символы.
     *
     * Если между разными последовательностями не окажется пробела, то подстрока с бóльшим количеством символов заменит остальные подстроки. Например, строка
     * "aaabb" становится "aaaaa".
     *
     * Создайте максимально крупную подстроку заданного символа. Гарантируется, что одинакового количества разных символов в результате замен у двух подстрок
     * быть не может.
     *
     * Ввод:
     *
     * s - строка символов, все последовательности разделены пробелом, 1<=length(s)<=100, s[i]=space,a..z
     * symbol - заданный символ, length(symbol)=1
     * Вывод:
     *
     * Integer - количество одинаковых подряд идущих заданных символов
     *
     * Пример 1:
     *
     * s = "aaa bbb"
     * symbol = "a"
     * getResult(s, symbol) = 7 // пробел заменяем на "a", тогда получаем "aaaabbb", которая по правилу заменяется на "aaaaaaa" - всего 7 символов "a"
     * Пример 2:
     *
     * s = "bbbb cc aa"
     * symbol = "b"
     * getResult(s, symbol) = 10 // первый пробел заменяем на "b", тогда получаем "bbbbbcc aa", которая по правилу заменяется на "bbbbbbb aa", далее второй пробел заменяем на "b", получаем "bbbbbbbbaa" -> "bbbbbbbbbb", всего 10 символов "b"
     */

    public String rightConcat(String s, String sRight, String symbol){
        String resultString = "";

        return resultString;
    }

    public static int getResult(String s, String symbol) {
        // Write your code here...
        List<String> sList = new ArrayList<>(Arrays.asList(s.split(" ")));
        Integer maxSubstringLength = 0;

        System.out.println(sList);

        // может ли быть несколько вхождений строки с нужным симовлом?*???

        int count = 0;
        while (count < 10) {
            for (int i = 0; i < sList.size(); i++) { //ищем строку с нужным символом в массиве строк, 1 проход
                if (sList.size() > 1) {
                    if (sList.get(i).contains(symbol)) { //строка нужного символа, которую нужно сделать максимально большой
                        if (i == 0) { //строка на первом месте, пробел только справа
                            //сравниваем строку с соседней справа и заменяем на одинаковые символы по правилу
                            if (sList.get(i).length() + 1 > sList.get(i + 1).length()) {
                                //заменяем пробел справа на заданный символ
                                System.out.println(sList.get(i));
                                sList.set(i, sList.get(i).concat(symbol));
                                System.out.println(sList.get(i));

                                String tmp = "";
                                for (int j = 0; j < sList.get(i + 1).length(); j++) {
                                    tmp = tmp.concat(symbol);
                                }

                                sList.set(i, sList.get(i).concat(tmp));
                                sList.remove(i + 1);  //удаляем меньшую строку
                                System.out.println(sList);
                            }
                        } else if (i < sList.size() - 1) { //строка не последняя, т.е. пробелы есть и слева и справа
                            //выбираем сторону в которую выгоднее двигаться, сравним размеры соседних строк
                            if (sList.get(i).length() + 1 > sList.get(i + 1).length()) { //идем направо если результирующая длина строки больше той что справа
                                //заменяем пробел справа на заданный символ
                                System.out.println(sList.get(i));
                                sList.set(i, sList.get(i).concat(symbol));
                                System.out.println(sList.get(i));

                                //сравниваем строку с соседней справа и заменяем на одинаковые символы по правилу
                                    String tmp = "";
                                    for (int j = 0; j < sList.get(i + 1).length(); j++) {
                                        tmp = tmp.concat(symbol);
                                    }

                                    sList.set(i, sList.get(i).concat(tmp));
                                    sList.remove(i + 1);  //удаляем меньшую строку
                                    System.out.println(sList);

                            } else if (sList.get(i).length() + 1 > sList.get(i - 1).length()) { //идем налево если результирующая длина строки больше той что слева

                                //сравниваем строку с соседней слева и заменяем на одинаковые символы по правилу
                                if (sList.get(i).length() + 1 > sList.get(i - 1).length()) {
                                    //заменяем пробел слева на заданный символ
                                    System.out.println(sList.get(i));
                                    sList.set(i, sList.get(i).concat(symbol));
                                    System.out.println(sList.get(i));

                                    String tmp = "";
                                    for (int j = 0; j < sList.get(i - 1).length(); j++) {
                                        tmp = tmp.concat(symbol);
                                    }

                                    sList.set(i, sList.get(i).concat(tmp));
                                    sList.remove(i - 1);  //удаляем меньшую строку
                                    System.out.println(sList);
                                }
                            }
                        } else if (sList.size() > 1) { //строка последняя но не единственная, значит пробел только слева

                            //сравниваем строку с соседней слева и заменяем на одинаковые символы по правилу
                            if (sList.get(i).length() + 1 > sList.get(i - 1).length()) {
                                //заменяем пробел слева на заданный символ
                                System.out.println(sList.get(i));
                                sList.set(i, sList.get(i).concat(symbol));
                                System.out.println(sList.get(i));

                                String tmp = "";
                                for (int j = 0; j < sList.get(i - 1).length(); j++) {
                                    tmp = tmp.concat(symbol);
                                }

                                sList.set(i, sList.get(i).concat(tmp));
                                sList.remove(i - 1);  //удаляем меньшую строку
                                System.out.println(sList);
                            }
                        }
                    }
                } else break;
            }
            count++;
        }

        //найдем длину строки с заданным символом
        for (int i = 0; i < sList.size(); i++) {
            if (sList.get(i).contains(symbol)) {
                maxSubstringLength = sList.get(i).length();
            }
        }

        System.out.println(maxSubstringLength);
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

        getResult("b c aaaaa cccc", "c");
    }

}
