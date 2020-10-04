package es.iessaladillo.pedrojoya.greet;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import es.iessaladillo.pedrojoya.greet.databinding.MainActivityBinding;

public class MainActivity extends AppCompatActivity {

    private MainActivityBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = MainActivityBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setupViews();
    }


    private void clickGender(){
        if (binding.rdbMr.isChecked()) {
            binding.imgGender.setImageResource(R.drawable.ic_mr);
        } else if (binding.rdbMrs.isChecked()) {
            binding.imgGender.setImageResource(R.drawable.ic_mrs);
        } else if (binding.rdbMs.isChecked()) {
            binding.imgGender.setImageResource(R.drawable.ic_ms);
        }
    }

    private void clickGreet() {
        if (binding.chkPolitely.isChecked() ) {
            binding.lblGreetResult.setText("rwerewr");
        } else {
            binding.lblGreetResult.setText("nono");
        }
    }

    private void incrementProgressBar(){

    }

    private void isPremium() {
        if (binding.swtPremium.isChecked()) {
            binding.prBar.setVisibility(View.INVISIBLE);
            binding.lblPrBar.setVisibility(View.INVISIBLE);
        } else {
            binding.prBar.setVisibility(View.VISIBLE);
            binding.lblPrBar.setVisibility(View.VISIBLE);
        }
    }

    private void setupViews() {

        binding.rdbMr.setOnCheckedChangeListener((x, y) -> clickGender());
        binding.rdbMrs.setOnCheckedChangeListener((x, y) -> clickGender());
        binding.rdbMs.setOnCheckedChangeListener((x, y) -> clickGender());

        binding.btnGreet.setOnClickListener(v -> clickGreet());

        binding.swtPremium.setOnClickListener(v -> isPremium());
    }
}