package ca.tetervak.catmessage1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ca.tetervak.catmessage1.OutputActivity.Companion.ENVELOPE
import ca.tetervak.catmessage1.databinding.ActivityMainBinding
import ca.tetervak.catmessage1.model.Envelope

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.sendButton.setOnClickListener{showOutput()}
    }

    private fun showOutput(){
        // get urgent flag value
        val urgent = binding.urgentCheckBox.isChecked

        // get the selected message text
        val message = when (binding.messageGroup.checkedRadioButtonId) {
            R.id.purr_button -> getString(R.string.cat_purr)
            R.id.mew_button -> getString(R.string.cat_mew)
            R.id.hiss_button -> getString(R.string.cat_hiss)
            else -> getString(R.string.undefined)
        }

        val intent = Intent(this, OutputActivity::class.java).apply {
            putExtra(ENVELOPE, Envelope(urgent, message))
        }
        startActivity(intent)
    }
}