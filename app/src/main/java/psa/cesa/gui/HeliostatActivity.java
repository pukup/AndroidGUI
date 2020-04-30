package psa.cesa.gui;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class HeliostatActivity extends AppCompatActivity {

    private TextView titleTextView, descriptionTextView;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_heliostat);

        titleTextView = findViewById(R.id.hTitle);
        descriptionTextView = findViewById(R.id.hDescription);
        imageView = findViewById(R.id.hImage);

        ActionBar actionBar = getSupportActionBar();

        Intent intent = getIntent();

        String title = intent.getStringExtra("title");
        String description = intent.getStringExtra("description");
        byte[] bytes = intent.getByteArrayExtra("image");

        Bitmap bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);

        actionBar.setTitle(title);

        titleTextView.setText(title);
        descriptionTextView.setText(description);
        imageView.setImageBitmap(bitmap);

    }
}
