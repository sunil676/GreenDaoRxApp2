package com.sunil.greendaorxapp;

import android.icu.util.Calendar;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;

import com.sunil.greendaorxapp.Manager.NoteManager;
import com.sunil.greendaorxapp.daogen.Note;
import com.sunil.greendaorxapp.util.Utility;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by sunil on 11-Oct-16.
 */

public class NoteDetailActivity extends AppCompatActivity {

    private static String TAG = NoteDetailActivity.class.getSimpleName();

    @BindView(R.id.titleLayout)
    TextInputLayout titleLabelLayout;
    @BindView(R.id.descriptionLayout)
    TextInputLayout descriptionLabelLayout;
    @BindView(R.id.dateLayout)
    TextInputLayout dateLabelLayout;

    @BindView(R.id.title)
    EditText titleEditText;
    @BindView(R.id.description)
    EditText descriptionEditText;
    @BindView(R.id.age)
    EditText ageEditText;

    @BindView(R.id.save)
    Button save;

    private boolean isCreate;
    private Long noteId;
    Note mNote;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_detail);
        ButterKnife.bind(this);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            isCreate = bundle.getBoolean("Create");
            noteId = bundle.getLong("NoteID");
        }
        if (!isCreate) {
            save.setText("Save");
            mNote = NoteManager.load(this, noteId);
            if (mNote != null) {
                titleEditText.setText(mNote.getText());
                descriptionEditText.setText(mNote.getComment());
                ageEditText.setText(mNote.getDate() + "");
            }
        } else {
            save.setText("Add");
            Calendar c = Calendar.getInstance();
            System.out.println("Current time => " + c.getTime());
            ageEditText.setText(c.getTime()+"");
        }
    }

    @OnClick(R.id.save)
    public void saveClick(){
        if (isCreate){
            // insert note
            if (!valid()){
                return;
            }else{
                Note note = new Note();
                note.setText(titleEditText.getText().toString());
                note.setComment(descriptionEditText.getText().toString());
                note.setText(ageEditText.getText().toString());
                NoteManager.insertOrReplace(this, note);
                finish();
            }

        }else{
            // update note
            if (!valid()){
                return;
            }else{
                mNote.setText(titleEditText.getText().toString());
                mNote.setComment(descriptionEditText.getText().toString());
                mNote.setText(ageEditText.getText().toString());
                NoteManager.insertOrReplace(this, mNote);
            }
        }
    }

    private boolean valid(){
        boolean isValid;
        if (!Utility.nullCheck(titleLabelLayout, "Title")){
            isValid = false;
        }
        else if (!Utility.nullCheck(descriptionLabelLayout, "Comment")){
            isValid = false;
        }
        else if (!Utility.nullCheck(dateLabelLayout, "Date")){
            isValid = false;
        }else{
            isValid = true;
        }
        return  isValid;
    }
}
