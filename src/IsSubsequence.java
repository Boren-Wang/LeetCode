public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        // s abc
        // t ahbgdc
        int sIdx = 0;
        int tIdx = 0;
        while(tIdx<t.length() && sIdx<s.length()) {
            if(s.charAt(sIdx)==t.charAt(tIdx)) {
                sIdx++;
                tIdx++;
            } else {
                tIdx++;
            }
        }
        return sIdx==s.length();                                                              
    }
}
