package org.elfeghali.freeproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class WatersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_waters);

        Toolbar toolbar = findViewById(R.id.toolbar_waters);
        setSupportActionBar(toolbar);

        WatersFragment watersFragment = new WatersFragment();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.fragment_container_waters, watersFragment);
        ft.addToBackStack(null);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        ft.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        // Get back to home page when home icon clicked in action bar
        if (item.getItemId() == R.id.action_home) {
            Intent home_intent = new Intent(this, MainActivity.class);
            startActivity(home_intent);
            return true;

        } else if (item.getItemId() == R.id.action_bookmarks) {
            BookmarksFragment bookmarksFragment = new BookmarksFragment();
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.fragment_container_waters, bookmarksFragment);
            ft.addToBackStack(null);
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            ft.commit();
            return true;

        } else if (item.getItemId() == R.id.action_subscribe) {
            SubscriptionFragment subscriptionFragment = new SubscriptionFragment();
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.fragment_container_waters, subscriptionFragment);
            ft.addToBackStack(null);
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            ft.commit();
            return true;

        } else { return super.onOptionsItemSelected(item); }
    }

    public void onClick(View view)
    {
        SelectedWaterFragment selectedWaterFragment = new SelectedWaterFragment();

        if (view.getId() == R.id.image_button_baatara) {
            selectedWaterFragment.setName("Baatara Waterfalls");

        } else if (view.getId() == R.id.image_button_kfarhelda) {
            selectedWaterFragment.setName("Kfarhelda Waterfall");

        } else if (view.getId() == R.id.image_button_jezzine) {
            selectedWaterFragment.setName("Jezzine Waterfall");

        } else if (view.getId() == R.id.image_button_afqa) {
            selectedWaterFragment.setName("Afqa Waterfall");

        } else if (view.getId() == R.id.image_button_chouwen) {
            selectedWaterFragment.setName("Chouwen Lake");

        } else if (view.getId() == R.id.image_button_nahr_jahliye) {
            selectedWaterFragment.setName("Nahr El Jahliye");

        } else if (view.getId() == R.id.image_button_baakline) {
            selectedWaterFragment.setName("Atika Waterfall");

        } else if (view.getId() == R.id.image_button_atika) {
            selectedWaterFragment.setName("Qannoubine Waterfalls");

        } else if (view.getId() == R.id.image_button_qannoubine) {
            selectedWaterFragment.setName("Baakline Waterfall");

        } else if (view.getId() == R.id.image_button_serjbel) {
            selectedWaterFragment.setName("Serjbel Waterfall");

        } else if (view.getId() == R.id.image_button_akoura) {
            selectedWaterFragment.setName("Akoura Waterfall");

        } else {
            selectedWaterFragment.setName("Assi River");
        }

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.fragment_container_waters, selectedWaterFragment);
        ft.addToBackStack(null);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        ft.commit();

    }
}