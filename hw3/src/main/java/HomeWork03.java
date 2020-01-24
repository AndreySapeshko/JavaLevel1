import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class HomeWork03 {
    private static Random rand = new Random();
    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {

        String input = "Mama mila ramu, Ramu mila mama!!! MAMA mamA";
        String[] dic = {"mama", "ramu"};
        System.out.println(input);
        System.out.println(countOfWordsFromDictionaryInString(input, dic));

        int[] nums = {1,0,3,17,2,7,14,1,1,7};
        int k = 6;
        System.out.println(k + " шестое по величине число: " + kOrderValue(nums, k));


        System.out.println(isEmail("m.levin.main@mailg.spb.com"));

        guessWord();

        boolean newGame = true;
        while (newGame) {
            int answer = rand.nextInt(100);
            for (int i = 1; i < 8; i++) {
                System.out.println("Угадайте чилсо от 0 до 100. У вас: " + (8 - i) + " попытки.");
                int userAnswer = in.nextInt();
                if (userAnswer == answer) {
                    System.out.println("Вы угадали! Поздравляем!");
                    break;
                } else if (userAnswer < answer) {
                    System.out.println("Ваше число меньше.");
                } else {
                    System.out.println("Ваше число больше.");
                }
                if (i == 7) {
                    System.out.println("Вы проиграли! Загаднное число: " + answer);
                }
            }
            System.out.println("Если хотите сиграть еще раз введите 1, если нет 0");
            int yesNo = in.nextInt();
            if (yesNo != 1) {
                newGame = false;
                System.out.println("Игра окончена.");
            }
        }
        in.close();
    }
    static void guessWord() {
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot",
                "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea",
                "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
        String wordAnswer = words[rand.nextInt(words.length)];
        String userWord;
        char[] demoWordArr = {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'};
        do {
            System.out.println("Программа выбрала слово из массива:\n" + Arrays.toString(words) + "\nУгадайте какое.");
            userWord = in.nextLine();
            if (wordAnswer.equals(userWord.toLowerCase())) {
                System.out.println("Вы угадали!");
                break;
            } else {
                for (int i = 0; i < userWord.length(); i++) {
                    if (i == wordAnswer.length()) {
                        break;
                    }
                    if (wordAnswer.charAt(i) == userWord.charAt(i)) {
                        wordAnswer.getChars(i, i + 1, demoWordArr, i);
                    }
                }
                String demoWord = new String(demoWordArr);
                System.out.println("Вы не угадали, выбранное слово: " + demoWord + " Попробуйте еще!");
            }
        } while (!wordAnswer.equals(userWord.toLowerCase()));
    }
    /* example:
     * input: Mama mila ramu, Ramu mila mama!!!, [mama, ramu]
     * output: 4
     * use regex, split, lowerCase, replace methods
     * */
    public static int countOfWordsFromDictionaryInString(String input, String[] dictionary) {
        //посчитать все слова из словаря в input
        //если одно слово встречается 5 раз его нужно посчитать 5 раз
        // TODO: 1/21/2020
        for (int i = 33; i < 65; i++) {
            input = input.replace((char)i, ' ');
        }
        int score = 0;
        for (int j = 0; j < dictionary.length; j++) {
            for (int i = 0; i < input.split(" ").length; i++) {
                if (dictionary[j].equals(input.split(" ")[i].toLowerCase())) {
                    score++;
                }
            }
        }
        return score;
    }

    /* example:
     * input: [1,0,3,17,2,7,14,1,1,7], K = 6
     * output: 3
     * use sort
     * */
    public static int kOrderValue(int[] array, int k) {
        //метод должен вернуть К по порядку элемент массива
        for (int j = 1; j < array.length; j++) {
            for (int i = 0; i <array.length - 1; i++) {
                if (array[i] > array[i+1]) {
                    int buf = array[i];
                    array[i] = array[i+1];
                    array[i+1] = buf;
                }
            }
        }
        return array[k-1];
    }

    /* example:
     * input: m.levin.main@mailg.spb.com
     * output: true
     * @ с 2 по length - 4
     * . c length - 3 to length - 2
     * use matches
     * */
    public static boolean isEmail(String input) {
        // TODO: 1/21/2020
        return (input.matches("(.{2,})@[a-z](.{5,})") && input.matches("(.*).[a-z]{2,3}"));
    }

    /*
     *  Это реальная задача, которую я сегодня делал на работе
     *  Кому интересно, можете проверить свои силы))))
     *  Если слово из values есть в словаре from, его необходимо заменить
     *  с from[i] на to[i] [a, b, c], [a, b], [x, y] -> [x, y, c]
     *  Если словарь to длиннее from, то строка to[from.length] - дефолтное
     *  значение для всех values, которых нет в словаре from
     *  [a, b, c, d], [a, b], [x, y, lol] -> [x, y, lol, lol]
     *  Если словарь from длиннее to, то необходимо удалить из values все значения
     *  имющиеся в куске from на индексах от to.length до rom.length
     *  [a, b, c, d], [a, b, e, d], [x, y] -> [x, y, c] d удалем, так как он есть во
     *  from
     */
    public String[] translate(String[] values, String[] from, String[] to) {
        // TODO: 1/22/2020
        for (int i = 0; i < values.length; i++) {
            for (int j = 0; j < from.length; j++) {
                if (to.length > from.length) {
                    if (values[i].equals(from[j])) {
                        from[j] = to[j];
                    } else {
                        values[i] = to[from.length];
                    }
                } else {
                    if (to.length < j) {
                        if (values[i].equals(from[j])) {
                            values[i] = null;
                        }
                    } else {
                        if (values[i].equals(from[j])) {
                            from[j] = to[j];
                        }
                    }
                }
            }


        }
        return null;
    }
}
