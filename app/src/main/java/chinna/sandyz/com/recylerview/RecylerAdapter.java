package chinna.sandyz.com.recylerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;



public class RecylerAdapter extends RecyclerView.Adapter<RecylerAdapter.ViewHolder> {

    private String[] names;
    Context context;

    public RecylerAdapter(String[] names) {
        this.names = names;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflater = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row, null);

        ViewHolder viewHolder = new ViewHolder(inflater);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.name.setText(names[position]);


    }

    @Override
    public int getItemCount() {
        return names.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView name;

        private ViewHolder(View itemView) {


            super(itemView);

            name = (TextView) itemView.findViewById(R.id.textView);
        }
    }
}
