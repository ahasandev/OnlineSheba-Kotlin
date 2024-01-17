package com.kingtech.onlinesheba.model.data

import com.kingtech.onlinesheba.R
import com.kingtech.onlinesheba.model.Ambulance
import com.kingtech.onlinesheba.model.Category
import com.kingtech.onlinesheba.model.Details
import com.kingtech.onlinesheba.model.Fair
import com.kingtech.onlinesheba.model.News

object CategoryData {

    val categoryData = mutableListOf<Category>(
        Category("খবর",""+ R.drawable.category_news),
        Category("এ্যাম্বুলেন্স",""+ R.drawable.category_ambulence),
        Category("ফায়ার সার্ভিস",""+ R.drawable.category_fire_service),
        Category("হেল্প লাইন",""+ R.drawable.category_helpline),
        Category("থানা পুলিশ",""+ R.drawable.category_police),
        Category("আইনজীবী",""+ R.drawable.category_lawyer),
        Category("হাসপাতাল",""+ R.drawable.category_hospital),
        Category("ডাক্তার",""+ R.drawable.category_doctor),
        Category("ব্লাড ডোনার",""+ R.drawable.category_blood),


    )


    val newsData = mutableListOf<News>(
        News("",""+R.drawable.news_prothomalop),
        News("",""+R.drawable.news_prothomalop),
        News("",""+R.drawable.news_prothomalop),
        News("",""+R.drawable.news_prothomalop),
        News("",""+R.drawable.news_prothomalop),
    )

    val ambulanceData = mutableListOf<Ambulance>(
        Ambulance("এ্যাম্বুলেন্স সার্ভিস-২","01717-8543"),
        Ambulance("এ্যাম্বুলেন্স সার্ভিস","01717-8345447"),
        Ambulance("এ্যাম্বুলেন্স সার্ভিস","01717-834448"),
        Ambulance("এ্যাম্বুলেন্স সার্ভিস-২0","01717-44445"),

    )


    val fairData = mutableListOf<Fair>(
        Fair("Dinajpur Fair Service","Dinajpur","0123456789"),
        Fair("Dinajpur Fair Service","Dinajpur","0123456789"),
        Fair("Dinajpur Fair Service","Dinajpur","0123456789"),
        Fair("Dinajpur Fair Service","Dinajpur","0123456789"),
        Fair("Dinajpur Fair Service","Dinajpur","0123456789"),
        Fair("Dinajpur Fair Service","Dinajpur","0123456789"),
        Fair("Dinajpur Fair Service","Dinajpur","0123456789"),
        Fair("Dinajpur Fair Service","Dinajpur","0123456789"),
        Fair("Dinajpur Fair Service","Dinajpur","0123456789"),


        )

    val thanaData = mutableListOf<Details>(

        Details("","","","242"),
        Details("fsafas","","",""),
        Details("sadf","","asda","asfas"),
    )

    val lowerData = mutableListOf<Details>(

        Details("sfaf","","0000",""),
        Details("fsafa","","",""),
        Details("fasf","asf","afs",""),
        Details("fasf","asf","afs",""),
    )

    val helplineData = mutableListOf<Details>(

        Details("faf","","456345364",""),
        Details("fasf","","4536",""),
        Details("fasf","","45345",""),
        Details("fasf","","45345",""),
        Details("fasf","","45345",""),
    )


}