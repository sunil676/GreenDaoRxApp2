package com.sunil.greendaorxapp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sunil.greendaorxapp.R;
import com.sunil.greendaorxapp.daogen.Note;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by sunil on 11-Oct-16.
 */

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.NoteViewHolder> {

    private List<Note> noteList;
    private Context context;

    public NoteAdapter(Context contactList, List<Note> notes) {
        this.noteList = notes;
        this.context = context;
    }

    @Override
    public int getItemCount() {
        return noteList.size();
    }

    @Override
    public void onBindViewHolder(NoteViewHolder noteViewHolder, int i) {
        Note note = noteList.get(i);
        noteViewHolder.title.setText(note.getText());
        noteViewHolder.description.setText(note.getComment());
        noteViewHolder.date.setText(note.getDate()+"");
    }

    @Override
    public NoteViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_note, viewGroup, false);
        return new NoteViewHolder(itemView);
    }

    public static class NoteViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.title)
        TextView title;
        @BindView(R.id.description)
        TextView description;
        @BindView(R.id.date)
        TextView date;


        public NoteViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}