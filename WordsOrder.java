import java.util.*;

public class WordsOrder {
    /**
     * "Ukfpf qjzncz, f herb ltkfmn"
     */
    public static String wordsOrder(String words) {
        // Write your code here...
        String result = "";
        List<String> wordsList = new ArrayList<>();
        Map<Integer, String> wordsMap = new HashMap<>();

        wordsList.addAll(Arrays.asList(words.split(" ")));

        for (int i = 0; i < wordsList.size(); i++) {
            int tmpKey = Integer.parseInt(wordsList.get(i).replaceAll("[^0-9]+", ""));
            wordsMap.put(tmpKey, wordsList.get(i).replaceAll("[0-9]", ""));
        }

        for (String item : wordsMap.values()) {
            result = result.concat(item + " ");
        }
        result = result.trim();

        System.out.println("wordsList: " + wordsList);
        System.out.println("wordsMap: " + wordsMap);
        System.out.println("result: " + result);

        return result;
    }

    public static void runCode() {
        // Entrypoint to debug your function
    }

    public static void main(String[] args) throws Exception {
        List<String> words = new ArrayList<>();

        wordsOrder("l5tkfmn 4herb qj2zncz, f3 Uk1fpf");
    }

}
