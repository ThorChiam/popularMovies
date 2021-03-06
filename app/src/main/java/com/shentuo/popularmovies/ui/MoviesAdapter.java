package com.shentuo.popularmovies.ui;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.shentuo.popularmovies.R;
import com.shentuo.popularmovies.global.Constants;
import com.shentuo.popularmovies.model.Poster;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ShentuoZhan on 13/3/17.
 */

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.PosterViewHolder> {
    private static final String TAG = MoviesAdapter.class.getSimpleName();
    final private ListItemClickListener mOnClickListener;
    private Context context;
    private List<Poster> mData;

    public interface ListItemClickListener {
        void onListItemClick(String jsonString);
    }

    public MoviesAdapter(ListItemClickListener listener) {
        mOnClickListener = listener;
        mData = new ArrayList<>();
    }

    public void addPosterItem(Poster poster) {
        mData.add(poster);
    }

    public void clearItems() {
        mData = new ArrayList<>();
    }

    @Override
    public PosterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        int layoutIdForListItem = R.layout.movies_list_item;
        LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater.inflate(layoutIdForListItem, parent, false);

        return new PosterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PosterViewHolder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    class PosterViewHolder extends RecyclerView.ViewHolder implements OnClickListener {
        ImageView listItemPosterView;

        public PosterViewHolder(View itemView) {
            super(itemView);
            listItemPosterView = (ImageView) itemView.findViewById(R.id.iv_item_poster);
            itemView.setOnClickListener(this);
        }

        void bind(int listIndex) {
            String imageURL = Constants.BASE_IMAGE_URL + Constants.IMAGE_SIZE + "/" + mData.get(listIndex).getPoster_path();
            Picasso.with(context)
                    .load(imageURL)
                    .placeholder(R.drawable.ic_picture)
                    .error(R.drawable.ic_error)
                    .into(listItemPosterView);
        }

        @Override
        public void onClick(View view) {
            int clickedPosition = getAdapterPosition();
            if (clickedPosition > -1 && clickedPosition < mData.size()) {
                mOnClickListener.onListItemClick(mData.get(clickedPosition).toString());
            }
        }
    }
}
