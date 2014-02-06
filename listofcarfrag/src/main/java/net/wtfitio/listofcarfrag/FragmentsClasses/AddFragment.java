package net.wtfitio.listofcarfrag.FragmentsClasses;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import net.wtfitio.listofcarfrag.Classes.Car;
import net.wtfitio.listofcarfrag.R;

/**
 * Created by plamend on 2/1/14.
 */
public class AddFragment extends Fragment {
    public interface MoveExtras {
       public void OnCarCreate(Car car);

    }
    MoveExtras move;
    public AddFragment(){

    }
    EditText name_imput;
    EditText model_imput;
    EditText make_imput;
    EditText prod_year;
    EditText col;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_add,container,false);
        this.name_imput = (EditText)rootView.findViewById(R.id.car_name_input);
        this.make_imput = (EditText)rootView.findViewById(R.id.car_make_input);
        this.model_imput = (EditText)rootView.findViewById(R.id.car_model_input);
        this.prod_year = (EditText)rootView.findViewById(R.id.car_prod_year_input);
        this.col = (EditText)rootView.findViewById(R.id.car_color_input);
        Button add = (Button)rootView.findViewById(R.id.add_butoon);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name=name_imput.getText().toString();
                String make=make_imput.getText().toString();
                String model=model_imput.getText().toString();
                String p_year=prod_year.getText().toString();
                String color=col.getText().toString();

                if (!name.equals("")&&!make.equals("")&&!model.equals("")&&!p_year.equals("")&&!color.equals("")){
                  Car car = new Car();
                    car.setName(name);
                    car.setMake(make);
                    car.setModel(model);
                    car.setProdYear(p_year);
                    car.setColor(color);
                    move.OnCarCreate(car);

                }
                else{
                    ShowMessage("All info is mandatory");
                }

            }

        });

        return rootView;
    }

    private void ShowMessage(String message) {
        Toast.makeText(getActivity().getBaseContext(), message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            move = (MoveExtras) activity;
        }
        catch (ClassCastException e){
            throw new ClassCastException(activity.toString() + " must implement OnArticleSelectedListener");
        }



    }
}
