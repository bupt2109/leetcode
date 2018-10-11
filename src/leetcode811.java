import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 811. Subdomain Visit Count
 * Time: 2018-09-26 13:57
 *
 */
public class leetcode811 {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> map = new HashMap<>();
        String[] num1domain;
        String tmp;
        int num;
        int i;
        List<String> res = new ArrayList<>();
        for(String cpdomain: cpdomains){
            num1domain = cpdomain.split(" ");
            num = Integer.parseInt(num1domain[0]);
            tmp = num1domain[1];
            do{
                if(map.containsKey(tmp)){
                    map.put(tmp, num + map.get(tmp));
                }else{
                    map.put(tmp, num);
                }
                if((i = tmp.indexOf('.')) != -1) {
                    tmp = tmp.substring(i + 1);
                }else{
                    tmp = null;
                }
            }while(tmp!=null);
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            res.add(entry.getValue() + " " + entry.getKey());
        }
        return res;
    }

    public static void main(String[] args) {
        leetcode811 test = new leetcode811();
        String[] urls = {
                "900 google.mail.com",
                "50 yahoo.com",
                "1 intel.mail.com",
                "5 wiki.org"
        };//"901 mail.com","50 yahoo.com","900 google.mail.com","5 wiki.org","5 org","1 intel.mail.com","951 com"
        List<String> res = test.subdomainVisits(urls);
    }
}
