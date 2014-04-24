package Storage;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import model.Issue;

import java.util.ArrayList;
import java.util.List;

import static android.provider.BaseColumns._ID;


public class DataStorage extends SQLiteOpenHelper {
    private static final String TABLE_NAME = "issues";
    private static final String TITLE_COL = "title";
    private static final String DESCRIPTION_COL = "description";
    private static final String DB_NAME = "kranti.db";
    private static final String DATABASE_CREATE = "CREATE TABLE " + TABLE_NAME + " (" + _ID
            + " INTEGER PRIMARY KEY AUTOINCREMENT, " + TITLE_COL
            + " TEXT NOT NULL ," + DESCRIPTION_COL + " TEXT );";


    public DataStorage(Context context) {
        super(context, DB_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DATABASE_CREATE);
    }

    public void store(Issue issue) {
        SQLiteDatabase db = getWritableDatabase();
        SQLiteStatement statement = db.compileStatement("INSERT INTO " + TABLE_NAME + " (" + TITLE_COL + "," + DESCRIPTION_COL + ") VALUES ( ?, ? )");
        statement.bindString(1, issue.getTitle());
        statement.bindString(2, issue.getDescription());
        statement.executeInsert();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    public List<Issue> get() {
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        List<Issue> issues = new ArrayList<Issue>();
        if (cursor != null){
            if (cursor.moveToFirst()){
                do{
                    String title = cursor.getString(cursor.getColumnIndex(TITLE_COL));
                    String description = cursor.getString(cursor.getColumnIndex(DESCRIPTION_COL));
                    Issue issue = new Issue(title, description);
                    issues.add(issue);
                }while (cursor.moveToLast());
            }
        }
        return issues;
    }
}
