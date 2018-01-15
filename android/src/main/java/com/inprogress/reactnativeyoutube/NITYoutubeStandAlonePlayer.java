package com.inprogress.reactnativeyoutube;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import static com.google.android.youtube.player.YouTubePlayer.FULLSCREEN_FLAG_CONTROL_SYSTEM_UI;

/**
 * @author Federico Boschini
 */

public class NITYoutubeStandAlonePlayer extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener {

    YouTubePlayerView youTubePlayerView;
    static String devKey;
    static String videoId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nit_youtube_layout);

        youTubePlayerView = (YouTubePlayerView) findViewById(R.id.youtube);
        youTubePlayerView.initialize(devKey, this);
    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean wasRestored) {
        if (null == youTubePlayer) return;
        youTubePlayer.setFullscreenControlFlags(FULLSCREEN_FLAG_CONTROL_SYSTEM_UI);
        youTubePlayer.setFullscreen(true);
        youTubePlayer.setPlayerStateChangeListener(new YouTubePlayer.PlayerStateChangeListener() {
            @Override
            public void onLoading() {

            }

            @Override
            public void onLoaded(String s) {

            }

            @Override
            public void onAdStarted() {

            }

            @Override
            public void onVideoStarted() {

            }

            @Override
            public void onVideoEnded() {
                finish();
            }

            @Override
            public void onError(YouTubePlayer.ErrorReason errorReason) {

            }
        });

        youTubePlayer.setOnFullscreenListener(new YouTubePlayer.OnFullscreenListener() {
            @Override
            public void onFullscreen(boolean b) {

            }
        });

        if (!wasRestored) {
            youTubePlayer.loadVideo(videoId);
            youTubePlayer.play();
            youTubePlayer.setPlaybackEventListener(new YouTubePlayer.PlaybackEventListener() {
                @Override
                public void onPlaying() {

                }

                @Override
                public void onPaused() {

                }

                @Override
                public void onStopped() {

                }

                @Override
                public void onBuffering(boolean b) {

                }

                @Override
                public void onSeekTo(int i) {

                }
            });
        }
    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

    }


    public static Intent createVideoIntent(Activity currentActivity, String apiKey, String vidId) {
        devKey = apiKey;
        videoId = vidId;
        return new Intent(currentActivity, NITYoutubeStandAlonePlayer.class);
    }
}
