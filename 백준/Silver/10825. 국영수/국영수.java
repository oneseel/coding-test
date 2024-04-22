import java.io.*;
import java.util.*;

// 학생 정보 클래스
class Student {
    String name;
    int korean, english, math;

    public Student(String name, int korean, int english, int math) {
        this.name = name;
        this.korean = korean;
        this.english = english;
        this.math = math;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 학생 수
        List<Student> students = new ArrayList<>(); // 학생 정보를 저장할 리스트
        
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken(); // 이름
            int korean = Integer.parseInt(st.nextToken()); // 국어 점수
            int english = Integer.parseInt(st.nextToken()); // 영어 점수
            int math = Integer.parseInt(st.nextToken()); // 수학 점수
            students.add(new Student(name, korean, english, math));
        }
        
        // 정렬 기준에 따라 학생 리스트 정렬
        Collections.sort(students, (o1, o2) -> {
            if (o1.korean != o2.korean) return o2.korean - o1.korean; // 내림차순
            else if (o1.english != o2.english) return o1.english - o2.english; // 오름차순
            else if (o1.math != o2.math) return o2.math - o1.math; // 내림차순
            else return o1.name.compareTo(o2.name); // 오름차순 (String은 compareTo 사용)
        });

        // 정렬된 학생 이름 출력
        for (Student student : students) {
            System.out.println(student.name);
        }
    }
}
