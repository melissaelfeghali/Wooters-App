package org.elfeghali.freeproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class BookmarksSQLiteOpenHelper extends SQLiteOpenHelper {

    // Database Name
    private static final String DB_NAME = "bookmarks_database";

    // Database Version
    private static final int DB_VERSION = 1;

    public BookmarksSQLiteOpenHelper(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE BOOKMARKS ("
                + "_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "NAME TEXT, " + "IMAGE_RESOURCE_ID INTEGER);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    private static void insertBookmark(SQLiteDatabase db, String name, int image_id) {

        ContentValues contentValues = new ContentValues();
        contentValues.put("NAME", name);
        contentValues.put("IMAGE_RESOURCE_ID", image_id);

        db.insert("BOOKMARKS", null, contentValues);
    }
}
