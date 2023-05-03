package com.works.currency_homework

import android.app.Application
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.StrictMode
import android.util.Log
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.works.currency_homework.models.CurrencyModel
import com.bumptech.glide.Glide

class MainActivity : AppCompatActivity() {

    lateinit var txtForexBuying: TextView
    lateinit var txtForexSelling: TextView
    lateinit var txtBanknoteBuying: TextView
    lateinit var txtBanknoteSelling: TextView
    lateinit var txtViewDate : TextView
    lateinit var btnCurrencySelect: Button
    lateinit var imgViewTCMB : ImageView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(policy)

        btnCurrencySelect = findViewById(R.id.btnCurrencySelect)
        txtForexBuying = findViewById(R.id.txtForexBuying)
        txtForexSelling = findViewById(R.id.txtForexSelling)
        txtBanknoteBuying = findViewById(R.id.txtBanknoteBuying)
        txtBanknoteSelling = findViewById(R.id.txtBanknoteSelling)
        imgViewTCMB = findViewById(R.id.imgViewTCMB)
        txtViewDate = findViewById(R.id.txtViewDate)

        registerForContextMenu(btnCurrencySelect)



        val imgUrl = "https://www3.tcmb.gov.tr/TLSimge/images/logo.png"
        Glide.with(this).load(imgUrl).into(imgViewTCMB)

        val xml = xmlCurrency()
        val date = xml.getDate()

        txtViewDate.text = date + " tarihindeki belirlenen Türkiye Cumhuriyet Merkez Bankası kurları"




    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        menuInflater.inflate(R.menu.button_menu, menu)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        val xml = xmlCurrency()
        val arr = xml.xmlResult()

        when (item.itemId) {
            R.id.abd_dollar -> arrList(arr, 0)

            R.id.australian_dollar -> arrList(arr, 1)

            R.id.denmak_kron -> arrList(arr, 2)

            R.id.euro -> arrList(arr, 3)

            R.id.england_sterline -> arrList(arr, 4)

            R.id.switzerland_frank -> arrList(arr, 5)

            R.id.sweeden_kron -> arrList(arr, 6)

            R.id.canada_dollar -> arrList(arr, 7)

            R.id.kuvalti_dinar -> arrList(arr, 8)

            R.id.norway_kron -> arrList(arr, 9)

            R.id.saudi_riyal -> arrList(arr, 10)

            R.id.japan_yen -> arrList(arr, 11)

            R.id.bulgarian_lev -> arrList(arr, 12)

            R.id.NEW_LEU -> arrList(arr, 13)

            R.id.Russian_double -> arrList(arr, 14)

            R.id.Iranian_rial -> arrList(arr, 15)

            R.id.Chinese_Remnibi -> arrList(arr, 16)

            R.id.Pakistani_rupee -> arrList(arr, 17)

            R.id.Qatari_riyal -> arrList(arr, 18)

            R.id.South_korean_won -> arrList(arr, 19)

            R.id.Azerbaijani_new_manat -> arrList(arr, 20)

            R.id.United_Arab_Emirates_Dirham -> arrList(arr, 21)
        }

        return super.onContextItemSelected(item)
    }

    fun arrList(arr: List<CurrencyModel>, index: Int) {

        if (arr.get(index).ForexBuying != "") {
            txtForexBuying.text = arr.get(index).ForexBuying
        }
        else
        {
            txtForexBuying.text = "Döviz alış yoktur"
        }
        if (arr.get(index).ForexSelling != "") {
            txtForexSelling.text = arr.get(index).ForexSelling
        }
        else
        {
            txtForexSelling.text = "Döviz satış yoktur"
        }
        if (arr.get(index).BanknoteBuying != "")
        {
            txtBanknoteBuying.text = arr.get(index).BanknoteBuying
        }
        else
        {
            txtBanknoteBuying.text = "Efektif alış yoktur"
        }
        if (arr.get(index).BanknoteSelling !="")
        {
            txtBanknoteSelling.text = arr.get(index).BanknoteSelling
        }
        else
        {
            txtBanknoteSelling.text = "Efektif satış yoktur"
        }



    }



}



