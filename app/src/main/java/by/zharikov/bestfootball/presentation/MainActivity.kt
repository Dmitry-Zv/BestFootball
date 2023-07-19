package by.zharikov.bestfootball.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import by.zharikov.bestfootball.R
import by.zharikov.bestfootball.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val navController =
            (supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment).findNavController()
        with(binding) {
            bottomNavigation.setupWithNavController(
                navController = navController
            )
            bottomNavigation.setOnItemReselectedListener {
                when (it.itemId) {
                    R.id.home -> navController.navigateUp()
                    R.id.live -> navController.navigateUp()
                    R.id.standings -> navController.navigateUp()
                }
            }
        }


    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}