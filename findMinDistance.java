import java.util.*;

public class findMinDistance {
    /**
     * Петя припарковал автомобиль в плохо освещенном переулке и пытается его найти. В самом начале до автомобиля 100 м, если двигаться в правую сторону. Петя перемещается по переулку либо влево, либо вправо, а затем останавливается и осматривается по сторонам. Найдите минимальное расстояние, которое отделяло Петю от автомобиля в ходе его поисков в момент, когда он стоял на месте.
     * Допущение:
     *
     * длина автомобиля не учитывается (считаем автомобиль точкой)
     * На входе: steps - массив чисел (integer) - перемещения Пети (вправо - со знаком "+", влево - со знаком "-")
     * На выходе: минимальное расстояние (integer)
     *
     *Аргумент
     * // 1: steps: Integer[]
     * [10, -20, 20, 30]
     * Ожидаемое значение
     * 60

     * Аргумент
     * // 1: steps: Integer[]
     * [-50, 20, 10, 10]
     * Ожидаемое значение
     * 100
     *
     */
    public static int findMinDistance(List<Integer> steps) {
        // Write your code here...
        int min = 100;
        Map<Integer, Integer> stepsMap = new HashMap<>();

        for (int i = 0; i < steps.size(); i++) {
            if (i == 0) {
                stepsMap.put(i, min - steps.get(i));
            } else {
                stepsMap.put(i, stepsMap.get(i - 1) - steps.get(i));
            }
            System.out.println(stepsMap.get(i));
        }

        for (int i = 0; i < stepsMap.size(); i++) {
            if (min > Math.abs(stepsMap.get(i))) {
                min = stepsMap.get(i);
            }

        }

        System.out.println("min: " + Math.abs(min));
        return Math.abs(min);
    }

    public static void runCode() {
        // Entrypoint to debug your function
    }

    public static void main(String[] args) throws Exception {
        List<Integer> steps = Arrays.asList(50, 20, 50, 40);

        findMinDistance(steps);
    }

}
