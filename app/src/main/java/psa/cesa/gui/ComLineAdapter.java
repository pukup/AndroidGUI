package psa.cesa.gui;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.HashMap;

public class ComLineAdapter extends RecyclerView.Adapter<ComLineHolder> {

    private Context context;
    private HashMap<Integer, ComLine> comLines;

    public ComLineAdapter(Context context, HashMap ComLines) {
        this.context = context;
        this.comLines = ComLines;
    }

    @NonNull
    @Override
    public ComLineHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.com_line, null);
        return new ComLineHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ComLineHolder comLineHolder, int position) {
        comLineHolder.imageView.setImageResource(R.drawable.heliostat);
        comLineHolder.title.setText(String.valueOf(comLines.get(position+1).getId()));
//        comLineHolder.description.setText(comLines.get(position).getDescription());

        comLineHolder.setRowClickListener(new RowClickListener() {
            @Override
            public void onRowClickListener(View view, int position) {

//                String title = comLines.get(position).getTitle();
//                String description = comLines.get(position).getDescription();
//                BitmapDrawable bitmapDrawable = (BitmapDrawable) comLineHolder.imageView.getDrawable();
//
//                Bitmap bitmap = bitmapDrawable.getBitmap();
//
//                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
//
//                bitmap.compress(Bitmap.CompressFormat.PNG, 100, outputStream);
//
//                byte[] bytes = outputStream.toByteArray();

                Intent intent = new Intent(context, HeliostatActivity.class);

//                intent.putExtra("title", title);
//                intent.putExtra("description", description);
//                intent.putExtra("image", bytes);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return comLines.size();
    }
}
