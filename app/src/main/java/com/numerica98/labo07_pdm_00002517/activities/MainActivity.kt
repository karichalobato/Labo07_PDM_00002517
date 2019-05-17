package com.numerica98.labo07_pdm_00002517.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.numerica98.labo07_pdm_00002517.R
import com.numerica98.labo07_pdm_00002517.database.entities.GitHubRepo
import com.numerica98.labo07_pdm_00002517.viewModels.GitHubRepoViewModel
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    lateinit var viewModel: GitHubRepoViewModel
    var contador = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bind()
    }
    //TODO RECIBE UNA ACTIVIDAD PARA PODERLA LINKEAR
    private fun bind(){
        viewModel = ViewModelProviders.of(this).get(GitHubRepoViewModel::class.java)

        viewModel.getRepoList().observe(this, Observer {
            Log.d("Repos", "--------------------------------------------------------")
            for (i in 0 until it.size){
                Log.d("Repos", it[i].name)
            }
        })//TODO NOS DEVUELVE UN LIVE DATA DE ESA LISTA. EL PUNTO OBSER ES PARTE DE LIVE DATA

        bt_accion.setOnClickListener {
            viewModel.insert(GitHubRepo("Repository #" + contador))
            contador ++
        }
    }
}
