package com.example.wallet;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.CardsViewHolder>{

    private List<Card> cards ;
    private  OnItemClickListener onItemClickListener;
    public CardAdapter(List<Card> cards,OnItemClickListener onItemClickListener){
            this.cards = cards;
            this.onItemClickListener= onItemClickListener;

    }

    @NonNull
    @Override
    public CardsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemCard = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_card,parent,false);

        return new CardsViewHolder(itemCard);
    }

    @Override
    public void onBindViewHolder(@NonNull CardsViewHolder holder, int position) {
            Card card=cards.get(position);
            holder.txtNombre.setText(card.getNombre());
            holder.txtNumeroCard.setText(card.getNumeroOsfuscado());
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                   Card card = cards.get(position);
                   onItemClickListener.onItemClick(card);
                }
            });
    }

    @Override
    public int getItemCount() {
        return cards.size();
    }

    class CardsViewHolder extends RecyclerView.ViewHolder {

        TextView txtNombre;
        TextView txtNumeroCard;
        public CardsViewHolder(@NonNull View itemView) {
            super(itemView);
            txtNombre= itemView.findViewById(R.id.txtNombre);
            txtNumeroCard= itemView.findViewById(R.id.txtNumeroCard);
        }
    }
    interface  OnItemClickListener{
        void onItemClick(Card cards);
    }

}
