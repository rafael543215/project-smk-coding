package com.example.smkcodingproject1

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_edit_name.*

class EditNameActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_name)

        //menerima data dari halaman profile
        val intentData = intent.extras
        val namaUser = intentData?.getString("nama")

        //set editText dengan data yang baru dipindahkan
        et_editnama.setText(namaUser)

        //memberikan action tombol simpan
        btn_ubah.setOnClickListener { saveData() }

    }

    //action mengirimkan kembali data ke profile activity
    private fun saveData(){
        val namaEdit = et_editnama.text.toString()
        if(!namaEdit.isEmpty()){
            //jika proses berhasil
            Toast.makeText(this, "Nama Berhasil Di Edit!", Toast.LENGTH_SHORT).show()
            val result = Intent()
            result.putExtra("nama", namaEdit)
            setResult(Activity.RESULT_OK, result)
        }else{
            //jika proses gagal
            Toast.makeText(this, "Nama Gagal Diperbarui!", Toast.LENGTH_SHORT).show()
            setResult(Activity.RESULT_CANCELED)
        }
        finish()
    }
}
