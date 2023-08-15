public class ValidPalindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome(".1AbcBa1."));
    }
    public static boolean isPalindrome(String s) {
        char[] chars = s.toLowerCase().toCharArray();
        int l=0;
        int r=chars.length-1;
        while(l<r) {
            if(!Character.isLetterOrDigit(chars[l])) { // while-if-continue结构
                l++;
                continue;
            }
            if(!Character.isLetterOrDigit(chars[r])) {
                r--;
                continue;
            }
            if(chars[l]!=chars[r]) return false;

            l++;
            r--;
        }
        return true;
    }
}