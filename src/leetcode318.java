import java.util.HashMap;

/**
 * Created by YX on 2016/11/3.
 */

//开心！打败99.83的提交者！关键的关键这题我是完全自己做的！！！！！！！！
public class leetcode318 {

    public int maxProduct(String[] words) {
        if(words == null || words.length<2)
            return 0;
        int[] alphabet = new int[26];
        int totallen = words.length;
        int[] lens = new int[totallen];
        int[] table = new int[totallen];
        int i=0,j,res=0;
        for(i=0;i<26;i++){
            alphabet[i] = 1<<i;
        }
        i=0;
        for(String word : words){
            lens[i]=word.length();
            for(char ch : word.toCharArray()){
                table[i] = table[i] | alphabet[ch-'a'];
            }
            i++;
        }
        for(i=0;i<totallen;i++){
            for(j=i+1;j<totallen;j++){
                if((table[i]&table[j])==0){//meiyouchongfu
                    if(lens[i]*lens[j]>res){
                        res = lens[i]*lens[j];
                    }
                }
            }
        }
        for(i=0;i<totallen;i++){
            System.out.print(" "+words[i]+" "+lens[i]);
            System.out.println();
            System.out.println(Integer.toBinaryString(table[i]));
        }
        System.out.println(res);
        return res;
    }

    public static void main(String[] args) {
        leetcode318 test = new leetcode318();
        String[] string = {"ddffe",
                "gggggggggggggggrfseuhiuv",
                "qpwoewjofjeignsnvlcuwegeyr",
                "ssssssss",
                "asgsgwrg",
                "shrhsdgtrtjjshbshey",
                ""
        };
        test.maxProduct(string);
    }
}
