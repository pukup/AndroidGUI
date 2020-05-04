package psa.cesa.gui.controller;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import psa.cesa.gui.R;
import psa.cesa.gui.model.ComLine;
import psa.cesa.gui.view.HeliostatAdapter;

public class HeliostatActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private HeliostatAdapter heliostatAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondary);

        recyclerView = findViewById(R.id.heliostatRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Intent intent = getIntent();
        ComLine comLine = (ComLine) intent.getSerializableExtra("comLine");

        heliostatAdapter = new HeliostatAdapter(this, comLine.getHeliostats());
        recyclerView.setAdapter(heliostatAdapter);

//        ActionBar actionBar = getSupportActionBar();
//        String title = intent.getStringExtra("title");
//        actionBar.setTitle(title);


//        String description = intent.getStringExtra("description");
//        byte[] bytes = intent.getByteArrayExtra("image");
//        Bitmap bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);

    }

    private void refresh() {

    }
}
