package uom.team2.weball_statistics.UI_Controller.MatchesOnMainPage.UpcomingMatches;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

import uom.team2.weball_statistics.Model.Match;
import uom.team2.weball_statistics.R;
import uom.team2.weball_statistics.UIFactory.LayoutFactory;
import uom.team2.weball_statistics.UI_Controller.MatchesOnMainPage.BaseMatchesFragment;
import uom.team2.weball_statistics.databinding.FragmentUpcomingMatchesBinding;

public class UpcomingMatches extends BaseMatchesFragment {

    private boolean isAdmin = false;

    public UpcomingMatches() {}

    public static UpcomingMatches getInstance(Bundle bundle) {
        UpcomingMatches upcomingMatches = new UpcomingMatches();
        upcomingMatches.setArguments(bundle);
        return upcomingMatches;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Bundle bundle = getArguments();
        isAdmin = bundle.getBoolean("isAdmin");
        progressDialog = LayoutFactory.createNonCancelableProgressBar(getContext());
        if (binding != null) {
            binding.getRoot().setVisibility(View.INVISIBLE);
            progressDialog.show();
        }
    }

    @Override
    protected FragmentUpcomingMatchesBinding createBinding(LayoutInflater inflater, ViewGroup container, boolean attachToRoot) {
        return FragmentUpcomingMatchesBinding.inflate(inflater, container, attachToRoot);
    }

    @Override
    protected ProgressDialog createProgressDialog() {
        return LayoutFactory.createNonCancelableProgressBar(getContext());
    }
}
