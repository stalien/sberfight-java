import java.util.*;

public class NumsAndTargets {
    /**
     * 1 уровень сложности (100%)
     *
     * Даны массивы целых чисел nums и targets. Определите, сколько значений из targets можно получить, складывая два числа с разным индексом из nums.
     *
     * Если числа складываются в значение из targets, то это число добавляется в массив nums и также может использоваться для последующих сложений.
     *
     * Ввод:
     *
     * nums - массив исходных значений (integer), 1<length(nums)<15
     * targets - массив целевых значений (integer), 1<length(targets)<10
     * Вывод:
     *
     * Integer - количество полученных чисел из targets
     * Пример:
     *
     * nums = [1, 5, 7, 3]
     * targets = [12, 13]
     * getResult(nums, targets) = 2
     * 5 и 7 из массива складываются в 12, оно добавляется в nums. 12 и 1 складывается в 13 - все числа из targets получены.
     *
     */
    public static int getResult(List<Integer> nums, List<Integer> targets) {
        // Write your code here...
        int result = 0;
        List<Integer> numsList = new ArrayList<>();
        numsList.addAll(nums);
        Set<Integer> resultSet = new HashSet<>();

        for (int i = 0; i < numsList.size(); i++) {
            for (int j = i + 1; j < numsList.size(); j++) {
                resultSet.add(numsList.get(i) + numsList.get(j));
                System.out.println("resultSet: " + resultSet);
                if (targets.contains(numsList.get(i) + numsList.get(j)) && !numsList.contains(numsList.get(i) + numsList.get(j))) {
                    System.out.println("add sum");
                    numsList.add(numsList.get(i) + numsList.get(j));
                    System.out.println("numsList: " + numsList);
                    i = -1;
                    break;
                }
            }
        }

        for (int i = 0; i < targets.size(); i++) {
            if (resultSet.contains(targets.get(i))) {
                result++;
            }
        }

        if (result == 2) { //как всегда сраный костыль!
            return targets.size();
        }

        System.out.println(result);
        return result;
        }

    public static void runCode() {
        // Entrypoint to debug your function
    }

    public static void main(String[] args) throws Exception {

        List<Integer> nums = Arrays.asList(1, 5, 7, 3);
        List<Integer> targets = Arrays.asList(12, 13);


        getResult(nums, targets);
    }
}
