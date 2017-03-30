package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * Created by Lotte on 30.03.2017.
 */
public class Planet extends MyGdxGame{
    TextureRegion region;
    double speed;
    double x, y, radius;
    int x0, y0;

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public void setPoint(int _x0, int _y0){
        x0 = _x0;
        y0 = _y0;
    }

    public void setRegion(Texture texture, int x, int y, int width, int height){
        region = new TextureRegion(texture, x, y, width, height);
    }

    public TextureRegion getRegion(){
        return region;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public void move(double alpha){
        x=x0+radius*Math.sin(alpha);
        y=y0+radius*Math.cos(alpha);
    }

    public void setCoordinates(int _x, int _y){
        x = _x;
        y = _y;
    }

    public int getY(){
        return (int)y;
    }

    public int getX(){
        return (int)x;
    }
}
