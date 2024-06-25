import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] words = new String[5]; // 단어를 저장할 배열
        StringBuilder result = new StringBuilder();

        int maxLength = 0; // 최대 길이
        for (int i = 0; i < 5; i++) {
            words[i] = br.readLine();
            maxLength = Math.max(maxLength, words[i].length());
        }

        for (int j = 0; j < maxLength; j++) {
            for (int i = 0; i < 5; i++) {
                if (j < words[i].length()) {
                    result.append(words[i].charAt(j));
                }
            }
        }

        System.out.println(result.toString());
    }
}
