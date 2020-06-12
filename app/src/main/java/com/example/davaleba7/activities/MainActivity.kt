package com.example.davaleba7.activities

import android.os.Bundle
import android.view.Menu
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley

import com.example.davaleba7.R
import com.example.davaleba7.adapters.RvAdapter
import com.example.davaleba7.model.Building
import org.json.JSONException
import org.json.JSONObject
import java.util.*


class MainActivity : AppCompatActivity() {
    private val URL_JSON =
        "http://www.mocky.io/v2/5edb4d643200002a005d26f0"
    private var ArrayRequest: JsonArrayRequest? = null
    private var requestQueue: RequestQueue? = null
    private val lstAnime: MutableList<Building?> = ArrayList<Building?>()
    private var myrv: RecyclerView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        myrv = findViewById(R.id.rv)
        jsoncall()
    }

    fun jsoncall() {
        ArrayRequest =
            JsonArrayRequest(URL_JSON,
                Response.Listener { response ->
                    var jsonObject: JSONObject? = null
                    for (i in 0 until response.length()) {

                        //Toast.makeText(getApplicationContext(),String.valueOf(i),Toast.LENGTH_SHORT).show();
                        try {
                            jsonObject = response.getJSONObject(i)
                            val anime = Building()
                            anime.setCover(jsonObject.getString("cover"))
                            anime.setTitle(jsonObject.getString("titleEN"))
                            anime.setDescription(jsonObject.getString("descriptionEN"))

                            lstAnime.add(anime)
                        } catch (e: JSONException) {
                            e.printStackTrace()
                        }
                    }
                    Toast.makeText(
                        this@MainActivity,
                        "Size of Liste " + lstAnime.size.toString(),
                        Toast.LENGTH_SHORT
                    ).show()
                    Toast.makeText(
                        this@MainActivity,
                        lstAnime[1].toString(),
                        Toast.LENGTH_SHORT
                    ).show()
                    setRvadapter(lstAnime)
                }, Response.ErrorListener { })
        requestQueue = Volley.newRequestQueue(this@MainActivity)
        requestQueue.add(ArrayRequest)
    }

    fun setRvadapter(lst: List<Building?>?) {
        val myAdapter = RvAdapter(this, lst)
        myrv!!.layoutManager = LinearLayoutManager(this)
        myrv!!.setAdapter(myAdapter)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }
}