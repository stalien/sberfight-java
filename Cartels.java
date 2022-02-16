import com.sun.xml.internal.ws.util.HandlerAnnotationInfo;

import java.nio.charset.StandardCharsets;
import java.util.*;

public class Cartels {
    /**
     * 3 уровень сложности (100%)
     *
     Aмерика 90-х годов. Повсеместны синдикаты и картельные сговоры. У вас на руках список торговых сделок крупных компаний за
     последний год.

     Если сделки состоят из цепочки, в которой первая компания и последняя совпадают, образуя круг компаний, то вы наткнулись
     на очередной синдикат. Например, если компания A заключила сделку с B, та в свою очередь с C, а C - с A, то перед вами
     незаконный торговый союз.

     Найдите все такие связи и выведите количество синдикатов. То есть необходимо найти количество уникальных цепочек, в
     которых первая и последняя компании совпадают. Отметим, что цепочки с одинаковым набором,
     например, a-b-c-a и b-c-a-b - это один и тот же синдикат.

     Случаев, когда компании заключали сделки напрямую ("a-b", "b-a") нет.

     Подсказка: Если нарисовать все связи с помощью однонаправленного графа, то количество синдикатов - это
     количество петель в этом графе.

     Ввод:
     deal - массив строк deal["a-bc..."], где a - компания, заключившая сделку с b,c… - компании, с которыми
     была совершена сделка (количество таких компаний не ограничено). Если у какой-либо компании после названия нет тире
     mи далее списка, то у компании нет никаких сделок. 0<length(deal)<=10

     Вывод:
     integer - количество синдикатов

     Examples:

     deal = ["a-b", "b-c", "c-a"]
     getResult(deal) = 1

     deal = ["a-b","b-c","c-ad","d"]
     getResult(deal) = 1
     */

    private HashMap<String, List<String>> vertexMap = new HashMap<String, List<String>>();

    public void addVertex(String vertexName) {
        if (!hasVertex(vertexName)) {
            vertexMap.put(vertexName, new ArrayList<String>());
        }
    }

    public boolean hasVertex(String vertexName) {
        return vertexMap.containsKey(vertexName);
    }

    public boolean hasEdge(String vertexName1, String vertexName2) {
        if (!hasVertex(vertexName1)) return false;
        List<String> edges = vertexMap.get(vertexName1);
        return Collections.binarySearch(edges, vertexName2) != -1;
    }

    public void addEdge(String vertexName1, String vertexName2) {
        if (!hasVertex(vertexName1)) addVertex(vertexName1);
        if (!hasVertex(vertexName2)) addVertex(vertexName2);
        List<String> edges1 = vertexMap.get(vertexName1);
        edges1.add(vertexName2);
        Collections.sort(edges1);
//        double rnd = Math.random();
    }

    public int hasLoop() {
        int loops = 0;
        List<String> chains = new ArrayList<>();
        Stack<String> stack = new Stack<>();
        List<String> nodesList = new ArrayList<>(vertexMap.keySet());
        Map<String, List<String>> visitedMap = new HashMap<>();
        String tmpString;
        List<String> tmpEdgesList = new ArrayList<>();

        int indexKey = 0;
        int indexValue = 0;
        String lastVisited = "";


        //последовательно обходим все ноды, начиная с первой (A)
        for (int i = 0; i < nodesList.size(); i++) {

            stack.push(nodesList.get(i));
            System.out.println("i: " + i);
            System.out.println("stack: " + stack);
            System.out.println(" ");

            while (!stack.isEmpty()) {

                //если в текущей ноде есть ссылки, то идем по следующей от lastVisited
                if (!vertexMap.get(stack.peek()).isEmpty()) {
                    //если lastVisited есть в списке ссылок, то кладем в стек следующее за ним значение
                    if (vertexMap.get(stack.peek()).contains(lastVisited)) {
                        if (vertexMap.get(stack.peek()).indexOf(lastVisited) < vertexMap.get(stack.peek()).size() - 1) {
                            int nextIndex = vertexMap.get(stack.peek()).indexOf(lastVisited) + 1;
                            lastVisited = stack.peek();
                            stack.push(vertexMap.get(stack.peek()).get(nextIndex));
                        } else { //если список в ноде закончился с учетом lastVisited
                            lastVisited = stack.pop();
                            System.out.println("!!!!!!!!");
                        }
                    } else {
                        lastVisited = stack.peek();
                        stack.push(vertexMap.get(stack.peek()).get(0)); //кладем в стек первую ссылку из списка
                    }
                } else { //если пусто, то откатываемся

                    lastVisited = stack.pop();
                }

                System.out.println("lastVisited: " + lastVisited);
                System.out.println("stack: " + stack);
                System.out.println(" ");

                if (stack.size() > 1 && stack.peek().equals(stack.get(0))) { //find chain
                    //добавить результат в виде отсортированной строки!!
                    tmpString = stack.toString().replaceAll("[, \\[\\]]","");

                    chains.add(tmpString.trim());
                    System.out.println("chains" + chains);
                    loops++;

                    lastVisited = stack.pop();

                }

                if (stack.size() > 10) { //защита от внутренних зацикленностей
                    stack.clear();
                }

            } // here stack is empty
            lastVisited = "";
        }

        //сравнение уникальных цепочек, отсортировать по буквам и сравнить
        Set<String> sortedChains = new HashSet<>();
        for (int i = 0; i < chains.size(); i++) {
            char[] ar = chains.get(i).toCharArray();
            Arrays.sort(ar);

            HashSet<Character> uniqueCharSet = new HashSet<>(); //оставляем только уникальные симовлы
            for(char each : ar) {
                uniqueCharSet.add(each);
            }
//            System.out.println(uniqueCharSet);
            if (uniqueCharSet.size() > 2)
            sortedChains.add(uniqueCharSet.toString());
        }
        System.out.println("sortedChains: " + sortedChains);


        return sortedChains.size();
    }

    public Map<String, List<String>> getVertexMap() {
        return vertexMap;
    }

    public static int getResult(List<String> deal) {
        // Write your code here...
        int cartelsCount = 0;
        Cartels first = new Cartels();

        System.out.println(deal);
        for (int i = 0; i < deal.size(); i ++) {
            System.out.println(deal.get(i));
            if (deal.get(i).length() > 1) {
                for (int j = 0; j < deal.get(i).substring(deal.get(i).indexOf("-") + 1).length(); j++) {
                    first.addEdge(
                            deal.get(i).substring(0, deal.get(i).indexOf("-")),   //edge1
                            deal.get(i).substring(deal.get(i).indexOf("-") + 1).substring(j, j + 1)); //edge2
                }
            } else {
            first.addVertex(deal.get(i));
            }
        }

        System.out.println(first.getVertexMap());


        cartelsCount = first.hasLoop();
        System.out.println(cartelsCount);

        return cartelsCount;
    }

    public static void runCode() {
        // Entrypoint to debug your function
    }

    public static void main(String[] args) throws Exception {

        List<String> deal = new ArrayList<>();
        deal.add("a-b");
        deal.add("b-c");
        deal.add("c-af");
        deal.add("e-f");
        deal.add("f-g");
        deal.add("g-ea");

//        efge?
//        deal.add("d-c");
//        deal.add("d-a");


        getResult(deal);
    }
}
