/**
 * To Lower Case
 * Implement function ToLowerCase() that has a string parameter str, and returns the same string in lowercase.
 * Example 1:

 Input: "Hello"
 Output: "hello"
 Example 2:

 Input: "here"
 Output: "here"
 Example 3:

 Input: "LOVELY"
 Output: "lovely"
 */
public class leetcode709 {
    public String toLowerCase(String str) {
        StringBuilder sb = new StringBuilder();
        for(char ch: str.toCharArray()){
            if(ch>='A' && ch<='Z'){
                //大小写ASCII码差32
                sb.append((char)(ch + 32));
            }else{
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}
