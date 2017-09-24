package com.example.darren.q1;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class fragment extends Fragment {

    public View onCreateView(LayoutInflater inflater,
                             ViewGroup vg, Bundle bundle) {
        return inflater.inflate(R.layout.fragment_, vg, false);
    }

    public void onActivityCreated(Bundle savedState)
    {
        super.onActivityCreated(savedState);
    }
}
