/*
정수 내림차순으로 배치하기
https://school.programmers.co.kr/learn/courses/30/lessons/12933

문제풀이
1. 정수 n을 문자열로 변환
2. 문자열을 문자 배열로 변환
3. 배열을 정렬
4. 정렬된 배열을 문자열로 변환
5. 문자열을 뒤집어 내림차순 정렬
6. 정수로 변환하여 반환

시간복잡도
O(n log n)
Arrays.sort()가 가장 큰 O(n log n)의 시간복잡도를 가짐
*/

import java.util.Arrays;

class Solution {
    public long solution(long n) {
        long answer = 0;
        
        String s = String.valueOf(n);
        char[] arr = s.toCharArray();
        
        Arrays.sort(arr);
        String sorted = String.valueOf(arr);
        
        StringBuilder sb = new StringBuilder(sorted);
        String reversed = sb.reverse().toString();
        
        answer = Long.parseLong(reversed);
        return answer;
    }
}