package uom.team2.weball_statistics.UI_Controller.MatchesOnMainPage.LiveMatches;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import uom.team2.weball_statistics.UIFactory.LayoutFactory;
import uom.team2.weball_statistics.UI_Controller.MatchesOnMainPage.BaseMatchesFragment;
import uom.team2.weball_statistics.databinding.FragmentLiveMatchesBinding;

public class LiveMatches extends BaseMatchesFragment {

    private boolean isAdmin = false;

    public LiveMatches() {
    }

    public static LiveMatches getInstance(Bundle bundle) {
        LiveMatches liveMatches = new LiveMatches();
        liveMatches.setArguments(bundle);
        return liveMatches;
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
    protected FragmentLiveMatchesBinding createBinding(LayoutInflater inflater, ViewGroup container, boolean attachToRoot) {
        return FragmentLiveMatchesBinding.inflate(inflater, container, attachToRoot);
    }

    @Override
    protected ProgressDialog createProgressDialog() {
        return LayoutFactory.createNonCancelableProgressBar(getContext());
    }
}
