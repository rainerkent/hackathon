package com.r2sdittos.hackathon;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.view.MenuInflater;


import com.r2sdittos.hackathon.Entity.MissionEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link MissionFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link MissionFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MissionFragment extends Fragment {

    private RecyclerView recyclerView;

    public MissionFragment() {
    }

    public static MissionFragment newInstance() {
        MissionFragment fragment = new MissionFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_mission, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        List<MissionEntity> missionList = new ArrayList<>();
        missionList.add(new MissionEntity("Push-ups", "Do 50 push-ups in the morning and 50 push-ups in the afternoon"));
        missionList.add(new MissionEntity("Watch movie with friends", "Go out to the nearest moviehouse and bond with your friends"));

        recyclerView.setAdapter(new MissionListAdapter(missionList, getContext()));
    }

    // TODO: Rename method, update argument and hook method into UI event
//    public void onButtonPressed(Uri uri) {
////        if (mListener != null) {
////            mListener.onFragmentInteraction(uri);
////        }
//    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
//        if (context instanceof OnFragmentInteractionListener) {
//            mListener = (OnFragmentInteractionListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
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
//    public interface OnFragmentInteractionListener {
//        // TODO: Update argument type and name
//        void onFragmentInteraction(Uri uri);
//    }
    public class MissionListAdapter extends RecyclerView.Adapter<MissionListHolder> {
        private List<MissionEntity> list;
        private Context context;
        private int position;

        public MissionListAdapter(List<MissionEntity> list, Context context) {
            this.list = list;
            this.context = context;
        }

        @Override
        public MissionListHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater
                    .from(parent.getContext())
                    .inflate(R.layout.layout_mission_item, parent, false);

            return new MissionListHolder(view);
        }

        @Override
        public void onBindViewHolder(final MissionListHolder holder, int position) {
            holder.title.setText(list.get(position).getTitle());
            holder.description.setText(list.get(position).getDescription());
            holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    setPosition(holder.getPosition());
                    return false;
                }
            });
        }

        @Override
        public void onViewRecycled(MissionListHolder holder) {
            holder.itemView.setOnLongClickListener(null);
            super.onViewRecycled(holder);
        }

        @Override
        public int getItemCount() {
            return list.size();
        }

        public int getPosition() {
            return position;
        }

        public void setPosition(int position) {
            this.position = position;
        }
    }

    public class MissionListHolder extends RecyclerView.ViewHolder implements View.OnCreateContextMenuListener {
        TextView title, description;
        public MissionListHolder(View view) {
            super(view);
            title = view.findViewById(R.id.title);
            description = view.findViewById(R.id.description);
            view.setOnCreateContextMenuListener(this);
        }

        @Override
        public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
            MenuInflater inflater = new MenuInflater(v.getContext());
            inflater.inflate(R.menu.context_menu_challenge, menu);
        }

    }
}
