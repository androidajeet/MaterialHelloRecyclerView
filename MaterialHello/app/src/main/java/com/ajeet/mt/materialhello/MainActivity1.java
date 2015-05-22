package com.ajeet.mt.materialhello;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.ajeet.mt.controller.PostController;
import com.ajeet.mt.model.Post;

import java.util.List;


public class MainActivity1 extends ActionBarActivity {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private static final String MY_DB = "my_db";
    private PostController pc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SharedPreferences sp = getSharedPreferences(MY_DB, Context.MODE_PRIVATE);
        boolean hasVisited = sp.getBoolean("hasVisited", false);
        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

        if (!hasVisited) {

            PostController postController = new PostController(MainActivity1.this);
            postController.addNewPost(new Post("At which lux level do the Nikon 1 cameras switch from PDAF to contrast-detection?", "Ajeet"));
            postController.addNewPost(new Post("How do I photograph a landscape with a solar eclipse where the sun is not the main subject?", "Abhishek"));
            postController.addNewPost(new Post("How can I adjust the colour temperature of an image programmatically?", "Mukesh kumar"));
            postController.addNewPost(new Post("Which portfolio hosting services offer swipe navigation on mobile devices?", "Ravi"));
            postController.addNewPost(new Post("Will an EMF AF Confirm M42 Lens To Canon EOS adapter actually confirm with the Helios 44-2 58mm f/2?", "Kushagra"));
            postController.addNewPost(new Post("What exactly is base ISO and how do I find what is base ISO on my camera?", "Devika Mehta"));
            postController.addNewPost(new Post("How can I light a staged showroom interior, where there is no ceiling to bounce light from?", "Aruna Yadav"));
            postController.addNewPost(new Post("Nikon D5100 Press Shutter Release Button Again error, but fixing itself after left alone for a while", "Vivek Mishra"));
            postController.addNewPost(new Post("How do I measure the correlated color temperature of a light source with a DSLR without a gray card?", "Neetu"));
            postController.addNewPost(new Post("How do I get a two person portrait with the background blurred using a DSLR and 50mm f/1.8 lens?", "Divya"));

            SharedPreferences.Editor e = sp.edit();
            e.putBoolean("hasVisited", true);
            e.commit();
        }
        /*ArrayList<String> myDataset = new ArrayList<String>();
        myDataset.add("Item1");
        myDataset.add("Item2");
        myDataset.add(2, "Item3"); // it will add Item3 to the third position of
        // array list
        myDataset.add("Item4");
        myDataset.add("Item5");
        myDataset.add("Item6");
        myDataset.add("Item7");
        myDataset.add("Item8");
        myDataset.add("Item9");
        myDataset.add("Item10");
        myDataset.add("Item11");
        myDataset.add("Item12");*/
        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView

        pc = new PostController(MainActivity1.this);
        List<Post> listPost = pc.getAllPost();
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        // specify an adapter (see also next example)
        mAdapter = new MyAdapter(listPost, MainActivity1.this);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
