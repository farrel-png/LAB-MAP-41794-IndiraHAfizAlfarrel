package umn.ac.id.uts;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class recyclerAdapter extends RecyclerView.Adapter<recyclerAdapter.MyViewHolder> {
    private ArrayList<Music> judulList;
    private RecyclerViewClickListener listener;

    public recyclerAdapter(ArrayList<Music> judulList, RecyclerViewClickListener listener){
        this.judulList = judulList;
        this.listener = listener;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private ImageButton delete;
        private TextView judulTxt, kategoriTxt;

        public MyViewHolder(final View view){
            super(view);
            delete = view.findViewById(R.id.delete);
            judulTxt = view.findViewById(R.id.judul);
            kategoriTxt = view.findViewById(R.id.kategori);

            view.setOnClickListener(this);
            delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(listener!= null){
                        int position = getAdapterPosition();
                        if(position!=RecyclerView.NO_POSITION){
                            listener.onDeleteClick(position);
                        }
                    }
                }
            });
        }

        @Override
        public void onClick(View view) {
            listener.onClick(view, getAdapterPosition());
        }
    }

    @NonNull
    @Override
    public recyclerAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,parent,false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull recyclerAdapter.MyViewHolder holder, int position) {
        String name = judulList.get(position).getJudul();
        String kat = judulList.get(position).getKategori();
        holder.kategoriTxt.setText(kat);
        holder.judulTxt.setText(name);
    }

    @Override
    public int getItemCount() {
        return judulList.size();
    }

    public interface RecyclerViewClickListener{
        void onClick(View v, int position);
        void onDeleteClick(int position);
    }
}
