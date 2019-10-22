package com.example.fragments_ejercicio;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FragmentOne.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class FragmentOne extends Fragment {
    private EditText textViewFragmentOne;
    private ImageView indicator;
    private int colorId = android.R.color.black;
    Button buttonFragmentOne;



    private void changeColor() {
        indicator.setColorFilter(ContextCompat.getColor(getContext(), colorId));
    }


    private OnFragmentInteractionListener mListener;

        public static FragmentOne newInstance() {
            return new FragmentOne();
        }
        // Required empty public constructor


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_fragment_one, container, false);
        textViewFragmentOne = rootView.findViewById(R.id.textViewFragmentOne);
        buttonFragmentOne = rootView.findViewById(R.id.buttonFragmentOne);
        indicator = rootView.findViewById(R.id.indicator);
        buttonFragmentOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onButtonPressed(colorId);
            }
        });
        Button colorOne = rootView.findViewById(R.id.colorOne);
        Button colorTwo = rootView.findViewById(R.id.colorTwo);
        Button colorThree = rootView.findViewById(R.id.colorThree);
        Button colorFour = rootView.findViewById(R.id.colorFour);
        colorOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                colorId = android.R.color.holo_blue_dark;
                changeColor();
            }
        });
        colorTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                colorId = android.R.color.holo_green_dark;
                changeColor();
            }
        });
        colorThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                colorId = android.R.color.holo_orange_dark;
                changeColor();
            }
        });
        colorFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                colorId = android.R.color.holo_red_dark;
                changeColor();
            }
        });
        return rootView;
    }

    // TODO: Rename method, update argument and hook method into UI event
    private void onButtonPressed(int colorId) {
        if (mListener != null) {
            mListener.onFragmentInteraction(textViewFragmentOne.getText().toString(), colorId);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(String text, int colorId);
    }
}
