import java.util.*;

public class LessMedian {
    /**
     * 1 уровень сложности (100%)
     *
     * Дан числовой массив. Необходимо найти все числа, которые меньше медианного значения в массиве.
     *
     * На входе:
     *
     *     nums - числовой массив, 1<length(nums)<=10, 0<nums[i]<2000
     *
     * На выходе:
     *
     *     Integer[] - числа из массива nums, которые меньше медианного значения
     *
     * Пример:
     *
     * nums = [1, 3, 5, 6, 7]
     * getResult(nums) = [1, 3]
     *
     * Медианное число - 5
     *
     */
    public static List<Integer> getResult(List<Integer> nums) {
        // Write your code here...
        double median, mid, mid2;
        List<Integer> resultList = new ArrayList<>();

        Collections.sort(nums);

        mid = (double)nums.get(nums.size()/2);
        mid2 = (double)nums.get(nums.size()/2 - 1);

        if (nums.size() % 2 == 0) {
            median = (mid + mid2)/2;
        } else {
            median = mid;
        }
        System.out.println(median);

        for (int i = 0; i < nums.size(); i++) {
            if (nums.get(i) < median) {
                resultList.add(nums.get(i));
            }
        }

        System.out.println(resultList);
        return resultList;
    }

    public static void runCode() {
        // Entrypoint to debug your function
    }

    public static void main(String[] args) throws Exception {

        List<Integer> nums = new ArrayList<>();
        nums.add(1);
        nums.add(3);
        nums.add(2);
        nums.add(2);

        getResult(nums);
    }
}
