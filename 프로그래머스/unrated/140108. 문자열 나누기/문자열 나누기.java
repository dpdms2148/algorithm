class Solution {
    public int solution(String s) {
        int answer = 0;
        
        for(int i = 0; i < s.length(); i++){
            //기준 문자 및 카운트 초기화
            char x = s.charAt(i);
            System.out.println(x+"("+i+")");
            int sameCount = 1;
            int diffCount = 0;
            
            //남은 부분이 없으므로 종료
            if(i == s.length() - 1){
                answer++;
                break;
            }
            
            //탐색 시작
            int j = 0;
            while(sameCount!=diffCount){
                j++;
                if((i + j) == s.length() - 1){
                    break;
                }
                
                if(x == s.charAt(i + j)){
                    sameCount++;
                }else{
                    diffCount++;
                }
            }
            i += j;
            
            answer++;
        }
        return answer;
    }
}