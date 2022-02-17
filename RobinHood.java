import java.util.*;

public class RobinHood {
    /**
     * 2 уровень сложности (100%)
     *
     * Доблестный или почти доблестный Робин Гуд и отправляетесь в новый поход в лес. Дан массив passersby , в котором содержится количество золотых у каждого путника в лесу, которого можно обокрасть. В результате кражи все деньги путника переходят к Робину.
     *
     * Но, каждый раз после того как совершена кража, Робин обязан отдать часть денег одному другому путнику, иначе его будут считать просто вором. Для очищения совести достаточно умножить сумму золотых прохожего вдвое, то есть, выгоднее всего отдавать деньги бедным.
     *
     * Робин Гуд волен сам выбирать у какого путника будет красть золотые, он также вправе не трогать проходящего человека. Главная задача Робина Гуда - оставить максимальное количество золотых себе, найдите это количество. Порядок кражи/вознаграждения не имеет значения. С каждым из путников Робин Гуд встречается единожды, то есть ограбить/вознаградить каждого прохожего можно только один раз, прохожий также может и не быть ограблен и не быть вознагражден.
     *
     * Ввод:
     *
     * passersby - массив прохожих, где passerby[i] - количество золотых прохожего i, 0<length(passerby)<=10, 0<passerby[i]<1000
     * Вывод:
     *
     * Integer - количество золотых, которые остались у Робин Гуда
     * Пример:
     *
     * passersby = [3, 10, 4, 8]
     * getResult(passersby) = 11
     *
     * Робин Гуд обокрал путников с 10 и 8 золотыми и одарил остальных двух на 3 и 4 золотых соответственно. То есть 10+8-3-4
     */

    public static int getResult(List<Integer> passersby) {
        // Write your code here...
        int count = 0;
        List<Integer> desc = new ArrayList<>();
        List<Integer> asc = new ArrayList<>();

        desc.addAll(passersby);
        Collections.sort(desc);
        Collections.reverse(desc);

        asc.addAll(passersby);
        Collections.sort(asc);

        int i = passersby.size();

        while (i > 1) {

            System.out.println("desc: " + desc);
            //отнимаем
            count += desc.get(0);
            desc.remove(0);
            i--;
            System.out.println("result: " + desc);

            //отдаем

            System.out.println("asc: " + asc);
            count -= asc.get(0);
            asc.set(0, asc.get(0) * 2);
            asc.remove(0);
            i--;
            System.out.println("result: " + asc);
        }

        System.out.println(count);

        return count;
    }

    public static void runCode() {
        // Entrypoint to debug your function
    }

    public static void main(String[] args) throws Exception {

        List<Integer> passersby  = new ArrayList<>();
        passersby .add(3);
        passersby .add(10);
        passersby .add(4);
        passersby .add(8);

        getResult(passersby );
    }
}
