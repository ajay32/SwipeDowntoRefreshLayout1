package com.example.macmine.swipedowntorefreshlayout;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

//==============================
// why use need SwipeRefresh layout ...when something is gonna happen after a particular time ..like  when there is time gap ..
// suppose a list is set ...after 2 min of that  ...api gets hit n new list you get .... but it will not gonna set automatically ...on the screen
//so you can use swip refresh layout ....

// or somthing like api hitting on an event ....like there a button n it perfrom some action ...u getting some data ..to get that data display on the screen...you need the screen to be refreshed
//then u need this layout ... you cant use timer n all ..coz ..api not htting automatically ..it get hits on a particualr event..
// ex cricket score app..you can use this ...

//Like in istagram suppose api gets hit after 1 minute n u get new data..but they also gave u the swiperefresh layout that u can use to get images list data by whenever u want...by refersing it u can hit api every second



public class MainActivity extends AppCompatActivity {

    private SwipeRefreshLayout swipeRefreshLayout;
    private ListView listView;

    ArrayList<String> names = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        names.add("AJAY");
        names.add("JEFF");
        names.add("Kevon");
        names.add("meaio");
        names.add("manchu");
        names.add("tanchu");
        names.add("ranchu");
        names.add("lanchu");



        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipeToRefresh);
        listView = (ListView) findViewById(R.id.listView);

        swipeRefreshLayout.setColorSchemeResources(R.color.black);  // set refresh icon color...



        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, names);
        listView.setAdapter(adapter);



        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                shuffle();     // on every refresh shufle the list..
                swipeRefreshLayout.setRefreshing(false);
            }
        });
    }

    public void shuffle(){
        Collections.shuffle(names, new Random(System.currentTimeMillis()));  //shuffle the list .

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, names);  // then again set that list to adapter
        listView.setAdapter(adapter);                                                               // then set it into the listview
    }
}
