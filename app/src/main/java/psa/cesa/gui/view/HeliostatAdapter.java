package psa.cesa.gui.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.HashMap;

import psa.cesa.gui.R;
import psa.cesa.gui.model.Heliostat;

public class HeliostatAdapter extends RecyclerView.Adapter<HeliostatHolder> {

    private Context context;
    private HashMap<Integer, Heliostat> heliostats;

    public HeliostatAdapter(Context context, HashMap<Integer, Heliostat> heliostats) {
        this.context = context;
        this.heliostats = heliostats;
    }

    @NonNull
    @Override
    public HeliostatHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.heliostat, null);
        view.setLayoutParams(new RecyclerView.LayoutParams(
                RecyclerView.LayoutParams.MATCH_PARENT,
                RecyclerView.LayoutParams.WRAP_CONTENT
        ));
        return new HeliostatHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HeliostatHolder heliostatHolder, int position) {
        Heliostat heliostat = heliostats.get(position + 1);
        heliostatHolder.imageViewAz.setImageResource(R.drawable.image_az);
        heliostatHolder.imageViewEl0.setImageResource(R.drawable.image_el_0);
        heliostatHolder.imageViewEl1.setImageResource(R.drawable.image_el_1);
        if (heliostat != null) {
            heliostatHolder.textTitle.setText("" + String.valueOf(heliostat.getComLineId() + 1) + "-" + heliostat.getId());
            heliostatHolder.description.setText(heliostat.toString());
            heliostatHolder.imageViewEl1.setRotation(heliostat.getPositionEL());
            heliostatHolder.imageViewAz.setRotation(heliostat.getPositionAZ());
            heliostatHolder.diagnosisAZ.setText(heliostat.diagnosisAZToString());
            heliostatHolder.diagnosisEL.setText(heliostat.diagnosisELToString());
            heliostatHolder.textViewAz.setText("Acimut: " + heliostat.getPositionAZ());
            heliostatHolder.textViewEl.setText("Elevación: " + heliostat.getPositionEL());
        } else {
            heliostatHolder.textTitle.setText("Sin comunicación");
            heliostatHolder.description.setText("");
        }
    }

    @Override
    public int getItemCount() {
        return heliostats.size();
    }
}
