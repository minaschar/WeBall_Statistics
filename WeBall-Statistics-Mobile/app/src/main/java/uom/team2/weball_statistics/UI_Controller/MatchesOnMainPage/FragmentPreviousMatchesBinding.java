package uom.team2.weball_statistics.UI_Controller.MatchesOnMainPage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class FragmentPreviousMatchesBinding implements MatchBinding {

    private View rootView;

    private FragmentPreviousMatchesBinding(View rootView) {
        this.rootView = rootView;
    }

    // Factory method to create an instance of FragmentLiveMatchesBinding
    public static FragmentPreviousMatchesBinding inflate(LayoutInflater inflater, ViewGroup container, boolean attachToRoot) {
        // Use the generated inflate method from ViewBinding
        return new FragmentPreviousMatchesBinding(FragmentLiveMatchesBinding.inflate(inflater, container, attachToRoot).getRoot());
    }

    @Override
    public View getRoot() {
        return rootView;
    }
}
