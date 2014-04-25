package com.change.kranti;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import repository.IssueRepository;

public class ViewIssuesActivity extends ListActivity {
    private IssueRepository issueRepository;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view);
        issueRepository = new IssueRepository(getApplicationContext());

    }

}