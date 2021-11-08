package id.ac.ukdw.pertemuan9_7117000

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2


class MainActivity:  AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))
        supportActionBar?.setDisplayShowTitleEnabled(false)

        val viewPager = findViewById<ViewPager2>(R.id.pager)
        val listFragment: ArrayList<Fragment> = arrayListOf(FragmentSatu(), FragmentDua(), FragmentTiga())
        val pagerAdapter = PagerAdapter(this, listFragment)
        viewPager.adapter = pagerAdapter
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        getMenuInflater().inflate(R.menu.menu_default, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean = when (item.itemId){
        R.id.frg1 -> {
            val viewPager = findViewById<ViewPager2>(R.id.pager)
            val fragment: ArrayList<Fragment> = arrayListOf(FragmentSatu(),FragmentDua(),FragmentTiga())
            val pagerAdapter = PagerAdapter(this, fragment)
            viewPager.adapter = pagerAdapter
            true
        }
        R.id.frg2 -> {
            val viewPager = findViewById<ViewPager2>(R.id.pager)
            val fragment: ArrayList<Fragment> = arrayListOf(FragmentDua(),FragmentTiga(),FragmentSatu())
            val pagerAdapter = PagerAdapter(this, fragment)
            viewPager.adapter = pagerAdapter
            true
        }
        R.id.frg3 -> {
            val viewPager = findViewById<ViewPager2>(R.id.pager)
            val fragment: ArrayList<Fragment> = arrayListOf(FragmentTiga(),FragmentSatu(),FragmentDua())
            val pagerAdapter = PagerAdapter(this, fragment)
            viewPager.adapter = pagerAdapter
            true
        }
        else -> {
            super.onOptionsItemSelected(item)
        }
    }
    class PagerAdapter(val activity: AppCompatActivity, val listFragment: ArrayList<Fragment>):
        FragmentStateAdapter(activity){
        override fun getItemCount(): Int = listFragment.size
        override fun createFragment(position: Int): Fragment = listFragment.get(position)
    }

}