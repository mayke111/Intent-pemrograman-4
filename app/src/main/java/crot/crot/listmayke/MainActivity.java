package crot.crot.listmayke;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Data> userslist;
    private RecyclerView recyclerView;
    protected Button button;
    protected Adapter.RecyclerViewClickListener listener;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.rcyleview);
        userslist = new ArrayList<>();
        setUserInfo();
        setAdapter();
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), SecondActivity.class);
                i.putExtra("1", "kntl");
                i.putExtra("2", "kntl");
                startActivity(i);
            }
        });

    }

    private void setAdapter(){
        setOnClickListener();
        Adapter adapter = new Adapter(userslist, listener);
        RecyclerView.LayoutManager LayoutManager = new LinearLayoutManager((getApplicationContext()));
        recyclerView.setLayoutManager(LayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

    }

    private void setUserInfo(){
        userslist.add(new Data("PEMROG 2", "2022-10-20"));
        userslist.add(new Data("RPL", "2022-10-20"));
        userslist.add(new Data("DATABASE", "2022-10-20"));
        userslist.add(new Data("MTK", "2022-10-20"));
        userslist.add(new Data("GIS", "2022-10-20"));
        userslist.add(new Data("JARKOM", "2022-10-20"));
        userslist.add(new Data("KSI", "2022-10-20"));
        userslist.add(new Data("PROJEK3", "2022-10-20"));


    }

    private void setOnClickListener(){
        listener = new Adapter.RecyclerViewClickListener() {
            @Override
            public void onClick(View v, int position) {
                Intent intent = new Intent(getApplicationContext(),SecondActivity.class);
                intent.putExtra("namamatkul", userslist.get(position).getNamamatkul());
                intent.putExtra("dikumpul", userslist.get(position).getDikumpul());
                startActivity(intent);
            }
        };
    }
}