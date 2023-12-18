package uom.team2.weball_statistics.UI_Controller.best_starting5;

import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.json.JSONException;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import uom.team2.weball_statistics.Model.Player;
import uom.team2.weball_statistics.Model.Team;
import uom.team2.weball_statistics.R;
import uom.team2.weball_statistics.configuration.Config;
import uom.team2.weball_statistics.databinding.BestPlayerPerPositionLayoutBinding;
import uom.team2.weball_statistics.utils.JSONHandler;
import uom.team2.weball_statistics.utils.Utils;


/*
 * @author Charakopoulos Minas Theodoros mai24054
 */
public class BestStarting5UIController {

    public static BestStarting5UIController instance = new BestStarting5UIController();

    //Implement singleton pattern
    public static BestStarting5UIController getInstance(){
        if(instance == null){
            instance = new BestStarting5UIController();
        }
        return instance;
    }

    public void fillBestPlayerInfo(Player player, BestStarting5 bestStarting5Fragment, PositionBinder position)
            throws IOException, JSONException {
        BestPlayerPerPositionLayoutBinding bestPlayerPerPositionLayoutBinding = position.getBinding(bestStarting5Fragment);

        if (bestPlayerPerPositionLayoutBinding != null) {
            setPlayerInfo(player, bestStarting5Fragment, bestPlayerPerPositionLayoutBinding, position.getClass().getSimpleName());
        }
    }

    private void setPlayerInfo(Player player, BestStarting5 bestStarting5Fragment,
                               BestPlayerPerPositionLayoutBinding binding, String position)
            throws IOException, JSONException {

        binding.background.setBackgroundColor(Utils.getColor(bestStarting5Fragment.getContext(), getColorByTeam(player.getTeamString())));

        ImageView imageViewTeamLogo = binding.logoImage;
        ImageView imageViewPlayerPhoto = binding.playerImage;
        TextView textViewPlayerInfo = binding.cityTeamNumberPosition;
        TextView textViewPlayerName = binding.firstnameLastname;
        TextView textViewEfValue = binding.efficiencyValue;

        textViewPlayerInfo.setText(player.getTeamString() + " | #" + player.getNumber() + " | " + position);
        textViewPlayerName.setText(player.getName() + " " + player.getSurname());
        textViewEfValue.setText("+ " + player.getEfficiency());

        if (!"NOT FOUND".equals(player.getSurname())) {
            loadPlayerImage(player, imageViewPlayerPhoto);
            loadTeamLogo(player, imageViewTeamLogo);
        }
    }

    private void loadPlayerImage(Player player, ImageView imageViewPlayerPhoto) {
        Picasso.get()
                .load(Config.PLAYER_IMAGES_RESOURCES + player.getImagePath())
                .resize(250, 400)
                .centerCrop()
                .into(imageViewPlayerPhoto);
    }

    private void loadTeamLogo(Player player, ImageView imageViewTeamLogo) throws IOException, JSONException {
        OkHttpClient client = new OkHttpClient().newBuilder().build();
        Request request = new Request.Builder()
                .url(Config.API_URL + "team.php?name=" + player.getTeamString())
                .method("GET", null)
                .addHeader("Content-Type", "application/json")
                .build();
        Response response = client.newCall(request).execute();
        Team myTeam = JSONHandler.deserializeTeam(response.body().string());

        Picasso.get()
                .load(Config.TEAM_IMAGES_RESOURCES + myTeam.getBadgePath())
                .resize(250, 400)
                .centerCrop()
                .into(imageViewTeamLogo);
    }

    private int getColorByTeam(String team) {
        try {
            TeamColor teamColor = TeamColor.valueOf(team.toUpperCase().replace(" ", "_"));
            return teamColor.getColorResourceId();
        } catch (IllegalArgumentException e) {
            return TeamColor.DEFAULT_COLOR.getColorResourceId();
        }
    }
}
