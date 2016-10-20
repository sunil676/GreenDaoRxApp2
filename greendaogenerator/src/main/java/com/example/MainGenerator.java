package com.example;

import org.greenrobot.greendao.generator.DaoGenerator;
import org.greenrobot.greendao.generator.Entity;
import org.greenrobot.greendao.generator.Schema;

public class MainGenerator {

    public static void main(String[] args) throws Exception {
        Schema schema = new Schema(3, "com.sunil.greendaorxapp.daogen");
        addNote(schema);
        new DaoGenerator().generateAll(schema, "../GreenDaoRxApp2/app/src/main/java/");
    }

    private static void addNote(Schema schema) {
        Entity note = schema.addEntity("Note");
        note.addIdProperty();
        note.addStringProperty("tittle").notNull();
        note.addStringProperty("comment");
        note.addStringProperty("noteDate");
    }
}
