class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 1;
        //a < b가 되도록  
        if(a > b) {
            int temp = a;
            a = b;
            b = temp;
        }
        
        while(true) {
            //현재 라운드에서 만났는지 확인
            if(a + 1 == b && a / 2  + 1 == b / 2) {
                break;
            }
            //다음 라운드 참가 번호 계산
            a = (int) Math.ceil( (double) a / 2);
            b = (int) Math.ceil( (double) b / 2);
            answer++;
        }
        
        return answer;
    }
}