package com.example.madlabpaper;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;


public abstract class Database extends SQLiteOpenHelper {
    private static final String DB_Name = "courseDb";
    private static final int DB_version = 1;
    private static final String TableName = "mycourse";
    private static final String ID_Col = "courseDb";
    private static final String Name = "Course Name";

    private static final String DurationCol = "duration";

    private static final String DescCol = "Desc";

    public Database(Context context) {
        super(context, DB_Name, null, DB_version);

    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        // on below line we are creating
        // an sqlite query and we are
        // setting our column names
        // along with their data types.
        String trackCol = "Track";
        String query = "CREATE TABLE " + TableName + " ("
                + ID_Col + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + Name + "TEXT,"
                + DurationCol + " TEXT,"
                + DescCol + "TEXT,"
                + trackCol + "TEXT)";

        // at last we are calling a exec sql
        // method to execute above sql query
        db.execSQL(query);
    }

    public void addNewCourse(String courseName, String courseDuration, String courseDesc, String courseTrack) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Name, courseName);
        values.put(DurationCol, courseDuration);
        values.put(DescCol, courseDesc);
        values.put(courseTrack, courseTrack);
        db.insert(TableName, null, values);
        db.close();

    }
    @Override
    public void onUpgrade(SQLiteDatabase db,int oldVersion,int newVersion){
        db.execSQL(" Drop Table if Exists " + TableName);
        onCreate(db);

    }
}

