package Storage;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import model.Issue;

import static android.provider.BaseColumns._ID;


public class DataStorage extends SQLiteOpenHelper {
    private static final String TABLE_NAME = "issues";
    private static final String TITLE_COL = "title";
    private static final String DESCRIPTION_COL = "description";
    private static final String LOCATION_COL = "location";
    private static final String DB_NAME = "kranti.db";
    private static final String IMAGEPATH_COL = "imagepath";

  public DataStorage(Context context) {
        super(context, DB_NAME, null, 1);
    }

    private static final String DATABASE_CREATE = "CREATE TABLE " + TABLE_NAME + " (" +
            _ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            TITLE_COL + " TEXT NOT NULL ," +
            DESCRIPTION_COL + " TEXT, " +
            LOCATION_COL + " TEXT, "+
            IMAGEPATH_COL+" TEXT );";

    public void store(Issue issue) {

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DATABASE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

}
