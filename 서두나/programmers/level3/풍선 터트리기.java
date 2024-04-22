class Solution {
    public int solution(int[] a) {
        int answer = 1;
        
        int[] minValue= new int[a.length];
        minValue[a.length-1]=a[a.length-1];
        for(int i=a.length-2;i>=0;i--){
            minValue[i]=Math.min(minValue[i+1],a[i]);
        }
        
        int minLeft=a[0];
        
        for(int i=1;i<a.length;i++){
            if(a[i]<=minValue[i] || a[i]<=minLeft){
                answer++;
            }
            minLeft=Math.min(minLeft, a[i]);
        }
        
        return answer;
    }
}
