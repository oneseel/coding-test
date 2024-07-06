import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine()); // 추천 문제 리스트의 수
        TreeSet<Problem> set = new TreeSet<>((o1, o2) -> {
            if (o1.l == o2.l) { // 문제 난이도가 같다면
                return o1.p - o2.p; // 문제번호 내림차순
            }
            return o1.l - o2.l; // 문제 난이도 오름차순
        });

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken()); // 문제번호
            int l = Integer.parseInt(st.nextToken()); // 난이도
            Problem problem = new Problem(p, l);
            set.add(problem);
            map.put(p, l);
        }

        int m = Integer.parseInt(br.readLine()); // 명령어의 수
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            int p = Integer.parseInt(st.nextToken());

            switch (command) {
                case "add":
                    int l = Integer.parseInt(st.nextToken());
                    Problem problem = new Problem(p, l);
                    set.add(problem);
                    map.put(p, l);
                    break;

                case "recommend":
                    if (p == 1) {
                        System.out.println(set.last().p);
                    } else {
                        System.out.println(set.first().p);
                    }
                    break;

                case "solved":
                    set.remove(new Problem(p, map.get(p)));
                    break;
            }
        }
    }
}

class Problem {
    int p;
    int l;

    public Problem (int p, int l) {
        this.p = p;
        this.l = l;
    }
}
