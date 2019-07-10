package com.example.bicycleanimation;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class Bicycle extends View{
    public Bicycle(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    int r = 27;
    float x1= 500,y1=600,x2=600,y2=600;
    float[] firstWheel = {500,600};float[] secondWheel = {600,600};
    int posx = 0, posy = 0;
    int velx = 0, vely = 0;
    char flip = ' ';
    int x = 1;
    int degree = 0;
    Canvas c;
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
            System.out.println(canvas.getHeight()+" "+canvas.getWidth());

        if ( posx+velx + x2 + r < canvas.getWidth() && posx + velx + x1 - r > 0 ){
            posx += velx;
        }
        if (posy +  vely + x2 +  r+50  < canvas.getHeight() && posy + vely + x2 - r-50> 0 ){
            posy += vely;
        }

        if (flip == 'r'){
            x = 1;
            degree = 0;
        }

        if (flip == 'l'){
            x = -1;
            degree = 0;
        }

        if (flip == 'd'){
            x = 1;
            degree = 90;
        }

        if (flip == 'u'){
            x = -1;
            degree = 90;
        }
        canvas.translate(posx, posy);
        transformBike(canvas);

        drawBike(canvas);

        velx =0; vely=0;
        //flip = ' ';
    }


    public void moveBike(String m){
            if ( m == "down"){
                flip = 'd';
            }
            else if (m == "up"){
                flip = 'u';
            }
            else if (m == "right"){
                flip = 'r';
            }
            else if (m == "left"){
                flip = 'l';
            }

        switch (m){
            case "up":
                vely = -10;
                break;
            case "down":
                vely = 10;
                break;
            case "left":
                velx = -10;
                break;
            case "right":
                velx = 10;
                break;
        }
        postInvalidate();
    }

    public void drawBike(Canvas canvas){
        Paint p = new Paint();
        p.setStyle(Paint.Style.STROKE);
        p.setColor(Color.BLACK);
        p.setStrokeWidth(7);
        canvas.drawCircle(x1, y1, r, p);
        canvas.drawCircle(x2, y2, r, p );
        canvas.drawLine(x1,y1,x2,y1,p); 
        canvas.drawLine(x2,y2,x2,y2-70,p);
        canvas.drawLine((x1+x2)/2,y1,(x1+x2)/2,y1-40,p);
        canvas.drawLine((x1+x2)/2-10,y1-40,(x1+x2)/2+10,y1-40,p);
    }

    public void transformBike(Canvas canvas){
        canvas.rotate(degree, (x1 + x2)/2  , y1);
        canvas.scale(x, 1, (x1 + x2)/2  , y1);
    }


}
