package net.wtfitio.listofcarfrag;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.Toast;

import net.wtfitio.listofcarfrag.Adapters.CarsAdapter;
import net.wtfitio.listofcarfrag.Classes.Car;
import net.wtfitio.listofcarfrag.FragmentsClasses.AddFragment;
import net.wtfitio.listofcarfrag.FragmentsClasses.FragmentMain;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends ActionBarActivity implements  FragmentMain.MoveExtras_Main_Fragment,AddFragment.MoveExtras{

    CarsAdapter adapter=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new FragmentMain())
                    .commit();

        }
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
            switch (id){
                case R.id.action_settings:

                case R.id.action_add_car:
                    createCar();
                    return true;
            }
        return super.onOptionsItemSelected(item);
    }

    private void createCar() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container,new AddFragment())
                .addToBackStack(null).commit();


    }


    @Override
    public void onAdapterCreate(CarsAdapter adapter) {
        this.adapter=adapter;
    }

    @Override
    public void onListItemClick(int position) {

       Car car =  this.adapter.getItem(position);
        Toast.makeText(this,car.getModel(),Toast.LENGTH_SHORT).show();
    }

    @Override
    public void OnCarCreate(Car car) {
        adapter.add(car);
        FragmentMain frag_main = FragmentMain.getInstance(adapter);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container,frag_main)
                .commit();
    }
}
