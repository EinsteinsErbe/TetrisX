package com.major94.TetrisX.other;

public class Vector2f {

	public float x, y;

	public Vector2f(float x, float y) {
		this.x = x;
		this.y = y;
	}

	public Vector2f(Vector2f v) {
		this.x = v.x;
		this.y = v.y;
	}

	public float length(){
		return (float)Math.sqrt(x*x+y*y);
	}

	public float angle(){
		float angle = 0;

		if(x==0){
			if(y>0){
				angle = 90;
			}
			if(y==0){
				angle = 0;
			}
			if(y<0){
				angle = 270;
			}
		}
		else{
			angle = (float)(Math.atan(y/x)*180/Math.PI);
			if(x>0){
				if(y<0){
					angle += 360;
				}
			}
			else{
				angle += 180;
			}
		}
		return angle;
	}

	public void add(float x, float y){
		this.x += x;
		this.y += y;
	}

	public void add(Vector2f v){
		add(v.x, v.y);
	}

	public void sub(float x, float y){
		this.x -= x;
		this.y -= y;
	}

	public void sub(Vector2f v){
		sub(v.x, v.y);
	}

	public Vector2f sum(float x, float y){
		return new Vector2f(this.x+x, this.y+y);
	}

	public Vector2f sum(Vector2f v){
		return sum(v.x, v.y);
	}

	public Vector2f difference(float x, float y){
		return new Vector2f(this.x-x, this.y-y);
	}
	public Vector2f difference(Vector2f v){
		return difference(v.x, v.y);
	}
}
