package stathis_katerina.little_math;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;

public class LittleMath extends FragmentActivity {

    private static final String MATH = "math";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_little_math);
    }

    void putFragmentToContent(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.content, fragment, MATH);
        fragmentTransaction.commit();
        findViewById(R.id.menu).setVisibility(View.GONE);
    }

    void showMenu() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment fragment = fragmentManager.findFragmentByTag(MATH);
        if (fragment != null) {
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            getSupportFragmentManager().beginTransaction().remove(fragment).commit();
        }
        findViewById(R.id.menu).setVisibility(View.VISIBLE);
    }

    public void launchPower(View view) {
        putFragmentToContent(new Power());
    }

    public void launchEquation(View view) {
        putFragmentToContent(new Equation());
    }

    boolean isOnMenu() {
        return findViewById(R.id.menu).getVisibility() == View.VISIBLE;
    }

    public void onBackPressed() {
        if (isOnMenu()) {
            super.onBackPressed();
        } else {
            showMenu();
        }
    }

}
