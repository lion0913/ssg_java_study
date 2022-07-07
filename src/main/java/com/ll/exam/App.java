package com.ll.exam;

import netscape.javascript.JSObject;
import org.json.simple.JSONObject;

import java.util.*;


public class App {
    public void run() {
        int id = 0;
        HashMap<Integer, WiseSaying> wordList = new HashMap<>();
        System.out.println("== 명언 SSG ==");

        Scanner sc = new Scanner(System.in);


        outer:while(true) {
            System.out.print("명령) ");
            //입력받음+공백제거
            String cmd = sc.nextLine().trim();
            if(cmd.contains("종료")) {
                break outer;
            } else if(cmd.contains("등록")) {
                System.out.print("작가: ");
                String author = sc.nextLine().trim();
                System.out.print("명언: ");
                String word = sc.nextLine().trim();
                WiseSaying w = new WiseSaying(id, author, word);
                wordList.put(id++, w);
                System.out.println((id)+"번 명언이 등록되었습니다.");

            } else if(cmd.contains("목록")) {
                System.out.println("번호 / 작가 / 명언\n" + "--------------------------");
                for(WiseSaying element: wordList.values()){
                    System.out.println(element.id + " / " + element.author + " / " + element.word);
                }
            } else if(cmd.contains("삭제")) {
                int idx = Integer.parseInt(cmd.split("\\?id=")[1]);
                wordList.remove(idx);

            } else if(cmd.contains("수정")) {
                int idx = Integer.parseInt(cmd.split("\\?id=")[1]);
                System.out.print("수정할 내용 입력: ");
                String word = sc.nextLine();
                WiseSaying w = wordList.get(idx);
                w.word = word;
                wordList.put(idx, w);
                System.out.println(w);
            }
        }
        sc.close();

    }
}
