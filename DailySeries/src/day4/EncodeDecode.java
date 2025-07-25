package day4;

import java.util.ArrayList;
import java.util.List;

public class EncodeDecode {
    public String encode(List<String> strs) {
        StringBuilder builder=new StringBuilder();
        for(String str:strs){
            builder.append(str.length()).append("#").append(str);
        }
        return  builder.toString();
    }

    public static List<String> decode(String str) {

        List<String> array=new ArrayList<>();
        int i=0;
        while(i<str.length()){
            int j=i;
            while(str.charAt(j)!='#')
            {
                j++;
            }
            int length= Integer.parseInt(str.substring(i,j));
            array.add(str.substring(j+1,j+1+length));

            i=j+1+length;
        }
        return array;

    }
    public static void main(String[] args) {
        System.out.println(decode("4#neet5#Co#de"));
    }
}
