class Solution {
    public String solution(String m, String[] musicinfos) {
        m = m.replace("C#", "c").replace("D#", "d").replace("F#", "f").replace("G#", "g").replace("A#", "a").replace("B#", "b");

        String result = "(None)";
        int maxPlayTime = 0;

        for (int i = 0; i < musicinfos.length; i++) {
            String[] musicinfo = musicinfos[i].split(",");
            int start = timeCal(musicinfo[0]);
            int end = timeCal(musicinfo[1]);
            String title = musicinfo[2];
            int time = end - start;
            String melody = musicinfo[3].replace("C#", "c").replace("D#", "d").replace("F#", "f").replace("G#", "g").replace("A#", "a").replace("B#", "b");

            StringBuilder playedMelody = new StringBuilder();
            for (int j = 0; j < time; j++) {
                playedMelody.append(melody.charAt(j % melody.length()));
            }

            if (playedMelody.toString().contains(m) && time > maxPlayTime) {
                result = title;
                maxPlayTime = time;
            }
        }

        return result;
    }

    private int timeCal(String t) {
        String[] time = t.split(":");
        int h = Integer.parseInt(time[0]);
        int m = Integer.parseInt(time[1]);

        return 60 * h + m;
    }
}
