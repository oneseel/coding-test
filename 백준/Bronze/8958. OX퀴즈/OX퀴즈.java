import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            String ox = br.readLine();
            String[] arr = ox.split("");
            int score = 0; // 총 점수
            int temp = 0; // 연속된 O의 개수

            for (int j = 0; j < arr.length; j++) {
                if (arr[j].equals("O")) {
                    temp++;
                    score += temp;
                } else {
                    temp = 0; //
                }
            }
            System.out.println(score);
        }
    }
}
