package com.example.newscoba.adapterlist;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.newscoba.R;
import com.example.newscoba.model.beritakonten;

import java.util.List;

public class adapter extends RecyclerView.Adapter<adapter.MyViewHolder> {
    private Context mContext;
    private List<beritakonten> list;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title;
        public TextView published_at;
        public TextView content;
        public TextView author;
        public ImageView thumbnail;
        public LinearLayout panel;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title_news);
            content = (TextView) view.findViewById(R.id.content);
            published_at = (TextView) view.findViewById(R.id.published_at);
            thumbnail = (ImageView) view.findViewById(R.id.thumbnail);
            author = (TextView) view.findViewById(R.id.author);
            panel = view.findViewById(R.id.panel);
        }
    }

    public adapter(Context mContext, List<beritakonten> coll) {
        this.mContext = mContext;
        this.list = coll;
    }

    @Override
    public adapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_fragment, parent, false);

        return new adapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final adapter.MyViewHolder holder, final int position) {
        final beritakonten item = list.get(position);
        holder.title.setText(item.getTitle());
        holder.published_at.setText(item.getPublishedAt());
        holder.content.setText(item.getDescription() + " (Tap untuk baca selengkapnya ....)");
        holder.author.setText("Penulis : " + item.getAuthor());

        Glide.with(mContext).load(item.getUrlToImage()).into(holder.thumbnail);
        holder.panel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(""+item.getUrl()));
                mContext.startActivity(browserIntent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setData(List<beritakonten> _data) {
        this.list = _data;
    }
}
