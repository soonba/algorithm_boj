package brute_force.remote_controll;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class MainTest {

    @Test
    void test1() {
        Sol sol = new Sol();
        Integer sol1 = sol.sol(9999, new ArrayList<>(List.of(0, 1, 2, 3, 4, 5, 6, 7, 8)));
        System.out.println(sol1);
        assertThat(sol1).isEqualTo(10000);
    }

    @Test
    void test2() {
        Sol sol = new Sol();
        Integer sol1 = sol.sol(5457, new ArrayList<>(List.of(0, 1, 2, 3, 4, 5, 9)));
        System.out.println(sol1);
        assertThat(sol1).isEqualTo(5459);
    }

    @Test
    void test3() {
        Sol sol = new Sol();
        Integer sol1 = sol.sol(500000, new ArrayList<>(List.of(1, 5)));
        System.out.println(sol1);
        assertThat(sol1).isEqualTo(511111);
    }

    @Test
    void test4() {
        Sol sol = new Sol();
        Integer sol1 = sol.sol(100, new ArrayList<>(List.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)));
        System.out.println(sol1);
        assertThat(sol1).isEqualTo(100);
    }

    @Test
    void test5() {
        Sol sol = new Sol();
        Integer sol1 = sol.sol(80000, new ArrayList<>(List.of(0, 1, 2, 3, 4, 5, 6, 7)));
        System.out.println(sol1);
        assertThat(sol1).isEqualTo(77777);
    }

    @Test
    void test6() {
        Sol sol = new Sol();
        Integer sol1 = sol.sol(40, new ArrayList<>(List.of(0)));
        System.out.println(sol1);
        assertThat(sol1).isEqualTo(0);
    }

    @Test
    void test7() {
        Sol sol = new Sol();
        Integer sol1 = sol.sol(80, new ArrayList<>(List.of(0)));
        System.out.println(sol1);
        assertThat(sol1).isEqualTo(100);
    }

    @Test
    void test8() {
        Sol sol = new Sol();
        Integer sol1 = sol.sol(1, new ArrayList<>(List.of(0)));
        System.out.println(sol1);
        assertThat(sol1).isEqualTo(0);
    }

    @Test
    void test9() {
        Sol sol = new Sol();
        Integer sol1 = sol.sol(6789, new ArrayList<>(List.of(1, 8, 0)));
        System.out.println(sol1);
        assertThat(sol1).isEqualTo(8000);
    }

    @Test
    void test10() {
        Sol sol = new Sol();
        Integer sol1 = sol.sol(499999, new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9)));
        System.out.println(sol1);
        assertThat(sol1).isEqualTo(499999);
    }

    @Test
    void test11() {
        Sol sol = new Sol();
        Integer sol1 = sol.sol(0, new ArrayList<>(List.of(1)));
        System.out.println(sol1);
        assertThat(sol1).isEqualTo(1);
    }

    @Test
    void test12() {
        Sol sol = new Sol();
        Integer sol1 = sol.sol(1, new ArrayList<>(List.of(3)));
        System.out.println(sol1);
        assertThat(sol1).isEqualTo(3);
    }

    @Test
    void test13() {
        Sol sol = new Sol();
        Integer sol1 = sol.sol(98, new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7, 8)));
        System.out.println(sol1);
        assertThat(sol1).isEqualTo(100);
    }

    @Test
    void test14() {
        Sol sol = new Sol();
        Integer sol1 = sol.sol(2345, new ArrayList<>(Collections.emptyList()));
        System.out.println(sol1);
        assertThat(sol1).isEqualTo(100);
    }

    @Test
    void test15() {
        Sol sol = new Sol();
        Integer sol1 = sol.sol(10, new ArrayList<>(List.of(9)));
        System.out.println(sol1);
        assertThat(sol1).isEqualTo(9);
    }

    @Test
    void test16() {
        Sol sol = new Sol();
        Integer sol1 = sol.sol(103, new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 0)));
        System.out.println(sol1);
        assertThat(sol1).isEqualTo(103);
    }
}

// 자릿수까지 더하면 더 많이 눌러야 하는 경우
// 1000 을 누르기 위해 999 와 1001은 동치 이지만 1001은 한자리 더 누르게 됨