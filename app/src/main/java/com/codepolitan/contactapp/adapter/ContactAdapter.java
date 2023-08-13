package com.codepolitan.contactapp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.codepolitan.contactapp.R;
import com.codepolitan.contactapp.model.Contact;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ViewHolder> {

    private ArrayList<Contact> contacts = new ArrayList<>();
    private ItemClickListener itemClickListener;



    public interface ItemClickListener{
        void onClick(Contact contact);
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_contact, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bindItem(contacts.get(position), itemClickListener);
    }

    @Override
    public int getItemCount() {

        return contacts.size();
    }

    public void setData(ArrayList<Contact> contacts){
        this.contacts = contacts;
        notifyDataSetChanged();
    }
    public void onClick(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private final CircleImageView ivContact;
        private final TextView tvNameContact;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            ivContact = itemView.findViewById(R.id.iv_contact);
            tvNameContact = itemView.findViewById(R.id.tv_name_contact);
        }

        public void bindItem(Contact contact, ItemClickListener itemClickListener) {
            ivContact.setImageResource(contact.getImage());
            tvNameContact.setText(contact.getName());

            if (itemClickListener != null){
                itemView.setOnClickListener(v -> {
                    itemClickListener.onClick(contact);
                });
            }


        }
    }
}
