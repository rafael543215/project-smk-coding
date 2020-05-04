package com.example.smkcodingproject1

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_edit_name.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_profile.*

class ProfileActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        //fungsi pemanggilan data
        ambilData()

        btn_editnama.setOnClickListener { navigasiEditProfile() }

        btn_dial.setOnClickListener { dialPhoneNumber(tv_telp.text.toString()) }
    }

    //fungsi Pengambil Data
    private fun ambilData(){
        val bundle = intent.extras

        val nama = bundle?.getString("nama")
        val jeniskelamin = bundle?.getString("jeniskelamin")
        val email = bundle?.getString("email")
        val telp = bundle?.getString("telp")
        val alamat = bundle?.getString("alamat")
        val umur = bundle?.getString("umur")

        tv_nama.text = nama
        tv_jeniskelamin.text = jeniskelamin
        tv_email.text = email
        tv_telp.text = telp
        tv_alamat.text = alamat
        tv_umur.text = umur

    }

    companion object{
        val REQUEST_CODE = 100
    }
    //Navigasi ke Edit Profile
    private fun navigasiEditProfile(){
        val intent = Intent(this, EditNameActivity::class.java)

        val namaUser = tv_nama.text.toString()
        intent.putExtra("nama", namaUser)
        startActivityForResult(intent, REQUEST_CODE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode == REQUEST_CODE){
            if(resultCode == Activity.RESULT_OK){
                val result = data?.getStringExtra("nama")
                tv_nama.text = result
            }else{
                Toast.makeText(this, "Edit Gagal!", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun dialPhoneNumber(phoneNumber : String){
        val intent = Intent(Intent.ACTION_DIAL).apply {
            data = Uri.parse("tel:$phoneNumber")
        }
        if(intent.resolveActivity(packageManager) != null){
            startActivity(intent)
        }
    }
}
