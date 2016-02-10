package rz.rasel.androidautocompleteone;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.MultiAutoCompleteTextView;
import android.widget.Toast;

public class ActivityAutoComplete extends AppCompatActivity {
    //|------------------------------------|
    String[] colors = {"January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December",
            "Android", "java", "IOS", "SQL", "JDBC", "Web services",
            "Black", "White", "Red", "Blue", "Yellow", "Green", "Brown", "Pink",
            "Orange", "Purple"};
    private AutoCompleteTextView autoComplete;
    private MultiAutoCompleteTextView multiAutoComplete;
    private ArrayAdapter<String> adapter;

    //|~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //|------------------------------------|
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto_complete);
        //|------------------------------------|
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, colors);
        //Creating the instance of ArrayAdapter containing list of language names
        ArrayAdapter <String> adapterTwo = new ArrayAdapter<String> (this, android.R.layout.select_dialog_item, colors);
        //|------------------------------------|
        autoComplete = (AutoCompleteTextView) findViewById(R.id.sysAutoComplete);
        multiAutoComplete = (MultiAutoCompleteTextView) findViewById(R.id.sysMultiAutoComplete);

        // set adapter for the auto complete fields
        autoComplete.setAdapter(adapterTwo);
        multiAutoComplete.setAdapter(adapter);

        // specify the minimum type of characters before drop-down list is shown
        autoComplete.setThreshold(1);
        multiAutoComplete.setThreshold(2);
        // comma to separate the different colors
        multiAutoComplete.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());
        //|------------------------------------|
        // when the user clicks an item of the drop-down list
        multiAutoComplete.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View view, int position, long arg3) {
                Toast.makeText(getBaseContext(), "MultiAutoComplete: " + "you add color " + arg0.getItemAtPosition(position), Toast.LENGTH_LONG).show();
            }
        });
        //|------------------------------------|
    }
    //|~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|
}