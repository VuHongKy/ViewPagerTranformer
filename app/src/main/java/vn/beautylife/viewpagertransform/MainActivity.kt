package vn.beautylife.viewpagertransform

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.annotation.SuppressLint
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.view.ViewPager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.MotionEvent
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import vn.beautylife.pagertransformerlibrary.*
import kotlin.math.abs

class MainActivity : AppCompatActivity(), View.OnTouchListener {
    private val transformerList = mutableListOf<String>()
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

        transformerList.add(AccordionTransformer::class.java.name)
        transformerList.add(ParallaxPageTransformer::class.java.name)
        transformerList.add(StackTransformer::class.java.name)
        transformerList.add(ZoomInTransformer::class.java.name)
        transformerList.add(ZoomOutTransformer::class.java.name)
        transformerList.add(ZoomOutSlideTransformer::class.java.name)
        transformerList.add(DepthPageTransformer::class.java.name)
        transformerList.add(BackgroundToForegroundTransformer::class.java.name)
        transformerList.add(ForegroundToBackgroundTransformer::class.java.name)

        transformerList.add(CubeOutTransformer::class.java.name)
        transformerList.add(CubeInTransformer::class.java.name)
        transformerList.add(FlipHorizontalTransformer::class.java.name)
        transformerList.add(FlipVerticalTransformer::class.java.name)
        transformerList.add(RotateUpTransformer::class.java.name)
        transformerList.add(RotateDownTransformer::class.java.name)
        transformerList.add(DrawFromBackTransformer::class.java.name)
        transformerList.add(TabletTransformer::class.java.name)
        transformerList.add(DefaultTransformer::class.java.name)
    }

    private fun setupViews() {
        setupViewPager()
        setupRecyclerTransformer()
        setupRecyclerImage()
    }

    private fun setupViewPager() {
        val imageAdapter = ImagePagerAdapter(supportFragmentManager, imageList)
        viewPager.run {
            adapter = imageAdapter
            setPageTransformer(true, ZoomOutTransformer())
            offscreenPageLimit = 4
            currentItem = initialPosition
            setOnTouchListener(this@MainActivity)
            addOnPageChangeListener(object : ViewPager.SimpleOnPageChangeListener() {
                override fun onPageSelected(position: Int) {
                    recyclerImage.scrollToPosition(position)
                }
            })
        }
    }

    private fun setupRecyclerTransformer() {
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        val recyclerAdapter = TransformerNameAdapter(transformerList, 4).apply {
            setOnItemClickListener { onItemTransformerClick(this, it) }
        }
        recyclerTransformer.run {
            setHasFixedSize(true)
            setItemViewCacheSize(5)
            this.layoutManager = layoutManager
            itemAnimator = ReuseItemAnimator()
            adapter = recyclerAdapter
        }
    }

    private fun onItemTransformerClick(adapter: TransformerNameAdapter, position: Int) {
        adapter.selectItem(position)
        showRecyclerView(recyclerTransformer, false)
        showRecyclerView(recyclerImage, false)
        viewPager.setPageTransformer(true,
                if (transformerList[position] == ParallaxPageTransformer::class.java.name)
                    ParallaxPageTransformer(R.id.image)
                else createObjectFromClassName(transformerList[position])
        )
    }

    private fun createObjectFromClassName(className: String): ViewPager.PageTransformer {
        val clazz = Class.forName(className) // className full, not simpleName
        return clazz.getConstructor().newInstance() as ViewPager.PageTransformer
    }

    private fun setupRecyclerImage() {
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        val recyclerAdapter = ImageListAdapter(imageList).apply {
            setOnItemClickListener { viewPager.currentItem = it }
        }
        recyclerImage.run {
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
                    showRecyclerView(recyclerTransformer, !recyclerTransformer.isShown)
                    showRecyclerView(recyclerImage, !recyclerImage.isShown)
                    true
                }
            }
        }
        return false
    }

    private fun showRecyclerView(recyclerView: RecyclerView, show: Boolean = true) {
        if (show) recyclerView.visibility = View.VISIBLE
        recyclerView.animate()
                .alpha(if (show) 1f else 0f)
                .setDuration(500)
                .setListener(object : AnimatorListenerAdapter() {
                    override fun onAnimationEnd(animation: Animator?) {
                        super.onAnimationEnd(animation)
                        if (!show) recyclerView.visibility = View.GONE
                    }
                })
                .start()
    }

}
