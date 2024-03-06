class Solution {
    public String solution(String s) {
        String answer = "";

        if(97<=s.charAt(0)-0 && s.charAt(0)-0<=122){
             answer+=(char)(s.charAt(0)-32);
            }
            else{
                answer+=s.charAt(0);
            }

        for(int i=1;i<s.length();i++){
            if(s.charAt(i-1)==' ' && 97<=s.charAt(i)-0 && s.charAt(i)-0<=122){
                answer+=(char)(s.charAt(i)-32);
            }
            else if(s.charAt(i-1)!=' '&& 65<=s.charAt(i)-0 && s.charAt(i)-0<=90){
                answer+=(char)(s.charAt(i)+32);
            }
            else{
                answer+=s.charAt(i);
            }

        }

        return answer;
    }
}
