package vn.beautylife.viewpagertransform

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.annotation.SuppressLint
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.view.ViewPager
import android.support.v7.widget.LinearLayoutManager
import android.view.MotionEvent
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.abs

class MainActivity : AppCompatActivity(), View.OnTouchListener {
    private val imageList: MutableList<Int> = mutableListOf()
    private val initialPosition = 2
    private var x1: Float? = null
    private var x2: Float? = null

    companion object {
        private const val SWIPE_MIN_THRESHOLD = 5
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initData()
        setupViews()
    }

    private fun initData() {
        imageList.add(R.drawable.img1)
        imageList.add(R.drawable.img2)
        imageList.add(R.drawable.img3)
        imageList.add(R.drawable.img4)
        imageList.add(R.drawable.img5)
        imageList.add(R.drawable.img6)
        imageList.add(R.drawable.img7)
        imageList.add(R.drawable.img8)
        imageList.add(R.drawable.img9)
    }

    private fun setupViews() {
        setupViewPager()
        setupRecyclerView()
    }

    private fun setupViewPager() {
        val imageAdapter = ImagePagerAdapter(supportFragmentManager, imageList)
        viewPager.run {
            adapter = imageAdapter
            //setPageTransformer(true, )
            offscreenPageLimit = 4
            currentItem = initialPosition
            setOnTouchListener(this@MainActivity)
            addOnPageChangeListener(object : ViewPager.SimpleOnPageChangeListener() {
                override fun onPageSelected(position: Int) {
                    recyclerView.scrollToPosition(position)
                }
            })
        }
    }

    private fun setupRecyclerView() {
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        val recyclerAdapter = ImageListAdapter(imageList).apply {
            setOnItemClickListener { viewPager.currentItem = it }
        }
        recyclerView.run {
            setHasFixedSize(true)
            setItemViewCacheSize(5)
            setLayoutManager(layoutManager)
            adapter = recyclerAdapter
            scrollToPosition(initialPosition)
        }
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onTouch(v: View?, event: MotionEvent?): Boolean {
        when(event?.action) {
            MotionEvent.ACTION_DOWN -> x1 = event.x
            MotionEvent.ACTION_MOVE -> return false // Swipe horizon
            MotionEvent.ACTION_UP -> {
                x2 = event.x
                return if (abs(x2!! - x1!!) > SWIPE_MIN_THRESHOLD) { // Swipe horizon
                    false
                } else { // single tap = hide/show recycerView
                    showRecyclerView(!recyclerView.isShown)
                    true
                }
            }
        }
        return false
    }

    private fun showRecyclerView(show: Boolean = true) {
        recyclerView.animate()
                .alpha(if (show) 1f else 0f)
                .setDuration(500)
                .setListener(object : AnimatorListenerAdapter() {
                    override fun onAnimationEnd(animation: Animator?) {
                        super.onAnimationEnd(animation)
                        recyclerView.visibility = if (show) View.VISIBLE else View.GONE
                    }
                })
                .start()
    }

}
