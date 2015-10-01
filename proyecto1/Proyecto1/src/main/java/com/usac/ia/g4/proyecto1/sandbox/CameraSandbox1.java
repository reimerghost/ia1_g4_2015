package com.usac.ia.g4.proyecto1.sandbox;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import javax.swing.SwingUtilities;
import org.openimaj.feature.DoubleFVComparison;

import org.openimaj.image.*;
import org.openimaj.image.colour.ColourSpace;
import org.openimaj.image.connectedcomponent.GreyscaleConnectedComponentLabeler;
import org.openimaj.image.pixel.ConnectedComponent;
import org.openimaj.image.pixel.statistics.HistogramModel;
import org.openimaj.image.typography.hershey.HersheyFont;
import org.openimaj.math.statistics.distribution.MultidimensionalHistogram;
import org.openimaj.ml.clustering.FloatCentroidsResult;
import org.openimaj.ml.clustering.assignment.HardAssigner;
import org.openimaj.ml.clustering.kmeans.FloatKMeans;
import org.openimaj.video.*;
import org.openimaj.video.capture.VideoCapture;
import org.openimaj.video.xuggle.*;

/**
 * Record the webcam to a file.
 *
 * @author 
 */
public class CameraSandbox1 extends KeyAdapter implements VideoDisplayListener<MBFImage> {

    private Video<MBFImage> video;
    private VideoDisplay<MBFImage> display;
//    private final VideoDisplay<MBFImage> display;
    private XuggleVideoWriter writer;

    private boolean close = false, test = false, comparar = false, snapshot = false;

    /**
     * Default constructor
     *
     * @throws IOException
     */
    public CameraSandbox1() throws IOException {

        final JPanel videoPanel = new JPanel();
//        open webcam
        video = new VideoCapture(320, 240);
        //open display
        display = VideoDisplay.createVideoDisplay(video);
        //open a writer
        writer = new XuggleVideoWriter("video.flv", video.getWidth(), video.getHeight(), 30);
        //set this class to listen to video display events
        display.addVideoListener(this);

        //set this class to listen to keyboard events
        SwingUtilities.getRoot(display.getScreen()).addKeyListener(this);
    }

    @Override
    public void afterUpdate(VideoDisplay<MBFImage> display) {
        //Do nothing
    }

    @Override
    public void beforeUpdate(MBFImage frame) {
        //write a frame 
        if (!close) {
//            writer.addFrame(frame);
        }
        if (test) {
            DisplayUtilities.display(segmentarImagen(frame));
            test = false;
        }
        if (comparar) {
            try {
                System.out.println(compararImagenes(segmentarImagen(frame), "REIMER"));
            } catch (IOException ex) {
                Logger.getLogger(CameraSandbox1.class.getName()).log(Level.SEVERE, null, ex);
            }
            comparar = false;
        }
        if (snapshot) {
            Snapshot(segmentarImagen(frame), "REIMER");
            snapshot = false;
        }
    }

    public void Snapshot(MBFImage frame, String str) {
        try {
            File outfile = new File("/home/reimer/" + str + ".jpg");

            ImageUtilities.write(frame, outfile);
        } catch (final IOException ioe) {
            // display an error if the file couldn't be saved
            JOptionPane.showMessageDialog(null, "Unable to save file.");
        }
    }

    public double compararImagenes(MBFImage img, String str) throws MalformedURLException, IOException {

        File[] imagesFile = new File[]{
            new File("/home/reimer/" + str + ".jpg")
        };

        List<MultidimensionalHistogram> histograms;
        histograms = new ArrayList<MultidimensionalHistogram>();
        HistogramModel model = new HistogramModel(4, 4, 4);
        model.estimateModel(img);
        histograms.add(model.histogram.clone());
        for (File u : imagesFile) {
            model.estimateModel(ImageUtilities.readMBF(u));
            histograms.add(model.histogram.clone());
        }
        // Calculate the histogram

        Snapshot(img, "compara");

        double distanceScore = histograms.get(0).compare(histograms.get(1), DoubleFVComparison.EUCLIDEAN);
        return distanceScore;
    }

    /**
     *
     * @param input
     * @return
     */
    public MBFImage segmentarImagen(MBFImage input) {
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
            input.drawText("Point: " + (i++), comp.calculateCentroidPixel(), HersheyFont.TIMES_MEDIUM, 20);
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
        comparar = key.getKeyCode() == KeyEvent.VK_C;
        snapshot = key.getKeyCode() == KeyEvent.VK_S;
    }

    /**
     * Main method
     *
     * @param args ignored
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        CameraSandbox1 cameraSandbox1;
        cameraSandbox1 = new CameraSandbox1();
    }
}
