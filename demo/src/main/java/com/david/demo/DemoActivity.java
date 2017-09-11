package com.david.demo;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.TextureView;

import com.david.arlocation.aritem.boundary.ArManager;
import com.david.arlocation.aritem.manager.DefaultArManager;
import com.david.arlocation.view.views.MarkersView;
import com.david.arlocation.view.views.RadarView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DemoActivity extends AppCompatActivity {

    private static final int MULTIPLE_PERMISSIONS_REQUEST_CODE = 1;

    @BindView(R.id.textureView) TextureView textureView;
    @BindView(R.id.iconsView) MarkersView<Place> markersView;
    @BindView(R.id.radarView) RadarView<Place> radarView;

    ArManager<Place> arManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_demo);

        initializeViewComponents();

        if(arePermissionsGranted()) {
            arManager.init();
            arManager.addArItems(Place.getPlaces());
        }
    }

    private void initializeViewComponents() {
        ButterKnife.bind(this);
        arManager = new DefaultArManager<>(
                this,
                textureView,
                markersView,
                radarView);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        arManager.init();
    }

    @Override
    protected void onPause() {
        arManager.release();
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        arManager.release();
        super.onDestroy();
    }

    public boolean arePermissionsGranted() {
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED ||
                ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(
                    this, new String[] {
                            Manifest.permission.CAMERA,
                            Manifest.permission.ACCESS_FINE_LOCATION},
                    MULTIPLE_PERMISSIONS_REQUEST_CODE);

            return false;
        }

        return true;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if(requestCode == MULTIPLE_PERMISSIONS_REQUEST_CODE && grantResults[0] == PackageManager.PERMISSION_DENIED) {
            finish();
        } else {
            arManager.init();
            arManager.addArItems(Place.getPlaces());
        }
    }
}
