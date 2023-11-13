package hackerank.grid_search;

import java.util.List;

public class Result {

    /*
     * Complete the 'gridSearch' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. STRING_ARRAY G
     *  2. STRING_ARRAY P
     */

    public static String gridSearch(List<String> G, List<String> P) {
        int gRSize = G.size();
        int pRSize = P.size();
        int gCSize = G.get(0).length();
        int pCSize = P.get(0).length();
        for (int i = 0; i <= gRSize - pRSize; i++) {
            String nowG = G.get(i);
            for (int j = 0; j <= gCSize - pCSize; j++) {
                String firstP = P.get(0);
                int sp = j;
                int ep = j + pCSize;
                if (nowG.substring(sp, ep).equals(firstP)) {
                    boolean check = true;
                    for (int k = 1; k < pRSize; k++) {
                        String nextG = G.get(i + k);
                        if (!nextG.substring(sp, ep).equals(P.get(k))) {
                            check = false;
                            break;
                        }
                        ;
                    }
                    if (check) {
                        return "YES";
                    }
                }
            }
        }
        return "NO";

    }

}
