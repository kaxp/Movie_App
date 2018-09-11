package com.example.kapil.movie_app.recyclerView.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kapil.movie_app.MainActivity;
import com.example.kapil.movie_app.R;
import com.example.kapil.movie_app.recyclerView.callback.OnMovieCellClick;
import com.example.kapil.movie_app.recyclerView.movies.Movies;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class CustomRVAdapter extends RecyclerView.Adapter<CustomRVAdapter.CustomRVViewHolder>{

    private Context mContext;
    private List<Movies> mList;
    private OnMovieCellClick mListener;

    public CustomRVAdapter(Context context, ArrayList<Movies> mList, OnMovieCellClick mListener) {
        this.mContext = context;
        this.mList = mList;
        this.mListener = mListener;

    }

    @NonNull
    @Override
    public CustomRVAdapter.CustomRVViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.list_item, viewGroup , false);

        CustomRVAdapter.CustomRVViewHolder vh = new CustomRVAdapter.CustomRVViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomRVViewHolder customRVViewHolder, int i) {

       final Movies m = this.mList.get(i);
        customRVViewHolder.tv_title.setText(m.Title);
        customRVViewHolder.tv_year.setText(String.valueOf(m.Year));
        customRVViewHolder.tv_genre.setText(m.Genre);
        customRVViewHolder.tv_director.setText(m.Director);
        customRVViewHolder.tv_rating.setText(String.valueOf(m.Rating));
        customRVViewHolder.tv_certification.setText(m.Certification);
        customRVViewHolder.tv_time.setText(String.valueOf(m.Duration));

        Picasso.with(this.mContext)
                .load(m.ThumbnailImage)
                .into(customRVViewHolder.img);

        customRVViewHolder.ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onMovieCellClickedListener(m);




            }
        });


    }



    @Override
    public int getItemCount() {
        return mList != null ? mList.size() : 0;
    }



    public class CustomRVViewHolder extends RecyclerView.ViewHolder{
        private ImageView img;
        private TextView tv_title;
        private TextView tv_genre;
        private TextView tv_rating;
        private TextView tv_director;
        private TextView tv_time;
        private TextView tv_certification;
        private TextView tv_year;
        private LinearLayout ll;


        public CustomRVViewHolder(@NonNull View itemView)  {
            super(itemView);

            img= itemView.findViewById(R.id.img);
            tv_title = itemView.findViewById(R.id.rv_row1);
            tv_genre = itemView.findViewById(R.id.rv_row2);
            tv_year = itemView.findViewById(R.id.rv_row12);
            tv_director = itemView.findViewById(R.id.rv_row3);
            tv_rating = itemView.findViewById(R.id.rv_row4);
            tv_certification = itemView.findViewById(R.id.rv_row43);
            tv_time = itemView.findViewById(R.id.rv_row42);
            ll= itemView.findViewById(R.id.ll_frame);
        }
    }
}
