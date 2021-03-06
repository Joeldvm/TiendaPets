package com.bbva.petagram;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link fragment_recview#newInstance} factory method to
 * create an instance of this fragment.
 */
public class fragment_recview extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    ArrayList<ListaPets> lista = new ArrayList<ListaPets>();
    private RecyclerView lista_pets;

    public fragment_recview() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment fragment_recview.
     */
    // TODO: Rename and change types and number of parameters
    public static fragment_recview newInstance(String param1, String param2) {
        fragment_recview fragment = new fragment_recview();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_recview, container, false);

        lista_pets = (RecyclerView) v.findViewById(R.id.rvpets);


        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        lista_pets.setLayoutManager(llm);

        lista.add(new ListaPets("Gato",R.drawable.gato1));
        lista.add(new ListaPets("Perro",R.drawable.perro2));
        lista.add(new ListaPets("Perrito",R.drawable.perro3));

        inicializaAdaptador();

        return  v;
    }

    public void inicializaAdaptador(){
        PetsAdaptador adaptador = new PetsAdaptador(lista);
        lista_pets.setAdapter(adaptador);

    }
}