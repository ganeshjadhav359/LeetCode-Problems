public class ImplementStrStr {
    public static int strStr(String haystack, String needle) {
        if(needle.length()==0)
            return 0;
        String z = needle+'#'+haystack;
        int[] lps = new int[z.length()];
        lps[0] = 0;
        for(int i=1;i<z.length();i++){
            int j = lps[i-1];
            while(j>0 && z.charAt(j)!=z.charAt(i))
                j = lps[j-1];
            if(z.charAt(j)==z.charAt(i))
                j++;
            if(j==needle.length())
                return i-2*j;
            lps[i]=j;
        }
        return -1;
    }
    public static void main(String[] args) {

    }
}
