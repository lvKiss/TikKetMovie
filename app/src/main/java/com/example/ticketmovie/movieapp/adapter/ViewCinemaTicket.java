package com.example.ticketmovie.movieapp.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.ticketmovie.movieapp.activities.ProfileActivity;
import com.example.ticketmovie.movieapp.activities.ListLuuVeActivity;
import com.example.ticketmovie.movieapp.activities.ListMovieActivity;

public class ViewCinemaTicket extends FragmentStatePagerAdapter {
    public ViewCinemaTicket(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:

                return new ListMovieActivity();
            case 1:
                return new ListLuuVeActivity();
            case 2:
                return new ProfileActivity();
            default:
                return new ListMovieActivity();
        }

    }

    @Override
    public int getCount() {
        return 3;
    }
}
