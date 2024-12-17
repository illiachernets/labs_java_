public class lab6 {
    public static void main(String[] args) {
        String value = "CAFE";
//        String value = ""; incorrect input
        int hexInt = hexStringToInt(value);
        System.out.println("Результат 1: " + hexInt);

//        String input = ""; incorrect input
        String input = "The user with the nickname koala757677 this month wrote 3 times more " +
                "comments than the user with the nickname croco181dile920 4 months ago";
        int combinationsCount = countDigitCombinations(input);
        System.out.println("Результат 2: " + combinationsCount);


    }
    static int hexStringToInt(String s) {
        if (s == null || s.isEmpty()) {
            throw new IllegalArgumentException("incorrect input");
        }

        int hexInt = Integer.parseInt(s, 16); // // Використовуємо Integer.parseInt з базою 16 (шістнадцятковий формат)

        return hexInt;
    }

    static int countDigitCombinations(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("incorrect input");
        }
        String[] words = input.split("\\s+"); // Розбиваємо рядок на слова

        int count = 0;

        for (String word : words) {
            if (containsDigitCombination(word)) {
                count++;
            }
        }

        return count;
    }

    static boolean containsDigitCombination(String str) {
        boolean containsLetter = false;
        boolean containsDigit = false;

        for (char ch : str.toCharArray()) {     // Перетворюємо слово на масив символів і перевіряємо кожен символ
            if (Character.isLetter(ch)) {
                containsLetter = true;
            } else if (Character.isDigit(ch)) {
                containsDigit = true;
            }

            if (!containsLetter && containsDigit) {
                return true;
            }
        }

        return false;
    }
}