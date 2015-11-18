package org.pltw.examples.collegeapp;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by wdumas on 2/18/2015.
 */
public class GuardianFragment extends Fragment {
    private static final String TAG = "GuardianFragment";
    private static final String FILENAME = "guardian.json";
    private Guardian mGuardian;
    private TextView mFirstName;
    private TextView mLastName;
    private EditText mEnterFirstName;
    private EditText mEnterLastName;
    private GuardianJSONStorer mStorer;
    private Context mAppContext;

    public GuardianFragment() {
        //deliberately empty in conformity to Android conventions.
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAppContext = this.getActivity();
        Log.d(TAG, "Context: " + mAppContext);
        mStorer = new GuardianJSONStorer(mAppContext, FILENAME);
        try {
            mGuardian = mStorer.load();
        } catch (Exception e) {
            mGuardian = new Guardian();
            Log.e(TAG, "Error loading guardian: " + FILENAME, e);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View rootView = inflater.inflate(R.layout.fragment_guardian, container, false);

        mFirstName = (TextView)rootView.findViewById(R.id.first_name);
        mEnterFirstName = (EditText)rootView.findViewById(R.id.enter_first_name);
        mLastName = (TextView)rootView.findViewById(R.id.last_name);
        mEnterLastName = (EditText)rootView.findViewById(R.id.enter_last_name);

        mFirstName.setText(mGuardian.getFirstName());
        mLastName.setText(mGuardian.getLastName());

        FirstNameTextChanger firstNameTextChanger = new FirstNameTextChanger();
        LastNameTextChanger lastNameTextChanger = new LastNameTextChanger();

        mEnterFirstName.addTextChangedListener(firstNameTextChanger);
        mEnterLastName.addTextChangedListener(lastNameTextChanger);

        return rootView;
    }

    private class FirstNameTextChanger implements TextWatcher {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            mGuardian.setFirstName(s.toString());
        }

        @Override
        public void afterTextChanged(Editable s) {
            mFirstName.setText(mGuardian.getFirstName());
        }
    }

    private class LastNameTextChanger implements TextWatcher {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            mGuardian.setLastName(s.toString());
        }

        @Override
        public void afterTextChanged(Editable s) {
            mLastName.setText(mGuardian.getLastName());
        }
    }

    private boolean saveGuardian() {
        try {
            mStorer.save(mGuardian);
            Log.d(TAG, "guardian saved to file.");
            return true;
        } catch (Exception e) {
            Log.e(TAG, "Error saving guardian: ", e);
            return false;
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        saveGuardian();
        Log.d(TAG, "Fragment paused.");
    }

    private void loadGuardian() {
        try {
            mGuardian = mStorer.load();
            Log.d(TAG, "Loaded " + mGuardian.getFirstName());
            mFirstName.setText(mGuardian.getFirstName());
            mLastName.setText(mGuardian.getLastName());
        } catch (Exception e) {
            mGuardian = new Guardian();
            Log.e(TAG, "Error loading guardian from: " + FILENAME, e);
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        loadGuardian();
        Log.d(TAG, "Fragment resumed.");
    }

}
