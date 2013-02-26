package com.change.kranti;

import android.*;
import android.R;
import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import model.Issue;
import repository.IssueRepository;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class ViewIssuesActivity extends ListActivity{

  private IssueRepository issueRepository;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(com.change.kranti.R.layout.issues);
    issueRepository = new IssueRepository(getApplicationContext());
    List<Issue> issues = new ArrayList<Issue>();
    issues = issueRepository.getIssues();
    ArrayAdapter<Issue> adapter = new ArrayAdapter<Issue>(this,
      android.R.layout.simple_list_item_1, issues);

    setListAdapter(adapter);
  }

  @Override
  protected void onListItemClick(ListView listView, View view, int position, long id) {
    super.onListItemClick(listView, view, position, id);
    Issue issue = (Issue)listView.getAdapter().getItem(position);
    Intent intent = new Intent(getApplicationContext(), IssueDetailsActivity.class);
    intent.putExtra(getString(com.change.kranti.R.string.issue_title), issue.getTitle());
    intent.putExtra(getString(com.change.kranti.R.string.issue_description), issue.getDescription());
    intent.putExtra(getString(com.change.kranti.R.string.issue_location), issue.getLocation());
    intent.putExtra(getString(com.change.kranti.R.string.issue_image_url), issue.getImagePath());
    startActivity(intent);

  }
}
