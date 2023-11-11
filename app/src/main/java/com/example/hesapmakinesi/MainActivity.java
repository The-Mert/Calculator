package com.example.hesapmakinesi;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.example.hesapmakinesi.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        /////Silme VE HESAPLAMA TUŞLARI

        binding.butonSil.setOnClickListener(v->{
            if(binding.textHesap.length()>0) {
                String existingText = binding.textHesap.getText().toString();

                StringBuffer stringBuffer = new StringBuffer(existingText);

                String deletedText = stringBuffer.deleteCharAt(stringBuffer.length() - 1).toString();
                binding.textHesap.setText(deletedText);
            }
        });

        binding.butonSifirla.setOnClickListener(v->{
            binding.textHesap.setText("");
        });

        binding.butonSonuc.setOnClickListener(v->{
            String existingText = binding.textHesap.getText().toString();
            StringBuffer stringBuffer = new StringBuffer(existingText);

            if(!existingText.matches("")){
                String sonKarakter = String.valueOf(stringBuffer.charAt(stringBuffer.length()-1));
//                Log.e("Sonuç2",sonKarakter);
                if(existingText.contains("+") && sonKarakter!="+"){ //TOPLAMA
                    int sum = 0;
                    Log.e("Sonuç2",sonKarakter);
                    String[] arrOfStr = existingText.split("\\+");
                    for(String number : arrOfStr){
                        sum+=Integer.parseInt(number);
                    }
                    binding.textHesap.setText(String.valueOf(sum));

                }else if(existingText.contains("-") && sonKarakter!="-"){ //ÇIKARMA
                    int sum = 0;

                    String[] arrOfStr = existingText.split("-");
                    sum = Integer.parseInt(arrOfStr[0])*2;
                    for(String number : arrOfStr){

                        sum-=Integer.parseInt(number);
                    }
                    binding.textHesap.setText(String.valueOf(sum));
                }else if(existingText.contains("/") && sonKarakter!="/"){  //BÖLME
                    int sum = 0;
                    String[] arrOfStr = existingText.split("/");
                    sum = Integer.parseInt(arrOfStr[0]);
                    for(String number : arrOfStr){
                        if(number != arrOfStr[0]) {
                            sum /= Integer.parseInt(number);
                        }}
                    binding.textHesap.setText(String.valueOf(sum));
                }else if(existingText.contains("*") && sonKarakter!="*"){ //ÇARPMA
                    int sum = 0;

                    String[] arrOfStr = existingText.split("\\*");
                    sum = Integer.parseInt(arrOfStr[0]);
                    for(String number : arrOfStr){
                        if(number != arrOfStr[0]) {
                            sum *= Integer.parseInt(number);
                        }
                    }
                    binding.textHesap.setText(String.valueOf(sum));
                }
            }

        });



        //// TUŞ TAKIMI
        binding.buton0.setOnClickListener(v-> {
            String existingText = binding.textHesap.getText().toString();

            binding.textHesap.setText(existingText + "0");
        });
        binding.buton1.setOnClickListener(v-> {
            String existingText = binding.textHesap.getText().toString();

            binding.textHesap.setText(existingText + "1");
        });
        binding.buton2.setOnClickListener(v-> {
            String existingText = binding.textHesap.getText().toString();

            binding.textHesap.setText(existingText + "2");
        });
        binding.buton3.setOnClickListener(v-> {
            String existingText = binding.textHesap.getText().toString();

            binding.textHesap.setText(existingText + "3");
        });
        binding.buton4.setOnClickListener(v-> {
            String existingText = binding.textHesap.getText().toString();

            binding.textHesap.setText(existingText + "4");
        });
        binding.buton5.setOnClickListener(v-> {
            String existingText = binding.textHesap.getText().toString();

            binding.textHesap.setText(existingText + "5");
        });
        binding.buton6.setOnClickListener(v-> {
            String existingText = binding.textHesap.getText().toString();

            binding.textHesap.setText(existingText + "6");
        });
        binding.buton7.setOnClickListener(v-> {
            String existingText = binding.textHesap.getText().toString();

            binding.textHesap.setText(existingText + "7");
        });
        binding.buton8.setOnClickListener(v-> {
            String existingText = binding.textHesap.getText().toString();

            binding.textHesap.setText(existingText + "8");
        });
        binding.buton9.setOnClickListener(v-> {
            String existingText = binding.textHesap.getText().toString();

            binding.textHesap.setText(existingText + "9");
        });


        /////İŞLEM TUŞLARI

        binding.butonToplama.setOnClickListener(v-> {
            String existingText = binding.textHesap.getText().toString();

            StringBuffer stringBuffer = new StringBuffer(existingText);
            String sonKarakter = String.valueOf(stringBuffer.charAt(stringBuffer.length()-1));
            if(sonKarakter != "+"){
                binding.textHesap.setText(existingText + "+");
            }
        });

        binding.buyonBolme.setOnClickListener(v-> {
            String existingText = binding.textHesap.getText().toString();
            binding.textHesap.setText(existingText + "/");
        });

        binding.butonCarpma.setOnClickListener(v-> {
            String existingText = binding.textHesap.getText().toString();
            binding.textHesap.setText(existingText + "*");
        });

        binding.butonCikarma.setOnClickListener(v-> {
            String existingText = binding.textHesap.getText().toString();
            StringBuffer stringBuffer = new StringBuffer(existingText);
            String sonKarakter = String.valueOf(stringBuffer.charAt(stringBuffer.length()-1));

            if(sonKarakter != "-"){
                binding.textHesap.setText(existingText + "-");
            }
        });



    }
}