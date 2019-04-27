package com.example.episodates.view.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;

import com.example.episodates.R;

public class SearchSerieFragment extends Fragment implements View.OnClickListener {

    public EditText ETNameSerie;
    public Button btnSearchSerie;

    ResultSerieFragment searchedSerieFragment;
    Bundle bundle = new Bundle();


    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View v = inflater.inflate(R.layout.search_serie_fragment, container, false);

        ETNameSerie = v.findViewById(R.id.input_name_serie);

        btnSearchSerie = v.findViewById(R.id.btnSearchSerie);
        btnSearchSerie.setOnClickListener(this);

        return v;
    }

    public void onClick(View v) {
        if (v.getId() == R.id.btnSearchSerie && !ETNameSerie.getText().toString().equals("")) {
            searchedSerieFragment = ResultSerieFragment.newInstance();
            bundle.putString("nameSerie", ETNameSerie.getText().toString());
            searchedSerieFragment.setArguments(bundle);
            ETNameSerie.onEditorAction(EditorInfo.IME_ACTION_DONE);

            getChildFragmentManager().beginTransaction().replace(R.id.searchedSerieFragment, searchedSerieFragment).commit();
        }
    }

    // Affichage du menu
    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    // Écouteur sur le menu
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // L’item sur lequel l’utilisateur a cliqué
        int id = item.getItemId();
        // Afficher le fragment des préférences
        if (id == R.id.pref) {
            Intent intent = new Intent(this, SettingsActivity.class);
            startActivity(intent);
            overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }*/
}