package com.change.kranti;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import com.change.kranti.adapters.ViewIssuesAdapter;
import model.Issue;
import repository.IssueRepository;

import java.util.ArrayList;
import java.util.List;

public class ViewIssuesActivity extends Activity{

  private IssueRepository issueRepository;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(com.change.kranti.R.layout.issues);
    issueRepository = new IssueRepository(getApplicationContext());
      List<Issue> issues = new ArrayList<Issue>();
      issues = issueRepository.getIssues();
      LayoutInflater layoutInflater = getLayoutInflater();

  }



}
