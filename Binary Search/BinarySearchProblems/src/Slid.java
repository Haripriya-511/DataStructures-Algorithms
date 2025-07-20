import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Slid {
    public static void main(String[] args) {
        String s="baa";
        String p="aa";
        int i=0,j=0;
        int n=s.length();
        int matchCount=0;

        List<Integer> l=new ArrayList<>();
        //if(p.equals(s))

        Map<Character,Integer>  mp=new HashMap<>();

        for(int ind=0;ind<p.length();ind++)
            mp.put(p.charAt(ind),mp.getOrDefault(p.charAt(ind),0)+1);

        while(j<n){
            if(mp.containsKey(s.charAt(j))){
                mp.put(s.charAt(j),mp.get(s.charAt(j))-1);
                if(mp.get(s.charAt(j))==0)
                    matchCount++;
            }
            if((j-i+1)==p.length()){
                if(matchCount==p.length())
                {
                    l.add(i);
                }
                char removeChar=s.charAt(i);
                if(mp.containsKey(removeChar)){
                    int freq= mp.get(removeChar);
                    if(freq==0){
                        matchCount--;

                    }
                    mp.put(removeChar,freq+1);
                }
                i++;
            }
            j++;
        }

        System.out.println(l);
    }
}
