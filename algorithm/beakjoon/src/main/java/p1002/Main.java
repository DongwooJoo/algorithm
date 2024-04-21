package p1002;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String firstLine = br.readLine();
        int numberOfCases = Integer.parseInt(firstLine);
        int i;
        ArrayList<Integer> result = new ArrayList<>();

        for (i = 0; i < numberOfCases; i++) {
            String[] s = br.readLine().split(" ");

            int x1 = Integer.parseInt(s[0]);
            int y1 = Integer.parseInt(s[1]);
            int r1 = Integer.parseInt(s[2]);
            int x2 = Integer.parseInt(s[3]);
            int y2 = Integer.parseInt(s[4]);
            int r2 = Integer.parseInt(s[5]);

            int dx = x2 - x1;
            int dy = y2 - y1;
            int sr = r1 + r2;
            double d = Math.sqrt(dx * dx + dy * dy);

            if (d < sr) { // 1. 두 원의 중심 사이의 거리 < 반지름의 합
                if (d == 0) { // 1-1. 두 원의 중심이 같은 경우
                    if (r1 == r2) { // 1-1-1. 두 원의 중심이 같고, 반지름이 같은 경우 -> 중심이 같아, 같은 원이다. 위치의 개수가 무한대이다.
                        result.add(-1);
                    } else { // 1-1-2. 두 원의 중심이 같고, 반지름이 같지 않은 경우 -> 중심이 같지만, 포함 관계에 있어 두 원은 서로 만나지 않는다.
                        result.add(0);
                    }
                } else if (d + r1 == r2 || d + r2 == r1) { // 1-2. 두 원의 중심이 다르고, 반지름과 두 원의 중심 사이의 거리를 더했을 때, 다른 원의 반지름이 되는 경우 -> 두 원은 한 점에서 만난다.
                    result.add(1); //
                } else { // 1-3. 두 원의 중심 사이의 거리가 반지름의 합보다 작은 경우의 나머지 케이스
                    if (d + r1 < r2 || d + r2 < r1) { // 1-3-1. 거리와 한 원의 반지름이 다른 원의 반지름보다 작다면, 만나지 않는 포함관계이다.
                        result.add(0);
                    } else { // 나머지 모든 케이스 -> 두 원은 두 점에서 만난다.
                        result.add(2);
                    }
                }
            } else if (d == sr) { // 2. 두 원의 중심 사이의 거리 == 반지름의 합 -> 두 원은 한 점에서 만난다.
                result.add(1);
            } else { // 3. 두 원의 중심 사이의 거리 > 반지름의 합 -> 두 원은 만나지 않는다.
                result.add(0);
            }
        }

        for (Integer r : result) {
            System.out.println(r);
        }
    }
}