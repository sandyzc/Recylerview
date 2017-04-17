package chinna.sandyz.com.recylerview;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private Palette mPalette;
    private Toolbar toolbar;
    private RecylerAdapter adapter;
    final String[] names = {"Alpha","Beta","Cupcake","Donut","Eclairs","Froyo","Gingerbread","HoneyComb","IceCreamSandwich","jellybean","kitkat","Lolipop","Marshmallow","Naugat"};
    private RecyclerView rv;
    int color;
    private FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rv=(RecyclerView)findViewById(R.id.Recycle);
        fab =(FloatingActionButton)findViewById(R.id.fab);

        toolbar = (Toolbar)findViewById(R.id.toolbar);
//        if (toolbar != null){
//            setSupportActionBar(toolbar);
//
//        }
        getPhoto();
        getSupportActionBar().setTitle("Android Versions");
        color = ContextCompat.getColor(getApplicationContext(),android.R.color.holo_green_light);

        rv.setHasFixedSize(true);
        adapter = new RecylerAdapter(names);
        rv.setAdapter(adapter);
        rv.setLayoutManager(new LinearLayoutManager(this));



            }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if (id==R.id.add){
            Snackbar.make(getCurrentFocus(),"clicked on add",Snackbar.LENGTH_LONG).show();
        }
        if (id==R.id.delete){
            Toast.makeText(getApplicationContext(),"Clicked on delete",Toast.LENGTH_SHORT).show();
        }
        if (id==R.id.app_bar_search){
            Toast.makeText(getApplicationContext(),"Clicked on search",Toast.LENGTH_SHORT).show();
        }
        if (id==R.id.settings){
            Toast.makeText(getApplicationContext(),"Clicked on settings",Toast.LENGTH_SHORT).show();
        }


        return super.onOptionsItemSelected(item);
    }


    private void getPhoto() {
        Bitmap photo = BitmapFactory.decodeResource(getResources(),R.drawable.ic_delete);
        colorize(photo);
    }

    private void colorize(Bitmap photo) {
        mPalette = Palette.generate(photo);
        applyPalette();
    }

    private void applyPalette() {
        getWindow().setBackgroundDrawable(new ColorDrawable(mPalette.getDarkMutedColor(color)));
        rv.setBackgroundColor(mPalette.getLightVibrantColor(color));
        toolbar.setBackgroundColor(mPalette.getLightVibrantColor(color));


    }
}
