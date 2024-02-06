package com.example.quizappassignment1.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.quizappassignment1.R;
import com.example.quizappassignment1.model.Option;

import java.util.List;

public class GalleryAdapter extends ArrayAdapter<Option> {
    private Context mContext;
    private int mResource;

    public GalleryAdapter(@NonNull Context context, int resource, @NonNull List<Option> objects) {
        super(context, resource, objects);
        this.mContext = context;
        this.mResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);

        convertView = layoutInflater.inflate(mResource, parent, false);

        ImageView imageView = convertView.findViewById(R.id.image);
        imageView.setImageURI(getItem(position).getImage());

        TextView txtAnswer = convertView.findViewById(R.id.txtAnswer);
        txtAnswer.setText(getItem(position).getMatchingName());

        return convertView;
    }
}
