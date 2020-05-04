package psa.cesa.gui.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.HashMap;

import psa.cesa.gui.view.HeliostatHolder;
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
        Heliostat heliostat = heliostats.get(position);
        heliostatHolder.textTitle.setText("" + heliostat.getComLineId() + "-" + heliostat.getId());
        heliostatHolder.description.setText(heliostat.state0ToString());
        heliostatHolder.imageViewEl0.setImageResource(R.drawable.image_el_0);
        heliostatHolder.imageViewEl1.setImageResource(R.drawable.image_el_1);
        heliostatHolder.imageViewEl1.setRotation(heliostat.getPositionEL());
        heliostatHolder.imageViewAz.setImageResource(R.drawable.image_az);
        heliostatHolder.imageViewAz.setRotation(heliostat.getPositionAZ());
        heliostatHolder.textViewAzEl.setText("          Acimut: " + heliostat.getPositionAZ() + "                   Elevación: " + heliostat.getPositionEL());
    }

    @Override
    public int getItemCount() {
        return heliostats.size();
    }
}
