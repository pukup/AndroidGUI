package psa.cesa.gui.view;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import psa.cesa.gui.R;

public class ComLineHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    ImageView imageView;
    TextView title, description;
    RowClickListener rowClickListener;

    public ComLineHolder(@NonNull View itemView) {
        super(itemView);
        this.imageView = itemView.findViewById(R.id.c_image);
        this.title = itemView.findViewById(R.id.c_title);
        this.description = itemView.findViewById(R.id.c_description);

        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        this.rowClickListener.onRowClickListener(view, getLayoutPosition());
    }

    public void setRowClickListener(RowClickListener rowClickListener) {
        this.rowClickListener = rowClickListener;
    }
}
