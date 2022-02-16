import java.util.*;

public class Immigrants {
    /**
     * 2 уровень сложности (100%)
     *
     * Вы сотрудник иммиграционной службы страны Арстоцка. В эту страну приезжает много людей, которые предоставляют вам свой
     * паспорт, а потом сообщают вам информацию о себе.
     *
     * Вы сравниваете возраст и имя с паспортными данными и принимаете решение – впустить человека в страну или нет. Впускаем
     * в страну, когда данные правдивы. Будьте внимательнее с возрастом :)
     *
     * Однако, вы можете расслышать имя неправильно. Если ошибка в имени одна (не хватает буквы, лишняя буква или одна буква
     * другая), то считайте вам сказали правду. Регистр букв в имени не учитывается.
     *
     * На входе:
     *
     *     calendar – нынешний год (integer)
     *     date_of_birth – год рождения в паспорте (integer)
     *     name – имя человека в паспорте (string)
     *     phrases – строковый массив – показания человека phrases[a, b], где a – возраст человека, b – имя
     *
     * На выходе:
     *
     *     Boolean – решение, которые вы приняли (True – впустить, False – нет, то есть если возраст не соответствует
     *     паспортным данным или различий в имени больше одного)
     *
     * Пример:
     *
     * calendar = 1984
     * date_of_birth = 1950
     * name = “Anna”
     * phrases = [“34”, “Ana”]
     * getResult(calendar, date_of_birth, name, phrases) = True
     *
     */
    public static boolean getResult(int calendar, int dateOfBirth, String name, List<String> phrases) {
        // Write your code here...
        boolean result = false, boolName = false, boolDate = false;
        Integer checkDate;
        Integer age = Integer.valueOf(phrases.get(0));

        checkDate = calendar - dateOfBirth;
        System.out.println(checkDate);
        System.out.println(age);

        if (checkDate.equals(age) || checkDate - age == 1) {
            boolDate = true;
        }

        List<Character> charsListCheckName = new ArrayList<>();

        for (char ch : phrases.get(1).toLowerCase().toCharArray()) {
            charsListCheckName.add(ch);
        }
        System.out.println(charsListCheckName);

        List<Character> charsListName = new ArrayList<>();

        for (char ch : name.toLowerCase().toCharArray()) {
            charsListName.add(ch);
        }
        System.out.println(charsListName);

        for (int i = 0; i < charsListName.size(); i++) {
            if (charsListCheckName.contains(charsListName.get(i))) {
                charsListCheckName.remove(charsListName.get(i));
                charsListName.remove(i);
                i--;
            }
        }

        System.out.println(charsListCheckName);
        System.out.println(charsListName);

        if ((charsListName.size() < 2 && charsListCheckName.size() < 2)
                && (Math.abs(charsListName.size() - charsListCheckName.size()) < 2)) boolName = true;

        if (boolDate && boolName) result = true;

        System.out.println(result);
        return result;
    }

    public static void runCode() {
        // Entrypoint to debug your function
    }

    public static void main(String[] args) throws Exception {

        List<String> phrases = new ArrayList<>();
        phrases.add("41");
        phrases.add("Andrey");

        int calendar = 2022;
        int date_of_birth = 1982;
        String name = "Andrey";


        getResult(calendar, date_of_birth, name, phrases);
    }
}
