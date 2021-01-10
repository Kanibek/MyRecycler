package kg.andro.myrecycler;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<RecyclerModel> deleteBtn;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.Adapter adapter;

    private static final String COMMON_TAG = "OrientationChange";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(COMMON_TAG, "MainActivity onCreate");
        setContentView(R.layout.activity_main);

        listRecyclerView();
        settingRecyclerView();
        addingItem();

    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE){
            recyclerView.setLayoutManager(new GridLayoutManager(this, newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE ? 4 : 1));
            recyclerView.setItemAnimator(new DefaultItemAnimator());
            Log.i(COMMON_TAG,"landscape");
        }
        else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT){
            recyclerView.setLayoutManager(new GridLayoutManager(this, newConfig.orientation == Configuration.ORIENTATION_PORTRAIT ? 2 : 1));
            recyclerView.setItemAnimator(new DefaultItemAnimator());
            Log.i(COMMON_TAG,"portrait");
        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.i(COMMON_TAG, "MainActivity onSaveInstanceState");
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.i(COMMON_TAG, "MainActivity onSaveInstanceState");
    }

    public void listRecyclerView(){

        deleteBtn = new ArrayList<>();
        deleteBtn.add(new RecyclerModel(R.drawable.ic_delete, getString(R.string.one)));
        deleteBtn.add(new RecyclerModel(R.drawable.ic_delete, getString(R.string.two)));
        deleteBtn.add(new RecyclerModel(R.drawable.ic_delete, getString(R.string.three)));
        deleteBtn.add(new RecyclerModel(R.drawable.ic_delete, getString(R.string.four)));
        deleteBtn.add(new RecyclerModel(R.drawable.ic_delete, getString(R.string.five)));
        deleteBtn.add(new RecyclerModel(R.drawable.ic_delete, getString(R.string.six)));
        deleteBtn.add(new RecyclerModel(R.drawable.ic_delete, getString(R.string.seven)));
        deleteBtn.add(new RecyclerModel(R.drawable.ic_delete, getString(R.string.eight)));
        deleteBtn.add(new RecyclerModel(R.drawable.ic_delete, getString(R.string.nine)));
        deleteBtn.add(new RecyclerModel(R.drawable.ic_delete, getString(R.string.ten)));
        deleteBtn.add(new RecyclerModel(R.drawable.ic_delete, getString(R.string.eleven)));
        deleteBtn.add(new RecyclerModel(R.drawable.ic_delete, getString(R.string.twelve)));
        deleteBtn.add(new RecyclerModel(R.drawable.ic_delete, getString(R.string.thirteen)));
        deleteBtn.add(new RecyclerModel(R.drawable.ic_delete, getString(R.string.fourteen)));
        deleteBtn.add(new RecyclerModel(R.drawable.ic_delete, getString(R.string.fifteen)));
    }

    public void settingRecyclerView(){
        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        adapter = new RecyclerAdapter(deleteBtn);
        adapter.notifyDataSetChanged();

        layoutManager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    public void addingItem() {

        Thread thread = new Thread(){
            @Override
            public void run(){

                while (!isInterrupted()) {
                    try {
                        Thread.sleep(5000);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                deleteBtn.add(new RecyclerModel(R.drawable.ic_delete, getString(R.string.new_Item)));
                                adapter.notifyDataSetChanged();
                                Collections.shuffle(deleteBtn);
                            }
                        });

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        thread.start();
    }
}