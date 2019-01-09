/**
 * Created by sglopez on 1/9/2019.
 */
public class RemoveDuplicates {
    public static void main (String args[] ){
        String s = "qwertyuiopasdfghjklqzwxrtcvb";
        System.out.println("original characters: " + s + " -- result characters: " + removeDuplicates(s));
    }

    private static String removeDuplicates(String s) {
        boolean[] strChar = new boolean[256];
        char[] chars = new char[s.length()];
        StringBuffer stringBuffer = new StringBuffer();


        for (int i=0 ;i<= s.length() - 1;i ++) {
            int val = s.charAt(i);
            if (!strChar[val]) {
                strChar[val] = true;
                stringBuffer.append(s.charAt(i));
                chars[i] = s.charAt(i);
            } else
                System.out.println("Duplicated removed val : " + val + " - strVal : " + String.valueOf(s.charAt(i)));
        }
//        return String.copyValueOf(chars);
        return stringBuffer.toString();
    }
}
