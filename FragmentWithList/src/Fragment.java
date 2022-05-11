package com.example.myapplication7;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.app.ListFragment;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class Fragment extends ListFragment{
    String[] code_name = {"Rijeka", "Opatija", "Lovran", "Ičići", "Crikvenica", "Delnice", "Mtulji", "Kastav", "Rubeši", "Ika"};


        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

            View view = inflater.inflate(R.layout.fragment, container, false);
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(inflater.getContext(), android.R.layout.simple_list_item_1, code_name);
            setListAdapter(adapter);
            return view;

        }

        @Override
        public void onListItemClick(ListView l, View v, int position, long id) {
            Toast.makeText(getActivity().getBaseContext(), code_name[position], Toast.LENGTH_SHORT).show();
        }
    }
