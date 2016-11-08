package edu.uml.android.adventurersarchive;

import android.content.Intent;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.uml.android.adventurersarchive.character.CharacterInfo;
import edu.uml.android.adventurersarchive.info.Spell;

/**
 * Created by Darin on 11/6/2016.
 */
public class CharacterSpellbookActivity extends AppCompatActivity {
    private CharacterInfo myCharacter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_spellbook);

        Intent intent = getIntent();

        myCharacter = (CharacterInfo) intent.getParcelableExtra("character");
        setTitle(myCharacter.getCharacterName());

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        SpellbookTabAdapter adapter = new SpellbookTabAdapter(this, myCharacter, getSupportFragmentManager());

        viewPager.setAdapter(adapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
    }
}