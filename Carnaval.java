import java.util.*;

public class Carnaval {
    /**
     * 1 уровень сложности(100%)
     *
     * Вы купили дорогой билет на карнавал и хотите попасть на все представления. Учитывая время начала мероприятий и длительности проведения, ответьте, возможно ли это. Время перемещения между мероприятиями не учитывается.
     *
     * На входе:
     *
     * time - интервалы проведения представлений (string[]) в формате: "час_начала-час_окончания"
     * На выходе:
     *
     * Boolean - возможно ли полностью посмотреть каждое представление
     * Пример 1:
     *
     * time = ["09-13", "12-14"]
     * getResult(time) = false
     * Первое представление идёт с 9 часов до 13, а второе начинается в 12.
     * Так что побывать на всех представлениях полностью не получится.
     * Пример 2:
     *
     * time = ["07-09", "10-12", "15-19"]
     * getResult(time) = true
     */
    public static boolean getResult(List<String> time) {
        // Write your code here...
        boolean result = false;
        List<List<String>> timesList = new ArrayList<>();

        String timeStart, timeEnd;

        for (int i = 0; i < time.size(); i++) {
            List<String> tmp = new ArrayList<>();
            timeStart = time.get(i).substring(0, time.get(i).indexOf("-"));
            timeEnd = time.get(i).substring(time.get(i).indexOf("-") + 1);
            tmp.add(timeStart);
            tmp.add(timeEnd);
            timesList.add(tmp);
        }
        System.out.println(timesList);

        for (int i = 0; i < timesList.size() - 1; i++) {
            if (Integer.valueOf(timesList.get(i).get(1)) <= Integer.valueOf(timesList.get(i + 1).get(0))) {
                result = true;
            } else {
                result = false;
                break;
            }
        }

        return result;
    }


    public static void runCode() {
        // Entrypoint to debug your function
    }

    public static void main(String[] args) throws Exception {
        List<String> time = new ArrayList<>();

        time.add("07-09");
        time.add("10-12");
        time.add("15-19");

        getResult(time);
    }

}
