import java.math.*;

class Solution {
    public long solution(int w, int h) {
        BigInteger bw = BigInteger.valueOf(w);
        BigInteger bh = BigInteger.valueOf(h);
        long gcd = bw.gcd(bh).longValue();
        
        long num = (long) w * (long) h;
        
        return num - ((w + h) / gcd - 1) * gcd;
    }
}
