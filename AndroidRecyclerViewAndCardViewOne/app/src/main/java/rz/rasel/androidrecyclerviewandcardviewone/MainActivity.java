package rz.rasel.androidrecyclerviewandcardviewone;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    //|------------------------------------|
    private List<Person> persons;
    TextView personName;
    TextView personAge;
    ImageView personPhoto;

    //|------------------------------------|
    //|~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //|------------------------------------|
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //|------------------------------------|
        personName = (TextView)findViewById(R.id.person_name);
        personAge = (TextView)findViewById(R.id.person_age);
        personPhoto = (ImageView)findViewById(R.id.person_photo);

        personName.setText("Emma Wilson");
        personAge.setText("23 years old");
        //personPhoto.setImageResource(R.drawable.emma);
        personPhoto.setImageResource(R.mipmap.ic_launcher);
        //|------------------------------------|
    }

    //|~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|
    private void initializeData() {
        //|------------------------------------|
        persons = new ArrayList<>();
        persons.add(new Person("Emma Wilson", "23 years old", R.mipmap.ic_launcher));
        persons.add(new Person("Lavery Maiss", "25 years old", R.mipmap.ic_launcher));
        persons.add(new Person("Lillie Watts", "35 years old", R.mipmap.ic_launcher));
        //|------------------------------------|
    }
    //|~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|
}