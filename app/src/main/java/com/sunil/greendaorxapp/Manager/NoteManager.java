package com.sunil.greendaorxapp.Manager;

import android.content.Context;

import com.sunil.greendaorxapp.MainApplication;
import com.sunil.greendaorxapp.daogen.DaoSession;
import com.sunil.greendaorxapp.daogen.Note;
import com.sunil.greendaorxapp.daogen.NoteDao;

import java.util.List;

/**
 * Created by sunil on 11-Oct-16.
 */

public class NoteManager {

    public static Note load(Context ctx, long id) {
        return getNoteDao(ctx).load(id);
    }

    public static Note loadByRowId(Context ctx, long rowId) {
        return getNoteDao(ctx).loadByRowId(rowId);
    }

    public static List<Note> loadAll(Context ctx) {
        return getNoteDao(ctx).loadAll();
    }


    public static long count(Context ctx) {
        return getNoteDao(ctx).count();
    }


    public static long insertOrReplace(Context ctx, Note note) {
        return getNoteDao(ctx).insertOrReplace(note);
    }

    public static void remove(Context ctx, Note note) {
        getNoteDao(ctx).delete(note);
    }

    private static NoteDao getNoteDao(Context c) {
        // get the note DAO
        DaoSession daoSession = ((MainApplication) MainApplication.getAppContext()).getDaoSession();
        NoteDao noteDao = daoSession.getNoteDao();
        return noteDao ;
    }


}
