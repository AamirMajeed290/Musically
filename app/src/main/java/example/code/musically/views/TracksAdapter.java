package example.code.musically.views;

import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.squareup.picasso.Picasso;

import java.util.List;

import example.code.musically.MainActivity;
import example.code.musically.R;
import example.code.musically.network.model.Result;
import io.realm.Realm;


/**
 * The type Tracks adapter.
 */
public class TracksAdapter extends RecyclerView.Adapter <TracksAdapter.TracksViewHolder>  {

    /**
     * The Main.
     */
    MainActivity main;

    private Realm realm;

    private List<Result> tracks;

    /**
     * Instantiates a new Tracks adapter.
     *
     * @param tracks the tracks
     */
    public TracksAdapter(List tracks)
    {
        this.tracks=tracks;

    }


    @NonNull
    @Override
    public TracksViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater= LayoutInflater.from(parent.getContext());
        View view= inflater.inflate(R.layout.tracks_rows,parent,false);



        return new TracksViewHolder(view);



    }

    @Override
    public void onBindViewHolder(@NonNull TracksViewHolder holder, final int position) {
        try {

//setting values to all views in recyclerview

            holder.mTextViewTrackName.setText(tracks.get(position).getTrackName().toString()+"( "+ tracks.get(position).getCollectionName().toString()+" )");
            holder.mTextViewArtistName.setText(tracks.get(position).getArtistName().toString());
            holder.mTextViewTrackPrice.setText("Price: "+tracks.get(position).getTrackPrice().toString()+" USD");
            Picasso.get().load(tracks.get(position).getArtworkUrl60()).into(holder.imageView);


            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent=new Intent();
                    intent.setAction(intent.getAction());
                    intent.setDataAndType(Uri.parse(tracks.get(position).getPreviewUrl()),"audio/*");
                    v.getContext().startActivity(intent);

                }
            });


        }
        catch (Exception e)
        {

        }


    }




    @Override
    public int getItemCount() {

        return tracks.size();
    }

    /**
     * The type Tracks view holder.
     */
    public class TracksViewHolder extends RecyclerView.ViewHolder {

        private TextView mTextViewTrackName;
        private TextView mTextViewArtistName;
        private TextView mTextViewTrackPrice;
        private ImageView imageView;

        /**
         * Instantiates a new Tracks view holder.
         *
         * @param itemView the item view
         */
        public TracksViewHolder(@NonNull View itemView) {

            super(itemView);
            //binding views for views in in recyclerview
            mTextViewTrackName = itemView.findViewById(R.id.textViewTrackName);
            mTextViewArtistName = itemView.findViewById(R.id.textViewArtistName);
            mTextViewTrackPrice = itemView.findViewById(R.id.textViewTrackPrice);
            imageView = itemView.findViewById(R.id.imageView);


        }


    }
    }

