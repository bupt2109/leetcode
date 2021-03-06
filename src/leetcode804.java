import java.util.HashSet;
import java.util.Set;

/**
 * Unique Morse Code Words
 * Time: 2018-09-19 11:23
 * International Morse Code defines a standard encoding where each letter is mapped to a series of dots and dashes, as follows: "a" maps to ".-", "b" maps to "-...", "c" maps to "-.-.", and so on.
 For convenience, the full table for the 26 letters of the English alphabet is given below:
 * [".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."]
 * Now, given a list of words, each word can be written as a concatenation of the Morse code of each letter. For example, "cab" can be written as "-.-.-....-", (which is the concatenation "-.-." + "-..." + ".-"). We'll call such a concatenation, the transformation of a word.

 Return the number of different transformations among all words we have.

 Example:
 Input: words = ["gin", "zen", "gig", "msg"]
 Output: 2
 Explanation:
 The transformation of each word is:
 "gin" -> "--...-."
 "zen" -> "--...-."
 "gig" -> "--...--."
 "msg" -> "--...--."
 There are 2 different transformations, "--...-." and "--...--.".

 Note:
 The length of words will be at most 100.
 Each words[i] will have length in range [1, 12].
 words[i] will only consist of lowercase letters.
 */
public class leetcode804 {
    public int uniqueMorseRepresentations(String[] words) {
        String[] alphabet = {
                ".-",
                "-...",
                "-.-.",
                "-..",
                ".",
                "..-.",
                "--.",
                "....",
                "..",
                ".---",
                "-.-",
                ".-..",
                "--",
                "-.",
                "---",
                ".--.",
                "--.-",
                ".-.",
                "...",
                "-",
                "..-",
                "...-",
                ".--",
                "-..-",
                "-.--",
                "--.."
        };
        Set<String> set = new HashSet<String>();
        StringBuilder sb = new StringBuilder();
        for (String word: words){
            for (char ch: word.toCharArray()){
                sb.append(alphabet[ch - 'a']);
            }
            set.add(sb.toString());
            sb.delete(0,sb.length());
        }
        return set.size();
    }

    public static void main(String[] args) {
        new leetcode804().uniqueMorseRepresentations(null);
    }
}
