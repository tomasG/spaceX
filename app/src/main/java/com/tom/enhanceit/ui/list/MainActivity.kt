package com.tom.enhanceit.ui.list

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.tom.enhanceit.core.AppSchedulers
import com.tom.enhanceit.core.BaseActivity
import com.tom.enhanceit.core.Error
import com.tom.enhanceit.databinding.ActivityMainBinding
import com.tom.moviesapp.core.disposeBy
import org.koin.android.ext.android.inject
import java.lang.ref.WeakReference

class MainActivity : BaseActivity() {

    private val launchesAdapter: LaunchesAdapter = LaunchesAdapter(::onLaunchClicked)
    lateinit var binding: ActivityMainBinding

    private val presenter: PresenterSpaceX by inject()
    private val schedulers: AppSchedulers by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setView()
        callLaunches()
    }

    private fun setView() {
        binding.recycler.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = launchesAdapter
            addItemDecoration(
                DividerItemDecoration(
                    this@MainActivity,
                    LinearLayoutManager.VERTICAL
                )
            )
        }
    }

    private fun callLaunches() {
        presenter.getLaunches()
            .subscribeOn(schedulers.io())
            .observeOn(schedulers.mainThread())
            .subscribe(
                { list ->
                    binding.loader.visibility = View.GONE
                    launchesAdapter.list = list
                },
                { throwable ->
                    binding.loader.visibility = View.GONE
                    showSnackBarError(
                        binding.root, Error.getError(
                            WeakReference(
                                this@MainActivity
                            ), throwable
                        )
                    ) {
                        binding.loader.visibility = View.GONE
                    }
                }).disposeBy(disposable)
    }

    private fun onLaunchClicked(id: Long, view: View) {

    }
}