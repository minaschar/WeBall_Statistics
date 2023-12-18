package uom.team2.weball_statistics.UI_Controller.best_starting5;

import uom.team2.weball_statistics.R;

public enum TeamColor {

    ATLANTA_HAWKS(R.color.Hawks),
    BROOKLYN_NETS(R.color.Nets),
    BOSTON_CELTICS(R.color.Celtics),
    CLEVELAND_CAVALIERS(R.color.Cavaliers),
    DALLAS_MAVERICKS(R.color.Mavericks),
    CHARLOTTE_HORNETS(R.color.Hornets),
    CHICAGO_BULLS(R.color.Bulls),
    DENVER_NUGGETS(R.color.Nuggets),
    DEFAULT_COLOR(R.color.other);

    private final int colorResourceId;

    TeamColor(int colorResourceId) {
        this.colorResourceId = colorResourceId;
    }

    public int getColorResourceId() {
        return colorResourceId;
    }
}
