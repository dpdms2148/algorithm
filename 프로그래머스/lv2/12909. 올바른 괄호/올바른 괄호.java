import java.util.Stack;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        
        Stack<Character> stack = new Stack<Character>();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '('){// 여는 괄호일 때
                stack.push('(');
            }else{// 닫는 괄호일 때
                if(stack.size() == 0 ){//스택에 아무것도 없음
                    answer = false;
                    break;
                }if(stack.peek() == '('){//스택에 여는 괄호가 있음
                    stack.pop();
                }else{// 스택에 여는 괄호가 없음
                    answer = false;
                    break;
                }
            }
        }
        if(stack.size() > 0){
            answer = false;
        }
        return answer;
    }
}