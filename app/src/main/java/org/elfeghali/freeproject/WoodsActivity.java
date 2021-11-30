package org.elfeghali.freeproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class WoodsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_woods);

        Toolbar toolbar = findViewById(R.id.toolbar_woods);
        setSupportActionBar(toolbar);

        WoodsFragment woodsFragment = new WoodsFragment();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.fragment_container_woods, woodsFragment);
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
            ft.replace(R.id.fragment_container_woods, bookmarksFragment);
            ft.addToBackStack(null);
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            ft.commit();
            return true;

        } else if (item.getItemId() == R.id.action_subscribe) {
            SubscriptionFragment subscriptionFragment = new SubscriptionFragment();
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.fragment_container_woods, subscriptionFragment);
            ft.addToBackStack(null);
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            ft.commit();
            return true;

        } else { return super.onOptionsItemSelected(item); }
    }
}