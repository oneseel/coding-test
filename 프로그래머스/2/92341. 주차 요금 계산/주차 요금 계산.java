import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {

  public int[] solution(int[] fees, String[] records) {

    // fees = {기본시간, 기본요금, 단위시간, 단위요금}
    // records = {시각, 차량번호, 내역}
    Map<String, Integer> parking = new HashMap<>(); // 주차된 차량 맵(차 번호, 시간)
    Map<String, Integer> times = new HashMap<>(); // 차량의 누적시간(차 번호, 누적시간)
    List<String> cars = new ArrayList<>(); // 차량리스트

    for (int i = 0; i < records.length; i++) {
      String[] record = records[i].split(" ");
      int time = time(record[0]);
      String car = record[1];

      if (!cars.contains(car)) {
        cars.add(car); // 차량 등록
        times.put(car, 0); // times Map에 차량 등록
      }

      // 출차
      if (parking.containsKey(car)) {
        times.put(car, times.get(car) + (time - parking.get(car)));
        parking.remove(car);
        // 입차
      } else {
        parking.put(car, time);
      }
    }

    int[] answer = new int[cars.size()];
    Collections.sort(cars);

    for (int i = 0; i < cars.size(); i++) {
      int basicTime = fees[0];
      int basicFee = fees[1];
      int unitTime = fees[2];
      int unitFee = fees[3];
      answer[i] = basicFee;
      String car = cars.get(i);
      int time = times.get(car) - basicTime;

      // 출차가 안되어 있다면(23:59)
      if (parking.containsKey(car)) {
        time += time("23:59") - parking.get(car);
      }

      // 요금 계산
      if (time > 0) {
        answer[i] += (int) (Math.ceil((double) time / unitTime) * unitFee);
      }
    }

    return answer;
  }

  public int time(String time) {
    String[] timeArray = time.split(":");
    int hour = Integer.parseInt(timeArray[0]);
    int minute = Integer.parseInt(timeArray[1]);

    // 시간을 분으로 변환
    return hour * 60 + minute;
  }
}