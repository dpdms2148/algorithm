class Solution {
    public int solution(String s) {
        int answer = 0;
        int sameCount = 0;
        int diffCount = 0;
        char x = s.charAt(0);
        
        for(int i = 0; i < s.length(); i++){
            if(sameCount == diffCount){
                answer++;
                x = s.charAt(i);    
            }
            
            if (x == s.charAt(i)) sameCount++;
            else diffCount++;
        }
        return answer;
    }
}
