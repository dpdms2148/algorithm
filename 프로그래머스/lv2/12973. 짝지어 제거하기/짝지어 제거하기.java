import java.util.Stack;

class Solution
{
    public int solution(String s)
    {
        Stack<Character> stack = new Stack<>();
        int answer = -1;
        int length = s.length();
        for(int i = 0; i < length; i++){
            if(stack.size() == 0){
                stack.push(s.charAt(i));
            } else if(stack.peek() == s.charAt(i)){
                stack.pop();
            } else if(stack.peek() != s.charAt(i)){
                stack.push(s.charAt(i));
            }
        }
        
        if(stack.size() == 0){
            return 1;
        }else{
            return 0;   
        }
    }
}