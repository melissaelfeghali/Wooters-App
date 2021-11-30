package org.elfeghali.freeproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class WootersSQLiteOpenHelper extends SQLiteOpenHelper {

    // Database Name
    private static final String DB_NAME = "wooters_database";

    // Database Version
    private static final int DB_VERSION = 1;

    public WootersSQLiteOpenHelper(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        // SQL command to create table
        db.execSQL("CREATE TABLE WOODS ("
                + "_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "NAME TEXT, " + "LOCATION TEXT, " + "DESCRIPTION TEXT, "
                + "IMAGE_RESOURCE_ID_ONE INTEGER, " + "IMAGE_RESOURCE_ID_TWO INTEGER, "
                + "IMAGE_RESOURCE_ID_THREE INTEGER, " + "IMAGE_RESOURCE_ID_FOUR INTEGER);");

        db.execSQL("CREATE TABLE WATERS ("
                + "_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "NAME TEXT, " + "LOCATION TEXT, " + "DESCRIPTION TEXT, "
                + "IMAGE_RESOURCE_ID_ONE INTEGER, " + "IMAGE_RESOURCE_ID_TWO INTEGER, "
                + "IMAGE_RESOURCE_ID_THREE INTEGER, " + "IMAGE_RESOURCE_ID_FOUR INTEGER);");

        insertWater(db, "Baatara Waterfalls", "Tannourine",
                "The waterfall, also known as Balaa Gorge Sinkhole, drops 255 meters into the Balaa Pothole," +
                        "a cave of Jurassic limestone. This caves is also knwon as the Cave of the Three Bridges", R.drawable.baatara_one,
                R.drawable.baatara_two, R.drawable.baatara_three, R.drawable.baatara_four);

        insertWater(db, "Kfarhelda Waterfall", "Boustane El Aassi",
                "Spring waterfalls hitting the banks of Walnut River, known in Arabic as Nahr Al Jawz",
                R.drawable.kfarhelda_one, R.drawable.kfarhelda_two, R.drawable.kfarhelda_three, R.drawable.kfarhelda_four);

        insertWater(db, "Jezzine Waterfall ", "Jezzine",
                "The waterfalls are located on the edge of the town and fall down the valley. " +
                        "The water flows from Jezzine Spring and goes down Jezzine’s River. " +
                        "After the fall, water meets with the Awali River and they both end up in the Litani power plant.",
                R.drawable.jezzine_one, R.drawable.jezzine_two, R.drawable.jezzine_three, R.drawable.jezzine_four);

        insertWater(db, "Afqa Waterfall", "Afqa",
                "The word Apheca, or Afeka, was interpreted as “source” and affiliated to the birth and death of Adonis at the foot of the waterfalls, " +
                        "where Lake Yammouneh is formed. Gushing out of a limestone cave in the cliff wall almost 200m above the ground, " +
                        "the waterfalls are at the source of the River Adonis or Nahr Ibrahim.", R.drawable.afqa_one, R.drawable.afqa_two,
                R.drawable.afqa_three, R.drawable.afqa_four);

        insertWater(db, "Chouwen Lake", "Chouwen",
                "After hiking in the majestic nature, mixed forests with oak, pine and many other plant species, " +
                        "a marvelous lake known as Jannet Chouwen is reached. " +
                        "The hiking trip is moderate during down slopes and advanced during up slopes." +
                        "Make sure to bring a swimsuit to benefit from the clear transparent water for a swim. ", R.drawable.chouwen_one,
                R.drawable.chouwen_two, R.drawable.chouwen_three, R.drawable.chouwen_four);

        insertWater(db, "Nahr El Jahliye", "El Fkhaïte",
                "Nahr ej Jâhlîyé is a stream in Mount Lebanon and has an elevation of 167 metres. ", R.drawable.jahliye_one,
                R.drawable.jahliye_two, R.drawable.jezzine_three, R.drawable.jezzine_four);

        insertWater(db, "Atika Waterfall", "Akkar El Atika",
                "Located right above the citadel, the 160 meters tall Akkar el Atiqa waterfall is one of the highest in Akkar. " +
                        "When visiting in winter, you will hear the water roaring, especially when snow is melting. " +
                        "It is said that the current waterfall takes its shape from the rock behind it, carved by broken ice. ", R.drawable.atika_one,
                R.drawable.atika_two, R.drawable.atika_three, R.drawable.atika_four);

        insertWater(db, "Qannoubine Waterfalls", "Bcharreh",
                "Formed by the melting snow covering Mount Makmel from December onwards, " +
                        "the Qannoubine falls surge into the valley. It is a UNESCO World Heritage Site.", R.drawable.qannoubine_one,
                R.drawable.qannoubine_two, R.drawable.qannoubine_three, R.drawable.qannoubine_four);

        insertWater(db, "Baakline Waterfall", "Baakline", "The blue waterfall is called Shallalat Al Zarka and there " +
                        "is a restaurant there with the same name.", R.drawable.baakline_one,
                R.drawable.baakline_two, R.drawable.baakline_three, R.drawable.baakline_four);

        insertWater(db, "Serjbel Waterfall", "Serjbel", "The waterfall is a small treasure located in the Chouf" +
                        "District of Mount Lebanon. It is a public place where no entrance is required.", R.drawable.serjbel_one,
                R.drawable.serjbel_two, R.drawable.serjbel_three, R.drawable.serjbel_four);

        insertWater(db, "Akoura Waterfall", "Akoura", "After a 90min hike near the river, you will " +
                        "find an amazing lake and waterfall where you can swim and enjoy the clean blue and fresh water.", R.drawable.akoura_one,
                R.drawable.akoura_two, R.drawable.akoura_three, R.drawable.akoura_four);

        insertWater(db, "Assi River", "Hermel", "Unlike other rivers, Al-Assi offers enough water depth all year round. " +
                        "The ride is 7 km long; you will follow the white stream for about 2 hours and a half and cross 3 waterfalls that will pump " +
                        "high your adrenaline.", R.drawable.assi_river_one, R.drawable.assi_river_two, R.drawable.assi_river_three, R.drawable.assi_river_four);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    private static void insertWood(SQLiteDatabase db, String name, String location, String description,
                                   int image_id_one, int image_id_two, int image_id_three, int image_id_four) {

        ContentValues contentValues = new ContentValues();
        contentValues.put("NAME", name);
        contentValues.put("LOCATION", location);
        contentValues.put("DESCRIPTION", description);
        contentValues.put("IMAGE_RESOURCE_ID_ONE", image_id_one);
        contentValues.put("IMAGE_RESOURCE_ID_TWO", image_id_two);
        contentValues.put("IMAGE_RESOURCE_ID_THREE", image_id_three);
        contentValues.put("IMAGE_RESOURCE_ID_FOUR", image_id_four);

        db.insert("WOODS", null, contentValues);
    }

    private static void insertWater(SQLiteDatabase db, String name, String location, String description,
                                    int image_id_one, int image_id_two, int image_id_three, int image_id_four) {

        ContentValues contentValues = new ContentValues();
        contentValues.put("NAME", name);
        contentValues.put("LOCATION", location);
        contentValues.put("DESCRIPTION", description);
        contentValues.put("IMAGE_RESOURCE_ID_ONE", image_id_one);
        contentValues.put("IMAGE_RESOURCE_ID_TWO", image_id_two);
        contentValues.put("IMAGE_RESOURCE_ID_THREE", image_id_three);
        contentValues.put("IMAGE_RESOURCE_ID_FOUR", image_id_four);


        db.insert("WATERS", null, contentValues);
    }
}
