package com.example.mbtitest

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2

class TestActivity : AppCompatActivity() {

    private lateinit var viewPager: ViewPager2

    val questionnaireResults = QuestionnaireResults()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)

        viewPager = findViewById(R.id.viewPager)
        viewPager.adapter = ViewPagerAdapter(this)
        viewPager.isUserInputEnabled = false // 화면을 터치로 좌우로 넘기면 새로운 viewpager는 새로운 페이지가 나옴. 그걸 막아줘야함

    }

    fun moveToNextQuestion(){
        if(viewPager.currentItem == 3 ) {


            // 마지막 페이지 결과 화면으로 이동

        } else {
            val nextItem = viewPager.currentItem +1
            if(nextItem < viewPager.adapter?.itemCount ?: 0) {
                viewPager.setCurrentItem(nextItem, true)
            }
        }
    }

}

class QuestionnaireResults {
    val results = mutableListOf<Int>()

    fun addResponse(response: List<Int>) {
        val mostFrequent = response.groupingBy{ it }.eachCount().maxByOrNull { it.value }?.key
        mostFrequent.let { results.add(it) }
    }
}