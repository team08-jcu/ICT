package com.example.apple.coursepal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.util.Log;
import android.widget.RatingBar;
public class NewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);

        ActionBar actionBar = getSupportActionBar();

        TextView mDetailsTv = (TextView) findViewById(R.id.textView);
        TextView mtitle = (TextView) findViewById(R.id.textViewtitle);
        ImageView imgv = (ImageView)findViewById(R.id.imageView);
        TextView tutionInfo = (TextView)findViewById(R.id.textTutionInfo);
        TextView ViewEnrollmentInfo = (TextView)findViewById(R.id.textViewEnrollmentInfo);
        RatingBar simpleRatingBar = (RatingBar) findViewById(R.id.ratingBar2);

        //get data from previous activity when item of listview is clicked using intent
        Intent intent = getIntent();
        String mActionBarTitle = intent.getStringExtra("actionBarTitle");
        String mContent = intent.getStringExtra("contentAddress");
        mtitle.setText(mActionBarTitle);
        Bundle bundle=this.getIntent().getExtras();
        int pic=bundle.getInt("image");
        imgv.setImageResource(pic);

        String mtutionInfo = intent.getStringExtra("contentTutionInfo");
        tutionInfo.setText(mtutionInfo);
        Log.d("", "mtutionInfo-"+ mtutionInfo);
        String mViewEnrollmentInfo= intent.getStringExtra("contentEnrollmentInfo");
        ViewEnrollmentInfo.setText(mViewEnrollmentInfo);
        Log.d("", "mViewEnrollmentInfo-"+ mViewEnrollmentInfo);
        String starInt = intent.getStringExtra("contentStarRating");
        simpleRatingBar.setRating((int) Integer.parseInt(starInt));

        Log.d("", "contentAddress-"+ mContent);
        //set actionbar title
        actionBar.setTitle(mActionBarTitle);
        //set text in textview
        mDetailsTv.setText("Address :-" + mContent);

    }
}
