package com.example.apple.coursepal;

import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.SearchView;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import java.util.ArrayList;
import android.util.Log;
import com.google.firebase.auth.FirebaseAuth;
import android.content.Intent;
import android.widget.Toast;

public class ListMain2Activity extends AppCompatActivity {

        ListView listView;
        ListViewAdapter adapter;
        String[] title;
        String[] description;
        int[] icon;
        ArrayList<Model> arrayList = new ArrayList<Model>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_main2);
        Log.d("1","-1");

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Search");


      //  title = new String[]{"Battery", "Cpu", "Display", "Memory", "Sensor"};
      //  description = new String[]{"Battery detail...", "Cpu detail...", "Display detail...", "Memory detail...", "Sensor detail..."};

        title = new String[]{
                "University of Melbourne - Bachelors of Information Technology",
                "The University of Sydney - Bachelor of Games and interactive environments",
                "Monash University, Clayton Campus - Bachelor of Justice",
                "The University of Queensland - Bachelors of Information Technology",
                "UNSW Sydney - Bachelor of Games and interactive environments",
                "The University of Adelaide - Bachelor of Justice",
                "RMIT University, Melbourne City Campus -  Bachelors of Information Technology ",
                "University of South Australia - Bachelor of Games and interactive environments",
                "La Trobe University, Melbourne Campus - Bachelor of Justice"
        };
        description = new String[]{
                "Parkville VIC 3010 Australia",
                "Camperdown NSW 2006 Australia",
                "St Lucia QLD 4072 Australia",
                "Public university in Kensington Australia",
                "Wellington Rd Clayton VIC 3800 Australia",
                "Adelaide SA 5005 Australia",
                "124 La Trobe St Melbourne VIC 3000 Australia",
                "101 Currie St Adelaide SA 5001 Australia",
                "Plenty Rd & Kingsbury Dr Bundoora VIC 3086 Australia"
        };

        icon = new int[]{R.drawable.melbourneuni,
                R.drawable.sydneyuni,
                R.drawable.melbourneuni,
                R.drawable.queenslanduni,
                R.drawable.unsw,
                R.drawable.adelaide,
                R.drawable.rmit,
                R.drawable.southaus,
                R.drawable.latrobe};

        listView = (ListView) findViewById(R.id.listView);

        for (int i =0; i<title.length; i++){
            Log.d("1","-1" + i);
            Model model = new Model(title[i], description[i], icon[i]);
            //bind all strings in an array
            arrayList.add(model);
        }

        //pass results to listViewAdapter class
        adapter = new ListViewAdapter(this, arrayList);

        //bind the adapter to the listview
        listView.setAdapter(adapter);

    }
        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            Log.d("1","-100");
            getMenuInflater().inflate(R.menu.menu, menu);

            MenuItem myActionMenuItem = menu.findItem(R.id.action_search);
            SearchView searchView = (SearchView)myActionMenuItem.getActionView();
            searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                @Override
                public boolean onQueryTextSubmit(String s) {
                    return false;
                }

                @Override
                public boolean onQueryTextChange(String s) {
                    if (TextUtils.isEmpty(s)){
                        adapter.filter("");
                        listView.clearTextFilter();
                    }
                    else {
                        adapter.filter(s);
                    }
                    return true;
                }
            });
            return true;
        }

        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            int id = item.getItemId();
             Log.d("","result-"+ item);

            if(id == R.id.Profile){
                Intent intent = new Intent(ListMain2Activity.this, NewActivity1.class);
                startActivity(intent);
                return true;                }

            if (id == R.id.action_logout) {
                logout();
                return true;
            }

            return super.onOptionsItemSelected(item);
        }



    private void logout() {
            FirebaseAuth.getInstance().signOut();
            Intent intent = new Intent(ListMain2Activity.this, LoginActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            finish();
        }



    }
