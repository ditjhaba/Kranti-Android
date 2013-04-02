package repository;

import Storage.DataStorage;
import Storage.ServerStorage;
import android.content.Context;
import model.Issue;

import java.util.List;

public class IssueRepository {
    private DataStorage dataStorage;

  public IssueRepository(Context context) {
        dataStorage = new DataStorage(context);

    }
    public void createIssue(String title, String description, String location, String imagePath) {
        Issue issue = new Issue(title,description, location, imagePath);
        dataStorage.store(issue);
    }
    public List<Issue> getIssues() {
      return dataStorage.get();
    }
}
