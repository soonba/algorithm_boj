package string.nums;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println(nums("12223"));
        System.out.println(nums("111999333"));
        System.out.println(nums("123"));
        System.out.println(nums("1302010003231"));
        System.out.println(nums("1"));
        System.out.println(nums("0"));
    }

    static int nums(String str) {
        int result = -1;
        String[] split = str.split("");
        for (int i = 0; i < split.length - 2; i++) {
            if(split[i].equals(split[i+1]) && split[i+1].equals(split[i+2])) {
                result = Math.max(result, Integer.parseInt(split[i].repeat(3)));
            }
        }
        return result;
    }

}
