import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class reverseTest {

    @Test
    void reverse1() {
        assertEquals(reverse.reverse(""), "");
    }
    @Test
    void reverse2() {
        assertEquals(reverse.reverse("a"), "a");
    }
    @Test
    void reverse3() {
        assertEquals(reverse.reverse("ab"), "ba");
    }
    @Test
    void reverse4() {
        assertEquals(reverse.reverse("abc"), "cba");
    }
    @Test
    void reverse5() {
        assertEquals(reverse.reverse("leohortetrohoel"), "leohortetrohoel");
    }
    @Test
    void reverse6() {
        assertEquals(reverse.reverse(" "), " ");
    }
    @Test
    void reverse7() {
        assertEquals(reverse.reverse("a "), " a");
    }
}