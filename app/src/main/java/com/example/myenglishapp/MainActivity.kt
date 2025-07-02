package com.example.myenglishapp


import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.myenglishapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        // Setup drawer toggle
        toggle = ActionBarDrawerToggle(this, binding.drawerLayout, binding.toolbar,
            R.string.open, R.string.close)
        binding.drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        // Handle drawer item clicks
        binding.navView.setNavigationItemSelectedListener {
            // ✅ Show a toast when an item is clicked
            Toast.makeText(this, "Clicked ${it.title}", Toast.LENGTH_SHORT).show()

            when (it.itemId) {
                R.id.menu_home -> loadFragment(HomeFragment())
                R.id.menu_practice -> loadFragment(PracticeFragment())
                R.id.menu_profile -> loadFragment(ProfileFragment())
            }

            binding.drawerLayout.closeDrawers()
            true
        }

        // Handle bottom nav clicks
        binding.bottomNav.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.nav_home -> loadFragment(HomeFragment())
                R.id.nav_practice -> loadFragment(PracticeFragment())
                R.id.nav_profile -> loadFragment(ProfileFragment())
            }
            true
        }

        // Load default fragment
        loadFragment(HomeFragment())
    }

    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }
}
