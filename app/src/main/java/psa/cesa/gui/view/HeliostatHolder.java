package psa.cesa.gui.view;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import psa.cesa.gui.R;

class HeliostatHolder extends RecyclerView.ViewHolder {

    ImageView imageViewAz, imageViewEl0, imageViewEl1;
    TextView textTitle, description, diagnosisAZ, diagnosisEL, textViewAz, textViewEl;

    public HeliostatHolder(@NonNull View itemView) {
        super(itemView);

        this.imageViewAz = itemView.findViewById(R.id.h_image_az);
        this.imageViewEl0 = itemView.findViewById(R.id.h_image_el_0);
        this.imageViewEl1 = itemView.findViewById(R.id.h_image_el_1);
        this.textTitle = itemView.findViewById(R.id.h_title);
        this.diagnosisAZ = itemView.findViewById(R.id.h_text_diagnosis_az);
        this.diagnosisEL = itemView.findViewById(R.id.h_text_diagnosis_el);
        this.textViewAz = itemView.findViewById(R.id.h_text_az);
        this.textViewEl = itemView.findViewById(R.id.h_text_el);
        this.description = itemView.findViewById(R.id.h_text_description);
    }
}
