public class ReorganizeString {

    public static String reorganizeString(String s) {
        StringBuilder res = new StringBuilder();
        int hash[]=new int[30] ;
        int maxCharCount =0;
        int maxId = -1;
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            hash[ch-'a']++;
            if(hash[ch-'a'] > maxCharCount){
                maxCharCount = hash[ch-'a'];
                maxId=ch-'a';
            }
        }
        int preId=-1;
        maxId=-1;
        while(true){
            maxCharCount=0;
            for(int i=0;i<26;i++){
                if(maxCharCount < hash[i] && i!=preId){
                    maxCharCount = hash[i];
                    maxId=i;
                }
            }
            if(maxId!=preId){
                res.append((char)(maxId+'a'));
                hash[maxId]--;
            }
            else
                break;
            preId=maxId;
        }
        if(s.length()!=res.length())
            return "";
        return res.toString();
    }
    public static void main(String[] args) {
        System.out.println(reorganizeString(""));
    }
}
