class Solution {
    public String solution(String s) {
        String result = new String();
        String[] strings = s.toLowerCase().split("");
        boolean check = true;

        for (int i = 0; i < strings.length; i++) {
            if (check) {
                result += strings[i].toUpperCase();
                check = false;
            } else result += strings[i];
            if (strings[i].equals(" ")) {
                check = true;
            }
        }

        return result;
    }
}
