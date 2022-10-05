import java.util.Arrays;

/*
문제: 프로그래머스 - 분수의 덧셈

유클리드 호제법으로 최대공약수, 최소공배수 구하는법
1. a, b 숫자 2개의 조건은 a > b
2. while(b!=0) 반복문에서 r = a % b, a = b, b = r
3. return a -> 최대 공약수
4. a * b / 최대공약수 -> 최소공배수

실행로직
1. 분모 num1과 num2의 최소공배수를 찾는다.
2. 분모 num1과 num2를 최소공배수로 만든다.
3. 각 분모를 최소공배수로 만들기위해 곱한만큼 분자인 denum1, denum2에 각각 곱해준다.
4. 두 분수를 더한다. (분수 더하기에서 분모는 그대로간다)
5. 결과 분수 값에서 최대공약수를 구한다.
6. 최대공약수로 분모와 분자를 각각 나눠서 기약분수로 만든다.
7. 결과 분수를 배열로 만들어 리턴한다.
*/

class FractionAdd {
    public int[] solution(int denum1, int num1, int denum2, int num2) {
        int gcdnum = gcd(num1, num2); //분모의 최대공약수
        int lcmnum = lcm(num1, num2, gcdnum); //분모의 최소공배수
        
        int one = lcmnum / num1; //첫번째 분모를 최소공배수로 만들기위해 곱하기 위한 숫자
        int two = lcmnum / num2; //두번째 분모를 최소공배수로 만들기위해 곱하기 위한 숫자
        
        num1 = num1 * one; //첫번째 분모를 최소공배수로 만들기
        denum1 = denum1 * one; //첫번째 분모를 곱한만큼 첫번째 분자도 곱하기
        
        num2 = num2 * two; //두번째 분모를 최소공배수로 만들기
        denum2 = denum2 * two; //두번째 분모를 곱한만큼 두번째 분자도 곱하기

        int resultNum = num1; //결과 분수의 분모 (분수 계산에서 분모는 그대로 간다)
        int resultDenum = denum1 + denum2; //결과 분수의 분자
        
        gcdnum = gcd(resultNum, resultDenum); //결과 분수의 최대공약수 구하기
        resultNum = resultNum / gcdnum; //결과 분수의 분모 최대공약수로 나누기
        resultDenum = resultDenum / gcdnum; //결과 분수의 분자 최대공약수로 나누기
        
        int[] answer = {resultDenum, resultNum}; //결과를 배열에 저장하여 리턴
        return answer;
    }
    
    //최대공약수
    public static int gcd(int a, int b) {
        if (a < b) {
            int temp = a;
            a = b;
            b = temp;
        }
        
        while(b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
    
    //최소공배수
    public static int lcm(int a, int b, int c) {
        int result = (a * b) / c;
        return result;
    }

    public static void main(String[] args) {
        FractionAdd fa = new FractionAdd();
        System.out.println(Arrays.toString(fa.solution(1, 2, 3, 4)));
    }
}