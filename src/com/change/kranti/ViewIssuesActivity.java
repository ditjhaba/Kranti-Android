package com.change.kranti;

import android.app.ListActivity;
import android.os.Bundle;
import repository.IssueRepository;

public class ViewIssuesActivity extends ListActivity{

  private IssueRepository issueRepository;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(com.change.kranti.R.layout.issues);
    issueRepository = new IssueRepository(getApplicationContext());
  }


}
