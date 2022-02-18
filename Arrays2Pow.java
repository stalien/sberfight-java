import java.util.*;

public class Arrays2Pow {
    /**
     * Дано два массива чисел arr1 и arr2. Напишите функцию, которая проверяет, что для каждого элемента n массива arr1 есть элемент
     * m в массиве arr2, такой что m = n ** 2
     *
     * Примечание:
     *
     *     если в массиве arr1 несколько одинаковых элементов, для которых в массиве arr2 есть только один соответствующий элемент,
     *     то функция должна вернуть false
     *     если массив arr1 пуст, функция должна вернуть false
     *
     * На входе:
     *
     *     arr1 - массив чисел
     *     arr2 - массив чисел
     *
     * На выходе: true или false
     *
     * Пример:
     * 1.
     *
     * arr1 = [2, 3, 2]
     * arr2 = [4, 4, 9, 5]
     * getResult( arr1, arr2 ) -> true
     *
     * 2.
     *
     * arr1 = [2, 3, 2]
     * arr2 = [4, 9]
     * getResult( arr1, arr2 ) -> false
     *
     * // 1: arr1: Integer[]
     * [7, 3, 4, 4, 5, 3]
     *
     * // 2: arr2: Integer[]
     * [16, 16, 9, 49, 25, 9]
     *
     * Ожидаемое значение
     *
     * true
     *
     * Аргументы
     *
     * // 1: arr1: Integer[]
     * [7, 2, 6, 2, 1]
     *
     * // 2: arr2: Integer[]
     * [36, 4, 1, 4]
     *
     * Ожидаемое значение
     *
     * false
     *
     */
    public static boolean getResult(List<Integer> arr1, List<Integer> arr2) {
        // Write your code here...
        Set<Boolean> boolSet = new HashSet<>();
        List<Integer> tmpArr1 = new ArrayList<>();
        tmpArr1.addAll(arr1);
        List<Integer> tmpArr2 = new ArrayList<>();
        tmpArr2.addAll(arr2);

        if (arr1.size() == 0) {
            return false;
        }

        for (int i = 0; i < tmpArr1.size(); i ++) {
            for (int j = 0; j < tmpArr2.size(); j++) {
                if (tmpArr2.get(j).equals((int)Math.pow(tmpArr1.get(i), 2))) {
//                    boolSet.add(true);
                    tmpArr1.remove(i);
                    tmpArr2.remove(j);
                    i--;
                    break;
                }
            }
        }

        System.out.println(tmpArr1);
        System.out.println(tmpArr2);
//        System.out.println("boolSet: " + boolSet);

        if (tmpArr1.size() > 0) {
            System.out.println("false");
            return false;
        }

//        if (boolSet.size() == 1 && boolSet.contains(true)) {
//            System.out.println("true");
//            return true;
//        }

        System.out.println("true");
        return true;
    }

    public static void runCode() {
        // Entrypoint to debug your function
    }

    public static void main(String[] args) throws Exception {
        List<Integer> arr1 = Arrays.asList(7, 2, 6, 2, 1);
        List<Integer> arr2 = Arrays.asList(36, 4, 1, 4);

        getResult(arr1,arr2);
    }

}

