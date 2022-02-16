import java.util.*;

public class MaxSum {
    /**
     * Дан числовой массив. Выведите подмассив подряд идущих элементов, который имеет наибольшую сумму и имеет
     * хотя бы один элемент внутри.
     *
     * На входе: nums - числовой массив
     *
     * На выходе: числовой массив, подряд идущих элементов, который имеет наибольшую сумму
     *
     * Пример:
     *
     * numb = [4, 2, 8, -5, 2]
     * getResult(nums) = [4, 2, 8]
     */
    public static List<Integer> getResult(List<Integer> numb) {
        // Write your code here...
        List<Integer> result = new ArrayList<>();
        TreeMap<Integer, List<Integer>> sumMap = new TreeMap<>();

        int window = numb.size();
        while (window > 0) {
            for (int firstIndex = 0; firstIndex <= numb.size() - window; firstIndex++) {
                int sum = 0;
                for (int i = firstIndex; i < firstIndex + window; i++) {
                    sum += numb.get(i);
                }
                sumMap.put(sum, numb.subList(firstIndex, firstIndex + window));
            }

            window --;
        }
        System.out.println(sumMap);

//        for (Map.Entry<List<Integer>, Integer> entry : sumMap.entrySet()) {
//            if (Objects.equals(Collections.max(sumMap.values()), entry.getValue())) {
//                result.addAll(entry.getKey());
//            }
//        }

        result.addAll(sumMap.lastEntry().getValue());

        System.out.println(result);
        return result;
    }

    public static void runCode() {
        // Entrypoint to debug your function
    }

    public static void main(String[] args) throws Exception {

        List<Integer> numb = new ArrayList<>();
        numb.add(2);
        numb.add(4);
        numb.add(-5);
        numb.add(3);
        numb.add(3);
        numb.add(-7);
        numb.add(5);
        numb.add(1);

        getResult(numb);
    }
}
