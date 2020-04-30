package psa.cesa.gui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new Adapter(this, getList());
        recyclerView.setAdapter(adapter);
    }

    private ArrayList getList() {
        ArrayList<Row> rows = new ArrayList<>();
        Row row = new Row();
        row.setImage(R.drawable.heliostat);
        row.setTitle("01");
        row.setDescription("Heliostatos en opecarión");
        rows.add(row);

        return rows;
    }
}
