package CodingBat.Warmup2;

public class StringSplosion {

    public static void main(String[] args) {}

    public String stringSplosion(String str) {
        StringBuilder newStr = new StringBuilder();
        StringBuilder tempStr = new StringBuilder();

        if (str.length() == 1) {
            return newStr.append(str).toString();
        } else {
            for (int i = 0; i < str.length(); i++) {
                tempStr.append(str.charAt(i));
                newStr = newStr.append(tempStr);
            }
        }

        return newStr.toString();
    }
}