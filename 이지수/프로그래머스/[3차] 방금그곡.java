class Solution {
    public String solution(String m, String[] musicinfos) {
        String answer = "";
        int playTime = 0;
        
        m = m.replace("A#", "0");
        m = m.replace("B#", "5");
        m = m.replace("C#", "1");
        m = m.replace("D#", "2");
        m = m.replace("F#", "3");
        m = m.replace("G#", "4");
        
        for(int i = 0; i < musicinfos.length; i++) {
            String[] tmp = musicinfos[i].split(",");
            String[] start = tmp[0].split(":");
            String[] end = tmp[1].split(":");
            
            int l = (Integer.parseInt(end[0]) - Integer.parseInt(start[0])) * 60 + (Integer.parseInt(end[1]) - Integer.parseInt(start[1]));
            
            tmp[3] = tmp[3].replace("A#", "0");
            tmp[3] = tmp[3].replace("B#", "5");
            tmp[3] = tmp[3].replace("C#", "1");
            tmp[3] = tmp[3].replace("D#", "2");
            tmp[3] = tmp[3].replace("F#", "3");
            tmp[3] = tmp[3].replace("G#", "4");
            
            StringBuilder play = new StringBuilder();
            int idx = 0;
            while(idx < l / tmp[3].length()) {
                play.append(tmp[3]);
                idx++;
            }
            
            idx = 0;
            while(idx < l % tmp[3].length())
                play.append(tmp[3].charAt(idx++));
            
            if(play.toString().contains(m)) {
                if(answer.equals("") || playTime < l) {
                    answer = tmp[2];
                    playTime = l;
                }
            }
        }
        
        if(answer.equals(""))
            answer = "(None)";
        
        return answer;
    }
}
