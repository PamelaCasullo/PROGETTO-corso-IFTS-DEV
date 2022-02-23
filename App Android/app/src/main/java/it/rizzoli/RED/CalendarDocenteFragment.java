package it.rizzoli.RED;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import androidx.fragment.app.Fragment;


public class CalendarDocenteFragment extends Fragment {
    private final static String MY_PREFERENCES = "MyPref";

    WebView webView;
    public String fileName = "TimeTable.html";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_calendar_docente, container, false);

        // INIZIALIZZA WEBVIEW
        webView = (WebView) view.findViewById(R.id.webview_docente);

        // VISUALIZZA IL CONTENUTO DELLA WEBVIEW DAL FILE HTML CHE STA NELL'ASSETS
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("file:///android_asset/" + fileName);

        return view;
    }
}