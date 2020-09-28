package id.firman.movies.movie

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import id.firman.movies.R
import id.firman.movies.movie.nowplaying.NowPlayingFragment
import id.firman.movies.movie.popular.PopularFragment
import id.firman.movies.movie.upcoming.UpcomingFragment
import kotlinx.android.synthetic.main.activity_main.*

class MovieActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setToolbar()
        bottom_navigation.setOnNavigationItemSelectedListener({ item ->
            when (item.itemId) {
                R.id.playing -> {
                    loadPlayingFragment(savedInstanceState)
                }
                R.id.upcoming -> {
                    loadUpcomingFragment(savedInstanceState)
                }
                R.id.popular -> {
                    loadPopularFragment(savedInstanceState)
                }
            }
            true
        })
        bottom_navigation.selectedItemId = R.id.playing
        

    }

    private fun setToolbar() {
        setSupportActionBar(toolbar)
        supportActionBar?.title = getString(R.string.app_name)
    }

    private fun loadPlayingFragment(savedInstanceState: Bundle?) {
        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.main_container, NowPlayingFragment(), NowPlayingFragment::class.simpleName)
                .commit()
        }
    }

    private fun loadUpcomingFragment(savedInstanceState: Bundle?) {
        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.main_container, UpcomingFragment(), UpcomingFragment::class.simpleName)
                .commit()
        }
    }

    private fun loadPopularFragment(savedInstanceState: Bundle?) {
        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.main_container, PopularFragment(), PopularFragment::class.simpleName)
                .commit()
        }
    }

}
