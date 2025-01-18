package CodingBat.String3;

public class MirrorEnds {
    
    public static void main(String[] args) {
        System.out.println(mirrorEnds("123and then 321"));
    }

    public static String mirrorEnds(String string) {
        StringBuilder result = new StringBuilder();
    
        for(int i = 0; i < string.length(); i++) {
            if(string.charAt(i) == string.charAt(string.length() - i - 1))
                result.append(string.charAt(i));
            else
                break;
        }
                                  
        return result.toString();
        
        // my long, convoluted, and WRONG code
        /*
        StringBuilder firstHalf = new StringBuilder();
        StringBuilder secondHalf = new StringBuilder();
        StringBuilder mirror = new StringBuilder();

        int halfStrLen = string.length() / 2;

        boolean odd = false;
        if (string.length() % 2 == 1) {
            odd = true;
        }

        for (int i = 0; i < halfStrLen; i++) {
            firstHalf.append(string.charAt(i));
        }
    
        for (int i = string.length() - 1; i >= halfStrLen; i--) {
            secondHalf.append(string.charAt(i));
        }

        for (int i = 0; i < firstHalf.length(); i++) {
            if (firstHalf.charAt(i) == secondHalf.charAt(i)) {
                mirror.append(firstHalf.charAt(i));
            } else {
                break;
            }
        }

        if (odd) {
            if (firstHalf.toString().equals(secondHalf.substring(0, firstHalf.length()))) {
                mirror.append(string.charAt(halfStrLen));
                for (int i = 0; i < firstHalf.length(); i++) {
                    if (firstHalf.charAt(i) == secondHalf.charAt(i)) {
                        mirror.append(firstHalf.charAt(i));
                    }
                }
            }
        }

        return mirror.toString();
         */
    }
}