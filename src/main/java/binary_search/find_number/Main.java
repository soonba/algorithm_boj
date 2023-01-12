package binary_search.find_number;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        String s = br.readLine();
        String[] split = s.split(" ");
        List<Integer> codomain = Arrays.stream(split).map(Integer::parseInt).sorted().collect(Collectors.toList());



        int M = Integer.parseInt(br.readLine());
        String s1 = br.readLine();
        String[] split1 = s1.split(" ");
        List<Integer> domainList = Arrays.stream(split1).map(Integer::parseInt).collect(Collectors.toList());
        for (int i = 0; i < M; i++) {
            int min = 0;
            int max = codomain.size() - 1;
            Integer domain = domainList.get(i);
            boolean check = false;
            while (max - min > 1) {
                int mid = (min + max) / 2;
                if (codomain.get(mid).equals(domain)) {
                    check = true;
                    System.out.println("1");
                    break;
                } else if (codomain.get(mid) > domain) {
                    max = mid;
                } else {
                    min = mid;
                }
            }

            if(max - min == 1) {
                if(codomain.get(min).equals(domain)) {
                    System.out.println("1");
                    check = true;
                } else if(codomain.get(max).equals(domain)) {
                    System.out.println("1");
                    check = true;
                }
            } else if(min==max) {
                if(T == 1) {
                    if(codomain.get(0).equals(domain)) {
                        System.out.println("1");
                        check = true;
                    }
                } else {
                    if(codomain.get(min-1).equals(domain)) {
                        System.out.println("1");
                        check = true;
                    }
                }
            }

            if (!check) {
                System.out.println("0");
            }

        }
    }
}


