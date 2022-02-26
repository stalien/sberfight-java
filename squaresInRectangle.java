import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class squaresInRectangle {
    /**
     *
     * Даны размеры прямоугольника: длина и ширина. Требуется определить, на какие квадраты его можно разбить. Число квадратов должно быть минимальным. Ответом будет являться массив длин сторон квадратов в порядке убывания.
     *
     * На входе: длина и ширина прямоугольника (длина и ширина не равны друг другу)
     * На выходе: массив чисел
     *
     * Пример:
     *
     * squaresInRectangle( 5, 3 ) --> [3, 2, 1, 1]
     * Прямоугольник 5 x 3 разбивается на 4 квадрата: (3 х 3), (2 х 2), (1 х 1), (1 х 1).
     *
     */
    public static List<Integer> squaresInRectangle(int length, int width) {
        // Write your code here...
        List<Integer> result = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        tmp.addAll(Arrays.asList(length, width));

        while (tmp.get(0) > 0) {
            Collections.sort(tmp);
            Collections.reverse(tmp);
            System.out.println(tmp);
            result.add(Collections.min(tmp));
            tmp.set(0, tmp.get(0) - Collections.min(tmp));
        }

        System.out.println(result);
        return result;
    }

    public static void runCode() {
        // Entrypoint to debug your function
    }

    public static void main(String[] args) throws Exception {

        squaresInRectangle(5, 3);
    }

}
