import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // 입력: 오래된 간판의 수 N
        int N = sc.nextInt();
        sc.nextLine(); // 줄바꿈 처리
        
        // 입력: 새로 연 편의점의 이름
        String storeName = sc.nextLine();
        
        // 입력: 기존 간판 문자열들
        Set<String> validSignboards = new HashSet<>(); // 유효한 간판들을 저장 (중복 제거)
        
        for (int i = 0; i < N; i++) {
            String oldSignboard = sc.nextLine();
            if (canMakeSignboard(oldSignboard, storeName)) {
                validSignboards.add(oldSignboard); // 유효한 간판만 저장
            }
        }
        
        // 결과 출력: 유효한 간판의 수
        System.out.println(validSignboards.size());
    }
    
    // 특정 간판으로 가게 이름을 만들 수 있는지 확인하는 함수
    private static boolean canMakeSignboard(String oldSignboard, String storeName) {
        int oldLength = oldSignboard.length();
        int nameLength = storeName.length();
        
        // 간판의 모든 가능한 시작 위치에서 검사
        for (int start = 0; start < oldLength; start++) {
            for (int gap = 1; gap <= oldLength; gap++) { // 문자 간의 간격 (1 이상)
                if (canFormWithGap(oldSignboard, storeName, start, gap)) {
                    return true; // 가능한 경우가 하나라도 있으면 true 반환
                }
            }
        }
        return false; // 어느 경우도 만족하지 않으면 false 반환
    }
    
    // 특정 시작점과 간격으로 가게 이름을 만들 수 있는지 검사
    private static boolean canFormWithGap(String oldSignboard, String storeName, int start, int gap) {
        int index = start;
        for (int i = 0; i < storeName.length(); i++) {
            // 간판의 끝을 벗어나면 실패
            if (index >= oldSignboard.length()) {
                return false;
            }
            // 현재 위치의 문자가 원하는 문자가 아니면 실패
            if (oldSignboard.charAt(index) != storeName.charAt(i)) {
                return false;
            }
            // 다음 문자는 일정한 간격만큼 떨어진 위치에서 검사
            index += gap;
        }
        return true; // 모든 문자가 일치하면 성공
    }
}
