import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a word: ");
        String word = input.nextLine();

        List<char[]> permutations = findPermutations(word.toCharArray());

        System.out.println("All possible permutations of the word '" + word + "':");
        for(char[] permutation : permutations) {
            System.out.println(new String(permutation));
        }

        input.close();
    }

    public static List<char[]> findPermutations(char[] word) {
        List<char[]> permutations = new ArrayList<>();
        findPermutationsHelper(word, 0, permutations);
        return permutations;
    }

    public static void findPermutationsHelper(char[] chars, int index, List<char[]> permutations) {
        if(index == chars.length - 1) {
            permutations.add(Arrays.copyOf(chars, chars.length));
            return;
        }

        for(int i = index; i < chars.length; i++) {
            swap(chars, index, i);
            findPermutationsHelper(chars, index + 1, permutations);
            swap(chars, index, i);
        }
    }

    public static void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
}
