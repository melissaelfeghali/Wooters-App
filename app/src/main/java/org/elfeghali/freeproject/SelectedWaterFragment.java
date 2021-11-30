package org.elfeghali.freeproject;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class SelectedWaterFragment extends Fragment {

    private String name;
    private int imageId_one;

    private int[] images_array;
    private List<Integer> images = new ArrayList<>();

    public SelectedWaterFragment() {
        // Required empty public constructor
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_selected_water, container, false);
    }

    public void onStart() {
        super.onStart();

        View view = getView();

        TextView title_text_view = view.findViewById(R.id.title_text_view);
        TextView location_text_view = view.findViewById(R.id.location_text_view);
        TextView info_text_view = view.findViewById(R.id.info_text_view);

        ViewPager viewPager = (ViewPager) view.findViewById(R.id.viewPagerMain);

        try {

            SQLiteOpenHelper sqLiteOpenHelper = new WootersSQLiteOpenHelper(getContext());
            SQLiteDatabase db = sqLiteOpenHelper.getReadableDatabase();

            Cursor cursor = db.query("WATERS", new String[]{"NAME", "LOCATION", "DESCRIPTION", "IMAGE_RESOURCE_ID_ONE",
                            "IMAGE_RESOURCE_ID_TWO", "IMAGE_RESOURCE_ID_THREE", "IMAGE_RESOURCE_ID_FOUR"}, "NAME = ?",
                    new String[]{name}, null, null, null);

            if (cursor.moveToFirst()) {
                String waters_name = cursor.getString(0);
                String waters_location = cursor.getString(1);
                String waters_info = cursor.getString(2);
                imageId_one = cursor.getInt(3);
                images_array = new int[]{cursor.getInt(3), cursor.getInt(4),
                        cursor.getInt(5), cursor.getInt(6)};

                title_text_view.setText(waters_name);
                location_text_view.setText(waters_location);
                info_text_view.setText(waters_info);
            }

            cursor.close();
            db.close();

        } catch (Exception e) {
            Toast.makeText(getContext(), "Database not available.", Toast.LENGTH_SHORT).show();
        }

        Button bookmark_button = view.findViewById(R.id.bookmark_button);
        bookmark_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    SQLiteOpenHelper sqLiteOpenHelper_bookmark = new BookmarksSQLiteOpenHelper(getContext());
                    SQLiteDatabase bookmark_db = sqLiteOpenHelper_bookmark.getReadableDatabase();

                    Cursor cursor_validator = bookmark_db.query("BOOKMARKS", new String[]{"NAME"},
                            "NAME = ?", new String[]{name}, null, null, null);

                    if(!cursor_validator.moveToFirst()) {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("NAME", name);
                        contentValues.put("IMAGE_RESOURCE_ID", imageId_one);
                        bookmark_db.insert("BOOKMARKS", null, contentValues);
                    }

                    TextView textView = view.findViewById(R.id.review_complete);
                    textView.setText("Added to Bookmarks");

                    bookmark_db.close();
                } catch (Exception e) {
                    Toast.makeText(getContext(), "Database not available.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getContext(), images_array);
        viewPager.setAdapter(viewPagerAdapter);

        Button review_button = view.findViewById(R.id.review_button);
        review_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView textView = view.findViewById(R.id.review_complete);
                textView.setText("Feature coming soon in our next update.");
            }
        });
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}