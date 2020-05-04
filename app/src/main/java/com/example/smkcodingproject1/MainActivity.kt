package com.example.smkcodingproject1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Message
import android.widget.Adapter
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //action button simpan
        btn_simpan.setOnClickListener { validasiInput() }
    }
    //proses intent dan pemindahan data
    private fun goToProfileActivity(){
        val intent = Intent(this, ProfileActivity::class.java)

        val  bundle = Bundle()
        bundle.putString("nama", namaInput)
        bundle.putString("jeniskelamin", jenisKelaminInput)
        bundle.putString("telp", telpInput)
        bundle.putString("umur", umurInput)
        bundle.putString("alamat", alamatInput)
        bundle.putString("email", emailInput)

        intent.putExtras(bundle)
        startActivity(intent)


    }

    //validasi data
    private var namaInput : String = ""
    private var telpInput : String = ""
    private var alamatInput : String = ""
    private var emailInput : String = ""
    private var jenisKelaminInput : String = ""
    private var umurInput : String = ""

    private fun validasiInput(){
        namaInput = et_nama.text.toString()
        telpInput = et_telp.text.toString()
        alamatInput = et_alamat.text.toString()
        emailInput = et_email.text.toString()
        jenisKelaminInput = spinner.selectedItem.toString()
        umurInput = et_umur.text.toString()

        when {
            namaInput.isEmpty() -> et_nama.error = "Nama Tidak Boleh Kosong!"
            jenisKelaminInput.equals("Pilih Jenis Kelamin", ignoreCase = true) -> tampilToast("Jenis Kelamin Harus Dipilih!")
            alamatInput.isEmpty() -> et_alamat.error = "Alamat Tidak Boleh Kosong!"
            emailInput.isEmpty() -> et_email.error = "Email Tidak Boleh Kosong!"
            alamatInput.isEmpty() -> et_email.error = "Alamat tidak boleh kosong!"
            umurInput.isEmpty() -> et_umur.error = "Umur tidak boleh kosong!"

            else -> {
                tampilToast("Navigasi ke Halaman Profile")
                goToProfileActivity()
            }
        }
    }

    //Toast
    private fun tampilToast(message: String){
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
    //Set adapter Spinner
    private fun setDataOnSpinner(){
        val adapter = ArrayAdapter.createFromResource(this, R.array.array, android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter
    }
}
