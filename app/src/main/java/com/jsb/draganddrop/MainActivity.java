package com.jsb.draganddrop;

import android.content.ClipData;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView pb1,pb2,pb3,gd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pb1 = findViewById(R.id.prueba1);
        pb2 = findViewById(R.id.prueba2);
        pb3 = findViewById(R.id.prueba3);
        gd = findViewById(R.id.draganddrop);


        pb1.setOnTouchListener(touchListener);

        //pb1.setOnLongClickListener(longClickListener);
        pb2.setOnLongClickListener(longClickListener);
        pb3.setOnLongClickListener(longClickListener);
        gd.setOnDragListener(dragListener);



    }

    View.OnTouchListener touchListener = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            ClipData data = ClipData.newPlainText("","");
            View.DragShadowBuilder myShadowBuilder = new View.DragShadowBuilder(v);
            v.startDrag(data, myShadowBuilder,v,0);
            return true;
        }
    };
    View.OnLongClickListener longClickListener = new View.OnLongClickListener() {
        @Override
        public boolean onLongClick(View v) {
            ClipData data = ClipData.newPlainText("","");
            View.DragShadowBuilder myShadowBuilder = new View.DragShadowBuilder(v);
            v.startDrag(data, myShadowBuilder,v,0);
            return true;
        }
    };

    View.OnDragListener dragListener = new View.OnDragListener() {
        @Override
        public boolean onDrag(View v, DragEvent event) {
            int dragEvent = event.getAction();

            switch (dragEvent){
                case DragEvent.ACTION_DRAG_ENTERED:
                    final View view = (View) event.getLocalState();

                    if (view.getId() == R.id.prueba1){
                        gd.setText("Prueba 1");
                    }else if(view.getId()==R.id.prueba2){
                        gd.setText("Prueba 2");
                    }else if(view.getId()==R.id.prueba3){
                        gd.setText("Prueba 3");
                    }

                    break;

                case DragEvent.ACTION_DRAG_EXITED:
                    break;

                case DragEvent.ACTION_DROP:
                    break;
            }
            return true;
        }
    };

}
