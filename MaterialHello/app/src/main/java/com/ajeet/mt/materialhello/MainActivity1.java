package com.ajeet.mt.materialhello;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Outline;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.ajeet.mt.controller.PostController;
import com.ajeet.mt.model.Post;
import com.ajeet.mt.util.Common;

import java.util.List;


public class MainActivity1 extends ActionBarActivity {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private static final String MY_DB = "my_db";
    private PostController pc;
    private ActionBarDrawerToggle drawerToggle;
    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private Outline mOutlineCircle;
    private ListView leftDrawerList;
    private ArrayAdapter<String> navigationDrawerAdapter;
    private String[] leftSliderData = {"Home", "Android", "Sitemap", "About", "Contact Me"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        nitView();
        if (toolbar != null) {
           // toolbar.setTitle("Navigation Drawer");
            setSupportActionBar(toolbar);
        }

        

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

        setAdapter();
        initDrawer();

    }

    private void nitView() {
        leftDrawerList = (ListView) findViewById(R.id.left_drawer);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        navigationDrawerAdapter=new ArrayAdapter<String>( MainActivity1.this, android.R.layout.simple_list_item_1, leftSliderData);
        leftDrawerList.setAdapter(navigationDrawerAdapter);
    }

    private void initDrawer() {
        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.drawer_open, R.string.drawer_close) {

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);

            }

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);

            }
        };
        drawerLayout.setDrawerListener(drawerToggle);
        }
    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        drawerToggle.syncState();
    }


    private void setAdapter() {
        pc = new PostController(MainActivity1.this);
        List<Post> listPost = pc.getAllPost();
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        // specify an adapter (see also next example)
        mAdapter = new MyAdapter(listPost, R.layout.row_country, this);
        mRecyclerView.setAdapter(mAdapter);
    }


    public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

        private List<Post> posts;
        private int rowLayout;
        private Context mContext;
        private int counter = 0;
        private int position = 0;
        Post p;
        private PostController postController;

        public MyAdapter(List<Post> posts, int rowLayout, Context context) {
            this.posts = posts;
            this.rowLayout = rowLayout;
            this.mContext = context;

        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup viewGroup, final int i) {
            View v = LayoutInflater.from(viewGroup.getContext()).inflate(rowLayout, viewGroup, false);
            return new ViewHolder(v);
        }


        @Override
        public void onBindViewHolder(final ViewHolder viewHolder, final int i) {

            position = i;
            final ViewHolder  vh = viewHolder;

            p = posts.get(i);
            vh.userName.setText(p.getPostedBy());
            vh.postString.setText(p.getPostText());
            vh.createdDateString.setText(Common.getDifferenceBetweenDate(p.getCreatedDate(), Common.getCurrentLocalDateTime()));
           // vh.noOfLikes.setText(p.getLikes() + "");


            viewHolder.likebutton.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    /// button click event
                    counter++;
                    System.out.println("position::" + i);
                    vh.noOfLikes.setText(counter+"");



                   /* PostController postController = new PostController(MainActivity1.this);
                    boolean isRightBuild = postController.updateTask(position, counter);
                    if (isRightBuild) {
                        p.setLikes(counter);
                        v.setTag(p);
                        mAdapter.notifyDataSetChanged();
                        mRecyclerView.invalidate();
                    }
*/
                    //Toast.makeText(MainActivity1.this,"count"+counter, Toast.LENGTH_LONG).show();
                }
            });
            //counter = p.getLikes();

        }

        @Override
        public int getItemCount() {
            return posts == null ? 0 : posts.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            public TextView userName, postString, createdDateString, noOfLikes, likebutton;
            // public Button likebutton;
            public RelativeLayout countryImage;

            public ViewHolder(View itemView) {
                super(itemView);
                userName = (TextView) itemView.findViewById(R.id.userName);
                postString = (TextView) itemView.findViewById(R.id.dataTxt);
                noOfLikes = (TextView) itemView.findViewById(R.id.likeCountTxt);
                countryImage = (RelativeLayout) itemView.findViewById(R.id.letterImage);
                createdDateString = (TextView) itemView.findViewById(R.id.timeStamp);
                likebutton = (TextView) itemView.findViewById(R.id.like_icon);

               /* int size = getResources().getDimensionPixelSize(R.dimen.fab_size);
                Outline outline = new Outline();
                outline.setOval(0, 0, size, size);*/
                //outline.setOval(0, 0, size, size);
                noOfLikes.setTag(position);
                /*likebutton.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        // TODO Auto-generated method stub
                        //int count = Integer.parseInt(noOfLikes.toString());
                        counter++;

                        Toast.makeText(MainActivity1.this,"count"+counter, Toast.LENGTH_LONG).show();

                        *//*PostController postController = new PostController(MainActivity1.this);
                        boolean isRightBuild = postController.updateTask(position, counter);
                        if (isRightBuild) {
                            p.setLikes(counter);
                            v.setTag(p);
                            mAdapter.notifyDataSetChanged();
                            mRecyclerView.invalidate();
                        }*//*


                    }
                });*/


            }

        }
    }






















    ///option menu code
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
