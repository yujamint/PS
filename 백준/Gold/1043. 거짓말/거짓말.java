import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    static List<List<Integer>> party = new ArrayList<>();
    static List<List<Integer>> participatingParty = new ArrayList<>();
    static boolean[] partyVisited, memberVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        partyVisited = new boolean[m];
        memberVisited = new boolean[n + 1];
        st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        Stack<Integer> known = new Stack<>();
        for (int i = 0; i < k; i++) {
            int num = Integer.parseInt(st.nextToken());
            known.push(num);
            memberVisited[num] = true;
        }
        // 진실 아는 사람 스택에 넣어놓기
        // 스택 꺼내면서 그 사람이 속한 파티 돌기
            // 아직 진실을 모르는 사람이면 스택에 넣기
        for (int i = 0; i < m; i++) {
            party.add(new ArrayList<>());
        }
        for (int i = 0; i <= n; i++) {
            participatingParty.add(new ArrayList<>());
        }
        for (int partyIdx = 0; partyIdx < m; partyIdx++) {
            st = new StringTokenizer(br.readLine());
            int memberCount = Integer.parseInt(st.nextToken());
            for (int j = 0; j < memberCount; j++) {
                int memberIdx = Integer.parseInt(st.nextToken());
                party.get(partyIdx).add(memberIdx);
                participatingParty.get(memberIdx).add(partyIdx);
            }
        }

        while (!known.isEmpty()) {
            int knownMember = known.pop();
            for (int partyIdx : participatingParty.get(knownMember)) {
                if (partyVisited[partyIdx]) continue;
                partyVisited[partyIdx] = true;
                for (int partyMember : party.get(partyIdx)) {
                    if (memberVisited[partyMember]) continue;
                    memberVisited[partyMember] = true;
                    known.push(partyMember);
                }
            }
        }

        int count = 0;
        for (int i = 0; i < m; i++) {
            if (!partyVisited[i]) count++;
        }
        System.out.println(count);
    }

}
