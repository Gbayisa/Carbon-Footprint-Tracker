package com.example.slidebox.ui.recyclables;//package com.example.slidebox.ui.recyclables;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.slidebox.R;
import com.example.slidebox.User;


public class RecyclablesFragment extends Fragment {


    private RecyclablesViewModel recyclablesViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        recyclablesViewModel = new ViewModelProvider(this).get(RecyclablesViewModel.class);
        final View root = inflater.inflate(R.layout.recyclables_dialog, container, false);

        TextView textViewPaper = (TextView)root.findViewById(R.id.paperDialog);
        this.paperDialog(textViewPaper, root);

        TextView textViewMetal = (TextView)root.findViewById(R.id.metalDialog);
        this.metalDialog(textViewMetal, root);

        TextView textViewPlastic = (TextView)root.findViewById(R.id.plasticDialog);
        this.plasticDialog(textViewPlastic, root);

        TextView textViewGlass = (TextView)root.findViewById(R.id.glassDialog);
        this.glassDialog(textViewGlass, root);

        return root;
    }

    User user = User.getInstance();

    // Show single choice radio button in alert dialog.
    private void paperDialog(TextView textViewPaper, View v) {
        final TextView textViewTmp = textViewPaper;
        Button dialogPaperButton = (Button) v.findViewById(R.id.paperButton);
        dialogPaperButton.setOnClickListener(new View.OnClickListener() {

            private String chooseItem;
            int index;

            @Override
            public void onClick(final View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                builder.setIcon(R.mipmap.ic_launcher);
                builder.setTitle("What kind of paper are you recycling?");

                final String listItemArr[] = {"Old corrugated Containers", "Old Newspaper selected", "Standard Stationary Paper selected", "High Grade De-inked Paper selected"};
                final int[] points = {10,5,5,10};
                builder.setSingleChoiceItems(listItemArr, 0, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int itemIndex) {
                        chooseItem = listItemArr[itemIndex];
                        index = itemIndex;
                    }
                });

                builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(view.getContext(), "Item added: " + chooseItem, Toast.LENGTH_SHORT).show();
                        user.addPoints(points[index]);
                    }
                });

                builder.show();


            }
        });
    }


    private void metalDialog(TextView textViewMetal, View v) {
        final TextView textViewTmp = textViewMetal;
        Button dialogMetalButton = (Button) v.findViewById(R.id.metalButton);
        dialogMetalButton.setOnClickListener(new View.OnClickListener() {

            private String chooseItem;
            int index;

            @Override
            public void onClick(final View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                builder.setIcon(R.mipmap.ic_launcher);
                builder.setTitle("What kind of metal are you recycling?");

                final String listItemArr[] = {"Stationary items (ex. staplers)", "PC's, Laptops, tablets", "Batteries", "Generic scrap metal"};
                final int[] points = {5,20,5,5};
                builder.setSingleChoiceItems(listItemArr, 0, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int itemIndex) {
                        chooseItem = listItemArr[itemIndex];
                        index = itemIndex;
                    }
                });

                builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(view.getContext(), "Item added: " + chooseItem, Toast.LENGTH_SHORT).show();
                        user.addPoints(points[index]);
                    }
                });

                builder.show();


            }
        });
    }


    private void plasticDialog(TextView textViewPlastic, View v) {
        final TextView textViewTmp = textViewPlastic;
        Button dialogPlasticButton = (Button) v.findViewById(R.id.plasticButton);
        dialogPlasticButton.setOnClickListener(new View.OnClickListener() {

            private String chooseItem;
            int index;

            @Override
            public void onClick(final View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                builder.setIcon(R.mipmap.ic_launcher);
                builder.setTitle("What kind of plastic are you recycling?");

                final String listItemArr[] = {"Small plastic bottle (500ml Coke bottle)", "Medium plastic bottle (1L Coke bottle)", "Large plastic bottle (1.5L+ Coke bottle)", "Plastic cup/Container"};
                final int[] points = {10,15,20,5};
                builder.setSingleChoiceItems(listItemArr, 0, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int itemIndex) {
                        chooseItem = listItemArr[itemIndex];
                        index = itemIndex;
                    }
                });

                builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(view.getContext(), "Item added: " + chooseItem, Toast.LENGTH_SHORT).show();
                        user.addPoints(points[index]);
                    }
                });

                builder.show();


            }
        });
    }


    private void glassDialog(TextView textViewGlass, View v) {
        final TextView textViewTmp = textViewGlass;
        Button dialogGlassButton = (Button) v.findViewById(R.id.glassButton);
        dialogGlassButton.setOnClickListener(new View.OnClickListener() {

            private String chooseItem;
            int index;

            @Override
            public void onClick(final View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                builder.setIcon(R.mipmap.ic_launcher);
                builder.setTitle("What kind of glass are you recycling?");

                final String listItemArr[] = {"Transparent Glass", "Coloured Glass"};
                final int[] points = {5, 5};
                builder.setSingleChoiceItems(listItemArr, 0, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int itemIndex) {
                        chooseItem = listItemArr[itemIndex];
                        index = itemIndex;
                    }
                });

                builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(view.getContext(), "Item added: " + chooseItem, Toast.LENGTH_SHORT).show();
                        user.addPoints(points[index]);
                    }
                });

                builder.show();


            }
        });
    }



}
