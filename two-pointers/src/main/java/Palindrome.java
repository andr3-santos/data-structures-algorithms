public class Palindrome {

    public boolean isPalindrome(String s) {
        int pointer1 = 0;
        int pointer2 = s.length() -1;
        while (pointer1 < pointer2) {
            // skip non-alphanumeric
            while (pointer1 < pointer2 && !Character.isLetterOrDigit(s.charAt(pointer1)))
                pointer1++;
            while (pointer1 < pointer2 && !Character.isLetterOrDigit(s.charAt(pointer2)))
                pointer2--;

            // case-insensitive compare
            if (Character.toLowerCase(s.charAt(pointer1)) != Character.toLowerCase(s.charAt(pointer2)))
                return false;

            pointer1++;
            pointer2--;
            }
        return true;
    }

    public static void main(String[] args) {
        Palindrome p = new Palindrome();
        System.out.println(p.isPalindrome("xaX"));
    }
}
