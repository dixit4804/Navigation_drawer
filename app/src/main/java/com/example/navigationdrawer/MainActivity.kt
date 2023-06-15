package com.example.navigationdrawer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.fragment.app.FragmentTransaction
import com.example.namespace.R
import com.example.navigationdrawer.fragment.aboutusFragment
import com.example.navigationdrawer.fragment.homeFragment
import com.example.navigationdrawer.fragment.logoutFragment
import com.example.navigationdrawer.fragment.profileFragment
import com.example.navigationdrawer.fragment.rateusFragment
import com.example.navigationdrawer.fragment.reportFragment
import com.example.navigationdrawer.fragment.settingFragment
import kotlinx.android.synthetic.main.activity_main.drawer_layout
import kotlinx.android.synthetic.main.activity_main.navigationView
import kotlinx.android.synthetic.main.mytoolbar.myToolbar

class MainActivity : AppCompatActivity() {

    private lateinit var Home: homeFragment
    private lateinit var Profile :profileFragment
    private lateinit var Setting :settingFragment
    private lateinit var Rateus :rateusFragment
    private lateinit var Aboutus  :aboutusFragment
    private lateinit var Report :reportFragment
    private lateinit var LogOut :logoutFragment



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(myToolbar)
        val toggle = ActionBarDrawerToggle(this,drawer_layout,myToolbar,0,0)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        Home = homeFragment()
        supportFragmentManager.beginTransaction().replace(R.id.container,Home).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
            .commit()
        setUpnavigation()

    }

    private fun setUpnavigation() {
        navigationView.setNavigationItemSelectedListener { menuItem ->
            menuItem.isChecked = false
            drawer_layout.closeDrawers()

            when(menuItem.itemId){
                R.id.navhome ->{
                    Home = homeFragment()
                    myToolbar.title="Home"
                    supportFragmentManager.beginTransaction().replace(R.id.container,Home).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()
                }

                R.id.navprofile ->{
                    Profile =profileFragment()
                    myToolbar.title="Profile"
                    supportFragmentManager.beginTransaction().replace(R.id.container,Profile).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()
                }

                R.id.navsetting ->{
                    Setting = settingFragment()
                    myToolbar.title="Seting"
                    supportFragmentManager.beginTransaction().replace(R.id.container,Setting).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()
                }

                R.id.navRateus ->{
                    Rateus = rateusFragment()
                    myToolbar.title="Rate us"
                    supportFragmentManager.beginTransaction().replace(R.id.container,Rateus).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()
                }

                R.id.navAboutus ->{
                    Aboutus = aboutusFragment()
                    myToolbar.title="About us"
                    supportFragmentManager.beginTransaction().replace(R.id.container,Aboutus).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()
                }

                R.id.navreport ->{
                    Report = reportFragment()
                    myToolbar.title="Report us"
                    supportFragmentManager.beginTransaction().replace(R.id.container,Report).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()
                }
                R.id.navlogout ->{
                    LogOut =logoutFragment()
                    myToolbar.title="Log Out"
                    supportFragmentManager.beginTransaction().replace(R.id.container,LogOut).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()
                }
            }
            true
        }
    }
}