package psa.cesa.gui;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Holder extends RecyclerView.ViewHolder implements View.OnClickListener {

    ImageView imageView;
    TextView title, description;
    RowClickListener rowClickListener;

    public Holder(@NonNull View itemView) {
        super(itemView);
        this.imageView = itemView.findViewById(R.id.rowImage);
        this.title = itemView.findViewById(R.id.rowTitle);
        this.description = itemView.findViewById(R.id.rowDescription);

        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        this.rowClickListener.onRowClickListener(view, getLayoutPosition());
    }

    public void setRowClickListener(RowClickListener rowClickListener){
        this.rowClickListener = rowClickListener;
    }
}
