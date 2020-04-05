package io.github.zeex.twitchkat

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import org.mozilla.geckoview.GeckoRuntime
import org.mozilla.geckoview.GeckoRuntimeSettings
import org.mozilla.geckoview.GeckoSession
import org.mozilla.geckoview.GeckoSessionSettings
import org.mozilla.geckoview.GeckoView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        val webView = findViewById<GeckoView>(R.id.web_view)
        val sessionSettings = GeckoSessionSettings.Builder()
            .viewportMode(GeckoSessionSettings.VIEWPORT_MODE_DESKTOP)
            .userAgentMode(GeckoSessionSettings.USER_AGENT_MODE_DESKTOP)
            .build()
        val session = GeckoSession(sessionSettings)
        val runtimeSettings = GeckoRuntimeSettings.Builder()
            .aboutConfigEnabled(false)
            .consoleOutput(false)
            .debugLogging(false)
            .inputAutoZoomEnabled(false)
            .preferredColorScheme(GeckoRuntimeSettings.COLOR_SCHEME_DARK)
            .remoteDebuggingEnabled(false)
            .build()
        val runtime = GeckoRuntime.create(this, runtimeSettings)
        
        session.open(runtime)
        webView.setSession(session)
        session.loadUri("https://www.twitch.tv")
    }
}
