package psa.cesa.gui.view;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.HashMap;
import java.util.Map;

import psa.cesa.gui.R;
import psa.cesa.gui.controller.HeliostatActivity;
import psa.cesa.gui.model.ComLine;
import psa.cesa.gui.model.Heliostat;

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
        comLineHolder.title.setText(String.valueOf(comLines.get(position).getId()));
        if (operate(comLines.get(position))) {
            comLineHolder.description.setText("Heliostatos en operación");
        } else {
            comLineHolder.description.setText("Heliostatos en abatimiento");
        }

        comLineHolder.setRowClickListener(new RowClickListener() {
            @Override
            public void onRowClickListener(View view, int position) {

                Intent intent = new Intent(context, HeliostatActivity.class);

                intent.putExtra("comLine", comLines.get(position));

                context.startActivity(intent);
            }
        });
    }

    private boolean operate(ComLine comLine) {
        boolean operation = false;
        for (Map.Entry<Integer, Heliostat> heliostat : comLine.getHeliostats().entrySet()) {
            if (!heliostat.getValue().state0ToString().equals("Operación local") || !heliostat.getValue().state0ToString().equals("Abatimiento")) {
                operation = true;
            }
        }
        return operation;
    }

    @Override
    public int getItemCount() {
        return comLines.size();
    }
}
