package com.ll.exam;

import org.junit.Test;

import java.io.File;

import static org.junit.Assert.assertTrue;

public class WiseSayingTest {
    @Test
    public void saveWiseSayingTest() {
        WiseSayingTable wiseSayingTable = new WiseSayingTable("test_data");
        wiseSayingTable.save("나에게 불가능이란 없다.", "나폴레옹");
        assertTrue(new File("test_data/wise_saying/list.json").exists());

        wiseSayingTable.save("나의 죽음을 적들에게 알리지 마라.", "이순신");
        assertTrue(new File("test_data/wise_saying/list.json").exists());
    }

}
