import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ArrayNumsMoves {
    /**
     * Дан массив чисел nums. За один ход можно выбрать любой элемент и уменьшить его на 1.
     *
     * Массив nums является зигзагообразным массивом, если выполняется одно из условий:
     *
     *     Каждый элемент на четной позиции больше, чем соседние элементы
     *
     * nums[0] > nums[1] < nums[2] > nums[3] < nums[4]>...
     *
     *     Каждый элемент на нечетной позиции больше, чем соседние элементы
     *
     * nums[0] < nums[1] > nums[2] < nums[3] > nums[4]<...
     *
     * Напишите функцию, которая возвращает минимальное количество ходов для преобразования заданного массива nums в зигзагообразный массив.
     *
     * На входе: массив чисел nums
     * На выходе: целое число - количество ходов
     *
     * Пример:
     *
     * nums = [1,2,3]
     * moves( nums ) --> 2
     *
     * Мы можем за два хода уменьшить 2 до 0 (либо 3 до 1).
     *
     */
    public static int moves(List<Integer> nums) {
        // Write your code here...
        int result = 0, res1 = 0, res2 = 0;
        List<Integer> nums1 = new ArrayList<>();
        nums1.addAll(nums);
        List<Integer> nums2 = new ArrayList<>();
        nums2.addAll(nums);

        for (int i = 0; i < nums1.size(); i++) {
            if (i % 2 != 0) {
                System.out.println(i);
                int min = Collections.min(nums1);
                if (i != 0 && i != nums1.size() - 1) {
                    min = Math.min(nums1.get(i - 1), nums1.get(i + 1));
                } else
                if (i == nums1.size() - 1) {
                    min = nums1.get(i - 1);
                } else
                if (i == 0) {
                    min = nums1.get(i + 1);
                }

                System.out.println("min: " + min);

                while (nums1.get(i) >= min) {
                    nums1.set(i, nums1.get(i) - 1);
                    res1++;
                }
                System.out.println(nums1);

            }
        }
        for (int i = 0; i < nums2.size(); i++) {
            if (i % 2 == 0) {
                System.out.println(i);
                int min = Collections.min(nums2);
                if (i != 0 && i != nums2.size() - 1) {
                    min = Math.min(nums2.get(i - 1), nums2.get(i + 1));
                } else
                if (i == nums2.size() - 1) {
                    min = nums2.get(i - 1);
                } else
                if (i == 0) {
                    min = nums2.get(i + 1);
                }

                System.out.println("min: " + min);

                while (nums2.get(i) >= min) {
                    nums2.set(i, nums2.get(i) - 1);
                    res2++;
                }
                System.out.println(nums2);

            }
        }

        result = Math.min(res1, res2);

        System.out.println("result: " + result);
        return result;
    }

    public static void runCode() {
        // Entrypoint to debug your function
    }

    public static void main(String[] args) throws Exception {
        List<Integer> nums = new ArrayList<>(Arrays.asList(9, 6, 1, 6, 2, 1));


        moves(nums);
    }

}
