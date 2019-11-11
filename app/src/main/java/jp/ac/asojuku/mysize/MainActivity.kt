package jp.ac.asojuku.mysize

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import android.view.View
import androidx.core.content.edit
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResume(){
        super.onResume();
        //共有プリファレンスの取得う
        val pref = PreferenceManager.getDefaultSharedPreferences(this);
        //共有プリファレンスのいんすたんすから4つの保存済みの値を取り出す
        val editNeck = pref.getString("NECK","");
        val editSleeve = pref.getString("SLEEVE","");
        val editWaist = pref.getString("WAIST","");
        val editInseam = pref.getString("INSEAM","");
        //所得した保存値で各入力欄を上書き
        neck.setText(editNeck);
        sleeve.setText(editSleeve);
        waist.setText(editWaist);
        inseam.setText(editInseam);
        //保存btnを押した時の動作
        save.setOnClickListener{ onSaveTapped() };

        //身長ボタン処理
        heightButton.setOnClickListener{
            //インデント生成( どこからどこまで情報 )
            val intent = Intent(this, HeightActivity::class.java);
            startActivity(intent);
        }
    }



    private fun onSaveTapped() {
        val pref = PreferenceManager.getDefaultSharedPreferences(this);
        pref.edit {
            putString("NECK", neck.text.toString());
            putString("SLEEVE",sleeve.text.toString());
            putString("WAIST",waist.text.toString());
            putString("INSEAM",inseam.text.toString());
        }
    }
}
