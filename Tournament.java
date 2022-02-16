import java.util.*;

public class Tournament {
    /**
     * 3 уровень сложности (100%)
     *
     * Сегодня на турнире сражаются отважные войны! Начальная турнирная сетка определяется случайным образом, количество участников неизменно равно четырем.
     *
     * У каждого бойца есть параметр выносливости. Сражаясь, побеждает тот, у кого этот параметр выше. У победителя отнимается выносливость, равная выносливости противника, после чего боец проходит дальше по турнирной сетке.
     *
     * Если во время схватки выносливость бойцов одинакова, то побеждает случайный боец, оставаясь с нулевой выносливостью.
     *
     * Учитывая случайность подбора в турнирной сетке, определите для каждого участника шанс победить в турнире.
     *
     * foo
     *
     * Ввод:
     *
     *     fighters_stamina - массив выносливости для каждого участника турнира,  length(fighters_stamina)=4, 0<=fighters_stamina[i]<=10
     *
     * Вывод:
     *
     *     Integer[] - шанс победы каждого участника турнира, в процентах, округленных до целого числа (из-за округления может получиться, что сумма процентов не 100, это не страшно - мы все равно поймем кто лучший)
     *
     * Пример:
     *
     * fighters_stamina = [2, 1, 0, 2]
     * getResult(fighters_stamina) = [33, 33, 0, 33]
     *
     * Есть три варианта распределения бойцов в турнирной сетке:
     * В первом варианте побеждает боец №4
     * [2, 1] [0, 2]
     *     [1, 2]
     *      [1]
     * Во втором - второй боец №2 (при данном вариант турнирной сетки он третий)
     * [2, 2] [1, 0]
     *    [0, 1]
     *      [1]
     * В третьем - боец №1
     * [2, 0] [1, 2]
     *     [2, 1]
     *       [1]
     *
     * У 1, 2 и 4 бойца есть равный шанс победить
     *
     * Аргумент
     *
     * // 1: fightersStamina: Integer[]
     * [1, 0, 3, 4]
     *
     * Ожидаемое значение
     *
     * [17, 0, 17, 67]
     *
     */
    public static List<Integer> getResult(List<Integer> fightersStamina) {
        // Write your code here...
        List<Integer> сhancesList = new ArrayList<>();
        Stack<List<Integer>> enemiesStack = new Stack<>();
        Queue<Integer> halfChances = new ArrayDeque<>();
        List<Integer> enemiesList = new ArrayList<>();
        List<Integer> winnersIndexesList = new ArrayList<>();
        Map<Integer, Integer> enemiesMap = new TreeMap<>();
        Map<Integer, Float> chancesMap = new TreeMap<>();
        Map<Integer, Float> finalChancesMap = new TreeMap<>();

        System.out.println("fightersStamina: " + fightersStamina);

        enemiesList.clear();
        enemiesList.add(0);
        enemiesList.add(1);
        enemiesList.add(2);
        enemiesList.add(3);
        List<Integer> tmp = new ArrayList<>();
        tmp.addAll(enemiesList);
        enemiesStack.push(tmp);

        enemiesList.clear();
        enemiesList.add(0);
        enemiesList.add(3);
        enemiesList.add(1);
        enemiesList.add(2);
        List<Integer> tmp2 = new ArrayList<>();
        tmp2.addAll(enemiesList);
        enemiesStack.push(tmp2);

        enemiesList.clear();
        enemiesList.add(0);
        enemiesList.add(2);
        enemiesList.add(1);
        enemiesList.add(3);
        List<Integer> tmp3 = new ArrayList<>();
        tmp3.addAll(enemiesList);
        enemiesStack.push(tmp3);

        System.out.println("enemiesStack: " + enemiesStack);

        while (enemiesStack.size() > 0) {
            enemiesList.clear();
            enemiesList.addAll(enemiesStack.pop());
            for (int i = 0; i < enemiesList.size(); i++) {
                enemiesMap.put(i, fightersStamina.get(enemiesList.get(i)));
            }
            System.out.println("enemiesList: " + enemiesList);
            System.out.println("enemiesMap: " + enemiesMap);

            int playersCount = enemiesMap.size();
            int winnerIndex = 0;
            while (playersCount > 1) {
                List<Integer> playersIndexes = new ArrayList<>();
                playersIndexes.addAll(enemiesMap.keySet());
                System.out.println("playersIndexes: " + playersIndexes);
                for (int i = 0; i < playersIndexes.size(); i++) {
//                System.out.println(i);
//                System.out.println(playersIndexes.get(i));
                    if (enemiesMap.get(playersIndexes.get(i)) == enemiesMap.get(playersIndexes.get(i + 1))) {
                        int rand = (int) Math.round(Math.random());
                        System.out.println("rand: " + rand);
                        if (rand == 0) {
                            winnerIndex = enemiesList.get(i);
                            enemiesMap.put(playersIndexes.get(i), 0);

                            if (playersCount > 2) {
                                chancesMap.put(enemiesList.get(playersIndexes.get(i)), 0.5f); //chances to win 50%
                                chancesMap.put(enemiesList.get(playersIndexes.get(i + 1)), 0.5f); //chances to win 50%
                            } else {
                                chancesMap.put(enemiesList.get(playersIndexes.get(i)), 0.5f * chancesMap.get(enemiesList.get(playersIndexes.get(i)))); //chances to win 50%
                                chancesMap.put(enemiesList.get(playersIndexes.get(i + 1)), 0.5f * chancesMap.get(enemiesList.get(playersIndexes.get(i + 1)))); //chances to win 50%
                                while (halfChances.size() > 0) {
                                    chancesMap.put(enemiesList.get(halfChances.peek()), 0.5f * chancesMap.get(enemiesList.get(halfChances.peek()))); //chances to win 50% to a previous
                                    halfChances.poll();
                                }
//                                System.out.println("halfchancesMap: " + chancesMap);
//                                System.out.println(halfChances);
                            }

                            enemiesMap.remove(playersIndexes.get(i + 1));
                            if (playersCount > 2) {
                                halfChances.offer(playersIndexes.get(i + 1));
                            }
                            playersIndexes.remove(i + 1);
                        } else {
                            winnerIndex = enemiesList.get(i + 1);
                            enemiesMap.put(playersIndexes.get(i + 1), 0);

                            if (playersCount > 2) {
                                chancesMap.put(enemiesList.get(playersIndexes.get(i)), 0.5f); //chances to win 50%
                                chancesMap.put(enemiesList.get(playersIndexes.get(i + 1)), 0.5f); //chances to win 50%
                            } else {
                                chancesMap.put(enemiesList.get(playersIndexes.get(i)), 0.5f * chancesMap.get(enemiesList.get(playersIndexes.get(i)))); //chances to win 50%
                                chancesMap.put(enemiesList.get(playersIndexes.get(i + 1)), 0.5f * chancesMap.get(enemiesList.get(playersIndexes.get(i + 1)))); //chances to win 50%
                                while (halfChances.size() > 0){
                                    chancesMap.put(enemiesList.get(halfChances.peek()), 0.5f * chancesMap.get(enemiesList.get(halfChances.peek()))); //chances to win 50% to a previous
                                    halfChances.poll();
                                }
//                                System.out.println("chancesMap: " + chancesMap);
                            }

                            enemiesMap.remove(playersIndexes.get(i));
                            if (playersCount > 2) {
                                halfChances.offer(playersIndexes.get(i));
                            }
                            playersIndexes.remove(i);
                        }
                    } else if (enemiesMap.get(playersIndexes.get(i)) > enemiesMap.get(playersIndexes.get(i + 1))) {
                        winnerIndex = enemiesList.get(i);
                        enemiesMap.put(playersIndexes.get(i), enemiesMap.get(playersIndexes.get(i)) - enemiesMap.get(playersIndexes.get(i + 1)));

                        if (playersCount > 2) {
                            chancesMap.put(enemiesList.get(playersIndexes.get(i)), 1f); //chances 100%
                            chancesMap.put(enemiesList.get(playersIndexes.get(i + 1)), 0f); //chances 0%
                        } else {
                            chancesMap.put(enemiesList.get(playersIndexes.get(i)), 1f * chancesMap.get(enemiesList.get(playersIndexes.get(i)))); //chances 100%
                            chancesMap.put(enemiesList.get(playersIndexes.get(i + 1)), 0f * chancesMap.get(enemiesList.get(playersIndexes.get(i + 1)))); //chances 0%
                            while (halfChances.size() > 0) {
                                chancesMap.put(enemiesList.get(halfChances.peek()), 0f * chancesMap.get(enemiesList.get(halfChances.peek()))); //chances to win 50% to a previous
                                halfChances.poll();
                            }
                        }

                        enemiesMap.remove(playersIndexes.get(i + 1));
                        playersIndexes.remove(i + 1);
                    } else {
                        winnerIndex = enemiesList.get(i + 1);
                        enemiesMap.put(playersIndexes.get(i + 1), enemiesMap.get(playersIndexes.get(i + 1)) - enemiesMap.get(playersIndexes.get(i)));

                        if (playersCount > 2) {
                            chancesMap.put(enemiesList.get(playersIndexes.get(i + 1)), 1f); //chances 100%
                            chancesMap.put(enemiesList.get(playersIndexes.get(i)), 0f); //chances 0%
                        } else {
                            chancesMap.put(enemiesList.get(playersIndexes.get(i + 1)), 1f * chancesMap.get(enemiesList.get(playersIndexes.get(i + 1)))); //chances 100%
                            chancesMap.put(enemiesList.get(playersIndexes.get(i)), 0f * chancesMap.get(enemiesList.get(playersIndexes.get(i)))); //chances 0%
                            while (halfChances.size() > 0) {
                                chancesMap.put(enemiesList.get(halfChances.peek()), 0f * chancesMap.get(enemiesList.get(halfChances.peek()))); //chances to win 50% to a previous
                                halfChances.poll();
                            }
                        }

                        enemiesMap.remove(playersIndexes.get(i));
                        playersIndexes.remove(i);
                    }
                    System.out.println(enemiesMap);
                    System.out.println("chancesMap: " + chancesMap);
                    System.out.println("halfChances: " + halfChances);
                }
                playersCount = enemiesMap.size();
                System.out.println("playersCount: " + playersCount);
            }


            for (int i = 0; i < chancesMap.size(); i++) {
                if (!finalChancesMap.containsKey(i)) {
                    finalChancesMap.put(i, chancesMap.get(i));
                } else {
                    finalChancesMap.put(i, finalChancesMap.get(i) + chancesMap.get(i));
                }
            }
            chancesMap.clear();
            halfChances.clear();
            winnersIndexesList.add(winnerIndex);
            System.out.println("winnersIndexesList: " + winnersIndexesList);
        }

        for (int i = 0; i < fightersStamina.size(); i++){
            сhancesList.add(Math.round(finalChancesMap.get(i) * 100 / 3));
        }

        System.out.println(сhancesList);
        return сhancesList;
    }

    public static void runCode() {
        // Entrypoint to debug your function
    }

    public static void main(String[] args) throws Exception {
        List<Integer> fightersStamina = new ArrayList<>();

        fightersStamina.add(2);
        fightersStamina.add(1);
        fightersStamina.add(0);
        fightersStamina.add(2);


        getResult(fightersStamina);
    }

}
