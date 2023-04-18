class Solution {
    public int solution(String dirs) {
        int answer = 0;
        int x = 5;
        int y = 5;
        boolean[][][] visited = new boolean[11][11][5];
        
        for(int i = 0; i < dirs.length(); i++){
            if(dirs.charAt(i) == 'U'){      // U(1) 일때
                int ny = y + 1;
                if(ny >= 11){               // y값이 좌표를 벗어날 때
                    continue;
                }
                if(!visited[x][y][1] && !visited[x][ny][2]){     // 처음 방문하는 길일 때
                    visited[x][y][1] = true;
                    answer++;
                }
                y = ny;                     // y값 업데이트
            }else if(dirs.charAt(i) == 'D'){// D(2) 일때
                int ny = y - 1;
                if(ny < 0){                 // y값이 좌표를 벗어날 때
                    continue;
                }
                if(!visited[x][ny][1] && !visited[x][y][2]){     // 처음 방문하는 길일 때
                    visited[x][y][2] = true;
                    answer++;
                }
                y = ny;                     // y값 업데이트 
            }else if(dirs.charAt(i) == 'R'){// R(3) 일때
                int nx = x + 1;
                if(nx >= 11){               // x값이 좌표를 벗어날 때
                    continue;
                }
                if(!visited[x][y][3] && !visited[nx][y][4]){     // 처음 방문하는 길일 때
                    visited[x][y][3] = true;
                    answer++;
                }
                x = nx;                     // x값 업데이트
            }else{                          // L(4) 일때
                int nx = x - 1;
                if(nx < 0){                 // x값이 좌표를 벗어날 때
                    continue;
                }
                if(!visited[nx][y][3] && !visited[x][y][4]){     // 처음 방문하는 길일 때
                    visited[x][y][4] = true;
                    answer++;
                }
                x = nx;                     // x값 업데이트
            }
        }
        
        return answer;
    }
}