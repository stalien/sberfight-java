import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Jumps {
    /**
     * 2 уровень сложности (100%)
     *
     * Вы играете в игру, где ваш персонаж прыгает по заборчикам. Значения в массиве означают, сколько заборчиков персонаж
     * обязан перешагнуть, двигаясь вперед, начиная с этого индекса. Например, в массиве 2, 1, 0 с нулевого индекса нужно
     * прыгнуть на второй индекс, с первого - прыгнуть на второй, со второго - остаться на месте. Вы можете менять элементы
     * в массиве местами.  А за пределами всего массива пропасть, из которой нельзя вылезти.
     *
     * Чтобы выиграть, персонажу нужно с нулевого индекса дойти до последнего. Выведите true, если победить в игре возможно,
     * в противном случае - false.
     *
     * Ввод:
     *
     *     fences - массив значений длин прыжков. Персонаж начинает с нулевого индекса, 1<length(fences)<=20, -10<=fences[i]<=15
     *
     * Вывод:
     *
     *     Boolean - возможно ли победить. Победить нельзя, если даже при перестановках элементов в массиве дойти до
     *     последнего индекса в массиве персонажу будет невозможно
     *
     * Пример 1:
     *
     * fences = [0, 2, 4, 1, 6, 2]
     * getResult(fences) = True
     *
     * Один из возможных вариантов: [1, 4, 2, 0, 6, 2]. Герой с 0-го индекса прыгнул на 1-ый, и сразу же смог прыгнуть на
     * последний индекс массива - он победил
     *
     * Пример 2:
     *
     * fences = [2,-1,0,2]
     * getResult(fences) = True
     *
     * Вариант победы: [2, 2, -1, 0]. Герой с 0-го индекса прыгнул на 2-ой, далее назад на один индекс и прыжок на 2 - это
     * последний индекс, победа
     */
    public static boolean getResult(List<Integer> fences) {
        // Write your code here...
        boolean maybee = false;

        int i = 0, jumpsCount = 0, shuffles = 0;
//        boolean stop = true;

        while (shuffles < 100) {
            System.out.println(fences);
            while (jumpsCount < fences.size()) {
                if (i == fences.size() - 1) {
                    System.out.println("victory!");
                    return true;
                }
                if (i < 0 || i > fences.size() - 1) {
                    System.out.println("game over");
                    break;
                }
                i += fences.get(i);
                jumpsCount++;

            }
            Collections.shuffle(fences);
            i = 0;
            jumpsCount = 0;
            shuffles++;
        }

        return maybee;
    }

    public static void runCode() {
        // Entrypoint to debug your function
    }

    public static void main(String[] args) throws Exception {
        List<Integer> fences = new ArrayList<>();

        fences.add(2);
        fences.add(0);
        fences.add(4);
        fences.add(1);
        fences.add(6);
        fences.add(2);

        getResult(fences);
    }

}
