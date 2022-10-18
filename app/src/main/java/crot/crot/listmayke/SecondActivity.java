package crot.crot.listmayke;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    protected Bundle bundle;
    protected TextView textView1;
    protected TextView textView2;
    protected TextView textView3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.secrot);
        textView1 = findViewById(R.id.textView);
        textView2 = findViewById(R.id.textView3);

        String namamatkul = "Matkul not set";
        String kumpulkan = "kumpul not set";

        Bundle extras = getIntent().getExtras();
        if (extras!= null){
            namamatkul = extras.getString("namamatkul");
            kumpulkan = extras.getString("dikumpul");
        }

        textView1.setText(namamatkul);
        textView2.setText(kumpulkan);




    }
}
