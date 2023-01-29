package com.recordOfMemory.src.main

import android.os.Bundle
import android.view.View
import com.recordOfMemory.R
import com.recordOfMemory.config.BaseActivity
import com.recordOfMemory.databinding.ActivityMainBinding
import com.recordOfMemory.src.main.calendar.CalendarFragment
import com.recordOfMemory.src.main.home.HomeFragment
import com.recordOfMemory.src.main.myPage.MyPageFragment
import com.recordOfMemory.src.main.onboarding.OnboardingFragment1
import com.recordOfMemory.src.main.onboarding.OnboardingFragment2
import com.recordOfMemory.src.main.onboarding.OnboardingFragment3
import com.recordOfMemory.src.main.onboarding.OnboardingFragment4

class MainActivity : BaseActivity<ActivityMainBinding>(ActivityMainBinding::inflate) {

    //https://sbe03005dev.tistory.com/entry/Android-Kotlin-%EC%95%88%EB%93%9C%EB%A1%9C%EC%9D%B4%EB%93%9C-%EC%BD%94%ED%8B%80%EB%A6%B0-Fragment-%EC%83%81%ED%83%9C-%EC%9C%A0%EC%A7%80
    //replace 대신 add, show, hide

    private var fragment1 = OnboardingFragment1()
    private var fragment2 = OnboardingFragment2()
    private var fragment3 = OnboardingFragment3()
    private var fragment4 = OnboardingFragment4()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //온보딩 레이아웃 보이게 하기
        val transaction = supportFragmentManager.beginTransaction()
            .replace(binding.onboardingFrm.id, fragment1)
        transaction.commit()
        //메인 레이아웃 보이게 하기
        supportFragmentManager.beginTransaction().replace(binding.mainFrm.id, HomeFragment()).commitAllowingStateLoss()
        binding.mainBtmNav.run {
            setOnItemSelectedListener { item ->
                when (item.itemId) {
                    R.id.menu_main_btm_nav_home -> {
                        supportFragmentManager.beginTransaction()
                            .replace(binding.mainFrm.id, HomeFragment())
                            .commitAllowingStateLoss()
                    }
                    R.id.menu_main_btm_nav_calendar -> {
                        supportFragmentManager.beginTransaction()
                            .replace(binding.mainFrm.id, CalendarFragment())
                            .commitAllowingStateLoss()
                    }
                    R.id.menu_main_btm_nav_mypage -> {
                        supportFragmentManager.beginTransaction()
                            .replace(binding.mainFrm.id, MyPageFragment())
                            .commitAllowingStateLoss()
                    }
                }
                true
            }
            selectedItemId = R.id.menu_main_btm_nav_home
        }
    }

    // 온보딩 fragment 바꾸는 메소드
    fun openFragmentOnOnboarding(int: Int){
        val transaction = supportFragmentManager.beginTransaction()
        when(int){
            1 -> transaction.replace(binding.onboardingFrm.id, fragment1)
            2 -> transaction.replace(binding.onboardingFrm.id, fragment2)
            3 -> transaction.replace(binding.onboardingFrm.id, fragment3)
            4 -> transaction.replace(binding.onboardingFrm.id, fragment4)
        }
        transaction.commit()
    }

    //메인 레이아웃 안보이게 하기
    fun hideMainFragment(bool: Boolean) {
        if (bool)  {
            // 안보이게
            binding.mainFrm.visibility = View.GONE
            binding.mainBtmNav.visibility = View.GONE
        } else {
            // 보이게
            binding.onboardingFrm.visibility = View.GONE
            binding.mainBtmNav.visibility = View.VISIBLE
            binding.mainFrm.visibility = View.VISIBLE
        }
    }
}
