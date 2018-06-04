package com.example.admin.crudmahasiswaik.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.admin.crudmahasiswaik.R;
import com.example.admin.crudmahasiswaik.model.Mahasiswa;
import com.squareup.picasso.Picasso;

import java.util.List;


public class MahasiswaAdapter extends  ArrayAdapter<Mahasiswa>{

    public MahasiswaAdapter(@NonNull Context context, int resource, @NonNull List<Mahasiswa> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext())
                    .inflate(R.layout.item_mahasiswa, parent, false);
        }
        Mahasiswa user = getItem(position);
        TextView tvNama = convertView.findViewById(R.id.tv_nama);
        tvNama.setText(user.getNama());
        TextView tvNim = convertView.findViewById(R.id.tv_nim);
        tvNim.setText(user.getNim());
        TextView tvEmail = convertView.findViewById(R.id.tv_email);
        tvEmail.setText(user.getEmail());


        ImageView ivFoto = convertView.findViewById(R.id.iv_foto);
        Picasso.get().load("https://picsum.photos/200/300").into(ivFoto);

        return convertView;
    }
}

