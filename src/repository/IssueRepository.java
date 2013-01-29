package repository;

import Storage.DataStorage;
import android.content.Context;
import model.Issue;

public class IssueRepository {
    private DataStorage dataStorage;

    public IssueRepository(Context context) {
        dataStorage = new DataStorage(context);

    }
    public void createIssue(String title, String description, String location) {
        Issue issue = new Issue(title,description, location);
        dataStorage.store(issue);
    }
}
