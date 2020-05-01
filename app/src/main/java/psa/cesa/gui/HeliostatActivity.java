package psa.cesa.gui;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;

import java.util.HashMap;

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

        heliostatAdapter = new HeliostatAdapter(this, getList());
        recyclerView.setAdapter(heliostatAdapter);

//        ActionBar actionBar = getSupportActionBar();
//        String title = intent.getStringExtra("title");
//        actionBar.setTitle(title);


        String description = intent.getStringExtra("description");
        byte[] bytes = intent.getByteArrayExtra("image");
        Bitmap bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);

    }

    private HashMap getList() {
        HashMap<Integer, Heliostat> heliostats = new HashMap<>();

        Heliostat heliostat = new Heliostat();
        heliostats.put(1, heliostat);

        Heliostat heliostat2 = new Heliostat();
        heliostats.put(2, heliostat2);

        return heliostats;
    }
}
