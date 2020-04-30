package psa.cesa.gui;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Holder> {

    private Context context;
    private ArrayList<Row> rows;

    public Adapter(Context context, ArrayList<Row> rows) {
        this.context = context;
        this.rows = rows;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row, null);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final Holder holder, int position) {
        holder.imageView.setImageResource(rows.get(position).getImage());
        holder.title.setText(rows.get(position).getTitle());
        holder.description.setText(rows.get(position).getDescription());

        holder.setRowClickListener(new RowClickListener() {
            @Override
            public void onRowClickListener(View view, int position) {

                String title = rows.get(position).getTitle();
                String description = rows.get(position).getDescription();
                BitmapDrawable bitmapDrawable = (BitmapDrawable) holder.imageView.getDrawable();

                Bitmap bitmap = bitmapDrawable.getBitmap();

                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

                bitmap.compress(Bitmap.CompressFormat.PNG, 100, outputStream);

                byte[] bytes = outputStream.toByteArray();

                Intent intent = new Intent(context, HeliostatActivity.class);

                intent.putExtra("title", title);
                intent.putExtra("description", description);
                intent.putExtra("image", bytes);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return rows.size();
    }
}
