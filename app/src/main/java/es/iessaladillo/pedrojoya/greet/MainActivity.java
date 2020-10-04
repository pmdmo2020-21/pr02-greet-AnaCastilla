package es.iessaladillo.pedrojoya.greet;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import es.iessaladillo.pedrojoya.greet.databinding.MainActivityBinding;

public class MainActivity extends AppCompatActivity {

    private MainActivityBinding binding;
    String gender;
    int i = 0;


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
            gender = "Mr.";
        } else if (binding.rdbMrs.isChecked()) {
            binding.imgGender.setImageResource(R.drawable.ic_mrs);
            gender = "Mrs.";
        } else if (binding.rdbMs.isChecked()) {
            binding.imgGender.setImageResource(R.drawable.ic_ms);
            gender = "Ms.";
        }
    }

    private void clickGreet() {
        String name = binding.edtName.getText().toString();
        String surname = binding.edtSurname.getText().toString();
        if (!name.isEmpty() && !surname.isEmpty()) {
            if (binding.chkPolitely.isChecked()) {
                binding.lblGreetResult.setText("Good morning " + gender + " " + name +
                        " " + surname +". Pleased to meet you");
                binding.prBar.setProgress(i++);
                binding.lblPrBar.setText(i + " of 10");
            } else {
                binding.lblGreetResult.setText("Hello " + name + " " + surname + ". What's up?");
                binding.prBar.setProgress(i++);
                binding.lblPrBar.setText(i + " of 10");
            }

            if (i > 10) {
                binding.lblPrBar.setText("10 of 10");
                binding.lblGreetResult.setText("Buy premium suscription to go on greeting!!");
            }


        } else if (name.isEmpty() && surname.isEmpty()){
            binding.lblGreetResult.setText("");
        }
    }


    private void isPremium() {
        if (binding.swtPremium.isChecked()) {
            binding.prBar.setVisibility(View.INVISIBLE);
            binding.lblPrBar.setVisibility(View.INVISIBLE);
            i = 0;
            reset();
        } else {
            binding.prBar.setVisibility(View.VISIBLE);
            binding.lblPrBar.setVisibility(View.VISIBLE);
            binding.prBar.setProgress(0);
            binding.lblPrBar.setText("0 of 10");
        }
    }

    private void reset() {
        clickGreet();
    }

    private void setupViews() {

        binding.rdbMr.setOnCheckedChangeListener((x, y) -> clickGender());
        binding.rdbMrs.setOnCheckedChangeListener((x, y) -> clickGender());
        binding.rdbMs.setOnCheckedChangeListener((x, y) -> clickGender());

        binding.btnGreet.setOnClickListener(v -> clickGreet());

        binding.swtPremium.setOnClickListener(v -> isPremium());
    }
}