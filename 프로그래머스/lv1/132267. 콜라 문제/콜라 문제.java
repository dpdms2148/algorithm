class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        while(n >= a){
            // 빈병 n개를 가져가서 받은 콜라의 수
            answer += (n / a) * b;
            // 남은 빈병의 수
            n = (n / a) * b + n % a;
        }
        return answer;
    }
}
