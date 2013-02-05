package repository;

import storage.DataStorage;
import storage.ServerStorage;
import android.content.Context;
import model.Issue;

public class IssueRepository {
    private DataStorage dataStorage;
    private ServerStorage serverStorage;

    public IssueRepository(Context context) {
        dataStorage = new DataStorage(context);
        serverStorage = new ServerStorage();

    }
    public void createIssue(String title, String description, String location) {
        Issue issue = new Issue(title,description, location);
        serverStorage.store(issue);
        dataStorage.store(issue);
    }
}
