package uom.team2.weball_statistics.UI_Controller.MatchesOnMainPage.PreviousMatches;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import uom.team2.weball_statistics.UIFactory.LayoutFactory;
import uom.team2.weball_statistics.UI_Controller.MatchesOnMainPage.BaseMatchesFragment;
import uom.team2.weball_statistics.databinding.FragmentPreviousMatchesBinding;

public class PreviousMatches extends BaseMatchesFragment {

    public PreviousMatches() {
    }

    public static PreviousMatches getInstance(Bundle bundle) {
        PreviousMatches previousMatches = new PreviousMatches();
        previousMatches.setArguments(bundle);

        return previousMatches;
    }

    @Override
    protected FragmentPreviousMatchesBinding createBinding(LayoutInflater inflater, ViewGroup container, boolean attachToRoot) {
        return FragmentPreviousMatchesBinding.inflate(inflater, container, attachToRoot);
    }

    @Override
    protected ProgressDialog createProgressDialog() {
        return LayoutFactory.createNonCancelableProgressBar(getContext());
    }
}
