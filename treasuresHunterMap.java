import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class treasuresHunterMap {
    /**
     * Вы сбежали от тянущейся рутины и отправились в приключение! Каждый день вы можете спуститься в подземелье и найти сокровища. Ваша задача забрать с собой как можно больше сокровищ. Однако, если вы пойдёте за сокровищами во второй день подряд, то у вас украдут половину сокровищ текущего, второго дня другие искатели приключений, действуйте осторожно!
     *
     * Чтобы этого избежать, вы можете взять паузу в один день.
     *
     *  Ввод:
     * treasures - массив сокровищ, treasures[i] - количество сокровищ, i - номер дня
     *
     *  Вывод:
     * integer - максимальное количество сокровищ за приключение, округленное в большую сторону
     *
     * Example:
     *
     * treasures = [4, 2, 5, 1, 5]
     * getResult(treasures) = 14
     * В данном случае, вы забрали сокровища 0, 2 и 4 дня (4 + 5 + 5 = 14)
     */
    public static int getResult(List<Integer> treasures) {
        // Write your code here...
//        BigInteger maxTreasures = new BigInteger("0");
        double maxTreasures = 0;
//        boolean pause = false;
//        boolean secondDay = false;
//        List<Integer> tempSum = new ArrayList<>();
        List<double[]> prev_stack = new ArrayList<>();
        List<double[]> stack = new ArrayList<>();
//        Map<Integer, List<Integer>> tresMap = new HashMap<>();

        double[] temp = {0,0};
        stack.add(temp);

        for (int i = 0; i < treasures.size(); i++) {
            prev_stack.addAll(stack);
            stack.clear();

            for (double[] st : prev_stack) {
                if (st[0] == 1) {
                    //берем и половиним добычу
                    temp = new double[] {1, st[1] + (double)treasures.get(i)/2};
                    stack.add(temp);
                    maxTreasures = Math.max(maxTreasures, temp[1]);
                    //пропускаем
                    temp = new double[] {0, st[1]};
                    stack.add(temp);
                    maxTreasures = Math.max(maxTreasures, temp[1]);
                } else {
                    //берем все
                    temp = new double[] {1, st[1] + treasures.get(i)};
                    stack.add(temp);
                    maxTreasures = Math.max(maxTreasures, temp[1]);
                    //пропускаем
                    temp = new double[] {0, st[1]};
                    stack.add(temp);
                    maxTreasures = Math.max(maxTreasures, temp[1]);
                }
            }

        }

        System.out.println(treasures);
        System.out.println(stack);
        System.out.println(maxTreasures);
        return (int)Math.ceil(maxTreasures);
    }

    public static void runCode() {
        // Entrypoint to debug your function
    }

    public static void main(String[] args) throws Exception {

        List<Integer> treasures = new ArrayList<>();
        treasures.add(1);
        treasures.add(1);
//        treasures.add(1);
//        treasures.add(1);
//        treasures.add(1);
//        treasures.add(50);

        getResult(treasures);
    }
}
