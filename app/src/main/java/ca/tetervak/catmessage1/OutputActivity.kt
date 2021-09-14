package ca.tetervak.catmessage1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ca.tetervak.catmessage1.databinding.ActivityOutputBinding
import ca.tetervak.catmessage1.model.Envelope

class OutputActivity : AppCompatActivity() {

    companion object{
        const val ENVELOPE = "Envelope"
    }

    private lateinit var binding: ActivityOutputBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOutputBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // get and display the message data
        val envelope = intent.getSerializableExtra(ENVELOPE) as Envelope
        binding.messageText.text = envelope.textMessage
        binding.isUrgentOutput.text =
            if (envelope.isUrgent) {
                getString(R.string.urgent)
            } else {
                getString(R.string.not_urgent)
            }

        // make the close button work
        binding.backButton.setOnClickListener { finish() }
    }
}