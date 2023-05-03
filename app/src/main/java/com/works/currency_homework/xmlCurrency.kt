package com.works.currency_homework

import android.util.Log
import com.works.currency_homework.models.CurrencyModel
import org.jsoup.nodes.Document
import org.jsoup.Jsoup
import org.jsoup.select.Elements
import javax.xml.xpath.XPathConstants
import javax.xml.xpath.XPathExpressionException
import javax.xml.xpath.XPathFactory

class xmlCurrency
{
    fun xmlResult() : List<CurrencyModel>
    {
        val arr = mutableListOf<CurrencyModel>()
        val url = "https://www.tcmb.gov.tr/kurlar/today.xml"
        val doc: Document = Jsoup.connect(url).timeout(15000).ignoreContentType(true).get()
        val elements: Elements = doc.getElementsByTag("Currency")


        for (item in elements)
        {
            val Isim = item.getElementsByTag("Isim").text()
            val ForexBuying = item.getElementsByTag("ForexBuying").text()
            val ForexSelling = item.getElementsByTag("ForexSelling").text()
            val BanknotBuying = item.getElementsByTag("BanknoteBuying").text()
            val BanknotSelling = item.getElementsByTag("BanknoteSelling").text()

            val currency = CurrencyModel(Isim,ForexBuying,ForexSelling,BanknotBuying,BanknotSelling)
            arr.add(currency)

        }
        return arr
    }
    fun getDate() : String
    {
        val url = "https://www.tcmb.gov.tr/kurlar/today.xml"
        val doc: Document = Jsoup.connect(url).timeout(15000).ignoreContentType(true).get()
        val date = doc.getElementsByTag("Tarih_Date").attr("Tarih")
        return date
    }



}