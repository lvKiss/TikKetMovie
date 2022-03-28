package com.example.ticketmovie.movieapp.fragments;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.ticketmovie.movieapp.activities.ListMovieActivity;
import com.example.ticketmovie.movieapp.activities.MovieDetailActivity;


//public class ViewPagerAdapter extends FragmentStatePagerAdapter {
//    public ViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
//        super(fm, behavior);
//    }
//
//    @NonNull
//    @Override
//    public Fragment getItem(int position) {
//        switch (position){
//            case 0:
//                return new ListMovieActivity();
//            case 1:
//                return new InformationMovieFragment();
//            default:
//                return new ListMovieActivity();
//        }
//
//    }
//
//    @Override
//    public int getCount() {
//        return 2;
//    }
//
//    @Nullable
//    @Override
//    public CharSequence getPageTitle(int position) {
//        switch (position){
//            case 0:
//                return "Phim";
//            case 1:
//                return "Thông tin";
//            default:
//                return "Phim";
//        }
//    }
//}