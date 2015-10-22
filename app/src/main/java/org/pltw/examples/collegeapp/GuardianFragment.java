package org.pltw.examples.collegeapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;


public class GuardianFragment extends Fragment {
    private static final String TAG = "GuardianFragment";
    private Profile mProfile;

    private TextView mFirstName;
    private EditText mEnterFirstName;
    private TextView mLastName;
    private EditText mEnterLastName;
    private EditText occupation;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View rootView = inflater.inflate(R.layout.fragment_guardian, container,
                false);
        mProfile = new Profile("Anne", "Bryon");

        mFirstName = (TextView)rootView.findViewById(R.id.first_name);
        mEnterFirstName =
                (EditText)rootView.findViewById(R.id.enter_first_name);
        occupation =
                (EditText)rootView.findViewById(R.id.editText);

        mFirstName.setText(mProfile.getFirstName());

        FirstNameTextChanger firstNameTextChanger = new FirstNameTextChanger();

        mEnterFirstName.addTextChangedListener(firstNameTextChanger);
//last name
        mLastName = (TextView)rootView.findViewById(R.id.last_name);
        mEnterLastName =
                (EditText)rootView.findViewById(R.id.enter_last_name);

        mLastName.setText(mProfile.getLastName());

        LastNameTextChanger lastNameTextChanger = new LastNameTextChanger();

        mEnterLastName.addTextChangedListener(lastNameTextChanger);

        return rootView;
    }

    private class FirstNameTextChanger implements TextWatcher {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int
                after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int
                count) {
            mProfile.setFirstName(s.toString());
        }

        @Override
        public void afterTextChanged(Editable s) {
            mFirstName.setText(mProfile.getFirstName());
        }
    }

    private class LastNameTextChanger implements TextWatcher {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int
                after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int
                count) {
            mProfile.setLastName(s.toString());
        }

        @Override
        public void afterTextChanged(Editable s) {
            mLastName.setText(mProfile.getLastName());
        }
    }

}