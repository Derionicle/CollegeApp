package org.pltw.examples.collegeapp;

public class Profile {
    private String mFirstName;
    private String mLastName;

    public String getFirstName() {
        return mFirstName;
    }

    public void setFirstName(String firstName) {
        mFirstName = firstName;
    }

    public String getLastName() {
        return mLastName;
    }

    public void setLastName(String lastName) {
        mLastName = lastName;
    }
    Profile(String fn, String ln) {
        mFirstName = fn;
        mLastName = ln;
    }
}