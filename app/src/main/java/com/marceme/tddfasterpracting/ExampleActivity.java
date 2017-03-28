package com.marceme.tddfasterpracting;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import com.marceme.tddfasterpracting.datamanager.PixabayAPIService;
import com.marceme.tddfasterpracting.datamanager.PixabayAPIServiceFactory;
import com.marceme.tddfasterpracting.datamanager.PixabayDataManager;
import com.marceme.tddfasterpracting.imageui.ImagesPresenter;





// Image activty
public class ExampleActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private ImagesPresenter mPresenter;
    private ProgressBar mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example);

        // Setup recyclerview
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        // Setup presenter, inject data manager, and api service
        mPresenter = new ImagesPresenter(new PixabayDataManager(PixabayAPIServiceFactory.makeImageApiService()));

        // Setup Progress bar
        mProgressBar = (ProgressBar) findViewById(R.id.progress);

        // reference to send message
        final Button sendMessageButton = (Button) findViewById(R.id.button);

        // send message button click listener
        sendMessageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendMessage();
            }
        });
    }





    private void sendMessage() {

    }


}
