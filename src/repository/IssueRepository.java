package repository;

import android.content.Context;
import model.Issue;
import storage.DataStorage;
import storage.ServerStorage;

import java.util.List;

public class IssueRepository {
    private DataStorage dataStorage;
    private ServerStorage serverStorage;

  public IssueRepository(Context context) {
        dataStorage = new DataStorage(context);
        serverStorage = new ServerStorage();

    }
    public void createIssue(String title, String description, String location, String imagePath) {
        Issue issue = new Issue(title,description, location, imagePath);
        dataStorage.store(issue);
    }
    public List<Issue> getIssues() {
      return dataStorage.get();
    }
}
