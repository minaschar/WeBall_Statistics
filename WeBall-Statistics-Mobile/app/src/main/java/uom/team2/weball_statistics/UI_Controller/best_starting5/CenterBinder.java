package uom.team2.weball_statistics.UI_Controller.best_starting5;

import uom.team2.weball_statistics.databinding.BestPlayerPerPositionLayoutBinding;

public class CenterBinder implements PositionBinder {

    @Override
    public BestPlayerPerPositionLayoutBinding getBinding(BestStarting5 bestStarting5Fragment) {
        return bestStarting5Fragment.getBinding().includeC;
    }
}
