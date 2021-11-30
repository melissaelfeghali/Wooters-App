package org.elfeghali.freeproject;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class BookmarksFragment extends Fragment {

    public BookmarksFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        RecyclerView bookmarkRecycler = (RecyclerView) inflater.inflate(R.layout.fragment_bookmarks,
                container, false);

        String[] bookmarkNames;
        int[] bookmarkImages;

        try {
            SQLiteOpenHelper sqLiteOpenHelper = new BookmarksSQLiteOpenHelper(getContext());
            SQLiteDatabase db = sqLiteOpenHelper.getReadableDatabase();

            Cursor cursor = db.query("BOOKMARKS", new String[]{"NAME", "IMAGE_RESOURCE_ID"},
                    null, null, null, null, null);


            String countQuery = "SELECT  * FROM " + "BOOKMARKS";
            Cursor cursor_count = db.rawQuery(countQuery, null);
            int count = cursor_count.getCount();

            bookmarkNames = new String[count];
            bookmarkImages = new int[count];

            int index = 0;
            if (cursor.moveToFirst()) {
                bookmarkNames[index] = cursor.getString(0);
                bookmarkImages[index] = cursor.getInt(1);
                index ++ ;
                while (cursor.moveToNext()) {
                    bookmarkNames[index] = cursor.getString(0);
                    bookmarkImages[index] = cursor.getInt(1);
                    index ++ ;
                }
            }

            cursor_count.close();
            cursor.close();
            db.close();

            CaptionedImagesAdapter captionedImagesAdapter = new CaptionedImagesAdapter(bookmarkNames, bookmarkImages);
            bookmarkRecycler.setAdapter(captionedImagesAdapter);

            LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
            bookmarkRecycler.setLayoutManager(layoutManager);

            return bookmarkRecycler;

        } catch (Exception e) {
            Toast.makeText(getContext(), "Database not available.", Toast.LENGTH_SHORT).show();
        }

        return bookmarkRecycler;
    }
}