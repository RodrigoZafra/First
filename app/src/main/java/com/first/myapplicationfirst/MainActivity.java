package com.first.myapplicationfirst;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.snackbar.Snackbar;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private SwipeRefreshLayout swipeLayout;
    private WebView vistaWeb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vistaWeb = (WebView) findViewById(R.id.vistaWeb);
        registerForContextMenu(vistaWeb);

        vistaWeb.getSettings().setBuiltInZoomControls(true);
        vistaWeb.loadUrl("https://thispersondoesnotexist.com");

        swipeLayout = (SwipeRefreshLayout) findViewById(R.id.swipe);
        swipeLayout.setOnRefreshListener(mOnRefreshListener);
    }

    public void showAlertDialogButtonClicked(MainActivity mainActivity) {
        MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(this);

        builder.setTitle("Achtung!");
        builder.setMessage("Where do you go?");
        builder.setIcon(R.drawable.usericon);
        builder.setCancelable(false);

        builder.setPositiveButton("Signup", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent intent = new Intent(MainActivity.this, Signup.class);
                startActivity(intent);
                dialogInterface.dismiss();
            }
        });

        builder.setNegativeButton("Do nothing", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });

        builder.setNeutralButton("Other", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    /*public void showAccountDialogButtonClicked(MainActivity mainActivity){
        String[] items = new String[]{"rodrifdt17@gmail.com", "natzafr@gmail.com", "javierz@gmail.com"};
        MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(this);
                builder.setTitle("Accounts");
                builder.setItems(items);
        }
        AlertDialog dialog = builder.create();
        dialog.show();
    }*/

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.menu_context, menu);
    }

    protected SwipeRefreshLayout.OnRefreshListener
            mOnRefreshListener = new SwipeRefreshLayout.OnRefreshListener() {
        @Override
        public void onRefresh() {
            Toast toast0 = Toast.makeText(MainActivity.this, "Hola, no existo!", Toast.LENGTH_LONG);
            toast0.show();

            vistaWeb.reload();

            swipeLayout.setRefreshing(false);
        }
    };

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item1:
                // Toast toast = Toast.makeText(this, "Item copied", Toast.LENGTH_LONG);
                //toast.show();
                final ConstraintLayout mLayout = findViewById(R.id.myMainConstraint);
                Snackbar snackbar = Snackbar.make(mLayout, "fancy a Snack while you refresh?", Snackbar.LENGTH_LONG)
                        .setAction("UNDO", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Snackbar snackbar1 = Snackbar.make(mLayout, "Action is restored!", Snackbar.LENGTH_SHORT);
                                snackbar1.show();
                            }
                        });
                snackbar.show();
                return true;
            case R.id.item2:
                Toast toast2 = Toast.makeText(this, "Downloading item...", Toast.LENGTH_LONG);
                toast2.show();
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {//Aparece el menu en la barra de arriba
        getMenuInflater().inflate(R.menu.menu_appbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {//Gestiona las acciones sobre los botones
        int id = item.getItemId();
        if (id == R.id.search) {
            Toast toast = Toast.makeText(this, "infecting", Toast.LENGTH_LONG);
            toast.show();
        }
        if (id == R.id.favorite) {
            Toast toast = Toast.makeText(this, "Me gusta!", Toast.LENGTH_LONG);
            toast.show();
        }

        if (id == R.id.signOut) {
            showAlertDialogButtonClicked(MainActivity.this);
        }

        if (id == R.id.menu_navigation) {
            Intent intent = new Intent(MainActivity.this, MainBn.class);
            startActivity(intent);
        }


        return super.onOptionsItemSelected(item);
    }
}