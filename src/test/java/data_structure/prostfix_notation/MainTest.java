package data_structure.prostfix_notation;

import org.junit.jupiter.api.Test;

import static data_structure.postfix_notation.Main.*;
import static org.assertj.core.api.Assertions.*;

public class MainTest {

    @Test
    void mainTest1() {
        String target = "A*(B+C)";
        String added = addBracketsAtOperator(target,high);
        String result = addBracketsAtOperator(added,low);
        String totalResult = convertPostfixNotation(result);
        assertThat(totalResult).isEqualTo("ABC+*");
    }

    @Test
    void mainTest2() {
        String target = "A+B";
        String added = addBracketsAtOperator(target,high);
        String result = addBracketsAtOperator(added,low);
        String totalResult = convertPostfixNotation(result);
        assertThat(totalResult).isEqualTo("AB+");
    }


    @Test
    void mainTest3() {
        String target = "A*(B+C)";
        String added = addBracketsAtOperator(target,high);
        String result = addBracketsAtOperator(added,low);
        String totalResult = convertPostfixNotation(result);
        assertThat(totalResult).isEqualTo("ABC+*");
    }


    @Test
    void mainTest4() {
        String target = "A+B*C";
        String added = addBracketsAtOperator(target,high);
        String result = addBracketsAtOperator(added,low);
        String totalResult = convertPostfixNotation(result);
        assertThat(totalResult).isEqualTo("ABC*+");
    }


    @Test
    void mainTest5() {
        String target = "A+B*C-D/E";
        String added = addBracketsAtOperator(target,high);
        String result = addBracketsAtOperator(added,low);
        String totalResult = convertPostfixNotation(result);
        assertThat(totalResult).isEqualTo("ABC*+DE/-");
    }

    @Test
    void mainTest6() {
        String target = "A*(B+C)/D";
        String added = addBracketsAtOperator(target,high);
        String result = addBracketsAtOperator(added,low);
        String totalResult = convertPostfixNotation(result);
        assertThat(totalResult).isEqualTo("ABC+*D/");
    }

    @Test
    void mainTest7() {
        String target = "A+(B-C)/D";
        String added = addBracketsAtOperator(target,high);
        String result = addBracketsAtOperator(added,low);
        String totalResult = convertPostfixNotation(result);
        assertThat(totalResult).isEqualTo("ABC-D/+");
    }

    @Test
    void mainTest8() {
        String target = "A+B*C+D";
        String added = addBracketsAtOperator(target,high);
        String result = addBracketsAtOperator(added,low);
        String totalResult = convertPostfixNotation(result);
        assertThat(totalResult).isEqualTo("ABC*+D+");
    }

    @Test
    void mainTest9() {
        String target = "G*(A-B*(C/D+E)/F)";
        String added = addBracketsAtOperator(target,high);
        String result = addBracketsAtOperator(added,low);
        String totalResult = convertPostfixNotation(result);
        assertThat(totalResult).isEqualTo("GABCD/E+*F/-*");
    }

    @Test
    void mainTest10() {
        String target = "A+B+C*D-E*F";
        String added = addBracketsAtOperator(target,high);
        String result = addBracketsAtOperator(added,low);
        String totalResult = convertPostfixNotation(result);
        assertThat(totalResult).isEqualTo("AB+CD*+EF*-");
    }

    @Test
    void mainTest11() {
        String target = "A*B-C*D/E";
        String added = addBracketsAtOperator(target,high);
        String result = addBracketsAtOperator(added,low);
        String totalResult = convertPostfixNotation(result);
        assertThat(totalResult).isEqualTo("AB*CD*E/-");
    }

    @Test
    void t1() {
        String target = "A*B+C";
        String added = addBracketsAtOperator(target,high);
        assertThat(added).isEqualTo("(A*B)+C");
        String result = addBracketsAtOperator(added,low);
        assertThat(result).isEqualTo("((A*B)+C)");
    }

    @Test
    void t2() {
        String target = "A+B*C-D/E";
        String added = addBracketsAtOperator(target,high);
        assertThat(added).isEqualTo("A+(B*C)-(D/E)");
        String result = addBracketsAtOperator(added,low);
        assertThat(result).isEqualTo("((A+(B*C))-(D/E))");
    }

    @Test
    void t3() {
        String addResult = "((A+(B*C))-(D/E))";
        String result = convertPostfixNotation(addResult);
        assertThat(result).isEqualTo("ABC*+DE/-");
    }

    @Test
    void findFirstCloseIndexTest() {
        StringBuilder sb = new StringBuilder("(a+b-c)*(d*(e+f)+g)+h");
        int i1 = findCloseIndex(sb, 7);
        assertThat(i1).isEqualTo(18);
    }

    @Test
    void findFirstOpenBracketTest() {
        StringBuilder sb = new StringBuilder("z+(a+b-c)*(d*(e+f)+g)+h");
        int i1 = findOpenIndex(sb, 9);
        assertThat(i1).isEqualTo(2);
    }

    @Test
    void sbTest() {
        StringBuilder sb = new StringBuilder("abc)de)fg");
        sb.insert(0,'A');
        assertThat(sb.toString()).isEqualTo("Aabc)de)fg");
        sb.insert(6,')');
        assertThat(sb.toString()).isEqualTo("Aabc)d)e)fg");
    }

    @Test
    void sbTest2() {
        StringBuilder sb = new StringBuilder("((A+(B*C))-(D/E))");
        sb.deleteCharAt(3);
        sb.insert(8,"+");
    }
}