package com.change.kranti;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import com.kranti.location.GPSLocation;
import repository.IssueRepository;

import java.io.*;

public class CaptureIssueActivity extends Activity {
    private static int count = 0;
    private static final int IMAGE_CAPTURE = 0;
    private Uri imageUri;
    private IssueRepository issueRepository;
    private GPSLocation gpsLocation;
    private Intent ImageData;
    private String fileName;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        issueRepository = new IssueRepository(getApplicationContext());
        setContentView(R.layout.main);
        gpsLocation = new GPSLocation(this);
    }

    public void captureIssueImage(View view) {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, IMAGE_CAPTURE);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == IMAGE_CAPTURE && resultCode == Activity.RESULT_OK && data != null) {
            ImageData = data;
            showImage();
            return;
        }
        Toast.makeText(this, "Issue Image not captured !!", Toast.LENGTH_LONG).show();
    }

    private Bitmap showImage() {
        ImageView issueImageView = (ImageView) findViewById(R.id.issue_image_capture);
        Bitmap issueImageBitmap = (Bitmap) ImageData.getExtras().get("data");
        issueImageView.setImageBitmap(issueImageBitmap);
        return issueImageBitmap;
    }

    private void storeImage() {
        fileName = "Issue_" + count++ + ".png";
        Toast.makeText(this, "Issue Image was captured", Toast.LENGTH_LONG).show();
        File outputFile = new File(createDirectory(), fileName);
        Bitmap issueImageBitmap = showImage();
        ByteArrayOutputStream imageBytes = new ByteArrayOutputStream();
        issueImageBitmap.compress(Bitmap.CompressFormat.PNG, 90, imageBytes);
        try {
            outputFile.createNewFile();
            FileOutputStream stream = new FileOutputStream(outputFile);
            stream.write(imageBytes.toByteArray());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private File createDirectory() {
        File krantiDir = new File("/sdcard/kranti/");
        krantiDir.mkdirs();
        return krantiDir;
    }

    public void submit(View view) {
        if(ImageData!=null)
            storeImage();
        EditText description = (EditText) findViewById(R.id.descriptionText);
        EditText title = (EditText) findViewById(R.id.titleText);
        String title1 =  title.getText().toString();
        String description1 =  description.getText().toString();
        String location = gpsLocation.getLocationByString();
        issueRepository.createIssue(title1, description1, location);
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }
}
