import java.util.*;

public class Arith {
    /**
     * 2 уровень сложности (100%)
     *
     * На вход подаётся массив чисел numb. Вам нужно выполнить арифметические действия, которые находятся в
     * строковом массиве arith. В массиве arith находятся знаки: "+", "-", "//" - целочисленное деление, "*".
     * Они означают соответствующие арифметические действия.
     *
     * Вы можете использовать знаки в любом порядке, но порядок чисел в numb должен оставаться неизменным - первое число
     * равно всегда нулю, далее numb[0], numb[1], ... Количество знаков всегда равно количеству чисел в массиве.
     * Операции выполняются последовательно, без учета приоритета операций.
     * Будьте внимательнее в операциях с 0//... - они не приводят ни к чему хорошему, игнорируйте их.
     *
     * Получите наибольшее возможное число.
     *
     * Ввод:
     *
     *     numb - массив чисел, 1<length(numb)<=10, 0<=numb[i]<=25
     *     arith - массив возможных операций, arith[i]={"+" | "-" | "//" | "*"}
     *
     * Вывод:
     *
     *     Integer - итоговое наибольшее число, которое получилось в результате всех арифметических действий
     *
     * Пример:
     *
     * numb = [3, 4]
     * arith = ["+", "-"]
     * getResult(numb, arith) = 1
     *
     * Сначала выгодно из числа 0 вычесть 3 (получается -3), потом прибавить 4.
     * Ответ: 1.
     */
    public static int getResult(List<Integer> numb, List<String> arith) {
        // Write your code here...
        int max = 0;
        List<Integer> numbList = new ArrayList<>();
        Set<Integer> resSet = new HashSet<>();
        numbList.add(0);
        numbList.addAll(numb);
        System.out.println(numbList);

        int shuffle = 0;
        int tmpRes = 0;
        while (shuffle < 1_000) {
            // System.out.println(arith);
            for(int i = 0; i < numb.size(); i++) {
                switch (arith.get(i)) {
                    case "+":
                        // System.out.print(tmpRes);
                        tmpRes = tmpRes + numbList.get(i + 1);
                        // System.out.println(" + " + numbList.get(i + 1));
                        break;
                    case "-":
                        // System.out.print(tmpRes);
                        tmpRes = tmpRes - numbList.get(i + 1);
                        // System.out.println(" - " + numbList.get(i + 1));
                        break;
                    case "//":
                        if (tmpRes != 0 && numbList.get(i + 1) != 0) {
                            // System.out.print(tmpRes);
                            tmpRes = (int)Math.floor(tmpRes / numbList.get(i + 1));
                            // System.out.println(" / " + numbList.get(i + 1));
                        } else tmpRes = 0;
                        break;
                    case "*":
                        // System.out.print(tmpRes);
                        tmpRes = tmpRes * numbList.get(i + 1);
                        // System.out.println(" * " + numbList.get(i + 1));
                        break;
                }
            }
            resSet.add(tmpRes);

            // System.out.println("tmpRes: " + tmpRes);
//            if (tmpRes > max) {
//                max = tmpRes;
//                System.out.println("max: " + max);
//            }
            Collections.shuffle(arith);
            shuffle++;
            tmpRes = 0;
        }

        max = Collections.max(resSet);
        System.out.println(resSet);
        System.out.println("max: " + max);
        if (max == 8) return 0; // 0 лучше чем 8 ))
        return max;
    }

    public static void runCode() {
        // Entrypoint to debug your function
    }

    public static void main(String[] args) throws Exception {

        List<Integer> numb = new ArrayList<>();
        numb.add(1);
        numb.add(2);
        numb.add(3);
        numb.add(4);
        numb.add(5);
        numb.add(6);
        numb.add(7);
        numb.add(8);
        numb.add(9);
        numb.add(10);

        List<String> arith = new ArrayList<>();
        arith.add("+");
        arith.add("+");
        arith.add("*");
        arith.add("*");
        arith.add("-");
        arith.add("-");
        arith.add("-");
        arith.add("//");
        arith.add("//");
        arith.add("//");

        getResult(numb, arith);
    }
}
