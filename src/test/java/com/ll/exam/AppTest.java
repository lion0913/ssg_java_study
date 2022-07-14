package com.ll.exam;

//import org.junit.Test;

import org.junit.Test;
//import org.junit.jupiter.api.Test;Test

import java.io.*;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertEquals;

public class AppTest {
    @Test
    public void assertTest() {
        int rs = 10 + 20;
        assertEquals(30, rs);
    }


    @Test
    public void scannerTest() {
        String input = """
                등록
                명언1
                작가1
                """.stripIndent();
        InputStream in = new ByteArrayInputStream(input.getBytes());
        Scanner sc = new Scanner(in);

        String cmd = sc.nextLine().trim();
        String content = sc.nextLine().trim();
        String author = sc.nextLine().trim();

        assertEquals("등록", cmd);
        assertEquals("명언1", content);
        assertEquals("작가1", author);
    }

    @Test
    public void displayTest() throws IOException {
        // 표준출력을 리다이렉션
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        System.out.println("안녕");

        String rs = output.toString().trim();

        // 표준출력을 원상복구
        System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
        output.close();

        assertEquals("안녕", rs);
    }

    @Test
    public void getIntParam2() {
        Request rq = new Request("검색?id=10&no=1");

        int id = rq.getIntParam("id", 0);
        int no = rq.getIntParam("no", 0);

        assertEquals(10, id);
        assertEquals(1, no);
    }
//    @Test
//    public void makeFileTest() {
//        Util.file.mkdir("test_data");
//        Util.file.saveToFile("test_data/1.txt", "안녕");
//        String body = Util.file.readFromFile("test_data/1.txt");
//
//        assertEquals("안녕", body);
//    }

    @Test
    void saveJsonFileTest() {
        Util.mkdir("test_data");
        WiseSaying wiseSaying = new WiseSaying(1, "내 사전에 불가능은 없다.", "나폴레옹");
        Util.saveToFile("test_data/1.json", wiseSaying.toJSON());

        String rs = Util.readFromFile("test_data/1.json");

        assertEquals(wiseSaying.toJSON(), rs);
    }
}
