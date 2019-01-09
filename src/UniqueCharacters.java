/**
 * Created by sglopez on 1/9/2019.
 */
public class UniqueCharacters {
    public static void main (String args[] ){
        String s = "qwertyuiopasdfghjklqzxcvb";
        char[] chars = new char[s.length()];
        System.out.println("is unique string: " + isUniqueString(s));
    }

    private static boolean isUniqueString(String s) {
        boolean[] strChar = new boolean[256];

        for (int i=0 ;i<= s.length();i ++){
            int val = s.charAt(i);
            if (!strChar[val]){
                System.out.println("val : " + val + "strVal : " + String.valueOf(s.charAt(i)));
                strChar[val] =true;
            }else{
                return false;
            }
        }
        return true;
    }
}
