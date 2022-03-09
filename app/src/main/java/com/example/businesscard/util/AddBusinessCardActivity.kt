package com.example.businesscard.util

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.businesscard.App
import com.example.businesscard.R
import com.example.businesscard.data.BusinessCard
import com.example.businesscard.databinding.ActivityAddBusinessCardBinding
import com.example.businesscard.ui.MainViewModel
import com.example.businesscard.ui.MainViewModelFactory

class AddBusinessCardActivity: AppCompatActivity() {
    private val binding by lazy { ActivityAddBusinessCardBinding.inflate(layoutInflater)}
    private val mainViewModel: MainViewModel by viewModels {
        MainViewModelFactory((application as App).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }

    private fun inserListeners(){
        binding.but.setOnClickListener {
            finish()
        }
        binding.btConfirm.setOnClickListener {
            val businessCard = BusinessCard(
                nome = binding.tipName.editText?.text.toString(),
                empresa = binding.tipEmpresa.editText?.text.toString(),
                telefone = binding.tipPhone.editText?.text.toString(),
                email = binding.tipEmail.editText?.text.toString(),
                fundo = binding.tipCor.editText?.text.toString(),
            )
            mainViewModel.insert(businessCard)
            Toast.makeText(this, R.string.label_success, Toast.LENGTH_SHORT).show()
            finish()
        }
    }

}