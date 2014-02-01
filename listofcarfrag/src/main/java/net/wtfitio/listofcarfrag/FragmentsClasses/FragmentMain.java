package net.wtfitio.listofcarfrag.FragmentsClasses;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import net.wtfitio.listofcarfrag.Adapters.CarsAdapter;
import net.wtfitio.listofcarfrag.Classes.Car;
import net.wtfitio.listofcarfrag.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by plamend on 1/31/14.
 */
public class FragmentMain extends Fragment {
    public interface  MoveExtras_Main_Fragment{
        public void onAdapterCreate(CarsAdapter adapter);
        public void onListItemClick(int position);
    }
    MoveExtras_Main_Fragment move;
    public FragmentMain(){

    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            move = (MoveExtras_Main_Fragment) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement OnArticleSelectedListener");
        }

    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        ListView list = (ListView) rootView.findViewById(R.id.list);
        List<Car> cars;
        CarsAdapter adapter;
        Activity activity = getActivity();
        cars = genCars();
        adapter = new CarsAdapter(activity.getBaseContext(),R.layout.car_list_layout,cars);
        move.onAdapterCreate(adapter);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                move.onListItemClick(i);
            }
        });


        return rootView;
    }
    private List<Car> genCars() {
        List<Car> cars = new ArrayList<Car>();
        Car tm1 = new Car();
        tm1.setName("Pepi");
        tm1.setMake("Ford");
        tm1.setModel("Fiesta");
        tm1.setProdYear("2010");
        tm1.setColor("Green");
        cars.add(tm1);

        Car tm2 = new Car();
        tm2.setName("Pupi");
        tm2.setMake("Suzuki");
        tm2.setModel("Liana");
        tm2.setProdYear("2006");
        tm2.setColor("Blue");
        cars.add(tm2);

        return cars;
    }

}
