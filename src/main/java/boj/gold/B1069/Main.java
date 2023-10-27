package boj.gold.B1069;

public class Main {
    public static void main(String[] args) throws Exception {
        int x = read();
        int y = read();
        int d = read();
        int t = read();
        double time,v = Math.sqrt((x * x) + (y * y));
        if(d<=t) {
            time = v;
        } else {
            double tempMin, tempV = v;
            double tempTime = 0.0;
            int jumpCount = 0;
            while(tempV >= d) {
                tempV -= d;
                tempTime += t;
                jumpCount++;
            }
            tempMin = tempTime + tempV;
            tempV -= d;
            tempTime += t;
            tempMin = Math.min(tempMin, tempTime - tempV);
            if(jumpCount == 0) jumpCount++;
            time = Math.min(tempMin, (jumpCount+1) * t);
        }
        System.out.println(time);
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}

