package com.example.tp3;

import android.os.Bundle;

import com.example.tp3.adapter.WordListAdapter;
import com.example.tp3.data.dataSource;
import com.example.tp3.model.Word;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;



import com.example.tp3.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {


    private ActivityMainBinding binding;
    private WordListAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setSupportActionBar(binding.toolbar);
        dataSource mDataSource = new dataSource();
        LinkedList<Word> mWordList = mDataSource.loadWords();
        mAdapter = new WordListAdapter(mWordList);
        binding.contentMain.recyclerview.setAdapter(mAdapter);
        binding.contentMain.recyclerview.setHasFixedSize(true);
        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int wordListSize = mWordList.size();

                // Ajoutez un nouveau mot à la liste de mots.
                mWordList.addLast(new Word("+ Word " + wordListSize));

                // Notifiez l'adaptateur qu'une nouvelle donnée a été insérée.
                binding.contentMain.recyclerview.getAdapter().notifyItemInserted(wordListSize);

                // Faites défiler jusqu'en bas
                binding.contentMain.recyclerview.smoothScrollToPosition(wordListSize);

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}