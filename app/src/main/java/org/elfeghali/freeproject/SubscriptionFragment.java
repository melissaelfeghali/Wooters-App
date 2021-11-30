package org.elfeghali.freeproject;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import android.os.Bundle;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class SubscriptionFragment extends Fragment {

    public static final String CHANNEL_ID = "WOOTERS_CHANNEL";
    int notificationId = 3210;

    public SubscriptionFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_subscription, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();

        View view = getView();
        Button subscribe = view.findViewById(R.id.subscribe_button);
        TextView textView = view.findViewById(R.id.subscription_complete);

        subscribe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                NotificationCompat.Builder builder = new NotificationCompat.Builder(getContext(), CHANNEL_ID)
                        .setSmallIcon(R.drawable.logo)
                        .setContentTitle("WOOTERS")
                        .setContentText("Welcome to WOOTERS newsletters! Let the adventure begin...")
                        .setPriority(NotificationCompat.PRIORITY_DEFAULT);

                NotificationManagerCompat notificationManager = NotificationManagerCompat.from(getContext());
                notificationManager.notify(notificationId, builder.build());

//                textView.setText("You have successfully subscribed to Wooters Newsletter !");
            }
        });
    }
}