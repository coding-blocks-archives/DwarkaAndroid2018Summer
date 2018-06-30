package com.codingblocks.postsfetch;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsHolder> {

    private Context context;
    private ArrayList<Article> articles;

    public NewsAdapter(ArrayList<Article> articles) {
        this.articles = articles;
    }

    @NonNull
    @Override
    public NewsHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        context = viewGroup.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.item_news, viewGroup, false);
        return new NewsHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsHolder viewHolder, int i) {
        Article currentArticle = articles.get(i);

//        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//            }
//        });

        viewHolder.title.setText(currentArticle.getTitle());
        viewHolder.desc.setText(currentArticle.getDesc());
        Source source = currentArticle.getSource();
        String newsName = "Anonymous";
        String authorName = "Anonymous";
        if (!source.getName().equals("null"))
            newsName = source.getName();
        if (!currentArticle.getAuthor().equals("null")) {
            authorName = currentArticle.getAuthor();
        }
        viewHolder.authorAndSource.setText(authorName + " " +newsName);
        Picasso.get()
                .load(currentArticle.getImageUrl())
                .error(R.drawable.ic_error)
                .into(viewHolder.newsImage);

    }

    @Override
    public int getItemCount() {
        return articles.size();
    }

    class NewsHolder extends RecyclerView.ViewHolder {

        ImageView newsImage;
        TextView title, desc, authorAndSource;

        public NewsHolder(@NonNull View itemView) {
            super(itemView);
            newsImage = itemView.findViewById(R.id.ivNews);
            title = itemView.findViewById(R.id.tvTitle);
            desc = itemView.findViewById(R.id.tvDesc);
            authorAndSource = itemView.findViewById(R.id.tvAuthorAndSource);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    final Article article = articles.get(getAdapterPosition());
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(article.getUrl()));

                    context.startActivity(i);

                }
            });

        }
    }

}
