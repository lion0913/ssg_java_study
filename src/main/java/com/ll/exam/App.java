package com.ll.exam;

import java.util.Scanner;

public class App {
    public void run() {
        System.out.println("== 명언 SSG ==");

        //키보드 입력
        Scanner sc = new Scanner(System.in);

        outer:while(true) {
            System.out.print("명령) ");
            //입력받음+공백제거
            String cmd = sc.nextLine().trim();

            switch(cmd)  {
                //종료 입력시 outer(while문 자체를) 종료
                case "종료":
                    break outer;
            }
        }

        sc.close();
    }
}
