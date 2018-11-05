package mg.hostel.hostelmanagement;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.ContentValues;
import android.database.Cursor;

public class MyDBHandler extends SQLiteOpenHelper{

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "booking.db";
    public static final String TABLE_BOOKING = "booking";
    public static final String COLUMN_USERNAME = "username";
    public static final String COLUMN_GENDER = "gender";
    public static final String COLUMN_ROOM = "room";
    public static final String COLUMN_MESS = "mess";
    public static final String COLUMN_MOBILE = "mobile";

    public MyDBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase dbb) {
        String query = "CREATE TABLE " + TABLE_BOOKING + "(" +
                COLUMN_USERNAME + " TEXT " +
                COLUMN_GENDER + " TEXT " +
                COLUMN_ROOM + " TEXT " +
                COLUMN_MESS + " TEXT " +
                COLUMN_MOBILE + " TEXT  " +
                ");";
        dbb.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase dbb, int i, int i1) {

        dbb.execSQL("DROP TABLE IF EXISTS "+TABLE_BOOKING); //DROP OLDER TABLE IF EXISTS
        onCreate(dbb);
    }


}
