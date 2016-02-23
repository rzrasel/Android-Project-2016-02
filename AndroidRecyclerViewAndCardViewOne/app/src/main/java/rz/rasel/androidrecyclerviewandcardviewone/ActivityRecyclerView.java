package rz.rasel.androidrecyclerviewandcardviewone;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ActivityRecyclerView extends AppCompatActivity {
    //|------------------------------------|
    private List<Person> persons;
    private RecyclerView rv;

    //|------------------------------------|
    //|~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //|------------------------------------|
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        //|------------------------------------|
        rv = (RecyclerView) findViewById(R.id.rv);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);
        rv.setHasFixedSize(true);

        initializeData();
        initializeAdapter();
        //|------------------------------------|
    }

    //|~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|
    private void initializeData() {
        //|------------------------------------|
        persons = new ArrayList<>();
        /*persons.add(new Person("Emma Wilson", "23 years old", R.drawable.emma));
        persons.add(new Person("Lavery Maiss", "25 years old", R.drawable.lavery));
        persons.add(new Person("Lillie Watts", "35 years old", R.drawable.lillie));*/
        persons.add(new Person("Emma Wilson", "23 years old", R.mipmap.ic_launcher));
        persons.add(new Person("Lavery Maiss", "25 years old", R.mipmap.ic_launcher));
        persons.add(new Person("Lillie Watts", "35 years old", R.mipmap.ic_launcher));
        //|------------------------------------|
    }

    //|~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|
    private void initializeAdapter() {
        //|------------------------------------|
        RVAdapter adapter = new RVAdapter(persons);
        rv.setAdapter(adapter);
        RecyclerView recyclerView = rv;

        /*recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(getActivity(), new   RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        // TODO Handle item click
                        //Log.e("@@@@@",""+position);
                    }
                })
        );*/
        //|------------------------------------|
        recyclerView.addOnItemTouchListener(
                //|------------------------------------|
                new RecyclerItemClickListener(this, new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        //|------------------------------------|
                        // TODO Handle item click
                        Toast.makeText(getApplicationContext(), position + " --", Toast.LENGTH_LONG).show();
                        //|------------------------------------|
                    }
                })
                //|------------------------------------|
        );
        //|------------------------------------|
    }
    //|~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|
}
/*
tutsplus/Android-CardViewRecyclerView
https://github.com/tutsplus/Android-CardViewRecyclerView
Surviving-with-android/Android_RecyclerView_CardView/
https://github.com/survivingwithandroid/Surviving-with-android/tree/master/Android_RecyclerView_CardView
survivingwithandroid/Surviving-with-android
https://github.com/survivingwithandroid/Surviving-with-android

Surviving-with-android/Android_RecyclerView_CardView/
https://github.com/survivingwithandroid/Surviving-with-android/tree/master/Android_RecyclerView_CardView
*/