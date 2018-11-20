/**
 * Author:  reverse-only-letters
 * Time: 2018-10-22 10:31
 * Given a string S, return the "reversed" string where all characters that are not a letter stay in the same place, and all letters reverse their positions.

 Example 1:
 Input: "ab-cd"
 Output: "dc-ba"
 Example 2:
 Input: "a-bC-dEf-ghIj"
 Output: "j-Ih-gfE-dCba"
 Example 3:
 Input: "Test1ng-Leet=code-Q!"
 Output: "Qedo1ct-eeLg=ntse-T!"

 Note:
 S.length <= 100
 33 <= S[i].ASCIIcode <= 122
 S doesn't contain \ or "
 */
public class leetcode917 {
    public String reverseOnlyLetters(String S) {
        if(S==null || S.length()==0){
            return S;
        }
        char[] a = S.toCharArray();
        int len = S.length()-1;
        int i = 0,j = len;
        while(i<j){
            while(i<len && (a[i]<'a')){
                i++;
            }
        }
        return null;
    }
}
