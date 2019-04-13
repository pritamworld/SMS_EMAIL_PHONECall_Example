package com.lambton.sms_email_phonecall_example.fragments;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.lambton.sms_email_phonecall_example.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * A simple {@link Fragment} subclass.
 */
public class SMSFragment extends Fragment
{


    @BindView(R.id.input_phone_number)
    EditText inputPhoneNumber;
    @BindView(R.id.input_layout_phone_number)
    TextInputLayout inputLayoutPhoneNumber;
    @BindView(R.id.input_text)
    EditText inputText;
    @BindView(R.id.input_layout_text)
    TextInputLayout inputLayoutText;
    @BindView(R.id.btnSms)
    Button btnSms;
    @BindView(R.id.txtClickTest)
    TextView txtClickTest;
    //Unbinder unbinder;

    public SMSFragment()
    {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sms, container, false);
        ButterKnife.bind(this, view);
        return view;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);

        SpannableString ss = new SpannableString("Call to get help  +1 234 567 8900");

        ClickableSpan spanNumber = new ClickableSpan() {
            @Override
            public void onClick(View textView) {
                Toast.makeText(getActivity(), "Make Call for Help", Toast.LENGTH_SHORT).show();
            }
        };

        ss.setSpan(spanNumber, 17, 33, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        txtClickTest.setText(ss);
        txtClickTest.setMovementMethod(LinkMovementMethod.getInstance());
    }

    @Override
    public void onDestroyView()
    {
        super.onDestroyView();
        //unbinder.unbind();
    }

    @OnClick(R.id.btnSms)
    public void onViewClicked()
    {

        String message = inputText.getText().toString();
        String phoneNo = inputPhoneNumber.getText().toString();
        if (!TextUtils.isEmpty(message) && !TextUtils.isEmpty(phoneNo))
        {
            Intent smsIntent = new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:" + phoneNo));
            smsIntent.putExtra("sms_body", message);
            if (smsIntent.resolveActivity(getActivity().getPackageManager()) != null)
            {
                startActivity(smsIntent);
                Toast.makeText(getActivity(), "SMS Sent", Toast.LENGTH_SHORT).show();
            } else
            {
                Toast.makeText(getActivity(), "No application to handle SMS", Toast.LENGTH_SHORT).show();
            }
        }

    }
}
