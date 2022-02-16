import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Thieves {
    /**
     * В анонимном клубе воров присутствуют n человек. У вас есть массив cash, который содержит богатство каждого вора.
     *
     * Каждый вор может украсть у других не более k монет. Определите, какой вор может стать самым богатым в клубе.
     *
     * На входе:
     *
     * cash - количество золотых каждого вора (integer[])
     * k - сколько каждый вор может украсть у других в сумме (integer)
     * На выходе:
     *
     * Integer[] - номера воров, которые могут стать самыми богатыми, отсчёт начинается с единицы
     * Пример:
     *
     * cash = [1, 3, 4, 2]
     * k = 2
     * getResult(cash, k) = [2, 3, 4]
     *
     * 1. первый вор будет иметь 3 золотых монеты, в массиве как минимум будет 1 вор с таким же капиталом.
     * 2. Одно из решений - [1, 5, 1, 2]
     * 3. Одно из решений - [1, 1, 6, 2]
     * 4. Одно из решений - [1, 3, 2, 4]
     */
    public static List<Integer> getResult(List<Integer> cash, int k) {
        // Write your code here...

        //обратно-сортированный список богатств
        List<Integer> sorted = new ArrayList<>(cash);
        Collections.sort(sorted);
        Collections.reverse(sorted);

        //список воров, богаче которых нужно стать при данном k
        List<Integer> mayBeRich = new ArrayList<>();

        //итерируем по списку богатств, чтобы определить потенциал воровства
        for (int i = 0; i < cash.size(); i++) {

            //проверяем только тех, богаче кого можно стать потенциально при данном k
            int richValue = cash.get(i) + k;

            List<Integer> mayBeThyved = new ArrayList<>(sorted);
            int max = Collections.max(mayBeThyved);

            //богатство, кродется
            if (richValue <= max){
                int l = k;
                while (l > 0) {
                    for (int j = 0; j < sorted.size(); j++) {
                        if (richValue <= sorted.get(j)) {
                            mayBeThyved.set(j,mayBeThyved.get(j) - 1);
                            Collections.sort(mayBeThyved);
                            Collections.reverse(mayBeThyved);
                            break;
                        }
                    }
                    l -= 1;
                }
            }

            //максимальное значение списка
            if (true){
                max = Collections.max(mayBeThyved);

                if ((richValue) > max) {
                    mayBeRich.add(i + 1);
                }
            }

        }

        System.out.println(mayBeRich);
        return mayBeRich;
    }

    public static void runCode() {
        // Entrypoint to debug your function
    }

    public static void main(String[] args) throws Exception {
        List<Integer> cash = new ArrayList<>();
        int k = 2;

        cash.add(1);
        cash.add(3);
        cash.add(4);
        cash.add(2);

        getResult(cash, k);
    }

}
