package com.example.android.muzak;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by pkennedy on 11/18/17.
 */

public class AlbumAdapter extends ArrayAdapter<Album> {

    public AlbumAdapter(Activity context, ArrayList<Album> albums) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for three TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, albums);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item_albums, parent, false);
        }

        // Get the {@link album} object located at this position in the list
        Album currentAlbum = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID title_text_view
        TextView titleTextView = (TextView) listItemView.findViewById(R.id.title_text_view);
        // Get the title from the current song object and
        // set this text on the Title TextView
        titleTextView.setText(currentAlbum.getTitle());

        // Find the TextView in the list_item.xml layout with the ID artist_text_view
        TextView artistTextView = (TextView) listItemView.findViewById(R.id.artist_text_view);
        // Get the title from the current song object and
        // set this text on the Title TextView
        artistTextView.setText(currentAlbum.getArtist());

        // Find the TextView in the list_item.xml layout with the ID duration_text_view
        TextView albumTextView = (TextView) listItemView.findViewById(R.id.duration_text_view);
        // Get the title from the current song object and
        // set this text on the Title TextView
        albumTextView.setText(currentAlbum.getDuration());

        // Find the ImageView in the list_item.xml layout with the ID album_image_view
        ImageView albumImageView = (ImageView) listItemView.findViewById(R.id.album_image_view);
        // Get the title from the current song object and
        // set this text on the Title TextView
        albumImageView.setImageResource(currentAlbum.getImageResourceId());

        // Return the whole list item layout (containing 3 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return listItemView;
    }
}
