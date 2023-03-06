import java.util.Arrays;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        Arrays.sort(phone_book);
        int n = phone_book.length;
        for(int i = 0; i < n - 1; i++){
            int m = phone_book[i].length();
            for(int j = 0; j < m; j++){
                if(phone_book[i+1].charAt(j) != phone_book[i].charAt(j)){
                    answer = true;
                    break;
                }else{
                    answer = false;
                }
            }
            if(!answer){
                return answer;
            }
            
        }
        return answer;
    }
}