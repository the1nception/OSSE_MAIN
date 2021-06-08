package de.hfu;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class UtilTest {

    private Util util;

    @Before
    public void erzeugeUtil () {
        this.util = new Util();
    }

    @Test(expected=IllegalArgumentException.class, timeout=1000)
    public void testIstErstesHalbjahrExceptionMax() {
        Util.istErstesHalbjahr(13);
    }

    @Test(expected=IllegalArgumentException.class, timeout=1000)
    public void testIstErstesHalbjahrExceptionMin() {
        Util.istErstesHalbjahr(0);
    }

    @Test
    public void testIstErstesHalbjahrMax () {
        boolean vergleich = true;
        assertEquals(Util.istErstesHalbjahr(6), vergleich);
    }

    @Test
    public void testIstErstesHalbjahrMin () {
        boolean vergleich = true;
        assertEquals(Util.istErstesHalbjahr(1), vergleich);
    }

    @Test
    public void testIstErstesHalbjahrOut () {
        boolean vergleich = false;
        assertEquals(Util.istErstesHalbjahr(7), vergleich);
    }

    @Test
    public void testIstErstesHalbjahrOutMax () {
        boolean vergleich = false;
        assertEquals(Util.istErstesHalbjahr(12), vergleich);
    }
}


