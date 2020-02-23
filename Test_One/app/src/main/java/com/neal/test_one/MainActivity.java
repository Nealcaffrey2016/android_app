package com.neal.test_one;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    String Massage1 = "Reject" + " $test\n " + 10;
    String Massage2 = Massage1 + " hello";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void rejectOne(View view) {

        TextView textMassageBox = (TextView) findViewById(R.id.text_body);
        textMassageBox.setText(Massage2);


        ImageView backImages = (ImageView) findViewById(R.id.image2);
        backImages.setImageResource(R.drawable.love2);
        Toast.makeText(this, "   Bad choice!", Toast.LENGTH_SHORT).show();
    }

    public void acceptOne(View view) {
        String textMassage2 = "Accept";
        textMassage2 = textMassage2 + "\nGood!";
        String oldMassage;
        // reset textcontent body

        TextView textMassageBox = (TextView) findViewById(R.id.text_body);
        oldMassage = textMassageBox.getText().toString();
        textMassageBox.setText(textMassage2 + oldMassage);


        // log test

        Log.i("MainActivity.java", "prepare to change the images background!");

        //reset a new images


        ImageView backImages = (ImageView) findViewById(R.id.image2);
        backImages.setImageResource(R.drawable.housers);

        // Throst a massage
        Toast.makeText(this, "   Good choice!", Toast.LENGTH_SHORT).show();
    }


    //checkbox method

    public void checkOne(View view) {
        String oldMassage;
        TextView textMassageBox = (TextView) findViewById(R.id.text_body);
        oldMassage = textMassageBox.getText().toString();
        textMassageBox.setText(oldMassage + "\nchecked!");

    }

    //penson picture reset

    public void reChangePicture(View view) {

        ImageView backImages = (ImageView) findViewById(R.id.person_picture);
        backImages.setImageResource(R.drawable.loveone);
    }

    // Send massge using Email

    public void sendEmail(View view) {
        String mailSubject = "testone subject!";
        String massagebody = "massage body ,test !";
        int log = 0;
        // intent body Email
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setType("*/*");

        intent.putExtra(Intent.EXTRA_SUBJECT, mailSubject);
        intent.putExtra(Intent.EXTRA_TEXT, massagebody);
        log = 1;
        if (intent.resolveActivity(getPackageManager()) != null) {
            log = 2;
            startActivity(intent);
        }
        else log=3;

        String textMassage2 = "Accept";
        textMassage2 = textMassage2 + "\nGood!";
        String oldMassage;
        // reset textcontent body

        TextView textMassageBox = (TextView) findViewById(R.id.text_body);
        oldMassage = textMassageBox.getText().toString();
        textMassageBox.setText(textMassage2 + "\nlog value = " + log + "\n" + oldMassage);

        log = 4;
    }

}
