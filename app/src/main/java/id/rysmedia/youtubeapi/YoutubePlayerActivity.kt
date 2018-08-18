package id.rysmedia.youtubeapi

import android.os.Bundle
import android.widget.Toast
import com.google.android.youtube.player.YouTubeBaseActivity
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer
import kotlinx.android.synthetic.main.activity_main.*


class YoutubePlayerActivity : YouTubeBaseActivity(), YouTubePlayer.OnInitializedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        youtubePlayer.initialize(resources.getString(R.string.api_key), this)
    }

    override fun onInitializationFailure(provider: YouTubePlayer.Provider, result: YouTubeInitializationResult) {
        Toast.makeText(this, "Failed to initialize.", Toast.LENGTH_LONG).show()
    }

    override fun onInitializationSuccess(provider: YouTubePlayer.Provider, player: YouTubePlayer?, wasRestored: Boolean) {
        if (null == player) return
        player.setPlayerStyle(YouTubePlayer.PlayerStyle.MINIMAL)
        player.setPlayerStateChangeListener(PlayerStateChangeListener(player))
        if (!wasRestored) {
            player.cueVideo(resources.getString(R.string.id_video))
        }
    }

    class PlayerStateChangeListener(private val player:YouTubePlayer) : YouTubePlayer.PlayerStateChangeListener{
        override fun onAdStarted() {

        }

        override fun onLoading() {

        }

        override fun onVideoStarted() {

        }

        override fun onLoaded(p0: String?) {
            player.play()
        }

        override fun onVideoEnded() {

        }

        override fun onError(p0: YouTubePlayer.ErrorReason?) {

        }
    }
}