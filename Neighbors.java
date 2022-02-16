import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Neighbors {
    /**
     * 2 уровень сложности(100%)
     *
     * Сегодня Аристократия организовывает пир. Мы знаем количество гостей, ваша задача рассадить всех за стол.
     *
     * Однако, некоторые гости дали вам список неприятелей, с которыми они не сядут.
     *
     * Стулья расставили так, что у стола оказалось два крайних места, у которых только один соседний гость. В остальных случаях соседа два.
     *
     * Определите, можно ли рассадить гостей так, чтобы все оказались довольны.
     *
     * Ввод:
     *
     * invited_list -  количество приглашённых гостей
     * dislike_list - строчный массив неприятелей, ["1-2,3"] - означает, что гость под номером 1 не сядет с гостями 2 и 3
     * Вывод:
     *
     * Boolean - возможно ли рассадить гостей так, чтобы они все были довольны
     * Пример:
     *
     * invited_list = 4
     * dislike_list = ["1-2", "3-4"]
     * getResult(invited_list, dislike_list) = True // [1, 4, 2, 3]
     */
    public static boolean getResult(int invitedList, List<String> dislikeList) {
        // Write your code here...
        boolean result = true;

        Map<Integer, List<Integer>> dislikeMap = new HashMap<>();

        for (int i = 0; i < dislikeList.size(); i++) {
            int key = Integer.parseInt(dislikeList.get(i).substring(0, dislikeList.get(i).indexOf("-")));
            String valueSubstring = dislikeList.get(i).substring(dislikeList.get(i).indexOf("-") + 1);
            List<String> valueStrings = Stream.of(valueSubstring.split(","))
                    .map(String::trim)
                    .collect(Collectors.toList());
            List<Integer> valueInt = valueStrings.stream()
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());

            dislikeMap.put(key, valueInt);

            for (int k = 0; k < 100; k ++) continue;

            //System.out.println(dislikeList.get(i));

        }
        System.out.println("dislikeMap :" + dislikeMap);

        Map<Integer, List<Integer>> likeMap = new HashMap<>();

        for (int i = 1; i <= invitedList; i++) {
            List<Integer> likeList = new ArrayList<>();
            List<Integer> iDislike = dislikeMap.get(i);

                for (int j = 1; j <= invitedList; j++) {
                    List<Integer> jDislike = dislikeMap.get(j);
                    System.out.println("temp :" + jDislike);
                    System.out.println("i :" + i + " j :" + j);
                    System.out.println("iDislike :" + iDislike);
                    System.out.println("jDislike :" + jDislike);
                    //проверяем, есть ли j в списке тех с кем не хочет сидеть i (например 1=[2, 3])
                    if (i == j || (iDislike != null && iDislike.indexOf(j) != -1)) {
                        System.out.println("!!!!!!!!");
                        //continue;
                    } else {
                        if (dislikeMap.containsKey(j)) { //есть ли в списке dislikeMap предпостения для гостя j (например 4=[1])
                            System.out.println("?????");
                            //if (!dislikeMap.get(i).contains(j)) { //проверяем, есть ли i в списке тех с кем не хочет сидеть j (например 4=[1])
                                if (jDislike != null && jDislike.indexOf(i) != -1) {
                                    System.out.println("@@@@@@");
                                    //continue;
                                } else {
                                    likeList.add(j);
                                }
                            //}
                        } else {
                            likeList.add(j);
                        }
                    }
                }

                likeMap.put(i, likeList);
                System.out.println("likeMap :" + likeMap);

        }

        for (int i = 1; i <= invitedList; i++) {
            if(likeMap.get(i).isEmpty()) {
                result = false;
            }
        }

        System.out.println(result);

        return result;
    }

    public static void runCode() {
        // Entrypoint to debug your function
    }

    public static void main(String[] args) throws Exception {

        int invitedList = 5;
        List<String> dislikeList = new ArrayList<>(Arrays.asList("1-2,3", "3-4,5", "2-3"));

        getResult(invitedList, dislikeList);
    }

}
