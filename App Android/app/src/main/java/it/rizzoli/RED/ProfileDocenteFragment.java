package it.rizzoli.RED;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;


public class ProfileDocenteFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile_docente, container, false);

        // CODICE PER L'ANIMAZIONE DI BACKGROUNG
        DrawerLayout drawerLayout = view.findViewById(R.id.my_drawer_layout);
        AnimationDrawable animationDrawable = (AnimationDrawable) drawerLayout.getBackground();
        animationDrawable.setEnterFadeDuration(5000);
        animationDrawable.setExitFadeDuration(5000);
        animationDrawable.start();


        return view;
    }
}