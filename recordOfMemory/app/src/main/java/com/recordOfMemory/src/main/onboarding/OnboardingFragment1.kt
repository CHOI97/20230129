package com.recordOfMemory.src.main.onboarding

import android.R
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.recordOfMemory.databinding.FragmentOnboarding1Binding
import com.recordOfMemory.src.main.MainActivity


class OnboardingFragment1 : Fragment() {
    private lateinit var viewBinding: FragmentOnboarding1Binding

    var mainActivity: MainActivity? = null
    override fun onAttach(context: Context) {
        super.onAttach(context)
        mainActivity = context as MainActivity
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewBinding = FragmentOnboarding1Binding.inflate(inflater, container, false)
        mainActivity!!.hideMainFragment(true)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        //다음 누르면
        viewBinding.nextBtn.setOnClickListener {
            mainActivity!!.openFragmentOnOnboarding(2)
        }
        //건너뛰기 누르면
        viewBinding.skipBtn.setOnClickListener {
            mainActivity!!.hideMainFragment(false)
        }
    }
}