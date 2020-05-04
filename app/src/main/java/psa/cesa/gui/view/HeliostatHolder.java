package psa.cesa.gui.view;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import psa.cesa.gui.R;

class HeliostatHolder extends RecyclerView.ViewHolder {

    ImageView imageViewAz, imageViewEl0, imageViewEl1;
    TextView textTitle, textViewAzEl, description;

    public HeliostatHolder(@NonNull View itemView) {
        super(itemView);

        this.imageViewAz = itemView.findViewById(R.id.h_image_az);
        this.imageViewEl0 = itemView.findViewById(R.id.h_image_el_0);
        this.imageViewEl1 = itemView.findViewById(R.id.h_image_el_1);
        this.textTitle = itemView.findViewById(R.id.h_title);
        this.textViewAzEl = itemView.findViewById(R.id.h_text_az_el);
        this.description = itemView.findViewById(R.id.h_text_description);
    }
}
