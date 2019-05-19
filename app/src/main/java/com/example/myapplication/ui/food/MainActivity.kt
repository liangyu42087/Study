package com.example.myapplication.ui.food

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.data.model.Food
import com.example.myapplication.util.InjectUtil
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {

    private val foodViewModelFactory = InjectUtil.providesFoodViewModelFactory()
    private val foodAdapter = FoodAdapter()
    private val layoutManager: LinearLayoutManager by lazy {
        LinearLayoutManager(this).apply {
            orientation = RecyclerView.VERTICAL
        }
    }
    private val viewModel: FoodViewModel by lazy {
        ViewModelProviders.of(this, foodViewModelFactory).get(FoodViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        initUi()
    }
    private fun initUi() {
        food_recyclerview.adapter = foodAdapter
        food_recyclerview.layoutManager = layoutManager
        viewModel.getFoods().observe(this, Observer {
            //If we get it from real room, we dont need to do this.
            foodAdapter.submitList(ArrayList<Food>(it))
        })
        viewModel.getError().observe(this, Observer {
            Toast.makeText(this, it, Toast.LENGTH_LONG).show()
        })
        fab.setOnClickListener { view ->
            val price = food_price_et.text.toString()
            val name = food_name_et.text.toString()
            viewModel.insertFood(name, price)
        }
    }



    /*  override fun onCreateOptionsMenu(menu: Menu): Boolean {
          // Inflate the menu; this adds items to the action bar if it is present.
          menuInflater.inflate(R.menu.menu_main, menu)
          return true
      }

      override fun onOptionsItemSelected(item: MenuItem): Boolean {
          // Handle action bar item clicks here. The action bar will
          // automatically handle clicks on the Home/Up button, so long
          // as you specify a parent activity in AndroidManifest.xml.
          return when (item.itemId) {
              R.id.action_settings -> true
              else -> super.onOptionsItemSelected(item)
          }
      }*/
}
