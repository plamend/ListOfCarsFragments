package net.wtfitio.listofcarfrag.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import net.wtfitio.listofcarfrag.Classes.Car;
import net.wtfitio.listofcarfrag.FragmentsClasses.FragmentMain;
import net.wtfitio.listofcarfrag.R;

import java.util.List;

/**
 * Created by plamend on 1/31/14.
 */
public class CarsAdapter extends ArrayAdapter<Car> {
    public CarsAdapter(Context context, int resource, List<Car> objects) {
        super(context, resource, objects);
    }

    @Override
    public Car getItem(int position) {
        return super.getItem(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView==null){

            Context context = getContext();
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.car_list_layout,parent,false);

            CarViewHolder holder = InitilizeHolder(convertView);
            convertView.setTag(holder);


        }
        Car car = getItem(position);
        CarViewHolder holder = (CarViewHolder) convertView.getTag();

        String name = car.getName();
        holder.Name.setText(name);

        String make = car.getMake();
        holder.Make.setText(make);

        String model = car.getModel();
        holder.Model.setText(model);

        String year = car.getProdYear();
        holder.prodYear.setText(year);

        String color = car.getColor();
        holder.Color.setText(color);


        return convertView;
    }

    private CarViewHolder InitilizeHolder(View convertView) {
        CarViewHolder car = new CarViewHolder();
        car.Name = (TextView)convertView.findViewById(R.id.list_car_name);
        car.Make = (TextView)convertView.findViewById(R.id.list_car_make);
        car.Model = (TextView)convertView.findViewById(R.id.list_car_model);
        car.prodYear = (TextView)convertView.findViewById(R.id.list_car_prod_year);
        car.Color = (TextView)convertView.findViewById(R.id.list_car_color);
        return car;
    }


    private class CarViewHolder {
        private TextView Name;
        private TextView Make;
        private TextView Model;
        private TextView prodYear;
        private TextView Color;

    }
}
