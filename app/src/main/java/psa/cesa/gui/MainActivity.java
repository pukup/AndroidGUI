package psa.cesa.gui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ComLineAdapter comLineAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.comLineRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        comLineAdapter = new ComLineAdapter(this, getList());
        recyclerView.setAdapter(comLineAdapter);
    }

    private ArrayList getList() {
        ArrayList<ComLine> ComLines = new ArrayList<>();

        ComLine comLine = new ComLine();
        comLine.setImage(R.drawable.heliostat);
        comLine.setTitle("01");
        comLine.setDescription("Heliostatos en opecarión");
        ComLines.add(comLine);

        ComLine comLine2 = new ComLine();
        comLine2.setImage(R.drawable.heliostat);
        comLine2.setTitle("02");
        comLine2.setDescription("Heliostatos en abatimiento");
        ComLines.add(comLine2);

        return ComLines;
    }
}
