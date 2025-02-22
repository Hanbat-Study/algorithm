import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N, time, result;
    static PriorityQueue<Meeting> pq;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        time = 0;
        result = 0;
        pq = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            pq.add(new Meeting(start, true));
            pq.add(new Meeting(end, false));
        }

        while (!pq.isEmpty()) {
            Meeting meeting = pq.poll();

            if (meeting.flag) {
                time++;

                result = Math.max(time, result);
            } else time--;
        }

        System.out.println(result);
    }

    public static class Meeting implements Comparable<Meeting> {
        int start;
        boolean flag;

        public Meeting(int start, boolean flag) {
            this.start = start;
            this.flag = flag;
        }

        @Override
        public int compareTo(Meeting meeting) {
            return this.start - meeting.start;
        }
    }
}
