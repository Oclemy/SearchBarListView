package com.tutorials.hp.searchbarlistview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import com.mancj.materialsearchbar.MaterialSearchBar;
import java.util.ArrayList;
import java.util.List;
/*
- Our MainActivity class.
- Derives from AppCompatActivity which is a Base class for activities that use the support library action bar features.
- Methods: onCreate().
- Inflated From activity_main.xml using the setContentView() method.
- This method is responsible for filtering/searching a gridview via a material serahcbar displayed inside a toolbar.
- The views we use are Material Searchbar for searching and ListView to be searched.
- Reference MaterialSearchBar and ListView from our layout specification using findViewById().
- Instantiate adapter and set it to ListView.
- Add TextChangeListener to MaterialSearchBar and use arrayadapter instance to filter data inside onTextChanged() method.
 */
public class MainActivity extends AppCompatActivity {

    /*
    - When activity is created.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //REFERENCE MATERIALSEARCHBAR AND LISTVIEW
        ListView lv= (ListView) findViewById(R.id.mListView);
        MaterialSearchBar searchBar = (MaterialSearchBar) findViewById(R.id.searchBar);
        searchBar.setHint("Search..");
        searchBar.setSpeechMode(true);

        List<String> galaxies=new ArrayList<>();
        galaxies.add("Cartwheel");
        galaxies.add("Whirlpool");
        galaxies.add("Andromeda I");
        galaxies.add("Andromeda II");
        galaxies.add("Sombrero");
        galaxies.add("Messier 81");
        galaxies.add("Messier 87");
        galaxies.add("Canis Majos Over-density");
        galaxies.add("Messier 92");
        galaxies.add("Black Eye");
        galaxies.add("Centaurus A");
        galaxies.add("Centaurus B");
        galaxies.add("Milky Way");
        galaxies.add("IC 1011");
        galaxies.add("Star Bust");
        galaxies.add("Hoag's Object");
        galaxies.add("Pinwheel");
        galaxies.add("Triangulum");
        galaxies.add("Cosmos Redshift");
        galaxies.add("Ursa Minor");
        galaxies.add("Virgo Stellar-Stream");

        //ADAPTER
        final ArrayAdapter adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,galaxies);
        lv.setAdapter(adapter);

        //SEARCHBAR TEXT CHANGE LISTENER
        searchBar.addTextChangeListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                //SEARCH FILTER
                adapter.getFilter().filter(charSequence);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        //LISTVIEW ITEM CLICKED
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, adapter.getItem(i).toString(), Toast.LENGTH_SHORT).show();
            }
        });

    }

}
