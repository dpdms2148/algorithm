import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    static class Member {
        int level;
        String nickname;

        public Member(int level, String nickname) {
            this.level = level;
            this.nickname = nickname;
        }
    }

    static class Room {
        int firstMemberLevel;
        int memberCount;
        ArrayList<Member> members;

        public Room(int firstMemberLevel, int memberCount, ArrayList<Member> members) {
            this.firstMemberLevel = firstMemberLevel;
            this.memberCount = memberCount;
            this.members = members;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int P = Integer.parseInt(st.nextToken());//플레이어 수
        int M = Integer.parseInt(st.nextToken());//방의 정원

        ArrayList<Room> rooms = new ArrayList<>();
        for (int i = 0; i < P; i++) {
            st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken());//플레이어의 레벨
            String N = st.nextToken();//플레이어의 이름


            if (rooms.size() == 0) {
                // 1. 플레이어가 입장을 신청하였을 때 매칭이 가능한 방이 없다면 새로운 방을 생성하고 입장시킨다.
                // 이떄 해당 방에는 처음 입장한 플레이어의 레벨을 기준으로 -10부터 +10까지 입장 가능하다.
                ArrayList<Member> members = new ArrayList<>();
                members.add(new Member(L, N));
                rooms.add(new Room(L, 1, members));
            } else {
                // 2. 입장 가능한 방이 있다면 입장시킨 후 방의 정원이 모두 찰 때까지 대기시킨다.
                // 이때 입장이 가능한 방이 여러 개라면 먼저 생성된 방에 입장한다.
                boolean isEnterd = false;
                for (Room r : rooms) {
                    if (r.memberCount == M) continue;
                    if (r.firstMemberLevel + 10 < L || r.firstMemberLevel - 10 > L) continue;
                    r.members.add(new Member(L, N));
                    r.memberCount++;
                    isEnterd = true;
                    if(isEnterd) break;
                }
                if(!isEnterd){
                    ArrayList<Member> members = new ArrayList<>();
                    members.add(new Member(L, N));
                    rooms.add(new Room(L, 1, members));
                }
            }
            // 3. 방의 정원이 모두 차면 게임을 시작시킨다.
        }

        for (Room r : rooms) {
            if (r.memberCount == M) {
                System.out.println("Started!");
            } else {
                System.out.println("Waiting!");
            }
            // 방에 있는 플레이어들의 정보는 닉네임이 사전순으로 앞서는 플레이어부터 출력
            Collections.sort(r.members, Comparator.comparing(m -> m.nickname));
            for(Member m : r.members){
                System.out.println(m.level +" "+m.nickname);
            }
        }
    }
}