package psa.cesa.gui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.HashMap;

class HeliostatAdapter extends RecyclerView.Adapter<HeliostatHolder>{

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
        return new HeliostatHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HeliostatHolder heliostatHolder, int position) {

    }

    @Override
    public int getItemCount() {
        return heliostats.size();
    }
}
