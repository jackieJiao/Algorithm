package leetcode;

public class LCP_14 {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length==0)
            return "";
        String prefix=strs[0];
        //lcp(0,n)=lcp(lcp(0,n-1),n)
        for (int i=1;i<strs.length;i++){
            while(strs[i].indexOf(prefix)!=0){
                //prefix --
                prefix=prefix.substring(0,prefix.length()-1);
                if(prefix.equals(""))
                    return "";
            }
        }


        return prefix;
    }
}
