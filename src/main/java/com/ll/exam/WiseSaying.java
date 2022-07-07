package com.ll.exam;

public class WiseSaying {
    String author;
    String word;
    int id;

    public WiseSaying(int id, String author, String word) {
        this.author = author;
        this.word = word;
        this.id = id;
        System.out.println("명언: " + word);
        System.out.println("작가: " + author);
    }

    @Override
    public String toString() {
        return "WiseSaying{" +
                "author='" + author + '\'' +
                ", word='" + word + '\'' +
                ", id=" + id +
                '}';
    }
}
