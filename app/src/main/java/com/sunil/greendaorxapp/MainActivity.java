package com.sunil.greendaorxapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.sunil.greendaorxapp.Manager.NoteManager;
import com.sunil.greendaorxapp.adapter.NoteAdapter;
import com.sunil.greendaorxapp.daogen.Note;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    private static String TAG = MainActivity.class.getSimpleName();

    @BindView(R.id.no_data)
    TextView no_data_tv;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.button_create)
    Button btn_create;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    @Override
    protected void onResume() {
        super.onResume();

        List<Note> list = NoteManager.loadAll(this);
        if (list== null && list.size()==0){
            no_data_tv.setVisibility(View.VISIBLE);
            recyclerView.setVisibility(View.GONE);
        }else{
            no_data_tv.setVisibility(View.GONE);
            recyclerView.setVisibility(View.VISIBLE);
            NoteAdapter adapter = new NoteAdapter(this, list);
            recyclerView.setAdapter(adapter);

        }
    }

    @OnClick(R.id.button_create)
    public void createNoteClick(){
        startActivity(new Intent(MainActivity.this, NoteDetailActivity.class));
    }
}
