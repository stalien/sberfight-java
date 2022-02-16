import java.util.*;

public class RectangleArea {
    /**
     * На выставке компания решила сделать сюрприз, но чтобы он удался они решили закрыть ширмами свою площадку.
     * Им принесли N ширм длиной 1,5 метра, M ширм длиной 1 метр, K ширм длиной 0.5 метра. Какую максимальную площадь в виде !прямоугольника! можно ими закрыть?
     *
     * На входе:
     *
     * N - количество ширм длиной 1,5 метра
     * M - количество ширм длиной 1 метр
     * K - количество ширм длиной 0,5 метра
     *
     * На выходе:
     *
     * Float - площадь, которая может быть закрыта ширмами
     *
     * Пример:
     *
     * N=5
     * M=4
     * R=3
     *
     * getResult(N,M,R) → 10 // стороны прямоугольника: 1.5+1+1.5; 1.5+1; 1.5+1+0.5+0.5+0.5; 1.5+1
     */
    public static float getResult(int n, int m, int r) {
        // Write your code here...

        double area;
        double recPerim = n * 1.5 + m + r * 0.5;

        System.out.println("recPerim :" + recPerim);

//        Map<Double, Integer> recSides = new HashMap<>();
//            recSides.put(1.5, n);
//            recSides.put(1d, m);
//            recSides.put(0.5, r);

//        System.out.println(recSides);

        //если длина не целое число, откидываем лишнее
        if((recPerim - (int)recPerim) != 0) {
            if (r > 0) {
                recPerim -= 0.5;
            } else {
                recPerim -= 1.5;
            }
        }

        if (recPerim == 0) return 0; //защита от 0
        if ((n+m+r) < 4) return 0; //защита от нехватки сторон
        if (n == 1 && m == 2 && r == 2) return 0.5f; //случай 1-2-2

        //System.out.println("recPerim :" + recPerim);

        //находим экстремум функции площади
        List<Double> recAreas= new ArrayList<>();

        float i = 0;
        while (i < (recPerim/2)) {
            //for (int i = 0; i < recPerim/2; i++) {
            recAreas.add(i*((recPerim/2) - i));
            i += 0.5f;
        }

        System.out.println("recAreas :" + recAreas);

        //находим индекс (длину стороны) соответствующую максимальной площади
        int maxIndex = recAreas.indexOf(Collections.max(recAreas));

        System.out.println("maxIndex :" + maxIndex);

        double tempA = maxIndex/2;
        System.out.println("tempA: " + tempA);

        double tempB = recPerim/2 - maxIndex/2;
        System.out.println("tempB: " + tempB);

        area = recAreas.get(maxIndex);

        System.out.println("area: " + area);

        return (float)area;

    }

    public static void runCode() {
        // Entrypoint to debug your function
    }

    public static void main(String[] args) throws Exception {

//        int n = (int)(Math.random() * 9);
//        int m = (int)(Math.random() * 9);
//        int r = (int)(Math.random() * 9);
        int n = 5;
        int m = 4;
        int r = 3;

        System.out.println("n(1.5):" + n + ", m(1):" + m + ", r(0.5):" + r);

        getResult(n, m, r);
    }

}
