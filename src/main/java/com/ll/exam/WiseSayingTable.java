package com.ll.exam;

public class WiseSayingTable {
    private String baseDir;

    public WiseSayingTable(String baseDir) {
        this.baseDir = baseDir;
    }

    public void save(WiseSaying wiseSaying) {
        Util.mkdir("%s/wise_saying".formatted(baseDir));
        String body = wiseSaying.toString();
        Util.saveToFile("%s/wise_saying/list.json".formatted(baseDir), body);
    }

    public void save(String content, String author) {
        int id = getLastId() + 1;

        WiseSaying wiseSaying = new WiseSaying(id, content, author);
        save(wiseSaying);

        saveLastId(id);
    }

    private void saveLastId(int id) {
        Util.saveToFile("%s/wise_saying/last_id.txt".formatted(baseDir), id + "");
    }

    private int getLastId() {
        String lastId = Util.readFromFile("%s/wise_saying/last_id.txt".formatted(baseDir));

        if (lastId.isEmpty()) {
            return 0;
        }

        return Integer.parseInt(lastId);
    }
}
