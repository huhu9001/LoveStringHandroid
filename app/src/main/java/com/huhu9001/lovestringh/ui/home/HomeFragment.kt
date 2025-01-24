package com.huhu9001.lovestringh.ui.home

import android.view.View
import androidx.core.widget.doAfterTextChanged
import com.huhu9001.lovestringh.encoding.Encoder

class HomeFragment : androidx.fragment.app.Fragment() {
    private class EncodingAdaptor(context:android.content.Context)
        :android.widget.ArrayAdapter<Encoder>(context, android.R.layout.simple_spinner_item) {
        override fun getCount() = Encoder.encoders.size
        override fun getItem(position:Int) = Encoder.encoders[position]
        init { setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item) }
    }
    private class EscapestyleAdaptor(context:android.content.Context, private val spinnerEncoding:android.widget.Spinner)
        :android.widget.ArrayAdapter<Encoder.EscapeStyle>(context, android.R.layout.simple_spinner_item) {
        override fun getCount() =
            (spinnerEncoding.selectedItem as Encoder).styles.size
        override fun getItem(position: Int) =
            (spinnerEncoding.selectedItem as Encoder).styles[position]
        init { setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item) }
    }

    private var stopTextChangedOnce = false
    private var stopEscapestyleChangedOnce = false

    override fun onCreateView(
        inflater:android.view.LayoutInflater,
        container:android.view.ViewGroup?,
        savedInstanceState:android.os.Bundle?)
    : View {
        val body = com.huhu9001.lovestringh.databinding.FragmentHomeBinding.inflate(inflater, container, false)
        val context = requireContext()

        body.spinnerEncoding.adapter = EncodingAdaptor(context)
        body.spinnerEscapestyle.adapter = EscapestyleAdaptor(context, body.spinnerEncoding)

        @Suppress("UNUSED_PARAMETER") fun textChangedChar(p0:android.text.Editable?) {
            if (stopTextChangedOnce) return
            body.checkboxChangebytes.isChecked = true
            stopTextChangedOnce = true
            body.edittextByte.setText((body.spinnerEncoding.selectedItem as Encoder).encode(
                body.edittextChar.text,
                (body.spinnerEscapestyle.selectedItem as Encoder.EscapeStyle).escape))
            stopTextChangedOnce = false
        }

        @Suppress("UNUSED_PARAMETER") fun textChangedByte(p0:android.text.Editable?) {
            if (stopTextChangedOnce) return
            body.checkboxChangebytes.isChecked = false
            stopTextChangedOnce = true
            body.edittextChar.setText((body.spinnerEncoding.selectedItem as Encoder).decode(body.edittextByte.text))
            stopTextChangedOnce = false
        }

        val handler = android.os.Handler(context.mainLooper)
        handler.post {
            body.edittextChar.doAfterTextChanged(::textChangedChar)
            body.edittextByte.doAfterTextChanged(::textChangedByte)
            body.spinnerEncoding.onItemSelectedListener = object:android.widget.AdapterView.OnItemSelectedListener {
                override fun onItemSelected(p0:android.widget.AdapterView<*>?, p1:View?, p2:Int, p3:Long) {
                    val indexStyle = body.spinnerEscapestyle.selectedItemPosition
                    if (indexStyle >= body.spinnerEscapestyle.adapter.count) {
                        stopEscapestyleChangedOnce = true
                        body.spinnerEscapestyle.setSelection(0)
                        handler.post { handler.post { stopEscapestyleChangedOnce = false } }
                        /* Double Handler.post() is needed to ensure this flag clearing is executed after onItemSelected() */
                    }
                    if (body.checkboxChangebytes.isChecked)
                        textChangedChar(body.edittextChar.text)
                    else textChangedByte(body.edittextByte.text)
                    (body.spinnerEscapestyle.adapter as android.widget.BaseAdapter).notifyDataSetChanged()
                }
                override fun onNothingSelected(p0:android.widget.AdapterView<*>?) = p0?.setSelection(0) ?: Unit
            }
            body.spinnerEscapestyle.onItemSelectedListener = object:android.widget.AdapterView.OnItemSelectedListener {
                override fun onItemSelected(p0:android.widget.AdapterView<*>?, p1:View?, p2:Int, p3:Long) {
                    if (stopEscapestyleChangedOnce) return
                    textChangedChar(body.edittextChar.text)
                }
                override fun onNothingSelected(p0:android.widget.AdapterView<*>?) = p0?.setSelection(0) ?: Unit
            }
        }
        return body.root
    }
}