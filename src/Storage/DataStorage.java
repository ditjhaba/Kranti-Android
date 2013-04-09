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

  public DataStorage(Context context) {
        super(context, DB_NAME, null, 1);
    }

    private static final String DATABASE_CREATE = "CREATE TABLE " + TABLE_NAME + " (" +
            _ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            DESCRIPTION_COL + " TEXT);";

    public void store(Issue issue) {
        SQLiteDatabase db = getWritableDatabase();
        SQLiteStatement statement = db.compileStatement("insert into " + TABLE_NAME + " (" + DESCRIPTION_COL+") values ( ?)");
        statement.bindString(1, issue.getDescription());
        statement.executeInsert();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DATABASE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

  public List<Issue> get() {
    SQLiteDatabase db = getReadableDatabase();
    Cursor c = db.rawQuery("SELECT * FROM " + TABLE_NAME , null);
    List<Issue> issues = new ArrayList<Issue>();
    if (c != null ) {
      if  (c.moveToFirst()) {
        do {
          String description = c.getString(c.getColumnIndex(DESCRIPTION_COL));
          Issue issue = new Issue(null,description);
          issues.add(issue);
        }while (c.moveToNext());
      }
    }
    return issues;
  }

  public Issue getIssueDetails() {
    SQLiteDatabase db = getReadableDatabase();
    Cursor c = db.rawQuery("SELECT * FROM " + TABLE_NAME , null);
    String title;
    Issue issue = null;
    List<String> titles = new ArrayList<String>();
    if (c != null ) {
      if  (c.moveToFirst()) {
        do {
          title = c.getString(c.getColumnIndex(TITLE_COL));
          issue = new Issue(title,null);
        }while (c.moveToNext());
      }
    }
    return issue;
  }
}
