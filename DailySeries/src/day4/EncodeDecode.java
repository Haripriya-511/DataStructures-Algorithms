package day4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EncodeDecode {
    public  static String encode1(List<String> strs) {
        if(strs.isEmpty())
            return "";
        StringBuilder sb=new StringBuilder();
        List<Integer> sizes=new ArrayList<>();
        for(String str:strs){
            sizes.add(str.length());
        }
        for(int size:sizes){
            sb.append(size).append(",");
        }
        sb.append("#");
        for(String str:strs){
            sb.append(str);
        }
        return sb.toString();
    }

    public static List<String> decode1(String str) {
        if (str.length() == 0) {
            return new ArrayList<>();
        }
        List<String> res = new ArrayList<>();
        List<Integer> sizes = new ArrayList<>();
        int i=0;
        while (str.charAt(i) != '#') {
            StringBuilder cur = new StringBuilder();

            while(str.charAt(i)!=','){
                cur.append(str.charAt(i));
                i++;
            }
            sizes.add(Integer.parseInt(cur.toString()));
            i++;
        }
        i++;
        for(int sz:sizes){
            res.add(str.substring(i,i+sz));
            i=i+sz;
        }
        return res;

    }
    public static String encode(List<String> strs) {
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
        List<String> strings= Arrays.asList("neet","code","love","you");
        System.out.println(encode1(strings));
        System.out.println(decode1("4,4,4,3,#neetcodeloveyou"));

        System.out.println(encode(strings));
        System.out.println(decode("4#neet4#code4#love3#you"));


        System.out.println(decode("4#neet5#Co#de"));
    }
}
