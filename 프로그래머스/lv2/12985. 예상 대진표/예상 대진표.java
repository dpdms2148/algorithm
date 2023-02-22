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
            if(a + 1 == b && a / 2  + 1 == b / 2) {
                break;
            }
            a = (int) Math.ceil( (double) a / 2);
            b = (int) Math.ceil( (double) b / 2);
            answer++;
        }
    
        return answer;
    }
}