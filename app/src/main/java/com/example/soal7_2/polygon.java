package com.example.soal7_2;

import android.opengl.GLSurfaceView;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

class polygon implements GLSurfaceView.Renderer {
    private FloatBuffer polygon;

    @Override
    public void onSurfaceCreated(GL10 gl, EGLConfig config) {
        gl.glClearColor(0.0f, 0.0f, 1.0f, 0.0f);
        initShapes();
        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
    }

    @Override
    public void onDrawFrame(GL10 gl) {
        gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);
        gl.glColor4f(1.0f, 0.0f, 0.0f,0.0f);
        gl.glVertexPointer(3, GL10.GL_FLOAT, 0, polygon);
        gl.glDrawArrays(GL10.GL_TRIANGLE_STRIP, 0, 5);
    }

    @Override
    public void onSurfaceChanged(GL10 gl, int width, int height) {
        gl.glViewport(0, 0, width, height);
    }

    private void initShapes() {
        float vertices[] = {
                -0.35f, -0.4f, 0,
                0.35f, -0.4f, 0,
                -0.6f, 0.0f, 0,
                0.6f, 0.0f, 0,
                0.0f, 0.25f, 0
        };

        ByteBuffer vbb = ByteBuffer.allocateDirect(vertices.length * 4);
        vbb.order(ByteOrder.nativeOrder());

        polygon = vbb.asFloatBuffer();
        polygon.put(vertices);
        polygon.position(0);
    }
}