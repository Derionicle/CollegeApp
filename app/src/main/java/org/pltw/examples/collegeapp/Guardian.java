package org.pltw.examples.collegeapp;

public class Guardian {
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
    Guardian(String fn, String ln) {
        mFirstName = fn;
        mLastName = ln;
    }
}