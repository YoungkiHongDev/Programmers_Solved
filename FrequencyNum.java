/*
문제: 프로그래머스 - 최빈값 구하기

문제이해
[1, 2, 3, 3, 4] 와 같은 배열을 넘겨받고 여기서 최빈값 찾아서 리턴 하지만 최빈값이 여러개면 -1 리턴

실행로직
1. 자바의 메소드들을 활용하기 위해 배열을 어레이리스트에 담기
2. 중복을 제거하는 해시셋을 이용하여 for-each문으로 각 숫자의 빈도수만 담은 어레이리스트 생성
3. 각 빈도수를 비교하여 최대 빈도수 찾기 + 최대 빈도수 중복체크
4. 중복이 있다면 -1 리턴, 중복이 없다면 최대 빈도수의 숫자 리턴
*/
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

class FrequencyNum {
    public int solution(int[] array) {
        Integer[] intarr = Arrays.stream(array).boxed().toArray(Integer[]::new); //배열을 어레이리스트에 담기위해 Integer로 형변환
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(intarr)); //주어진 배열을 담은 어레이리스트
        HashSet<Integer> has = new HashSet<>(Arrays.asList(intarr)); //중복을 제거하기 위한 해시셋
        ArrayList<Integer> hasarr = new ArrayList<>(has); //중복을 제거한 해시셋을 담은 어레이리스트
        ArrayList<Integer> fre = new ArrayList<>(); //각 숫자의 빈도수를 담기위한 어레이리스트
        
        //어레이리스트에 각 숫자의 빈도수 담기위한 반복문
        for (int i : hasarr) {
            fre.add(Collections.frequency(arr, i));
        }
        
        int n = fre.size(); //반복문을 돌리기위한 회수를 담은 변수
        int num = fre.get(0); //첫번째 빈도수를 담은 변수
        int chk = 0; //중복을 체크하기위한 변수
        //각 빈도수를 비교하여 최대 빈도수와 빈도수 중복체크를 위한 반복문
        for (int i=1; i<n; i++) {
            if (num < fre.get(i)) {
                num = fre.get(i);
                chk = 0;
            } else if (num == fre.get(i)) {
                chk++;
            }
        }
        
        int answer = 0; //리턴값을 담을 변수
        //중복이 있다면 -1, 중복이 없다면 최대 빈도수의 숫자 리턴
        if (chk > 0) {
            answer = -1;
        } else if (chk == 0) {
            answer = (int) hasarr.get(fre.indexOf(num)); //최대 빈도수를 가진 숫자를 해시셋을 담은 어레이리스트에서 가져옴
        }
        
        return answer;
    }

    public static void main(String[] args) {
        FrequencyNum fn = new FrequencyNum();
        int[] testCase = {1, 2, 3, 3, 3, 4};
        System.out.println(fn.solution(testCase));
    }
}