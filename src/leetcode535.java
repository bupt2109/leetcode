import java.util.HashMap;
import java.util.Map;

/**
 * Author:
 * Time: 2018-10-11 16:11
 * Copyright (C) 2018
 */
public class leetcode535 {
    Map<String,String> urlMap = new HashMap<>();
    int index = 31415926;

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        String a = index2String(index);
        index ++;
        urlMap.put(a, longUrl);
        return "http://tinyurl.com/" + a;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        String longUrl = urlMap.get(shortUrl.substring(19,25));
        return longUrl;
    }

    private String index2String(int index) {
        int chu = index;
        int shang;
        int yu;
        int ii = 5;
        char[] res = "000000".toCharArray();
        while(chu != 0){
            shang = chu / 36;
            yu = chu % 36;
            chu = shang;
            if(yu<10){
                res[ii] = (char)('0' + yu);
            }else{
                res[ii] = (char)('a' + yu - 10);
            }
            ii--;
        }
        return new String(res);
    }

    // Your Codec object will be instantiated and called as such:
    // Codec codec = new Codec();
    // codec.decode(codec.encode(url));

    public static void main(String[] args) {
        String[] urls = {
                "https://leetcode.com/problems/design-tinyurl0",
                "https://leetcode.com/problems/design-tinyurl1",
                "https://leetcode.com/problems/design-tinyurl2",
                "https://leetcode.com/problems/design-tinyurl3",
                "https://leetcode.com/problems/design-tinyurl4",
        };
        leetcode535 codec = new leetcode535();
        for (int i = 0; i < 1000; i++) {
            String encode = codec.encode(urls[0] + i);
            System.out.println(encode);
//            System.out.println(codec.decode(encode));
//            System.out.println();
        }
    }
}
