package sg.edu.rp.c346.id21024095.mylocalbanks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView tvDBS;
    TextView tvOCBC;
    TextView tvUOB;

    String wordClicked = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvDBS = findViewById(R.id.textViewDBS);
        tvOCBC = findViewById(R.id.textViewOCBC);
        tvUOB = findViewById(R.id.textViewUOB);

        registerForContextMenu(tvDBS);
        registerForContextMenu(tvOCBC);
        registerForContextMenu(tvUOB);
    }
// Language settings
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here.
        int id = item.getItemId();

        if (id == R.id.EnglishSelection) {
            tvDBS.setText(getString(R.string.dbs));
            tvOCBC.setText(getString(R.string.ocbc));
            tvUOB.setText(getString(R.string.uob));
            return true;

        } else if (id == R.id.ChineseSelection) {
            tvDBS.setText(getString(R.string.dbsC));
            tvOCBC.setText(getString(R.string.ocbcC));
            tvUOB.setText(getString(R.string.uobC));
            return true;

        } else {
            tvDBS.setText(getString(R.string.error));
            tvOCBC.setText(getString(R.string.error));
            tvUOB.setText(getString(R.string.error));
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.add(0,0,0,getString(R.string.menuWeb));
        menu.add(0,1,1,getString(R.string.menuContact));

        if (v == tvDBS) {
            wordClicked = getString(R.string.dbs);
        } else if (v == tvOCBC) {
            wordClicked = getString(R.string.ocbc);
        } else if (v == tvUOB) {
            wordClicked = getString(R.string.uob);
        }
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if (wordClicked.equalsIgnoreCase(getString(R.string.dbs))) {
            if (item.getItemId() == 0) {
                Toast.makeText(MainActivity.this, "Entering " + getString(R.string.dbs), Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(Intent. ACTION_VIEW, Uri.parse(getString(R.string.dbsSite)));
                startActivity(intent);
                return true;

            } else if (item.getItemId() == 1) {
                Toast.makeText(MainActivity.this, "Contacting " + getString(R.string.dbs), Toast.LENGTH_SHORT).show();

                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: " + getString(R.string.dbsContact)));
                startActivity(intentCall);
                return true;
            }

        } else if (wordClicked.equalsIgnoreCase(getString(R.string.ocbc))) {
            if (item.getItemId() == 0) {
                Toast.makeText(MainActivity.this, "Entering " + getString(R.string.ocbc), Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(Intent. ACTION_VIEW, Uri.parse(getString(R.string.ocbcSite)));
                startActivity(intent);
                return true;

            } else if (item.getItemId() == 1) {
                Toast.makeText(MainActivity.this, "Contacting " + getString(R.string.ocbc), Toast.LENGTH_SHORT).show();

                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: " +  getString(R.string.ocbcContact)));
                startActivity(intentCall);
                return true;
            }

        } else {
            if (item.getItemId() == 0) {
                Toast.makeText(MainActivity.this, "Entering " + getString(R.string.uob), Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(Intent. ACTION_VIEW, Uri.parse(getString(R.string.uobSite)));
                startActivity(intent);
                return true;

            } else if (item.getItemId() == 1) {
                Toast.makeText(MainActivity.this, "Contacting " + getString(R.string.uob), Toast.LENGTH_SHORT).show();

                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: " + getString(R.string.uobContact)));
                startActivity(intentCall);
                return true;
            }
        }
        return super.onContextItemSelected(item);
    }
}