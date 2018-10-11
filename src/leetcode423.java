/**
 * Created by YX on 2016/11/4.
 */
public class leetcode423 {
    public String originalDigits(String s) {
/*
         efghinorstuvwxz
    0    100000110000001 4
    1    100001100000000 3
    2    000000100100100 3
    3    200100010100000 5
    4    010000110010000 4
    5    110010000001000 4
    6    000010001000010 3
    7    200001001001000 5
    8    101110000100000 5
    9    100012000000000 4
         921244432312111 40
         efghinorstuvwxz

         efhinorstv
    1    1000110000 3
    3    2010001010 5
    5    1101000001 4
    7    2000100101 5
    9    1001200000 4
         7112411112 21 0 2 4 6 8
         efhinorstv

         ein
    9    112   1 3 5 7
*/
        int[] letters = new int[26];
        int[] digits = new int[10];
        StringBuilder sb = new StringBuilder();
        for(char ch: s.toCharArray()){
            letters[ch-'a']++;
        }
        //zxwug  02468
        if(letters[25]!=0){//z
            digits[0] = letters[25];    //0
            letters[4]-=letters[25];    //e
            letters[14]-=letters[25];   //o
            letters[17]-=letters[25];   //r
        }
        if(letters[22]!=0){//w
            digits[2] = letters[22];    //2
            letters[19]-=letters[22];   //t
            letters[14]-=letters[22];   //o
        }
        if(letters[20]!=0){//u
            digits[4] = letters[20];    //4
            letters[5]-=letters[20];    //f
            letters[14]-=letters[20];   //o
            letters[17]-=letters[20];   //r
        }
        if(letters[23]!=0){//x
            digits[6] = letters[23];    //6
            letters[8]-=letters[23];    //i
            letters[18]-=letters[23];   //s
        }
        if(letters[6]!=0){//g
            digits[8] = letters[6];    //8
            letters[7]-=letters[6];    //h
            letters[8]-=letters[6];    //i
            letters[4]-=letters[6];    //e
            letters[19]-=letters[6];   //t
        }
        //step2: fors  1357
        if(letters[14]!=0){//o
            digits[1] = letters[14];    //1
            letters[4]-=letters[14];    //e
            letters[13]-=letters[14];   //n
        }
        if(letters[17]!=0){//r
            digits[3] = letters[17];    //3
            letters[4]-=letters[17]*2;  //ee
            letters[7]-=letters[17];    //h
            letters[19]-=letters[17];   //t
        }
        if(letters[5]!=0){//f
            digits[5] = letters[5];    //5
            letters[4]-=letters[5];    //e
            letters[8]-=letters[5];    //i
            letters[21]-=letters[5];   //v
        }
        if(letters[18]!=0){//s
            digits[7] = letters[18];    //7
            letters[4]-=letters[18]*2;  //ee
            letters[13]-=letters[18];   //n
            letters[21]-=letters[18];   //v
        }
        digits[9] = letters[4];         //9

        for(int i=0;i<10;i++) {
            for (int j = 0; j < digits[i]; j++) {
                sb.append(i);
            }
        }
        return sb.toString();
    }
}
