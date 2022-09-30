package edu.info.aen.first_test.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import edu.info.aen.first_test.R;
import edu.info.aen.first_test.RvDetailActivity;

public class CouleursAdapter extends RecyclerView.Adapter<CouleursAdapter.CouleurViewHolder> {

    private final Context ctx;
    private final String[] titre;
    private final String[] description;
    private final int[] images;

    public CouleursAdapter(Context ctx, String[] titre, String[] description, int[] images){
        this.ctx = ctx;
        this.titre = titre;
        this.description = description;
        this.images = images;
    }

    @NonNull
    @Override
    public CouleurViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(ctx);
        View view = inflater.inflate(R.layout.rv_item, parent, false);
        return new CouleurViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CouleurViewHolder holder, int position) {
        holder.title.setText(titre[position]);
        holder.description.setText(description[position]);
        holder.image.setImageResource(images[position]);
        holder.image.setOnClickListener(v -> {
            int pos = holder.getAdapterPosition();
            Intent intent = new Intent(ctx, RvDetailActivity.class);
            intent.putExtra("title", titre[pos]);
            intent.putExtra("description", description[pos]);
            intent.putExtra("image", images[pos]);
            ctx.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return images.length;
    }

    protected static class CouleurViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView title;
        TextView description;
        ConstraintLayout constraintLayout;
        private CouleurViewHolder(View itemView) {
            super(itemView);
            this.image = itemView.findViewById(R.id.rv_item_imageview);
            this.title = itemView.findViewById(R.id.rv_item_tv_title);
            this.description = itemView.findViewById(R.id.rv_item_tv_subtitle);
            this.constraintLayout = itemView.findViewById(R.id.rv_item_cstlay_main_layout);
        }
    }
}
