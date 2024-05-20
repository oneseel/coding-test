import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        // 장르별 전체 플레이 맵 구성
        Map<String, Integer> totalPlay = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            totalPlay.put(genres[i], totalPlay.getOrDefault(genres[i], 0) + plays[i]);
        }

        // 고유번호에 따른 플레이수 리스트
        List<int[]> playList = new ArrayList<>();
        for (int i = 0; i < genres.length; i++) {
            playList.add(new int[] {i, plays[i]});
        }

        // 정렬
        Collections.sort(playList, (o1, o2) -> {
            // 장르가 다르다면 (더 많이 재생된 장르, 내림차순)
            if (!genres[o1[0]].equals(genres[o2[0]])) {
                return totalPlay.get(genres[o2[0]]) - totalPlay.get(genres[o1[0]]);
            } 
            // 장르가 같다면 (더 많이 재생된 노래, 내림차순)
            else if (o1[1] != o2[1]) {
                return o2[1] - o1[1];
            } 
            // 재생수도 같다면 (고유번호가 낮은 순, 오름차순)
            else {
                return o1[0] - o2[0];
            }
        });
        
        // 장르별로 최대 2곡씩 베스트 앨범에 추가
        Map<String, Integer> count = new HashMap<>();
        List<Integer> bestAlbum = new ArrayList<>();
        for (int[] play : playList) {
            String genre = genres[play[0]];
            
            if (count.getOrDefault(genre, 0) < 2) {
                bestAlbum.add(play[0]);
                count.put(genre, count.getOrDefault(genre, 0) + 1);
            }
        }

        return bestAlbum.stream().mapToInt(i -> i).toArray();
    }
}
