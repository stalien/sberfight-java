import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.*;

public class ZamenaSumm {
    /**
     * 2 уровень сложности (100%)
     *
     * Дан массив состоящий из латинских символов. Каждый символ в массиве можно заменить на любое натуральное число.
     * После замены все идентичные символы будут также заменены на такое же число.
     * Определите, возможно ли сделать сумму значений массива равной k.
     * Ввод:
     * * sub_array - массив латинских символов, 0<length(sub_array)<20, sub_array[i]="x" | "y" | "z"
     * * k - значение суммы массива, которую нужно получить, 0<k<150
     * Вывод:
     * * Boolean - можно или нельзя сделать сумму значений массива sub_array равной k
     * Пример:
     * sub_array = ["x", "x", "x", "y", "y"]
     * k = 12
     * getResult(sub_array, k) = True // Можно заменить x на 2, y на 3, тогда получится [2, 2, 2, 3, 3]
     *
     * // 1: subArray: String[]
     * ["x", "x", "y", "y"]
     *
     * // 2: k: Integer
     * 20
     *
     * true
     */
    public static boolean getResult(List<String> subArray, int k) {
        // Write your code here...
        boolean result = false;
        List<String> varTypes = new ArrayList<>();
        Map<String, Integer> varMap = new HashMap<>();

        for (String item: subArray) {
            if (!varMap.containsKey(item)) {
                varMap.put(item, 1);
            } else
                varMap.put(item, varMap.get(item) + 1);
        }
        System.out.println("varMap: " + varMap);

        varTypes.add(subArray.get(0));
        for (int i = 1; i < subArray.size(); i++) {
            if (!varTypes.contains(subArray.get(i))) {
                varTypes.add(subArray.get(i));
            }
        }
        System.out.println("varTypes: " + varTypes);

//            12 = [x*3 + y*2]

        //////////////////////

        double median = (double)k / (double)subArray.size();
        median = Math.floor(median);
        System.out.println("median: " + median);

        List<Integer> tmpMedian = new ArrayList<>();
        List<Integer> tmpTypes = new ArrayList<>();
        int offset = 0;

        while (offset < 5) {
            if (subArray.size() > 1) {
                if (subArray.size() % 2 == 0) { //четное

                    for (int i = 0; i < varTypes.size(); i++) {
                        int tmpVal = (int)median - varTypes.size() / 2 + i;
                        if (subArray.get(subArray.size()/2 - 1).equals(subArray.get(subArray.size()/2))
                                && tmpVal == median) {
                            tmpTypes.add(tmpVal + offset);
                            continue;
                        }
                        tmpTypes.add(tmpVal + offset);
                    }
                    System.out.println("tmpTypes: " + tmpTypes);

                } else { //нечетное
                    for (int i = 0; i < varTypes.size(); i++) {
                        int tmpVal = (int) median - varTypes.size() / 2 + i;
                        tmpTypes.add(tmpVal + offset);
                    }
                    System.out.println("tmpTypes: " + tmpTypes);

                }
            } else if (subArray.size() == 1) {
                return true;
            }

            for (String item : subArray) {
                tmpMedian.add(tmpTypes.get(varTypes.indexOf(item)));
            }
            System.out.println("tmpMedian: " + tmpMedian);

            int dif = k - tmpMedian.stream().mapToInt(Integer::intValue).sum();
            System.out.println("dif: " + dif);
            if (dif == 0) {
                return true;
            } else {
                if (dif < 0) break;
                if (dif > 0 && varMap.containsValue(1)) {
                    return true;
                }
                if (dif == 2 && varMap.containsValue(2)) {
                    return true;
                }
                if ((dif == 3 && varMap.containsValue(3)) || (varMap.containsValue(1) && varMap.containsValue(2))) {
                    return true;
                }
                if ((dif == 4 && varMap.containsValue(4)) || (varMap.containsValue(1) && varMap.containsValue(3))) {
                    return true;
                }
                if ((dif == 5 && varMap.containsValue(5)) || (varMap.containsValue(2) && varMap.containsValue(3))) {
                    return true;
                }
                tmpTypes.clear();
                tmpMedian.clear();
                offset++;
            }
        }


        ////////////////////////

//        for (int nums = 1; nums <= k; nums++) {
//
//            for (int varNum = 0; varNum < varMap.size(); varNum++) {
//
//            }
//
//        }
//
//        for (int j = 1; j < 10; j++) {
//            int tmpSum = 0;
//                System.out.println("j:" + j);
//                int tmpInd = 0;
//                for (Map.Entry<String, Integer> entry : varMap.entrySet()) {
//                    System.out.println("entry: " + entry.getValue());
//                    tmpSum += entry.getValue() * (j + tmpInd);
//                    System.out.println("tmpSum: " + tmpSum);
//                    tmpInd++;
//                }
//                if (tmpSum == k) {
//                    result = true;
//                    break;
//                }
//
//        }

        System.out.println(result);

        return result;
    }

    public static void runCode() {
        // Entrypoint to debug your function
    }

    public static void main(String[] args) throws Exception {

        int k = 41;

        List<String> subArray = new ArrayList<>();
        subArray.add("x");

        subArray.add("y");

        subArray.add("z");

        getResult(subArray, k);
    }
}
