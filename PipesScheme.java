import java.util.*;

public class PipesScheme {
    /**
     * 3 уровень сложности (100%)
     *
     * Сантехник устал от того, что ему приходится самому рассчитывать количество и цену каждой трубы.
     * Поэтому он решил написать программу, которая будет принимать бинарную схему труб (0-нет трубы, 1- есть труба)
     * и выдавать стоимость проекта, в зависимости от типа каждой трубы.
     *
     * Цены на трубы постоянные и указаны на рисунке, берем их именно отсюда:
     *
     * Примечание:
     *
     *     если труба находится у начала или конца матрицы, то считаем, что за границей находится другая труба
     *     труба всегда одна и нигде не прерывается
     *     нам тоже показалось странным, что одинаковые трубы под разными углами могут стоить дороже, мы считаем, что сантехника обманывают, но сообщить ему почему-то не решились
     *
     * На входе:
     *
     *     scheme - бинарная матрица схемы труб, scheme[i]=0|1
     *
     * На выходе:
     *
     * Integer - общая стоимость всех труб, которые надо купить
     *
     * Пример:
     *
     * scheme = [
     * '0-0-0-0',
     * '1-1-1-0',
     * '0-0-1-0',
     * '0-0-1-0']
     *
     * getResult(scheme) → 92 // 21+21+10+20+20
     */
    public static int getResult(List<String> scheme) {
        // Write your code here...
        int cost = 0;
        Map<String, Integer> costMap = new HashMap<>();
        costMap.put("0011", 17);
        costMap.put("1011", 32);
        costMap.put("1001", 10);
        costMap.put("0111", 40);
        costMap.put("1111", 63);
        costMap.put("1101", 31);
        costMap.put("0110", 15);
        costMap.put("1110", 29);
        costMap.put("1100", 13);
        costMap.put("0101", 20);
        costMap.put("1010", 21);

        String[][] pipesScheme = new String[scheme.size()][scheme.get(0).replaceAll("[-]", "").length()];

        for (int i = 0; i < pipesScheme.length; i++) {
            for (int j = 0; j < pipesScheme[i].length; j++) {
                pipesScheme[i][j] = scheme.get(i).replaceAll("[-]", "").substring(j, j + 1);
            }
        }

        String tmpNeighbor = "";
        for (int i = 0; i < pipesScheme.length; i++) {
            for (int j = 0; j < pipesScheme[i].length; j++) {
                if (j == 0) { // что слева
                    tmpNeighbor = tmpNeighbor.concat("1");
                } else {
                    tmpNeighbor = tmpNeighbor.concat(pipesScheme[i][j - 1]);
                }
                if (i == 0) { // что сверху
                    tmpNeighbor = tmpNeighbor.concat("1");
                } else {
                    tmpNeighbor = tmpNeighbor.concat(pipesScheme[i - 1][j]);
                }
                if (j == pipesScheme[i].length - 1) { // что справа
                    tmpNeighbor = tmpNeighbor.concat("1");
                } else {
                    tmpNeighbor = tmpNeighbor.concat(pipesScheme[i][j + 1]);
                }
                if (i == pipesScheme.length - 1) { // что снизу
                    tmpNeighbor = tmpNeighbor.concat("1");
                } else {
                    tmpNeighbor = tmpNeighbor.concat(pipesScheme[i + 1][j]);
                }
                System.out.println("tmpNeighbor: " + tmpNeighbor);
                System.out.println(costMap.get(tmpNeighbor));
                if (pipesScheme[i][j].equals("1")) {
                    cost += costMap.get(tmpNeighbor);
                }
                tmpNeighbor = "";
            }
        }

        System.out.println("cost: " + cost);
        return cost;
    }

    public static void runCode() {
        // Entrypoint to debug your function
    }

    public static void main(String[] args) throws Exception {
        List<String> scheme = new ArrayList<>();

        scheme.add("0-0-1-0-0-0-0-0");
        scheme.add("0-0-1-0-1-1-1-0");
        scheme.add("0-0-1-1-1-0-1-0");
        scheme.add("0-0-0-0-0-0-1-0");
        scheme.add("0-0-0-0-0-0-1-0");
        scheme.add("0-0-0-0-1-1-1-0");
        scheme.add("0-0-0-0-1-0-0-0");

        getResult(scheme);
    }

}
