package it.rizzoli.RED.Studenti;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import it.rizzoli.RED.R;

public class CalendarFragment extends Fragment {
    private final static String MY_PREFERENCES = "MyPref";

    WebView webView;
    public String fileName = "TimeTable.html";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_calendar, container, false);

        // INIZIALIZZA WEBVIEW
        webView = (WebView) view.findViewById(R.id.webview);

        // VISUALIZZA IL CONTENUTO DELLA WEBVIEW DAL FILE HTML CHE STA NELL'ASSETS
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("file:///android_asset/" + fileName);

        return view;
    }
}
