package com.example.assessmentbelajarandroidform

import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.assessmentbelajarandroidform.databinding.ActivityResultBinding
import com.example.assessmentbelajarandroidform.model.AssessmentData

class ResultActivity : AppCompatActivity() {

    private lateinit var binding: ActivityResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val assessmentData = intent.getParcelableExtra<AssessmentData>("assessment_data")
        assessmentData?.let {
            binding.txtNimResult.text = it.nim
            binding.txtNamaResult.text = it.nama
            binding.txtSemesterResult.text = it.semester
            binding.txtDeviceResult.text = it.jenisPerangkat
            binding.txtOsResult.text = it.sistemOperasi
            binding.txtVersiOsResult.text = it.versiOs
            binding.txtRamResult.text = it.ram
            binding.txtCpuResult.text = it.cpu
            binding.txtDeployResult.text = it.deploy
            binding.txtMerkHpResult.text = it.merkHp
            binding.txtVersiOsHpResult.text = it.versiOsHp
            binding.txtUkuranHpResult.text = it.ukuranHp
            binding.txtInternetResult.text = it.jenisInternet
            binding.txtInstallAndroidResult.text = it.statusInstallAndroid
            binding.txtVersiInstallAndroidResult.text = it.versiInstallAndroid
        }

        binding.btnInfoDeveloper.setOnClickListener {
            showDeveloperDialog()
        }
    }

    private fun showDeveloperDialog() {
        AlertDialog.Builder(this)
            .setTitle("Profil Developer")
            .setMessage("""
                Nama: Louis Jonathan Susanto Putra
                NIM: 10122362
                Kelas: Pemrograman Android 4
            """.trimIndent())
            .setPositiveButton("Tutup") { dialog, _ ->
                dialog.dismiss()
            }
            .create()
            .show()
    }
}