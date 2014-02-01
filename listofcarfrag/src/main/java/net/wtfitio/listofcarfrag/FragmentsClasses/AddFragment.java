package net.wtfitio.listofcarfrag.FragmentsClasses;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by plamend on 2/1/14.
 */
public class AddFragment extends Fragment {
    public interface MoveExtras {

    }
    MoveExtras move;
    public AddFragment(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
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
