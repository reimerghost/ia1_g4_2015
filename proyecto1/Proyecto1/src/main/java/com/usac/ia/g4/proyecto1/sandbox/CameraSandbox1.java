package com.usac.ia.g4.proyecto1.sandbox;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.swing.SwingUtilities;

import org.openimaj.image.*;
import org.openimaj.image.colour.ColourSpace;
import org.openimaj.image.connectedcomponent.GreyscaleConnectedComponentLabeler;
import org.openimaj.image.pixel.ConnectedComponent;
import org.openimaj.image.typography.hershey.HersheyFont;
import org.openimaj.ml.clustering.FloatCentroidsResult;
import org.openimaj.ml.clustering.assignment.HardAssigner;
import org.openimaj.ml.clustering.kmeans.FloatKMeans;
import org.openimaj.video.*;
import org.openimaj.video.capture.VideoCapture;
import org.openimaj.video.xuggle.*;
import org.openimaj.video.capture.Device;

/**
 * Record the webcam to a file.
 *
 * @author Jonathon Hare (jsh2@ecs.soton.ac.uk)
 */
public class CameraSandbox1 extends KeyAdapter implements VideoDisplayListener<MBFImage> {

    private Video<MBFImage> video;
    private VideoDisplay<MBFImage> display;
    private XuggleVideoWriter writer;
    private boolean close = false, test = false;

    /**
     * Default constructor
     *
     * @throws IOException
     */
    public CameraSandbox1() throws IOException {
        //open webcam
        video = new VideoCapture(320, 240);
        //open display
        display = VideoDisplay.createVideoDisplay(video);
        //open a writer
        writer = new XuggleVideoWriter("video.flv", video.getWidth(), video.getHeight(), 30);
        //set this class to listen to video display events
        display.addVideoListener(this);

        //video.processInplace(new CannyEdgeDetector());
        //set this class to listen to keyboard events
        SwingUtilities.getRoot(display.getScreen()).addKeyListener(this);
    }

    public void afterUpdate(VideoDisplay<MBFImage> display) {
        //Do nothing
    }

    public void beforeUpdate(MBFImage frame) {
        //write a frame 
        if (!close) {
            writer.addFrame(segmentarImagen(frame));
        }
        if (test) {
            
            DisplayUtilities.display(frame);
            test = false;
        }
    }
    
    public float compararImagenes(){
        return 1f;
    }
    
    public MBFImage segmentarImagen(MBFImage input){
            input = ColourSpace.convert(input, ColourSpace.CIE_Lab);

            FloatKMeans cluster = FloatKMeans.createExact(2);
            float[][] imageData = input.getPixelVectorNative(new float[input.getWidth() * input.getHeight()][3]);
            FloatCentroidsResult result = cluster.cluster(imageData);
            float[][] centroids = result.centroids;
            for (float[] fs : centroids) {
                System.out.println(Arrays.toString(fs));
            }

            HardAssigner<float[], ?, ?> assigner = result.defaultHardAssigner();
            for (int y = 0; y < input.getHeight(); y++) {
                for (int x = 0; x < input.getWidth(); x++) {
                    float[] pixel = input.getPixelNative(x, y);
                    int centroid = assigner.assign(pixel);
                    input.setPixelNative(x, y, centroids[centroid]);
                }
            }

            GreyscaleConnectedComponentLabeler labeler = new GreyscaleConnectedComponentLabeler();
            List<ConnectedComponent> components = labeler.findComponents(input.flatten());

            int i = 0;
            for (ConnectedComponent comp : components) {
                if (comp.calculateArea() < 10000) {
                    continue;
                }
                input.drawText("Point:" + (i++), comp.calculateCentroidPixel(), HersheyFont.TIMES_MEDIUM, 20);
            }
            System.out.println("Points: " + i);

            input = ColourSpace.convert(input, ColourSpace.RGB);
            return input;
    }

    @Override
    public void keyPressed(KeyEvent key) {
        //wait for the escape key to be pressed
        close = key.getKeyCode() == KeyEvent.VK_ESCAPE;
        test = key.getKeyCode() == KeyEvent.VK_Z;
    }

    /**
     * Main method
     *
     * @param args ignored
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        new CameraSandbox1();
    }
}
