// Terakhir dikerjakan: Sabtu, 17 Mei 2025
// NIM: 10122362
// Nama: Louis Jonathan Susanto Putra
// Kelas: Pemrograman Android 4

package com.example.assessmentbelajarandroidform
import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.assessmentbelajarandroidform.databinding.ActivityMainBinding
import com.example.assessmentbelajarandroidform.model.AssessmentData

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // spinner semester
        val semesterArray = arrayOf("I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII")
        val semesterAdapter =
            ArrayAdapter(this, android.R.layout.simple_spinner_item, semesterArray)
        semesterAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spSemester.adapter = semesterAdapter

        // spinner merk HP
        val merkHpArray =
            arrayOf("Samsung", "Xiaomi", "Oppo", "Vivo", "Realme", "Apple", "Asus", "Sony",
                "Huawei", "Nokia", "Poco", "Honor", "Infinix", "Iqoo", "Redmi", "Lainnya")
        val merkHpAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, merkHpArray)
        merkHpAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spMerkHp.adapter = merkHpAdapter

        binding.btnSubmit.setOnClickListener {
            val nim = binding.edtNim.text.toString()
            val nama = binding.edtNama.text.toString()
            val semester = binding.spSemester.selectedItem.toString()
            val jenisPerangkat = when{
                binding.radPc.isChecked -> "PC Dekstop"
                binding.radLaptop.isChecked -> "Laptop"
                binding.radTidakPunya.isChecked -> "Tidak Punya"
                else -> ""
            }
            val sistemOperasi = when{
                binding.radWindows.isChecked -> "Windows"
                binding.radLinux.isChecked -> "Linux"
                binding.radMacOs.isChecked -> "Mac OS"
                else -> ""
            }
            val versiOs = binding.edtVersiOs.text.toString()
            val ram = binding.edtRam.text.toString()
            val cpu = binding.edtCpu.text.toString()
            val deploy = when{
                binding.radEmulator.isChecked -> "Emulator"
                binding.radDeviceKabel.isChecked -> "Device Kabel"
                binding.radDeviceWifi.isChecked -> "Device Wifi"
                binding.radTidakBisaDeploy.isChecked -> "Tidak Bisa Deploy"
                else -> ""
            }
            val merkHp = binding.spMerkHp.selectedItem.toString()
            val versiOsHp = binding.edtVersiOsHp.text.toString()
            val ukuranHp = binding.edtUkuranHp.text.toString()
            val internet = when{
                binding.radTethering.isChecked -> "Tethering HP Sendiri"
                binding.radWifiSendiri.isChecked -> "Wifi Sendiri"
                binding.radWifiNebeng.isChecked -> "Wifi Nebeng"
                binding.radTidakPunyaWifi.isChecked -> "Tidak Punya"
                else -> ""
            }
            val installAndroid = when {
                binding.radSudahInstall.isChecked -> "Sudah"
                binding.radBelumInstall.isChecked -> "Belum"
                binding.radTidakBisaInstall.isChecked -> "Tidak Bisa"
                else -> ""
            }
            val versiInstallAndroid = binding.edtVersiInstallAndroid.text.toString()
            if (nim.isEmpty() || nama.isEmpty() || semester.isEmpty() || jenisPerangkat.isEmpty()
                || sistemOperasi.isEmpty() || versiOs.isEmpty() || ram.isEmpty() || cpu.isEmpty()
                || deploy.isEmpty() || merkHp.isEmpty() || versiOsHp.isEmpty() || ukuranHp.isEmpty()
                || internet.isEmpty() || installAndroid.isEmpty() || versiInstallAndroid.isEmpty()) {
                Toast.makeText(this, "Semua Field Harus Diisi", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val assessmentData = AssessmentData(nim, nama, semester, jenisPerangkat, sistemOperasi, versiOs, ram, cpu,
                deploy, merkHp, versiOsHp, ukuranHp, internet, installAndroid, versiInstallAndroid)
            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra("assessment_data", assessmentData)
            startActivity(intent)
            }
        }

    }