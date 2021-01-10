package kg.andro.myrecycler;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder> {
    private List<RecyclerModel> recyclerModelList;

    public RecyclerAdapter(List<RecyclerModel> recyclerModels) {
        this.recyclerModelList = recyclerModels;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_row, parent, false);
        RecyclerViewHolder recyclerViewHolder = new RecyclerViewHolder(view);
        return recyclerViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        RecyclerModel model = recyclerModelList.get(position);
        holder.deleteBtn.setImageResource(model.getDelete_btn());
        holder.tvNumRecycler.setText(model.getNum_recyclerview());
    }

    @Override
    public int getItemCount() {
        return recyclerModelList.size();
    }

    public void removeItem(int position) {
        recyclerModelList.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, recyclerModelList.size());
        notifyDataSetChanged();
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder {

        private ImageView deleteBtn;
        private TextView tvNumRecycler;
        public RecyclerViewHolder(View itemView) {
            super(itemView);
            deleteBtn = itemView.findViewById(R.id.delete_btn);
            tvNumRecycler = itemView.findViewById(R.id.num_recyclerview);

            try {
                deleteBtn.setOnClickListener(v -> removeItem(getAdapterPosition()));
            }
            catch (Exception e){
                ///////////////////
            }

        }
    }
}
