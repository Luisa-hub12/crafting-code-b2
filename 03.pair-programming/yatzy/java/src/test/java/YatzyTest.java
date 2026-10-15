import org.junit.*;
import static org.junit.Assert.*;

public class YatzyTest {

    @Test
    public void chance_scores_sum_of_all_dice() {
        assertEquals(16, new Yatzy(3,3,4,5,1).chance());
    }

    @Test public void yatzy_scores_50() {
        int expected = 50;
        int actual = Yatzy.yatzy(4,4,4,4,4);
        assertEquals(expected, actual);
        assertEquals(50, Yatzy.yatzy(6,6,6,6,6));
        assertEquals(0, Yatzy.yatzy(6,6,6,6,3));
    }

    @Test public void test_1s() {
        assertEquals(1, new Yatzy(1,2,4,5,5).resultOfRoll(1));
        assertEquals(2, new Yatzy(4,1,1,5,5).resultOfRoll(1));
        assertEquals(0, new Yatzy(4,2,4,5,5).resultOfRoll(1));
    }

    @Test
    public void test_2s() {
        assertEquals(0, new Yatzy(4,4,4,5,5).resultOfRoll(2));
        assertEquals(2, new Yatzy(4,2,4,5,5).resultOfRoll(2));

    }

    @Test
    public void test_3s() {
        assertEquals(3, new Yatzy(3,4,4,5,5).resultOfRoll(3));
        assertEquals(6, new Yatzy(3,3,4,5,5).resultOfRoll(3));

    }

    @Test
    public void test_4s()
    {
        assertEquals(12, new Yatzy(4,4,4,5,5).resultOfRoll(4));
        assertEquals(8, new Yatzy(4,4,5,5,5).resultOfRoll(4));
        assertEquals(4, new Yatzy(4,5,5,5,5).resultOfRoll(4));
    }

    @Test
    public void test_5s() {
        assertEquals(10, new Yatzy(4,2,4,5,5).resultOfRoll(5));
        assertEquals(5, new Yatzy(4,2,4,4,5).resultOfRoll(5));
    }

    @Test
    public void test_6s() {
        assertEquals(0, new Yatzy(4,2,4,5,5).resultOfRoll(6));
        assertEquals(12, new Yatzy(4,6,4,5,6).resultOfRoll(6));
    }

    @Test
    public void one_pair() {
        assertEquals(6, new Yatzy(3,4,3,5,6).scorePair());
//        assertEquals(10, Yatzy.scorePair(5,3,3,3,5));
//        assertEquals(12, Yatzy.scorePair(5,3,6,6,5));
    }

    @Test
    public void two_Pair() {
        assertEquals(16, Yatzy.twoPair(3,3,5,4,5));
        assertEquals(16, Yatzy.twoPair(3,3,5,5,5));
    }

    @Test
    public void three_of_a_kind() 
    {
        assertEquals(9, Yatzy.threeOfAKind(3,3,3,4,5));
        assertEquals(15, Yatzy.threeOfAKind(5,3,5,4,5));
        assertEquals(9, Yatzy.threeOfAKind(3,3,3,3,5));
    }

    @Test
    public void fourOfAKind() {
        assertEquals(12, Yatzy.fourOfAKind(3,3,3,3,5));
        assertEquals(20, Yatzy.fourOfAKind(5,5,5,4,5));
        assertEquals(9, Yatzy.threeOfAKind(3,3,3,3,3));
    }

    @Test
    public void smallStraight() {
        assertEquals(15, Yatzy.smallStraight(1,2,3,4,5));
        assertEquals(15, Yatzy.smallStraight(2,3,4,5,1));
        assertEquals(0, Yatzy.smallStraight(1,2,2,4,5));
    }

    @Test
    public void largeStraight() {
        assertEquals(20, Yatzy.largeStraight(6,2,3,4,5));
        assertEquals(20, Yatzy.largeStraight(2,3,4,5,6));
        assertEquals(0, Yatzy.largeStraight(1,2,2,4,5));
    }

    @Test
    public void fullHouse() {
        assertEquals(18, Yatzy.fullHouse(6,2,2,2,6));
        assertEquals(0, Yatzy.fullHouse(2,3,4,5,6));
    }
}
