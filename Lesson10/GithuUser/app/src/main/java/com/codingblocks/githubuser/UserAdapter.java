package com.codingblocks.githubuser;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserHolder> {

    private ArrayList<User> users;
    private Context context;

    public UserAdapter(ArrayList<User> users) {
        this.users = users;
    }

    @NonNull
    @Override
    public UserHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        context = viewGroup.getContext();
        return new UserHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_row, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull UserHolder userHolder, int i) {
        User currentUser = users.get(i);
        userHolder.userId.setText(currentUser.getLogin());
        Picasso.get().load(currentUser.getAvatarUrl()).into(userHolder.userImage);
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public class UserHolder extends RecyclerView.ViewHolder {

        ImageView userImage;
        TextView userId;

        public UserHolder(@NonNull View itemView) {
            super(itemView);
            userImage = itemView.findViewById(R.id.ivUser);
            userId = itemView.findViewById(R.id.tvUserName);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    User currentUser = users.get(getAdapterPosition());
                    //Start a new Activity with an Intent
                    Intent i = new Intent(context,DetailActivity.class);
//                    i.putExtra("URL",currentUser.getUrl() );
//                    i.putExtra("REPO",currentUser.getReposUrl());
//                    i.putExtra("LOGIN", currentUser.getLogin());
//                    i.putExtra("AVATAR", currentUser.getAvatarUrl());
//

//                    Gson gson = new Gson();
//                    String json = gson.toJson(currentUser);

                    i.putExtra("USER",currentUser);
//                    Log.e("TAG", "onClick: " + currentUser.getReposUrl());
//                    Log.e("TAG", "onClick: " + currentUser.getUrl());
                    context.startActivity(i);

                }
            });

        }
    }
}
