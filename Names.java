import sun.reflect.generics.tree.ClassSignature;

import java.util.*;

public class Names {
    /**
     * 3 уровень сложности (100%)
     *
     * Вам даётся массив имён трёх братьев и массив утверждений, которые являются правдивыми. Список возможных утверждений:
     *
     * “is youngest” – самый младший
     * “is not youngest” – не самый младший
     * “is not oldest” – не самый старший
     * “is oldest” – самый старший
     * Вам предстоит расставить всех братьев по возрастанию возраста
     *  Ввод:
     *
     * names – массив имён трёх братьев
     * statements – массив(string[]), statements[i] = [“a-b”], где a – имя брата, b – утверждение,
     * их разделяет тире без пробелов. Для одного брата может быть несколько утверждений
     *  Вывод:
     *
     * String[] – список братьев от самого младшего до самого старшего, решение всегда есть и всегда одно
     * Example:
     *
     * names=[“Kevin”, “Jack”, “Mark”]
     * statements=[“Kevin-is not youngest”, “Jack-is oldest”, “Mark-is not oldest”]
     *
     * getResult(names, statements)=[“Mark”, “Kevin”, “Jack”]
     *
     * Аргументы
     *
     * // 1: names: String[]
     * ["Kevin", "Jack", "Mark"]
     *
     * // 2: statements: String[]
     * ["Kevin-is youngest", "Mark-is oldest"]
     *
     * Ожидаемое значение
     *
     * ["Kevin", "Jack", "Mark"]
     *
     */
    public static List<String> getResult(List<String> names, List<String> statements) {
        // Write your code here...
        List<String> namesOrder = new ArrayList<>();
        namesOrder.addAll(names);
        Map<String, List<Integer>> namesMapInvert = new HashMap<>();
        Map<Integer, String> namesMapNew = new HashMap<>();
        String name, statement;

        for (int i = 0; i < statements.size(); i++) {

            name = statements.get(i).substring(
                    0,
                    statements.get(i).indexOf("-"));
            statement = statements.get(i).substring(
                    statements.get(i).indexOf("-")+1
            );

            List<Integer> tmp = new ArrayList<>();
            switch (statement) {
                case "is youngest":
                    namesMapNew.put(0, name);

                    tmp.clear();
                    if (!namesMapInvert.containsKey(name)) {
                        tmp.add(0);
                        namesMapInvert.put(name, tmp);
                    } else {
                        tmp.add(0);
                        namesMapInvert.put(name, tmp);
                    }
                    break;
                case "is oldest":
                    namesMapNew.put(2, name);

                    tmp.clear();
                    if (!namesMapInvert.containsKey(name)) {
                        tmp.add(2);
                        namesMapInvert.put(name, tmp);
                    } else {
                        tmp.add(2);
                        namesMapInvert.put(name, tmp);
                    }
                    break;
                case "is not youngest":
                    namesMapNew.put(2, name);
                    if (!namesMapNew.containsKey(1)) {
                        namesMapNew.put(1, name);
                    } else
                    namesMapNew.put(1, namesMapNew.get(1) + "," + name);

                    tmp.clear();
                    if (!namesMapInvert.containsKey(name)) {
                        tmp.add(1);
                        tmp.add(2);
                        namesMapInvert.put(name, tmp);
                    } else if (namesMapInvert.get(name).size() != 1){
                        tmp.addAll(namesMapInvert.get(name));
                        tmp.add(1);
                        tmp.add(2);
                        namesMapInvert.put(name, tmp);
                    }
                    break;
                case "is not oldest":
                    namesMapNew.put(0, name);
                    if (!namesMapNew.containsKey(1)) {
                        namesMapNew.put(1, name);
                    } else {
                        namesMapNew.put(1, namesMapNew.get(1) + "," + name);
                    }

                    tmp.clear();
                    if (!namesMapInvert.containsKey(name)) {
                        tmp.add(0);
                        tmp.add(1);
                        namesMapInvert.put(name, tmp);
                    } else if (namesMapInvert.get(name).size() != 1){
                        tmp.addAll(namesMapInvert.get(name));
                        tmp.add(0);
                        tmp.add(1);
                        namesMapInvert.put(name, tmp);
                    }
                    break;

            }
        }

        System.out.println(namesMapInvert);

        //пересечение дает удвоение, удвоение дает позицию
        int k = -1;
        for (String item : names) {
            if (namesMapInvert.containsKey(item) && namesMapInvert.get(item).size() > 1) {
                for (int i = 0; i < namesMapInvert.get(item).size(); i++) {
                    for (int j = i + 1; j < namesMapInvert.get(item).size(); j++) {
                        if (namesMapInvert.get(item).get(i).equals(namesMapInvert.get(item).get(j))) {
                            k = namesMapInvert.get(item).get(i);
                            break;
                        }
                    }
                }
                if (k != -1) {
                    namesMapInvert.get(item).clear();
                    namesMapInvert.get(item).add(k);
                }
            }
        }

        //единственность дает позицию

        for (String item : names) {
            if (namesMapInvert.containsKey(item)) {
                if (namesMapInvert.get(item).size() > 1) {

                    for (String item2 : names) {
                        if (item != item2 && namesMapInvert.containsKey(item2)) {

                                for (int i = 0; i < namesMapInvert.get(item).size(); i++) { // убираем дубликаты

                                    if (namesMapInvert.get(item2).contains(namesMapInvert.get(item).get(i))) {
                                        if (namesMapInvert.get(item2).size() > 1) {
                                            namesMapInvert.get(item2).remove(namesMapInvert.get(item).get(i));
                                            namesMapInvert.get(item).remove(i);
                                        } else {
                                            namesMapInvert.get(item).remove(i);
                                        }
                                    }
                                }

                        }
                    }
                }
            }
        }

        System.out.println(namesMapInvert);
        System.out.println(namesOrder);

        if (namesMapInvert.size() < names.size()) {
            List<Integer> tmpList = new ArrayList<>();
            tmpList.addAll(Arrays.asList(0, 1, 2));
            for (String item : names) {
                if (!namesMapInvert.containsKey(item)) {

                    for (String item2 : namesMapInvert.keySet()) {
                        if (tmpList.contains(namesMapInvert.get(item2).get(0))) {
                            tmpList.remove(namesMapInvert.get(item2).get(0));
                        }
                    }
                    namesMapInvert.put(item, tmpList);
                }
            }

            System.out.println(namesMapInvert);
            System.out.println("tmpList: " + tmpList);
        }

        for (String item : namesMapInvert.keySet()) {
            if (namesMapInvert.get(item).size() == 0) {
                List<Integer> tmpList = new ArrayList<>();
                tmpList.addAll(Arrays.asList(0, 1, 2));

                for (String item2 : namesMapInvert.keySet()) {
                    for (int i = 0; i < tmpList.size(); i++) {
                        if (!item.equals(item2) && namesMapInvert.get(item2).contains(tmpList.get(i))) {
                            tmpList.remove(i);
                            System.out.println("!!!");
                        }
                    }
                }

                namesMapInvert.put(item, tmpList);
                System.out.println(namesMapInvert);
                System.out.println(" tmpList: " + tmpList);
            }
        }

        if (namesMapNew.size() < 3 && statements.size() > 0) {
            for (String item : names) {
                if (!namesMapNew.containsValue(item)) {

                    if (!namesMapNew.containsKey(0)) {
                        namesMapNew.put(0, item);
                    }
                    if (!namesMapNew.containsKey(1)) {
                        namesMapNew.put(1, item);
                    }
                    if (!namesMapNew.containsKey(2)) {
                        namesMapNew.put(2, item);
                    }
                }
            }

        }

        System.out.println(namesMapNew);

        List<String> tmpList = new ArrayList<>();

            if (namesMapNew.containsKey(1))
                tmpList.addAll(Arrays.asList(namesMapNew.get(1).split(",")));

            if (tmpList.contains(namesMapNew.get(0))) {
                tmpList.remove(namesMapNew.get(0));
            }
            if (tmpList.contains(namesMapNew.get(2))) {
                tmpList.remove(namesMapNew.get(2));
            }

            if (tmpList.size() > 0) namesMapNew.replace(1, tmpList.get(0));
            System.out.println(namesMapNew);


        System.out.println(namesOrder);
        if (namesMapNew.size() > 0) {
            namesOrder.clear();
            namesOrder.addAll(namesMapNew.values());
        }
        System.out.println(namesOrder);

        for (String item : namesMapInvert.keySet()) {
            namesOrder.set(namesMapInvert.get(item).get(0), item);
        }
        System.out.println(namesOrder);

        return namesOrder;
    }

    public static void runCode() {
        // Entrypoint to debug your function
    }

    public static void main(String[] args) throws Exception {

        List<String> names = new ArrayList<>();
        names.add("Kevin");
        names.add("Jack");
        names.add("Mark");

        List<String> statements = new ArrayList<>();

        statements.add("Jack-is not oldest");
        statements.add("Jack-is not youngest");
//        statements.add("Kevin-is oldest");
        statements.add("Kevin-is not youngest");


//        statements.add("Kevin-is not youngest");
//        statements.add("Jack-is oldest");
//        statements.add("Mark-is not oldest");


        //"Mark", "Kevin", "Jack" 1/4 (1) +
        //"Mark", "Jack", "Kevin" 1/4 (3) -
        //"Jack", "Mark", "Kevin" 1/4 (4) +
        //"Kevin", "Jack", "Mark" 1/4 (2) +

        getResult(names, statements);
    }
}
